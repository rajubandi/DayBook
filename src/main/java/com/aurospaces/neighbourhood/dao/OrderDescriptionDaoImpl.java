package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderDescriptionBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class OrderDescriptionDaoImpl extends DaoSupport implements OrderDescriptionDao {

	@Override
	public boolean insertOrderDescription(
			OrderDescriptionBean objOrderDescriptionBean) {
		boolean isInsert = false;
		try {
			String sSql = "insert into order_description(orderId, orderDescription) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objOrderDescriptionBean.getOrderId(),
									objOrderDescriptionBean.getOrderDescription()
									});
			System.out.println(iCount);
			if (iCount != 0) {

				isInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInsert;
	}

}
