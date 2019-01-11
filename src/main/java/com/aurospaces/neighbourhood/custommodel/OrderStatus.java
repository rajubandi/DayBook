package com.aurospaces.neighbourhood.custommodel;

public class OrderStatus
{

public OrderStatus()
{
	this.name = null;
	this.id = "";
	this.is_done = false;
}

public OrderStatus(String name, String  id)
{
	this.name = name;
	this.id  = id;
	this.is_done = false;
}

public void setId(String id)
{
	this.id = id;
}

public void setName(String name)
{
	this.name = name;
}

public void setIs_done(boolean indone)
{
	this.is_done = indone;
}


public String id;
public String name;
public boolean is_done;

public void setDone()
{
	is_done = true;
}

}
