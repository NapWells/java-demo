package com.liu.hibernate.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.liu.hibernate.beans.Student;

public class JunctionDemo {
	public static void main(String [] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Property gender = Property.forName("gender");
		Property lastname = Property.forName("lastname");
		
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.conjunction().add(gender.eq("ÄÐ")).add(lastname.like("ÕÅ")));
		
		List <Student> students = criteria.list();
		for(Object obj : students){
			System.out.println(obj);
		}
	}
}
