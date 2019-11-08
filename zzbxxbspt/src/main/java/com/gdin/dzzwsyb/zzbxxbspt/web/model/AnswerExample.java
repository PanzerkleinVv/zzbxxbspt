package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswerExample() {
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("ANSWER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("ANSWER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(String value) {
            addCriterion("ANSWER_ID =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(String value) {
            addCriterion("ANSWER_ID <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(String value) {
            addCriterion("ANSWER_ID >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_ID >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(String value) {
            addCriterion("ANSWER_ID <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_ID <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLike(String value) {
            addCriterion("ANSWER_ID like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotLike(String value) {
            addCriterion("ANSWER_ID not like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<String> values) {
            addCriterion("ANSWER_ID in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<String> values) {
            addCriterion("ANSWER_ID not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(String value1, String value2) {
            addCriterion("ANSWER_ID between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(String value1, String value2) {
            addCriterion("ANSWER_ID not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("QUESTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("QUESTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(String value) {
            addCriterion("QUESTION_ID =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(String value) {
            addCriterion("QUESTION_ID <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(String value) {
            addCriterion("QUESTION_ID >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_ID >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(String value) {
            addCriterion("QUESTION_ID <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_ID <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLike(String value) {
            addCriterion("QUESTION_ID like", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotLike(String value) {
            addCriterion("QUESTION_ID not like", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<String> values) {
            addCriterion("QUESTION_ID in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<String> values) {
            addCriterion("QUESTION_ID not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(String value1, String value2) {
            addCriterion("QUESTION_ID between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(String value1, String value2) {
            addCriterion("QUESTION_ID not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIsNull() {
            addCriterion("ANSWER_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIsNotNull() {
            addCriterion("ANSWER_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentEqualTo(String value) {
            addCriterion("ANSWER_CONTENT =", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotEqualTo(String value) {
            addCriterion("ANSWER_CONTENT <>", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThan(String value) {
            addCriterion("ANSWER_CONTENT >", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_CONTENT >=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThan(String value) {
            addCriterion("ANSWER_CONTENT <", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_CONTENT <=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLike(String value) {
            addCriterion("ANSWER_CONTENT like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotLike(String value) {
            addCriterion("ANSWER_CONTENT not like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIn(List<String> values) {
            addCriterion("ANSWER_CONTENT in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotIn(List<String> values) {
            addCriterion("ANSWER_CONTENT not in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentBetween(String value1, String value2) {
            addCriterion("ANSWER_CONTENT between", value1, value2, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotBetween(String value1, String value2) {
            addCriterion("ANSWER_CONTENT not between", value1, value2, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIsNull() {
            addCriterion("ANSWER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIsNotNull() {
            addCriterion("ANSWER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE =", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE <>", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeGreaterThan(Integer value) {
            addCriterion("ANSWER_TYPE >", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE >=", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeLessThan(Integer value) {
            addCriterion("ANSWER_TYPE <", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE <=", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIn(List<Integer> values) {
            addCriterion("ANSWER_TYPE in", values, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotIn(List<Integer> values) {
            addCriterion("ANSWER_TYPE not in", values, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_TYPE between", value1, value2, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_TYPE not between", value1, value2, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderIsNull() {
            addCriterion("ANSWER_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderIsNotNull() {
            addCriterion("ANSWER_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderEqualTo(Integer value) {
            addCriterion("ANSWER_ORDER =", value, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderNotEqualTo(Integer value) {
            addCriterion("ANSWER_ORDER <>", value, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderGreaterThan(Integer value) {
            addCriterion("ANSWER_ORDER >", value, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_ORDER >=", value, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderLessThan(Integer value) {
            addCriterion("ANSWER_ORDER <", value, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderLessThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_ORDER <=", value, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderIn(List<Integer> values) {
            addCriterion("ANSWER_ORDER in", values, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderNotIn(List<Integer> values) {
            addCriterion("ANSWER_ORDER not in", values, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_ORDER between", value1, value2, "answerOrder");
            return (Criteria) this;
        }

        public Criteria andAnswerOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_ORDER not between", value1, value2, "answerOrder");
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