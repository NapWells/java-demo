package com.liu.productHibernate.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name = "style")
@Entity
public class Style {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "note")
	private String note;
	
	@OneToMany(mappedBy = "style", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
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


	public Set<ProductStyle> getProductStyles() {
		return productStyles;
	}

	public void setProductStyles(Set<ProductStyle> productStyles) {
		this.productStyles = productStyles;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", name=" + name + ", note=" + note + "]";
	}
	
	
}
