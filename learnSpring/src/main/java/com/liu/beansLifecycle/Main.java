package com.liu.beansLifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String [] args){
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("com/liu/beansLifecycle/beans.xml");
		BeanLifecycle lifcycle = ctx.getBean(BeanLifecycle.class);
		ctx.close();
	}
}
