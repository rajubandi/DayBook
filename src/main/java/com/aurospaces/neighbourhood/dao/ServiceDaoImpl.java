/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ServicesBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class ServiceDaoImpl extends DaoSupport implements ServiceDao {
	private Logger logger = Logger.getLogger(ServiceDaoImpl.class);
	@Override
	public boolean insertServices(ServicesBean objServicesBean) {
		boolean isServicesInsert = false;
		try {
			String sSql = "insert into services(serviceId, serviceName,pageName, serviceDesc) values(?,?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objServicesBean.getServiceId(),
							objServicesBean.getServiceName(), 
							objServicesBean.getPageName(),"" });
			System.out.println(iCount);
			if (iCount != 0) {

				isServicesInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in insertServices() in ServiceDaoImpl"+e.getMessage());
			logger.fatal("error in insertServices() in ServiceDaoImpl");
		} finally {

		}
		return isServicesInsert;
	}

	@Override
	public boolean updateServices(ServicesBean objServicesBean) {
		boolean isServicesUpdate = false;
		try {
			String sSql = "update services set serviceName = ?,pageName = ? where serviceId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objServicesBean.getServiceName(),
					objServicesBean.getPageName(),
					objServicesBean.getServiceId());
			if (iCount != 0) {
				isServicesUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in updateServices() in ServiceDaoImpl"+e.getMessage());
			logger.fatal("error in updateServices() in ServiceDaoImpl");
		} finally {

		}
		return isServicesUpdate;
	}

	@Override
	public List<ServicesBean> getServices(ServicesBean objServicesBean,
			String likeSearch) {
		List<ServicesBean> listServicesBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from services s , services_category sc where s.`serviceId` = sc.`serviceId`");
			if (objServicesBean.getServiceName() != null) {
				if ("both".equals(likeSearch)) {
					objStringBuffer.append(" and  s.serviceName like '%"
							+ objServicesBean.getServiceName() + "%'");
				} else if ("left".equals(likeSearch)) {
					objStringBuffer.append(" and s.serviceName like '%"
							+ objServicesBean.getServiceName() + "'");
				} else if ("right".equals(likeSearch)) {
					objStringBuffer.append(" and s.serviceName like '"
							+ objServicesBean.getServiceName() + "%'");
				} else {
					objStringBuffer.append(" and s.serviceName = '"
							+ objServicesBean.getServiceName() + "'");
				}

			}
			if (objServicesBean.getServiceId() != null) {
				objStringBuffer.append(" and s.serviceId != '"
						+ objServicesBean.getServiceId() + "'");
			}
			if (objServicesBean.getCategoryId() != null && objServicesBean.getCategoryId() != "") {
				objStringBuffer.append(" and sc.categoryId = '"+ objServicesBean.getCategoryId() + "'");
			}
			objStringBuffer.append(" group by s.serviceId ");
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listServicesBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<ServicesBean>(
									ServicesBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in getServices() in ServiceDaoImpl"+e.getMessage());
			logger.fatal("error in getServices() in ServiceDaoImpl");
		} finally {

		}
		return listServicesBeans;
	}

	@Override
	public ServicesBean getService(ServicesBean objServicesBean,
			String likeSearch) {
		ServicesBean objServiceBean = null;
		try {
			String sSql = "select * from services s, services_category sc where sc.`serviceId` =s.serviceId and s.serviceId ='"+ objServicesBean.getServiceId() + "' GROUP BY s.`serviceId`";
			objServiceBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<ServicesBean>(
									ServicesBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in getService() in ServiceDaoImpl"+e.getMessage());
			logger.fatal("error in getService() in ServiceDaoImpl");
		} finally {

		}
		return objServiceBean;
	}

	@Override
	public boolean deleteService(ServicesBean objServicesBean) {
		boolean isServicesDelete = false;
		try {
			String sSql = "delete from services where serviceId ='"
					+ objServicesBean.getServiceId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isServicesDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in deleteService() in ServiceDaoImpl"+e.getMessage());
			logger.fatal("error in deleteService() in ServiceDaoImpl");
		} finally {

		}
		return isServicesDelete;
	}
	
	@Override
	public ServicesBean getServiceName(ServicesBean objServicesBean,
			String likeSearch) {
		ServicesBean objLocalServicesBean = null;
		try {
			String sSql = "select s.serviceName from services s where s.serviceId ='"+ objServicesBean.getServiceId() + "'";
			objLocalServicesBean = getJdbcTemplate()
					.queryForObject(sSql,new BeanPropertyRowMapper<ServicesBean>(ServicesBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in getService() in ServiceDaoImpl"+e.getMessage());
			logger.fatal("error in getService() in ServiceDaoImpl");
		} finally {

		}
		return objLocalServicesBean;
	}

}
