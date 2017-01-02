package com.liu.productHibernate.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "product_style")
@Entity
public class ProductStyle implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "style_id")
	private Style style;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;


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
		return "ProductStyle [styleId=" + style.getId() + ", productId=" + product.getId() + "]";
	}

	
}
