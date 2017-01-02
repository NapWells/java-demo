package com.liu.learnMybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.learnMybatis.pojo.Student;

public class I_U_D_App {
	 public static void main( String[] args ){
	    	String resource = "mybatis_conf.xml";
	    	InputStream is = SearchApp.class.getClassLoader().getResourceAsStream(resource);
	    	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	    	
	    	SqlSession session = sessionFactory.openSession();
	    	
	    	System.out.println("-----------------(1)插入-----------------");
	    	Student student = new Student();
	    	student.setName("刘浩宇");
	    	student.setUsername("lhy");
	    	student.setPassword("123456");
	    	String statement = "com.liu.learnMybatis.mapping.studentMapper.insertStudent";
	    	System.out.println("insert before = "+ student);
	    	int count = session.insert(statement, student);
	    	System.out.println("insert count = " + count);
	    	System.out.println("insert after = "+ student);
	    	session.commit();
	    	
	    	System.out.println("\n-----------------(2)更新-----------------");
	    	student.setPassword("qazwsx");
	    	statement = "com.liu.learnMybatis.mapping.studentMapper.updateStudent";
	    	count = session.update(statement, student);
	    	System.out.println("update count = " + count);
	    	System.out.println("update after = "+ student);
	    	session.commit();
	    	
	    	System.out.println("\n-----------------(3)删除-----------------");
	    	statement = "com.liu.learnMybatis.mapping.studentMapper.deleteStudent";
	    	count = session.delete(statement, student);
	    	System.out.println("delete count = " + count);
	    	System.out.println("delete after = "+ student);
	    	session.commit();
	    	
	    	session.close();
	 }
}
