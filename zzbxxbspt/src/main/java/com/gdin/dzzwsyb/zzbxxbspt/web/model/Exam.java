package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Exam {
    private String examId;

    private String groupId;

    private String examTitle;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date examBegin;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date examEnd;

    private Integer examTime;

    private Integer examScore;

    private Integer examSc;

    private BigDecimal examScScore;

    private Integer examTf;

    private BigDecimal examTfScore;

    private Integer examMc;

    private BigDecimal examMcScore;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle == null ? null : examTitle.trim();
    }

    public Date getExamBegin() {
        return examBegin;
    }

    public void setExamBegin(Date examBegin) {
        this.examBegin = examBegin;
    }

    public Date getExamEnd() {
        return examEnd;
    }

    public void setExamEnd(Date examEnd) {
        this.examEnd = examEnd;
    }

    public Integer getExamTime() {
        return examTime;
    }

    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    public Integer getExamScore() {
        return examScore;
    }

    public void setExamScore(Integer examScore) {
        this.examScore = examScore;
    }

    public Integer getExamSc() {
        return examSc;
    }

    public void setExamSc(Integer examSc) {
        this.examSc = examSc;
    }

    public BigDecimal getExamScScore() {
        return examScScore;
    }

    public void setExamScScore(BigDecimal examScScore) {
        this.examScScore = examScScore;
    }

    public Integer getExamTf() {
        return examTf;
    }

    public void setExamTf(Integer examTf) {
        this.examTf = examTf;
    }

    public BigDecimal getExamTfScore() {
        return examTfScore;
    }

    public void setExamTfScore(BigDecimal examTfScore) {
        this.examTfScore = examTfScore;
    }

    public Integer getExamMc() {
        return examMc;
    }

    public void setExamMc(Integer examMc) {
        this.examMc = examMc;
    }

    public BigDecimal getExamMcScore() {
        return examMcScore;
    }

    public void setExamMcScore(BigDecimal examMcScore) {
        this.examMcScore = examMcScore;
    }
}