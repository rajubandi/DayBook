/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Divya
 * 
 */
@Repository
public class PathologyTestTypeDaoimpl extends DaoSupport implements PathologyTestTypeDao {
	@Override
	public boolean insertPathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean) {
		boolean isPathologyTestTypeInsert = false;
		try {
			String sSql = "insert into pathology_test_types(testTypeId, testTypeName, testDescription) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objPathologyTestTypeBean.getTestTypeId(),
							objPathologyTestTypeBean.getTestTypeName(), "" });
			System.out.println(iCount);
			if (iCount != 0) {
				isPathologyTestTypeInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyTestTypeInsert;
	}

	@Override
	public boolean updatePathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean) {
		boolean isPathologyTestTypeUpdate = false;
		try {
			String sSql = "update pathology_test_types set testTypeName = ? where testTypeId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objPathologyTestTypeBean.getTestTypeName(), objPathologyTestTypeBean.getTestTypeId());
			if (iCount != 0) {
				isPathologyTestTypeUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyTestTypeUpdate;
	}

	@Override
	public List<PathologyTestTypeBean> getPathologyTestTypes(PathologyTestTypeBean objPathologyTestTypeBean, String likeSearch) {
		List<PathologyTestTypeBean> listPathologyTestTypeBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from pathology_test_types");
			if (objPathologyTestTypeBean.getTestTypeName() != null) {
				if ("both".equals(likeSearch)) {
					objStringBuffer.append(" where testTypeName like '%"
							+ objPathologyTestTypeBean.getTestTypeName() + "%'");
				} else if ("left".equals(likeSearch)) {
					objStringBuffer.append(" where testTypeName like '%"
							+ objPathologyTestTypeBean.getTestTypeName() + "'");
				} else if ("right".equals(likeSearch)) {
					objStringBuffer.append(" where testTypeName like '"
							+ objPathologyTestTypeBean.getTestTypeName() + "%'");
				} else {
					objStringBuffer.append(" where testTypeName = '"
							+ objPathologyTestTypeBean.getTestTypeName() + "'");
				}

			}
			if (objPathologyTestTypeBean.getTestTypeId() != null) {
				objStringBuffer.append(" and testTypeId != '"
						+ objPathologyTestTypeBean.getTestTypeId() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listPathologyTestTypeBeans = getJdbcTemplate().query(sSql,
					new BeanPropertyRowMapper<PathologyTestTypeBean>(PathologyTestTypeBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyTestTypeBeans;
	}

	@Override
	public PathologyTestTypeBean getPathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean, String likeSearch) {
		PathologyTestTypeBean objLocalPathologyTestTypeBean = null;
		try {
			String sSql = "select * from pathology_test_types where testTypeId ='"
					+ objPathologyTestTypeBean.getTestTypeId() + "'";
			objLocalPathologyTestTypeBean = getJdbcTemplate().queryForObject(sSql,
					new BeanPropertyRowMapper<PathologyTestTypeBean>(PathologyTestTypeBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objLocalPathologyTestTypeBean;
	}

	@Override
	public boolean deletePathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean) {
		boolean isPathologyTestTypeDelete = false;
		try {
			String sSql = "delete from pathology_test_types where testTypeId ='"
					+ objPathologyTestTypeBean.getTestTypeId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isPathologyTestTypeDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyTestTypeDelete;
	}
}
