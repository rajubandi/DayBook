package com.aurospaces.neighbourhood.service;

import java.util.List;
import com.aurospaces.neighbourhood.bean.OrderBean;

public interface AdminOrderService {
	List<OrderBean> getOrders(OrderBean objOrderBean);
	public boolean assigntoVendor(OrderBean objOrderBean);
	List<OrderBean> searchPhoneNumber(OrderBean objOrderBean);
	List<OrderBean> searchEmail(OrderBean objOrderBean);
	List<OrderBean> getAllOrders(OrderBean objOrderBean) ;
	OrderBean getServiceId(OrderBean objOrderBean);
	List<OrderBean> getAllPathologyOrders(OrderBean objOrderBean);
}
