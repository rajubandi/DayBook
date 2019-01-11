/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.MedicineBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author YOGI
 *
 */
@Repository
public class OrderDaoImpl extends DaoSupport implements OrderDao {

	@Override
	public List<MedicineBean> getOrders(MedicineBean objMedicineOrderBean) {
		List<MedicineBean> listMedicineOrderBeans = null;
		try{
			String sSql = "SELECT * FROM `order_info` WHERE orderStatus='Ordered'";
			listMedicineOrderBeans = getJdbcTemplate().query(sSql, new BeanPropertyRowMapper<MedicineBean>(MedicineBean.class));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listMedicineOrderBeans;
	}
}
