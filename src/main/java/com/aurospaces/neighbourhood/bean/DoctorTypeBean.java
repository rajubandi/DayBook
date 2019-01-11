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
public class DoctorTypeBean {
	private String doctortypeId;
	private String doctortypeName;
	private String doctortypeDesc;
	private String sMsg;
	private String price;
	private String discount;
	
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDoctortypeId() {
		return doctortypeId;
	}
	public void setDoctortypeId(String doctortypeId) {
		this.doctortypeId = doctortypeId;
	}
	public String getsMsg() {
		return sMsg;
	}
	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}
	
	public String getDoctortypeName() {
		return doctortypeName;
	}
	public void setDoctortypeName(String doctortypeName) {
		this.doctortypeName = doctortypeName;
	}
	public String getDoctortypeDesc() {
		return doctortypeDesc;
	}
	public void setDoctortypeDesc(String doctortypeDesc) {
		this.doctortypeDesc = doctortypeDesc;
	}
	
	

}
