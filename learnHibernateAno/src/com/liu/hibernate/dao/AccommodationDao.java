package com.liu.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.liu.hibernate.beans.Accommodation;

public class AccommodationDao {
	private Session session;

	public AccommodationDao(Session session) {
		this.session = session;
	}
	
	public List<Accommodation> listAllAccommodation(){
		Query<Accommodation> query = session.createQuery("from Accommodation",Accommodation.class);
		return query.getResultList();
	}
	
}
