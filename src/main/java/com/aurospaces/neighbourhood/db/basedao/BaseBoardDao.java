
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.aurospaces.neighbourhood.db.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;


public class BaseBoardDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO user( created_time, updated_time, waitw, password, mobile_number) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final User user) 
	{
	if(user.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(user.getCreatedTime() == null)
					{
					user.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(user.getCreatedTime().getTime()); 
							
					if(user.getUpdatedTime() == null)
					{
					user.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(user.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, user.getUserName());
ps.setString(4, user.getPassword());
ps.setString(5, user.getMobileNumber());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				user.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE user  set updated_time = ? ,user_name = ? ,password = ? ,mobile_number = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{user.getUpdatedTime(),user.getUserName(),user.getPassword(),user.getMobileNumber(),user.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM user WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public User getById(int id) {
			String sql = "SELECT * from user where id = ? ";
			List<User> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(User.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
