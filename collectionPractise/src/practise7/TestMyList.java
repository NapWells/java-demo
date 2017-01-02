package practise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TestMyList {
	public static <T> void printList(List<T> list){
		for(T t:list)
			System.out.print(t+" ");
		System.out.println();
		System.out.println("------");
	}
	public static  void main(String [] args){
		List<String> list = new MyList<String>();
		System.out.println(list.isEmpty());
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("7");
		printList(list);
		System.out.println();
		System.out.println(list.isEmpty());
		
		System.out.println("删除 "+list.remove("3"));
		printList(list);
		
//		list.clear();
		printList(list);
		
		System.out.println(list.get(2));
		
		list.set(2, "7");
		printList(list);

		list.add(2, "8");
		list.add(5, "12");
		list.add("9");
		printList(list);
		System.out.println(list.size());
		
		list.remove(1);
		printList(list);
		
		System.out.println(list.indexOf("5"));
		
		System.out.println(list.lastIndexOf("7"));
		
		list = list.subList(2, 7);
		printList(list);
		
		Object [] o = list.toArray();
		System.out.println(Arrays.toString(o));
		
		ListIterator<String> it = list.listIterator();
		it.remove();
		it.set("15");
		it.add("14");
		while(it.hasNext()){

			System.out.println(it.next());
		}
		System.out.println("--------------");
		
		while(it.hasPrevious()){
			System.out.println(it.previous());
		}
		System.out.println("--------------");
		printList(list);
		List<String> list2 = new ArrayList<String>();
		list2.add("4");
		list2.add("12");
		System.out.println(list.containsAll(list2));

		printList(list);
		list.addAll(list2);
		printList(list);
		
		list.addAll(2,list2);
		printList(list);
		
		System.out.println(list2);
		list.removeAll(list2);
		printList(list);

	}
}
