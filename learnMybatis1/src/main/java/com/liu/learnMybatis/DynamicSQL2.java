package com.liu.learnMybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.learnMybatis.pojo.Student;

public class DynamicSQL2 {
	public static void main(String [] args){

		String resource = "mybatis_conf.xml";
		InputStream is = OneToMany.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = sessionFactory.openSession();
		
		System.out.println("-----------------1-----------------");
		Student search = new Student();
		getStudentByConditions(session, search);
		
		System.out.println("\n----------------2------------------");
		search.setName("");
		getStudentByConditions(session, search);
		
		System.out.println("\n----------------3------------------");
		search.setName("%宇%");
		getStudentByConditions(session, search);
		
		System.out.println("\n-----------------4-----------------");
		search.setClassId(2);
		getStudentByConditions(session, search);//where class_id = 2 不会执行到
	}
	
	public static void getStudentByConditions(SqlSession session,Student search){
		String st = "com.liu.learnMybatis.mapping.studentMapper.getStudentByConditions";
		List<Student> students = session.selectList(st,search);
		for(Student student	: students){
			System.out.println(student);
		}
	}
}
