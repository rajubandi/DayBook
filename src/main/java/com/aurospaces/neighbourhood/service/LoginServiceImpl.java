/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.LocationBean;
import com.aurospaces.neighbourhood.bean.LoginBean;
import com.aurospaces.neighbourhood.dao.LoginDao;

/**
 * @author YOGI
 * 
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDao objLoginDao;

	@Override
	public LoginBean getUserDetails(LoginBean objLoginBean) {
		LoginBean localBean = null;
		try {
			localBean = objLoginDao.getUserDetails(objLoginBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return localBean;
	}

	@Override
	public List<LocationBean> getServicesBasedOnLocations(
			LocationBean objLocationBean) {
		List<LocationBean> listLocationBeans = null;
		try {
			listLocationBeans = objLoginDao
					.getServicesBasedOnLocations(objLocationBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listLocationBeans;
	}
	
	@Override
	public List<LocationBean> getLocationBasedServices(
			LocationBean objLocationBean) {
		List<LocationBean> listLocationBeans = null;
		try {
			listLocationBeans = objLoginDao.getLocationBasedServices(objLocationBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listLocationBeans;
	}

}
