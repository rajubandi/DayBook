/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.CustomerLoginBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;


/**
 * @author Amit
 *
 */
public interface CustomerLoginDao {
	CustomerBean validateCustomerLogin(CustomerLoginBean objCustomerLoginBean);
	VendorRegistrationBean validateVendorLogin(CustomerLoginBean objCustomerLoginBean);
}
