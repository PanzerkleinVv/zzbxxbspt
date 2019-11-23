package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.List;

public class PaperExtend extends Paper {

	private Exam exam;

	private List<PaperQuestionExtend> paperQuestion;
	
	public PaperExtend() {
		super();
	}
	
	public PaperExtend(Paper paper) {
		super();
		this.setPaperId(paper.getPaperId());
		this.setExamId(paper.getExamId());
		this.setUserId(paper.getUserId());
		this.setPaperBegin(paper.getPaperBegin());
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<PaperQuestionExtend> getPaperQuestion() {
		return paperQuestion;
	}

	public void setPaperQuestion(List<PaperQuestionExtend> paperQuestion) {
		this.paperQuestion = paperQuestion;
	}

}
