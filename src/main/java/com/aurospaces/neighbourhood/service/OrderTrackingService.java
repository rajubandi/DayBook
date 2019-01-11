package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.OrderTrackingBean;

public interface OrderTrackingService {
	List<OrderTrackingBean> getTypes(OrderTrackingBean objTrackingBean);
}
