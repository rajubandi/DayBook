package com.aurospaces.neighbourhood.db.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.aurospaces.neighbourhood.db.model.ServiceUnitReviews;
import com.aurospaces.neighbourhood.db.model.UnitReviews;

public class ServiceUnitReviewCallbackHandler implements RowCallbackHandler {

	public LinkedHashMap<String, ServiceUnitReviews> serviceUnitMap;
	List<Map<String,String>>  retList;
	public String baseUrl;

	public ServiceUnitReviewCallbackHandler(String baseUrl) {

		serviceUnitMap = new LinkedHashMap<String, ServiceUnitReviews>();
		this.baseUrl = baseUrl;
	}

	public Collection<ServiceUnitReviews> getServiceCategory() {
		return serviceUnitMap.values();
	}
	
	public List<Map<String,String>>  getResult()
	{
		return retList;
	}

	public void processRow(ResultSet rs) throws SQLException {
		String package_id = rs.getString("package_id");
		String package_name = rs.getString("package_name");
		String package_cost = rs.getString("package_cost");
		String discount = rs.getString("discount");
		String happy_percent = rs.getString("happy_percent");
		String tts = rs.getString("tts");
		String vendor = rs.getString("vendor");
		String served_nos = rs.getString("served_nos");
		String package_description = rs.getString("package_description");
		String profile_photo = rs.getString("profile_photo");
		String review = rs.getString("review");
		String review_id = rs.getString("review_id");
		String pacakge_image_url = rs.getString("pacakge_image_url");

		ServiceUnitReviews ct = serviceUnitMap.get(package_id);
		if (ct == null) {
			ct = new ServiceUnitReviews();
			ct.package_id = package_id;
			ct.package_name = package_name;
			ct.package_cost = package_cost;
			ct.discount = discount;
			ct.happy_percent = happy_percent;
			ct.tts = tts;
			ct.vendor = vendor;
			ct.served_nos = served_nos;
			ct.package_description = package_description;
			ct.pacakge_image_url = pacakge_image_url;
			serviceUnitMap.put(package_id, ct);
		}
		ct.addService(new UnitReviews(review_id, review, profile_photo));
	}
}
