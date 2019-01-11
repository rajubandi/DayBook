
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

import com.aurospaces.neighbourhood.db.model.ServiceSeo;


public class BaseServiceSeoDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO service_seo( service_id, name, value, created_time, updated_time) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ServiceSeo serviceSeo) 
	{
	if(serviceSeo.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(serviceSeo.getCreatedTime() == null)
					{
					serviceSeo.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(serviceSeo.getCreatedTime().getTime()); 
							
					if(serviceSeo.getUpdatedTime() == null)
					{
					serviceSeo.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(serviceSeo.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setInt(1, serviceSeo.getServiceId());
ps.setString(2, serviceSeo.getName());
ps.setString(3, serviceSeo.getValue());
ps.setTimestamp(4, createdTime);
ps.setTimestamp(5, updatedTime);

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				serviceSeo.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE service_seo  set service_id = ? ,name = ? ,value = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{serviceSeo.getServiceId(),serviceSeo.getName(),serviceSeo.getValue(),serviceSeo.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM service_seo WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ServiceSeo getById(int id) {
			String sql = "SELECT * from service_seo where id = ? ";
			List<ServiceSeo> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceSeo.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
