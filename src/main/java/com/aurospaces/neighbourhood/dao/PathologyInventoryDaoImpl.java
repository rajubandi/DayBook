/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.bean.PathologyTestsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class PathologyInventoryDaoImpl extends DaoSupport implements PathologyInventoryDao {

	@Override
	public boolean insertPathologyInventory(PathologyTestsBean objPathologyTestsBean) {
		boolean isMedicineInsert = false;
			try {
				String sSql = "insert into pathology_tests(testId,testName, testDesc, price,discount) values(?,?,?,?,?)";
				getJdbcTemplate().update(sSql, new Object[]{
						objPathologyTestsBean.getTestId(),
						objPathologyTestsBean.getTestName(),
						objPathologyTestsBean.getTestDesc(),
						objPathologyTestsBean.getPrice(),
						objPathologyTestsBean.getDiscount()
				});
			isMedicineInsert = true;
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isMedicineInsert;
	}

	@Override
	public PathologyTestTypeBean getPathologyTestTypeId(PathologyTestTypeBean objPathologyTestTypeBean) {
		try {
			String sSql = "SELECT `testTypeId` FROM `pathology_test_types` WHERE `testTypeName` = '"
					+ objPathologyTestTypeBean.getTestTypeName() + "'";
			objPathologyTestTypeBean = getJdbcTemplate().queryForObject(sSql,
					new BeanPropertyRowMapper<PathologyTestTypeBean>(PathologyTestTypeBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objPathologyTestTypeBean;
	}

		}
