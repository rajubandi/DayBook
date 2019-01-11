
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

import com.aurospaces.neighbourhood.db.model.Cluster1;


public class BaseCluster1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO cluster1( created_time, updated_time, latitude, longitude, weightage) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Cluster1 cluster1) 
	{
	if(cluster1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(cluster1.getCreatedTime() == null)
					{
					cluster1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(cluster1.getCreatedTime().getTime()); 
							
					if(cluster1.getUpdatedTime() == null)
					{
					cluster1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(cluster1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setDouble(3, cluster1.getLatitude());
ps.setDouble(4, cluster1.getLongitude());
ps.setDouble(5, cluster1.getWeightage());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				cluster1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE cluster1  set updated_time = ? ,latitude = ? ,longitude = ? ,weightage = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{cluster1.getUpdatedTime(),cluster1.getLatitude(),cluster1.getLongitude(),cluster1.getWeightage(),cluster1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM cluster1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Cluster1 getById(int id) {
			String sql = "SELECT * from cluster1 where id = ? ";
			List<Cluster1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Cluster1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
