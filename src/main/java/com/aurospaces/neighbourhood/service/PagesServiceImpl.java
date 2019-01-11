package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PageServicesBean;
import com.aurospaces.neighbourhood.bean.PagesBean;
import com.aurospaces.neighbourhood.dao.PageServicesDao;
import com.aurospaces.neighbourhood.dao.PagesDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

@Service
public class PagesServiceImpl implements PagesService {
@Autowired
PagesDao objPagesDao;
@Autowired
PageServicesDao objPageServicesDao;
	@Override
	public boolean insertPages(PagesBean objPagesBean) {
		boolean isInsertPage = false;
		boolean isInsertPageService = false;
		boolean isInsert = false;
		String sPageId = null;
		PageServicesBean objPageServicesBean = null;
		try{
		sPageId = new NeighbourhoodUtil().getGUId();
		if(sPageId != null){
			objPagesBean.setPageId(sPageId);
		}
		isInsertPage = objPagesDao.insertPages(objPagesBean);
			if(isInsertPage){
				objPageServicesBean =new PageServicesBean();
				objPageServicesBean.setPageId(objPagesBean.getPageId());
				objPageServicesBean.setServiceId(objPagesBean.getServiceId());
				isInsertPageService = objPageServicesDao.insertPagesService(objPageServicesBean);
			}
			if(isInsertPageService){
				isInsert = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isInsert;
	}
	@Override
	public List<PagesBean> getServices(PagesBean objPagesBean,
			String likeSearch) {
		List<PagesBean> listPagesBeans = null;
		try{
			listPagesBeans = objPagesDao.getServices(objPagesBean, likeSearch);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listPagesBeans;
	}
	
	@Override
	public PagesBean getPage(PagesBean objPagesBean,
			String likeSearch) {
		PagesBean objPageBean = null;
		try{
			objPageBean = objPagesDao.getPage(objPagesBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		return objPageBean;
	}
}
