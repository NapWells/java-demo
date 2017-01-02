package com.liu.actions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class LoginRegistAction extends ActionSupport{
	private String username;
	private String password;
	private String tip;
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
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
	public String regist() throws Exception{
		ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
		invocation.addPreResultListener(new PreResultListener() {
			public void beforeResult(ActionInvocation invocation, String resultCode) {
				System.out.println("返回的逻辑视图名字为：" + resultCode);
				invocation.getInvocationContext().put("extra", new java.util.Date() + "由" + resultCode + "逻辑视图名转入");
			}
		});
		ActionContext.getContext().getSession().put("user", getUsername());
		setTip("恭喜您， " + getUsername() + ",您已经注册成功！");
		return SUCCESS;
	}

	public String login() throws Exception {
		ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
		invocation.addPreResultListener(new PreResultListener() {
			public void beforeResult(ActionInvocation invocation, String resultCode) {
				System.out.println("返回的逻辑视图名字为：" + resultCode);
				invocation.getInvocationContext().put("extra", new java.util.Date() + "由" + resultCode + "逻辑视图名转入");
			}
		});
		if (getUsername().equals("123")&& getPassword().equals("123") ){
			{
				ActionContext.getContext().getSession().put("user", getUsername());
				setTip("欢迎您， " + getUsername() + ",您已经登录成功！");
				return SUCCESS;
			}
		}
		setTip("登录失败！");
		return ERROR;
	}
	
	
}
