/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.ServicesBean;
import com.aurospaces.neighbourhood.dao.ServiceCategoryDao;
import com.aurospaces.neighbourhood.dao.ServiceDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 * 
 * 
 */
@Service
public class ServicesServiceImpl implements ServicesService {
@Autowired
ServiceDao objServicesDao;
@Autowired
ServiceCategoryDao objServiceCategoryDao;
	@Override
	public boolean insertServices(ServicesBean objServicesBean) {
		boolean isServicesInsert = false;
		try{
		String sServicesId = new NeighbourhoodUtil().getGUId();
		if(sServicesId != null){
			objServicesBean.setServiceId(sServicesId);
			System.out.println(sServicesId);
		}
			isServicesInsert = objServicesDao.insertServices(objServicesBean);
			if(isServicesInsert){
				objServiceCategoryDao.insertServiceCategory(objServicesBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isServicesInsert;
	}

	@Override
	public boolean updateServices(ServicesBean objServicesBean) {
		boolean isServicesUpdate = false;
		try{
			isServicesUpdate = objServicesDao.updateServices(objServicesBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isServicesUpdate;
	}

	@Override
	public List<ServicesBean> getServices(ServicesBean objServicesBean,
			String likeSearch) {
		List<ServicesBean> listServicesBeans = null;
		try{
			listServicesBeans = objServicesDao.getServices(objServicesBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listServicesBeans;
	}

	@Override
	public ServicesBean getService(ServicesBean objServicesBean,
			String likeSearch) {
		ServicesBean objEditSevicesBean = null;
		try{
			objEditSevicesBean = objServicesDao.getService(objServicesBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return objEditSevicesBean;
	}

	@Override
	public boolean deleteService(ServicesBean objServicesBean) {
		boolean isServiceDelete = false;
		try{
			isServiceDelete = objServicesDao.deleteService(objServicesBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isServiceDelete;
	}

}
