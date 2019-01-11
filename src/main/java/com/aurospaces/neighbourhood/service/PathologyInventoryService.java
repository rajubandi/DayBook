/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;

/**
 * @author Amit
 *
 */
public interface PathologyInventoryService {
	boolean insertPathologyInventory(List<PathologyTestsBean> objPathologyTestsBean);
	PathologyTestTypeBean getPathologyTestTypeId(PathologyTestTypeBean objPathologyTestTypeBean);
	
}
