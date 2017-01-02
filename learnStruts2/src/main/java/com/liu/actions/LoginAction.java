package com.liu.actions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwrod) {
		this.password = passwrod;
	}
	@Override
	public String execute() throws Exception {
		if (getUsername().equals("123")&& getPassword().equals("123") ){
			{
				ActionContext.getContext().getSession()
					.put("user", getUsername());
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
}
