/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.TimeSlotBean;
import com.aurospaces.neighbourhood.dao.TimeSlotDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 *
 */
@Service
public class TimeSlotServiceImpl implements TimeSlotService{
	@Autowired
	TimeSlotDao objTimeSlotDao;
	@Override
	public boolean insertTimeslot(TimeSlotBean objTimeSlotBean) {
		boolean isCategoryInsert = false;
		try{
		String sslotId = new NeighbourhoodUtil().getGUId();
		if(sslotId != null){
			objTimeSlotBean.setSlotId(sslotId);
		}
			isCategoryInsert = objTimeSlotDao.insertTimeslot(objTimeSlotBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isCategoryInsert;
	}

	@Override
	public boolean updateTimeslot(TimeSlotBean objTimeSlotBean) {
		boolean isCategoryUpdate = false;
		try{
			isCategoryUpdate = objTimeSlotDao.updateTimeslot(objTimeSlotBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isCategoryUpdate;
	}

	@Override
	public List<TimeSlotBean> getTimeslots(TimeSlotBean objTimeSlotBean, String likeSearch) {
		List<TimeSlotBean> listTimeSlotBeans = null;
		try{
			listTimeSlotBeans = objTimeSlotDao.getTimeslots(objTimeSlotBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listTimeSlotBeans;
	}

	@Override
	public TimeSlotBean getTimeslot(TimeSlotBean objTimeSlotBean, String likeSearch) {
		TimeSlotBean objEditCatBean = null;
		try{
			objEditCatBean = objTimeSlotDao.getTimeslot(objTimeSlotBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return objEditCatBean;
	}

	@Override
	public boolean deleteTimeslot(TimeSlotBean objTimeSlotBean) {
		boolean isCategoryDelete = false;
		try{
			isCategoryDelete = objTimeSlotDao.deleteTimeslot(objTimeSlotBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isCategoryDelete;
	}
}
