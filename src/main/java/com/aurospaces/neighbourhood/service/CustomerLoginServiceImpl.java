/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.CustomerLoginBean;
import com.aurospaces.neighbourhood.bean.LoginBean;
import com.aurospaces.neighbourhood.bean.SMSBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.dao.CustomerDao;
import com.aurospaces.neighbourhood.dao.CustomerLoginDao;
import com.aurospaces.neighbourhood.dao.LoginDao;
import com.aurospaces.neighbourhood.util.SMSUtil;

/**
 * @author Amit
 * 
 */
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
	@Autowired
	CustomerLoginDao objCustomerLoginDao;
	@Autowired 
	LoginDao objLoginDao;
	@Autowired
	CustomerDao objCustomerDao;
	@Autowired
	ServletContext objContext;
	@Override
	public CustomerBean validateCustomerLogin(
			CustomerLoginBean objCustomerLoginBean) {
		CustomerBean localCustomerLoginBean = null;
		VendorRegistrationBean objRegistrationBean = null;
		LoginBean objLoginBean = null;
		try {
			localCustomerLoginBean = objCustomerLoginDao.validateCustomerLogin(objCustomerLoginBean);
			if(localCustomerLoginBean == null){
				localCustomerLoginBean = new CustomerBean();
				objRegistrationBean = objCustomerLoginDao.validateVendorLogin(objCustomerLoginBean);
				localCustomerLoginBean.setRoleId(3);
				if(objRegistrationBean != null){
					localCustomerLoginBean.setObjVendorRegistrationBean(objRegistrationBean);
				}else{
					objLoginBean = new LoginBean();
					objLoginBean.setUserName(objCustomerLoginBean.getMobileOrEmail());
					objLoginBean.setPassword(objCustomerLoginBean.getPassword());
					LoginBean localLoginBean  = objLoginDao.getUserDetails(objLoginBean);
					if(localLoginBean != null){
						localCustomerLoginBean.setRoleId(1);
					}else{
						localCustomerLoginBean = null;
					}
					
				}
			}else{
				localCustomerLoginBean.setRoleId(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localCustomerLoginBean;
	}
	@Override
	public boolean resetPassword(CustomerBean objCustomerBean) {
		boolean isCustomerUpdate = false;
		SMSBean objSmsBean = null;
		SMSUtil objSmsUtil = null;
		try {
			isCustomerUpdate = objCustomerDao.resetPassword(objCustomerBean);
			if(isCustomerUpdate){
				objSmsBean = new SMSBean();
				objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
				objSmsBean.setCustomerId(objCustomerBean.getMobileNumber());
				objSmsBean.setPassword(objCustomerBean.getPassword());
				if(StringUtils.isNotBlank(objSmsBean.getCustomerId()) && StringUtils.isNotBlank(objSmsBean.getPassword())){
					objSmsUtil = new SMSUtil();
					//objSmsUtil.sendSms(objContext, objSmsBean, "customer_username");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCustomerUpdate;
	}
}
