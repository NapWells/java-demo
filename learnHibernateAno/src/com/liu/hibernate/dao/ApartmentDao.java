package com.liu.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.liu.hibernate.beans.Apartment;

public class ApartmentDao {
	private Session session;

	public ApartmentDao(Session session) {
		super();
		this.session = session;
	}
	
	public List<Apartment> listAllAparment(){
		Query<Apartment> query = session.createQuery("from Apartment",Apartment.class);
		return query.getResultList();
	}
	
}
