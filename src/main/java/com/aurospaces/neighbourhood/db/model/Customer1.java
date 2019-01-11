
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseCustomer1;

@Entity(name = "Customer1")
public class Customer1 extends BaseCustomer1 {
	public String cust_email_id;
	public String cust_mobile_no;
	public String cust_address;
	public String cust_password;
	public String problem_desc;
	public String selected_day_slot;
	public String selected_time_slot;

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

	public String getProblem_desc() {
		return problem_desc;
	}

	public void setProblem_desc(String problem_desc) {
		this.problem_desc = problem_desc;
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

}
