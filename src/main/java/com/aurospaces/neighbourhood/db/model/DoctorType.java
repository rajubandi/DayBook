/**
 * 
 */
package com.aurospaces.neighbourhood.db.model;

/**
 * @author yogi
 *
 */
public class DoctorType {
	public int doctor_type_id;
	public String doctor_type_name;
	public String doctor_type_icon;
	public String doctor_base_price;
	public String doctor_discount;
	public String doctor_total_price;
	
	public int getDoctor_type_id() {
		return doctor_type_id;
	}

	public void setDoctor_type_id(int doctor_type_id) {
		this.doctor_type_id = doctor_type_id;
	}

	public String getDoctor_type_name() {
		return doctor_type_name;
	}

	public void setDoctor_type_name(String doctor_type_name) {
		this.doctor_type_name = doctor_type_name;
	}

	public String getDoctor_type_icon() {
		return doctor_type_icon;
	}

	public void setDoctor_type_icon(String doctor_type_icon) {
		this.doctor_type_icon = doctor_type_icon;
	}

	public String getDoctor_base_price() {
		return doctor_base_price;
	}

	public void setDoctor_base_price(String doctor_base_price) {
		this.doctor_base_price = doctor_base_price;
	}

	public String getDoctor_discount() {
		return doctor_discount;
	}

	public void setDoctor_discount(String doctor_discount) {
		this.doctor_discount = doctor_discount;
	}

	public String getDoctor_total_price() {
		return doctor_total_price;
	}

	public void setDoctor_total_price(String doctor_total_price) {
		this.doctor_total_price = doctor_total_price;
	}

}
