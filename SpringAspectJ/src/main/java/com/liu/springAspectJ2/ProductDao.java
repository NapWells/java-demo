package com.liu.springAspectJ2;

public class ProductDao {
	public int add(){
		System.out.println("添加商品");
		return 123;
	}
	public void delete(){
		System.out.println("删除商品");
	}
	public void update(){
		System.out.println("更新商品");
//		int a = 10/0;
	}
	public void search(){
		System.out.println("查找商品");
	}
}
