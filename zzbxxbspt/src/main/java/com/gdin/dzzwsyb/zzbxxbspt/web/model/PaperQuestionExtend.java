package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.List;

public class PaperQuestionExtend extends PaperQuestion {

	private String questionContent;

	private Integer questionType;

	private List<Answer> answers;

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
