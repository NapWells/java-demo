package com.liu.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Main {
	public static void main(String [] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/liu/datasource/beans.xml");
		DataBase dataSource = ctx.getBean("datebase",DataBase.class);
		System.out.println(dataSource.getDatesource().getClass());
	}
}
