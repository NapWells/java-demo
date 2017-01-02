package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

class Person1 implements Comparable<Person1>{
	private String name;
	private int age;
	private int score;
	public Person1(String name, int age, int score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person1))
			return false;
		Person1 p = (Person1) obj;
		if(p.age == this.age&&this.name==p.name&&this.score==p.score)
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Person1 o) {
		// TODO Auto-generated method stub
		return o.getName().compareTo(this.getName());
	}
}

class sortNameComparator implements Comparator<Person1>{

	@Override
	public int compare(Person1 o1, Person1 o2) {
		// TODO Auto-generated method stub
		if(o1.getName().equals(o2.getName()))
			return 1;
		return o1.getName().compareTo(o2.getName());
	}
}
class sortAgeComparator implements Comparator<Person1>{

	@Override
	public int compare(Person1 o1, Person1 o2) {
		// TODO Auto-generated method stub
		if(o1.getAge()>o2.getAge())
			return 1;
		if(o1.getAge()<o2.getAge())
			return -1;
		return 0;
	}
}
class sortScoreComparator implements Comparator<Person1>{

	@Override
	public int compare(Person1 o1, Person1 o2) {
		// TODO Auto-generated method stub
		if(o1.getScore()>o2.getScore())
			return 1;
		if(o1.getScore()<o2.getScore())
			return -1;
		return 0;
	}
}
public class LearnComparator{
	public static void main(String [] args){
		System.out.println("按名字排序-------------");
		Set<Person1> personSet1 = new TreeSet<Person1>(new sortNameComparator());
		personSet1.add(new Person1("cat",13,30));
		personSet1.add(new Person1("dog",17,70));
		personSet1.add(new Person1("monky",15,90));
		personSet1.add(new Person1("cat",16,55));
		personSet1.add(new Person1("mouse",14,35));
		for(Person1 P:personSet1)
			System.out.println(P);
		
		System.out.println("按年龄排序----------");
		Set<Person1> personSet2 = new TreeSet<Person1>(new sortAgeComparator());
		personSet2.add(new Person1("cat",13,30));
		personSet2.add(new Person1("dog",17,70));
		personSet2.add(new Person1("monky",15,90));
		personSet2.add(new Person1("cat",16,55));
		personSet2.add(new Person1("mouse",14,35));
		for(Person1 P:personSet2)
			System.out.println(P);
		

		System.out.println("按分数排序----------");
		Set<Person1> personSet3 = new TreeSet<Person1>(new sortScoreComparator());
		personSet3.add(new Person1("cat",13,30));
		personSet3.add(new Person1("dog",17,70));
		personSet3.add(new Person1("monky",15,90));
		personSet3.add(new Person1("cat",16,55));
		personSet3.add(new Person1("mouse",14,35));
		for(Person1 P:personSet3)
			System.out.println(P);
		
		System.out.println("List排序----------");
		List<Person1> list = new ArrayList<Person1>();
		list.add(new Person1("cat",13,30));
		list.add(new Person1("dog",17,70));
		list.add(new Person1("monky",15,90));
		list.add(new Person1("cat",16,55));
		list.add(new Person1("mouse",14,35));
		Collections.sort((List<Person1>) list);
		for(Person1 P:list)
			System.out.println(P);
		
		System.out.println("线程安全的--------------");
		Vector<Person1> v = new Vector<Person1>();
		list = Collections.synchronizedList(list);
	}
}