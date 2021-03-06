package com.liu.advisorTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.advisor.CustomerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class AdvisorTest {
	@Autowired
	//@Qualifier("customerDao")注入的是真实对象，必须注入代理对象
	@Qualifier("customerDaoProxy")
	private CustomerDao customerDao;
	
	@Test
	public void demo1(){
		customerDao.add();
		customerDao.update();
		customerDao.delete();;
		customerDao.search();
	}
}	
