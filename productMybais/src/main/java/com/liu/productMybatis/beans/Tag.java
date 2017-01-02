package com.liu.productMybatis.beans;

import java.util.List;


public class Tag {
	private int id;
	
	private String name;
	
	private int rank;
	
	private List<SubTag> subTags;

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
	public List<SubTag> getSubTags() {
		return subTags;
	}

	public void setSubTags(List<SubTag> subTags) {
		this.subTags = subTags;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}
}

	
