/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.UserRoleBean;
import com.aurospaces.neighbourhood.dao.CustomerDao;
import com.aurospaces.neighbourhood.dao.CustomerDiscountDao;
import com.aurospaces.neighbourhood.dao.UserRoleDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author kanojia
 * 
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao objCustomerDao;
	@Autowired
	UserRoleDao objUserRoleDao;
	@Autowired
	UserRoleBean objUserRoleBean;
	@Autowired
	CustomerDiscountDao objCustomerDiscountDao;
	@Autowired
	DataSourceTransactionManager transactionManager;
	@Autowired
	ServletContext objContext;

	@Override
	public String insertCustomer(CustomerBean objCustomerBean) {
		boolean isCustomerInsert = false;
		boolean isUserRoleInsert = false;
		boolean isCustomerDiscInsert = false;
		TransactionStatus objTransStatus = null;
		TransactionDefinition objTransDef = null;
		String sCustomerId = null;
		try {
			sCustomerId = new NeighbourhoodUtil().getGUId();
			objTransDef = new DefaultTransactionDefinition();
			objTransStatus = transactionManager.getTransaction(objTransDef);
			if (sCustomerId != null) {
				objCustomerBean.setCustomerId(sCustomerId);
				isCustomerInsert = objCustomerDao
						.insertCustomer(objCustomerBean);
				if (isCustomerInsert) {
					objUserRoleBean.setUserId(sCustomerId);
					objUserRoleBean.setRoleId(2);
					isUserRoleInsert = objUserRoleDao
							.isInserUserRole(objUserRoleBean);
					if (isUserRoleInsert) {
						System.out.println("success customer registration...");
						transactionManager.commit(objTransStatus);
					} else {
						System.out
								.println("roll back customer registration...");
						transactionManager.rollback(objTransStatus);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return sCustomerId;
	}

	@Override
	public boolean updateCustomer(CustomerBean objCustomerBean) {
		boolean isCustomerUpdate = false;
		try {
			isCustomerUpdate = objCustomerDao.updateCustomer(objCustomerBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCustomerUpdate;
	}

	@Override
	public List<CustomerBean> getCustomers(CustomerBean objCustomerBean,
			String likeSearch) {
		List<CustomerBean> listCustomerBeans = null;
		try {
			System.out.println("this is for testing purpose...");
			listCustomerBeans = objCustomerDao.getCustomers(objCustomerBean,
					likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listCustomerBeans;
	}

	@Override
	public CustomerBean getCustomer(CustomerBean objCustomerBean,
			String likeSearch) {
		CustomerBean objEditCatBean = null;
		try {
			objEditCatBean = objCustomerDao.getCustomer(objCustomerBean,
					likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objEditCatBean;
	}

	@Override
	public boolean deleteCustomer(CustomerBean objCustomerBean) {
		boolean isCustomerDelete = false;
		try {
			isCustomerDelete = objCustomerDao.deleteCustomer(objCustomerBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCustomerDelete;
	}
}
