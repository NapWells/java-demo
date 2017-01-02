package com.liu.beans;

import com.liu.annotation.Bean;
import com.liu.annotation.Property;
import com.liu.annotation.Property.PropertyType;

@Bean(value = "animal")
public class Animal {
	@Bean(value = "dog")
	private Dog dog;
	@Property(value = "wangcai",type = PropertyType.String)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Animal [dog=" + dog + ", name=" + name + "]";
	}
	
}
