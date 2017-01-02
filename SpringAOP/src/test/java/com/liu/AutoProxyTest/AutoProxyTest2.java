package com.liu.AutoProxyTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.advisor.CustomerDao;
import com.liu.pointcutAdvisor.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext3.xml")
public class AutoProxyTest2 {

	@Autowired
	@Qualifier(value="customerDao")
	private CustomerDao customerDao;
	
	@Autowired
	@Qualifier(value="orderDao")
	private OrderDao orderDao;
	
	@Test    //	DefaultAdvisorAutoProxyCreator
	public void autoProxyTest(){
//		customerDao.add();
//		customerDao.update();
//		customerDao.delete();
//		customerDao.search();
//		
		orderDao.add();
		orderDao.delete();
		orderDao.search();
		orderDao.search();
	}

}
