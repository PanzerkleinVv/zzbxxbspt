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
			for (Answer answer : question.getAnswers()) {
				answer.setAnswerId(ApplicationUtils.randomUUID());
				answer.setQuestionId(questionId);
				answerService.insert(answer);
			}
			logService.log(new Log(2, me.getUserId(), "新增问题：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
			return new Message(true, "保存成功");
		} else {
			final String questionId = question.getQuestionId();
			questionService.update(question);
			AnswerExample example = new AnswerExample();
			example.createCriteria().andQuestionIdEqualTo(questionId);
			answerService.deleteByExample(example);
			for (Answer answer : question.getAnswers()) {
				answer.setAnswerId(ApplicationUtils.randomUUID());
				answer.setQuestionId(questionId);
				answerService.insert(answer);
			}
			logService.log(new Log(2, me.getUserId(), "修改问题：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
			return new Message(true, "保存成功");
		}
	}

	@Override
	public QuestionExtend info(Question question) {
		final Question question0 = questionService.selectById(question.getQuestionId());
		final QuestionExtend questionExtend = new QuestionExtend(question0);
		AnswerExample example = new AnswerExample();
		example.createCriteria().andQuestionIdEqualTo(question.getQuestionId());
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
		logService.log(new Log(2, me.getUserId(), "删除问题：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
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
		for (String[] row : data) {
			QuestionExtend question = new QuestionExtend();
			String answerFlag = "";
			question.setAnswers(new ArrayList<Answer>());
			if (row[0] == null) {
				continue;
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
				default:
					continue;
				}
			}
			if (row[1] == null) {
				continue;
			} else {
				question.setQuestionContent(row[1]);
			}
			if (row[2] == null) {
				continue;
			} else {
				switch (question.getQuestionType()) {
				case 0:
					if (row[2].length() == 1) {
						answerFlag = row[2];
					} else {
						continue;
					}
					break;
				case 1:
					if (row[2].length() == 1) {
						answerFlag = row[2];
					} else {
						continue;
					}
					break;
				case 2:
					if (row[2].length() > 1) {
						answerFlag = row[2];
					} else {
						continue;
					}
					break;
				default:
					continue;
				}
			}
			if (row[3] == null) {
				continue;
			} else {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[3]);
				answer.setAnswerOrder(1);
				if (answerFlag.indexOf("A") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag.replace("A", "");
				}
				question.getAnswers().add(answer);
			}
			if (row[4] == null) {
				continue;
			} else {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[4]);
				answer.setAnswerOrder(2);
				if (answerFlag.indexOf("B") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag.replace("B", "");
				}
				question.getAnswers().add(answer);
			}
			if (5 < row.length && row[5] == null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[5]);
				answer.setAnswerOrder(3);
				if (answerFlag.indexOf("C") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag.replace("C", "");
				}
				question.getAnswers().add(answer);
			}
			if (6 < row.length && row[6] == null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[6]);
				answer.setAnswerOrder(4);
				if (answerFlag.indexOf("D") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag.replace("D", "");
				}
				question.getAnswers().add(answer);
			}
			if (7 < row.length && row[7] == null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[7]);
				answer.setAnswerOrder(5);
				if (answerFlag.indexOf("E") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag.replace("E", "");
				}
				question.getAnswers().add(answer);
			}
			if (8 < row.length && row[8] == null) {
				final Answer answer = new Answer();
				answer.setAnswerContent(row[8]);
				answer.setAnswerOrder(6);
				if (answerFlag.indexOf("F") == -1) {
					answer.setAnswerType(0);
				} else {
					answer.setAnswerType(1);
					answerFlag.replace("F", "");
				}
				question.getAnswers().add(answer);
			}
			if (answerFlag.length() != 0) {
				continue;
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
			for (Answer answer : question.getAnswers()) {
				answer.setAnswerId(ApplicationUtils.randomUUID());
				answer.setQuestionId(questionId);
				answerService.insert(answer);
			}
			logService.log(new Log(2, me.getUserId(), "新增问题：" + question.getQuestionContent() + "（" + question.getQuestionId() + "）"));
		}
		return new Message(true, "保存成功" + questions.size() + "个问题");
	}

}
