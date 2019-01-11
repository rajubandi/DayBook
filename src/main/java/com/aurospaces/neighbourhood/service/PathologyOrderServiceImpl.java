package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PathologyOrderBean;
import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.dao.PathologyOrderDao;
@Service
public class PathologyOrderServiceImpl implements PathologyOrderService {
	@Autowired
	PathologyOrderDao objPathologyOrderDao;
	@Override
	public String insertPathologyOrder(PathologyOrderBean objPathologyOrderBean) {
	
		return null;
	}

	@Override
	public List<PathologyTestTypeBean> getPathologyType(
			PathologyTestTypeBean objPathologyTestTypeBean) {
		List<PathologyTestTypeBean> listPathologyTest=null;
		try{
			listPathologyTest=objPathologyOrderDao.getPathologyType(objPathologyTestTypeBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listPathologyTest;
	}

}
