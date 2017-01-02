package collection;

import java.util.ArrayList;
import java.util.List;

public class LearnArrayList {
	public static void printList(List<String> list){
		for(String s:list){
			System.out.println(s);
		}
	}
	public static void main(String []arg){
		List<String> list = new ArrayList<String>();
		//增加
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("张六");
		list.add("王五");
		list.add(0, "小二");
		System.out.println("起始list：");
		printList(list);
		
		//删除
		list.remove(0);
		System.out.println("删除后list：");
		printList(list);
		
		//替换
		list.set(list.size()-1, "王二");
		System.out.println("替换后list：");
		printList(list);
		
		//访问
		System.out.println("访问list：");
		System.out.println(list.get(2));
		
		List<String> list2 = new ArrayList<String>();
		list2.addAll(list);
		System.out.println(list2);
		list2.addAll(list2);
		System.out.println(list2);
		String [] s = new String[23];
		s = list2.toArray(s);
		for(String i: s)
			System.out.println(i+";");
	}
}
