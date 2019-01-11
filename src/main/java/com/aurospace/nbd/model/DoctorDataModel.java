package com.aurospace.nbd.model;

import com.google.gson.annotations.SerializedName;

public class DoctorDataModel {

	@SerializedName("module_name")
	private String subCategoryName;

	@SerializedName("doctor_booking")
	private DoctorBooking doctorBooking;

	@SerializedName("payment_mode")
	private String paymentMode;

	@SerializedName("is_payment_done")
	private boolean isPaymentDone;

	public DoctorDataModel(String subCategoryName, DoctorBooking doctorBooking,
			String paymentMode, boolean isPaymentDone) {
		this.subCategoryName = subCategoryName;
		this.doctorBooking = doctorBooking;
		this.paymentMode = paymentMode;
		this.isPaymentDone = isPaymentDone;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public DoctorBooking getDoctorBooking() {
		return doctorBooking;
	}

	public void setDoctorBooking(DoctorBooking doctorBooking) {
		this.doctorBooking = doctorBooking;
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
