/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.bean.PathologyPackagesBean;

/**
 * @author Amit
 *
 */
public interface PathologyPackagesService {
	boolean insertPathologyPackage(List<PathologyPackagesBean> objPathologyPackagesBean);
	
	
}
