
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

import com.aurospaces.neighbourhood.db.model.AutoPriceMeater;
import com.aurospaces.neighbourhood.db.model.Category1;


public class BaseAutoPriceMeaterDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO auto_price_meater( created_time, updated_time, generated_id, start_time, end_time, message, vendor_id) values (?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final AutoPriceMeater autoPriceMeater) 
	{
	if(autoPriceMeater.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(autoPriceMeater.getCreatedTime() == null)
					{
					autoPriceMeater.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(autoPriceMeater.getCreatedTime().getTime()); 
							
					if(autoPriceMeater.getUpdatedTime() == null)
					{
					autoPriceMeater.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(autoPriceMeater.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, autoPriceMeater.getGeneratedId());
ps.setDouble(4, autoPriceMeater.getStartTime());
ps.setDouble(5, autoPriceMeater.getEndTime());
ps.setString(6, autoPriceMeater.getMessage());
ps.setInt(7, autoPriceMeater.getVendor_id());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				autoPriceMeater.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE auto_price_meater  set updated_time = ? ,generated_id = ? ,start_time = ? ,end_time = ? ,message = ? ,vendor_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{autoPriceMeater.getUpdatedTime(),autoPriceMeater.getGeneratedId(),autoPriceMeater.getStartTime(),autoPriceMeater.getEndTime(),autoPriceMeater.getMessage(),autoPriceMeater.getVendor_id(),autoPriceMeater.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM auto_price_meater WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public AutoPriceMeater getById(int id) {
			String sql = "SELECT * from auto_price_meater where id = ? ";
			List<AutoPriceMeater> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AutoPriceMeater.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
