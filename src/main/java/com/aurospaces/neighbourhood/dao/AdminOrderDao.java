package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.OrderBean;

public interface AdminOrderDao {
	List<OrderBean> getOrders(OrderBean objOrderBean);
	List<OrderBean> searchPhoneNumber(OrderBean objOrderBean);
	List<OrderBean> searchEmail(OrderBean objOrderBean);
	List<OrderBean> getAllOrders(OrderBean objOrderBean) ;
	OrderBean getServiceId(OrderBean objOrderBean);
	List<OrderBean> getAllPathologyOrders(OrderBean objOrderBean);
}
