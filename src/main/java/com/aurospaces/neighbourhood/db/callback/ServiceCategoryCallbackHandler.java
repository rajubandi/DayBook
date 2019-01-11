package com.aurospaces.neighbourhood.db.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.aurospaces.neighbourhood.custommodel.Service;
import com.aurospaces.neighbourhood.custommodel.ServiceCategory;



public class ServiceCategoryCallbackHandler implements RowCallbackHandler
{

	public LinkedHashMap<String,ServiceCategory> serviceCategory;

	public String baseUrl ;


	public ServiceCategoryCallbackHandler(String baseUrl)
	{

			serviceCategory = new LinkedHashMap<String,ServiceCategory>();
			this.baseUrl = baseUrl;
	}	


	public Collection<ServiceCategory> getServiceCategory()
	{
		return serviceCategory.values();
	}

	

public void processRow(ResultSet rs) throws SQLException 
{
	
	String category_id = rs.getString("category_id");
	String category_name = rs.getString("category_name");
	String service_id = rs.getString("service_id");
	String service_name = rs.getString("service_name");
	String service_image = baseUrl + "/" + rs.getString("img");
	String category_image = baseUrl + "/" + rs.getString("cimg");

	ServiceCategory ct = serviceCategory.get(category_id);
	if(ct == null)	
	{
		ct = new ServiceCategory();
		ct.category_id = category_id;
		ct.category_name = category_name;
		ct.category_image = category_image;
		serviceCategory.put(category_id,ct);
	}	 
	ct.addService(new Service(service_id,service_name, service_image));
}
	
}