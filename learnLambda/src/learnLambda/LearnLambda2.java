package learnLambda;

import java.util.ArrayList;
import java.util.List;

public class LearnLambda2 {
	public static void main(String [] args){
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("张三","化学",60));
		persons.add(new Person("李四","生物",78));
		persons.add(new Person("王五","物理",69));
		persons.add(new Person("钱六","计算机",83));
		persons.add(new Person("赵七","英语",90));
		
		persons.forEach((Person p)->System.out.println(p.name));
		System.out.println();
		persons.forEach((Person p)->System.out.println(p.name + ":" + p.department));
		System.out.println();
		persons.forEach((Person p)->System.out.println(p.name + ":" + p.score));
	}
}
