package com.liu.event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String [] args){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com\\liu\\event\\beans.xml");
		EmailEvent ele = new EmailEvent("test","spring_test@163.com","this is a test");
		ctx.publishEvent(ele);
		ctx.close();
	}
}
