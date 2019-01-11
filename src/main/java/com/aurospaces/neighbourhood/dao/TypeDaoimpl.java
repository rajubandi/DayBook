/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.TypeBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Divya
 * 
 */
@Repository
public class TypeDaoimpl extends DaoSupport implements TypeDao {
	@Override
	public boolean insertType(TypeBean objTypeBean) {
		boolean isTypeInsert = false;
		try {
			String sSql = "insert into Type(TypeId, TypeName, TypeDesc) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objTypeBean.getTypeId(),
							objTypeBean.getTypeName(), "" });
			System.out.println(iCount);
			if (iCount != 0) {
				isTypeInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isTypeInsert;
	}

	@Override
	public boolean updateType(TypeBean objTypeBean) {
		boolean isTypeUpdate = false;
		try {
			String sSql = "update Type set TypeName = ? where TypeId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objTypeBean.getTypeName(), objTypeBean.getTypeId());
			if (iCount != 0) {
				isTypeUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isTypeUpdate;
	}

	@Override
	public List<TypeBean> getTypes(TypeBean objTypeBean, String likeSearch) {
		List<TypeBean> listTypeBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from Type");
			if (objTypeBean.getTypeName() != null) {
				if ("both".equals(likeSearch)) {
					objStringBuffer.append(" where TypeName like '%"
							+ objTypeBean.getTypeName() + "%'");
				} else if ("left".equals(likeSearch)) {
					objStringBuffer.append(" where TypeName like '%"
							+ objTypeBean.getTypeName() + "'");
				} else if ("right".equals(likeSearch)) {
					objStringBuffer.append(" where TypeName like '"
							+ objTypeBean.getTypeName() + "%'");
				} else {
					objStringBuffer.append(" where TypeName = '"
							+ objTypeBean.getTypeName() + "'");
				}

			}
			if (objTypeBean.getTypeId() != null) {
				objStringBuffer.append(" and TypeId != '"
						+ objTypeBean.getTypeId() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listTypeBeans = getJdbcTemplate().query(sSql,
					new BeanPropertyRowMapper<TypeBean>(TypeBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listTypeBeans;
	}

	@Override
	public TypeBean getType(TypeBean objTypeBean, String likeSearch) {
		TypeBean objLocalTypeBean = null;
		try {
			String sSql = "select * from Type where TypeId ='"
					+ objTypeBean.getTypeId() + "'";
			objLocalTypeBean = getJdbcTemplate().queryForObject(sSql,
					new BeanPropertyRowMapper<TypeBean>(TypeBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objLocalTypeBean;
	}

	@Override
	public boolean deleteType(TypeBean objTypeBean) {
		boolean isTypeDelete = false;
		try {
			String sSql = "delete from Type where TypeId ='"
					+ objTypeBean.getTypeId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isTypeDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isTypeDelete;
	}
}
