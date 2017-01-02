package com.liu.learnMybatis;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.learnMybatis.pojo.Student;
import com.liu.learnMybatis.pojo.Teacher;

public class SearchApp {
    public static void main( String[] args ){
    	String resource = "mybatis_conf.xml";
    	InputStream is = SearchApp.class.getClassLoader().getResourceAsStream(resource);
    	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
    	
    	SqlSession session = sessionFactory.openSession();
    	
    	System.out.println("-----------------(1)-----------------");
    	String statement = "com.liu.learnMybatis.mapping.studentMapper.getAllStudents";
    	List<Student> users = session.selectList(statement);
    	for(Student user : users)
    		System.out.println(user);
    	
    	System.out.println("-----------------(2)-----------------");
    	statement = "com.liu.learnMybatis.mapping.studentMapper.getStudentById";
    	Student user = session.selectOne(statement,1);
    	System.out.println(user);
    	
    	System.out.println("\n-----------------(3)-----------------");
    	statement = "com.liu.learnMybatis.mapping.teacherMapper.getAllTeachers";
    	List<Teacher> teachers = session.selectList(statement);
    	for(Teacher t : teachers)
    		System.out.println(t);
    	
    	System.out.println("\n-----------------(4)-----------------");
    	statement = "com.liu.learnMybatis.mapping.teacherMapper.getTeacherById";
    	Teacher teacher = session.selectOne(statement,2);
    	System.out.println(teacher);
    	
    	System.out.println("\n-----------------(5)-----------------");
    	statement = "com.liu.learnMybatis.mapping.studentMapper.getStudentAttrMapById";
    	Map<String,Object> students = session.selectOne(statement, 1);
    	for(String key : students.keySet())
    		System.out.println("key = " + key + " ,value = " + students.get(key) + ",vt = " + students.get(key).getClass().getSimpleName());
    	
    	session.close();
    }
}
