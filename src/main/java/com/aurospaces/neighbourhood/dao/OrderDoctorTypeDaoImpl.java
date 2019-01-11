package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderDoctorTypeBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
@Repository
public class OrderDoctorTypeDaoImpl extends DaoSupport implements OrderDoctorTypeDao {

	@Override
	public boolean insertOrderDoctorTye(OrderDoctorTypeBean objDoctorTypeBean) {
		boolean isInserDetails = false;

		try {

			String sSql = "insert into order_doctor_type (orderId, docotorTypeId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objDoctorTypeBean.getOrderId(),
							objDoctorTypeBean.getDocotorTypeId() });
			System.out.println(iCount);
			System.out.println(sSql);
			if (iCount != 0) {
				isInserDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}

}
