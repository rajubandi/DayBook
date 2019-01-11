
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

import com.aurospaces.neighbourhood.db.model.Location1;


public class BaseLocation1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO location1( created_time, updated_time, name, description, old_id, display_order, parent_city, is_dummy, is_bold, active, is_default, latitude, longitude) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Location1 location1) 
	{
	if(location1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(location1.getCreatedTime() == null)
					{
					location1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(location1.getCreatedTime().getTime()); 
							
					if(location1.getUpdatedTime() == null)
					{
					location1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(location1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, location1.getName());
ps.setString(4, location1.getDescription());
ps.setString(5, location1.getOldId());
ps.setInt(6, location1.getDisplayOrder());
ps.setInt(7, location1.getParentCity());
ps.setInt(8, location1.getIsDummy());
ps.setInt(9, location1.getIsBold());
ps.setInt(10, location1.getActive());
ps.setInt(11, location1.getIsDefault());
ps.setDouble(12, location1.getLatitude());
ps.setDouble(13, location1.getLongitude());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				location1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE location1  set name = ? ,description = ? ,old_id = ? ,display_order = ? ,parent_city = ? ,is_dummy = ? ,is_bold = ? ,active = ? ,is_default = ? ,latitude = ? ,longitude = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{location1.getName(),location1.getDescription(),location1.getOldId(),location1.getDisplayOrder(),location1.getParentCity(),location1.getIsDummy(),location1.getIsBold(),location1.getActive(),location1.getIsDefault(),location1.getLatitude(),location1.getLongitude(),location1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM location1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Location1 getById(int id) {
			String sql = "SELECT * from location1 where id = ? ";
			List<Location1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Location1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
