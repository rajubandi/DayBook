/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Divya
 *
 */
public class PathologyTestsBean {
	private String testId;
	private String testName;
	private String testDesc;
	private String price;
	private String discount;
	private String testTypeId;
	private String testDescription;
	private String businessName;
	private MultipartFile cvsFilePath;
	private String testTypeName;
	private String testClientId;
	private String testClientName;
	private String firstName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTestTypeName() {
		return testTypeName;
	}
	public void setTestTypeName(String testTypeName) {
		this.testTypeName = testTypeName;
	}
	public String getTestClientId() {
		return testClientId;
	}
	public void setTestClientId(String testClientId) {
		this.testClientId = testClientId;
	}
	public String getTestClientName() {
		return testClientName;
	}
	public void setTestClientName(String testClientName) {
		this.testClientName = testClientName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public MultipartFile getCvsFilePath() {
		return cvsFilePath;
	}
	public void setCvsFilePath(MultipartFile cvsFilePath) {
		this.cvsFilePath = cvsFilePath;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public String getTestTypeId() {
		return testTypeId;
	}
	public void setTestTypeId(String testTypeId) {
		this.testTypeId = testTypeId;
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
	public String getTestDesc() {
		return testDesc;
	}
	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
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