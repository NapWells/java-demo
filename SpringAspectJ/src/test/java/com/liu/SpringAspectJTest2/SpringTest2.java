package com.liu.SpringAspectJTest2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.springAspectJ2.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext2.xml")
public class SpringTest2 {
	@Autowired
	@Qualifier("productDao")
	private ProductDao productDao;
	
	@Test
	public void demo(){
		productDao.add();
		productDao.delete();
		productDao.update();
		productDao.search();
	}
}
