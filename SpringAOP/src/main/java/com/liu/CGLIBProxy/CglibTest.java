package com.liu.CGLIBProxy;

import org.junit.Test;

public class CglibTest {
	@Test
	public void test1(){
		ProductDao productDao = new ProductDao();
		productDao.add();
		productDao.update();
	}
	
	@Test
	public void test2(){
		ProductDao productDao = new ProductDao();
		CGLIBProxy cglibProxy = new CGLIBProxy(productDao);
		ProductDao proxy = cglibProxy.createProxy();
		proxy.add();
		proxy.update();
	}
}
