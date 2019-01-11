/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.LocationBean;

/**
 * @author Amit
 *
 */
public interface LocationService {
	boolean insertLocation(LocationBean objLocationBean);
	boolean updateLocation(LocationBean objLocationBean);
	List<LocationBean> getLocations(LocationBean objLocationBean, String likeSearch);
	LocationBean getLocation(LocationBean objLocationBean, String likeSearch);
	boolean deleteLocation(LocationBean objLocationBean);
}
