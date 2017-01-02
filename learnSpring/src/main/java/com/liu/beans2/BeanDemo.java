package com.liu.beans2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDemo {
	public static void main(String [] args){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/liu/beans2/beans.xml");
		Country country = ctx.getBean("country",Country.class);
		System.out.println("country : " + country.getName() + ", city : " +country.getCity().getName());
		ctx.close();
	}
}
