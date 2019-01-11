/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyTestTypesTestBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author sandhya
 *
 */
@Repository
public class PathologyTestTypesTestDaoImpl extends DaoSupport implements PathologyTestTypesTestDao {

	@Override
	public boolean insertPathologyTestTypesTest(
			PathologyTestTypesTestBean objPathologyTestTypesTestBean) {
		boolean isInsert = false;
		try {
			String sSql = "insert into pathology_test_types_test(testId,testTypeId) values(?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objPathologyTestTypesTestBean.getTestId(),
					objPathologyTestTypesTestBean.getTestTypeId()
			});
			isInsert = true;
		System.out.println(sSql);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

	}
	return isInsert;
}

}
