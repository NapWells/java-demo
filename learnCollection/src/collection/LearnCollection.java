package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LearnCollection {
	public static void main(String []args){
		Collection <String> collection;
		collection = new ArrayList<String>();
		collection.add("张三");
		collection.add("李四");
		collection.add("王五");
		collection.add("小六");
		
		System.out.println(collection.contains("张三"));
		System.out.println(collection.size());
		collection.remove("小六");
		System.out.println(collection.size());
		for(String s:collection)
			System.out.println(s);
	
		Iterator<String> it = collection.iterator();
		while(it.hasNext()){
			String s= it.next();
			System.out.println(s);
		}
	}
}
