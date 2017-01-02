package practise11;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String [] args){
		Set<Worker> set = new HashSet<Worker>();
		set.add(new Worker("张三",18,1200,new Address("余杭区","112")));
		set.add(new Worker("张三",18,1200,new Address("余杭区","112")));
		set.add(new Worker("李四",18,1200,new Address("余杭区","112")));
		set.add(new Worker("王五",18,1200,new Address("余杭区","112")));
		set.add(new Worker("王五",18,1200,new Address("余杭区","113")));
		set.add(new Worker("王五",18,1200,new Address("余杭区","112")));
		set.add(new Worker("王五",19,1200,new Address("余杭区","112")));
		for(Worker w:set)
			System.out.println(w.getName());
		
	
	}
}
