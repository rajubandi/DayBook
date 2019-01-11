/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderBean;

/**
 * @author YOGI
 *
 */
@Repository
public interface BookingOrderDao {
	boolean insertOrderInformation(OrderBean objOrderBean);
}
