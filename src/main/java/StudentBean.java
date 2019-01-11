

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class StudentBean {
 protected String  name,boardName,medium,className,section,rollNum,admissionNum,fatherName,mobile,alternativeMobile,email,blodgroup,gender,region,address,previousInstitue,caste,acomitation,buspesility,busroute,religion;
 protected int id   = 0;
 protected String  admissionDate;
 protected String imagePath;
protected double totalFee;
protected double discountFee;
String discountFee1;
String dob2;
@Override
public String toString() {
	return "StudentBean [name=" + name + ", boardName=" + boardName + ", medium=" + medium + ", className=" + className
			+ ", section=" + section + ", rollNum=" + rollNum + ", admissionNum=" + admissionNum + ", fatherName="
			+ fatherName + ", mobile=" + mobile + ", alternativeMobile=" + alternativeMobile + ", email=" + email
			+ ", blodgroup=" + blodgroup + ", gender=" + gender + ", region=" + region + ", address=" + address
			+ ", previousInstitue=" + previousInstitue + ", caste=" + caste + ", acomitation=" + acomitation
			+ ", buspesility=" + buspesility + ", busroute=" + busroute + ", religion=" + religion + ", id=" + id
			+ ", joinedDate=" + admissionDate + ", imagePath=" + imagePath + ", totalFee=" + totalFee + ", discountFee="
			+ discountFee + ", discountFee1=" + discountFee1 + ", dob2=" + dob2 + ", netFee=" + netFee + ", imageName="
			+ imageName + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", dob=" + dob + ", dob1="
			+ dob1 + "]";
}



public String getAdmissionDate() {
	return admissionDate;
}



public void setAdmissionDate(String admissionDate) {
	this.admissionDate = admissionDate;
}



public String getDob2() {
	return dob2;
}

public void setDob2(String dob2) {
	this.dob2 = dob2;
}

public String getDiscountFee1() {
	return discountFee1;
}

public void setDiscountFee1(String discountFee1) {
	this.discountFee1 = discountFee1;
}

protected double netFee;

 
 public double getTotalFee() {
	return totalFee;
}

public void setTotalFee(double totalFee) {
	this.totalFee = totalFee;
}

public double getDiscountFee() {
	return discountFee;
}

public void setDiscountFee(double discountFee) {
	this.discountFee = discountFee;
}

public double getNetFee() {
	return netFee;
}

public void setNetFee(double netFee) {
	this.netFee = netFee;
}

public String getImagePath() {
	return imagePath;
}

public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}

MultipartFile imageName;

	public MultipartFile getImageName() {
	return imageName;
}

public void setImageName(MultipartFile imageName) {
	this.imageName = imageName;
}

	protected Date createdTime ;

	protected Date updatedTime ;
	protected Date dob ;
	String dob1;
public String getDob1() {
		return dob1;
	}

	public void setDob1(String dob1) {
		this.dob1 = dob1;
	}

public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBoardName() {
	return boardName;
}

public void setBoardName(String boardName) {
	this.boardName = boardName;
}

public String getMedium() {
	return medium;
}

public void setMedium(String medium) {
	this.medium = medium;
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public String getSection() {
	return section;
}

public void setSection(String section) {
	this.section = section;
}

public String getRollNum() {
	return rollNum;
}

public void setRollNum(String rollNum) {
	this.rollNum = rollNum;
}

public String getAdmissionNum() {
	return admissionNum;
}

public void setAdmissionNum(String admissionNum) {
	this.admissionNum = admissionNum;
}

public String getFatherName() {
	return fatherName;
}

public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getAlternativeMobile() {
	return alternativeMobile;
}

public void setAlternativeMobile(String alternativeMobile) {
	this.alternativeMobile = alternativeMobile;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getBlodgroup() {
	return blodgroup;
}

public void setBlodgroup(String blodgroup) {
	this.blodgroup = blodgroup;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}


public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getRegion() {
	return region;
}

public void setRegion(String region) {
	this.region = region;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPreviousInstitue() {
	return previousInstitue;
}

public void setPreviousInstitue(String previousInstitue) {
	this.previousInstitue = previousInstitue;
}

public String getCaste() {
	return caste;
}

public void setCaste(String caste) {
	this.caste = caste;
}

public String getAcomitation() {
	return acomitation;
}

public void setAcomitation(String acomitation) {
	this.acomitation = acomitation;
}

public String getBuspesility() {
	return buspesility;
}

public void setBuspesility(String buspesility) {
	this.buspesility = buspesility;
}

public String getBusroute() {
	return busroute;
}

public void setBusroute(String busroute) {
	this.busroute = busroute;
}

public String getReligion() {
	return religion;
}

public void setReligion(String religion) {
	this.religion = religion;
}

}
