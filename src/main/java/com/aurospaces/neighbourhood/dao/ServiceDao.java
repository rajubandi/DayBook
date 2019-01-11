/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.ServicesBean;

/**
 * @author Amit
 *
 */
public interface ServiceDao {
	boolean insertServices(ServicesBean objServicesBean);
	boolean updateServices(ServicesBean objServicesBean);
	List<ServicesBean> getServices(ServicesBean objvBean, String likeSearch);
	ServicesBean getService(ServicesBean objServicesBean, String likeSearch);
	boolean deleteService(ServicesBean objServicesBean);
	public ServicesBean getServiceName(ServicesBean objServicesBean,String likeSearch); 
}
