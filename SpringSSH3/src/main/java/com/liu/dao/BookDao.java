package com.liu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.liu.pojo.Book;

@Repository("bookDao")
public class BookDao{

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	
	public void save(Book book) {
		System.out.println("dao≤„÷¥––¡À");
		hibernateTemplate.save(book);
	}

}
