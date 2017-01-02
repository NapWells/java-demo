package com.liu.beansLifecycle2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductTest {

	@Test
	//Bean的完整生命周期
	public void demo() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/liu/beansLifecycle2/applicationContext.xml");
		CustomerService CustomerService = ctx.getBean("customerService",CustomerService.class);
		CustomerService.add();
		CustomerService.find();
		ctx.close();
		
	}

}
