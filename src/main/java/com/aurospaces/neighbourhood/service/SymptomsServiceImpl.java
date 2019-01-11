/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.CategoryBean;
import com.aurospaces.neighbourhood.bean.SymptomsBean;
import com.aurospaces.neighbourhood.dao.CategoryDao;
import com.aurospaces.neighbourhood.dao.SymptomsDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author 
 *
 */
@Service
public class SymptomsServiceImpl implements SymptomsService{
	@Autowired
	SymptomsDao objSymptomsDao;
	@Override
	public boolean insertSymptoms(SymptomsBean objSymptomsBean) {
		boolean isSymptomsInsert = false;
		try{
		String sSymptomsId = new NeighbourhoodUtil().getGUId();
		if(sSymptomsId != null){
			objSymptomsBean.setSymsptomsId(sSymptomsId);
		}
			isSymptomsInsert = objSymptomsDao.insertSymptoms(objSymptomsBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isSymptomsInsert;
	}

	@Override
	public boolean updateSymptoms(SymptomsBean objSymptomsBean) {
		boolean isSymptomsUpdate = false;
		try{
			isSymptomsUpdate = objSymptomsDao.updateSymptoms(objSymptomsBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isSymptomsUpdate;
	}

	@Override
	public List<SymptomsBean> getSymptomss(SymptomsBean objSymptomsBean, String likeSearch) {
		List<SymptomsBean> listSymptomsBeans = null;
		try{
			listSymptomsBeans = objSymptomsDao.getSymptomss(objSymptomsBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listSymptomsBeans;
	}

	@Override
	public SymptomsBean getSymptoms(SymptomsBean objSymptomsBean, String likeSearch) {
		SymptomsBean objEditSymptomsBean = null;
		try{
			objEditSymptomsBean = objSymptomsDao.getSymptoms(objSymptomsBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return objEditSymptomsBean;
	}

	@Override
	public boolean deleteSymptoms(SymptomsBean objSymptomsBean) {
		boolean isSymptomsDelete = false;
		try{
			isSymptomsDelete = objSymptomsDao.deleteSymptoms(objSymptomsBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isSymptomsDelete;
	}

	@Override
	public SymptomsBean editSymptoms(SymptomsBean objSymptomsBean) {
		
		return objSymptomsDao.getSymptoms(objSymptomsBean, null);
	}
}
