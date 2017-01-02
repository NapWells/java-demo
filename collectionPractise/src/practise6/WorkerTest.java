package practise6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import practise5.Worker;

public class WorkerTest {
	public static void main(String [] args){
		Set<Worker> set = new HashSet<Worker>();
		Worker w1 = new Worker("张三",18,3000);
		Worker w2 = new Worker("李四",25,3500);
		Worker w3 = new Worker("王五",22,3200);
		Worker w4 = new Worker("张三",18,3000);
		set.add(w1);
		set.add(w2);
		set.add(w3);
		set.add(w4);
		System.out.println(w1.hashCode());
		System.out.println(w4.hashCode());
		Iterator<Worker> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
