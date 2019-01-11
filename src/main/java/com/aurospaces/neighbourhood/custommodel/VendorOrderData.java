package com.aurospaces.neighbourhood.custommodel;

public class VendorOrderData
{

	public VendorOrderData()
	{
			location = new LatLong();
	}

	public String order_id ;	
	public void setOrder_id(String inId)
	{
		this.order_id = inId;
	}
	public String category ;	
	public void setCategory(String inId)
	{
		this.category = inId;
	}
	public String img_url ;	
	public void setImg_url(String inId)
	{
		this.img_url = inId;
	}
	public String email ;	
	public void setEmail(String inId)
	{
		this.email = inId;
	}
	public String details ;	
	public void setDetails(String inId)
	{
		this.details = inId;
	}
	public LatLong location ;	
	public void setLatitude(String inId)
	{
		this.location.setLatitude(inId);
	}
	public void setLongitude(String inId)
	{
		this.location.setLongitude(inId);
	}
	public String order_status ;	
	public void setOrder_status(String inId)
	{
		this.order_status = inId;
	}
	public String order_status_id ;	
	public void setOrder_status_id(String inId)
	{
		this.order_status_id = inId;
	}


	public String mobile ;	
	public void setMobile(String inId)
	{
		this.mobile = inId;
	}
	public String address ;	
	public void setAddress(String inId)
	{
		this.address = inId;
	}
	public String day_slot ;	
	public void setDay_slot(String inId)
	{
		this.day_slot = inId;
	}
	public String time_slot ;	
	public void setTime_slot(String inId)
	{
		this.time_slot = inId;
	}
	public String name ;	
	public void setName(String inId)
	{
		this.name = inId;
	}



}
