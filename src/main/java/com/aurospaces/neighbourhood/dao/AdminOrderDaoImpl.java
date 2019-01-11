package com.aurospaces.neighbourhood.dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class AdminOrderDaoImpl extends DaoSupport implements AdminOrderDao {

	@Override
	public List<OrderBean> getOrders(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		String sSql = null;
		try {
			// String sSql = "SELECT * FROM `order_info` ";
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer
					.append("SELECT p1.*, st.*, oi.*, os.serviceId,pts.slotLabel ,se.`serviceName`, vo.vendorId,l.`locationName`, cd.`customerDiscount` FROM order_status p1 JOIN order_service os ON os.`orderId` = p1.`orderId` JOIN services se ON se.`serviceId` = os.`serviceId` LEFT JOIN vendor_order vo ON vo.`orderId` = p1.`orderId`  JOIN status st ON st.`statusId` = p1 .`statusId`  JOIN `order_info` oi ON oi.`orderId` = p1.`orderId` JOIN pathology_time_slots pts ON pts.`slotId` = oi.`appointmentSlotId` JOIN order_location ol ON ol.`orderId` =oi.`orderId`  JOIN location l ON l.`locationId` = ol.`locationId`   JOIN order_user ou ON ou.`orderId`=oi.`orderId`  LEFT JOIN customer_discount cd ON cd.`orderId` = oi.`orderId` WHERE p1.statusId =(SELECT p2.`statusId` FROM `order_status` p2  WHERE p2.orderId = p1.orderId ORDER BY  p2.`updatedDate` DESC LIMIT 1)");



			if (StringUtils.isNotEmpty(objOrderBean.getServiceId())) {
				objStringBuffer.append("  AND os.`serviceId`='"
						+ objOrderBean.getServiceId() + "'");
			}
			if (objOrderBean.getContactEmail() != null
					&& objOrderBean.getContactEmail().length() > 0) {
				objStringBuffer.append(" AND oi.contactEmail='"
						+ objOrderBean.getContactEmail() + "'");
			}
			if (objOrderBean.getContactNo() != null
					&& objOrderBean.getContactNo().length() > 0) {
				objStringBuffer.append(" AND oi.contactNo='"+ objOrderBean.getContactNo() + "'");
			}
			if(objOrderBean.getOrderId() != null && objOrderBean.getOrderId().length()>0){
				objStringBuffer.append(" AND os.`orderId`='"
						+ objOrderBean.getOrderId() + "'");
			}
			objStringBuffer.append(" and statusName != 'Closed'  GROUP BY p1.`orderId`  ORDER BY oi.`bookedDate`");
			sSql = objStringBuffer.toString();
			// System.out.println(sSql);
			//listOrderBeans = getJdbcTemplate().query(sSql,
			//		new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
			listOrderBeans = new ArrayList<OrderBean>();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return listOrderBeans;
	}

	@Override
	public List<OrderBean> searchPhoneNumber(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		String sSql = null;
		try {
			// String sSql = "SELECT * FROM `order_info` ";
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("SELECT * FROM `order_info` ");
			if (objOrderBean.getContactNo() != null
					&& objOrderBean.getContactNo() != "") {
				objStringBuffer.append("  WHERE `contactNo`='"
						+ objOrderBean.getContactNo() + "'");
			}
			sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listOrderBeans = getJdbcTemplate().query(sSql,
					new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;
	}

	@Override
	public List<OrderBean> searchEmail(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		String sSql = null;
		try {
			// String sSql = "SELECT * FROM `order_info` ";
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("SELECT * FROM `order_info` ");
			if (objOrderBean.getContactEmail() != null
					&& objOrderBean.getContactEmail() != "") {
				objStringBuffer.append("  WHERE `contactEmail`='"
						+ objOrderBean.getContactEmail() + "'");
			}
			sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listOrderBeans = getJdbcTemplate().query(sSql,
					new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;
	}

	@Override
	public List<OrderBean> getAllOrders(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		String sSql = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("SELECT orderId,orderDescription from order_description");
			if (objOrderBean.getOrderId() != null && objOrderBean.getOrderId() != "") {
				objStringBuffer.append("  where `orderId` ='"+ objOrderBean.getOrderId() + "'");
			}
			sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listOrderBeans = getJdbcTemplate().query(sSql,
					new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;
	}

	@Override
	public OrderBean getServiceId(OrderBean objOrderBean) {
		OrderBean objOrderBeans = null;
		String sSql = null;
		try {

			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer
					.append("SELECT s.serviceId, se.serviceName FROM `order_service` s, services se where se.serviceId = s.serviceId ");
			if (objOrderBean.getOrderId() != null
					&& objOrderBean.getOrderId() != "") {
				objStringBuffer.append("  and  s.`orderId`='"+ objOrderBean.getOrderId() + "'");
			}
			sSql = objStringBuffer.toString();
			System.out.println(sSql);
			objOrderBeans = getJdbcTemplate().queryForObject(sSql,
					new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objOrderBeans;
	}

	@Override
	public List<OrderBean> getAllPathologyOrders(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		String sSql = null;
		try {
			// String sSql = "SELECT * FROM `order_info` ";
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer
					.append("SELECT ps.`testName`,oi.`NetAmount` ,oi.`TotalDiscount`,oi.`bookedDate`,"
							+ " oi.`TotalPrice`,pt.`slotLabel`, oi.`bookedDate`,ps.`price`, ps.`discount`"
							+ " FROM order_info oi , order_service se, order_details od, pathology_tests ps,services sd, "
							+ "`pathology_time_slots` pt WHERE oi.`orderId` = od.`orderId` AND od.`testId` = ps.`testId` "
							+ " AND pt.`slotId` = oi.`appointmentSlotId` AND sd.`serviceId` = se.`serviceId` ");
							
							
			if (objOrderBean.getOrderId() != null
					&& objOrderBean.getOrderId() != "") {
				objStringBuffer.append(" AND od.`orderId` = '"+objOrderBean.getOrderId()+"' ");
			}
			objStringBuffer.append(" GROUP BY od.`testId`");
			sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listOrderBeans = getJdbcTemplate().query(sSql,
					new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;
	}

	
}
