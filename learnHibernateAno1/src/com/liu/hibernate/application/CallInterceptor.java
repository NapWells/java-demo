package com.liu.hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.liu.hibernate.beans.StudentStatus;
import com.liu.hibernate.interceptor.Interceptor1;

public class CallInterceptor {
	public static void main(String [] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.withOptions()
				.interceptor(new Interceptor1())
				.openSession();
		StudentStatus stat = session.get(StudentStatus.class, 113);
		System.out.println(stat);
	}
}
