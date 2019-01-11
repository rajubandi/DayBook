
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

import com.aurospaces.neighbourhood.db.model.Users;


public class BaseUsersDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO users( created_time, updated_time, name, password, location_id, display_name) values (?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Users users) 
	{
	if(users.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(users.getCreatedTime() == null)
					{
					users.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(users.getCreatedTime().getTime()); 
							
					if(users.getUpdatedTime() == null)
					{
					users.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(users.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, users.getName());
ps.setString(4, users.getPassword());
ps.setInt(5, users.getLocationId());
ps.setString(6, users.getDisplayName());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				users.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE users  set name = ? ,password = ? ,location_id = ? ,display_name = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{users.getName(),users.getPassword(),users.getLocationId(),users.getDisplayName(),users.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM users WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Users getById(int id) {
			String sql = "SELECT * from users where id = ? ";
			List<Users> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Users.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
