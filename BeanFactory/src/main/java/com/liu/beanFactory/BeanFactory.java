package com.liu.beanFactory;

public interface BeanFactory {

	Object getBean(String name);

	<T> T getBean(String name, Class<T> clazz);
}