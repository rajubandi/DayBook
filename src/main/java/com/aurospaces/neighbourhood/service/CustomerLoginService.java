/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.CustomerLoginBean;

/**
 * @author Amit
 *
 */
public interface CustomerLoginService {
	CustomerBean validateCustomerLogin(CustomerLoginBean objCustomerLoginBean) ;
	boolean resetPassword(CustomerBean objCustomerBean);
}
