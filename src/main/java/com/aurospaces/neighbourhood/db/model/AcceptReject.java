package com.aurospaces.neighbourhood.db.model;

public class AcceptReject {
	public String order_id;
	public boolean is_accept;
	public String vendor_id;
	public int status_id;
	public String order_status_message;
	

	public String getOrder_status_message() {
		return order_status_message;
	}

	public void setOrder_status_message(String order_status_message) {
		this.order_status_message = order_status_message;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public boolean isIs_accept() {
		return is_accept;
	}

	public void setIs_accept(boolean is_accept) {
		this.is_accept = is_accept;
	}

}
