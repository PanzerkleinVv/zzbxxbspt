package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("PAPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("PAPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(String value) {
            addCriterion("PAPER_ID =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(String value) {
            addCriterion("PAPER_ID <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(String value) {
            addCriterion("PAPER_ID >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_ID >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(String value) {
            addCriterion("PAPER_ID <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(String value) {
            addCriterion("PAPER_ID <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLike(String value) {
            addCriterion("PAPER_ID like", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotLike(String value) {
            addCriterion("PAPER_ID not like", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<String> values) {
            addCriterion("PAPER_ID in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<String> values) {
            addCriterion("PAPER_ID not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(String value1, String value2) {
            addCriterion("PAPER_ID between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(String value1, String value2) {
            addCriterion("PAPER_ID not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andExamIdIsNull() {
            addCriterion("EXAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andExamIdIsNotNull() {
            addCriterion("EXAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExamIdEqualTo(String value) {
            addCriterion("EXAM_ID =", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotEqualTo(String value) {
            addCriterion("EXAM_ID <>", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThan(String value) {
            addCriterion("EXAM_ID >", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXAM_ID >=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThan(String value) {
            addCriterion("EXAM_ID <", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThanOrEqualTo(String value) {
            addCriterion("EXAM_ID <=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLike(String value) {
            addCriterion("EXAM_ID like", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotLike(String value) {
            addCriterion("EXAM_ID not like", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdIn(List<String> values) {
            addCriterion("EXAM_ID in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotIn(List<String> values) {
            addCriterion("EXAM_ID not in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdBetween(String value1, String value2) {
            addCriterion("EXAM_ID between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotBetween(String value1, String value2) {
            addCriterion("EXAM_ID not between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIsNull() {
            addCriterion("PAPER_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIsNotNull() {
            addCriterion("PAPER_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andPaperScoreEqualTo(BigDecimal value) {
            addCriterion("PAPER_SCORE =", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotEqualTo(BigDecimal value) {
            addCriterion("PAPER_SCORE <>", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreGreaterThan(BigDecimal value) {
            addCriterion("PAPER_SCORE >", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAPER_SCORE >=", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreLessThan(BigDecimal value) {
            addCriterion("PAPER_SCORE <", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAPER_SCORE <=", value, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreIn(List<BigDecimal> values) {
            addCriterion("PAPER_SCORE in", values, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotIn(List<BigDecimal> values) {
            addCriterion("PAPER_SCORE not in", values, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAPER_SCORE between", value1, value2, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAPER_SCORE not between", value1, value2, "paperScore");
            return (Criteria) this;
        }

        public Criteria andPaperBeginIsNull() {
            addCriterion("PAPER_BEGIN is null");
            return (Criteria) this;
        }

        public Criteria andPaperBeginIsNotNull() {
            addCriterion("PAPER_BEGIN is not null");
            return (Criteria) this;
        }

        public Criteria andPaperBeginEqualTo(Date value) {
            addCriterion("PAPER_BEGIN =", value, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginNotEqualTo(Date value) {
            addCriterion("PAPER_BEGIN <>", value, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginGreaterThan(Date value) {
            addCriterion("PAPER_BEGIN >", value, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("PAPER_BEGIN >=", value, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginLessThan(Date value) {
            addCriterion("PAPER_BEGIN <", value, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginLessThanOrEqualTo(Date value) {
            addCriterion("PAPER_BEGIN <=", value, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginIn(List<Date> values) {
            addCriterion("PAPER_BEGIN in", values, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginNotIn(List<Date> values) {
            addCriterion("PAPER_BEGIN not in", values, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginBetween(Date value1, Date value2) {
            addCriterion("PAPER_BEGIN between", value1, value2, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperBeginNotBetween(Date value1, Date value2) {
            addCriterion("PAPER_BEGIN not between", value1, value2, "paperBegin");
            return (Criteria) this;
        }

        public Criteria andPaperEndIsNull() {
            addCriterion("PAPER_END is null");
            return (Criteria) this;
        }

        public Criteria andPaperEndIsNotNull() {
            addCriterion("PAPER_END is not null");
            return (Criteria) this;
        }

        public Criteria andPaperEndEqualTo(Date value) {
            addCriterion("PAPER_END =", value, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndNotEqualTo(Date value) {
            addCriterion("PAPER_END <>", value, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndGreaterThan(Date value) {
            addCriterion("PAPER_END >", value, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndGreaterThanOrEqualTo(Date value) {
            addCriterion("PAPER_END >=", value, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndLessThan(Date value) {
            addCriterion("PAPER_END <", value, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndLessThanOrEqualTo(Date value) {
            addCriterion("PAPER_END <=", value, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndIn(List<Date> values) {
            addCriterion("PAPER_END in", values, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndNotIn(List<Date> values) {
            addCriterion("PAPER_END not in", values, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndBetween(Date value1, Date value2) {
            addCriterion("PAPER_END between", value1, value2, "paperEnd");
            return (Criteria) this;
        }

        public Criteria andPaperEndNotBetween(Date value1, Date value2) {
            addCriterion("PAPER_END not between", value1, value2, "paperEnd");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}