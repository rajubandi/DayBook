package com.aurospaces.neighbourhood.dao;

import java.util.List;
import com.aurospaces.neighbourhood.bean.DoctorOrderBean;
import com.aurospaces.neighbourhood.bean.SymptomsBean;
public interface DoctorOrderDao {
	public List<DoctorOrderBean> getAllDoctorTypes();
	public List<SymptomsBean> getAllSymptoms();
	boolean insertDocterOrder(DoctorOrderBean objDoctorOrderBean);
	boolean insertOrderSymtoms(DoctorOrderBean objDoctorOrderBean);
	boolean insertOrderDocterType(DoctorOrderBean objDoctorOrderBean);
	boolean insertOrderStatus(DoctorOrderBean objDoctorOrderBean);
	boolean insertOrderUser(DoctorOrderBean objDoctorOrderBean);
	boolean insertOrderService(DoctorOrderBean objDoctorOrderBean);
}
