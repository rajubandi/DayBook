/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.bean.TypeBean;

/**
 * @author sandhya
 *
 */
public interface PathologyTestTypeService {
	
	boolean insertPathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean);
	boolean updatePathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean);
	List<PathologyTestTypeBean> getPathologyTestTypes(PathologyTestTypeBean objPathologyTestTypeBean, String likeSearch);
	PathologyTestTypeBean getPathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean, String likeSearch);
	boolean deletePathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean);
	
}
