package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.PaperBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Answer;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.AnswerExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestion;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Question;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionCount;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.AnswerService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.ExamService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PaperQuestionService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PaperService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.QuestionService;

@Service
public class PaperBizImpl implements PaperBiz {

	@Resource
	private PaperService paperService;

	@Resource
	private ExamService examService;

	@Resource
	private PaperQuestionService paperQuestionService;

	@Resource
	private LogService logService;

	@Resource
	private QuestionService questionService;

	@Resource
	private AnswerService answerService;

	@Override
	public List<Paper> selectByUserId(String userId) {
		PaperExample example = new PaperExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return paperService.selectByExample(example);
	}

	@Override
	public Message deleteByUserId(String userId, User me) {
		if (userId != null && !"".equals(userId)) {
			PaperExample example = new PaperExample();
			example.createCriteria().andUserIdEqualTo(userId);
			List<Paper> papers = paperService.selectByExample(example);
			int i = 0;
			int j = 0;
			if (papers != null) {
				for (Paper paper : papers) {
					PaperQuestionExample example0 = new PaperQuestionExample();
					example0.createCriteria().andPaperIdEqualTo(paper.getPaperId());
					j += paperQuestionService.deleteByExample(example0);
				}
				i = paperService.deleteByExample(example);
			}
			logService.log(new Log(2, me.getUserId(), "删除用户（" + userId + "）试卷" + i + "份、答案" + j + "行"));
			return new Message(true, "删除试卷" + i + "份、答案" + j + "行");
		} else {
			return new Message(false, "无效用户Id");
		}
	}

	@Override
	public Message deleteByExamId(String examId, User me) {
		if (examId != null && !"".equals(examId)) {
			PaperExample example = new PaperExample();
			example.createCriteria().andExamIdEqualTo(examId);
			List<Paper> papers = paperService.selectByExample(example);
			int i = 0;
			int j = 0;
			if (papers != null) {
				for (Paper paper : papers) {
					PaperQuestionExample example0 = new PaperQuestionExample();
					example0.createCriteria().andPaperIdEqualTo(paper.getPaperId());
					j += paperQuestionService.deleteByExample(example0);
				}
				i = paperService.deleteByExample(example);
			}
			logService.log(new Log(2, me.getUserId(), "删除考试（" + examId + "）试卷" + i + "份、答案" + j + "行"));
			return new Message(true, "删除试卷" + i + "份、答案" + j + "行");
		} else {
			return new Message(false, "无效考试Id");
		}
	}

	@Override
	public List<ExamExtend> getMyExamList(User me) {
		final List<ExamExtend> exams = examService.getMyExamList(me);
		for (ExamExtend exam : exams) {
			if ((exam.getExamTime() != null && exam.getPaperId() != null
					&& exam.getPaperBegin().getTime() + exam.getExamTime() * 60000 < System.currentTimeMillis())
					|| exam.getPaperId() != null && exam.getExamEnd().getTime() < System.currentTimeMillis()) {
				scoring(exam.getPaperId());
			}
		}
		return examService.getMyExamList(me);
	}

	@Override
	public void newPaper(Paper paper, User me) {
		final Exam exam = examService.selectById(paper.getExamId());
		final int allCount = exam.getExamTf() + exam.getExamSc() + exam.getExamMc() + exam.getExamIc();
		final List<QuestionCount> questionCount = questionService.count(exam.getGroupId());
		final int subject = questionCount.size();
		final Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (int i = 0; i < subject; i++) {
			countMap.put(questionCount.get(i).getQuestionSubject(),
					allCount / subject + (allCount % subject == 0 ? 0 : 1));
		}
		Random random = new Random();
		// 生成判断题
		if (exam.getExamTf() != 0) {
			QuestionExample example = new QuestionExample();
			example.createCriteria().andGroupIdEqualTo(exam.getGroupId()).andQuestionTypeEqualTo(0);
			example.setOrderByClause("question_id asc");
			final List<Question> tfs = questionService.selectByExample(example);
			for (int i = 0; i < exam.getExamTf(); i++) {
				Question question = null;
				do {
					int index = random.nextInt(tfs.size());
					question = tfs.get(index);
					tfs.remove(index);
				} while (countMap.get(question.getQuestionSubject()) == 0);
				countMap.put(question.getQuestionSubject(), countMap.get(question.getQuestionSubject()) - 1);
				PaperQuestion paperQuestion = new PaperQuestion();
				paperQuestion.setId(ApplicationUtils.randomUUID());
				paperQuestion.setPaperId(paper.getPaperId());
				paperQuestion.setQuestionId(question.getQuestionId());
				paperQuestion.setQuestionOrder(i);
				paperQuestionService.insert(paperQuestion);
			}
		}
		// 生成单选题
		if (exam.getExamSc() != 0) {
			QuestionExample example = new QuestionExample();
			example.createCriteria().andGroupIdEqualTo(exam.getGroupId()).andQuestionTypeEqualTo(1);
			example.setOrderByClause("question_id asc");
			final List<Question> scs = questionService.selectByExample(example);
			for (int i = 0; i < exam.getExamSc(); i++) {
				Question question = null;
				do {
					int index = random.nextInt(scs.size());
					question = scs.get(index);
					scs.remove(index);
				} while (countMap.get(question.getQuestionSubject()) == 0);
				countMap.put(question.getQuestionSubject(), countMap.get(question.getQuestionSubject()) - 1);
				PaperQuestion paperQuestion = new PaperQuestion();
				paperQuestion.setId(ApplicationUtils.randomUUID());
				paperQuestion.setPaperId(paper.getPaperId());
				paperQuestion.setQuestionId(question.getQuestionId());
				paperQuestion.setQuestionOrder(i + exam.getExamTf());
				paperQuestionService.insert(paperQuestion);
			}
		}
		// 生成多选题
		if (exam.getExamMc() != 0) {
			QuestionExample example = new QuestionExample();
			example.createCriteria().andGroupIdEqualTo(exam.getGroupId()).andQuestionTypeEqualTo(2);
			example.setOrderByClause("question_id asc");
			final List<Question> mcs = questionService.selectByExample(example);
			for (int i = 0; i < exam.getExamMc(); i++) {
				Question question = null;
				do {
					int index = random.nextInt(mcs.size());
					question = mcs.get(index);
					mcs.remove(index);
				} while (countMap.get(question.getQuestionSubject()) == 0);
				countMap.put(question.getQuestionSubject(), countMap.get(question.getQuestionSubject()) - 1);
				PaperQuestion paperQuestion = new PaperQuestion();
				paperQuestion.setId(ApplicationUtils.randomUUID());
				paperQuestion.setPaperId(paper.getPaperId());
				paperQuestion.setQuestionId(question.getQuestionId());
				paperQuestion.setQuestionOrder(i + exam.getExamTf() + exam.getExamSc());
				paperQuestionService.insert(paperQuestion);
			}
		}
		// 生成不定项选择题
		if (exam.getExamIc() != 0) {
			QuestionExample example = new QuestionExample();
			example.createCriteria().andGroupIdEqualTo(exam.getGroupId()).andQuestionTypeEqualTo(3);
			example.setOrderByClause("question_id asc");
			final List<Question> ics = questionService.selectByExample(example);
			for (int i = 0; i < exam.getExamIc(); i++) {
				Question question = null;
				do {
					int index = random.nextInt(ics.size());
					question = ics.get(index);
					ics.remove(index);
				} while (countMap.get(question.getQuestionSubject()) == 0);
				countMap.put(question.getQuestionSubject(), countMap.get(question.getQuestionSubject()) - 1);
				PaperQuestion paperQuestion = new PaperQuestion();
				paperQuestion.setId(ApplicationUtils.randomUUID());
				paperQuestion.setPaperId(paper.getPaperId());
				paperQuestion.setQuestionId(question.getQuestionId());
				paperQuestion.setQuestionOrder(i + exam.getExamTf() + exam.getExamSc() + exam.getExamMc());
				paperQuestionService.insert(paperQuestion);
			}
		}
		paper.setPaperBegin(new Date());
		logService.log(new Log(2, me.getUserId(), "生成试卷：" + paper.getPaperId() + "，开始答题"));
		paperService.insert(paper);
	}

	@Override
	public PaperExtend getPaper(String paperId) {
		final PaperExtend paper = new PaperExtend(paperService.selectById(paperId));
		paper.setExam(examService.selectById(paper.getExamId()));
		paper.setPaperQuestion(paperQuestionService.getPaperQestion(paperId));
		return paper;
	}

	@Override
	public BigDecimal scoring(String paperId) {
		final PaperExtend paper = new PaperExtend(paperService.selectById(paperId));
		paper.setExam(examService.selectById(paper.getExamId()));
		paper.setPaperQuestion(paperQuestionService.getPaperQestion(paperId));
		BigDecimal score = new BigDecimal(0);
		if (paper.getExam().getExamTf() != 0) {
			for (int i = 0; i < paper.getExam().getExamTf(); i++) {
				final String answerId = paper.getPaperQuestion().get(i).getAnswer();
				final Answer answer = answerService.selectById(answerId);
				if (answer != null && answer.getAnswerType() == 1) {
					score = score.add(paper.getExam().getExamTfScore());
				}
			}
		}
		if (paper.getExam().getExamSc() != 0) {
			for (int i = paper.getExam().getExamTf(); i < paper.getExam().getExamTf()
					+ paper.getExam().getExamSc(); i++) {
				final String answerId = paper.getPaperQuestion().get(i).getAnswer();
				final Answer answer = answerService.selectById(answerId);
				if (answer != null && answer.getAnswerType() == 1) {
					score = score.add(paper.getExam().getExamScScore());
				}
			}
		}
		if (paper.getExam().getExamMc() != 0) {
			for (int i = paper.getExam().getExamTf() + paper.getExam().getExamSc(); i < paper.getExam().getExamTf()
					+ paper.getExam().getExamSc() + paper.getExam().getExamMc(); i++) {
				final String questionId = paper.getPaperQuestion().get(i).getQuestionId();
				final String answerIds = paper.getPaperQuestion().get(i).getAnswer();
				AnswerExample example = new AnswerExample();
				example.createCriteria().andQuestionIdEqualTo(questionId).andAnswerTypeEqualTo(1);
				example.setOrderByClause("answer_order asc");
				final List<Answer> answers = answerService.selectByExample(example);
				String correctAnswer = "";
				for (Answer answer : answers) {
					correctAnswer += (answer.getAnswerId() + ",");
				}
				correctAnswer = correctAnswer.substring(0, correctAnswer.length() - 1);
				if (correctAnswer.equals(answerIds)) {
					score = score.add(paper.getExam().getExamMcScore());
				}
			}
		}
		if (paper.getExam().getExamIc() != 0) {
			for (int i = paper.getExam().getExamTf() + paper.getExam().getExamSc() + paper.getExam().getExamMc(); i < paper.getExam().getExamTf()
					+ paper.getExam().getExamSc() + paper.getExam().getExamMc() + paper.getExam().getExamIc(); i++) {
				final String questionId = paper.getPaperQuestion().get(i).getQuestionId();
				final String answerIds = paper.getPaperQuestion().get(i).getAnswer();
				AnswerExample example = new AnswerExample();
				example.createCriteria().andQuestionIdEqualTo(questionId).andAnswerTypeEqualTo(1);
				example.setOrderByClause("answer_order asc");
				final List<Answer> answers = answerService.selectByExample(example);
				String correctAnswer = "";
				for (Answer answer : answers) {
					correctAnswer += (answer.getAnswerId() + ",");
				}
				correctAnswer = correctAnswer.substring(0, correctAnswer.length() - 1);
				if (correctAnswer.equals(answerIds)) {
					score = score.add(paper.getExam().getExamMcScore());
				}
			}
		}
		final Paper paper0 = new Paper();
		paper0.setPaperId(paperId);
		paper0.setPaperScore(score);
		paperService.update(paper0);
		return score;
	}

	@Override
	public Message submit(List<PaperQuestion> paperQuestions) {
		for (PaperQuestion paperQuestion : paperQuestions) {
			if (paperQuestion.getAnswer() != null) {
				paperQuestionService.update(paperQuestion);
			}
		}
		final PaperQuestion paperQuestion = paperQuestionService.selectById(paperQuestions.get(0).getId());
		BigDecimal score = scoring(paperQuestion.getPaperId());
		return new Message(true, "得分：" + score.toPlainString());
	}

}
