/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author kanojia
 * 
 */
@Component
public class MedicineBean {
	public String medicineName;
	public String dosage;
	public String brand;
	public String quantity;
	public String orderId;
	public String orderDate;
	public String totalQty;
	public String totalDiscount;
	public String totalNetAmount;
	public String orderStatus;
	private String vendorId;
	private String assign;
	private String conformationId;
	private String serviceId;
	private String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getConformationId() {
		return conformationId;
	}

	public void setConformationId(String conformationId) {
		this.conformationId = conformationId;
	}

	/**
	 * @return the assign
	 */
	public String getAssign() {
		return assign;
	}

	/**
	 * @param assign
	 *            the assign to set
	 */
	public void setAssign(String assign) {
		this.assign = assign;
	}

	/**
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId
	 *            the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}

	/**
	 * @return the totalDiscount
	 */
	public String getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * @param totalDiscount
	 *            the totalDiscount to set
	 */
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * @return the totalNetAmount
	 */
	public String getTotalNetAmount() {
		return totalNetAmount;
	}

	/**
	 * @param totalNetAmount
	 *            the totalNetAmount to set
	 */
	public void setTotalNetAmount(String totalNetAmount) {
		this.totalNetAmount = totalNetAmount;
	}

	public List<MedicineOrderBean> listMedicineOrderBeans;

	/**
	 * @return the listMedicineOrderBeans
	 */
	public List<MedicineOrderBean> getListMedicineOrderBeans() {
		return listMedicineOrderBeans;
	}

	/**
	 * @param listMedicineOrderBeans
	 *            the listMedicineOrderBeans to set
	 */
	public void setListMedicineOrderBeans(
			List<MedicineOrderBean> listMedicineOrderBeans) {
		this.listMedicineOrderBeans = listMedicineOrderBeans;
	}

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

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
