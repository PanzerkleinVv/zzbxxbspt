package com.gdin.dzzwsyb.zzbxxbspt.web.model;

public class Message {

	private boolean flag;

	private String content;

	private Object object;

	public Message() {

	}

	public Message(boolean flag, String content) {
		this.flag = flag;
		this.content = content;
	}

	public Message(boolean flag, String content, Object object) {
		this.flag = flag;
		this.content = content;
		this.object = object;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
