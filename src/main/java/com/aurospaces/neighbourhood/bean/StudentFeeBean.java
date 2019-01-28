package com.aurospaces.neighbourhood.bean;

import java.util.Date;

public class StudentFeeBean {
	protected int id   = 0;

	protected Date createdTime,paymentDate ;

	protected Date updatedTime ;
	private String studentId;
	private double  totalFee;
	private double  discount;
	private double  netFee;
	private double  fee;
	private double  remaningFee;
	private String boardName;
	private String className;
	private String medium;
	private String section;
	private String dueFee;
	private double admissionFee;
	private double tutionFee;
	private double transportationFee;
	private double hostelFee,termOne,termTwo,termThree;
	private double stationaryFee;
	private String feeType;
	private double dueFee1;
	private int userId;
	private String cashier;
	private int invoiceId;
	private double totalPaidFee;
	private String academicYear;
	private int academicYearId;	
	
	public double getTermOne() {
		return termOne;
	}
	
	public void setTermOne(double termOne) {
		this.termOne = termOne;
	}
	
	public double getTermTwo() {
		return termTwo;
	}
	
	public void setTermTwo(double termTwo) {
		this.termTwo = termTwo;
	}
	
	public double getTermThree() {
		return termThree;
	}
	
	public void setTermThree(double termThree) {
		this.termThree = termThree;
	}
	
	public String getAcademicYear() {
		return academicYear;
	}
	
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	
	public int getAcademicYearId() {
		return academicYearId;
	}
	
	public void setAcademicYearId(int academicYearId) {
		this.academicYearId = academicYearId;
	}
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public double getTotalPaidFee() {
		return totalPaidFee;
	}
	
	public void setTotalPaidFee(double totalPaidFee) {
		this.totalPaidFee = totalPaidFee;
	}
	
	public int getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	public String getCashier() {
		return cashier;
	}
	
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	
	@Override
	public String toString() {
		return "StudentFeeBean [id=" + id + ", createdTime=" + createdTime + ", paymentDate=" + paymentDate
				+ ", updatedTime=" + updatedTime + ", studentId=" + studentId + ", totalFee=" + totalFee + ", discount="
				+ discount + ", netFee=" + netFee + ", fee=" + fee + ", remaningFee=" + remaningFee + ", boardName="
				+ boardName + ", className=" + className + ", medium=" + medium + ", section=" + section + ", dueFee="
				+ dueFee + ", admissionFee=" + admissionFee + ", tutionFee=" + tutionFee + ", transportationFee="
				+ transportationFee + ", hostelFee=" + hostelFee + ", termOne=" + termOne + ", termTwo=" + termTwo
				+ ", termThree=" + termThree + ", stationaryFee=" + stationaryFee + ", feeType=" + feeType
				+ ", dueFee1=" + dueFee1 + ", userId=" + userId + ", cashier=" + cashier + ", invoiceId=" + invoiceId
				+ ", totalPaidFee=" + totalPaidFee + ", academicYear=" + academicYear + ", academicYearId="
				+ academicYearId + "]";
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getDueFee1() {
		return dueFee1;
	}
	
	public void setDueFee1(double dueFee1) {
		this.dueFee1 = dueFee1;
	}
	
	public String getFeeType() {
		return feeType;
	}
	
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	public double getAdmissionFee() {
		return admissionFee;
	}
	
	public void setAdmissionFee(double admissionFee) {
		this.admissionFee = admissionFee;
	}
	
	public double getTutionFee() {
		return tutionFee;
	}
	
	public void setTutionFee(double tutionFee) {
		this.tutionFee = tutionFee;
	}
	
	public double getTransportationFee() {
		return transportationFee;
	}
	public void setTransportationFee(double transportationFee) {
		this.transportationFee = transportationFee;
	}
	
	public double getHostelFee() {
		return hostelFee;
	}
	
	public void setHostelFee(double hostelFee) {
		this.hostelFee = hostelFee;
	}
	
	public double getStationaryFee() {
		return stationaryFee;
	}
	
	public void setStationaryFee(double stationaryFee) {
		this.stationaryFee = stationaryFee;
	}
	
	public String getDueFee() {
		return dueFee;
	}
	
	public void setDueFee(String dueFee) {
		this.dueFee = dueFee;
	}
	
	public String getBoardName() {
		return boardName;
	}
	
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getMedium() {
		return medium;
	}
	
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	public String getSection() {
		return section;
	}
	
	public void setSection(String section) {
		this.section = section;
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
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public double getTotalFee() {
		return totalFee;
	}
	
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getNetFee() {
		return netFee;
	}
	
	public void setNetFee(double netFee) {
		this.netFee = netFee;
	}
	
	public double getFee() {
		return fee;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public double getRemaningFee() {
		return remaningFee;
	}
	
	public void setRemaningFee(double remaningFee) {
		this.remaningFee = remaningFee;
	}	
}