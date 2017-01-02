package com.liu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liu.dao.BookDao;
import com.liu.pojo.Book;

@Transactional 
@Service("bookService")
public class BookService {

	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;

	public void add(Book book) {
		System.out.println("service≤„÷¥––¡À");
		bookDao.save(book);
	}

}
