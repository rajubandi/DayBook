
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

import com.aurospaces.neighbourhood.db.model.Regions;


public class BaseRegionsDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO regions( created_time, updated_time, name) values (?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Regions regions) 
	{
	if(regions.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(regions.getCreatedTime() == null)
					{
					regions.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(regions.getCreatedTime().getTime()); 
							
					if(regions.getUpdatedTime() == null)
					{
					regions.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(regions.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, regions.getName());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				regions.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE regions  set name = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{regions.getName(),regions.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM regions WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Regions getById(int id) {
			String sql = "SELECT * from regions where id = ? ";
			List<Regions> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Regions.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
