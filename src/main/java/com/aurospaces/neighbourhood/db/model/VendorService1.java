
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseVendorService1;

@Entity(name = "VendorService1")
public class VendorService1 extends BaseVendorService1 {

	public String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
