package com.liu.hibernate.application;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.liu.hibernate.beans.Student;

public class ProdectionDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria criteria = session.createCriteria(Student.class);
		
		ProjectionList projectList = Projections.projectionList();
		projectList.add(Projections.countDistinct("id"));
		projectList.add(Projections.max("phone"));
		projectList.add(Projections.groupProperty("gender"));
		
		criteria.setProjection(projectList);
		List list = criteria.list();
		
		for(Object obj : list)
			System.out.println(Arrays.deepToString((Object[]) obj));
		
		session.close();
		sf.close();
	}

}
