/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.LocationBean;
import com.aurospaces.neighbourhood.dao.LocationDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 *
 */
@Service
public class LocationServiceImpl implements LocationService{
	private Logger logger = Logger.getLogger(LocationServiceImpl.class);
	@Autowired
	LocationDao objLocationDao;
	@Override
	public boolean insertLocation(LocationBean objLocationBean) {
		boolean isLocationInsert = false;
		try{
		String sLocationId = new NeighbourhoodUtil().getGUId();
		if(sLocationId != null){
			objLocationBean.setLocationId(sLocationId);
		}
			isLocationInsert = objLocationDao.insertLocation(objLocationBean);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in insertLocation() in LocationServiceImpl"+e.getMessage());
			logger.fatal("error in insertLocation() in LocationServiceImpl");
		}finally{
			
		}
		return isLocationInsert;
	}

	@Override
	public boolean updateLocation(LocationBean objLocationBean) {
		boolean isLocationUpdate = false;
		try{
			isLocationUpdate = objLocationDao.updateLocation(objLocationBean);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in updateLocation() in LocationServiceImpl"+e.getMessage());
			logger.fatal("error in updateLocation() in LocationServiceImpl");
		}finally{
			
		}
		return isLocationUpdate;
	}

	@Override
	public List<LocationBean> getLocations(LocationBean objLocationBean, String likeSearch) {
		List<LocationBean> listLocationBeans = null;
		try{
			listLocationBeans = objLocationDao.getLocations(objLocationBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in getLocations() in LocationServiceImpl"+e.getMessage());
			logger.fatal("error in getLocations() in LocationServiceImpl");
		}finally{
			
		}
		return listLocationBeans;
	}

	@Override
	public LocationBean getLocation(LocationBean objLocationBean, String likeSearch) {
		LocationBean objEditLocationBean = null;
		try{
			objEditLocationBean = objLocationDao.getLocation(objLocationBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in getLocation() in LocationServiceImpl"+e.getMessage());
			logger.fatal("error in getLocation() in LocationServiceImpl");
		}finally{
			
		}
		return objEditLocationBean;
	}

	@Override
	public boolean deleteLocation(LocationBean objLocationBean) {
		boolean isLocationDelete = false;
		try{
			isLocationDelete = objLocationDao.deleteLocation(objLocationBean);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in deleteLocation() in LocationServiceImpl"+e.getMessage());
			logger.fatal("error in deleteLocation() in LocationServiceImpl");
		}finally{
			
		}
		return isLocationDelete;
	}
}
