package com.aurospace.nbd.model;

import com.google.gson.annotations.SerializedName;

public class PathologyModel {

	@SerializedName("test_id")
	private long testId;

	@SerializedName("test_name")
	private String testName;

	@SerializedName("test_desc")
	private String testDesc;

	@SerializedName("test_category")
	private String testCategory;

	@SerializedName("test_vendor")
	private String testVendor;

	@SerializedName("total_price")
	private double totalPrice;

	@SerializedName("discount_percent")
	private int discountPercent;

	@SerializedName("calculated_price")
	private double calculatedPrice;

	// private boolean isSelected;

	public PathologyModel(long testId, String testName, String testDesc,
			String testCategory, String testVendor, double totalPrice,
			int discountPercent, double calculatedPrice) {
		this.testId = testId;
		this.testName = testName;
		this.testDesc = testDesc;
		this.testCategory = testCategory;
		this.testVendor = testVendor;
		this.totalPrice = totalPrice;
		this.discountPercent = discountPercent;
		this.calculatedPrice = calculatedPrice;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDesc() {
		return testDesc;
	}

	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}

	public String getTestCategory() {
		return testCategory;
	}

	public void setTestCategory(String testCategory) {
		this.testCategory = testCategory;
	}

	public String getTestVendor() {
		return testVendor;
	}

	public void setTestVendor(String testVendor) {
		this.testVendor = testVendor;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getCalculatedPrice() {
		return calculatedPrice;
	}

	public void setCalculatedPrice(double calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}
	//
	// public boolean isSelected() {
	// return isSelected;
	// }
	//
	// public void setSelected(boolean isSelected) {
	// this.isSelected = isSelected;
	// }

}
