/**
 * 
 */
package com.aurospaces.neighbourhood.db.model;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yogi
 *
 */
public class ServiceUnitReviews {
	public String package_id;
	public String package_name;
	public String package_cost;
	public String happy_percent;
	public String tts;
	public String served_nos;
	public String vendor;
	public String discount;
	public String package_description;
	public String pacakge_image_url;
	public Set<UnitReviews> reviews;

	public void addService(UnitReviews newCat) {
		reviews.add(newCat);
	}

	public ServiceUnitReviews() {
		reviews = new LinkedHashSet<UnitReviews>();
	}
}
