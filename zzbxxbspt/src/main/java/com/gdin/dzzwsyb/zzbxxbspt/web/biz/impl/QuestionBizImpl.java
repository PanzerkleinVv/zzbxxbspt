package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.QuestionBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Answer;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.AnswerExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Question;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionCount;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.AnswerService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.ExcelService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.FileService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.QuestionService;

@Service
public class QuestionBizImpl implements QuestionBiz {

	@Resource
	private QuestionService questionService;
	
	@Resource
	private AnswerService answerService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private ExcelService excelService;

	@Resource
	private FileService fileService;

	@Override
	public List<Question> selectByGroupId(String groupId) {
		QuestionExample example = new QuestionExample();
		example.createCriteria().andGroupIdEqualTo(groupId);
		return questionService.selectByExample(example);
	}

	@Override
	public Message deleteByGroupId(String groupId, User me) {
		if (groupId != null && !"".equals(groupId)) {
			QuestionExample example = new QuestionExample();
			example.createCriteria().andGroupIdEqualTo(groupId);
			List<Question> questions = questionService.selectByExample(example);
			int i = 0;
			int j = 0;
			if (questions != null) {
				for (Question question : questions) {
					AnswerExample example0 = new AnswerExample();
					example0.createCriteria().andQuestionIdEqualTo(question.getQuestionId());
					j += answerService.deleteByExample(example0);
				}
				i = questionService.deleteByExample(example);
			}
			logService.log(new Log(2, me.getUserId(), "删除课题组（" + groupId + "）题目" + i + "个、答案" + j + "个"));
			return new Message(true, "删除题目" + i + "个、答案" + j + "个");
		} else {
			return new Message(false, "无效课题组Id");
		}
	}

	@Override
	public Page<Question> search(Question question, int pageNo) {
		return questionService.search(question, pageNo);
	}

	@Override
	public Message edit(QuestionExtend question, User me) {
		if (question.getQuestionId() == null || "".equals(question.getQuestionId())) {
			final String questionId = ApplicationUtils.randomUUID();
			question.setQuestionId(questionId);
			question.setGroupId(me.getUserGroup());
			questionService.insert(question);
			int i = 1;
			for (Answer answer : question.getAnswers()) {
				if (answer != null && answer.getAnswerContent() != null && !"".equals(answer.getAnswerContent())) {
					answer.setAnswerId(ApplicationUtils.randomUUID());
					answer.setQuestionId(questionId);
					answer.setAnswerOrder(i);
					i++;
					answerService.insert(answer);
				}
			}
			logService.log(new Log(2, me.getUserId(), "新增题目：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
			return new Message(true, "保存成功");
		} else {
			final String questionId = question.getQuestionId();
			questionService.update(question);
			AnswerExample example = new AnswerExample();
			example.createCriteria().andQuestionIdEqualTo(questionId);
			answerService.deleteByExample(example);
			int i = 1;
			for (Answer answer : question.getAnswers()) {
				if (answer != null && answer.getAnswerContent() != null && !"".equals(answer.getAnswerContent())) {
					answer.setAnswerId(ApplicationUtils.randomUUID());
					answer.setQuestionId(questionId);
					answer.setAnswerOrder(i);
					i++;
					answerService.insert(answer);
				}
			}
			logService.log(new Log(2, me.getUserId(), "修改题目：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
			return new Message(true, "保存成功");
		}
	}

	@Override
	public QuestionExtend info(Question question) {
		final Question question0 = questionService.selectById(question.getQuestionId());
		final QuestionExtend questionExtend = new QuestionExtend(question0);
		AnswerExample example = new AnswerExample();
		example.createCriteria().andQuestionIdEqualTo(question.getQuestionId());
		example.setOrderByClause("answer_order asc");
		questionExtend.setAnswers(answerService.selectByExample(example));
		return questionExtend;
	}

	@Override
	public Message delete(Question question, User me) {
		final String questionId = question.getQuestionId();
		questionService.delete(questionId);
		AnswerExample example = new AnswerExample();
		example.createCriteria().andQuestionIdEqualTo(questionId);
		answerService.deleteByExample(example);
		logService.log(new Log(2, me.getUserId(), "删除题目：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
		return new Message(true, "删除成功");
	}

	@Override
	public File template(String filename) {
		return fileService.template(filename);
	}

	@Override
	public Message input(InputStream inputStream, String groupId) throws IOException {
		String[][] data = excelService.getData(inputStream);
		List<QuestionExtend> questions = new ArrayList<QuestionExtend>();
		for (int i = 0; i < data.length; i++) {
			String[] row = data[i];
			QuestionExtend question = new QuestionExtend();
			String answerFlag = "";
			question.setAnswers(new ArrayList<Answer>());
			if (row[0] == null) {
				return new Message(false, "Excel解析出错：第" + (i + 1) + "题目类型不能为空");
			} else {
				switch (row[0]) {
				case "判断题":
					question.setQuestionType(0);
					break;
				case "单选题":
					question.setQuestionType(1);
					break;
				case "多选题":
					question.setQuestionType(2);
					break;
				case "不定项选择题":
					question.setQuestionType(3);
					break;
				default:
					return new Message(false, "Excel解析出错：第" + (i + 1) + "题目类型只能为“判断题”、“单选题”、“多选题”、“不定项选择题”");
				}
			}
			if (row[1] == null) {
				return new Message(false, "Excel解析出错：第" + (i + 1) + "题目分类不能为空");
			} else {
				question.setQuestionSubject(row[1]);
			}
			if (row[2] == null) {
				return new Message(false, "Excel解析出错：第" + (i + 1) + "题目内容不能为空");
			} else {
				question.setQuestionContent(row[2]);
			}
			if (row[3] == null) {
				return new Message(false, "Excel解析出错：第" + (i + 1) + "正确答案选项不能为空");
			} else {
				switch (question.getQuestionType()) {
				case 0:
					if (row[3].length() == 1) {
						answerFlag = row[3].toUpperCase();
					} else {
						return new Message(false, "Excel解析出错：第" + (i + 1) + "判断题只能有一个正确答案");
					}
					break;
				case 1:
					if (row[3].length() == 1) {
						answerFlag = row[3].toUpperCase();
					} else {
						return new Message(false, "Excel解析出错：第" + (i + 1) + "单选题只能有一个正确答案");
					}
					break;
				case 2:
					if (row[3].length() > 1) {
						answerFlag = row[3].toUpperCase();
					} else {
						return new Message(false, "Excel解析出错：第" + (i + 1) + "多选题至少有两个正确答案");
					}
					break;
				case 3:
					if (row[3].length() > 0) {
						answerFlag = row[3].toUpperCase();
					} else {
						return new Message(false, "Excel解析出错：第" + (i + 1) + "不定项选择题至少有一个正确答案");
					}
					break;
				default:
					return new Message(false, "Excel解析出错：第" + (i + 1) + "题目类型不能为空*");
				}
			}
			if (row[4] == null) {
				return new Message(false, "Excel解析出错：第" + (i + 1) + "选项A不能为空");
			} else {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[4]);
				answer.setAnswerOrder(1);
				if (answerFlag.indexOf("A") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag = answerFlag.replace("A", "");
				}
				question.getAnswers().add(answer);
			}
			if (row[5] == null) {
				return new Message(false, "Excel解析出错：第" + (i + 1) + "选项B不能为空");
			} else {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[5]);
				answer.setAnswerOrder(2);
				if (answerFlag.indexOf("B") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag = answerFlag.replace("B", "");
				}
				question.getAnswers().add(answer);
			}
			if (6 < row.length && row[6] != null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[6]);
				answer.setAnswerOrder(3);
				if (answerFlag.indexOf("C") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag = answerFlag.replace("C", "");
				}
				question.getAnswers().add(answer);
			}
			if (7 < row.length && row[7] != null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[7]);
				answer.setAnswerOrder(4);
				if (answerFlag.indexOf("D") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag = answerFlag.replace("D", "");
				}
				question.getAnswers().add(answer);
			}
			if (8 < row.length && row[8] != null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[8]);
				answer.setAnswerOrder(5);
				if (answerFlag.indexOf("E") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag = answerFlag.replace("E", "");
				}
				question.getAnswers().add(answer);
			}
			if (9 < row.length && row[9] != null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[9]);
				answer.setAnswerOrder(6);
				if (answerFlag.indexOf("F") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag = answerFlag.replace("F", "");
				}
				question.getAnswers().add(answer);
			}
			if (answerFlag.length() != 0) {
				return new Message(false, "Excel解析出错：第" + (i + 1) + "正确答案序号与答案不匹配");
			}
			questions.add(question);
		}
		return new Message(true, "Excel解析成功", questions);
	}

	@Override
	public Message saveAll(List<QuestionExtend> questions, User me) {
		for (QuestionExtend question : questions) {
			final String questionId = ApplicationUtils.randomUUID();
			question.setQuestionId(questionId);
			question.setGroupId(me.getUserGroup());
			questionService.insert(question);
			int i = 1;
			for (Answer answer : question.getAnswers()) {
				if (answer != null && answer.getAnswerContent() != null && !"".equals(answer.getAnswerContent())) {
					answer.setAnswerId(ApplicationUtils.randomUUID());
					answer.setQuestionId(questionId);
					answer.setAnswerOrder(i);
					i++;
					answerService.insert(answer);
				}
			}
			logService.log(new Log(2, me.getUserId(), "新增题目：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
		}
		return new Message(true, "保存成功" + questions.size() + "个题目");
	}

	@Override
	public List<QuestionCount> getCount(String groupId) {
		List<QuestionCount> counts = questionService.count(groupId);
		QuestionCount countAll = new QuestionCount();
		countAll.setQuestionSubject("合计");
		countAll.setTf(0);
		countAll.setSc(0);
		countAll.setMc(0);
		countAll.setIc(0);
		for (QuestionCount count : counts) {
			countAll.setTf(count.getTf() + countAll.getTf());
			countAll.setSc(count.getSc() + countAll.getSc());
			countAll.setMc(count.getMc() + countAll.getMc());
			countAll.setIc(count.getIc() + countAll.getIc());
		}
		counts.add(0, countAll);
		return counts;
	}

}
