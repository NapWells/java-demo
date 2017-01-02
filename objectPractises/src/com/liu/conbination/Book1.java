package com.liu.conbination;

import java.util.Arrays;

public class Book1 {
	private String name;
	private Author author[];
	private double price;
	int qty = 0;
	
	public Book1(String name, Author []author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public Book1(String name, Author []author, double price, int qty) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public Author[] getAuthor() {
		return author;
	}
	public String getAuthorNames(){
		String result = "";
		for(Author a:author)
			result += a.getName()+",";
		return result;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", author[]=" + Arrays.deepToString(author)+ ", price=" + price + ", qty=" + qty + "]";
	}
}
