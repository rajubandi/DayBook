package com.aurospaces.neighbourhood.custommodel;

public class Service
{

	public Service(String id, String name, String img_url)
	{
		service_id = id;
		service_name = name;
		service_image = img_url;
	}

	public Service()
	{
	}


	public boolean equals(Object rhs)
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
	}


//	@JsonProperty("service_list")
//	public Arraylist<Service>  serviceList; 

}
/*
       public int service_id;
			 -       public String service_name;
			 -       public String service_image;
			 -
			 -       public int getService_id() {
			 -               return service_id;
			 -       }
			 -
			 -       public void setService_id(int service_id) {
			 -               this.service_id = service_id;
			 -       }
			 -
			 -       public String getService_name() {
			 -               return service_name;
			 -       }
			 -
			 -       public void setService_name(String service_name) {
			 -               this.service_name = service_name;
			 -       }
			 -
			 -       public String getService_image() {
			 -               return service_image;
			 -       }
			 -
			 -       public void setService_image(String service_image) {
			 -               this.service_image = service_image;
			 -       }
			 -
			 -

*/
