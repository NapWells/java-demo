package com.liu.beanFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.liu.annotation.Bean;
import com.liu.annotation.Property;
import com.liu.annotation.Property.PropertyType;
import com.liu.util.ReflectUtils;

public class AbstractBeanFactory implements BeanFactory {
	protected static Map<String, Object> singletonMap = new HashMap<String, Object>();
	protected static Map<String, Class<?>> prototypeMap = new HashMap<String, Class<?>>();

	public static Map<String, Object> getSingletonMap() {
		return singletonMap;
	}

	public static void setSingletonMap(Map<String, Object> singletonMap) {
		AbstractBeanFactory.singletonMap = singletonMap;
	}

	public static Map<String, Class<?>> getPrototypeMap() {
		return prototypeMap;
	}

	public static void setPrototypeMap(Map<String, Class<?>> prototypeMap) {
		AbstractBeanFactory.prototypeMap = prototypeMap;
	}

	public Object getBean(String name) {
		if (singletonMap.containsKey(name))
			return singletonMap.get(name);
		Object obj = null;
		if (prototypeMap.containsKey(name)) {
			Class<?> clazz = prototypeMap.get(name);
			try {
				obj = clazz.newInstance();

			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(String name, Class<T> clazz) {
		if (getBean(name) != null)
			return (T) getBean(name);
		return null;
	}

	protected static void remainBean(String name, Class<?> clazz, boolean isSingleton) {
		if (!isSingleton) {
			prototypeMap.put(name, clazz);
		} else {
			retainSingletonBean(name, clazz);
		}
	}

	protected static void retainSingletonBean(String name, Class<?> clazz) {
		try {
			Object obj = clazz.newInstance();
			singletonMap.put(name, obj);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	protected void resovleDependence(Object instance) {
		Class<?> clazz = instance.getClass();

		Field[] fields = clazz.getDeclaredFields();
		if (fields == null || fields.length <= 0) {
			return;
		}

		for (Field field : fields) {
			if (field.isAnnotationPresent(Bean.class)) {
				Bean injectedBean = field.getAnnotation(Bean.class);
				String injectedBeanName = injectedBean.value();
				Object injectedObject = getBean(injectedBeanName);
				if (injectedObject == null) {
					throw new RuntimeException("The injected bean is not defined! Bean name: " + injectedBeanName);
				}

				ReflectUtils.invokeSetterMethod(instance, field, injectedObject);
			}else if(field.isAnnotationPresent(Property.class)){
				Property injectedProperty = field.getAnnotation(Property.class);
				String injectedPropertyName = injectedProperty.value();
				PropertyType type = injectedProperty.type();
				ReflectUtils.invokeSetterMethod(instance, field, convert(injectedPropertyName,type));
			}

		}
	}
	protected Object convert(String injectedPropertyName,PropertyType type){
		Object result = null;
		if(type.equals(PropertyType.Integer))
			result =  Integer.parseInt(injectedPropertyName);
		
		if(type.equals(PropertyType.Byte))
			result =  Byte.parseByte(injectedPropertyName);
		
		if(type.equals(PropertyType.Short))
			result =  Short.parseShort(injectedPropertyName);
		
		if(type.equals(PropertyType.Long))
			result =  Long.parseLong(injectedPropertyName);
		
		if(type.equals(PropertyType.Float))
			result =  Float.parseFloat(injectedPropertyName);
		
		if(type.equals(PropertyType.Double))
			result =  Double.parseDouble(injectedPropertyName);
		
		if(type.equals(PropertyType.Character))
			result =  injectedPropertyName.charAt(0);

		if(type.equals(PropertyType.Boolean))
			result =  Boolean.getBoolean(injectedPropertyName);
		result = injectedPropertyName;
		return result;
	}
	

	public static void debug(Object msg) {
    	PropertyConfigurator.configure("src/main/java/log4j.properties");
    	Logger log = Logger.getLogger(AnnotationBeanFactory.class); 
    	log.debug(msg);
    }
	
}
