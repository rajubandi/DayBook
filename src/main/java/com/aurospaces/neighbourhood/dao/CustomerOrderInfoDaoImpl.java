/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author YOGI
 * 
 */
@Repository
public class CustomerOrderInfoDaoImpl extends DaoSupport implements
		CustomerOrderInfoDao {

	@Override
	public List<CustomerBean> getOrdersOfCustomer(CustomerBean objCustomerBean) {
		List<CustomerBean> listCustomerBeans = null;
		try {
			String sSql = "SELECT * FROM customer c, `customer_order` co  WHERE c.`customerId` = co.`customerId` AND c.`customerId` = '"
					+ objCustomerBean.getCustomerId() + "'";
			listCustomerBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<CustomerBean>(
									CustomerBean.class));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
		return listCustomerBeans;
	}

}
