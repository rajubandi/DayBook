
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

import com.aurospaces.neighbourhood.db.model.Experience1;


public class BaseExperience1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO experience1( created_time, updated_time, old_experience_id, name, description) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Experience1 experience1) 
	{
	if(experience1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(experience1.getCreatedTime() == null)
					{
					experience1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(experience1.getCreatedTime().getTime()); 
							
					if(experience1.getUpdatedTime() == null)
					{
					experience1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(experience1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, experience1.getOldExperienceId());
ps.setString(4, experience1.getName());
ps.setString(5, experience1.getDescription());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				experience1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE experience1  set updated_time = ? ,old_experience_id = ? ,name = ? ,description = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{experience1.getUpdatedTime(),experience1.getOldExperienceId(),experience1.getName(),experience1.getDescription(),experience1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM experience1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Experience1 getById(int id) {
			String sql = "SELECT * from experience1 where id = ? ";
			List<Experience1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Experience1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
