package com.liu.hibernate.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.liu.hibernate.beans.Student;

public class ExampleDemo {
	public static void main(String [] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Student st = new Student();
		st.setLastname("ÕÅ");
		st.setGender("ÄÐ");
		
		Example studentExample = Example.create(st);
		studentExample.excludeZeroes();
		
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(studentExample);
		
		List<Student> students = criteria.list();
		
		for(Object o : students){
			System.out.println(o);
		}
	}
}
