package com.liu.ListSetMap;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FoodTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/liu/ListSetMap/beans.xml");
		Food food   = (Food) ctx.getBean("food1");
		System.out.println(food.getName());
		for(String s : food.getList()){
			System.out.print(s+" ");
		}
		System.out.println("-------------------------------");
		for(String s : food.getSet()){
			System.out.print(s+" ");
		}
		System.out.println("-------------------------------");
		for(String s : food.getArray()){
			System.out.print(s+" ");
		}
		System.out.println("-------------------------------");
		for(Entry<String, Integer> entry: food.getMap().entrySet()){
			System.out.print("key:"+entry.getKey()+",value: "+entry.getValue());
		}
		System.out.println("-------------------------------");
		
		Properties prop = food.getProp();
		Iterator<Entry<Object, Object>> it = prop.entrySet().iterator(); 
		while(it.hasNext()){
			 Entry<Object, Object> entry = it.next();  
	            Object key = entry.getKey();  
	            Object value = entry.getValue();  
	            System.out.println("key   :" + key);  
	            System.out.println("value :" + value);  
	            System.out.println("---------------");  
		}

		System.out.println("-------------------------------");
	}

}
