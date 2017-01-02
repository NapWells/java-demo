package com.liu.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/liu/beans/beans.xml");
		HelloChinaBean hellochina = ctx.getBean("helloChinaBean",HelloChinaBean.class);
		System.out.println(hellochina.getMessage());
		System.out.println(hellochina.getMessage2());
		ctx.close();
	}

}
