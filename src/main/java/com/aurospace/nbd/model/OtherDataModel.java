package com.aurospace.nbd.model;

import com.google.gson.annotations.SerializedName;

public class OtherDataModel {

	@SerializedName("module_name")
	private String subCategoryName;

	@SerializedName("other_booking")
	private OtherBooking otherBooking;

	@SerializedName("payment_mode")
	private String paymentMode;

	@SerializedName("is_payment_done")
	private boolean isPaymentDone;

	public OtherDataModel(String subCategoryName, OtherBooking otherBooking,
			String paymentMode, boolean isPaymentDone) {
		this.subCategoryName = subCategoryName;
		this.otherBooking = otherBooking;
		this.paymentMode = paymentMode;
		this.isPaymentDone = isPaymentDone;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public OtherBooking getOtherBooking() {
		return otherBooking;
	}

	public void setOtherBooking(OtherBooking otherBooking) {
		this.otherBooking = otherBooking;
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
