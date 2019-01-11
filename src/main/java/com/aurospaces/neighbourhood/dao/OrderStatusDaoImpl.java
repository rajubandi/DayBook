/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderStatusBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author YOGI
 * 
 */
@Repository
public class OrderStatusDaoImpl extends DaoSupport implements OrderStatusDao {

	@Override
	public boolean insertOrderStatus(OrderStatusBean objOrderStatusBean) {
		String sSql = null;
		int iCount = 0;
		boolean isInsert = false;
		
		try {
			sSql = "insert into order_status (orderId, statusId, updatedDate, updatedBy) values (?,?, ?,?)";
			if(objOrderStatusBean != null){
				iCount = getJdbcTemplate().update(sSql, new Object[]{
						objOrderStatusBean.getOrderId(), objOrderStatusBean.getStatusId(),
						objOrderStatusBean.getUpdatedDate(),objOrderStatusBean.getUpdatedBy()
				});
				if(iCount > 0){
				isInsert = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			logger.fatal("error in insertOrderStatus() in OrderstatusDaoImpl");
		} finally {

		}
		return isInsert;
	}

	@Override
	public boolean updateOrderStatus(OrderStatusBean objOrderStatusBean) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return false;
	}

	@Override
	public List<OrderStatusBean> getOrderStatuss(
			OrderStatusBean objOrderStatusBean, String likeSearch) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return null;
	}

	@Override
	public OrderStatusBean getOrderStatus(OrderStatusBean objOrderStatusBean,
			String likeSearch) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return null;
	}

	@Override
	public boolean deleteOrderStatus(OrderStatusBean objOrderStatusBean) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return false;
	}

}
