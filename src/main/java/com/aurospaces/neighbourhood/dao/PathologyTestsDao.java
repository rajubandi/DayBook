package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyTestsBean;

/**
 * @author kotaiah
 *
 */
public interface PathologyTestsDao {
	public List<PathologyTestsBean> getAllPathologyTests();
	public List<PathologyTestsBean> getPathologyTestsInfoByTestIds(String pathologyTestIds);
	public boolean insertTemporaryPathologyOrdered(PathologyTestsBean objPathologyTestsBean);
	List<PathologyTestsBean> getFilterTestType(PathologyTestsBean objPathologyTestsBean);
	List<PathologyTestsBean> getFilterTestName(PathologyTestsBean objPathologyTestsBean);
}
