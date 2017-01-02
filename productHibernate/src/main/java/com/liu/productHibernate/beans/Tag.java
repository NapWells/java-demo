package com.liu.productHibernate.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tag")
@Entity
public class Tag {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rank")
	private int rank;
	
	@OneToMany(mappedBy = "tag",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<SubTag> subTags;

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


	public Set<SubTag> getSubTags() {
		return subTags;
	}

	public void setSubTags(Set<SubTag> subTags) {
		this.subTags = subTags;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}
}
