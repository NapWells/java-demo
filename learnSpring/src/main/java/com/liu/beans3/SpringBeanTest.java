package com.liu.beans3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {

	@Test
	public void Demo1() {
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("com/liu/beans3/beans.xml");
		Bean1 bean1 = ctx.getBean(Bean1.class);
		System.out.println(bean1);
		ctx.close();
	}

	@Test
	public void Demo2() {
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("com/liu/beans3/beans.xml");
		Bean2 bean2 = (Bean2) ctx.getBean("bean2");
		System.out.println(bean2);
		ctx.close();
	}
	
	@Test
	public void Demo3() {
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("com/liu/beans3/beans.xml");
		Bean3 bean3 = (Bean3) ctx.getBean("bean3");
		System.out.println(bean3);
		ctx.close();
	}
}
