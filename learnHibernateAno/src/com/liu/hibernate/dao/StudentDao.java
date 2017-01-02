package com.liu.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.liu.hibernate.beans.Student;

public class StudentDao {
	private Session session;

	public StudentDao(Session session) {
		this.session = session;
	}
	
	public List<Student> listAllStudent(){
		Query<Student> query = session.createQuery("from Student", Student.class);
		return query.getResultList();
	}
	
	public List<Student> listStudentByName(String name){
		Query<Student> query = session.createQuery("from Student where firstname like :name or lastname like:name",Student.class);
		query.setParameter("name","%"+name+"%");
		return query.getResultList();
	}
	
	public Student getStudentById(int id){
		Student student = session.get(Student.class, id);
		return student;
	}
	
}
