package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PathologyPackagesBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;
import com.aurospaces.neighbourhood.dao.PathologyPackagesDao;
import com.aurospaces.neighbourhood.dao.PathologyTestsDao;

/**
 * @author kotaiah
 *
 */
@Service
public class PathologyTestsServiceImpl implements PathologyTestsService {
	@Autowired
	PathologyTestsDao objPathologyTestsDao;
	@Autowired
	PathologyPackagesDao objPathologyPackagesDao;
	@Override
	public List<PathologyTestsBean> getAllPathologyTests() {
		List<PathologyTestsBean> listPathologyTests = null;
		try {
			listPathologyTests = objPathologyTestsDao.getAllPathologyTests();
			if(listPathologyTests != null && listPathologyTests.size() > 0){
				for(PathologyTestsBean objTestsBean : listPathologyTests){
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyTests;
	}

	@Override
	public boolean addPathologyTestsToCart(JSONObject pathologyData) {
		String pathologyTestId = pathologyData.getString("pathologyTestId");
		//pathologyTestId = " '"+ pathologyTestId +"'";
		System.out.println("pathologyTestId: " + pathologyTestId);
		List<PathologyTestsBean> listPathologyTestsBean	= objPathologyTestsDao.getPathologyTestsInfoByTestIds(pathologyTestId);
		if (listPathologyTestsBean != null && listPathologyTestsBean.size() > 0) {
			for( PathologyTestsBean objPathologyTestsBean: listPathologyTestsBean ){
				System.out.println(objPathologyTestsBean.getPrice());
			}
		}
		
		return false;
	}

	@Override
	public List<PathologyTestsBean> getFilterTestType(
			PathologyTestsBean objPathologyTestsBean) {
		List<PathologyTestsBean> listPathologyTestsBeans = null;
		try{
			listPathologyTestsBeans	= objPathologyTestsDao.getFilterTestType(objPathologyTestsBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listPathologyTestsBeans;
	}

	@Override
	public List<PathologyTestsBean> getFilterTestName(
			PathologyTestsBean objPathologyTestsBean) {
		List<PathologyTestsBean> listPathologyTestsBeans = null;
		try{
			listPathologyTestsBeans	= objPathologyTestsDao.getFilterTestName(objPathologyTestsBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listPathologyTestsBeans;
	}

	@Override
	public List<PathologyPackagesBean> getFilterPackage(
			PathologyPackagesBean objPathologyPackagesBean) {
		List<PathologyPackagesBean> listPathologyPackagesBeans = null;
		try{
			listPathologyPackagesBeans	= objPathologyPackagesDao.getFilterPackage(objPathologyPackagesBean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listPathologyPackagesBeans;
	}

}
