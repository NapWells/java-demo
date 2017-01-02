package com.liu.springAspectJ;

public class UserDao {
	public void add(){
		System.out.println("添加用户.....");
	}
	public void update(){
		System.out.println("更新用户.....");

	}
	public int delete(){
		System.out.println("删除用户.....");
		return 1;
	}
	public void search(){
		System.out.println("查找用户.....");
		int a = 1/0;
	}
}
