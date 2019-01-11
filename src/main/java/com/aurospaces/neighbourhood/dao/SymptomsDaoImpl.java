/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.bean.SymptomsBean;
import com.aurospaces.neighbourhood.bean.SymptomsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author 
 * 
 */
@Repository
public class SymptomsDaoImpl extends DaoSupport implements SymptomsDao {

	@Override
	public boolean insertSymptoms(SymptomsBean objSymptomsBean) {
		boolean isSymptomsInsert = false;
		try {
			String sSql = "insert into Symptoms(symptomsId, symptomsName, symptomsDesc) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objSymptomsBean.getSymsptomsId(),
							objSymptomsBean.getSymptomsName(), "" });
			System.out.println(iCount);
			if (iCount != 0) {
				isSymptomsInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isSymptomsInsert;
	}

	@Override
	public boolean updateSymptoms(SymptomsBean objSymptomsBean) {
		boolean isSymptomsUpdate = false;
		try {
			String sSql = "update symptoms set symptomsName = ? where symptomsId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objSymptomsBean.getSymptomsName(),
					objSymptomsBean.getSymsptomsId());
			if (iCount != 0) {
				isSymptomsUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isSymptomsUpdate;
	}

	@Override
	public List<SymptomsBean> getSymptomss(SymptomsBean objSymptomsBean, String likeSearch) {
		List<SymptomsBean> listSymptomsBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from symptoms");
			if (objSymptomsBean.getSymptomsName() != null) {
				if("both".equals(likeSearch)){
				objStringBuffer.append(" where symptomsName like '%"
						+ objSymptomsBean.getSymptomsName() + "%'");
				}
				else if("left".equals(likeSearch)){
					objStringBuffer.append(" where symptomsName like '%"
							+ objSymptomsBean.getSymptomsName() + "'");
				}else if("right".equals(likeSearch)){
					objStringBuffer.append(" where symptomsName like '"
							+ objSymptomsBean.getSymptomsName() + "%'");
				}else {
					objStringBuffer.append(" where symptomsName = '"
							+ objSymptomsBean.getSymptomsName() + "'");
				}
				
			}
			if (objSymptomsBean.getSymsptomsId() != null) {
				objStringBuffer.append(" and SymptomsId != '"
						+ objSymptomsBean.getSymsptomsId() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listSymptomsBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<SymptomsBean>(
									SymptomsBean.class));
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {

		}
		return listSymptomsBeans;
	}

	@Override
	public SymptomsBean getSymptoms(SymptomsBean objSymptomsBean, String likeSearch) {
		
		try {
			System.out.println( objSymptomsBean.getSymsptomsId());
			String sSql = "select * from symptoms where symptomsId ='"
					+ objSymptomsBean.getSymsptomsId() + "'";
			objSymptomsBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<SymptomsBean>(
									SymptomsBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objSymptomsBean;
	}

	@Override
	public boolean deleteSymptoms(SymptomsBean objSymptomsBean) {
		boolean isSymptomsDelete = false;
		try {
			String sSql = "delete from symptoms where symptomsId ='"
					+ objSymptomsBean.getSymsptomsId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isSymptomsDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isSymptomsDelete;
	}

	@Override
	public String editSymptoms(SymptomsBean objSymptomsBean) {
		try {
		
			String sSql = "select symptomsName from symptoms where symptomsId ='"
					+ objSymptomsBean.getSymsptomsId() + "'";
			objSymptomsBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<SymptomsBean>(
									SymptomsBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	
	}
}
