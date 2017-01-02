package com.liu.beanFactory;

public class Main {
	public static void main(String [] args){
		MyBeanFactory factory = new MyBeanFactory();
		
		MyBean bean = factory.getBean("helloBean",MyBean.class);
		bean.hello();
		
		MyBean bean2 = factory.getBean("helloBean",MyBean.class);
		bean2.hello();
		
		System.out.println("bean equals bean2 :" + (bean==bean2));
	}
	
}
