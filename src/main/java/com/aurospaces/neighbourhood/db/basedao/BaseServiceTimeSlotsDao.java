
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

import com.aurospaces.neighbourhood.db.model.ServiceTimeSlots;


public class BaseServiceTimeSlotsDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO service_time_slots1( created_time, updated_time, time_slot_id, service_id) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ServiceTimeSlots serviceTimeSlots) 
	{
	if(serviceTimeSlots.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(serviceTimeSlots.getCreatedTime() == null)
					{
					serviceTimeSlots.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(serviceTimeSlots.getCreatedTime().getTime()); 
							
					if(serviceTimeSlots.getUpdatedTime() == null)
					{
					serviceTimeSlots.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(serviceTimeSlots.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, serviceTimeSlots.getTimeSlotId());
ps.setInt(4, serviceTimeSlots.getServiceId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				serviceTimeSlots.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE service_time_slots1  set updated_time = ? ,time_slot_id = ? ,service_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{serviceTimeSlots.getUpdatedTime(),serviceTimeSlots.getTimeSlotId(),serviceTimeSlots.getServiceId(),serviceTimeSlots.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM service_time_slots1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ServiceTimeSlots getById(int id) {
			String sql = "SELECT * from service_time_slots1 where id = ? ";
			List<ServiceTimeSlots> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceTimeSlots.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
