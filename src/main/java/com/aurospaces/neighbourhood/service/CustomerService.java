/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.CustomerBean;

/**
 * @author Amit
 *
 */
public interface CustomerService {
	String insertCustomer(CustomerBean objCustomerBean);
	boolean updateCustomer(CustomerBean objCustomerBean);
	List<CustomerBean> getCustomers(CustomerBean objCustomerBean, String likeSearch);
	CustomerBean getCustomer(CustomerBean objCategoryBean, String likeSearch);
	boolean deleteCustomer(CustomerBean objCustomerBean);
	
	
}
