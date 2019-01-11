/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyOrderInfoBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;


/**
 * @author sandhya
 *
 */
@Repository
public class PathologyOrderDetailsDaoImpl  extends DaoSupport implements PathologyOrderDetailsDao{

	@Override
	public boolean insertPathologyOrderDetails(final PathologyOrderInfoBean objPathologyOrderInfoBean) {
		boolean isInserDetails=false;
		try {
			String sSql = "insert into order_details(orderId,testId) values(?,?)";
			final List<PathologyTestsBean> listPathologyTestsBean =  objPathologyOrderInfoBean.getListPathologyTestsBeans();
			final String sOrderId = objPathologyOrderInfoBean.getOrderId();
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
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}	

}
