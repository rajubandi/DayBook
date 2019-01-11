/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.StatusBean;
import com.aurospaces.neighbourhood.dao.ServiceStatusDao;
import com.aurospaces.neighbourhood.dao.StatusDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 *
 */
@Service
public class StatusServiceImpl implements StatusService{
	private Logger logger = Logger.getLogger(StatusServiceImpl.class);
	@Autowired
	StatusDao objStatusDao;
	@Autowired
	ServiceStatusDao objServiceStatusDao;
	@Override
	public boolean insertStatus(StatusBean objStausBean) {
		boolean isStatusInsert = false;
		try{
		String sStatusId = new NeighbourhoodUtil().getGUId();
		if(sStatusId != null){
			objStausBean.setStatusId(sStatusId);
			isStatusInsert = objStatusDao.insertStatus(objStausBean);
			if(isStatusInsert){
				isStatusInsert = objServiceStatusDao.insertServiceStatus(objStausBean);
			}
		}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in insertStatus() in StatusServiceImpl"+e.getMessage());
			logger.fatal("error in insertStatus() in StatusServiceImpl");
		}finally{
			
		}
		return isStatusInsert;
	}

	@Override
	public boolean updateStatus(StatusBean objStausBean) {
		boolean isStatusUpdate = false;
		try{
			isStatusUpdate = objStatusDao.updateStatus(objStausBean);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in updateStatus() in StatusServiceImpl"+e.getMessage());
			logger.fatal("error in updateStatus() in StatusServiceImpl");
		}finally{
			
		}
		return isStatusUpdate;
	}

	@Override
	public List<StatusBean> getStatuss(StatusBean objStausBean, String likeSearch) {
		List<StatusBean> listStausBeans = null;
		try{
			listStausBeans = objStatusDao.getStatuss(objStausBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in getStatuss() in StatusServiceImpl"+e.getMessage());
			logger.fatal("error in getStatuss() in StatusServiceImpl");
		}finally{
			
		}
		return listStausBeans;
	}

	@Override
	public StatusBean getStatus(StatusBean objStausBean, String likeSearch) {
		StatusBean objEditStatusBean = null;
		try{
			objEditStatusBean = objStatusDao.getStatus(objStausBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in getStatus() in StatusServiceImpl"+e.getMessage());
			logger.fatal("error in getStatus() in StatusServiceImpl");
		}finally{
			
		}
		return objEditStatusBean;
	}

	@Override
	public boolean deleteStatus(StatusBean objStausBean) {
		boolean isStatusDelete = false;
		try{
			isStatusDelete = objStatusDao.deleteStatus(objStausBean);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("error in deleteStatus() in StatusServiceImpl"+e.getMessage());
			logger.fatal("error in deleteStatus() in StatusServiceImpl");
		}finally{
			
		}
		return isStatusDelete;
	}

	
}
