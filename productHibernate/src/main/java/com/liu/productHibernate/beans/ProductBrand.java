package com.liu.productHibernate.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "product_brand")
@Entity
public class ProductBrand implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

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
		return "ProductBrand [brandId=" + brand.getId() + ", productId=" + product.getId() + "]";
	}
	
	
}
