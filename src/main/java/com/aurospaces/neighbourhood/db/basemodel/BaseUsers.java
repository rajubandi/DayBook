package com.aurospaces.neighbourhood.db.basemodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseUsers 
{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
/** Field mapping. **/
@Column(name= "id")
protected int id   = 0;

/** Field mapping. **/
@Column(name= "created_time")
protected Date createdTime ;

/** Field mapping. **/
@Column(name= "updated_time")
protected Date updatedTime ;

/** Field mapping. **/
@Column(name= "name")
protected String name ;

/** Field mapping. **/
@Column(name= "password")
protected String password ;

/** Field mapping. **/
@Column(name= "location_id")
protected Integer locationId ;

/** Field mapping. **/
@Column(name= "display_name")
protected String displayName ;

public int getId()
{
  return id;
}

public void setId(final int id)
{
  this.id = id;
}

public Date getCreatedTime()
{
  return createdTime;
}

public void setCreatedTime(final Date createdTime)
{
  this.createdTime = createdTime;
}

public Date getUpdatedTime()
{
  return updatedTime;
}

public void setUpdatedTime(final Date updatedTime)
{
  this.updatedTime = updatedTime;
}

public String getName()
{
  return name;
}

public void setName(final String name)
{
  this.name = name;
}

public String getPassword()
{
  return password;
}

public void setPassword(final String password)
{
  this.password = password;
}

public Integer getLocationId()
{
  return locationId;
}

public void setLocationId(final Integer locationId)
{
  this.locationId = locationId;
}

public String getDisplayName()
{
  return displayName;
}

public void setDisplayName(final String displayName)
{
  this.displayName = displayName;
}
}