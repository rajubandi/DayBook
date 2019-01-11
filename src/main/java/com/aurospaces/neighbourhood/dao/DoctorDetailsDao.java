/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.DoctorDetailsBean;

/**
 * @author Amit
 *
 */
public interface DoctorDetailsDao {
	boolean insertDoctorDetails(List<DoctorDetailsBean> objDoctorDetailsBean);
	List<DoctorDetailsBean> getDoctorDetails(DoctorDetailsBean objDoctorDetailsBean, String likeSearch);
}
