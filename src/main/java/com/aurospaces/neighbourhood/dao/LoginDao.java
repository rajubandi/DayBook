/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.LocationBean;
import com.aurospaces.neighbourhood.bean.LoginBean;

/**
 * @author YOGI
 *
 */
public interface LoginDao {
	LoginBean getUserDetails(LoginBean objLoginBean);
	public List<LocationBean> getServicesBasedOnLocations(LocationBean objLocationBean);
	public List<LocationBean> getLocationBasedServices(LocationBean objLocationBean);
}
