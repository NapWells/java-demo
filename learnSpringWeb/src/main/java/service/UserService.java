package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import bean.User;

public class UserService {
	@Autowired
	@Qualifier(value="user")
	private User user;
	public void say(){
		System.out.println("hello world");
	}
}
