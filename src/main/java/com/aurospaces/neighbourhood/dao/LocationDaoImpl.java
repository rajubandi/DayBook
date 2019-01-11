/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.bean.LocationBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class LocationDaoImpl extends DaoSupport implements LocationDao {
	private Logger logger = Logger.getLogger(LocationDaoImpl.class);
	@Override
	public boolean insertLocation(LocationBean objLocationBean) {
		boolean isLocationInsert = false;
		try {
			String sSql = "insert into location(locationId, locationName, locationDesc) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objLocationBean.getLocationId(),
							objLocationBean.getLocationName(), "" });
			System.out.println(iCount);
			if (iCount != 0) {
				isLocationInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in insertLocation() in LocationDaoImpl"+e.getMessage());
			logger.fatal("error in insertLocation() in LocationDaoImpl");
		} finally {

		}
		return isLocationInsert;
	}

	@Override
	public boolean updateLocation(LocationBean objLocationBean) {
		boolean isLocationUpdate = false;
		try {
			String sSql = "update location set locationName = ? where locationId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objLocationBean.getLocationName(),
					objLocationBean.getLocationId());
			if (iCount != 0) {
				isLocationUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in updateLocation() in LocationDaoImpl"+e.getMessage());
			logger.fatal("error in updateLocation() in LocationDaoImpl");
		} finally {

		}
		return isLocationUpdate;
	}

	@Override
	public List<LocationBean> getLocations(LocationBean objLocationBean, String likeSearch) {
		List<LocationBean> listLocationBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from location");
			if (objLocationBean.getLocationName() != null) {
				if("both".equals(likeSearch)){
				objStringBuffer.append(" where locationName like '%"
						+ objLocationBean.getLocationName() + "%'");
				}
				else if("left".equals(likeSearch)){
					objStringBuffer.append(" where locationName like '%"
							+ objLocationBean.getLocationName() + "'");
				}else if("right".equals(likeSearch)){
					objStringBuffer.append(" where locationName like '"
							+ objLocationBean.getLocationName() + "%'");
				}else {
					objStringBuffer.append(" where locationName = '"
							+ objLocationBean.getLocationName() + "'");
				}
				
			}
			if (objLocationBean.getLocationId() != null) {
				objStringBuffer.append(" and locationId != '"
						+ objLocationBean.getLocationId() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listLocationBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<LocationBean>(
									LocationBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in getLocations() in LocationDaoImpl"+e.getMessage());
			logger.fatal("error in getLocations() in LocationDaoImpl");
		} finally {

		}
		return listLocationBeans;
	}

	@Override
	public LocationBean getLocation(LocationBean objLocationBean, String likeSearch) {
		LocationBean objLocalLocationBean = null;
		
		try {

			String sSql = "select * from location where locationId ='"
					+ objLocationBean.getLocationId() + "'";
			objLocalLocationBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<LocationBean>(
									LocationBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in getLocation() in LocationDaoImpl"+e.getMessage());
			logger.fatal("error in getLocation() in LocationDaoImpl");
		} finally {

		}
		return objLocalLocationBean;
	}

	@Override
	public boolean deleteLocation(LocationBean objLocationBean) {
		boolean isLocationDelete = false;
		try {
			String sSql = "delete from location where locationId ='"+ objLocationBean.getLocationId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isLocationDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in deleteLocation() in LocationDaoImpl"+e.getMessage());
			logger.fatal("error in deleteLocation() in LocationDaoImpl");
		} finally {

		}
		return isLocationDelete;
	}
}
