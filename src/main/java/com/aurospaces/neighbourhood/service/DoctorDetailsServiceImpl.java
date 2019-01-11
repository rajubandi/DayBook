/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.DoctorDetailsBean;
import com.aurospaces.neighbourhood.dao.DoctorDetailsDao;
import com.aurospaces.neighbourhood.dao.DoctorTypeDoctorDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 *
 */
@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService{
	private Logger logger = Logger.getLogger(DoctorDetailsServiceImpl.class);
	@Autowired
	DoctorDetailsDao objDoctorDetailsDao;
	@Autowired
	DoctorTypeDoctorDao objDoctorTypeDoctorDao;
	@Override
	public boolean insertDoctorDetails(List<DoctorDetailsBean> objDoctorDetailsBean) {
		boolean isInsert = false;
		boolean isInsertPathologyTests = false;
		NeighbourhoodUtil objNeighbourhoodUtil = null;
		String sTestId = null;
		boolean isInsertPathologyTestType = false;
		List<DoctorDetailsBean> objLocalDoctorDetailsBeans = null;

		try {
			objNeighbourhoodUtil = new NeighbourhoodUtil();
			for (DoctorDetailsBean objPathologyInventoryBean : objDoctorDetailsBean) {
				if (objLocalDoctorDetailsBeans == null) {
					objLocalDoctorDetailsBeans = new ArrayList<DoctorDetailsBean>();
				}
				sTestId = objNeighbourhoodUtil.getGUId();
				objPathologyInventoryBean.setDoctorId(sTestId);
				objLocalDoctorDetailsBeans.add(objPathologyInventoryBean);
			}
			isInsertPathologyTests = objDoctorDetailsDao
					.insertDoctorDetails(objLocalDoctorDetailsBeans);
			if (isInsertPathologyTests) {
				isInsertPathologyTestType = objDoctorTypeDoctorDao
						.insertDoctorTypeDoctor(objLocalDoctorDetailsBeans);
			}
			if (isInsertPathologyTestType) {
				isInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isInsert;
	}
	@Override
	public List<DoctorDetailsBean> getDoctorDetails(
			DoctorDetailsBean objDoctorDetailsBean, String likeSearch) {
		
			List<DoctorDetailsBean> listDoctorDetailsBean = null;
			try {
				listDoctorDetailsBean = objDoctorDetailsDao.getDoctorDetails(objDoctorDetailsBean, likeSearch);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("error in getDoctorDetails() in DoctorDetailsServiceImpl"+e.getMessage());
				logger.fatal("error in getDoctorDetails() in DoctorDetailsServiceImpl");
			} finally {

			}
			return listDoctorDetailsBean;
		
	}

	
	
}
