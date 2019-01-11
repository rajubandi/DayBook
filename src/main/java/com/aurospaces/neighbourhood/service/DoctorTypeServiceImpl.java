/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.DoctorTypeBean;
import com.aurospaces.neighbourhood.bean.UserRoleBean;
import com.aurospaces.neighbourhood.dao.DoctorTypeDao;
import com.aurospaces.neighbourhood.dao.UserRoleDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author kanojia
 *
 */
@Service
public class DoctorTypeServiceImpl implements DoctorTypeService{
	@Autowired
	DoctorTypeDao objDoctorTypeDao;
	@Autowired
	UserRoleDao objUserRoleDao;
	@Autowired
	UserRoleBean objUserRoleBean;
	@Override
	public boolean insertDoctorType(DoctorTypeBean objDoctorTypeBean) {
		boolean isDoctorTypeInsert = false;
		try{
		String sDoctorTypeId = new NeighbourhoodUtil().getGUId();
		if(sDoctorTypeId != null){
			objDoctorTypeBean.setDoctortypeId(sDoctorTypeId);
		}
			isDoctorTypeInsert = objDoctorTypeDao.insertDoctorType(objDoctorTypeBean);
			if(isDoctorTypeInsert){
				objUserRoleBean.setUserId(sDoctorTypeId);
				objUserRoleBean.setRoleId(2);
				objUserRoleDao.isInserUserRole(objUserRoleBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isDoctorTypeInsert;
	}
	@Override
	public boolean updateDoctorType(DoctorTypeBean objDoctorTypeBean) {
		boolean isDoctorTypeUpdate = false;
		try{
			isDoctorTypeUpdate = objDoctorTypeDao.updateDoctorType(objDoctorTypeBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isDoctorTypeUpdate;
	}

	@Override
	public List<DoctorTypeBean> getDoctorTypes(DoctorTypeBean objDoctorTypeBean, String likeSearch) {
		List<DoctorTypeBean> listDoctorTypeBeans = null;
		try{
			listDoctorTypeBeans = objDoctorTypeDao.getDoctorTypes(objDoctorTypeBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listDoctorTypeBeans;
	}
	@Override
	public int getduplicatechecks(DoctorTypeBean objDoctorTypeBean, String likeSearch) {
		int DoctorTypeBeans = 0;
		try{
			DoctorTypeBeans = objDoctorTypeDao.getduplicatechecks(objDoctorTypeBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return DoctorTypeBeans;
	}

	@Override
	public DoctorTypeBean getDoctorType(DoctorTypeBean objDoctorTypeBean, String likeSearch) {
		DoctorTypeBean objEditDoctorTypeBean = null;
		try{
			objEditDoctorTypeBean = objDoctorTypeDao.getDoctorType(objDoctorTypeBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return objEditDoctorTypeBean;
	}

	@Override
	public boolean deleteDoctorType(DoctorTypeBean objDoctorTypeBean) {
		boolean isDoctorTypeDelete = false;
		try{
			isDoctorTypeDelete = objDoctorTypeDao.deleteDoctorType(objDoctorTypeBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isDoctorTypeDelete;
	}
	@Override
	public DoctorTypeBean getDoctorTypename(DoctorTypeBean objDoctorTypeBean,
			String likeSearch) {
		DoctorTypeBean objLocalTypeBean=null;
		
		try{
			objLocalTypeBean = objDoctorTypeDao.getDoctorTypename(objDoctorTypeBean, "");
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
			
		}
		return objLocalTypeBean;
	}
	
}



