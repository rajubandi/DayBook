package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.bean.VendorOrderBean;

public interface VendorOrderDao {
	boolean insertVendorOrder(VendorOrderBean objVendorOrderBean);
	public List<OrderBean> getOrders(OrderBean objorOrderBean);
	

}
