
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

import com.aurospaces.neighbourhood.db.basemodel.BaseServiceUnit1;

import java.util.List;

import java.math.BigDecimal;



@Entity (name = "ServiceUnit1")
public class ServiceUnit1 extends BaseServiceUnit1
{


	protected String vendorName ;
	protected String serviceName ;
	private List<ServiceUnit1> listServiceUnit1;
	protected String serviceType ;
	protected BigDecimal price ;
	protected BigDecimal discount ;
	protected BigDecimal discountPrice ;
	protected BigDecimal finalPrice ;
	public String serviceunitId;
	protected int package_vendor_id;
	protected String userId;
	private MultipartFile cvsFilePath;
	protected int couponDiscount;
	
	public int getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(int couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public MultipartFile getCvsFilePath() {
		return cvsFilePath;
	}

	public void setCvsFilePath(MultipartFile cvsFilePath) {
		this.cvsFilePath = cvsFilePath;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	
	
	public int getPackage_vendor_id() {
		return package_vendor_id;
	}

	public void setPackage_vendor_id(int package_vendor_id) {
		this.package_vendor_id = package_vendor_id;
	}

	public String getServiceunitId() {
		return serviceunitId;
	}

	public void setServiceunitId(String serviceunitId) {
		this.serviceunitId = serviceunitId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public List<ServiceUnit1> getListServiceUnit1() {
		return listServiceUnit1;
	}

	public void setListServiceUnit1(List<ServiceUnit1> listServiceUnit1) {
		this.listServiceUnit1 = listServiceUnit1;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

}
