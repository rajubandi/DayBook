package com.aurospaces.neighbourhood.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.OrderInfoBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class OrderInfoDaoImpl extends DaoSupport implements OrderInfoDao {

	@Override
	public boolean insertOrderInfo(OrderInfoBean objOrderInfoBean) {
		boolean isInserDetails = false;
		try {

			String sSql = "insert into order_info(orderId, appointmentDate, appointmentSlotId,orderAddress,contactEmail,contactNo,bookedDate,TotalPrice,TotalDiscount,NetAmount, orderDescription) values(?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objOrderInfoBean.getOrderId(),
							objOrderInfoBean.getAppointmentDate(),
							objOrderInfoBean.getAppointmentSlotId(),
							objOrderInfoBean.getOrderAddress(),
							objOrderInfoBean.getContactEmail(),
							objOrderInfoBean.getContactNo(),
							objOrderInfoBean.getBookedDate(),
							objOrderInfoBean.getTotalPrice(),
							objOrderInfoBean.getTotalDiscount(),
							objOrderInfoBean.getNetAmount(),
							objOrderInfoBean.getOrderDescription() });
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

	@Override
	public boolean updateOrderInfo(OrderInfoBean objOrderInfoBean) {
		boolean isOrderInfoUpdate = false;
		try {
			String sSql = "update order_info set appointmentDate = ?,appointmentSlotId =?,TotalPrice=?,TotalDiscount=?,NetAmount=? where orderId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objOrderInfoBean.getAppointmentDate(),
					objOrderInfoBean.getAppointmentSlotId(),
					objOrderInfoBean.getTotalPrice(),
					objOrderInfoBean.getTotalDiscount(),
					objOrderInfoBean.getNetAmount(),
					objOrderInfoBean.getOrderId());
			if (iCount != 0) {
				isOrderInfoUpdate = true;
				System.out.println(sSql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isOrderInfoUpdate;
	}

	@Override
	public CustomerBean getCustomerDetails(OrderInfoBean objOrderInfoBean) {
		CustomerBean objCustomerBean = null;
		try {
			String sSql = "SELECT c.`mobileNumber`,c.`email`, c.`address1`,cd.`customerDiscount`, cd.`discountUsedDate`"
					+ "  FROM customer c ,`order_user` ou, customer_discount cd  "
					+ "WHERE ou.`userId` = c.`customerId` AND cd.`customerId` = c.`customerId`"
					+ " AND ou.`orderId` ='"
					+ objOrderInfoBean.getOrderId()
					+ "' ";
			objCustomerBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<CustomerBean>(
									CustomerBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objCustomerBean;
	}

}
