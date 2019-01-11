/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.CustomerBean;

/**
 * @author YOGI
 *
 */
public interface CustomerOrderInfoService {
	List<CustomerBean> getOrdersOfCustomer(CustomerBean objCustomerBean);
}
