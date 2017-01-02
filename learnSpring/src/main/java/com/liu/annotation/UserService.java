package com.liu.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Component("userService")
@Service("userService")
//@Repository("userService")
//@Controller("userService")
@Scope("prototype")
public class UserService {
	@Value("张山")
	private String info;
	
	@Autowired
	@Qualifier("zzzzz")
	private UserDao userDao;
	
	public void say(){
		System.out.println("Aello Spring Annotation");
	}

	@Override
	public String toString() {
		return "UserService [info=" + info + ", userDao=" + userDao + "]";
	}
	
	@PostConstruct
	public void setup(){
		System.out.println("初始化.....");
	}
	
	@PreDestroy
	public void teardown(){
		System.out.append("销毁方法.....");
	}
	
}
