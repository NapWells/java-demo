package com.lhy.pojo;

import java.util.Set;

public class Data {
	private Set<Books> books;
	private int count;
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Date [books=" + books + ", count=" + count + "]";
	}
	
	
}
