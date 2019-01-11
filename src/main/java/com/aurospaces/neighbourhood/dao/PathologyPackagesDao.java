/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyPackagesBean;

/**
 * @author Amit
 *
 */
public interface PathologyPackagesDao {
	boolean insertPathologyPackages(PathologyPackagesBean objPathologyPackagesBean);
	List<PathologyPackagesBean> getFilterPackage(PathologyPackagesBean objPathologyPackagesBean);
	//PathologyTestTypeBean getPathologyTestTypeId(PathologyTestTypeBean objPathologyTestTypeBean);
}
