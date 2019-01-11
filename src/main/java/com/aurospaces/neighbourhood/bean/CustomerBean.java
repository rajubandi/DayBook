/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.stereotype.Component;

/**
 * @author kanojia
 * 
 */
@Component
public class CustomerBean {
	private String customerId;
	private String customerName;
	private String mobileNumber;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String pincode;
	private String state;
	private String sMsg;
	private String password;
	private VendorRegistrationBean objVendorRegistrationBean;
	private int roleId;
	private String confirmPassword;
	private String orderId;
	private String registerDate;
	private String discountUsedDate;
	private String customerDiscount;
	
	

	public String getCustomerDiscount() {
		return customerDiscount;
	}

	public void setCustomerDiscount(String customerDiscount) {
		this.customerDiscount = customerDiscount;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getDiscountUsedDate() {
		return discountUsedDate;
	}

	public void setDiscountUsedDate(String discountUsedDate) {
		this.discountUsedDate = discountUsedDate;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the objVendorRegistrationBean
	 */
	public VendorRegistrationBean getObjVendorRegistrationBean() {
		return objVendorRegistrationBean;
	}

	/**
	 * @param objVendorRegistrationBean
	 *            the objVendorRegistrationBean to set
	 */
	public void setObjVendorRegistrationBean(
			VendorRegistrationBean objVendorRegistrationBean) {
		this.objVendorRegistrationBean = objVendorRegistrationBean;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the sMsg
	 */
	public String getsMsg() {
		return sMsg;
	}

	/**
	 * @param sMsg
	 *            the sMsg to set
	 */
	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
