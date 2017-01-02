package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkListAndArrayList {
	public static void main(String [] args){
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();
		doTiniList("ArrayList",list1);
		doTiniList("LinkedList",list2);
	}
	public static void doTiniList(String type,List<Integer> list){
		long start = System.currentTimeMillis();
		for(int i=0;i<2E5;i++)
			list.add(0,i);
		long end = System.currentTimeMillis();
		System.out.println(type+"所用时间为："+(end-start)+"毫秒");
	}
}
