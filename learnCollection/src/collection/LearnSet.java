package collection;

import java.text.Collator;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person>{
	private int i;
	private String name;
	public Person(int i, String name) {
		this.i = i;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (i != other.i)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [i=" + i + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Person o) {
		Collator instance  = Collator.getInstance(Locale.CHINA);
		return instance.compare(this.name, o.name);
	}

	
}
public class LearnSet {
	public static void main(String [] arg){
		Set<String> s = new HashSet<String>();
		s.add("cat");
		s.add("dog");
		s.add("mouse");
		s.add("pig");
		s.add("cat");
		System.out.println(s);
		Set<String> s2 = new HashSet<String>();
		s2.add("monky");
		s2.add("cat");
		s2.add("sheep");
		s.removeAll(s2);
		System.out.println(s);
		s.addAll(s2);
		System.out.println(s);
		
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(new Person(1,"张三"));
		personSet.add(new Person(2,"李四"));
		personSet.add(new Person(1,"王五"));
		personSet.add(new Person(1,"张三"));
		System.out.println(personSet);
		
		Set<Person> personSet1 = new TreeSet<Person>();
		personSet1.add(new Person(1,"cat"));
		personSet1.add(new Person(2,"dog"));
		personSet1.add(new Person(1,"monky"));
		personSet1.add(new Person(1,"tiger"));
		System.out.println(personSet1);
		
		Set<Person> personSet2 = new TreeSet<Person>();
		personSet2.add(new Person(1,"张三"));
		personSet2.add(new Person(2,"李四"));
		personSet2.add(new Person(1,"王五"));
		personSet2.add(new Person(1,"赵六"));
		System.out.println(personSet2);
	}
}
