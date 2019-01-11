package com.aurospaces.neighbourhood.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderUserBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class OrderUserDaoImpl extends DaoSupport implements OrderUserDao {
	Logger objLogger = Logger.getLogger(OrderUserDaoImpl.class);

	@Override
	public boolean isInserOrderUser(OrderUserBean objOrderUserBean) {
		boolean isIsertOrderUser = false;
		String sSql = null;
		try {
			sSql = "insert into order_user(orderId, userId) values(?,?)";
			getJdbcTemplate().update(
					sSql,
					new Object[] { objOrderUserBean.getOrderId(),
							objOrderUserBean.getCustomerId() });
			isIsertOrderUser = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isIsertOrderUser;
	}

}
