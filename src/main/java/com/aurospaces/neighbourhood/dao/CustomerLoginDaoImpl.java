/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.CustomerLoginBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class CustomerLoginDaoImpl extends DaoSupport implements
		CustomerLoginDao {

	@Override
	public CustomerBean validateCustomerLogin(
			CustomerLoginBean objCustomerLoginBean) {
		CustomerBean objResultCustomerBean = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from customer");
			if (objCustomerLoginBean != null) {
				if (objCustomerLoginBean.getMobileOrEmail().contains("@")) {
					objStringBuffer.append(" where email='"
							+ objCustomerLoginBean.getMobileOrEmail() + "'");
				} else {
					objStringBuffer.append(" where mobileNumber='"
							+ objCustomerLoginBean.getMobileOrEmail() + "'");
				}
				objStringBuffer.append(" and password ='"
						+ objCustomerLoginBean.getPassword() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			List<CustomerBean> listCustomerBean = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<CustomerBean>(
							CustomerBean.class));
			if(listCustomerBean != null && listCustomerBean.size()>0 ){
				System.out.println(listCustomerBean.size());
				objResultCustomerBean = listCustomerBean.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return objResultCustomerBean;
	}
	@Override
	public VendorRegistrationBean validateVendorLogin(CustomerLoginBean objCustomerLoginBean) {
		VendorRegistrationBean objVendorRegistrationBean = null;
		List<VendorRegistrationBean> listRegistrationBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from vendor_profile");
			if (objCustomerLoginBean != null) {
				if (objCustomerLoginBean.getMobileOrEmail().contains("@")) {
					objStringBuffer.append(" where email='"
							+ objCustomerLoginBean.getMobileOrEmail() + "'");
				} else {
					objStringBuffer.append(" where mobileNo='"
							+ objCustomerLoginBean.getMobileOrEmail() + "'");
				}
				objStringBuffer.append(" and password ='"
						+ objCustomerLoginBean.getPassword() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listRegistrationBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<VendorRegistrationBean>(
							VendorRegistrationBean.class));
			if(listRegistrationBeans!= null && listRegistrationBeans.size()>0){
				objVendorRegistrationBean=	listRegistrationBeans.get(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return objVendorRegistrationBean;
	}
}
