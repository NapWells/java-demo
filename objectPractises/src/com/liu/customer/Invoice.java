package com.liu.customer;

public class Invoice {
	private int ID;
	private Customer customer;
	private double anmount;
	public Invoice(int iD, Customer customer, double anmount) {
		ID = iD;
		this.customer = customer;
		this.anmount = anmount;
	}
	public int getID() {
		return ID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getAnmount() {
		return anmount;
	}
	public void setAnmount(double anmount) {
		this.anmount = anmount;
	}
	public String getCustomerName(){
		return customer.getName();
	}
	public double getAmountAfterDiscount(){
		return customer.getDiscount();
	}
	
}
