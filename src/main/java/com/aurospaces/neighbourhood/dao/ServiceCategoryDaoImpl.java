/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ServicesBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class ServiceCategoryDaoImpl extends DaoSupport implements
		ServiceCategoryDao {

	@Override
	public boolean insertServiceCategory(ServicesBean objServicesBean) {
		boolean isServicesInsert = false;
		try {
			String sSql = "insert into services_category(serviceId, categoryId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objServicesBean.getServiceId(),
							objServicesBean.getCategoryId() });
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
