package com.liu.test;

import com.liu.beanFactory.AnnotationBeanFactory;
import com.liu.beanFactory.XmlBeanFactory;
import com.liu.beans.Dog;

public class Test {

	public static void main(String[] args) {
		XmlBeanFactory xbf = new XmlBeanFactory();
		Dog dog = xbf.getBean("dog",Dog.class);
		System.out.println(dog);
	}

}
