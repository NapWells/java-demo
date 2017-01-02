package practise2_3;

import java.util.ArrayList;
import java.util.List;

public class practise3 {
	public static <T> List<T> newList(List<T> list){
		List<T> result = new ArrayList<T>();
		for(int i=0;i<list.size();i++){
			if(result.contains(list.get(i))==false)
				result.add(list.get(i));
		}
		return result;
			
	}
	
	public static void main(String []args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(6);
		System.out.println(newList(list));
	}
}
