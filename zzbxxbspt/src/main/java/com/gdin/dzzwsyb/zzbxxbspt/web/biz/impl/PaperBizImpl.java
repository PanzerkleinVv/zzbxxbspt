package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.PaperBiz;
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
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
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
		return examService.getMyExamList(me);
	}

	@Override
	public void newPaper(Paper paper) {
		final Exam exam = examService.selectById(paper.getExamId());
		Random random = new Random();
		// 生成判断题
		if (exam.getExamTf() != 0) {
			QuestionExample example = new QuestionExample();
			example.createCriteria().andGroupIdEqualTo(exam.getGroupId()).andQuestionTypeEqualTo(0);
			example.setOrderByClause("question_id asc");
			final List<Question> tfs = questionService.selectByExample(example);
			for (int i = 0; i < exam.getExamTf(); i++) {
				int index = random.nextInt(tfs.size());
				PaperQuestion paperQuestion = new PaperQuestion();
				paperQuestion.setId(ApplicationUtils.randomUUID());
				paperQuestion.setPaperId(paper.getPaperId());
				paperQuestion.setQuestionId(tfs.get(index).getQuestionId());
				paperQuestion.setQuestionOrder(i);
				tfs.remove(index);
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
				int index = random.nextInt(scs.size());
				PaperQuestion paperQuestion = new PaperQuestion();
				paperQuestion.setId(ApplicationUtils.randomUUID());
				paperQuestion.setPaperId(paper.getPaperId());
				paperQuestion.setQuestionId(scs.get(index).getQuestionId());
				paperQuestion.setQuestionOrder(i + exam.getExamTf());
				scs.remove(index);
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
				int index = random.nextInt(mcs.size());
				PaperQuestion paperQuestion = new PaperQuestion();
				paperQuestion.setId(ApplicationUtils.randomUUID());
				paperQuestion.setPaperId(paper.getPaperId());
				paperQuestion.setQuestionId(mcs.get(index).getQuestionId());
				paperQuestion.setQuestionOrder(i + exam.getExamTf() + exam.getExamSc());
				mcs.remove(index);
				paperQuestionService.insert(paperQuestion);
			}
		}
		paper.setPaperBegin(new Date());
		paperService.insert(paper);
	}

	@Override
	public PaperExtend getPaper(String paperId) {
		final PaperExtend paper = new PaperExtend(paperService.selectById(paperId));
		paper.setExam(examService.selectById(paper.getExamId()));
		paper.setPaperQuestion(paperQuestionService.getPaperQestion(paperId));
		return paper;
	}

}
