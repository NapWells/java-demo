package com.liu.productMybais.dao;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.liu.productMybatis.beans.Brand;
import com.liu.productMybatis.beans.Product;
import com.liu.productMybatis.beans.ProductBrand;
import com.liu.productMybatis.beans.Style;
import com.liu.productMybatis.beans.SubTag;
import com.liu.productMybatis.beans.Tag;


public class ProductDaoTest {

	ProductDao dao = new ProductDao();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

//	@Test
//	public void testGetTagById() {
//		Tag tag = dao.getTagById(1);
//		System.out.println(tag);
//		for(SubTag st: tag.getSubTags())
//			System.out.println(st);
//		Assert.assertNotNull(tag);
//	}
//
//	@Test
//	public void testGetBrandById() {
//		Brand tag = dao.getBrandById(1);
//		System.out.println(tag);
//		Assert.assertNotNull(tag);
//	}
//
//	@Test
//	public void testGetStyleById() {
//		Style tag = dao.getStyleById(1);
//		System.out.println(tag);
//		Assert.assertNotNull(tag);
//	}
//
//	@Test
//	public void testGetProductById() {
//		Product product = dao.getProductById(1);
//		System.out.println(product);
//		System.out.println(product.getSubTag());
//		for(ProductBrand pb : product.getProductBrands())
//			System.out.println(pb);
//		Assert.assertNotNull(product);
//	}

	@Test
	public void testGetSubTagById() {
		SubTag tag = dao.getSubTagById(1);
		System.out.println(tag);
		for(Product p : tag.getProducts())
			System.out.println(p);
		System.out.println(tag.getProducts().size());
		Assert.assertNotNull(tag);
	}

}
