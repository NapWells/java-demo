package com.liu.productMybatis.beans;

import java.util.List;

public class Brand {
	private int id;
	private String name;
	private int rank;
	private List<ProductBrand> productBrands;

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

	public List<ProductBrand> getProductBrands() {
		return productBrands;
	}

	public void setProductBrands(List<ProductBrand> productBrands) {
		this.productBrands = productBrands;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}

	
	
	
}
