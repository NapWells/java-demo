package com.liu.beansLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanLifecycle implements BeanNameAware, BeanPostProcessor,BeanFactoryAware,InitializingBean,DisposableBean{

	public void destroy() throws Exception {
		System.out.println("执行destroy（）");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("执行afterPropertiesSet()");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("执行setBeanFactory（）");
	}

	public void setBeanName(String name) {
		System.out.println("执行setBeanName()");
	}
	public void init(){
		System.out.println("执行init()");
	}
	public void close(){
		System.out.println("执行close()");
	}
}
