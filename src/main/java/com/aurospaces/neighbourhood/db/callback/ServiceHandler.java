/*package com.aurospaces.neighbourhood.db.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.aurospaces.neighbourhood.custommodel.Service;
import com.aurospaces.neighbourhood.custommodel.ServiceCategory;



public class ServiceHandler implements RowCallbackHandler
{

	public LinkedHashMap<String,ServiceCategory> serviceCategory;

	public String baseUrl ;


	public ServiceHandler(String baseUrl)
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
	
	
	
	String service_id = rs.getString("service_id");
	String service_name = rs.getString("service_name");
	String service_image = baseUrl + "/" + rs.getString("img");
	String description =  rs.getString("description");

	 
	ct.addService(new Service(service_id,service_name, service_image));
}
	
}*/