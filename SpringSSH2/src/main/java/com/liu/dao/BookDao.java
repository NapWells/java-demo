package com.liu.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.liu.pojo.Book;

public class BookDao extends HibernateDaoSupport{

	public void save(Book book) {
		System.out.println("dao��ִ����");
		this.getHibernateTemplate().save(book);
	}

}
