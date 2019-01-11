package com.aurospaces.neighbourhood.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderServiceBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class OrderServiceDaoImpl extends DaoSupport implements OrderServiceDao {
	Logger objLogger = Logger.getLogger(OrderServiceDaoImpl.class);

	@Override
	public boolean isInsertOrderService(OrderServiceBean objOrderServiceBean) {
		boolean isInsertOrderService = false;
		String sSql = null;
		try {
			System.out.println(objOrderServiceBean.getOrderId());
			System.out.println(objOrderServiceBean.getServiceId());
			sSql = "insert into order_service(orderId, serviceId) values(?,?)";
			getJdbcTemplate().update(
					sSql,
					new Object[] { objOrderServiceBean.getOrderId(),
							objOrderServiceBean.getServiceId() });
			isInsertOrderService = true;
		} catch (Exception e) {
			e.printStackTrace();
			objLogger.error("error in isInsertOrderService() in orderServiceDaoImpl");
			objLogger.fatal("error in isInsertOrderService() in orderServiceDaoImpl");
		} finally {

		}
		return isInsertOrderService;
	}

}
