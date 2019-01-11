/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.MedicineBean;
import com.aurospaces.neighbourhood.dao.OrderDao;

/**
 * @author YOGI
 * 
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao objOrderDao;

	@Override
	public List<MedicineBean> getOrders(
			MedicineBean objMedicineOrderBean) {
		List<MedicineBean> listMedicineOrderBeans = null;
		try {
			listMedicineOrderBeans = objOrderDao
					.getOrders(objMedicineOrderBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listMedicineOrderBeans;

	}

}
