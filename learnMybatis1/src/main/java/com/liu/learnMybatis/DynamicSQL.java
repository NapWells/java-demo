package com.liu.learnMybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.learnMybatis.pojo.Student;

public class DynamicSQL {
	public static void main(String [] args){

		String resource = "mybatis_conf.xml";
		InputStream is = OneToMany.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = sessionFactory.openSession();
		
		Student search = new Student();
		getStudentNameLike(session, search);
		
		System.out.println("\n----------------------------------");
		search.setName("");
		getStudentNameLike(session, search);
		
		System.out.println("\n----------------------------------");
		search.setName("%宇%");
		getStudentNameLike(session, search);
	}
	
	public static void getStudentNameLike(SqlSession session,Student search){
		String st = "com.liu.learnMybatis.mapping.studentMapper.getStudentNameLike";
		List<Student> students = session.selectList(st,search);
		for(Student student	: students){
			System.out.println(student);
		}
	}
	
}
