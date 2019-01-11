package com.aurospace.nbd.model;

import com.google.gson.annotations.SerializedName;

public class DoctorTypeModel {

	@SerializedName("doctor_type_id")
	private String id;

	@SerializedName("doctor_type_name")
	private String categoryName;

	@SerializedName("doctor_type_icon")
	private String categoryResId;

	@SerializedName("doctor_base_price")
	private String totalPrice;

	@SerializedName("doctor_discount")
	private String discountPercentage;

	@SerializedName("doctor_total_price")
	private String calculatedPrice;

	//
	// public DoctorTypeModel(String categoryName, int categoryResId) {
	// this.categoryName = categoryName;
	// this.categoryResId = categoryResId;
	// }

	public DoctorTypeModel(String categoryName, String totalPrice,
			String discountPercentage, String calculatedPrice) {
		this.categoryName = categoryName;
		this.totalPrice = totalPrice;
		this.discountPercentage = discountPercentage;
		this.calculatedPrice = calculatedPrice;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryResId() {
		return categoryResId;
	}

	public void setCategoryResId(String categoryResId) {
		this.categoryResId = categoryResId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public String getCalculatedPrice() {
		return calculatedPrice;
	}

	public void setCalculatedPrice(String calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}

}
