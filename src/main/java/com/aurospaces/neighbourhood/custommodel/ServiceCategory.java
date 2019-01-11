package com.aurospaces.neighbourhood.custommodel;


import java.util.LinkedHashSet;
import java.util.Set;


public class ServiceCategory
{


	public String category_id;

	public String category_name;
	
	public String category_image;


//	@JsonProperty("service_list")
//	public Arraylist<Service>  serviceList; 

	public Set<Service> service_list;

	public void addService(Service newCat)
	{
		service_list.add(newCat);
	}

	public ServiceCategory()
	{
		service_list = new LinkedHashSet<Service>();
	}

}
