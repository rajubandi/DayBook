
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

import com.aurospaces.neighbourhood.db.model.ServiceUnitLocation;


public class BaseServiceUnitLocationDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO service_unit_location1( created_time, updated_time, service_unit_id, location_id) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ServiceUnitLocation serviceUnitLocation) 
	{
	if(serviceUnitLocation.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(serviceUnitLocation.getCreatedTime() == null)
					{
					serviceUnitLocation.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(serviceUnitLocation.getCreatedTime().getTime()); 
							
					if(serviceUnitLocation.getUpdatedTime() == null)
					{
					serviceUnitLocation.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(serviceUnitLocation.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, serviceUnitLocation.getServiceUnitId());
ps.setInt(4, serviceUnitLocation.getLocationId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				serviceUnitLocation.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE service_unit_location1  set updated_time = ? ,service_unit_id = ? ,location_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{serviceUnitLocation.getUpdatedTime(),serviceUnitLocation.getServiceUnitId(),serviceUnitLocation.getLocationId(),serviceUnitLocation.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM service_unit_location1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ServiceUnitLocation getById(int id) {
			String sql = "SELECT * from service_unit_location1 where id = ? ";
			List<ServiceUnitLocation> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnitLocation.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
