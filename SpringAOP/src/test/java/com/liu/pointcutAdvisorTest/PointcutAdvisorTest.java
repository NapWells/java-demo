package com.liu.pointcutAdvisorTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.pointcutAdvisor.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class PointcutAdvisorTest {
	@Autowired
	@Qualifier("orderDaoProxy")
	private OrderDao orderDao;
	
	@Test
	public void demo1(){
		orderDao.add();
		orderDao.update();
		orderDao.delete();
		orderDao.search();
	}
}
