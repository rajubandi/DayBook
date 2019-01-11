/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.StatusBean;

/**
 * @author Amit
 *
 */
public interface StatusService {
	boolean insertStatus(StatusBean objStausBean);
	boolean updateStatus(StatusBean objStausBean);
	List<StatusBean> getStatuss(StatusBean objStausBean, String likeSearch);
	StatusBean getStatus(StatusBean objStausBean, String likeSearch);
	boolean deleteStatus(StatusBean objStausBean);
	
}
