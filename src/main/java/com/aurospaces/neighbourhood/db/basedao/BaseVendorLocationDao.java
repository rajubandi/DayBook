
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

import com.aurospaces.neighbourhood.db.model.VendorLocation;


public class BaseVendorLocationDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO vendor_location( created_time, updated_time, location_id, vendor_id) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final VendorLocation vendorLocation) 
	{
	if(vendorLocation.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(vendorLocation.getCreatedTime() == null)
					{
					vendorLocation.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(vendorLocation.getCreatedTime().getTime()); 
							
					if(vendorLocation.getUpdatedTime() == null)
					{
					vendorLocation.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(vendorLocation.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, vendorLocation.getLocationId());
ps.setInt(4, vendorLocation.getVendorId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				vendorLocation.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE vendor_location  set location_id = ? ,vendor_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{vendorLocation.getLocationId(),vendorLocation.getVendorId(),vendorLocation.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM vendor_location WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public VendorLocation getById(int id) {
			String sql = "SELECT * from vendor_location where id = ? ";
			List<VendorLocation> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(VendorLocation.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
