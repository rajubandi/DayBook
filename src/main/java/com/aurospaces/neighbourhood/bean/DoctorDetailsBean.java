/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author kanojia
 *
 */
public class DoctorDetailsBean {
	private String doctorId;
	private String name;
	private String mobileNo;
    private String emailId;
	private String address;
	private String clinic;
	MultipartFile csvFilePath;
	private String typeName;
	private String doctortypeId;
	
	
	public String getDoctortypeId() {
		return doctortypeId;
	}
	public void setDoctortypeId(String doctortypeId) {
		this.doctortypeId = doctortypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public MultipartFile getCsvFilePath() {
		return csvFilePath;
	}
	public void setCsvFilePath(MultipartFile csvFilePath) {
		this.csvFilePath = csvFilePath;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	
	
	
}
