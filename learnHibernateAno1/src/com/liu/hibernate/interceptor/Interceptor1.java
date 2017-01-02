package com.liu.hibernate.interceptor;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class Interceptor1 extends EmptyInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("Entity£º" + entity);
		System.out.println("Id£º" + id);
		System.out.println("state: " + Arrays.toString(state));
		System.out.println("propertyNames: " + Arrays.toString(propertyNames));
		System.out.println("types: " + Arrays.toString(types));
		return true;
	}
	

}
