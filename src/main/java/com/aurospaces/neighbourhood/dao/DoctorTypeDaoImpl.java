/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.DoctorTypeBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public  class DoctorTypeDaoImpl extends DaoSupport implements DoctorTypeDao {

	@Override
	public boolean insertDoctorType(DoctorTypeBean objDoctorTypeBean){
		boolean isExperienceInsert = false;
		try {
			String sSql = "insert into doctor_type(doctortypeId, doctortypeName, doctortypeDesc) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objDoctorTypeBean.getDoctortypeId(),
							objDoctorTypeBean.getDoctortypeName(),
							objDoctorTypeBean.getDoctortypeDesc()});
			System.out.println(iCount);
			if (iCount != 0) {
				isExperienceInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isExperienceInsert;
	}
	@Override
	public boolean updateDoctorType(DoctorTypeBean objDoctorTypeBean) {
		boolean isDoctorTypeUpdate = false;
		try {
			String sSql = "update doctor_type set doctortypeName=?, doctortypeDesc=? where doctortypeId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					
					objDoctorTypeBean.getDoctortypeName(),
					objDoctorTypeBean.getDoctortypeDesc(),
					objDoctorTypeBean.getDoctortypeId()
				);
			System.out.println(sSql);
			if (iCount != 0) {
				isDoctorTypeUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isDoctorTypeUpdate;
	}

	@Override
	public List<DoctorTypeBean> getDoctorTypes(
			DoctorTypeBean objDoctorTypeBean, String likeSearch) {
		List<DoctorTypeBean> listDoctorTypeBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from doctor_type");
			if (objDoctorTypeBean.getDoctortypeName() != null) {
				if ("both".equals(likeSearch)) {
					objStringBuffer.append(" where doctortypeName like '%"
							+ objDoctorTypeBean.getDoctortypeName() + "%'");
				} else if ("left".equals(likeSearch)) {
					objStringBuffer.append(" where doctortypeName like '%"
							+ objDoctorTypeBean.getDoctortypeName() + "'");
				} else if ("right".equals(likeSearch)) {
					objStringBuffer.append(" where doctortypeName like '"
							+ objDoctorTypeBean.getDoctortypeName() + "%'");
				} else {
					objStringBuffer.append(" where doctortypeName = '"
							+ objDoctorTypeBean.getDoctortypeName() + "'");
				}

			}
			if (objDoctorTypeBean.getDoctortypeId() != null	&& StringUtils.isNotEmpty(likeSearch)
					&& "idList".equals(likeSearch)) {
				objStringBuffer.append(" where doctortypeId = '"
						+ objDoctorTypeBean.getDoctortypeId() + "'");
			}
			if (objDoctorTypeBean.getDoctortypeId() != null
					&& StringUtils.isEmpty(likeSearch)) {
				objStringBuffer.append(" and doctortypeId != '"
						+ objDoctorTypeBean.getDoctortypeId() + "'");
			}
			
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listDoctorTypeBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<DoctorTypeBean>(
							DoctorTypeBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listDoctorTypeBeans;
	}

	@Override
	public int getduplicatechecks(DoctorTypeBean objDoctorTypeBean, String likeSearch) {
		int DoctorTypeBeans =0;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select count(*) from doctor_type");
			if (objDoctorTypeBean.getDoctortypeName() != null && objDoctorTypeBean.getDoctortypeName()!="") {
	
				
					objStringBuffer.append(" where doctortypeName = '"
							+ objDoctorTypeBean.getDoctortypeName() + "'");
				}
			/*if (objDoctorTypeBean.getEmail() != null && objDoctorTypeBean.getEmail()!="" ){
					
					objStringBuffer.append(" where Email = '"
							+ objDoctorTypeBean.getEmail() + "'");
				}*/
				
			
			
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			DoctorTypeBeans = getJdbcTemplate()
					.queryForInt(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return DoctorTypeBeans;
	}

	@Override
	public DoctorTypeBean getDoctorType(DoctorTypeBean objDoctorTypeBean, String likeSearch) {
		DoctorTypeBean objDocTypeBean = null;
		try {
			String sSql = "select * from doctor_type where doctortypeId ='"
					+ objDoctorTypeBean.getDoctortypeId() + "'";
			objDocTypeBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<DoctorTypeBean>(
									DoctorTypeBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objDocTypeBean;
	}

	@Override
	public boolean deleteDoctorType(DoctorTypeBean objDoctorTypeBean) {
		boolean isDoctorTypeDelete = false;
		try {
			String sSql = "delete from doctor_type where doctortypeId ='"
					+ objDoctorTypeBean.getDoctortypeId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isDoctorTypeDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isDoctorTypeDelete;
	}
	@Override
	public DoctorTypeBean getDoctorTypename(DoctorTypeBean objDoctorTypeBean, String likeSearch) {
		DoctorTypeBean objDocTypeBean = null;
		try {
			String sSql = "select doctortypeId from doctor_type where doctortypeName ='"
					+ objDoctorTypeBean.getDoctortypeName() + "'";
			System.out.println(sSql);
			objDocTypeBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<DoctorTypeBean>(
									DoctorTypeBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in getDoctorType() in DoctorTypeDaoImpl"+e.getMessage());
			logger.fatal("error in getDoctorType() in DoctorTypeDaoImpl");
		} finally {

		}
		return objDocTypeBean;
	}
	
	}






