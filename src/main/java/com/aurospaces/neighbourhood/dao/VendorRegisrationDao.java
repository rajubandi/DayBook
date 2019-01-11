/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;

/**
 * @author Amit
 *
 */
public interface VendorRegisrationDao {
	boolean insertVendor(VendorRegistrationBean objProfileBean);
	boolean updateVendor(VendorRegistrationBean objProfileBean);
	List<VendorRegistrationBean> getVendors(VendorRegistrationBean objProfileBean);
	VendorRegistrationBean getVendor(VendorRegistrationBean objProfileBean); 
	boolean deleteVendor(VendorRegistrationBean objProfileBean);
	VendorRegistrationBean getVendorId(VendorRegistrationBean objVendorRegistrationBean);
	
}
