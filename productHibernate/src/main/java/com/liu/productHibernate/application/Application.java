package com.liu.productHibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.liu.productHibernate.beans.Brand;
import com.liu.productHibernate.beans.ProductBrand;

public class Application {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Brand brand = session.get(Brand.class, 1);
		System.out.println(brand);
		for(ProductBrand pb : brand.getProductBrands())
			System.out.println(pb);
	}
}
