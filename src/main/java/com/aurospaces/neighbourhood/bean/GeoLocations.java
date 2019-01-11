package com.aurospaces.neighbourhood.bean;


import com.aurospaces.neighbourhood.custommodel.LatLong;

import java.util.List;


public class GeoLocations {
	public String order_id;
	public List<LatLong> vendor_location;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public List<LatLong> getVendor_location() {
		return vendor_location;
	}

	public void setVendor_location(List<LatLong> vendor_location) {
		this.vendor_location = vendor_location;
	}

}
