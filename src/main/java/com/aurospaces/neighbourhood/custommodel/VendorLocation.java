package com.aurospaces.neighbourhood.custommodel;



public class VendorLocation
{


	public VendorLocation()
	{
	}


	public boolean equals(Object rhs)
	{
		if(rhs instanceof VendorLocation)
		{
			VendorLocation rhsS = (VendorLocation)rhs;
			return  rhsS.name.equals(name);
		}
		return false;
	}

	public int hashCode()
	{
		return name.hashCode();
	}

	public void setName(String input)
	{
		name = input;
	}
	public void setLatitude(Double input)
	{
		latitude = input;
	}
	public void setLongitude(Double input)
	{
		longitude = input;
	}
	public void setId(int input)
	{
		id = input;
	}

	public Double latitude;
	public Double longitude;
	public String name;
	public int id;


}
