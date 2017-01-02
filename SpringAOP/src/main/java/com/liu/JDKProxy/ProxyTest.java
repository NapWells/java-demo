package com.liu.JDKProxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test1(){
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.add();
		userDaoImpl.update();
		
	}
	
	@Test
	public void test2(){
		UserDao userDao = new UserDaoImpl();
		UserDao proxy = new JDKProxy(userDao).createProxy(userDao);
		proxy.add();
		proxy.update();
	}
}
