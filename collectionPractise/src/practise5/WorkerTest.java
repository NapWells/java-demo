package practise5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkerTest {
	public static void main(String [] args){
		List<Worker> list = new ArrayList<Worker>();
		Worker w1 = new Worker("张三",18,3000);
		Worker w2 = new Worker("李四",25,3500);
		Worker w3 = new Worker("王五",22,3200);
		list.add(w1);
		list.add(w2);
		list.add(w3);
		System.out.println(list);
		
		Worker w4 = new Worker("赵六",24,3000);
		list.add(1, w4);
		System.out.println(list);
		
		list.remove(w3);
		System.out.println(list);
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		
		for(Worker w: list)
			w.work();
		
	}
}
