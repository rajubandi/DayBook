/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.LocationBean;
import com.aurospaces.neighbourhood.bean.LoginBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author YOGI
 * 
 */
@Repository
public class LoginDaoImpl extends DaoSupport implements LoginDao {

	@Override
	public LoginBean getUserDetails(LoginBean objLoginBean) {
		LoginBean objLocalLoginBean = null;
		try {
			String sql = "SELECT u.name as userName,u.id as userId,u.location_id as locationId , r.* FROM users u, user_role1 ur, role  r WHERE u.id = ur.`userId` AND ur.`roleId`= r.`roleId` AND   u.name='"+objLoginBean.getUserName()+"' and u.password='"+objLoginBean.getPassword()+"' ";
			List<LoginBean> listLoginBeans = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<LoginBean>(LoginBean.class));
			if(listLoginBeans != null && listLoginBeans.size()>0){
				System.out.println(listLoginBeans.size());
				objLocalLoginBean = listLoginBeans.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objLocalLoginBean;
	}

	@Override
	public List<LocationBean> getServicesBasedOnLocations(
			LocationBean objLocationBean) {
		List<LocationBean> listLocationBeans = null;
		try {
			String sql = "SELECT s.`serviceId` , s.`serviceName` FROM services s, location_services ls  WHERE s.`serviceId` = ls.`serviceId` AND ls.`locationId` in ('"+objLocationBean.getLocationId()+"', '12')";
			listLocationBeans = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<LocationBean>(LocationBean.class));
			System.out.println(sql);
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
			String sql = "SELECT * FROM location l , `location_services` ls WHERE ls.`locationId` = l.locationId AND ls.`serviceId`='"+objLocationBean.getServiceId()+"' GROUP BY l.locationId";
			listLocationBeans = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<LocationBean>(LocationBean.class));
			System.out.println("sql---------"+sql);
			if(listLocationBeans != null && listLocationBeans.size() == 1){
				for(LocationBean objLocation: listLocationBeans){
					if("12".equalsIgnoreCase(objLocation.getLocationId())){
						String sSql = "SELECT * FROM location l , `location_services` ls WHERE ls.`locationId` = l.locationId  GROUP BY l.locationId ORDER BY date";
						listLocationBeans = getJdbcTemplate().query(sSql, new BeanPropertyRowMapper<LocationBean>(LocationBean.class));
						System.out.println("if-------"+sSql);
					}
				}
			}
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listLocationBeans;
	}
}
