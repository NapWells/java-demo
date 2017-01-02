package com.liu.customer;

public class InvoiceTest {
	public static void main(String [] args){
		Customer c1 = new Customer(111,"李明",30);
		System.out.println(c1);
		Invoice i = new Invoice(112,c1,20);
		System.out.println(i.getAmountAfterDiscount());
		System.out.println(i.getCustomerName());
	}
}
