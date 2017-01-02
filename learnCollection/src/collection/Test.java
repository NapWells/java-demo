package collection;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(3);
		set.add(4);
		set.add(7);
		set.add(5);
		set.add(4);
		set.add(34);
		for(int  i : set)
			System.out.print(i+" ");
	}

}
