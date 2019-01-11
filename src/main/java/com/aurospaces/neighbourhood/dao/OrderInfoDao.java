package com.aurospaces.neighbourhood.dao;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.OrderInfoBean;

public interface OrderInfoDao {
	boolean insertOrderInfo(OrderInfoBean objOrderInfoBean);
	boolean updateOrderInfo(OrderInfoBean objOrderInfoBean);
	public CustomerBean getCustomerDetails(OrderInfoBean objOrderInfoBean);
}
