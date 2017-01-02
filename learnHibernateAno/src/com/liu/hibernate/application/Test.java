package com.liu.hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.liu.hibernate.beans.CourseTemplateType;
import com.liu.hibernate.beans.Enrollment;
import com.liu.hibernate.beans.Evaluation;
import com.liu.hibernate.beans.Major;
import com.liu.hibernate.beans.Student;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Student e = session.get(Student.class, 101);
		System.out.println(e.getRegisterations());
		
		session.close();
		sf.close();
	}

}
