/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.UserRoleBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author YOGI
 * 
 */
@Repository
public class UserRoleDaoImpl extends DaoSupport implements UserRoleDao {

	@Override
	public boolean isInserUserRole(UserRoleBean objUserRoleBean) {
		boolean isInsertUserRole = false;
		try {
			String sSql = "insert into user_role (userId, roleId) values(?,?)";
			getJdbcTemplate().update(
					sSql,
					new Object[] { objUserRoleBean.getUserId(),
							objUserRoleBean.getRoleId() });
			isInsertUserRole = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInsertUserRole;
	}

}
