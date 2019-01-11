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

import com.aurospaces.neighbourhood.db.model.City1;


public class BaseCity1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO city1( created_time, updated_time, name, description) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final City1 city1) 
	{
	if(city1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(city1.getCreatedTime() == null)
					{
					city1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(city1.getCreatedTime().getTime()); 
							
					if(city1.getUpdatedTime() == null)
					{
					city1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(city1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, city1.getName());
ps.setString(4, city1.getDescription());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				city1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE city1  set updated_time = ? ,name = ? ,description = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{city1.getUpdatedTime(),city1.getName(),city1.getDescription(),city1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM city1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public City1 getById(int id) {
			String sql = "SELECT * from city1 where id = ? ";
			List<City1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(City1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
