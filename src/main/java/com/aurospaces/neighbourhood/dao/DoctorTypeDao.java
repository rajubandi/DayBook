/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.DoctorTypeBean;

/**
 * @author Amit
 *
 */
public interface DoctorTypeDao {
	boolean insertDoctorType(DoctorTypeBean objDoctorTypeBean);
	boolean updateDoctorType(DoctorTypeBean objDoctorTypeBean);
	List<DoctorTypeBean> getDoctorTypes(DoctorTypeBean objDoctorTypeBean, String likeSearch);
	int getduplicatechecks(DoctorTypeBean objDoctorTypeBean, String likeSearch);
	DoctorTypeBean getDoctorType(DoctorTypeBean objDoctorTypeBean, String likeSearch);
	boolean deleteDoctorType(DoctorTypeBean objDoctorTypeBean);
	DoctorTypeBean getDoctorTypename(DoctorTypeBean objDoctorTypeBean, String likeSearch);
}