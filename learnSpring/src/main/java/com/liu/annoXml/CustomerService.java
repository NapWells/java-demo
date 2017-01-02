package com.liu.annoXml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CustomerService {
	@Autowired
	@Qualifier(value="customerDao")
	private CustomerDao customerDao;
	
	@Autowired
	@Qualifier(value="orderDao")
	private OrderDao orderDao;
	
	@Override
	public String toString() {
		return "CustomerService [customerDao=" + customerDao + ", orderDao=" + orderDao + "]";
	}
}
