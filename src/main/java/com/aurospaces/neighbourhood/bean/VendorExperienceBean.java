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
public class VendorExperienceBean {
	private String vendorId;
	private String experianceId;

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

	public String getExperianceId() {
		return experianceId;
	}

	public void setExperianceId(String experianceId) {
		this.experianceId = experianceId;
	}

	

}
