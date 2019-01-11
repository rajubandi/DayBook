/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyBean;
import com.aurospaces.neighbourhood.bean.PathologyTestBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Divya
 * 
 */
@Repository
public class PathologyTestDaoImpl extends DaoSupport implements
		PathologyTestDao {
	public boolean insertPathology(PathologyBean objPathologyBean) {
		boolean isPathologyInsert = false;
		try {
			String sSql = "insert into Pathology(TestName, TestDesc,Price,Discount) values(?,?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objPathologyBean.getTestName(),
							objPathologyBean.getTestDesc(),objPathologyBean.getPrice(),objPathologyBean.getDiscount(),
							"" });
			System.out.println(iCount);
			if (iCount != 0) {
				isPathologyInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyInsert;
	}

	@Override
	public boolean updatePathology(PathologyBean objPathologyBean) {
		boolean isPathologyUpdate = false;
		try {
			String sSql = "update Pathology set PathologyName = ? where PathologyId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objPathologyBean.getTestName(),
					objPathologyBean.getPrice());
			if (iCount != 0) {
				isPathologyUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyUpdate;
	}

	@Override
	public List<PathologyTestBean> getPathologys(PathologyTestBean objPathologyBean,
			String likeSearch) {
		List<PathologyTestBean> listPathologyBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from pathology_tests");
			/*if (objPathologyBean.getTestName() != null) {
				if ("both".equals(likeSearch)) {
					objStringBuffer.append(" where PathologyName like '%"
							+ objPathologyBean.getTestName() + "%'");
				} else if ("left".equals(likeSearch)) {
					objStringBuffer.append(" where PathologyName like '%"
							+ objPathologyBean.getTestName() + "'");
				} else if ("right".equals(likeSearch)) {
					objStringBuffer.append(" where PathologyName like '"
							+ objPathologyBean.getTestName() + "%'");
				} else {
					objStringBuffer.append(" where PathologyName = '"
							+ objPathologyBean.getTestName() + "'");
				}

			}
			if (objPathologyBean.getTestDesc() != null) {
				objStringBuffer.append(" and TestName!= '"
						+ objPathologyBean.getDiscount() + "'");
			}*/
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listPathologyBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyTestBean>(
							PathologyTestBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyBeans;
	}

	@Override
	public PathologyBean getPahtology(PathologyBean objPathologyBean,
			String likeSearch) {
		PathologyBean objLocalPahtologyBean = null;
		try {
			String sSql = "select * from Pathology where PathologyName ='"
					+ objPathologyBean.getTestName() + "'";
			objLocalPahtologyBean = getJdbcTemplate().queryForObject(
					sSql,
					new BeanPropertyRowMapper<PathologyBean>(
							PathologyBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objLocalPahtologyBean;
	}

	@Override
	public boolean deletePathology(PathologyBean objPathologyBean) {
		boolean isPathologyDelete = false;
		try {
			String sSql = "delete from Pathology where PathologyName ='"
					+ objPathologyBean.getDiscount() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isPathologyDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyDelete;
	}
}
