package com.liu.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.liu.hibernate.beans.AcademyYear;

public class AcademyYearDao {
	private Session session;

	public AcademyYearDao(Session session) {
		this.session = session;
	}
	
	public List<AcademyYear> listAllAcademyYear(){
		Query<AcademyYear> query = session.createQuery("from AcademyYear",AcademyYear.class);
		return query.getResultList();
	}
}	
