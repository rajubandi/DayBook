/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.dao.CustomerOrderInfoDao;

/**
 * @author YOGI
 * 
 */
@Service
public class CustomerOrderInfoServiceImpl implements CustomerOrderInfoService {
	@Autowired
	CustomerOrderInfoDao objCustomerOrderInfoDao;

	@Override
	public List<CustomerBean> getOrdersOfCustomer(CustomerBean objCustomerBean) {
		List<CustomerBean> listCustomerBeans = null;
		try {
			listCustomerBeans = objCustomerOrderInfoDao.getOrdersOfCustomer(objCustomerBean);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
		return listCustomerBeans;
	}

}
