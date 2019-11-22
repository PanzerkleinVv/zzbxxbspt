package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ExamExtend extends Exam {

	private String paperId;

	private String userId;

	private BigDecimal paperScore;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date paperBegin;

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getPaperScore() {
		return paperScore;
	}

	public void setPaperScore(BigDecimal paperScore) {
		this.paperScore = paperScore;
	}

	public Date getPaperBegin() {
		return paperBegin;
	}

	public void setPaperBegin(Date paperBegin) {
		this.paperBegin = paperBegin;
	}

}
