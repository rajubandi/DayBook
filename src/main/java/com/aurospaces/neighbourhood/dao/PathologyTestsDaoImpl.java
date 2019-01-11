package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyTestsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author kotaiah
 * 
 */
@Repository
public class PathologyTestsDaoImpl extends DaoSupport implements
		PathologyTestsDao {

	@Override
	public List<PathologyTestsBean> getAllPathologyTests() {
		List<PathologyTestsBean> listPathologyTests = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("SELECT * FROM `vendor_test` vt,`vendor_profile` vp, `pathology_tests` pt" +
					" WHERE vp.`vendorId` = vt.`vendorId` AND "+
						"vt.`testId` = pt.`testId`");
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listPathologyTests = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyTestsBean>(
							PathologyTestsBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyTests;
	}

	@Override
	public List<PathologyTestsBean> getPathologyTestsInfoByTestIds(
			String pathologyTestIds) {
		List<PathologyTestsBean> listPathologyTests = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer
					.append("select * from pathology_tests where testId = '"
							+ pathologyTestIds + "'");
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listPathologyTests = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyTestsBean>(
							PathologyTestsBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyTests;
	}

	@Override
	public boolean insertTemporaryPathologyOrdered(
			PathologyTestsBean objPathologyTestsBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PathologyTestsBean> getFilterTestType(
			PathologyTestsBean objPathologyTestsBean) {
		List<PathologyTestsBean> listPathologyTestsBeans = null;
		try {
			String sSql = "SELECT * FROM `pathology_tests` pt, `pathology_test_types_test` pttt ,`pathology_test_types` ptt ,"
							+"`vendor_test` vt, `vendor_profile` vp "
							+"WHERE pt.`testId` = pttt.`testId` "
							+"AND pttt.`testTypeId` = ptt.`testTypeId` "
							+"AND pt.`testId` = vt.`testId` "
							+"AND vp.`vendorId` = vt.`vendorId` "
							+"AND ptt.`testTypeId` ='"
					+ objPathologyTestsBean.getTestTypeId() + "' order by pt.testName";
			listPathologyTestsBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyTestsBean>(
							PathologyTestsBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
		return listPathologyTestsBeans;
	}

	@Override
	public List<PathologyTestsBean> getFilterTestName(
			PathologyTestsBean objPathologyTestsBean) {
		List<PathologyTestsBean> listPathologyTestsBeans = null;
		try {
			String sSql = "SELECT * FROM `vendor_test` vt,`vendor_profile` vp, `pathology_tests` pt WHERE vp.`vendorId` = vt.`vendorId`" +
					"  AND vt.`testId` = pt.`testId` AND pt.`testName` LIKE '%"+objPathologyTestsBean.getTestName()+"%'";
			System.out.println("filter by name---"+sSql);
			listPathologyTestsBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyTestsBean>(
							PathologyTestsBean.class));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
		return listPathologyTestsBeans;
	}

}
