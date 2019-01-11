/**
 * 
 */
package com.aurospaces.neighbourhood.db.model;

/**
 * @author yogi
 *
 */
public class PathologyBooking {
	public String cust_email_id;
	public String cust_mobile_no;
	public String cust_address;
	public String cust_password;
	public PathologyData[] pathology_data;
	public Service1 service;
	public String payment_mode;
	public boolean is_payment_done;
	public String selected_day_slot;
	public long selected_day;
	public String selected_time_slot;
	public long getSelected_day() {
		return selected_day;
	}

	public void setSelected_day(long selected_day) {
		this.selected_day = selected_day;
	}

	public String getSelected_day_slot() {
		return selected_day_slot;
	}

	public void setSelected_day_slot(String selected_day_slot) {
		this.selected_day_slot = selected_day_slot;
	}

	public String getSelected_time_slot() {
		return selected_time_slot;
	}

	public void setSelected_time_slot(String selected_time_slot) {
		this.selected_time_slot = selected_time_slot;
	}

	public String getCust_email_id() {
		return cust_email_id;
	}

	public void setCust_email_id(String cust_email_id) {
		this.cust_email_id = cust_email_id;
	}

	public String getCust_mobile_no() {
		return cust_mobile_no;
	}

	public void setCust_mobile_no(String cust_mobile_no) {
		this.cust_mobile_no = cust_mobile_no;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_password() {
		return cust_password;
	}

	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}

	

	public PathologyData[] getPathology_data() {
		return pathology_data;
	}

	public void setPathology_data(PathologyData[] pathology_data) {
		this.pathology_data = pathology_data;
	}

	public Service1 getService() {
		return service;
	}

	public void setService(Service1 service) {
		this.service = service;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public boolean isIs_payment_done() {
		return is_payment_done;
	}

	public void setIs_payment_done(boolean is_payment_done) {
		this.is_payment_done = is_payment_done;
	}

}
