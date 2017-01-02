package com.liu.learnMybatis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CallSP {

	public static void main(String[] args) {
		String resource = "mybatis_conf.xml";
		InputStream is = OneToMany.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		
		String statement = "com.liu.learnMybatis.mapping.studentMapper.callSPtest";
		Map<String,Object> map = new HashMap<>();
		map.put("addend1", 2);
		map.put("addend2", 5);
		session.update(statement,map);
		System.out.println(map.get("thesum"));
	}

}
