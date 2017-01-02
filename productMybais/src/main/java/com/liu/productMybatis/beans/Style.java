package com.liu.productMybatis.beans;

import java.util.List;
public class Style {
	private int id;
	
	private String name;
	
	private String note;
	
	private List<ProductStyle> productStyles;

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

	public List<ProductStyle> getProductStyles() {
		return productStyles;
	}

	public void setProductStyles(List<ProductStyle> productStyles) {
		this.productStyles = productStyles;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", name=" + name + ", note=" + note + "]";
	}

	
	
}
