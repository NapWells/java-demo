package com.liu.customer;

public class Customer {
	private int ID;
	private String name;
	private int discount;
	public Customer(int iD, String name, int discount) {
		ID = iD;
		this.name = name;
		this.discount = discount;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public  String toString(){
		return name+"("+ID+")";
	}
	
}
