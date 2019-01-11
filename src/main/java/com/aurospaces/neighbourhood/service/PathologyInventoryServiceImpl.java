/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PathologyTestClientBean;
import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.bean.PathologyTestTypesTestBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;
import com.aurospaces.neighbourhood.bean.TestClientBean;
import com.aurospaces.neighbourhood.dao.PathologyInventoryDao;
import com.aurospaces.neighbourhood.dao.PathologyTestClientDao;
import com.aurospaces.neighbourhood.dao.PathologyTestTypesTestDao;
import com.aurospaces.neighbourhood.dao.TestClientDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 *
 */
@Service
public class PathologyInventoryServiceImpl implements PathologyInventoryService{
	@Autowired
	PathologyInventoryDao objPathologyInventoryDao;
	@Autowired
	PathologyTestTypesTestDao objPathologyTestTypesTestDao;
	@Autowired
	TestClientDao objTestClientDao;
	@Autowired
	PathologyTestClientDao objPathologyTestClientDao;
	@Override
	public boolean insertPathologyInventory(List<PathologyTestsBean> objListPathologyTestsBean) {
		boolean isInsert = false;
		boolean isInsertPathologyTests= false;
		boolean isInsertPathologyTestType = false;
		boolean isInsertPathologyTestClient = false;
		NeighbourhoodUtil objNeighbourhoodUtil = null;
		PathologyTestTypesTestBean objPathologyTestTypesTestBean = null;
		String sTestId = null;
		PathologyTestTypeBean objPathologyTestTypeBean= null;
		PathologyTestTypeBean objLocalPathologyTestTypeBean = null;
		TestClientBean objTestClientBean = null;
		PathologyTestClientBean objPathologyTestClientBean = null;
		TestClientBean objLocalClientBean = null;
		
		try{
			objNeighbourhoodUtil = new NeighbourhoodUtil();
			for(PathologyTestsBean objLocalPathologyTestsBean : objListPathologyTestsBean ){
				sTestId = objNeighbourhoodUtil.getGUId();
				objLocalPathologyTestsBean.setTestId(sTestId);
				isInsertPathologyTests = objPathologyInventoryDao.insertPathologyInventory(objLocalPathologyTestsBean);
				if(isInsertPathologyTests){
					objPathologyTestTypeBean = new PathologyTestTypeBean();
					objPathologyTestTypeBean.setTestTypeName(objLocalPathologyTestsBean.getTestTypeName());
					objLocalPathologyTestTypeBean = objPathologyInventoryDao.getPathologyTestTypeId(objPathologyTestTypeBean);
					if(objLocalPathologyTestTypeBean.getTestTypeId() != null){
					objPathologyTestTypesTestBean = new PathologyTestTypesTestBean();
					objPathologyTestTypesTestBean.setTestTypeId(objLocalPathologyTestTypeBean.getTestTypeId());
					objPathologyTestTypesTestBean.setTestId(objLocalPathologyTestsBean.getTestId());
					isInsertPathologyTestType =objPathologyTestTypesTestDao.insertPathologyTestTypesTest(objPathologyTestTypesTestBean);
					if(isInsertPathologyTestType){
						
						objTestClientBean = new TestClientBean();
						objPathologyTestClientBean = new PathologyTestClientBean();
						objLocalClientBean = new TestClientBean();
						objTestClientBean.setTestClientName(objLocalPathologyTestsBean.getBusinessName());
						objLocalClientBean = objTestClientDao.getTestClientId(objTestClientBean);
						if(objLocalClientBean.getVendorId() != null){
							objPathologyTestClientBean.setTestClientId(objLocalClientBean.getVendorId());
							objPathologyTestClientBean.setTestId(objLocalPathologyTestsBean.getTestId());
							isInsertPathologyTestClient = objPathologyTestClientDao.insertPathologyTestClient(objPathologyTestClientBean);
							if(isInsertPathologyTestClient)
							{
								isInsert = true;
							}
						}
					}
					}
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return isInsert;
	}
	@Override
	public PathologyTestTypeBean getPathologyTestTypeId(
			PathologyTestTypeBean objPathologyTestTypeBean) {
		PathologyTestTypeBean objLocalPathologyTestTypeBean = null;
		try {
			objLocalPathologyTestTypeBean = objPathologyInventoryDao.getPathologyTestTypeId(objPathologyTestTypeBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objLocalPathologyTestTypeBean;
	}

	
	
}
