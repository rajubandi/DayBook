package com.aurospaces.neighbourhood.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.DoctorOrderBean;
import com.aurospaces.neighbourhood.bean.SymptomsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
@Repository
public class OrderSymptomsDaoimpl extends DaoSupport implements OrderSymptomsDao {

	@Override
	public boolean insertOrderSymptoms(final DoctorOrderBean objDoctorOrderBean) {
		boolean isInserDetails = false;
		try {
			String sSql = "insert into order_symptoms(orderId,symptomsId,symptomsDesc) values(?,?,?)";
			final List<SymptomsBean> listSymptomsBeans = objDoctorOrderBean	.getListSymptomsBean();
			// final String sOrderId = objPathologyOrderInfoBean.getOrderId();
			getJdbcTemplate().batchUpdate(sSql,
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							SymptomsBean objSymptomsBean = listSymptomsBeans
									.get(i);

							ps.setString(1, objDoctorOrderBean.getOrderId());
							ps.setString(2, objSymptomsBean.getSymsptomsId());
							ps.setString(3,	objDoctorOrderBean.getSymptomsDesc());
						}

						@Override
						public int getBatchSize() {
							return listSymptomsBeans.size();
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
