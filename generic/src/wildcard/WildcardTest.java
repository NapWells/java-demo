package wildcard;

import java.util.ArrayList;
import java.util.List;

class Animal{
	private static int n;
	private int id=n++; 
	public Animal(){
	}
	public  String toString(){
		return "this is Animal "+id;
	}
	public void eating(){
		System.out.println("Animal "+id+" is eating");
	}
}
class Dog extends Animal{
	private static int n;
	private int id=n++; 
	public  String toString(){
		return "this is a dog "+id;
	}
	public void eating(){
		System.out.println("dog "+id+" is eating");
	}
}
public class WildcardTest {
	public static void showList(List<? extends Animal> list){
		for(Animal animal:list){
			System.out.println(animal);
			animal.eating();
		}
	}
	public static void showList2(List<? super Dog> list){
		for(Object animal:list){
			System.out.println(animal);
		}
	}
	public static void main(String [] args){
		Animal a = new Animal();
		Animal b = new Animal();
		List<Animal> list = new ArrayList<Animal>();
		Dog c = new Dog();
		Dog d = new Dog();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		showList(list);
		System.out.println("---------------------------------");
		showList2(list);

		
	}
}	
