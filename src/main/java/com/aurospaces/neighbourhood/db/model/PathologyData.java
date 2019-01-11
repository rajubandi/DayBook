/**
 * 
 */
package com.aurospaces.neighbourhood.db.model;

/**
 * @author yogi
 *
 */
public class PathologyData {
	public int pathology_id;
	public String pathology_name;
	public String pathology_desc;
	public String pathology_category;
	public String pathology_vendor;
	public String pathology_base_price;
	public String pathology_discount_percent;
	public String pathology_total_price;
	public String selected_day_slot;
	public String selected_time_slot;

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

	public int getPathology_id() {
		return pathology_id;
	}

	public void setPathology_id(int pathology_id) {
		this.pathology_id = pathology_id;
	}

	public String getPathology_name() {
		return pathology_name;
	}

	public void setPathology_name(String pathology_name) {
		this.pathology_name = pathology_name;
	}

	public String getPathology_desc() {
		return pathology_desc;
	}

	public void setPathology_desc(String pathology_desc) {
		this.pathology_desc = pathology_desc;
	}

	public String getPathology_category() {
		return pathology_category;
	}

	public void setPathology_category(String pathology_category) {
		this.pathology_category = pathology_category;
	}

	public String getPathology_vendor() {
		return pathology_vendor;
	}

	public void setPathology_vendor(String pathology_vendor) {
		this.pathology_vendor = pathology_vendor;
	}

	public String getPathology_base_price() {
		return pathology_base_price;
	}

	public void setPathology_base_price(String pathology_base_price) {
		this.pathology_base_price = pathology_base_price;
	}

	public String getPathology_discount_percent() {
		return pathology_discount_percent;
	}

	public void setPathology_discount_percent(String pathology_discount_percent) {
		this.pathology_discount_percent = pathology_discount_percent;
	}

	public String getPathology_total_price() {
		return pathology_total_price;
	}

	public void setPathology_total_price(String pathology_total_price) {
		this.pathology_total_price = pathology_total_price;
	}

}
