package com.liu.beanFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liu.util.MyBeanDefinition;
import com.liu.util.ReflectUtils;

public class XmlBeanFactory extends AbstractBeanFactory {

	private List<MyBeanDefinition> beanDefinitions;

	private Map<String, Object> singletonBeans;
	private Map<String, MyBeanDefinition> prototypeBeans;

	public XmlBeanFactory() {
		beanDefinitions = new ArrayList<MyBeanDefinition>();
		singletonBeans = new HashMap<String, Object>();
		prototypeBeans = new HashMap<String, MyBeanDefinition>();
		parse("src/main/java/mybean.xml");
		resolveBeanDefinition();
	}

	public Object getBean(String beanName) {
		if (singletonBeans.containsKey(beanName)) {
			return singletonBeans.get(beanName);
		}
		MyBeanDefinition definition = prototypeBeans.get(beanName);
		if (definition != null) {
			String className = definition.getClassName();
			try {
				return Class.forName(className).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("Invalid bean name : " + beanName);
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName, Class<T> clazz) {
		Object bean = getBean(beanName);
		if (bean.getClass().equals(clazz)) {
			return (T) bean;
		}
		throw new RuntimeException("The class is not match the bean class! Exception the class : " + clazz
				+ ", but actully get " + bean.getClass());
	}

	private void parse(String filePath) {
		org.jdom2.input.SAXBuilder builder = new org.jdom2.input.SAXBuilder();
		try {
			org.jdom2.Document document = builder.build(new File(filePath));
			org.jdom2.Element root = document.getRootElement();
			List<org.jdom2.Element> beanElements = root.getChildren("bean");
			for (org.jdom2.Element beanElement : beanElements) {
				String id = beanElement.getAttributeValue("id");
				String clazz = beanElement.getAttributeValue("class");
				String singleton = beanElement.getAttributeValue("singleton");
				MyBeanDefinition definition = new MyBeanDefinition();
				for (org.jdom2.Element propElement : beanElement.getChildren("property")) {
					if (propElement.getAttributeValue("value") != null)
						definition.getMapFiledValue().put(propElement.getAttributeValue("name"),
								propElement.getAttributeValue("value"));
					if (propElement.getAttributeValue("ref") != null)
						definition.getMapFiledref().put(propElement.getAttributeValue("name"),
								propElement.getAttributeValue("ref"));
				}
				definition.setName(id);
				definition.setClassName(clazz);

				if (singleton != null) {
					boolean isSingleton = Boolean.parseBoolean(singleton);
					definition.setSingleton(isSingleton);
				}
				beanDefinitions.add(definition);
			}
		} catch (org.jdom2.JDOMException | IOException e) {
			e.printStackTrace();
		}
	}

	// dom4j
	// private static List<List<Element>> parseChild(String filePath,String
	// nodeName){
	// List<List<org.dom4j.Element>> list = null;
	// org.dom4j.io.SAXReader saxReader = new org.dom4j.io.SAXReader();
	// try {
	// list = new ArrayList<>();
	// org.dom4j.Document document = saxReader.read(new File(filePath));
	// org.dom4j.Element root = document.getRootElement();
	// List<org.dom4j.Element> childList = root.elements();
	// for(org.dom4j.Element e : childList){
	// list.add(e.elements(nodeName));
	// }
	// } catch (DocumentException e) {
	// e.printStackTrace();
	// }
	// return list;
	// }

	private void resolveBeanDefinition() {
		for (MyBeanDefinition definition : beanDefinitions) {
			String id = definition.getName();
			String className = definition.getClassName();
			Class<?> clazz = null;
			Object instance = null;
			try {
				clazz = Class.forName(className);
				instance = clazz.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
			
			if(definition.getMapFiledValue().size()!=0||definition.getMapFiledref().size()!=0){
				Field[] fields = clazz.getFields();
				for(Field field : fields){
					if(definition.getMapFiledValue().get(field.getName())!=null)
						ReflectUtils.invokeSetterMethod(instance, field, definition.getMapFiledValue().get(field.getName()));
					else if(definition.getMapFiledref().get(field.getName())!=null){
						try {
							Class<?> c = Class.forName(definition.getMapFiledref().get(field.getName()));
							Object o = c.newInstance();
							ReflectUtils.invokeSetterMethod(instance, field,o);
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			if (definition.isSingleton()) {
				this.singletonBeans.put(id, instance);
			} else {
				prototypeBeans.put(id, definition);
			}
		}
	}
	
}
