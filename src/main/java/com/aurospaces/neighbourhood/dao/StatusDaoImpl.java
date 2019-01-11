/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.bean.StatusBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class StatusDaoImpl extends DaoSupport implements StatusDao {

	@Override
	public boolean insertStatus(StatusBean objStausBean) {
		boolean isStatusInsert = false;
		try {
			String sSql = "insert into status(statusId, statusName, statusDesc) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objStausBean.getStatusId(),
							objStausBean.getStatusName(), "" });
			System.out.println(iCount);
			if (iCount != 0) {
				isStatusInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isStatusInsert;
	}

	@Override
	public boolean updateStatus(StatusBean objStausBean) {
		boolean isStatusUpdate = false;
		try {
			String sSql = "update status set statusName = ? where statusId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objStausBean.getStatusName(),
					objStausBean.getStatusId());
			if (iCount != 0) {
				isStatusUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isStatusUpdate;
	}

	@Override
	public List<StatusBean> getStatuss(StatusBean objStausBean, String likeSearch) {
		List<StatusBean> listStausBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from status");
			if (objStausBean.getStatusName() != null) {
				if("both".equals(likeSearch)){
				objStringBuffer.append(" where statusName like '%"
						+ objStausBean.getStatusName() + "%'");
				}
				else if("left".equals(likeSearch)){
					objStringBuffer.append(" where statusName like '%"
							+ objStausBean.getStatusName() + "'");
				}else if("right".equals(likeSearch)){
					objStringBuffer.append(" where statusName like '"
							+ objStausBean.getStatusName() + "%'");
				}else {
					objStringBuffer.append(" where statusName = '"
							+ objStausBean.getStatusName() + "'");
				}
				
			}
			if (objStausBean.getStatusId() != null) {
				objStringBuffer.append(" and statusId != '"
						+ objStausBean.getStatusId() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listStausBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<StatusBean>(
									StatusBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listStausBeans;
	}

	@Override
	public StatusBean getStatus(StatusBean objStausBean, String likeSearch) {
		StatusBean objLocalStatusBean = null;
		String sSql = null;
		StringBuffer objStringBuffer = null;
		try {
			objStringBuffer = new StringBuffer();
			objStringBuffer.append("SELECT * FROM status s, service_status ss WHERE s.`statusId` = ss.statusId");
			if(objStausBean != null ){
				if(StringUtils.isNotEmpty(objStausBean.getStatusId())){
					objStringBuffer.append(" and  s.statusId ='"+ objStausBean.getStatusId() + "'");
				}
				if(StringUtils.isNotEmpty(objStausBean.getStatusName())){
					objStringBuffer.append(" and  s.statusName ='"+ objStausBean.getStatusName() + "'");
				}
				if(StringUtils.isNotEmpty(objStausBean.getServiceId())){
					objStringBuffer.append(" and  ss.serviceId ='"+ objStausBean.getServiceId() + "'");
				}
			}
			 sSql = objStringBuffer.toString();
			 System.out.println("status for id or name --"+sSql);
			 objLocalStatusBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<StatusBean>(
									StatusBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objLocalStatusBean;
	}

	@Override
	public boolean deleteStatus(StatusBean objStausBean) {
		boolean isStatusDelete = false;
		try {
			String sSql = "delete from status where statusId ='"+ objStausBean.getStatusId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isStatusDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isStatusDelete;
	}
}
