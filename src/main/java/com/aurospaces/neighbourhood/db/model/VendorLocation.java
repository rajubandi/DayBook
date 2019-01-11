
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseVendorLocation;


@Entity (name = "VendorLocation")
public class VendorLocation extends BaseVendorLocation
{
	public String vendorsId;
	public	String locationsId;
	public String locationName;
	public String vendorName;
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorsId() {
		return vendorsId;
	}
	public void setVendorsId(String vendorsId) {
		this.vendorsId = vendorsId;
	}
	public String getLocationsId() {
		return locationsId;
	}
	public void setLocationsId(String locationsId) {
		this.locationsId = locationsId;
	}



}
