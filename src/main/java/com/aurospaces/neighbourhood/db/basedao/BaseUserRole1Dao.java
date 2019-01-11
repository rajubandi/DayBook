
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.db.model.UserRole1;


public class BaseUserRole1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO user_role1( userId, roleId) values (?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final UserRole1 userRole1) 
	{
	if(userRole1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setInt(1, userRole1.getUserId());
ps.setInt(2, userRole1.getRoleId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				userRole1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE user_role1  set userId = ? ,roleId = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{userRole1.getUserId(),userRole1.getRoleId(),userRole1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM user_role1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public UserRole1 getById(int id) {
			String sql = "SELECT * from user_role1 where id = ? ";
			List<UserRole1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(UserRole1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
