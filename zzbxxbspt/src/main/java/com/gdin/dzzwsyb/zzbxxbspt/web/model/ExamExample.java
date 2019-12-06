package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamExample() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("GROUP_ID like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("GROUP_ID not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

		public Criteria andGroupUsed() {
			addCriterion("GROUP_ID in (select GROUP_ID from `GROUP` where GROUP_STATUS = 1)");
			return (Criteria) this;
		}

		public Criteria andExamTitleIsNull() {
			addCriterion("EXAM_TITLE is null");
			return (Criteria) this;
		}

        public Criteria andExamTitleIsNotNull() {
            addCriterion("EXAM_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andExamTitleEqualTo(String value) {
            addCriterion("EXAM_TITLE =", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleNotEqualTo(String value) {
            addCriterion("EXAM_TITLE <>", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleGreaterThan(String value) {
            addCriterion("EXAM_TITLE >", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleGreaterThanOrEqualTo(String value) {
            addCriterion("EXAM_TITLE >=", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleLessThan(String value) {
            addCriterion("EXAM_TITLE <", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleLessThanOrEqualTo(String value) {
            addCriterion("EXAM_TITLE <=", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleLike(String value) {
            addCriterion("EXAM_TITLE like", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleNotLike(String value) {
            addCriterion("EXAM_TITLE not like", value, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleIn(List<String> values) {
            addCriterion("EXAM_TITLE in", values, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleNotIn(List<String> values) {
            addCriterion("EXAM_TITLE not in", values, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleBetween(String value1, String value2) {
            addCriterion("EXAM_TITLE between", value1, value2, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamTitleNotBetween(String value1, String value2) {
            addCriterion("EXAM_TITLE not between", value1, value2, "examTitle");
            return (Criteria) this;
        }

        public Criteria andExamBeginIsNull() {
            addCriterion("EXAM_BEGIN is null");
            return (Criteria) this;
        }

        public Criteria andExamBeginIsNotNull() {
            addCriterion("EXAM_BEGIN is not null");
            return (Criteria) this;
        }

        public Criteria andExamBeginEqualTo(Date value) {
            addCriterion("EXAM_BEGIN =", value, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginNotEqualTo(Date value) {
            addCriterion("EXAM_BEGIN <>", value, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginGreaterThan(Date value) {
            addCriterion("EXAM_BEGIN >", value, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("EXAM_BEGIN >=", value, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginLessThan(Date value) {
            addCriterion("EXAM_BEGIN <", value, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginLessThanOrEqualTo(Date value) {
            addCriterion("EXAM_BEGIN <=", value, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginIn(List<Date> values) {
            addCriterion("EXAM_BEGIN in", values, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginNotIn(List<Date> values) {
            addCriterion("EXAM_BEGIN not in", values, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginBetween(Date value1, Date value2) {
            addCriterion("EXAM_BEGIN between", value1, value2, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamBeginNotBetween(Date value1, Date value2) {
            addCriterion("EXAM_BEGIN not between", value1, value2, "examBegin");
            return (Criteria) this;
        }

        public Criteria andExamEndIsNull() {
            addCriterion("EXAM_END is null");
            return (Criteria) this;
        }

        public Criteria andExamEndIsNotNull() {
            addCriterion("EXAM_END is not null");
            return (Criteria) this;
        }

        public Criteria andExamEndEqualTo(Date value) {
            addCriterion("EXAM_END =", value, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndNotEqualTo(Date value) {
            addCriterion("EXAM_END <>", value, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndGreaterThan(Date value) {
            addCriterion("EXAM_END >", value, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndGreaterThanOrEqualTo(Date value) {
            addCriterion("EXAM_END >=", value, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndLessThan(Date value) {
            addCriterion("EXAM_END <", value, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndLessThanOrEqualTo(Date value) {
            addCriterion("EXAM_END <=", value, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndIn(List<Date> values) {
            addCriterion("EXAM_END in", values, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndNotIn(List<Date> values) {
            addCriterion("EXAM_END not in", values, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndBetween(Date value1, Date value2) {
            addCriterion("EXAM_END between", value1, value2, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamEndNotBetween(Date value1, Date value2) {
            addCriterion("EXAM_END not between", value1, value2, "examEnd");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNull() {
            addCriterion("EXAM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNotNull() {
            addCriterion("EXAM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExamTimeEqualTo(Integer value) {
            addCriterion("EXAM_TIME =", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotEqualTo(Integer value) {
            addCriterion("EXAM_TIME <>", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThan(Integer value) {
            addCriterion("EXAM_TIME >", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAM_TIME >=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThan(Integer value) {
            addCriterion("EXAM_TIME <", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThanOrEqualTo(Integer value) {
            addCriterion("EXAM_TIME <=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeIn(List<Integer> values) {
            addCriterion("EXAM_TIME in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotIn(List<Integer> values) {
            addCriterion("EXAM_TIME not in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_TIME between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_TIME not between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamScoreIsNull() {
            addCriterion("EXAM_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andExamScoreIsNotNull() {
            addCriterion("EXAM_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andExamScoreEqualTo(Integer value) {
            addCriterion("EXAM_SCORE =", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreNotEqualTo(Integer value) {
            addCriterion("EXAM_SCORE <>", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreGreaterThan(Integer value) {
            addCriterion("EXAM_SCORE >", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAM_SCORE >=", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreLessThan(Integer value) {
            addCriterion("EXAM_SCORE <", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreLessThanOrEqualTo(Integer value) {
            addCriterion("EXAM_SCORE <=", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreIn(List<Integer> values) {
            addCriterion("EXAM_SCORE in", values, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreNotIn(List<Integer> values) {
            addCriterion("EXAM_SCORE not in", values, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_SCORE between", value1, value2, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_SCORE not between", value1, value2, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScIsNull() {
            addCriterion("EXAM_SC is null");
            return (Criteria) this;
        }

        public Criteria andExamScIsNotNull() {
            addCriterion("EXAM_SC is not null");
            return (Criteria) this;
        }

        public Criteria andExamScEqualTo(Integer value) {
            addCriterion("EXAM_SC =", value, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScNotEqualTo(Integer value) {
            addCriterion("EXAM_SC <>", value, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScGreaterThan(Integer value) {
            addCriterion("EXAM_SC >", value, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAM_SC >=", value, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScLessThan(Integer value) {
            addCriterion("EXAM_SC <", value, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScLessThanOrEqualTo(Integer value) {
            addCriterion("EXAM_SC <=", value, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScIn(List<Integer> values) {
            addCriterion("EXAM_SC in", values, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScNotIn(List<Integer> values) {
            addCriterion("EXAM_SC not in", values, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_SC between", value1, value2, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_SC not between", value1, value2, "examSc");
            return (Criteria) this;
        }

        public Criteria andExamScScoreIsNull() {
            addCriterion("EXAM_SC_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andExamScScoreIsNotNull() {
            addCriterion("EXAM_SC_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andExamScScoreEqualTo(BigDecimal value) {
            addCriterion("EXAM_SC_SCORE =", value, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreNotEqualTo(BigDecimal value) {
            addCriterion("EXAM_SC_SCORE <>", value, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreGreaterThan(BigDecimal value) {
            addCriterion("EXAM_SC_SCORE >", value, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXAM_SC_SCORE >=", value, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreLessThan(BigDecimal value) {
            addCriterion("EXAM_SC_SCORE <", value, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXAM_SC_SCORE <=", value, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreIn(List<BigDecimal> values) {
            addCriterion("EXAM_SC_SCORE in", values, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreNotIn(List<BigDecimal> values) {
            addCriterion("EXAM_SC_SCORE not in", values, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXAM_SC_SCORE between", value1, value2, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamScScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXAM_SC_SCORE not between", value1, value2, "examScScore");
            return (Criteria) this;
        }

        public Criteria andExamTfIsNull() {
            addCriterion("EXAM_TF is null");
            return (Criteria) this;
        }

        public Criteria andExamTfIsNotNull() {
            addCriterion("EXAM_TF is not null");
            return (Criteria) this;
        }

        public Criteria andExamTfEqualTo(Integer value) {
            addCriterion("EXAM_TF =", value, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfNotEqualTo(Integer value) {
            addCriterion("EXAM_TF <>", value, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfGreaterThan(Integer value) {
            addCriterion("EXAM_TF >", value, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAM_TF >=", value, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfLessThan(Integer value) {
            addCriterion("EXAM_TF <", value, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfLessThanOrEqualTo(Integer value) {
            addCriterion("EXAM_TF <=", value, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfIn(List<Integer> values) {
            addCriterion("EXAM_TF in", values, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfNotIn(List<Integer> values) {
            addCriterion("EXAM_TF not in", values, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_TF between", value1, value2, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_TF not between", value1, value2, "examTf");
            return (Criteria) this;
        }

        public Criteria andExamTfScoreIsNull() {
            addCriterion("EXAM_TF_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andExamTfScoreIsNotNull() {
            addCriterion("EXAM_TF_SCORE is not null");
            return (Criteria) this;
        }

		public Criteria andExamTfScoreEqualTo(BigDecimal value) {
			addCriterion("EXAM_TF_SCORE =", value, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreNotEqualTo(BigDecimal value) {
			addCriterion("EXAM_TF_SCORE <>", value, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreGreaterThan(BigDecimal value) {
			addCriterion("EXAM_TF_SCORE >", value, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("EXAM_TF_SCORE >=", value, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreLessThan(BigDecimal value) {
			addCriterion("EXAM_TF_SCORE <", value, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreLessThanOrEqualTo(BigDecimal value) {
			addCriterion("EXAM_TF_SCORE <=", value, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreIn(List<BigDecimal> values) {
			addCriterion("EXAM_TF_SCORE in", values, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreNotIn(List<BigDecimal> values) {
			addCriterion("EXAM_TF_SCORE not in", values, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("EXAM_TF_SCORE between", value1, value2, "examTfScore");
			return (Criteria) this;
		}

		public Criteria andExamTfScoreNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("EXAM_TF_SCORE not between", value1, value2, "examTfScore");
			return (Criteria) this;
		}

        public Criteria andExamMcIsNull() {
            addCriterion("EXAM_MC is null");
            return (Criteria) this;
        }

        public Criteria andExamMcIsNotNull() {
            addCriterion("EXAM_MC is not null");
            return (Criteria) this;
        }

        public Criteria andExamMcEqualTo(Integer value) {
            addCriterion("EXAM_MC =", value, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcNotEqualTo(Integer value) {
            addCriterion("EXAM_MC <>", value, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcGreaterThan(Integer value) {
            addCriterion("EXAM_MC >", value, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAM_MC >=", value, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcLessThan(Integer value) {
            addCriterion("EXAM_MC <", value, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcLessThanOrEqualTo(Integer value) {
            addCriterion("EXAM_MC <=", value, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcIn(List<Integer> values) {
            addCriterion("EXAM_MC in", values, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcNotIn(List<Integer> values) {
            addCriterion("EXAM_MC not in", values, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_MC between", value1, value2, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_MC not between", value1, value2, "examMc");
            return (Criteria) this;
        }

        public Criteria andExamMcScoreIsNull() {
            addCriterion("EXAM_MC_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andExamMcScoreIsNotNull() {
            addCriterion("EXAM_MC_SCORE is not null");
            return (Criteria) this;
        }

		public Criteria andExamMcScoreEqualTo(BigDecimal value) {
			addCriterion("EXAM_MC_SCORE =", value, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreNotEqualTo(BigDecimal value) {
			addCriterion("EXAM_MC_SCORE <>", value, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreGreaterThan(BigDecimal value) {
			addCriterion("EXAM_MC_SCORE >", value, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("EXAM_MC_SCORE >=", value, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreLessThan(BigDecimal value) {
			addCriterion("EXAM_MC_SCORE <", value, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreLessThanOrEqualTo(BigDecimal value) {
			addCriterion("EXAM_MC_SCORE <=", value, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreIn(List<BigDecimal> values) {
			addCriterion("EXAM_MC_SCORE in", values, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreNotIn(List<BigDecimal> values) {
			addCriterion("EXAM_MC_SCORE not in", values, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("EXAM_MC_SCORE between", value1, value2, "examMcScore");
			return (Criteria) this;
		}

		public Criteria andExamMcScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXAM_MC_SCORE not between", value1, value2, "examMcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcIsNull() {
            addCriterion("EXAM_IC is null");
            return (Criteria) this;
        }

        public Criteria andExamIcIsNotNull() {
            addCriterion("EXAM_IC is not null");
            return (Criteria) this;
        }

        public Criteria andExamIcEqualTo(Integer value) {
            addCriterion("EXAM_IC =", value, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcNotEqualTo(Integer value) {
            addCriterion("EXAM_IC <>", value, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcGreaterThan(Integer value) {
            addCriterion("EXAM_IC >", value, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXAM_IC >=", value, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcLessThan(Integer value) {
            addCriterion("EXAM_IC <", value, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcLessThanOrEqualTo(Integer value) {
            addCriterion("EXAM_IC <=", value, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcIn(List<Integer> values) {
            addCriterion("EXAM_IC in", values, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcNotIn(List<Integer> values) {
            addCriterion("EXAM_IC not in", values, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_IC between", value1, value2, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcNotBetween(Integer value1, Integer value2) {
            addCriterion("EXAM_IC not between", value1, value2, "examIc");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreIsNull() {
            addCriterion("EXAM_IC_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreIsNotNull() {
            addCriterion("EXAM_IC_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreEqualTo(BigDecimal value) {
            addCriterion("EXAM_IC_SCORE =", value, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreNotEqualTo(BigDecimal value) {
            addCriterion("EXAM_IC_SCORE <>", value, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreGreaterThan(BigDecimal value) {
            addCriterion("EXAM_IC_SCORE >", value, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXAM_IC_SCORE >=", value, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreLessThan(BigDecimal value) {
            addCriterion("EXAM_IC_SCORE <", value, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXAM_IC_SCORE <=", value, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreIn(List<BigDecimal> values) {
            addCriterion("EXAM_IC_SCORE in", values, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreNotIn(List<BigDecimal> values) {
            addCriterion("EXAM_IC_SCORE not in", values, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXAM_IC_SCORE between", value1, value2, "examIcScore");
            return (Criteria) this;
        }

        public Criteria andExamIcScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXAM_IC_SCORE not between", value1, value2, "examIcScore");
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