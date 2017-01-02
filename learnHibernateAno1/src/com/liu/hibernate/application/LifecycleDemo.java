package com.liu.hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.liu.hibernate.beans.StudentStatus;

public class LifecycleDemo {
	public static void main(String [] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
//		//触发onLoad
//		StudentStatus stat = session.get(StudentStatus.class, 110);
//		System.out.println(stat);
		
//		//触发onUpdate
//		StudentStatus stat = new StudentStatus();
//		stat.setId(112);
//		session.update(stat);
//		
//		session.clear();
//		session.update(stat);
		
//		StudentStatus stat2 = new StudentStatus();
//		stat2.setId(117);
//		stat2.setCode("new_avtive");
//		stat2.setName("new_active");
//		stat2.setDescription("new_active");
//		Transaction tx = session.beginTransaction();
//		//触发onSave
//		session.save(stat2);
//		tx.commit();
//		
//		
//		//触发onDelete
//		tx = session.beginTransaction();
//		session.delete(stat2);
//		tx.commit();
		
		sf.close();
	}
}
