
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

import com.aurospaces.neighbourhood.db.model.VendorService1;


public class BaseVendorService1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO vendor_service1( created_time, updated_time, vendor_id, service_id) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final VendorService1 vendorService1) 
	{
	if(vendorService1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(vendorService1.getCreatedTime() == null)
					{
					vendorService1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(vendorService1.getCreatedTime().getTime()); 
							
					if(vendorService1.getUpdatedTime() == null)
					{
					vendorService1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(vendorService1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, vendorService1.getVendorId());
ps.setInt(4, vendorService1.getServiceId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				vendorService1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE vendor_service1  set updated_time = ? ,vendor_id = ? ,service_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{vendorService1.getUpdatedTime(),vendorService1.getVendorId(),vendorService1.getServiceId(),vendorService1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM vendor_service1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public VendorService1 getById(int id) {
			String sql = "SELECT * from vendor_service1 where id = ? ";
			List<VendorService1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(VendorService1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
