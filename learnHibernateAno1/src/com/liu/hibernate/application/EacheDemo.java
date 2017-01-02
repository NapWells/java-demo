package com.liu.hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.liu.hibernate.beans.StudentStatus;

public class EacheDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		StudentStatus stat = session.get(StudentStatus.class, 111);
		System.out.println(stat);
		
		session.clear();
		stat = session.get(StudentStatus.class, 111);
		System.out.println(stat);
		
		session.close();
		sf.close();
	}

}
