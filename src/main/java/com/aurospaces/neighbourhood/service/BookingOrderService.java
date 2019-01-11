/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import com.aurospaces.neighbourhood.bean.OrderInfoBean;
import com.aurospaces.neighbourhood.bean.ServicesBean;

/**
 * @author YOGI
 *
 */
public interface BookingOrderService {
	boolean insertOrderInformation(OrderInfoBean objOrderBean);
	public ServicesBean getServiceName(ServicesBean objServicesBean); 
}
