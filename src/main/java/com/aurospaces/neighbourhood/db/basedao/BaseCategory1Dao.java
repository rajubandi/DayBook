
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

import com.aurospaces.neighbourhood.db.model.Category1;


public class BaseCategory1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO category1( created_time, updated_time, old_id, name, description, active, img_url) values (?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Category1 category1) 
	{
	if(category1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(category1.getCreatedTime() == null)
					{
					category1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(category1.getCreatedTime().getTime()); 
							
					if(category1.getUpdatedTime() == null)
					{
					category1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(category1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, category1.getOldId());
ps.setString(4, category1.getName());
ps.setString(5, category1.getDescription());
ps.setInt(6, category1.getActive());
ps.setString(7, category1.getImgUrl());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				category1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE category1  set updated_time = ? ,old_id = ? ,name = ? ,description = ? ,active = ? ,img_url = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{category1.getUpdatedTime(),category1.getOldId(),category1.getName(),category1.getDescription(),category1.getActive(),category1.getImgUrl(),category1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM category1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Category1 getById(int id) {
			String sql = "SELECT * from category1 where id = ? ";
			List<Category1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Category1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
