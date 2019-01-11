/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.aurospaces.neighbourhood.bean.ServicesBean;;

/**
 * @author kanojia
 *
 */
@Component
public class PathologyVendorBean {
	private String vendorId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String categoryId;
	private String expiryDate;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String email;
	private String personalImage;
	private String organisationName;
	private String vatNo;
	private String cstNo;
	private String panNo;
	private String website;
	private MultipartFile imageOrVedio;
	private String experienceId;
	private String experienceName;
	private String nativeState;
	private String cateogryName;
	private String serviceId;
	private String serviceName;
	private String profileDesc;
	private List<ServicesBean> listServicesBean;
	private String editMode;
	// project related
	private String pDescription;
	private MultipartFile pimagervideo;
	// review related
	public String rFirstName;
	public String rLastName;
	public String contactNumber;
	public String rEmail;
	public String reviewDate;
	public String rDescription;
	public MultipartFile imageRVideo;
	public String rHappyPercentage;
	public String serviceType;
	public String sMsg;
	
	public String getsMsg() {
		return sMsg;
	}
	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPersonalImage() {
		return personalImage;
	}
	public void setPersonalImage(String personalImage) {
		this.personalImage = personalImage;
	}
	public String getOrganisationName() {
		return organisationName;
	}
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	public String getVatNo() {
		return vatNo;
	}
	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}
	public String getCstNo() {
		return cstNo;
	}
	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public MultipartFile getImageOrVedio() {
		return imageOrVedio;
	}
	public void setImageOrVedio(MultipartFile imageOrVedio) {
		this.imageOrVedio = imageOrVedio;
	}
	public String getExperienceId() {
		return experienceId;
	}
	public void setExperienceId(String experienceId) {
		this.experienceId = experienceId;
	}
	public String getExperienceName() {
		return experienceName;
	}
	public void setExperienceName(String experienceName) {
		this.experienceName = experienceName;
	}
	public String getNativeState() {
		return nativeState;
	}
	public void setNativeState(String nativeState) {
		this.nativeState = nativeState;
	}
	public String getCateogryName() {
		return cateogryName;
	}
	public void setCateogryName(String cateogryName) {
		this.cateogryName = cateogryName;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getProfileDesc() {
		return profileDesc;
	}
	public void setProfileDesc(String profileDesc) {
		this.profileDesc = profileDesc;
	}
	public List<ServicesBean> getListServicesBean() {
		return listServicesBean;
	}
	public void setListServicesBean(List<ServicesBean> listServicesBean) {
		this.listServicesBean = listServicesBean;
	}
	public String getEditMode() {
		return editMode;
	}
	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public MultipartFile getPimagervideo() {
		return pimagervideo;
	}
	public void setPimagervideo(MultipartFile pimagervideo) {
		this.pimagervideo = pimagervideo;
	}
	public String getrFirstName() {
		return rFirstName;
	}
	public void setrFirstName(String rFirstName) {
		this.rFirstName = rFirstName;
	}
	public String getrLastName() {
		return rLastName;
	}
	public void setrLastName(String rLastName) {
		this.rLastName = rLastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getrEmail() {
		return rEmail;
	}
	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getrDescription() {
		return rDescription;
	}
	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}
	public MultipartFile getImageRVideo() {
		return imageRVideo;
	}
	public void setImageRVideo(MultipartFile imageRVideo) {
		this.imageRVideo = imageRVideo;
	}
	public String getrHappyPercentage() {
		return rHappyPercentage;
	}
	public void setrHappyPercentage(String rHappyPercentage) {
		this.rHappyPercentage = rHappyPercentage;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


}
