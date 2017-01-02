package com.liu.hibernate.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;

import com.liu.hibernate.beans.Student;

public class CriteriaDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		System.out.println("===========criteria===========");
		Criteria criteria = session.createCriteria(Student.class);
		List students = criteria.list();
		for(Object obj : students){
			System.out.println(obj);
		}
		
		
		System.out.println("===========Detached criteria===========");
		DetachedCriteria c = DetachedCriteria.forClass(Student.class);
		Criteria cc = c.getExecutableCriteria(session);
		List stus = cc.list();
		for(Object obj : stus){
			System.out.println(obj);
		}
		
	}

}
