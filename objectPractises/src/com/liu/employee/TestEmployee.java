package com.liu.employee;

public class TestEmployee {
	public static void main(String [] args){
		Employee e = new Employee(1,"liu","haoyu",1000);
		System.out.println(e);
		e.raiseSalary(4);
		System.out.println(e);
	}
}
