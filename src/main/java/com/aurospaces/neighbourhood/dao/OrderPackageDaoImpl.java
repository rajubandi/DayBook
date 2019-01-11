package com.aurospaces.neighbourhood.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyOrderInfoBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
@Repository
public class OrderPackageDaoImpl extends DaoSupport implements OrderPackageDao {

	@Override
	public boolean insertOrderPackage(
			final PathologyOrderInfoBean objPathologyOrderInfoBean) {
		boolean isInserDetails=false;
		try {
			String sSql = "insert into order_package(orderId,packageId) values(?,?)";
			final List<PathologyTestsBean> listPathologyTestsBean =  objPathologyOrderInfoBean.getListPathologyTestsBeans();
			getJdbcTemplate().batchUpdate(sSql,
						new BatchPreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement ps, int i)
									throws SQLException {
								PathologyTestsBean objPathologyTestsBean = listPathologyTestsBean.get(i);
								ps.setString(1, objPathologyOrderInfoBean.getOrderId());
								ps.setString(2, objPathologyTestsBean.getTestId());
								
							}
	             	@Override
							public int getBatchSize() {
								return listPathologyTestsBean.size();
							}
						});
				 isInserDetails = true;
		System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}
	
}
