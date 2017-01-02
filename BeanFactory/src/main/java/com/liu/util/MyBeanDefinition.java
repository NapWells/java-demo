package com.liu.util;

import java.util.HashMap;
import java.util.Map;

public class MyBeanDefinition {

	private String name;
	private String className;
	private boolean singleton = true;
	private Map<String,String> mapFiledValue;
	private Map<String,String> mapFiledref;
	public MyBeanDefinition() {
		mapFiledValue = new HashMap<>();
		mapFiledref = new HashMap<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public boolean isSingleton() {
		return singleton;
	}
	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}
	public Map<String, String> getMapFiledValue() {
		return mapFiledValue;
	}
	public void setMapFiledValue(Map<String, String> mapFiledValue) {
		this.mapFiledValue = mapFiledValue;
	}
	public Map<String, String> getMapFiledref() {
		return mapFiledref;
	}
	public void setMapFiledref(Map<String, String> mapFiledref) {
		this.mapFiledref = mapFiledref;
	}
}
