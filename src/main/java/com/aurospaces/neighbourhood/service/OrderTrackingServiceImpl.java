package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.OrderTrackingBean;
import com.aurospaces.neighbourhood.dao.OrderTrackingDao;
@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {
@Autowired
OrderTrackingDao objOrderTrackingDao;
	@Override
	public List<OrderTrackingBean> getTypes(OrderTrackingBean objTrackingBean) {
		List<OrderTrackingBean> listTracking=null;
		try {
			listTracking=objOrderTrackingDao.getTypes(objTrackingBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
		}
		return listTracking;
		
		
	}

}
