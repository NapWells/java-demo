package com.liu.hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.liu.hibernate.beans.Accommodation;
import com.liu.hibernate.beans.Apartment;
import com.liu.hibernate.beans.Student;
import com.liu.hibernate.beans.StudentStatus;
import com.liu.hibernate.beans.Teacher;
import com.liu.hibernate.dao.StudentDao;

public class HibernateApp {
	public static void main(String [] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
	
		System.out.println("====================OneToOne====================");
		StudentDao dao = new StudentDao(session);
		Student student = dao.getStudentById(100);
			
		System.out.println("Student:" + student);
		System.out.println("Student login : " + student.getLogin());
		
		
		System.out.println("====================ManyToOne====================");
		StudentStatus status = session.get(StudentStatus.class,110);
		System.out.println(status);
		System.out.println("status size:"+status.getStudents().size());
		
		System.out.println("====================ManyToMany====================");
		System.out.println("student's teachers :" + student.getTeachers().size());
		Teacher teacher = session.get(Teacher.class, 1);
		System.out.println("teacher:" + teacher);
		System.out.println("teacher's student:" + teacher.getStudents().size());
		
		session.close();
		
	}
}
