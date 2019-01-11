package com.aurospace.nbd.model;

import com.google.gson.annotations.SerializedName;

public class PathologyDataModel {

	@SerializedName("module_name")
	private String subCategoryName;

	@SerializedName("pathology_booking")
	private PathologyBooking pathologyBooking;

	@SerializedName("payment_mode")
	private String paymentMode;

	@SerializedName("is_payment_done")
	private boolean isPaymentDone;

	public PathologyDataModel(String subCategoryName,
			PathologyBooking pathologyBooking, String paymentMode,
			boolean isPaymentDone) {
		this.subCategoryName = subCategoryName;
		this.pathologyBooking = pathologyBooking;
		this.paymentMode = paymentMode;
		this.isPaymentDone = isPaymentDone;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public PathologyBooking getPathologyBooking() {
		return pathologyBooking;
	}

	public void setPathologyBooking(PathologyBooking pathologyBooking) {
		this.pathologyBooking = pathologyBooking;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public boolean isPaymentDone() {
		return isPaymentDone;
	}

	public void setPaymentDone(boolean isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

}
