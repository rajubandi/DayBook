/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;

/**
 * @author Amit
 *
 */
public interface PathologyInventoryDao {
	boolean insertPathologyInventory(PathologyTestsBean objPathologyTestsBean);
	PathologyTestTypeBean getPathologyTestTypeId(PathologyTestTypeBean objPathologyTestTypeBean);
}
