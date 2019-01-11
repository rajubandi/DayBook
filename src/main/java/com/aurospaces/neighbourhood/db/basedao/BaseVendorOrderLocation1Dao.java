
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

import com.aurospaces.neighbourhood.db.model.VendorOrderLocation1;


public class BaseVendorOrderLocation1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO vendor_order_location1( vendor_id, order_id, created_time, updated_time, latitude, longitude) values (?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final VendorOrderLocation1 vendorOrderLocation1) 
	{
	if(vendorOrderLocation1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(vendorOrderLocation1.getCreatedTime() == null)
					{
					vendorOrderLocation1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(vendorOrderLocation1.getCreatedTime().getTime()); 
							
					if(vendorOrderLocation1.getUpdatedTime() == null)
					{
					vendorOrderLocation1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(vendorOrderLocation1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setInt(1, vendorOrderLocation1.getVendorId());
ps.setInt(2, vendorOrderLocation1.getOrderId());
ps.setTimestamp(3, createdTime);
ps.setTimestamp(4, updatedTime);
ps.setDouble(5, vendorOrderLocation1.getLatitude());
ps.setDouble(6, vendorOrderLocation1.getLongitude());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				vendorOrderLocation1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE vendor_order_location1  set vendor_id = ? ,order_id = ? ,latitude = ? ,longitude = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{vendorOrderLocation1.getVendorId(),vendorOrderLocation1.getOrderId(),vendorOrderLocation1.getLatitude(),vendorOrderLocation1.getLongitude(),vendorOrderLocation1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM vendor_order_location1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public VendorOrderLocation1 getById(int id) {
			String sql = "SELECT * from vendor_order_location1 where id = ? ";
			List<VendorOrderLocation1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(VendorOrderLocation1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
