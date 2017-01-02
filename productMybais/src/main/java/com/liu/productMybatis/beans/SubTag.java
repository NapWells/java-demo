package com.liu.productMybatis.beans;

import java.util.List;


public class SubTag {
	private int id;
	
	private String name;
	
	private int rank;
	
	private int tagId;
	private Tag tag;

	private List<Product> products;
	
	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "SubTag [id=" + id + ", name=" + name + ", rank=" + rank + ", tagId=" + tagId + "]";
	}

	
	
}
