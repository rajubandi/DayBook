
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseService1;

@Entity(name = "Service1")
public class Service1 extends BaseService1 {
 protected String LocationId;

public String getLocationId() {
	return LocationId;
}

public void setLocationId(String locationId) {
	LocationId = locationId;
}
 
}
