package com.liu.pointcutAdvisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("环绕后强前....");
		Object result = invocation.proceed();
		System.out.println("环绕后增强....");
		return result;
	}

}
