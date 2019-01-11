
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

import com.aurospaces.neighbourhood.db.model.StatusList;


public class BaseStatusListDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO status_list1( created_time, updated_time, name) values (?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final StatusList statusList) 
	{
	if(statusList.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(statusList.getCreatedTime() == null)
					{
					statusList.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(statusList.getCreatedTime().getTime()); 
							
					if(statusList.getUpdatedTime() == null)
					{
					statusList.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(statusList.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, statusList.getName());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				statusList.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE status_list1  set updated_time = ? ,name = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{statusList.getUpdatedTime(),statusList.getName(),statusList.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM status_list1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public StatusList getById(int id) {
			String sql = "SELECT * from status_list1 where id = ? ";
			List<StatusList> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(StatusList.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
