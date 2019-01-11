
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

import com.aurospaces.neighbourhood.db.model.ServiceUnitHappiness;


public class BaseServiceUnitHappinessDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO service_unit_happiness( created_time, updated_time, service_unit_id, vendor_id, happiness, time_to_serve, served_number, feedback) values (?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ServiceUnitHappiness serviceUnitHappiness) 
	{
	if(serviceUnitHappiness.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(serviceUnitHappiness.getCreatedTime() == null)
					{
					serviceUnitHappiness.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(serviceUnitHappiness.getCreatedTime().getTime()); 
							
					if(serviceUnitHappiness.getUpdatedTime() == null)
					{
					serviceUnitHappiness.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(serviceUnitHappiness.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, serviceUnitHappiness.getServiceUnitId());
ps.setInt(4, serviceUnitHappiness.getVendorId());
ps.setInt(5, serviceUnitHappiness.getHappiness());
ps.setInt(6, serviceUnitHappiness.getTimeToServe());
ps.setInt(7, serviceUnitHappiness.getServedNumber());
ps.setString(8, serviceUnitHappiness.getFeedback());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				serviceUnitHappiness.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE service_unit_happiness  set service_unit_id = ? ,vendor_id = ? ,happiness = ? ,time_to_serve = ? ,served_number = ? ,feedback = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{serviceUnitHappiness.getServiceUnitId(),serviceUnitHappiness.getVendorId(),serviceUnitHappiness.getHappiness(),serviceUnitHappiness.getTimeToServe(),serviceUnitHappiness.getServedNumber(),serviceUnitHappiness.getFeedback(),serviceUnitHappiness.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM service_unit_happiness WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ServiceUnitHappiness getById(int id) {
			String sql = "SELECT * from service_unit_happiness where id = ? ";
			List<ServiceUnitHappiness> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnitHappiness.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
