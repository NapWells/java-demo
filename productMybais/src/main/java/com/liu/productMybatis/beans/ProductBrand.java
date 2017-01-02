package com.liu.productMybatis.beans;



public class ProductBrand {

	private int brandId;
	private Brand brand;
	
	private int productId;
	private Product product;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductBrand [brandId=" + brandId + ", productId=" + productId + "]";
	}

	
	
}
