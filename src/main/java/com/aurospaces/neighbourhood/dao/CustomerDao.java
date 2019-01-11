/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.CustomerBean;

/**
 * @author Amit
 *
 */
public interface CustomerDao {
	boolean insertCustomer(CustomerBean objCustomerBean);
	boolean updateCustomer(CustomerBean objCustomerBean);
	List<CustomerBean> getCustomers(CustomerBean objCustomerBean, String likeSearch);
	boolean deleteCustomer(CustomerBean objCustomerBean);
	CustomerBean getCustomer(CustomerBean objCustomerBean, String likeSearch);
	List<CustomerBean> validateCustomers(CustomerBean objCustomerBean);
	boolean resetPassword(CustomerBean objCustomerBean);
}
