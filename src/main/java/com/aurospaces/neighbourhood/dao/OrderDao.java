/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.MedicineBean;

/**
 * @author YOGI
 *
 */
@Repository
public interface OrderDao {
	List<MedicineBean> getOrders(MedicineBean objMedicineOrderBean);
}
