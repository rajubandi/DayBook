/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PathologyPackagesBean;
import com.aurospaces.neighbourhood.bean.VendorPackageBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.dao.PathologyPackagesDao;
import com.aurospaces.neighbourhood.dao.VendorPackagesDao;
import com.aurospaces.neighbourhood.dao.VendorRegisrationDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 *
 */
@Service
public class PathologyPackagesServiceImpl implements PathologyPackagesService{
	@Autowired
	PathologyPackagesDao objPathologyPackagesDao;
	@Autowired
	VendorPackagesDao objVendorPackagesDao;
	@Autowired
	VendorRegisrationDao objVendorRegisrationDao;
	@Override
	public boolean insertPathologyPackage(List<PathologyPackagesBean> objListPathologyPackagesBean) {
		boolean isPackageInsert = false;
		NeighbourhoodUtil objNeighbourhoodUtil = null;
		VendorRegistrationBean objVendorRegistrationBean = null;
		VendorRegistrationBean objLocalVendorRegistrationBean = null;
		VendorPackageBean objVendorPackageBean = null;
		String sPackageId = null;
		boolean insetVendorPackage = false;
		boolean isInsert = false;
		try{
			objNeighbourhoodUtil = new NeighbourhoodUtil();
			for(PathologyPackagesBean objLocalPathologyPackagesBean : objListPathologyPackagesBean){
				sPackageId = objNeighbourhoodUtil.getGUId();
				objLocalPathologyPackagesBean.setPackageId(sPackageId);
				isPackageInsert = objPathologyPackagesDao.insertPathologyPackages(objLocalPathologyPackagesBean);
				if(isPackageInsert){
				objVendorRegistrationBean = new VendorRegistrationBean();
				objVendorRegistrationBean.setFirstName(objLocalPathologyPackagesBean.getBusinessName());
				objLocalVendorRegistrationBean = objVendorRegisrationDao.getVendorId(objVendorRegistrationBean);
				System.out.println(objLocalVendorRegistrationBean.getVendorId());
				if(objLocalVendorRegistrationBean.getVendorId() != null){
					objVendorPackageBean = new VendorPackageBean();
					objVendorPackageBean.setPackageId(sPackageId);
					objVendorPackageBean.setVendorId(objLocalVendorRegistrationBean.getVendorId());
					insetVendorPackage = objVendorPackagesDao.insertVendorPackage(objVendorPackageBean);
					if(insetVendorPackage){
						isInsert = true;
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

	
	
}
