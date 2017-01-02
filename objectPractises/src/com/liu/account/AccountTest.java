package com.liu.account;

public class AccountTest {
	public static void main(String [] args){
		Account a1 = new  Account("111","张三",1000);
		Account a2 = new  Account("222","李四",1500);
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println("----------------------------------");
		a1.credit(100);
		System.out.println(a1);
		
		System.out.println("----------------------------------");
		a1.transferTo(a2, 800);
		System.out.println(a1);
		System.out.println(a2);
	}
}
