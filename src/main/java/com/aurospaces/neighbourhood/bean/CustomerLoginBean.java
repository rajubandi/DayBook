/**
 * 
 */
package com.aurospaces.neighbourhood.bean;


/**
 * @author yogi
 * 
 */
public class CustomerLoginBean {

	private String mobileOrEmail;
	private String password;
	

	/**
	 * @return the mobileOrEmail
	 */
	public String getMobileOrEmail() {
		return mobileOrEmail;
	}

	/**
	 * @param mobileOrEmail
	 *            the mobileOrEmail to set
	 */
	public void setMobileOrEmail(String mobileOrEmail) {
		this.mobileOrEmail = mobileOrEmail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
