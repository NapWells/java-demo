package com.liu.learnMybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.learnMybatis.pojo.Student;

public class ManyToOne {
	public static void main( String[] args ){
		String resource = "mybatis_conf.xml";
    	InputStream is = OneToMany.class.getClassLoader().getResourceAsStream(resource);
    	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
    	
    	SqlSession session = sessionFactory.openSession();
    	String st = "com.liu.learnMybatis.mapping.clazzMapper.selectStudentsClazz";
    	List<Student> students = session.selectList(st, 1);
    	for(Student student : students)
    		System.out.println(student);
    	session.close();
    }
}
