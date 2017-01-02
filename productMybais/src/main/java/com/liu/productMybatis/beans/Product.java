package com.liu.productMybatis.beans;

import java.util.List;


public class Product {
	private int id;
	
	private String name;
	
	private String note;
	
	private String imgUrl;
	
	private int subTagId;
	private SubTag subTag;
	
	private List<ProductBrand> productBrands;
	
	private List<ProductStyle> productStyles;

	public int getSubTagId() {
		return subTagId;
	}

	public void setSubTagId(int subTagId) {
		this.subTagId = subTagId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public SubTag getSubTag() {
		return subTag;
	}

	public void setSubTag(SubTag subTag) {
		this.subTag = subTag;
	}
	public List<ProductBrand> getProductBrands() {
		return productBrands;
	}

	public void setProductBrands(List<ProductBrand> productBrands) {
		this.productBrands = productBrands;
	}

	public List<ProductStyle> getProductStyles() {
		return productStyles;
	}

	public void setProductStyles(List<ProductStyle> productStyles) {
		this.productStyles = productStyles;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", note=" + note + ", imgUrl=" + imgUrl + ", subTagId="
				+ subTagId + "]";
	}

	
}
