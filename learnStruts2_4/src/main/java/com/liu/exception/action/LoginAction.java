package com.liu.exception.action;

import com.liu.exception.exception.MyException;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String tip;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	@Override
	public String execute() throws Exception {
		if(getUsername().equalsIgnoreCase("user")){
			throw new MyException("自定义异常");
		}if(getUsername().equalsIgnoreCase("sql")){
			throw new java.sql.SQLException("用户名不能为sql");
		}if(getUsername().equalsIgnoreCase("123")&&getPassword().equalsIgnoreCase("123")){
			addActionMessage("服务器提示：登陆成功！");
			return SUCCESS;
		}
		addActionMessage("服务器提示：登陆失败！");
		return ERROR;
	}
	
}

