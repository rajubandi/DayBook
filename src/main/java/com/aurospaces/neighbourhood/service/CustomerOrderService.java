/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.CustomerOrderBean;

/**
 * @author Amit
 *
 */
public interface CustomerOrderService {
	boolean insertCustomerOrder(CustomerOrderBean objCustomerOrderBean);
	boolean updateCustomerOrder(CustomerOrderBean objCustomerOrderBean);
	List<CustomerOrderBean> getCustomerOrders(CustomerOrderBean objCustomerOrderBean, String likeSearch);
	CustomerOrderBean getCustomerOrder(CustomerOrderBean objCustomerOrderBean, String likeSearch);
	boolean deleteCustomerOrder(CustomerOrderBean objCustomerOrderBean);
}
