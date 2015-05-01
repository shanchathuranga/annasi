package com.annasi.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
	    this.session = session;
	}

	public String execute() {
		if (session.get("user") == null) {
			return LOGIN;
		}
		return SUCCESS;
	}
	
}
