package com.liu.actions;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action{
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
	

	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer) ctx.getApplication().get("counter");
		if(counter == null){
			counter = 1;
		}else{
			counter += 1;
		}
		Cookie c = new Cookie("user",getUsername());
		c.setMaxAge(60*60);
		ServletActionContext.getResponse().addCookie(c);
		ctx.getApplication().put("counter", counter);
		ctx.getSession().put("user", getUsername());
		if (getUsername().equals("123")&& getPassword().equals("123") ){
			{
				ctx.put("tip", "服务器提示：您已经成功登录");
				return SUCCESS;
			}
		}
		ctx.put("tip", "服务器提示：登录失败");
		return ERROR;
	}
	
	
}
