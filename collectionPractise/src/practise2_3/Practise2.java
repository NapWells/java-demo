package practise2_3;

import java.util.ArrayList;
import java.util.List;

public class Practise2 {
	public static void main(String [] args){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=10;i++)
			list.add(i);
		System.out.println(list);
		deleteElement(list,4);
		System.out.println(list);
	}
	
	public static <T> List<T> deleteElement(List<T> list,int n){
		list.remove(n-1);
		return list;
	}
}
