package com.gdin.dzzwsyb.zzbxxbspt.web.security;

import org.apache.shiro.authc.AuthenticationToken;

@SuppressWarnings("serial")
public class UsernameIdcardToken implements AuthenticationToken {

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码, in char[] format
	 */
	private char[] password;

	public UsernameIdcardToken() {
	}

	/**
	 * 构造方法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码（char[]）
	 * @param rememberMe
	 *            是否记住我
	 * @param host
	 *            主机或ip
	 * @param usertype
	 *            用户类型
	 */
	public UsernameIdcardToken(final String username, final char[] password) {

		this.username = username;
		this.password = password;
	}

	/**
	 * 构造方法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码（String）
	 * @param rememberMe
	 *            是否记住我
	 * @param host
	 *            主机或ip
	 * @param usertype
	 *            用户类型
	 */
	public UsernameIdcardToken(final String username, final String password) {
		this(username, password != null ? password.toCharArray() : null);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	/**
	 * Simply returns {@link #getUsername() getUsername()}.
	 *
	 * @return the {@link #getUsername() username}.
	 * @see org.apache.shiro.authc.AuthenticationToken#getPrincipal()
	 */
	public Object getPrincipal() {
		return getUsername() + "$$" + new String(getPassword());
	}

	/**
	 * Returns the {@link #getPassword() password} char array.
	 *
	 * @return the {@link #getPassword() password} char array.
	 * @see org.apache.shiro.authc.AuthenticationToken#getCredentials()
	 */
	public Object getCredentials() {
		return getPassword();
	}

	/**
	 * 重写toString方法
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append(" - ");
		sb.append(username);
		return sb.toString();
	}

}
