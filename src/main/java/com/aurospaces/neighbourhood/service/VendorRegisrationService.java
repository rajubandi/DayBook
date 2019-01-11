/**
 * 
 */
package com.aurospaces.neighbourhood.service;



import java.util.List;

import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;

/**
 * @author Amit
 *
 */
public interface VendorRegisrationService {
	boolean insertVendor(VendorRegistrationBean objProfileBean);
	boolean updateVendor(VendorRegistrationBean objProfileBean);
	List<VendorRegistrationBean> getVendors(VendorRegistrationBean objProfileBean);
	VendorRegistrationBean getVendor(VendorRegistrationBean objProfileBean); 
	boolean deleteVendor(VendorRegistrationBean objProfileBean);
}
