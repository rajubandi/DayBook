package com.aurospace.nbd.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Category {

	@SerializedName("id")
	private long id;

	@SerializedName("serviceList")
	private List<SubCategory> categoryList;

	

	@SerializedName("description")
	private String description;

	@SerializedName("image")
	private String image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<SubCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<SubCategory> categoryList) {
		this.categoryList = categoryList;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
