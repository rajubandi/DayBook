/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author YOGI
 * 
 */
@Repository
public class CustomerDiscountDaoImpl extends DaoSupport implements
		CustomerDiscountDao {

	@Override
	public boolean isInsertCustomerDiscount(CustomerBean objCustomerBean) {
		String sSql = null;
		boolean isInsertCustomerDisc = false;
		try {
			sSql = "insert into customer_discount (customerId,registerDate, customerDiscount, orderId) values(?,?,?,?)";
			getJdbcTemplate().update(
					sSql,
					new Object[] { objCustomerBean.getCustomerId(),
							objCustomerBean.getRegisterDate(),
							objCustomerBean.getCustomerDiscount(), 
							objCustomerBean.getOrderId()});
			isInsertCustomerDisc = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInsertCustomerDisc;
	}

}
