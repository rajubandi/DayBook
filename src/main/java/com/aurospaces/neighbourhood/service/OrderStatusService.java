/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.OrderStatusBean;

/**
 * @author Amit
 *
 */
public interface OrderStatusService {
	boolean insertOrderStatus(OrderStatusBean objOrderStatusBean);
	boolean updateOrderStatus(OrderStatusBean objOrderStatusBean);
	List<OrderStatusBean> getOrderStatuss(OrderStatusBean objOrderStatusBean, String likeSearch);
	OrderStatusBean getOrderStatus(OrderStatusBean objOrderStatusBean, String likeSearch);
	boolean deleteOrderStatus(OrderStatusBean objOrderStatusBean);
}
