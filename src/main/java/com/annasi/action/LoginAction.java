package com.annasi.action;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.annasi.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private User user;
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void validate() {
		if (StringUtils.isEmpty(user.getUserName())) {
			addFieldError("user.userName", "Username cannot be empty");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			addFieldError("user.password", "Password cannot be empty");
		}
	}
	
	public String login() {
		if ( authenticate() ) {
			session.put("user", user);
			return SUCCESS;
		}
		return LOGIN;
	}
	
	private boolean authenticate() {
		if (user.getUserName().equals("shan") && user.getPassword().equals("123")) {
			return true;
		}
		return false;
	}
	
}
