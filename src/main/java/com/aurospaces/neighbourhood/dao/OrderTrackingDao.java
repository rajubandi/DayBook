package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.aurospaces.neighbourhood.bean.OrderTrackingBean;


public interface OrderTrackingDao {
	
	
	List<OrderTrackingBean> getTypes(OrderTrackingBean objTrackingBean);

}
