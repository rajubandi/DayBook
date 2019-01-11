
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

import com.aurospaces.neighbourhood.db.model.LocationService1;


public class BaseLocationService1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO location_service1( created_time, updated_time, location_id, service_id, display_order) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final LocationService1 locationService1) 
	{
	if(locationService1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(locationService1.getCreatedTime() == null)
					{
					locationService1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(locationService1.getCreatedTime().getTime()); 
							
					if(locationService1.getUpdatedTime() == null)
					{
					locationService1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(locationService1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, locationService1.getLocationId());
ps.setInt(4, locationService1.getServiceId());
ps.setInt(5, locationService1.getDisplayOrder());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				locationService1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE location_service1  set updated_time = ? ,location_id = ? ,service_id = ? ,display_order = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{locationService1.getUpdatedTime(),locationService1.getLocationId(),locationService1.getServiceId(),locationService1.getDisplayOrder(),locationService1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM location_service1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public LocationService1 getById(int id) {
			String sql = "SELECT * from location_service1 where id = ? ";
			List<LocationService1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(LocationService1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
