package com.liu.SpringAspectJTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.springAspectJ.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest1 {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Test
	public void demo1(){
		userDao.add();
		userDao.delete();
		userDao.update();
		userDao.search();
	}
}
