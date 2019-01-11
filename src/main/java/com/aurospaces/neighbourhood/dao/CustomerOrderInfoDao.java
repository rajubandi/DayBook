/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.CustomerBean;

/**
 * @author YOGI
 *
 */
public interface CustomerOrderInfoDao {
	List<CustomerBean> getOrdersOfCustomer(CustomerBean objCustomerBean);
}
