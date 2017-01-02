package com.liu.productHibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.liu.productHibernate.beans.Brand;
import com.liu.productHibernate.beans.Product;
import com.liu.productHibernate.beans.Style;
import com.liu.productHibernate.beans.Tag;

public class ProductDaoTest {
	static SessionFactory sf;
	static Session session ;
	static ProductDao dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = sf.openSession();
		dao = new ProductDao(session);
	}

	@Test
	public void testGetTagById() {
		Tag tag = dao.getTagById(1);
		System.out.println(tag);
		Assert.assertNotNull(tag);
	}

	@Test
	public void testGetProductById() {
		Product product = dao.getProductById(2);
		System.out.println(product);
		Assert.assertNotNull(product);
	}

	@Test
	public void testGetBrandById() {
		Brand brand = dao.getBrandById(2);
		System.out.println(brand);
		Assert.assertNotNull(brand);
	}

	@Test
	public void testGetStyleById() {
		Style style= dao.getStyleById(2);
		System.out.println(style);
		Assert.assertNotNull(style);
	}

}
