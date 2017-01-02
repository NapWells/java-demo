package com.liu.productMybatis.beans;



public class ProductStyle{

	private int styleId;
	private Style style;
	
	private int productId;
	private Product product;


	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductStyle [styleId=" + styleId + ", productId=" + productId + "]";
	}


	
}
