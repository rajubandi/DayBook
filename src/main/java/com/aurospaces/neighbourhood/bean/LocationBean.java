/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hiteshaurospaces
 *
 */
public class LocationBean {
	private String locationId;
	private String locationName;
	private String locationDesc;
	private String sMsg;
	private String serviceId;
	private MultipartFile csvFilePath;
	private String serviceName;
	
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public MultipartFile getCsvFilePath() {
		return csvFilePath;
	}
	public void setCsvFilePath(MultipartFile csvFilePath) {
		this.csvFilePath = csvFilePath;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getsMsg() {
		return sMsg;
	}
	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationDesc() {
		return locationDesc;
	}
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}
	
	
	

}
