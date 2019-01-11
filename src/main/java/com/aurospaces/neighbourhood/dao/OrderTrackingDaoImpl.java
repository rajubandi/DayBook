package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderTrackingBean;
import com.aurospaces.neighbourhood.bean.PathologyBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
@Repository
public class OrderTrackingDaoImpl extends DaoSupport implements OrderTrackingDao {

	@Override
	public List<OrderTrackingBean> getTypes(OrderTrackingBean objTrackingBean) {
		List<OrderTrackingBean> listTracking=null;
		try {
			String sSql = "SELECT os.`orderId`, updatedDate,totalQty,totalDiscount,totalNetAmount,statusId FROM `order_status` os ,`pharma_order_info` poi WHERE os.`orderId` = poi.`orderId` ";
			listTracking = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<OrderTrackingBean>(
							OrderTrackingBean.class));
			System.out.println(sSql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
		}
		return listTracking;
		
	}

}
