package com.liu.hibernate.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.liu.hibernate.beans.Student;

public class RistrictionsDemo {
	public static void main(String [] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria criteria = session.createCriteria(Student.class);
		
//		criteria.add(Restrictions.eq("gender", "ÄÐ"));
//		criteria.add(Restrictions.eq("lastname", "ÕÅ"));
//		List students = criteria.list();
//		for(Object obj : students)
//			System.out.println(obj);
		
//		Map<String,Object> params = new HashMap<>();
//		params.put("gender", "ÄÐ");
//		params.put("lastname", "ÕÅ");
//		
//		criteria.add(Restrictions.allEq(params));
//		List students = criteria.list();
//		for(Object obj : students)
//			System.out.println(obj);
		
		criteria.add(Restrictions.gt("phone", "1102313131"));
		List students = criteria.list();
		for(Object obj : students)
			System.out.println(obj);
		session.close();
		sf.close();
	}
}
