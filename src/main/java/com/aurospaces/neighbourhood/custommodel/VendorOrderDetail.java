package com.aurospaces.neighbourhood.custommodel;




import com.aurospaces.neighbourhood.db.model.OrderSequence;

import java.util.*;

public class VendorOrderDetail
{

	public VendorOrderDetail()
	{
			location = new LatLong();
	}
	public String service_id ;	
	public void setService_id(String inId)
	{
		this.service_id = inId;
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

	public List<OrderStatus> order_status ;	

	public void setStatusList(OrderSequence seq)
	{
		this.order_status =  seq.getSequence();
	}

	public String order_status_id ;	
	public void setOrder_status_id(String inId)
	{
		this.order_status_id = inId;
	}

	public void setStatus(OrderSequence seq)
	{
		this.order_status =  seq.getSequence();
		for(OrderStatus stat : order_status)
		{
			stat.setDone();
			if(stat.id.equals(order_status_id))
			{
				break;
			}
		}
	}



}
