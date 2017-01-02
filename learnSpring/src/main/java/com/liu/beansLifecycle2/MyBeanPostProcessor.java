package com.liu.beansLifecycle2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	/*
	 * bean:实例对象
	 * beanName：在配置文件中配置类的标识
	 */
	@Override
	public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("第五步：初始化之前执行");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第八步：在初始化后执行");
		//动态代理：
		if(bean.getClass().getSimpleName().equals("CustomerServiceImpl")){
			Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
					new InvocationHandler() {
				//调用目标方法时使用，调用invoke方法
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					if("add".equals(method.getName())){
						System.out.println(System.currentTimeMillis());
						Object result = method.invoke(bean, args);
						System.out.println(System.currentTimeMillis());
						return result;
					}
					return method.invoke(bean, args);
				}
			});
			return proxy;
		}
		return bean;
		
	}
	
}
