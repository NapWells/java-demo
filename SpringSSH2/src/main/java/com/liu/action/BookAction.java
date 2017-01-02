package com.liu.action;

import com.liu.pojo.Book;
import com.liu.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport implements ModelDriven<Book>{

	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	//ģ��������
	private Book book = new Book();
	public Book getModel() {
		return book;
	}
	
	public String add(){
		System.out.println("web������ִ����.....");
		bookService.add(book);
		return NONE;
	}

}
