/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyOrderInfoBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author sandhya
 * 
 */
@Repository
public class PathologyOrderInfoDaoImpl extends DaoSupport implements
		PathologyOrderInfoDao {
	Logger objLogger = Logger.getLogger(PathologyOrderDaoImpl.class);
	@Override
	public boolean insertPathologyOrderInfo(
			PathologyOrderInfoBean objPathologyOrderInfoBean) {
		boolean isInserDetails = false;
		try {
			String sSql = "insert into order_info(orderId, TotalDiscount, TotalPrice,NetAmount,contactNo,orderAddress,appointmentDate,appointmentSlotId,bookedDate, contactEmail) values(?,?,?,?,?,?,?,?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objPathologyOrderInfoBean.getOrderId(),
							objPathologyOrderInfoBean.getTotalDiscount(),
							objPathologyOrderInfoBean.getTotalPrice(),
							objPathologyOrderInfoBean.getNetAmount(),
							objPathologyOrderInfoBean.getContactNo(),
							objPathologyOrderInfoBean.getOrderAddress(),
							objPathologyOrderInfoBean.getAppointmentDate(),
							objPathologyOrderInfoBean.getAppointmentSlotId(),
							objPathologyOrderInfoBean.getBookedDate(),
							objPathologyOrderInfoBean.getEmailId()
					});
			if (iCount != 0) {
				logger.fatal("count for insertion --"+iCount);
				isInserDetails = true;
			}
		} catch (Exception e) {
			logger.error("error in insertion in pathology info dao impl"+e.getMessage());
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}
}
