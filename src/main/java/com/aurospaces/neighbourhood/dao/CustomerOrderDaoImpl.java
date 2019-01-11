/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerOrderBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author YOGI
 *
 */
@Repository
public class CustomerOrderDaoImpl extends DaoSupport implements CustomerOrderDao{

	@Override
	public boolean insertCustomerOrder(CustomerOrderBean objCustomerOrderBean) {
		try {
			String sSql ="insert into customer_order (orderId, customerId) values(?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objCustomerOrderBean.getOrderId(),
					objCustomerOrderBean.getCustomerId()
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return false;
	}

	
}
