package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPermIdIsNull() {
            addCriterion("PERM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNotNull() {
            addCriterion("PERM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPermIdEqualTo(Integer value) {
            addCriterion("PERM_ID =", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotEqualTo(Integer value) {
            addCriterion("PERM_ID <>", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThan(Integer value) {
            addCriterion("PERM_ID >", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PERM_ID >=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThan(Integer value) {
            addCriterion("PERM_ID <", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThanOrEqualTo(Integer value) {
            addCriterion("PERM_ID <=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdIn(List<Integer> values) {
            addCriterion("PERM_ID in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotIn(List<Integer> values) {
            addCriterion("PERM_ID not in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdBetween(Integer value1, Integer value2) {
            addCriterion("PERM_ID between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PERM_ID not between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermNameIsNull() {
            addCriterion("PERM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPermNameIsNotNull() {
            addCriterion("PERM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPermNameEqualTo(String value) {
            addCriterion("PERM_NAME =", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotEqualTo(String value) {
            addCriterion("PERM_NAME <>", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameGreaterThan(String value) {
            addCriterion("PERM_NAME >", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERM_NAME >=", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLessThan(String value) {
            addCriterion("PERM_NAME <", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLessThanOrEqualTo(String value) {
            addCriterion("PERM_NAME <=", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLike(String value) {
            addCriterion("PERM_NAME like", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotLike(String value) {
            addCriterion("PERM_NAME not like", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameIn(List<String> values) {
            addCriterion("PERM_NAME in", values, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotIn(List<String> values) {
            addCriterion("PERM_NAME not in", values, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameBetween(String value1, String value2) {
            addCriterion("PERM_NAME between", value1, value2, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotBetween(String value1, String value2) {
            addCriterion("PERM_NAME not between", value1, value2, "permName");
            return (Criteria) this;
        }

        public Criteria andPermSignIsNull() {
            addCriterion("PERM_SIGN is null");
            return (Criteria) this;
        }

        public Criteria andPermSignIsNotNull() {
            addCriterion("PERM_SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andPermSignEqualTo(String value) {
            addCriterion("PERM_SIGN =", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignNotEqualTo(String value) {
            addCriterion("PERM_SIGN <>", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignGreaterThan(String value) {
            addCriterion("PERM_SIGN >", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignGreaterThanOrEqualTo(String value) {
            addCriterion("PERM_SIGN >=", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignLessThan(String value) {
            addCriterion("PERM_SIGN <", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignLessThanOrEqualTo(String value) {
            addCriterion("PERM_SIGN <=", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignLike(String value) {
            addCriterion("PERM_SIGN like", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignNotLike(String value) {
            addCriterion("PERM_SIGN not like", value, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignIn(List<String> values) {
            addCriterion("PERM_SIGN in", values, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignNotIn(List<String> values) {
            addCriterion("PERM_SIGN not in", values, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignBetween(String value1, String value2) {
            addCriterion("PERM_SIGN between", value1, value2, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermSignNotBetween(String value1, String value2) {
            addCriterion("PERM_SIGN not between", value1, value2, "permSign");
            return (Criteria) this;
        }

        public Criteria andPermDescIsNull() {
            addCriterion("PERM_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPermDescIsNotNull() {
            addCriterion("PERM_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPermDescEqualTo(String value) {
            addCriterion("PERM_DESC =", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotEqualTo(String value) {
            addCriterion("PERM_DESC <>", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescGreaterThan(String value) {
            addCriterion("PERM_DESC >", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescGreaterThanOrEqualTo(String value) {
            addCriterion("PERM_DESC >=", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescLessThan(String value) {
            addCriterion("PERM_DESC <", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescLessThanOrEqualTo(String value) {
            addCriterion("PERM_DESC <=", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescLike(String value) {
            addCriterion("PERM_DESC like", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotLike(String value) {
            addCriterion("PERM_DESC not like", value, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescIn(List<String> values) {
            addCriterion("PERM_DESC in", values, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotIn(List<String> values) {
            addCriterion("PERM_DESC not in", values, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescBetween(String value1, String value2) {
            addCriterion("PERM_DESC between", value1, value2, "permDesc");
            return (Criteria) this;
        }

        public Criteria andPermDescNotBetween(String value1, String value2) {
            addCriterion("PERM_DESC not between", value1, value2, "permDesc");
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