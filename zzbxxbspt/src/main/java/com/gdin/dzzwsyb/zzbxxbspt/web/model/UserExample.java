package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserExample() {
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

		public Criteria andUserNameIsNull() {
			addCriterion("USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("USER_NAME =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("USER_NAME <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("USER_NAME >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NAME >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("USER_NAME <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("USER_NAME <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("USER_NAME like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("USER_NAME not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("USER_NAME in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("USER_NAME not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("USER_NAME between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("USER_NAME not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserPswIsNull() {
			addCriterion("USER_PSW is null");
			return (Criteria) this;
		}

		public Criteria andUserPswIsNotNull() {
			addCriterion("USER_PSW is not null");
			return (Criteria) this;
		}

		public Criteria andUserPswEqualTo(String value) {
			addCriterion("USER_PSW =", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswNotEqualTo(String value) {
			addCriterion("USER_PSW <>", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswGreaterThan(String value) {
			addCriterion("USER_PSW >", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswGreaterThanOrEqualTo(String value) {
			addCriterion("USER_PSW >=", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswLessThan(String value) {
			addCriterion("USER_PSW <", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswLessThanOrEqualTo(String value) {
			addCriterion("USER_PSW <=", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswLike(String value) {
			addCriterion("USER_PSW like", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswNotLike(String value) {
			addCriterion("USER_PSW not like", value, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswIn(List<String> values) {
			addCriterion("USER_PSW in", values, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswNotIn(List<String> values) {
			addCriterion("USER_PSW not in", values, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswBetween(String value1, String value2) {
			addCriterion("USER_PSW between", value1, value2, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserPswNotBetween(String value1, String value2) {
			addCriterion("USER_PSW not between", value1, value2, "userPsw");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdIsNull() {
			addCriterion("USER_ROLE_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdIsNotNull() {
			addCriterion("USER_ROLE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdEqualTo(Integer value) {
			addCriterion("USER_ROLE_ID =", value, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdNotEqualTo(Integer value) {
			addCriterion("USER_ROLE_ID <>", value, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdGreaterThan(Integer value) {
			addCriterion("USER_ROLE_ID >", value, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_ROLE_ID >=", value, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdLessThan(Integer value) {
			addCriterion("USER_ROLE_ID <", value, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdLessThanOrEqualTo(Integer value) {
			addCriterion("USER_ROLE_ID <=", value, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdIn(List<Integer> values) {
			addCriterion("USER_ROLE_ID in", values, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdNotIn(List<Integer> values) {
			addCriterion("USER_ROLE_ID not in", values, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdBetween(Integer value1, Integer value2) {
			addCriterion("USER_ROLE_ID between", value1, value2, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserRoleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_ROLE_ID not between", value1, value2, "userRoleId");
			return (Criteria) this;
		}

		public Criteria andUserDescIsNull() {
			addCriterion("USER_DESC is null");
			return (Criteria) this;
		}

		public Criteria andUserDescIsNotNull() {
			addCriterion("USER_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andUserDescEqualTo(String value) {
			addCriterion("USER_DESC =", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescNotEqualTo(String value) {
			addCriterion("USER_DESC <>", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescGreaterThan(String value) {
			addCriterion("USER_DESC >", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescGreaterThanOrEqualTo(String value) {
			addCriterion("USER_DESC >=", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescLessThan(String value) {
			addCriterion("USER_DESC <", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescLessThanOrEqualTo(String value) {
			addCriterion("USER_DESC <=", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescLike(String value) {
			addCriterion("USER_DESC like", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescNotLike(String value) {
			addCriterion("USER_DESC not like", value, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescIn(List<String> values) {
			addCriterion("USER_DESC in", values, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescNotIn(List<String> values) {
			addCriterion("USER_DESC not in", values, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescBetween(String value1, String value2) {
			addCriterion("USER_DESC between", value1, value2, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserDescNotBetween(String value1, String value2) {
			addCriterion("USER_DESC not between", value1, value2, "userDesc");
			return (Criteria) this;
		}

		public Criteria andUserGroupIsNull() {
			addCriterion("USER_GROUP is null");
			return (Criteria) this;
		}

		public Criteria andUserGroupIsNotNull() {
			addCriterion("USER_GROUP is not null");
			return (Criteria) this;
		}

		public Criteria andUserGroupEqualTo(String value) {
			addCriterion("USER_GROUP =", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupNotEqualTo(String value) {
			addCriterion("USER_GROUP <>", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupGreaterThan(String value) {
			addCriterion("USER_GROUP >", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupGreaterThanOrEqualTo(String value) {
			addCriterion("USER_GROUP >=", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupLessThan(String value) {
			addCriterion("USER_GROUP <", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupLessThanOrEqualTo(String value) {
			addCriterion("USER_GROUP <=", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupLike(String value) {
			addCriterion("USER_GROUP like", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupNotLike(String value) {
			addCriterion("USER_GROUP not like", value, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupIn(List<String> values) {
			addCriterion("USER_GROUP in", values, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupNotIn(List<String> values) {
			addCriterion("USER_GROUP not in", values, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupBetween(String value1, String value2) {
			addCriterion("USER_GROUP between", value1, value2, "userGroup");
			return (Criteria) this;
		}

		public Criteria andUserGroupNotBetween(String value1, String value2) {
			addCriterion("USER_GROUP not between", value1, value2, "userGroup");
			return (Criteria) this;
		}
		
		public Criteria andUserGroupUsed() {
			addCriterion("USER_GROUP in (select group_id from `group` where group_status = 1)");
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