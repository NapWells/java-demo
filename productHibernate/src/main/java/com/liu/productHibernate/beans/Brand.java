package com.liu.productHibernate.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "brand")
@Entity
public class Brand {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rank")
	private int rank;
	
	@OneToMany(mappedBy = "brand",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<ProductBrand> productBrands;

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


	public Set<ProductBrand> getProductBrands() {
		return productBrands;
	}

	public void setProductBrands(Set<ProductBrand> productBrands) {
		this.productBrands = productBrands;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", rank=" + rank +  "]";
	}
	
	
	
}
