/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kanojia
 * 
 */
@Component
public class VendorRegistrationBean {
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
	private String url;
	private String personalImage;
	private String organisationName;
	private String vatNo;
	private String cstNo;
	private String panNo;
	private String website;
	private String gLatitude;
	private String gLongitude;
	private MultipartFile imageOrVedio;
	private String experienceId;
	private String experienceName;
	private String nativeState;
	private String cateogryName;
	private String serviceId;
	private String serviceName;
	private String profileDesc;
	private String state_Name;
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
	public String password;
	public String cfpassword;
	private String imageVedio;
	private String fatherName;
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the listMedicineBeans
	 */

	public String getImageVedio() {
		return imageVedio;
	}

	public void setImageVedio(String imageVedio) {
		this.imageVedio = imageVedio;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public String getState_Name() {
		return state_Name;
	}

	public void setState_Name(String state_Name) {
		this.state_Name = state_Name;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the cfpassword
	 */
	public String getCfpassword() {
		return cfpassword;
	}

	/**
	 * @param cfpassword the cfpassword to set
	 */
	public void setCfpassword(String cfpassword) {
		this.cfpassword = cfpassword;
	}

	/**
	 * @return the editPassword
	 */
	public String getEditPassword() {
		return editPassword;
	}

	/**
	 * @param editPassword the editPassword to set
	 */
	public void setEditPassword(String editPassword) {
		this.editPassword = editPassword;
	}

	/**
	 * @return the experianceId
	 */
	public String getExperianceId() {
		return experianceId;
	}

	/**
	 * @param experianceId the experianceId to set
	 */
	public void setExperianceId(String experianceId) {
		this.experianceId = experianceId;
	}

	public String editPassword;
	public String experianceId;

	
	/**
	 * @return the editMode
	 */
	public String getEditMode() {
		return editMode;
	}

	/**
	 * @param editMode the editMode to set
	 */
	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}

	/**
	 * @return the listServicesBean
	 */
	public List<ServicesBean> getListServicesBean() {
		return listServicesBean;
	}

	/**
	 * @param listServicesBean the listServicesBean to set
	 */
	public void setListServicesBean(List<ServicesBean> listServicesBean) {
		this.listServicesBean = listServicesBean;
	}

	/**
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the gLatitude
	 */
	public String getgLatitude() {
		return gLatitude;
	}

	/**
	 * @param gLatitude the gLatitude to set
	 */
	public void setgLatitude(String gLatitude) {
		this.gLatitude = gLatitude;
	}

	/**
	 * @return the gLongitude
	 */
	public String getgLongitude() {
		return gLongitude;
	}

	/**
	 * @param gLongitude the gLongitude to set
	 */
	public void setgLongitude(String gLongitude) {
		this.gLongitude = gLongitude;
	}

	/**
	 * @return the imageOrVedio
	 */
	public MultipartFile getImageOrVedio() {
		return imageOrVedio;
	}

	/**
	 * @param imageOrVedio the imageOrVedio to set
	 */
	public void setImageOrVedio(MultipartFile imageOrVedio) {
		this.imageOrVedio = imageOrVedio;
	}

	/**
	 * @return the experienceId
	 */
	public String getExperienceId() {
		return experienceId;
	}

	/**
	 * @param experienceId the experienceId to set
	 */
	public void setExperienceId(String experienceId) {
		this.experienceId = experienceId;
	}

	/**
	 * @return the experienceName
	 */
	public String getExperienceName() {
		return experienceName;
	}

	/**
	 * @param experienceName the experienceName to set
	 */
	public void setExperienceName(String experienceName) {
		this.experienceName = experienceName;
	}

	/**
	 * @return the nativeState
	 */
	public String getNativeState() {
		return nativeState;
	}

	/**
	 * @param nativeState the nativeState to set
	 */
	public void setNativeState(String nativeState) {
		this.nativeState = nativeState;
	}

	/**
	 * @return the cateogryName
	 */
	public String getCateogryName() {
		return cateogryName;
	}

	/**
	 * @param cateogryName the cateogryName to set
	 */
	public void setCateogryName(String cateogryName) {
		this.cateogryName = cateogryName;
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the profileDesc
	 */
	public String getProfileDesc() {
		return profileDesc;
	}

	/**
	 * @param profileDesc the profileDesc to set
	 */
	public void setProfileDesc(String profileDesc) {
		this.profileDesc = profileDesc;
	}

	/**
	 * @return the vatNo
	 */
	public String getVatNo() {
		return vatNo;
	}

	/**
	 * @param vatNo
	 *            the vatNo to set
	 */
	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the cstNo
	 */
	public String getCstNo() {
		return cstNo;
	}

	/**
	 * @param cstNo
	 *            the cstNo to set
	 */
	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}

	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * @param panNo
	 *            the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * @return the pDescription
	 */
	public String getpDescription() {
		return pDescription;
	}

	/**
	 * @return the organisationName
	 */
	public String getOrganisationName() {
		return organisationName;
	}

	/**
	 * @param organisationName
	 *            the organisationName to set
	 */
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	/**
	 * @param pDescription
	 *            the pDescription to set
	 */
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	
	/**
	 * @return the rFirstName
	 */
	public String getrFirstName() {
		return rFirstName;
	}

	/**
	 * @param rFirstName
	 *            the rFirstName to set
	 */
	public void setrFirstName(String rFirstName) {
		this.rFirstName = rFirstName;
	}

	/**
	 * @return the rLastName
	 */
	public String getrLastName() {
		return rLastName;
	}

	/**
	 * @param rLastName
	 *            the rLastName to set
	 */
	public void setrLastName(String rLastName) {
		this.rLastName = rLastName;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber
	 *            the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the rEmail
	 */
	public String getrEmail() {
		return rEmail;
	}

	/**
	 * @param rEmail
	 *            the rEmail to set
	 */
	public void setrEmail(String rEmail) {
		this.rEmail = rEmail;
	}

	/**
	 * @return the reviewDate
	 */
	public String getReviewDate() {
		return reviewDate;
	}

	/**
	 * @param reviewDate
	 *            the reviewDate to set
	 */
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	/**
	 * @return the rDescription
	 */
	public String getrDescription() {
		return rDescription;
	}

	/**
	 * @param rDescription
	 *            the rDescription to set
	 */
	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	
	/**
	 * @return the pimagervideo
	 */
	public MultipartFile getPimagervideo() {
		return pimagervideo;
	}

	/**
	 * @param pimagervideo the pimagervideo to set
	 */
	public void setPimagervideo(MultipartFile pimagervideo) {
		this.pimagervideo = pimagervideo;
	}

	/**
	 * @return the imageRVideo
	 */
	public MultipartFile getImageRVideo() {
		return imageRVideo;
	}

	/**
	 * @param imageRVideo the imageRVideo to set
	 */
	public void setImageRVideo(MultipartFile imageRVideo) {
		this.imageRVideo = imageRVideo;
	}

	/**
	 * @return the rHappyPercentage
	 */
	public String getrHappyPercentage() {
		return rHappyPercentage;
	}

	/**
	 * @param rHappyPercentage
	 *            the rHappyPercentage to set
	 */
	public void setrHappyPercentage(String rHappyPercentage) {
		this.rHappyPercentage = rHappyPercentage;
	}

	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType
	 *            the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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

	public void setMobileNumber(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPersonalImage() {
		return personalImage;
	}

	public void setPersonalImage(String personalImage) {
		this.personalImage = personalImage;
	}

}
