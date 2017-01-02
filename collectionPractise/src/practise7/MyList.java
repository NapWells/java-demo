package practise7;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<T> implements List<T>{
	private T [] array;
	private int size =0;
	private int next=0;

	@SuppressWarnings("unchecked")
	public MyList(){
		array = (T[]) new Object[size];
	}
	@Override
	public int size() {
		return array.length;
	}

	@Override
	public boolean isEmpty() {
		if(array.length != 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean contains(Object o) {
		for(int i =0;i<array.length;i++)
			if(array[i] == o)
				return true;
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			@Override
			public boolean hasNext() {
				if(next+1>array.length){
					next=0;
					return false;
				}
				else
					return true;
			}
			@Override
			public T next() {
				return array[next++];
			}
		};
	}

	@Override
	public Object[] toArray() {
		return array;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T e) {
		size = array.length+1;
		T [] result = (T[]) new Object[size];
		for(int i=0;i<size-1;i++){
			result [i] = array[i];
		}
		result[size-1]=e;
		array =(T[]) new Object[size];
		array = result;
		return false;
	}

	@Override
	public boolean remove(Object o) {
		for(int i=0;i<array.length;i++)
			if(array[i]==o)
				this.remove(i);
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		T [] result = (T[]) c.toArray();
		int k=0;
		if(result.length>array.length)
			return false;
		else{
			for(int i = 0;i<result.length;i++){
				for(int j = 0;j<array.length;j++ ){
					if(result[i]==array[j]){
						k++; 
						continue;
					}
				}
			}
		}
		if(k==result.length)
			return true;
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		T [] result = (T[]) new Object[c.size()+array.length];
		int index=0;
		for(int i=0;i<=array.length;i++){
			if(index<array.length)
				result[index++] = array[i];
			else{
				for(T t:c){
					result[index++] = t;
				}
			}
		}
		array = result;
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		T [] result = (T[]) new Object[c.size()+array.length];
		int index1=0;
		for(int i=0;i<array.length;i++){
			if(i==index){
				result[index1++] = array[i];
				for(T t:c){
					result[index1++] = t;
				}
			}
				
			else{
				result[index1++] = array[i];
			}
		}
		array = result;
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		T [] result = (T[]) new Object[c.size()];
		for(int i=0;i<array.length;i++){
			for(int j=0;j<result.length;j++){
				if(array[i]==result[j]){
					this.remove(i);
				}
			}
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		size = 0;
		array = (T[]) new Object[size];
	}

	@Override
	public T get(int index) {
		if(index>array.length||index<0)
			return null;
		return array[index];
	}

	@Override
	public T set(int index, T element) {
		array[index] = element;
		return null;
	}

	@Override
	public void add(int index, T element) {
		size = array.length+1;
		T[] result = (T[]) new Object[size];
		int n = 0;
		for(int i=0;i<size-1;i++)
			if(i==index){
				result[n++] = element;
				result[n++] = array[i];
			}
			else
				result[n++] = array[i];
		array = result;
		
	}

	@Override
	public T remove(int index) {
		size = array.length-1;
		int n=0;
		T s = null;
		T []result = (T[]) new Object[size]; 
		for(int i=0;i<array.length;i++){
			if(i != index){
				result[n++]=array[i];
			}
			else{
				s = array[i];
				continue;
			}
		}
		array = result;
		return s;
	}

	@Override
	public int indexOf(Object o) {
		for(int i=0;i<array.length;i++)
			if(array[i] == o)
				return i;
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		for(int i=array.length-1;i>=0;i--)
			if(array[i]==o)
				return i;
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		return new ListIterator<T>(){
			int next=0;
			int previous = array.length;
			@Override
			public boolean hasNext() {
				if(next>=array.length){
					next=0;
					return false;
				}
				return true;
			}

			@Override
			public T next() {
				return array[next++];
			}

			@Override
			public boolean hasPrevious() {
				if(previous<0){
					return false;
				}
				return true;
			}

			@Override
			public T previous() {
				return array[previous--];
			}

			@Override
			public int nextIndex() {
				return next++;
			}

			@Override
			public int previousIndex() {
				return previous--;
			}

			@Override
			public void remove() {
				size = array.length-1;
				T [] result = (T[]) new Object[size];
				for(int i=0;i<size;i++)
					result[i] = array[i];
				array = result;
				previous = array.length-1;
				
			}

			@Override
			public void set(T e) {
				if(array.length != 0){
					if(hasNext())
						array[next] = e;
					else
						array[previous] =e;
				}
				else{
					array = (T[]) new Object[1];
					array[0] = e;
				}
			}

			@Override
			public void add(T e) {
				T [] result = (T[]) new Object[array.length+1];
				int index = 0;
				for(int i=0;i<result.length-1;i++)
					result[index++] = array[i];
				result[index++] = e;
				array = result;
			}};
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		T[] result = (T[]) new Object[toIndex-fromIndex];
		int index = 0;
		for(int i=0;i<array.length;i++){
			if(i==fromIndex){
				result[index++]=array[fromIndex];
				fromIndex++;
				if(fromIndex==toIndex)
					break;
			}
		}
		array = result;
		return this;
	}


}
