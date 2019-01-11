/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public  class CustomerDaoImpl extends DaoSupport implements CustomerDao {

	@Override
	public boolean insertCustomer(CustomerBean objCustomerBean){
		boolean isExperienceInsert = false;
		try {
			String sSql = "insert into customer(customerId, customerName, mobileNumber, email, address1, address2, city, pinCode,state, password) values(?,?,?,?,?,?,?,?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objCustomerBean.getCustomerId(),
							objCustomerBean.getCustomerName(),
							objCustomerBean.getMobileNumber(),
							objCustomerBean.getEmail(),
							objCustomerBean.getAddress1(),
							objCustomerBean.getAddress2(),
							objCustomerBean.getCity(),
							objCustomerBean.getPincode(),
							objCustomerBean.getState(),
							objCustomerBean.getPassword()});
			System.out.println(iCount);
			if (iCount != 0) {
				isExperienceInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isExperienceInsert;
	}
	@Override
	public boolean updateCustomer(CustomerBean objCustomerBean) {
		boolean isCustomerUpdate = false;
		try {
			String sSql = "update customer set customerName=?, mobileNumber=?, email=?, address1=?, address2=?, city=?, pinCode=?,state=?, password =?  where customerId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objCustomerBean.getCustomerName(),
					objCustomerBean.getMobileNumber(),
					objCustomerBean.getEmail(),
					objCustomerBean.getAddress1(),
					objCustomerBean.getAddress2(), 
					objCustomerBean.getCity(),
					objCustomerBean.getPincode(),
					objCustomerBean.getState(),
					objCustomerBean.getPassword(),
					objCustomerBean.getCustomerId());
			System.out.println(sSql);
			if (iCount != 0) {
				isCustomerUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCustomerUpdate;
	}

	@Override
	public List<CustomerBean> getCustomers(CustomerBean objCustomerBean, String likeSearch) {
		List<CustomerBean> listCustomerBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from customer");
			if (objCustomerBean.getCustomerName() != null) {
				if("both".equals(likeSearch)){
				objStringBuffer.append(" where customerName like '%"
						+ objCustomerBean.getCustomerName() + "%'");
				}
				else if("left".equals(likeSearch)){
					objStringBuffer.append(" where customerName like '%"
							+ objCustomerBean.getCustomerName() + "'");
				}else if("right".equals(likeSearch)){
					objStringBuffer.append(" where customerName like '"
							+ objCustomerBean.getCustomerName() + "%'");
				}else {
					objStringBuffer.append(" where customerName = '"
							+ objCustomerBean.getCustomerName() + "'");
				}
				
			}
			if (objCustomerBean.getCustomerId() != null) {
				objStringBuffer.append(" and CustomerId != '"
						+ objCustomerBean.getCustomerId() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
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

	@Override
	public CustomerBean getCustomer(CustomerBean objCustomerBean, String likeSearch) {
		CustomerBean objCatBean = null;
		StringBuffer objStringBuffer = null;
		String sSql = null;
		try {
			if(objCustomerBean != null){
				objStringBuffer = new StringBuffer();
				objStringBuffer.append("select * from customer ");
				if(StringUtils.isNotEmpty(objCustomerBean.getCustomerId())){
					objStringBuffer.append("where customerId ='"
						+ objCustomerBean.getCustomerId() + "'");
				}
				if(StringUtils.isNotEmpty(objCustomerBean.getMobileNumber())){
					objStringBuffer.append("where mobileNumber ='"
						+ objCustomerBean.getMobileNumber() + "'");
				}
				 sSql = objStringBuffer.toString();
				objCatBean = getJdbcTemplate().queryForObject(sSql,new BeanPropertyRowMapper<CustomerBean>(CustomerBean.class));
			}
		} catch (Exception e) {
			logger.fatal("error in getCustomer() in customerDaoImpl");
		} finally {

		}
		return objCatBean;
	}

	@Override
	public boolean deleteCustomer(CustomerBean objCustomerBean) {
		boolean isCustomerDelete = false;
		try {
			String sSql = "delete from customer where customerId ='"
					+ objCustomerBean.getCustomerId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isCustomerDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCustomerDelete;
	}

	@Override
	public List<CustomerBean> validateCustomers(CustomerBean objCustomerBean) {
			List<CustomerBean> listCustomerBeans= null;
			StringBuffer objStringBuffer = null;
			String sSql = null;
			try {
				if(objCustomerBean != null){
					objStringBuffer = new StringBuffer();
					objStringBuffer.append("select * from customer ");
					if(StringUtils.isNotEmpty(objCustomerBean.getCustomerId())){
						objStringBuffer.append("where customerId ='"
							+ objCustomerBean.getCustomerId() + "'");
					}
					if(StringUtils.isNotEmpty(objCustomerBean.getMobileNumber())){
						objStringBuffer.append("where mobileNumber ='"
							+ objCustomerBean.getMobileNumber() + "'");
					} if(StringUtils.isNotEmpty(objCustomerBean.getPassword())){
						objStringBuffer.append("and BINARY  password='"
								+ objCustomerBean.getPassword() + "'");
					}
					 sSql = objStringBuffer.toString();
					 listCustomerBeans = getJdbcTemplate().query(sSql,new BeanPropertyRowMapper<CustomerBean>(CustomerBean.class));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
			return listCustomerBeans;
		}
	@Override
	public boolean resetPassword(CustomerBean objCustomerBean) {
		boolean isCustomerUpdate = false;
		String sSql = null;
		int iCount =0;
		try {
			 sSql = "update customer set password=? where mobileNumber = ?";
			 iCount = getJdbcTemplate().update(sSql,
					objCustomerBean.getPassword(),
					objCustomerBean.getMobileNumber());
			System.out.println(sSql);
			if (iCount != 0) {
				isCustomerUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCustomerUpdate;
	}

	
	
}





