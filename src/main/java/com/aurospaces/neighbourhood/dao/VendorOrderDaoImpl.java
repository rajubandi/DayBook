package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.bean.VendorOrderBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
@Repository
public class VendorOrderDaoImpl extends DaoSupport implements VendorOrderDao {

	@Override
	public List<OrderBean> getOrders(OrderBean objorOrderBean) {
		List<OrderBean> listOrderBeans = null;
		String sSql=null;
		try{
		 sSql = "SELECT * FROM `order_info` oi,`vendor_order` vo ,`order_status` os, `status` st WHERE oi.`orderId` = vo.`orderId` AND os.`orderId` = oi.`orderId` AND os.`statusId` = st.`statusId` AND vo.`vendorId`= '2454297e-c0e4-4d93-bc9b-4efd3d4e2436' GROUP BY (oi.`orderId`)";
			listOrderBeans = getJdbcTemplate().query(sSql, new BeanPropertyRowMapper<OrderBean>(OrderBean.class));
			System.out.println(sSql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listOrderBeans;
	}
	@Override
	public boolean insertVendorOrder(VendorOrderBean objVendorOrderBean) {
		boolean isAssignOrder = false;
		try{
			String sSql ="INSERT INTO `vendor_order` (vendorId, `orderId`) VALUES(?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objVendorOrderBean.getVendorId(),
					objVendorOrderBean.getOrderId()
			});
			isAssignOrder = true;
			System.out.println(sSql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		return isAssignOrder;
	}

}
