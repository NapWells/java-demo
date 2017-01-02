package com.liu.learnMybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.learnMybatis.pojo.Student;
public class OneToMany {
	public static void main( String[] args ){
		String resource = "mybatis_conf.xml";
    	InputStream is = OneToMany.class.getClassLoader().getResourceAsStream(resource);
    	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
    	
    	SqlSession session = sessionFactory.openSession();
    	String st = "com.liu.learnMybatis.mapping.studentMapper.getStudentById";
    	Student student = session.selectOne(st,1);
    	System.out.println(student);
    	System.out.println(student.getClazz());
    	session.close();
    	
    }
}
