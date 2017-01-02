package practise5;

import java.text.Collator;
import java.util.Locale;

public class Worker implements Comparable<Worker>{
	private String name;
	private int age;
	private double salary;
	public Worker(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public void work(){
		System.out.println(name+"#开始工作。。。");
		System.out.println(name+"#完成工作。。。");
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Worker))
			return false;
		Worker w = (Worker) obj;
		if(this.age==w.age&&this.name.equals(w.name)&&this.salary==w.salary){
			return true;
		}
		else
			return false;
	}
	

	@Override
	public int hashCode() {
		
		return 0;
	}
	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	@Override
	public int compareTo(Worker o) {
		Collator instance  = Collator.getInstance(Locale.CHINA);
//		return instance.compare(this.name, o.name);
		if(this.age>o.age)
			return 1;
		if(this.age<o.age)
			return -1;
		else{
			if(this.salary>o.salary)
				return 1;
			if(this.salary>o.salary)
				return -1;
			else
				return instance.compare(this.name, o.name);
		}
	}
	
	
	
}
