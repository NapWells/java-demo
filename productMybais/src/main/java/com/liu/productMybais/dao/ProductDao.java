package com.liu.productMybais.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.liu.productMybais.db.DBAccess;
import com.liu.productMybatis.beans.Brand;
import com.liu.productMybatis.beans.Product;
import com.liu.productMybatis.beans.Style;
import com.liu.productMybatis.beans.SubTag;
import com.liu.productMybatis.beans.Tag;

public class ProductDao {
	public Tag getTagById(int id){
		DBAccess dbAccess = new DBAccess();
		Tag tag = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String s = "TagMapper.selectTagById";
			tag = sqlSession.selectOne(s,id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return tag;
	}
	
	
	public Brand getBrandById(int id){
		DBAccess dbAccess = new DBAccess();
		Brand brand = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			brand = sqlSession.selectOne("BrandMapper.selectBrandById",id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return brand;
	}
	
	
	public Style getStyleById(int id){
		DBAccess dbAccess = new DBAccess();
		Style style = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			style = sqlSession.selectOne("StyleMapper.selectStyleById",id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return style;
	}
	
	public Product getProductById(int id){
		DBAccess dbAccess = new DBAccess();
		Product product = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			product = sqlSession.selectOne("ProductMapper.selectProductById",id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return product;
	}
	
	public SubTag getSubTagById(int id){
		DBAccess dbAccess = new DBAccess();
		SubTag subTag = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			subTag = sqlSession.selectOne("SubTagMapper.selectSubTagById",id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return subTag;
	}
}
