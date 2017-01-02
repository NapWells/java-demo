package com.liu.conbination;

public class TestBook1 {
	public static void main(String [] args){
		Author a1 = new Author("小明","2343@qq.com",'男');
		Author a2 = new Author("小张","2424442@qq.com",'男');
		Author a3 = new Author("小风","3332343@qq.com",'男');
		
		Book1 book = new Book1("java",new Author[]{a1,a2,a3},45,34);
		System.out.println(book.getAuthorNames());
		System.out.println(book);
	}
}
