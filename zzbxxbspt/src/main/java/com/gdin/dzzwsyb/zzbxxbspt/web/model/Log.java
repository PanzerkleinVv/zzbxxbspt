package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;

public class Log {
    private String logId;

    private Integer logType;

    private String logUser;

    private String logDesc;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date logTime;
    
    public Log() {
		
	}
    
    public Log(Integer logType, String logUser, String logDesc) {
    	this.logId = ApplicationUtils.randomUUID();
    	this.logType = logType;
    	this.logUser = logUser;
    	this.logDesc = logDesc;
    	this.logTime = new Date();
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser == null ? null : logUser.trim();
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc == null ? null : logDesc.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}