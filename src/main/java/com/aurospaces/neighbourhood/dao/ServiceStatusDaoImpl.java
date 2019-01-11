/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.StatusBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class ServiceStatusDaoImpl extends DaoSupport implements
ServiceStatusDao {

	@Override
	public boolean insertServiceStatus(StatusBean objStatusBean) {
		boolean isServicesInsert = false;
		try {
			String sSql = "insert into service_status(serviceId, statusId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objStatusBean.getServiceId(),
							objStatusBean.getStatusId() });
			System.out.println(iCount);
			if (iCount != 0) {

				isServicesInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isServicesInsert;
	}

}
