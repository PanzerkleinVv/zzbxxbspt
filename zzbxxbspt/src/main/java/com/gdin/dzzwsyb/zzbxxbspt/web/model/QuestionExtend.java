package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.List;

public class QuestionExtend extends Question {

	private List<Answer> answers;
	
	public QuestionExtend() {
		super();
	}
	
	public QuestionExtend(Question question) {
		super();
		this.setQuestionId(question.getQuestionId());
		this.setGroupId(question.getGroupId());
		this.setQuestionType(question.getQuestionType());
		this.setQuestionSubject(question.getQuestionSubject());
		this.setQuestionContent(question.getQuestionContent());
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
