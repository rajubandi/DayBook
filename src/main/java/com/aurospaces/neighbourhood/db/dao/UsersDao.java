
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseUsersDao;
import com.aurospaces.neighbourhood.db.model.Partner;
import com.aurospaces.neighbourhood.db.model.Users;




@Repository(value = "usersDao")
public class UsersDao extends BaseUsersDao
{
	public List<Users> getAll() {
		List<Users> list = null;
		try {
			String sql = "SELECT * FROM users";
			list = jdbcTemplate.query(sql, new Object[] {},
					ParameterizedBeanPropertyRowMapper.newInstance(Users.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}
	 public int getUserId(Users objjUsers){
		 String sql = "select id from users where name = '"+objjUsers.getName()+"'";
			int result = jdbcTemplate.queryForInt(sql);
		
		 return result;

}
}

