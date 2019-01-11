/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.stereotype.Component;

/**
 * @author YOGI
 * 
 */
@Component
public class UserRoleBean {
	private String userId;
	private int roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
