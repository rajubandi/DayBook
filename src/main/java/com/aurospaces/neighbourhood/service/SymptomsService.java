/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.CategoryBean;
import com.aurospaces.neighbourhood.bean.SymptomsBean;

/**
 * @author Amit
 *
 */
public interface SymptomsService {
	boolean insertSymptoms(SymptomsBean objSymptomsBean);
	boolean updateSymptoms(SymptomsBean objSymptomsBean);
	List<SymptomsBean> getSymptomss(SymptomsBean objSymptomsBean, String likeSearch);
	SymptomsBean getSymptoms(SymptomsBean objSymptomsBean, String likeSearch);
	boolean deleteSymptoms(SymptomsBean objSymptomsBean);
	SymptomsBean editSymptoms(SymptomsBean objSymptomsBean);
}
