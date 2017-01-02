package com.liu.service;

import org.springframework.transaction.annotation.Transactional;

import com.liu.dao.BookDao;
import com.liu.pojo.Book;

@Transactional 
public class BookService {

	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void add(Book book) {
		System.out.println("service≤„÷¥––¡À");
		bookDao.save(book);
	}

}
