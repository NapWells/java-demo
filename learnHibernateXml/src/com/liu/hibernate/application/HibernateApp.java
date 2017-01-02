package com.liu.hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.liu.hibernate.beans.Student;
import com.liu.hibernate.beans.StudentStatus;
import com.liu.hibernate.dao.StudentDao;

public class HibernateApp {
	public static void main(String [] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
	
//		//OneToOne
		StudentDao dao = new StudentDao(session);
		
		Student student = dao.getStudentByIid(100);
			
		System.out.println("Student:" + student);
		System.out.println("Student login : " + student.getLogin());
		
		
//		ManyToOne
		StudentStatus status = session.get(StudentStatus.class,110);
		System.out.println(status);
		System.out.println(status.getStudents().size());
		

		session.close();
		
	}
}
