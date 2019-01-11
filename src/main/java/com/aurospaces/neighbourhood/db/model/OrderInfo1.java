package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

import com.aurospaces.neighbourhood.db.basemodel.BaseOrderInfo1;
import com.aurospaces.neighbourhood.util.MiscUtils;

@Entity(name = "OrderInfo1")
public class OrderInfo1 extends BaseOrderInfo1 {



	public OrderInfo1()
	{
		setGender("m");
	}
		
	private MultipartFile cvsFilePath;
	public String serviceName;
	public String appointTimeName;
	public String otp;
	public String appointDate;
	public String vendorName;
	public String vendorMobile;
	public String statusName;
	public String tests;
	public String symtoms;
	public int count;
	public int oid;
	public String vendorStatusName;
	private List<OrderInfo1> listClientOrder;
	private List<OrderInfo1> listAuroOrder;
	private String userName;
	private String packages;
	private String billingTo;
	private String ownerName;
	private String customerName;
	private String vendoraddress;
	private String accountNumber;
	private String bankName;
	private String ifscCode;
	private String branchName;
	private String displayName;
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getVendoraddress() {
		return vendoraddress;
	}

	public void setVendoraddress(String vendoraddress) {
		this.vendoraddress = vendoraddress;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBillingTo() {
		return billingTo;
	}

	public void setBillingTo(String billingTo) {
		this.billingTo = billingTo;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public MultipartFile getCvsFilePath() {
		return cvsFilePath;
	}

	public void setCvsFilePath(MultipartFile cvsFilePath) {
		this.cvsFilePath = cvsFilePath;
	}

	public String getVendorStatusName() {
		return vendorStatusName;
	}

	public void setVendorStatusName(String vendorStatusName) {
		this.vendorStatusName = vendorStatusName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<OrderInfo1> getListClientOrder() {
		return listClientOrder;
	}

	public void setListClientOrder(List<OrderInfo1> listClientOrder) {
		this.listClientOrder = listClientOrder;
	}

	public List<OrderInfo1> getListAuroOrder() {
		return listAuroOrder;
	}

	public void setListAuroOrder(List<OrderInfo1> listAuroOrder) {
		this.listAuroOrder = listAuroOrder;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getSymtoms() {
		return symtoms;
	}

	public void setSymtoms(String symtoms) {
		this.symtoms = symtoms;
	}

	public String getTests() {
		return tests;
	}

	public void setTests(String tests) {
		this.tests = tests;
	}

	public static Map<String, Integer> getTimeSlots() {
		return timeSlots;
	}

	public static void setTimeSlots(Map<String, Integer> timeSlots) {
		OrderInfo1.timeSlots = timeSlots;
		
	}
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorMobile() {
		return vendorMobile;
	}

	public void setVendorMobile(String vendorMobile) {
		this.vendorMobile = vendorMobile;
	}

	
	public String getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(String appointDate) {
		Date finalDate = MiscUtils.getDate(appointDate);
		this.setAppointmentDate(finalDate);
		this.appointDate = appointDate;
	}

	public String getOtp() {
		return otp;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOrderId() {
		return getGeneratedId();
	}

	public void setOrderId(String orderId) {
		setGeneratedId(orderId);
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getAppointTimeName() {
		return appointTimeName;
	}

	public void setAppointTimeName(String appointTimeName) {
		this.appointTimeName = appointTimeName;
		Integer slotId = timeSlots.get(appointTimeName.trim());
		this.setAppointmentSlotId(slotId);
	}

	public void setServiceId(String sId)
	{
		setServiceId(Integer.parseInt(sId));
	}



static Map<String, Integer> timeSlots;
static
{
	timeSlots = new HashMap<String, Integer>();
	timeSlots.put("Morning (8 AM to 12 PM)", 1);
	timeSlots.put("Afternoon (12 PM to 4 PM)", 2);
	timeSlots.put("Evening (4 PM to 7 PM)", 3);
	timeSlots.put("Morning(8-12)", 1);
	timeSlots.put("Afternoon(12-4PM)", 2);
	timeSlots.put("Evening(4-7PM)", 3);

}


}
