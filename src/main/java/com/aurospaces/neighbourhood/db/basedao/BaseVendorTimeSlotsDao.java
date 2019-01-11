
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

import com.aurospaces.neighbourhood.db.model.VendorTimeSlots;


public class BaseVendorTimeSlotsDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO vendor_time_slots1( created_time, updated_time, time_slot_id, vendor_id) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final VendorTimeSlots vendorTimeSlots) 
	{
	if(vendorTimeSlots.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(vendorTimeSlots.getCreatedTime() == null)
					{
					vendorTimeSlots.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(vendorTimeSlots.getCreatedTime().getTime()); 
							
					if(vendorTimeSlots.getUpdatedTime() == null)
					{
					vendorTimeSlots.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(vendorTimeSlots.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, vendorTimeSlots.getTimeSlotId());
ps.setInt(4, vendorTimeSlots.getVendorId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				vendorTimeSlots.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE vendor_time_slots1  set updated_time = ? ,time_slot_id = ? ,vendor_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{vendorTimeSlots.getUpdatedTime(),vendorTimeSlots.getTimeSlotId(),vendorTimeSlots.getVendorId(),vendorTimeSlots.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM vendor_time_slots1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public VendorTimeSlots getById(int id) {
			String sql = "SELECT * from vendor_time_slots1 where id = ? ";
			List<VendorTimeSlots> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(VendorTimeSlots.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
