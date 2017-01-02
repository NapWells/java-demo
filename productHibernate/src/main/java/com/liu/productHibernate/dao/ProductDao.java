package com.liu.productHibernate.dao;

import org.hibernate.Session;

import com.liu.productHibernate.beans.Brand;
import com.liu.productHibernate.beans.Product;
import com.liu.productHibernate.beans.Style;
import com.liu.productHibernate.beans.Tag;

public class ProductDao {
	private Session session;

	public ProductDao(Session session) {
		this.session = session;
	}
	
	public Tag getTagById(int id){
		Tag tag = session.get(Tag.class, id);
		return tag;
	}
	
	public Product getProductById(int id){
		return session.get(Product.class, id);
	}
	
	public Brand getBrandById(int id){
		return session.get(Brand.class, id);
	}
	
	public Style getStyleById(int id){
		return session.get(Style.class, id);
	}
}
