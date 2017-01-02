package com.liu.springAspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Before("execution(* com.liu.springAspectJ.UserDao.add(..))")
	public void before(JoinPoint joinPoint){
		System.out.println("前置增强...."+joinPoint);
	}
	
	@AfterReturning(value="execution(* com.liu.springAspectJ.UserDao.delete(..))",returning="returnVal")
	public void afterReturning(Object returnVal){
		System.out.println("后置增强....返回值:" + returnVal);
	}
	
	@Around(value = "execution(* com.liu.springAspectJ.UserDao.update(..))",argNames="")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("环绕前增强.....");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("环绕后增强.....");
		return obj;
	}
	
//	@AfterThrowing(value = "execution(* com.liu.springAspectJ.UserDao.search(..))",throwing="e")
	@AfterThrowing(value = "MyAspect.myPointcut())",throwing="e")
	public void AfterThrowing(Throwable e){
		System.out.println("异常信息:" + e.getMessage());
	}
	
//	@After(value = "execution(* com.liu.springAspectJ.UserDao.search(..))")
	@After(value = "MyAspect.myPointcut()")
	public void after(){
		System.out.println("最终通知....");
	}
	
	@Pointcut(value = "execution(* com.liu.springAspectJ.UserDao.search(..))")
	public void myPointcut(){}
}
