package com.liu.invoiceItem;

public class TestInvoiceItem {
	public static void main(String [] args){
		InvoiceItem i = new InvoiceItem("liu", "haoyu", 10, 20);
		System.out.println(i);
		System.out.println(i.getTotal());
	}
}
