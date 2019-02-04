
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.UserBean;
import com.aurospaces.neighbourhood.bean.UsersBean;

public class BaseUserDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public final String INSERT_SQL = "INSERT INTO users( name, password, rolId,mobile) values (?, ?, ?,?)";

	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final UsersBean user) {
		if (user.getId() == 0) {

			KeyHolder keyHolder = new GeneratedKeyHolder();
			int update = jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

					PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
					ps.setString(1, user.getName());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getRolId());
					ps.setString(4, user.getMobile());					

					return ps;
				}
			}, keyHolder);

			Number unId = keyHolder.getKey();
			user.setId(unId.intValue());

		} else {

			String sql = "UPDATE users  set name = ? ,password = ? ,rolId = ?,mobile =?  where id = ? ";
			
			jdbcTemplate.update(sql, new Object[] { user.getName(), user.getPassword(), user.getRolId(),user.getMobile(),
					 user.getId() });
		}
	}

	@Transactional
	public void delete(int id) {
		String sql = "DELETE FROM users WHERE id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	public UserBean getById(int id) {
		String sql = "SELECT * from users where id = ? ";
		List<UserBean> retlist = jdbcTemplate.query(sql, new Object[] { id },
				ParameterizedBeanPropertyRowMapper.newInstance(UserBean.class));
		if (retlist.size() > 0)
			return retlist.get(0);
		return null;
	}
	
	public UsersBean getByPassword(String mobile) {
		String sql = "SELECT * from users where mobile = ? ";
		List<UsersBean> retlist = jdbcTemplate.query(sql, new Object[] { mobile },
				ParameterizedBeanPropertyRowMapper.newInstance(UsersBean.class));
		if (retlist.size() > 0)
			return retlist.get(0);
		return null;
	}
	
	public UsersBean getByMobileAndRole(String mobile, String roleId) {
		String sql = "SELECT * from users where rolId=? and mobile = ?";
		List<UsersBean> retlist = jdbcTemplate.query(sql, new Object[] { Integer.parseInt(roleId), mobile,},
				ParameterizedBeanPropertyRowMapper.newInstance(UsersBean.class));
		if (retlist.size() > 0)
			return retlist.get(0);
		return null;
	}

}