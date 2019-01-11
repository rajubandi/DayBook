/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.UserRoleBean;
import com.aurospaces.neighbourhood.bean.VendorExperienceBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.dao.UserRoleDao;
import com.aurospaces.neighbourhood.dao.VendorCategoryDao;
import com.aurospaces.neighbourhood.dao.VendorExperienceDao;
import com.aurospaces.neighbourhood.dao.VendorRegisrationDao;
import com.aurospaces.neighbourhood.dao.VendorServiceDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 * 
 */
@Service
public class VendorRegisrationServiceImpl implements VendorRegisrationService {
	@Autowired
	VendorRegisrationDao objVendorRegisrationDao;
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
	public boolean insertVendor(VendorRegistrationBean objProfileBean) {
		boolean isVendorInsert = false;
		try {
			String sVendorId = new NeighbourhoodUtil().getGUId();
			if (sVendorId != null) {
				objProfileBean.setVendorId(sVendorId);
			}
			boolean isVInsert = objVendorRegisrationDao
					.insertVendor(objProfileBean);
			if (isVInsert) {
				boolean isVCInsert = objVendorCategoryDao
						.insertVendorCategory(objProfileBean);
				if (isVCInsert) {
					boolean isVSInsert = objVendorServiceDao
							.insertVendorServices(objProfileBean);
					//objVendorExperienceBean.setVendorId(sVendorId);
					//objVendorExperienceBean.setExperianceId(objProfileBean.getExperienceId());
					//boolean isVEInsert = objVendorExperienceDao.insertVendorExperience(objVendorExperienceBean);
					if (isVSInsert) {
						objUserRoleBean.setRoleId(2);
						objUserRoleBean.setUserId(sVendorId);
						objUserRoleDao.isInserUserRole(objUserRoleBean);
						isVendorInsert = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorInsert;
	}

	@Override
	public boolean updateVendor(VendorRegistrationBean objProfileBean) {
		boolean isUpdateVendor = false;
		try {
			isUpdateVendor = objVendorRegisrationDao
					.updateVendor(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isUpdateVendor;
	}

	@Override
	public List<VendorRegistrationBean> getVendors(
			VendorRegistrationBean objProfileBean) {
		List<VendorRegistrationBean> listVendorRegistrationBeans = null;
		try {
			listVendorRegistrationBeans = objVendorRegisrationDao
					.getVendors(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listVendorRegistrationBeans;
	}

	@Override
	public VendorRegistrationBean getVendor(
			VendorRegistrationBean objProfileBean) {
		VendorRegistrationBean objEditVendor = null;
		try {
			objEditVendor = objVendorRegisrationDao.getVendor(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objEditVendor;
	}

	@Override
	public boolean deleteVendor(VendorRegistrationBean objProfileBean) {
		boolean isVendorDelete = false;
		try {
			isVendorDelete = objVendorRegisrationDao
					.deleteVendor(objProfileBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorDelete;
	}

}
