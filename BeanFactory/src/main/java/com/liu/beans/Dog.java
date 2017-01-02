package com.liu.beans;

import com.liu.annotation.Bean;
import com.liu.annotation.Property;
import com.liu.annotation.Property.PropertyType;

@Bean("dog")
public class Dog {
	@Property(value = "张三",type = PropertyType.String)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
}
