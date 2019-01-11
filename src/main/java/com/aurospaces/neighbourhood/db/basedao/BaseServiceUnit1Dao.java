
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

import com.aurospaces.neighbourhood.db.model.ServiceUnit1;


public class BaseServiceUnit1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO service_unit1( created_time, updated_time, old_id, service_id, vendor_id, name, description, label, img_url, active) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ServiceUnit1 serviceUnit1) 
	{
	if(serviceUnit1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(serviceUnit1.getCreatedTime() == null)
					{
					serviceUnit1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(serviceUnit1.getCreatedTime().getTime()); 
							
					if(serviceUnit1.getUpdatedTime() == null)
					{
					serviceUnit1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(serviceUnit1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, serviceUnit1.getOldId());
ps.setInt(4, serviceUnit1.getServiceId());
ps.setInt(5, serviceUnit1.getVendorId());
ps.setString(6, serviceUnit1.getName());
ps.setString(7, serviceUnit1.getDescription());
ps.setString(8, serviceUnit1.getLabel());
ps.setString(9, serviceUnit1.getImgUrl());
ps.setInt(10, serviceUnit1.getActive());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				serviceUnit1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE service_unit1  set old_id = ? ,service_id = ? ,vendor_id = ? ,name = ? ,description = ? ,label = ? ,img_url = ? ,active = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{serviceUnit1.getOldId(),serviceUnit1.getServiceId(),serviceUnit1.getVendorId(),serviceUnit1.getName(),serviceUnit1.getDescription(),serviceUnit1.getLabel(),serviceUnit1.getImgUrl(),serviceUnit1.getActive(),serviceUnit1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM service_unit1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ServiceUnit1 getById(int id) {
			String sql = "SELECT * from service_unit1 where id = ? ";
			List<ServiceUnit1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnit1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
