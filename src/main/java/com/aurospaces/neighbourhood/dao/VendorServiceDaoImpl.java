/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ServicesBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class VendorServiceDaoImpl extends DaoSupport implements
		VendorServiceDao {

	@Override
	public boolean insertVendorServices(final VendorRegistrationBean objProfileBean) {
		boolean isVendorInsert = false;
		try {
			final List<ServicesBean> listSerBean = objProfileBean
					.getListServicesBean();
			String sSql = "insert into vendor_service (vendorId,serviceId) values (?,?)";
			getJdbcTemplate().batchUpdate(sSql,
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							ServicesBean objLocalVendor = listSerBean.get(i);
							ps.setString(1, objProfileBean.getVendorId());
							ps.setString(2, objLocalVendor.getServiceId());
						}
						@Override
						public int getBatchSize() {
							return listSerBean.size();
						}
					});
			isVendorInsert = true;
			/*
			 * if(objProfileBean!= null){
			 * listSerBean=objProfileBean.getListServicesBean();
			 * for(ServicesBean objSerBean: listSerBean){ String sSql =
			 * "insert into vendor_service (vendorId,serviceId) values (?,?)";
			 * int iCount = getJdbcTemplate().update( sSql, new Object[] {
			 * objProfileBean.getVendorId(), objProfileBean.getServiceId() }); }
			 * 
			 * }
			 */

			/*
			 * System.out.println(iCount); if (iCount != 0) { isVendorInsert =
			 * true; }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorInsert;
	}

}
