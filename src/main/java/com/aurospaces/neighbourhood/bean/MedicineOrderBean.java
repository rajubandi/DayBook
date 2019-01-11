/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.stereotype.Component;

/**
 * @author Amit
 * 
 */
@Component
public class MedicineOrderBean {
	public String orderId;
	public String medicineName;
	public String dosage;
	public String brand;
	public String quantity;
	public String typeId;
	public String mrp;
	public String discount;
	public String netAmount;
	public String customerName;
	public int pharmaorderdetailsId;
	public double totalQty;
	public double totalDiscount;
	public double totalNetAmount;
	public String conformationId;
	public String status;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}

	/**
	 * @param medicineName
	 *            the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @param dosage
	 *            the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId
	 *            the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the mrp
	 */
	public String getMrp() {
		return mrp;
	}

	/**
	 * @param mrp
	 *            the mrp to set
	 */
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * @return the netAmount
	 */
	public String getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount
	 *            the netAmount to set
	 */
	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the pharmaorderdetailsId
	 */
	public int getPharmaorderdetailsId() {
		return pharmaorderdetailsId;
	}

	/**
	 * @param pharmaorderdetailsId
	 *            the pharmaorderdetailsId to set
	 */
	public void setPharmaorderdetailsId(int pharmaorderdetailsId) {
		this.pharmaorderdetailsId = pharmaorderdetailsId;
	}

	/**
	 * @return the totalQty
	 */
	public double getTotalQty() {
		return totalQty;
	}

	/**
	 * @param totalQty
	 *            the totalQty to set
	 */
	public void setTotalQty(double totalQty) {
		this.totalQty = totalQty;
	}

	/**
	 * @return the totalDiscount
	 */
	public double getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * @param totalDiscount
	 *            the totalDiscount to set
	 */
	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * @return the totalNetAmount
	 */
	public double getTotalNetAmount() {
		return totalNetAmount;
	}

	/**
	 * @param totalNetAmount
	 *            the totalNetAmount to set
	 */
	public void setTotalNetAmount(double totalNetAmount) {
		this.totalNetAmount = totalNetAmount;
	}

	/**
	 * @return the conformationId
	 */
	public String getConformationId() {
		return conformationId;
	}

	/**
	 * @param conformationId
	 *            the conformationId to set
	 */
	public void setConformationId(String conformationId) {
		this.conformationId = conformationId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
