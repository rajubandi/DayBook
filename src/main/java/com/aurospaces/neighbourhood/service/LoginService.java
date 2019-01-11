/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.LocationBean;
import com.aurospaces.neighbourhood.bean.LoginBean;


/**
 * @author YOGI
 *
 */
public interface LoginService {
	LoginBean getUserDetails(LoginBean objLoginBean);
	public List<LocationBean> getServicesBasedOnLocations(LocationBean objLocationBean);
	public List<LocationBean> getLocationBasedServices(LocationBean objLocationBean);
}
