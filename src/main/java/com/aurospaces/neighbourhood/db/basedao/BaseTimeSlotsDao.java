
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

import com.aurospaces.neighbourhood.db.model.TimeSlots;


public class BaseTimeSlotsDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO time_slots1( created_time, updated_time, label, old_id, description, hour, active) values (?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final TimeSlots timeSlots) 
	{
	if(timeSlots.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(timeSlots.getCreatedTime() == null)
					{
					timeSlots.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(timeSlots.getCreatedTime().getTime()); 
							
					if(timeSlots.getUpdatedTime() == null)
					{
					timeSlots.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(timeSlots.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, timeSlots.getLabel());
ps.setString(4, timeSlots.getOldId());
ps.setString(5, timeSlots.getDescription());
ps.setInt(6, timeSlots.getHour());
ps.setInt(7, timeSlots.getActive());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				timeSlots.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE time_slots1  set updated_time = ? ,label = ? ,old_id = ? ,description = ? ,hour = ? ,active = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{timeSlots.getUpdatedTime(),timeSlots.getLabel(),timeSlots.getOldId(),timeSlots.getDescription(),timeSlots.getHour(),timeSlots.getActive(),timeSlots.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM time_slots1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public TimeSlots getById(int id) {
			String sql = "SELECT * from time_slots1 where id = ? ";
			List<TimeSlots> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(TimeSlots.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
