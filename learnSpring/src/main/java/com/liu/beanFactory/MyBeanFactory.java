package com.liu.beanFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class MyBeanFactory {

	private List<MyBeanDefinition> beanDefinitions;
	
	private Map<String,Object> singletonBeans;
	private Map<String,MyBeanDefinition> prototypeBeans;
	public MyBeanFactory(){
		beanDefinitions = new ArrayList<MyBeanDefinition>();
		singletonBeans = new HashMap<String, Object>();
		prototypeBeans = new HashMap<String, MyBeanDefinition>();
		parse("src\\main\\java\\com\\liu\\beanFactory\\mybean.xml");
		resolveBeanDefinition();
	}
	
	public Object getBean(String beanName){
		if(singletonBeans.containsKey(beanName)){
			return singletonBeans.get(beanName);
		}
		MyBeanDefinition definition = prototypeBeans.get(beanName);
		if(definition != null){
			String className = definition.getClassName();
			try{
				return Class.forName(className).newInstance();
			}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		throw new RuntimeException("Invalid bean name : " + beanName);
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName, Class<T> clazz) {
		Object bean = getBean(beanName);
		if(bean.getClass().equals(clazz)){
			return (T)bean;
		}
		throw new RuntimeException("The class is not match the bean class! Exception the class : "
				+ clazz + ", but actully get " + bean.getClass());
	}

	private void parse(String filePath) {
		SAXBuilder builder = new SAXBuilder();
		try{
			Document document = builder.build(new File(filePath));
			Element root = document.getRootElement();
			List<Element> beanElements = root.getChildren("bean");
			for(Element beanElement : beanElements){
				String id = beanElement.getAttributeValue("id");
				String clazz = beanElement.getAttributeValue("class");
				String singleton = beanElement.getAttributeValue("singleton");
				
				MyBeanDefinition definition = new MyBeanDefinition();
				definition.setName(id);
				definition.setClassName(clazz);
				
				if(singleton != null){
					boolean isSingleton = Boolean.parseBoolean(singleton);
					definition.setSingleton(isSingleton);
				}
				beanDefinitions.add(definition);
			}
		}catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}


	
	private void resolveBeanDefinition() {
		for(MyBeanDefinition definition : beanDefinitions){
			String id = definition.getName();
			
			if(definition.isSingleton()){
				String className = definition.getClassName();
				
			
				try {
					Class<?> clazz = Class.forName(className);
					Object instance = clazz.newInstance();
					this.singletonBeans.put(id, instance);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}else{
				prototypeBeans.put(id, definition);
			}
		}
	}


}
