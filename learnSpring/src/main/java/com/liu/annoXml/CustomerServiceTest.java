package com.liu.annoXml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceTest {
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/liu/annoXml/applicationContext.xml");
		CustomerService customerService = (CustomerService) ctx.getBean("customerService",CustomerService.class);
		System.out.println(customerService);
	}
}
