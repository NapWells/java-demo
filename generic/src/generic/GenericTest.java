package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

class Genarator<K,V>{
	private K k;
	private V v;
	public Genarator(K k, V v) {
		this.k = k;
		this.v = v;
	}
	public K getK() {
		return k;
	}
	public V getV() {
		return v;
	}
	@Override
	public String toString() {
		return "Genarator [k=" + k + ", v=" + v + "]";
	}

}
public class GenericTest {
	public static <T>void out(T...args ){
		for(T t:args)
			System.out.println(t);
	}
	public static void main(String [] args){
		Genarator<Integer,String> g1 = new Genarator<Integer,String>(1,"one");
		Genarator<String,String> g2 = new Genarator<String,String>("1","one");
		Genarator<Date,String> g3 = new Genarator<Date,String>(new Date(),"one");
		List<Genarator<Integer,String>> list = new ArrayList<Genarator<Integer,String>>();
		list.add(g1);
		Genarator<Integer,String> g4 = new Genarator<Integer,String>(4,"four");
//		list.add(g2);
//		list.add(g3);
		list.add(g4);
		for(Genarator<Integer,String> g:list){
			System.out.println(g);
		}
		out(1,2,3,4,5,6,7);
	}
}
