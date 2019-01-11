/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.MedicineBean;

/**
 * @author YOGI
 *
 */
public interface OrderService {
	List<MedicineBean> getOrders(MedicineBean objMedicineOrderBean);
}
