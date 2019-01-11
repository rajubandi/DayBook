
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

import com.aurospaces.neighbourhood.db.model.Symptom1;


public class BaseSymptom1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO symptom1( old_id, created_time, updated_time, name, description, active) values (?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Symptom1 symptom1) 
	{
	if(symptom1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(symptom1.getCreatedTime() == null)
					{
					symptom1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(symptom1.getCreatedTime().getTime()); 
							
					if(symptom1.getUpdatedTime() == null)
					{
					symptom1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(symptom1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, symptom1.getOldId());
ps.setTimestamp(2, createdTime);
ps.setTimestamp(3, updatedTime);
ps.setString(4, symptom1.getName());
ps.setString(5, symptom1.getDescription());
ps.setInt(6, symptom1.getActive());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				symptom1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE symptom1  set old_id = ? ,updated_time = ? ,name = ? ,description = ? ,active = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{symptom1.getOldId(),symptom1.getUpdatedTime(),symptom1.getName(),symptom1.getDescription(),symptom1.getActive(),symptom1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM symptom1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Symptom1 getById(int id) {
			String sql = "SELECT * from symptom1 where id = ? ";
			List<Symptom1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Symptom1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
