package com.aurospaces.neighbourhood.bean;

public class PathologyDetailsBean {
	public String pathology_id;
	public String pathology_original_price;
	public String pathology_name;
	public double totalNetAmount;
	public double getTotalNetAmount() {
		return totalNetAmount;
	}
	public void setTotalNetAmount(double totalNetAmount) {
		this.totalNetAmount = totalNetAmount;
	}
	public String getPathology_name() {
		return pathology_name;
	}
	public void setPathology_name(String pathology_name) {
		this.pathology_name = pathology_name;
	}
	public String getPathology_id() {
		return pathology_id;
	}
	public void setPathology_id(String pathology_id) {
		this.pathology_id = pathology_id;
	}
	public String getPathology_original_price() {
		return pathology_original_price;
	}
	public void setPathology_original_price(String pathology_original_price) {
		this.pathology_original_price = pathology_original_price;
	}

}
