package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.json.JSONObject;

import com.aurospaces.neighbourhood.bean.PathologyPackagesBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;

/**
 * @author kotaiah
 *
 */
public interface PathologyTestsService {
	
	List<PathologyTestsBean> getAllPathologyTests();
	boolean addPathologyTestsToCart(JSONObject pathologyData);
	List<PathologyTestsBean> getFilterTestType(PathologyTestsBean objPathologyTestsBean);
	List<PathologyTestsBean> getFilterTestName(PathologyTestsBean objPathologyTestsBean);
	List<PathologyPackagesBean> getFilterPackage(PathologyPackagesBean objPathologyPackagesBean);
}
