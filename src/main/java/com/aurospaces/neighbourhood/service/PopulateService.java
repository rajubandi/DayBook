/**
 * Copyright MNTSOFT 
 */
package com.aurospaces.neighbourhood.service;

import java.util.Map;

import com.aurospaces.neighbourhood.bean.PopulateBean;

/**
 * @author Amith
 * 
 */
public interface PopulateService {

	public java.util.List<PopulateBean> populate(String sql);

	public Map<String, String> populatePopUp(String sql);


}
