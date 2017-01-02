package com.liu.productHibernate.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "product")
@Entity
public class Product {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "img_url")
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name = "sub_tag_id")
	private SubTag subTag;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<ProductBrand> productBrands;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<ProductStyle> productStyles;

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

	public Set<ProductBrand> getProductBrands() {
		return productBrands;
	}

	public void setProductBrands(Set<ProductBrand> productBrands) {
		this.productBrands = productBrands;
	}

	public Set<ProductStyle> getProductStyles() {
		return productStyles;
	}

	public void setProductStyles(Set<ProductStyle> productStyles) {
		this.productStyles = productStyles;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", note=" + note + ", imgUrl=" + imgUrl + ", subTagId=" + subTag.getId()
				+ "]";
	}
	
	
}
