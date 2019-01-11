package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderLocationBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class OrderLocationDaoImpl extends DaoSupport implements OrderLocationDao {

	@Override
	public boolean insertOrderLocation(OrderLocationBean objOrderLocationBean) {
		boolean isInsert = false;
		try {
			String sSql = "insert into order_location(locationId,orderId) values(?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objOrderLocationBean.getLocationId(),
					objOrderLocationBean.getOrderId()
			});
		isInsert = true;
		System.out.println(sSql);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

	}
	return isInsert;
	}

}
