package com.liu.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler{
	private UserDao userDao;

	public JDKProxy(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	public UserDao createProxy(UserDao userDao){
		UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), 
				userDao.getClass().getInterfaces(), this);
		return proxy;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("add".equals(method.getName())){
			System.out.println("do something else...");
			return method.invoke(userDao, args);
		}
		return method.invoke(userDao, args);
	}

	
	
}
