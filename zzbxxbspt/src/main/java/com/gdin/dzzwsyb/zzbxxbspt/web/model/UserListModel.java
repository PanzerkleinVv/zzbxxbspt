package com.gdin.dzzwsyb.zzbxxbspt.web.model;

import java.util.List;

public class UserListModel {

	private List<User> users;

	public UserListModel() {
		super();
	}

	public UserListModel(List<User> users) {
		super();
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
