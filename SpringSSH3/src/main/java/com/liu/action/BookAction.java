package com.liu.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.liu.pojo.Book;
import com.liu.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
//<package namespace="/" entends="struts-default></package>
@Namespace("/")
@ParentPackage("struts-default")
@Controller("bookAction")
public class BookAction extends ActionSupport implements ModelDriven<Book>{

	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	

	//模型驱动类
	private Book book = new Book();
	public Book getModel() {
		return book;
	}
	
	@Action(value="book_add")
	public String add(){
		System.out.println("web层的添加执行了.....");
		bookService.add(book);
		return NONE;
	}

}
