package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Paper {
    private String paperId;

    private String examId;

    private String userId;

    private BigDecimal paperScore;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date paperBegin;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date paperEnd;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Date getPaperEnd() {
        return paperEnd;
    }

    public void setPaperEnd(Date paperEnd) {
        this.paperEnd = paperEnd;
    }
}