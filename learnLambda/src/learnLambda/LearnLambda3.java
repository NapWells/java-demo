package learnLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LearnLambda3 {
	public static void main(String [] args){
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("张三","化学",60));
		persons.add(new Person("李四","生物",78));
		persons.add(new Person("王五","物理",69));
		persons.add(new Person("钱六","计算机",83));
		persons.add(new Person("赵七","化学",90));
//		filterPrint(persons,(Person p)->p.department.equals("化学"));
		filterPrint(persons,(Person p)->p.score>70);
	}
	public static void filterPrint(List<Person> persons,Predicate<Person> predicate){
		for(Person p : persons){
			if(predicate.test(p))
				System.out.println(p.name);
		}
	}
}
