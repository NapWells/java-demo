package com.liu.beans3;

public class Bean3Factory {
	public Bean3 getBean(String name){
		Bean3 b = new Bean3();
		b.setName(name);
		return b;
	}
}
