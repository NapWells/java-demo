package practise8;

import java.util.Iterator;
import java.util.TreeSet;

import practise5.Worker;

public class WorkerTest {
	public static void main(String [] args){
		TreeSet<Worker> set = new TreeSet<Worker>();
		Worker w1 = new Worker("张三",18,1500);
		Worker w2 = new Worker("李四",18,1500);
		Worker w3 = new Worker("王五",18,1600);
		Worker w4 = new Worker("赵六",17,2000);
		set.add(w1);
		set.add(w2);
		set.add(w3);
		set.add(w4);
		for(Iterator<Worker> it=set.iterator();it.hasNext();)
			System.out.println(it.next());
	}

}
