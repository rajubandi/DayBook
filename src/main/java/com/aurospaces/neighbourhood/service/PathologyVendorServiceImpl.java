/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.UserRoleBean;
import com.aurospaces.neighbourhood.bean.VendorExperienceBean;
import com.aurospaces.neighbourhood.bean.PathologyVendorBean;
import com.aurospaces.neighbourhood.dao.UserRoleDao;
import com.aurospaces.neighbourhood.dao.VendorCategoryDao;
import com.aurospaces.neighbourhood.dao.VendorExperienceDao;
import com.aurospaces.neighbourhood.dao.PathologyVendorDao;
import com.aurospaces.neighbourhood.dao.VendorServiceDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 * 
 */
@Service
public class PathologyVendorServiceImpl implements PathologyVendorService {
	@Autowired
	PathologyVendorDao objPathologyVendorDao;
	@Autowired
	VendorCategoryDao objVendorCategoryDao;
	@Autowired
	VendorServiceDao objVendorServiceDao;
	@Autowired
	VendorExperienceDao objVendorExperienceDao;
	@Autowired
	VendorExperienceBean objVendorExperienceBean;
	@Autowired
	UserRoleDao objUserRoleDao;
	@Autowired
	UserRoleBean objUserRoleBean;

	@Override
	public boolean insertVendor(PathologyVendorBean objProfileBean) {
		boolean isVendorInsert = false;
		try {
			String sVendorId = new NeighbourhoodUtil().getGUId();
			if (sVendorId != null) {
				objProfileBean.setVendorId(sVendorId);
			}
			boolean isVInsert = objPathologyVendorDao
					.insertVendor(objProfileBean);
			/*if (isVInsert) {
				boolean isVCInsert = objVendorCategoryDao
						.insertVendorCategory(objProfileBean);
				if (isVCInsert) {
					boolean isVSInsert = objVendorServiceDao
							.insertVendorServices(objProfileBean);
					objVendorExperienceBean.setVendorId(sVendorId);
					objVendorExperienceBean.setExperienceId(objProfileBean.getExperienceId());
					boolean isVEInsert = objVendorExperienceDao.insertVendorExperience(objVendorExperienceBean);
					if (isVSInsert && isVEInsert) {
						objUserRoleBean.setRoleId(2);
						objUserRoleBean.setUserId(sVendorId);
						objUserRoleDao.isInserUserRole(objUserRoleBean);
						isVendorInsert = true;
					}
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorInsert;
	}

	@Override
	public boolean updateVendor(PathologyVendorBean objProfileBean) {
		boolean isUpdateVendor = false;
		try {
			isUpdateVendor = objPathologyVendorDao
					.updateVendor(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isUpdateVendor;
	}

	@Override
	public List<PathologyVendorBean> getVendors(
			PathologyVendorBean objProfileBean) {
		List<PathologyVendorBean> listPathologyVendorBeans = null;
		try {
			listPathologyVendorBeans = objPathologyVendorDao
					.getVendors(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyVendorBeans;
	}

	@Override
	public PathologyVendorBean getVendor(
			PathologyVendorBean objProfileBean) {
		PathologyVendorBean objEditVendor = null;
		try {
			objEditVendor = objPathologyVendorDao.getVendor(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objEditVendor;
	}

	@Override
	public boolean deleteVendor(PathologyVendorBean objProfileBean) {
		boolean isVendorDelete = false;
		try {
			isVendorDelete = objPathologyVendorDao
					.deleteVendor(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorDelete;
	}

}
