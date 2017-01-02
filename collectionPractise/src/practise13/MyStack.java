package practise13;

import java.util.LinkedList;
import java.util.List;

public class MyStack<E> {
	List<E> list =new LinkedList<E>();
	
	public void push(E e){
		list.add(e);
	}
	
	public E pop(){
		if(list.isEmpty())
			return null;
		else{
			E e = list.get(list.size()-1);
			list.remove(e);
			return e;
		}
	}
	
	public boolean isEmpty(){
		if(list.size()==0)
			return true;
		return false;
	}
	
	public E peek(){
		if(list.isEmpty())
			return null;
		else{
			E e = list.get(list.size()-1);
			return e;
		}
	}
	
	public int size(){
		return list.size();
	}

	@Override
	public String toString() {
		return "MyStack [list=" + list + "]";
	}
	
}
