package com.aurospace.nbd.model;

import com.google.gson.annotations.SerializedName;

public class SubCategory {

	@SerializedName("id")
	private long id;

	@SerializedName("image")
	private String url;

	@SerializedName("name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
