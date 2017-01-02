package com.liu.CGLIBProxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLIBProxy{

	private ProductDao productDao;
	public CGLIBProxy(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	public ProductDao createProxy(){
		//使用生成代理
		//1.创建核心类
		Enhancer enhancer = new Enhancer();
		//2.为其设置父类
		enhancer.setSuperclass(productDao.getClass());
		//3.设置回掉
		enhancer.setCallback(new MethodInterceptor(){
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				if("add".equals(method.getName())){
					System.out.println("do something else....");
					return methodProxy.invokeSuper(proxy, args);
				}
				return methodProxy.invokeSuper(proxy, args);
			}
		});
		//4.创建代理
		return (ProductDao) enhancer.create();
	}
	
}
