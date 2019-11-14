package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogExample.Criteria;

public class LogQuery {

	private String userName;

	private String logDesc;

	private String groupId;

	private Integer logType;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date logBegin;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date logEnd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogDesc() {
		return logDesc;
	}

	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public Date getLogBegin() {
		return logBegin;
	}

	public void setLogBegin(Date logBegin) {
		this.logBegin = logBegin;
	}

	public Date getLogEnd() {
		return logEnd;
	}

	public void setLogEnd(Date logEnd) {
		this.logEnd = logEnd;
	}

	public LogExample getLogExample() {
		LogExample example = new LogExample();
		Criteria criteria = example.createCriteria();
		if (logDesc != null && !"".equals(logDesc)) {
			criteria.andLogDescLike("%" + logDesc + "%");
		}
		if (logType != null && logType != 0) {
			criteria.andLogTypeEqualTo(logType);
		}
		if (logBegin != null) {
			criteria.andLogTimeGreaterThanOrEqualTo(logBegin);
		}
		if (logEnd != null) {
			criteria.andLogTimeLessThanOrEqualTo(logEnd);
		}
		if (userName != null && !"".equals(userName)) {
			String condition = " user.user_name like '%" + userName + "%'";
			criteria.addCriterion(condition);
		}
		if (groupId != null && !"".equals(groupId) && !"所有".equals(groupId)) {
			String condition = " user.user_group = '" + groupId + "'";
			criteria.addCriterion(condition);
		}
		example.setOrderByClause("log_time desc");
		return example;
	}

}
