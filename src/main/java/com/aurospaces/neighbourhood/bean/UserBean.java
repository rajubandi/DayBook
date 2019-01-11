package com.aurospaces.neighbourhood.bean;

public class UserBean {
   protected int id   = 0;
   private String name;
   private String password;
   private String rolId;
   private String mobile;
   
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRolId() {
	return rolId;
}
public void setRolId(String rolId) {
	this.rolId = rolId;
}

   
}
