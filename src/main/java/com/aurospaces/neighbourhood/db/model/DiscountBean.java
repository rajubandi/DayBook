package com.aurospaces.neighbourhood.db.model;

public class DiscountBean {
	int sCustomerDiscount;
	int NoOfcustomers;
	int existingCustomerDiscount;
	
	public int getExistingCustomerDiscount() {
		return existingCustomerDiscount;
	}
	public void setExistingCustomerDiscount(int existingCustomerDiscount) {
		this.existingCustomerDiscount = existingCustomerDiscount;
	}
	public int getsCustomerDiscount() {
		return sCustomerDiscount;
	}
	public void setsCustomerDiscount(int sCustomerDiscount) {
		this.sCustomerDiscount = sCustomerDiscount;
	}
	public int getNoOfcustomers() {
		return NoOfcustomers;
	}
	public void setNoOfcustomers(int noOfcustomers) {
		NoOfcustomers = noOfcustomers;
	}
}
