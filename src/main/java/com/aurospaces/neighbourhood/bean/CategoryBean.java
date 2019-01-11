package com.aurospaces.neighbourhood.bean;

import java.util.List;

public class CategoryBean {

	private String categoryId;
	private String categoryDesc;
	private String categoryName;
	private String sMsg;
	private List<ServicesBean> listServicesBeans;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ServicesBean> getListServicesBeans() {
		return listServicesBeans;
	}

	public void setListServicesBeans(List<ServicesBean> listServicesBeans) {
		this.listServicesBeans = listServicesBeans;
	}

	public String getsMsg() {
		return sMsg;
	}

	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}