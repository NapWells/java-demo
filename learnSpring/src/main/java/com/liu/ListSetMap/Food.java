package com.liu.ListSetMap;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Food {
	private String name;
	private List<String> list;
	private Set<String> set;
	private Map<String,Integer> map;
	private Properties prop;
	private String[] array;
	public Food(){}

	public Food(String name, List<String> list, Set<String> set, Map<String, Integer> map) {
		super();
		this.name = name;
		this.list = list;
		this.set = set;
		this.map = map;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}
	
	
} 
