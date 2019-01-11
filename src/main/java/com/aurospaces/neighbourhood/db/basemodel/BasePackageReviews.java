package com.aurospaces.neighbourhood.db.basemodel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import java.util.Date;
import java.math.BigDecimal;


/**
 *
 * @author autogenerated
 */



public class BasePackageReviews 
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
@Column(name= "service_unit_id")
protected int serviceUnitId ;

/** Field mapping. **/
@Column(name= "name")
protected String name ;

/** Field mapping. **/
@Column(name= "profile_pic")
protected String profilePic ;

/** Field mapping. **/
@Column(name= "review")
protected String review ;

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
public int getServiceUnitId()
{
  return serviceUnitId;
}
public void setServiceUnitId(final int serviceUnitId)
{
  this.serviceUnitId = serviceUnitId;
}
public String getName()
{
  return name;
}
public void setName(final String name)
{
  this.name = name;
}
public String getProfilePic()
{
  return profilePic;
}
public void setProfilePic(final String profilePic)
{
  this.profilePic = profilePic;
}
public String getReview()
{
  return review;
}
public void setReview(final String review)
{
  this.review = review;
}

}