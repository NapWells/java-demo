package com.liu.conbination;

public class TestBook {
	public static void main(String [] args){
		Author author = new Author("小明","2343@qq.com",'男');
		System.out.println(author);
		
		Book book = new Book("java",author,30);
		System.out.println(book.getAuthorEmail()+","+book.getAuthorName());
		
		Book book1 = new Book("IOS",new Author("小李","0889@qq.com",'女'),23,15); 
		System.out.println(book1);
	}
}
