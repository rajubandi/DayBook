/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.OrderStatusBean;

/**
 * @author Amit
 *
 */
public interface OrderStatusDao {
	boolean insertOrderStatus(OrderStatusBean objOrderStatusBean);
	boolean updateOrderStatus(OrderStatusBean objOrderStatusBean);
	List<OrderStatusBean> getOrderStatuss(OrderStatusBean objOrderStatusBean, String likeSearch);
	OrderStatusBean getOrderStatus(OrderStatusBean objOrderStatusBean, String likeSearch);
	boolean deleteOrderStatus(OrderStatusBean objOrderStatusBean);
}
