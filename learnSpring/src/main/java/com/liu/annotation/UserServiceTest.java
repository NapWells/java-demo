package com.liu.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void testSay() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com\\liu\\annotation\\applicationContext.xml");
		UserService userService = ctx.getBean(UserService.class);
		UserService userService2 = ctx.getBean(UserService.class);
		System.out.println(userService==userService2);
		ctx.close();
	}

}
