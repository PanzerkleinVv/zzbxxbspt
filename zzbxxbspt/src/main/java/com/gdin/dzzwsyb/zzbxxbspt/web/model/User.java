package com.gdin.dzzwsyb.zzbxxbspt.web.model;

public class User {
	private String userId;

	private String userName;

	private String userPsw;

	private Integer userRoleId;

	private String userDesc;

	private String userGroup;

	private Message message;

	public User() {

	}

	public User(String username, String password) {
		this.userName = username;
		this.userPsw = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw == null ? null : userPsw.trim();
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc == null ? null : userDesc.trim();
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup == null ? null : userGroup.trim();
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public boolean isEmpty() {
		if (this.userName == null || "".equals(this.userName)) {
			return true;
		} else if (this.userPsw == null || "".equals(this.userPsw)) {
			return true;
		} else {
			return false;
		}
	}
}