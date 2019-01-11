/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Divya
 *
 */
public class PathologyPackagesBean {
	private String packageId;
	private String packageName;
	private String packageDesc;
	private String price;
	private String discount;
	private String netPrice;
	private MultipartFile cvsFilePath;
	private String vendorId;
	private String businessName;
	private String testId;
	private String testName;
	private String testDesc;
	private String firstName;
	
	
	public String getTestDesc() {
		return testDesc;
	}
	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public MultipartFile getCvsFilePath() {
		return cvsFilePath;
	}
	public void setCvsFilePath(MultipartFile cvsFilePath) {
		this.cvsFilePath = cvsFilePath;
	}
	public String getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDesc() {
		return packageDesc;
	}
	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}

}