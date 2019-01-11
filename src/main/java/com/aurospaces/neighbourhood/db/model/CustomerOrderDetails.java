package com.aurospaces.neighbourhood.db.model;

import java.util.List;

import com.aurospaces.neighbourhood.custommodel.OrderStatus;

public class CustomerOrderDetails {
	public String order_id;
	public String service_name;
	public String package_name;
	public String vendor;
	public String img_url;
	public String total_amount;
	public String status_id;
	public String service_id;

	
	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	public List<OrderStatus> getOrder_status() {
		return order_status;
	}

	public void setOrder_status(List<OrderStatus> order_status) {
		this.order_status = order_status;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	
	public List<OrderStatus> order_status ;	

	public void setStatusList(OrderSequence seq)
	{
		this.order_status =  seq.getSequence();
	}
	
	public void setStatus(OrderSequence seq)
	{
		this.order_status =  seq.getSequence();
		for(OrderStatus stat : order_status)
		{
			stat.setDone();
			if(stat.id.equals(status_id))
			{
				break;
			}
		}
	}

}
