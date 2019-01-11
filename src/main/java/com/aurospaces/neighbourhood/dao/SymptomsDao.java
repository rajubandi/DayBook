/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.SymptomsBean;

/**
 * @author 
 *
 */
public interface SymptomsDao {
	boolean insertSymptoms(SymptomsBean objSymptomsBean);
	boolean updateSymptoms(SymptomsBean objSymptomsBean);
	List<SymptomsBean> getSymptomss(SymptomsBean objSymptomsBean, String likeSearch);
	SymptomsBean getSymptoms(SymptomsBean objSymptomsBean, String likeSearch);
	boolean deleteSymptoms(SymptomsBean objSymptomsBean);
	String editSymptoms(SymptomsBean objSymptomsBean);
}
