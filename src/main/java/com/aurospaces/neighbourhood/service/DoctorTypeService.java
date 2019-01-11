/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.DoctorTypeBean;

/**
 * @author Amit
 *
 */
public interface DoctorTypeService {
	boolean insertDoctorType(DoctorTypeBean objDoctorTypeBean);
	boolean updateDoctorType(DoctorTypeBean objDoctorTypeBean);
	List<DoctorTypeBean> getDoctorTypes(DoctorTypeBean objDoctorTypeBean, String likeSearch);
	int getduplicatechecks(DoctorTypeBean objDoctorTypeBean, String likeSearch);
	DoctorTypeBean getDoctorType(DoctorTypeBean objCategoryBean, String likeSearch);
	boolean deleteDoctorType(DoctorTypeBean objDoctorTypeBean);
	DoctorTypeBean getDoctorTypename(DoctorTypeBean objDoctorTypeBean, String likeSearch);
	
}
