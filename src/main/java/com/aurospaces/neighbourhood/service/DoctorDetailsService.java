/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.DoctorDetailsBean;

/**
 * @author Amit
 *
 */
public interface DoctorDetailsService {
	boolean insertDoctorDetails(List<DoctorDetailsBean> objDoctorDetailsBean);
	List<DoctorDetailsBean> getDoctorDetails(DoctorDetailsBean objDoctorDetailsBean, String likeSearch);
	
}
