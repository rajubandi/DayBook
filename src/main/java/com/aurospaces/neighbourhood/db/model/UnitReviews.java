package com.aurospaces.neighbourhood.db.model;

public class UnitReviews {
	public String id;
	public String profile_photo;
	public String review;

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
	
	public UnitReviews(String id,  String review,String profile_photo)
	{
		this.id = id;
		this.profile_photo = profile_photo;
		this.review = review;
	}

	public UnitReviews()
	{
	}


	/*public boolean equals(Object rhs)
	{
		if(rhs instanceof Service)
		{
			Service rhsS = (Service)rhs;
			return  rhsS.service_id.equals(service_id);
		}
		return false;
	}

	public int hashCode()
	{
		return service_id.hashCode();
	}

	public void setService_id(String input)
	{
		service_id = input;
	}
	public void setService_name(String input)
	{
		service_name = input;
	}
	public void setService_image(String input)
	{
		service_image = input;
	}

	public String service_id;
	public String service_name;
	public String service_image;


	public String getService_id()
	{
		return service_id;
	}
	public String getService_name()
	{
		return service_name;
	}
	public String getService_image()
	{
		return service_image;
	}*/
}
