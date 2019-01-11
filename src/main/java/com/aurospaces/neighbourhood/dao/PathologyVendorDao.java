/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyVendorBean;

/**
 * @author Amit
 *
 */
public interface PathologyVendorDao {
	boolean insertVendor(PathologyVendorBean objProfileBean);
	boolean updateVendor(PathologyVendorBean objProfileBean);
	List<PathologyVendorBean> getVendors(PathologyVendorBean objProfileBean);
	PathologyVendorBean getVendor(PathologyVendorBean objProfileBean); 
	boolean deleteVendor(PathologyVendorBean objProfileBean);
	
}
