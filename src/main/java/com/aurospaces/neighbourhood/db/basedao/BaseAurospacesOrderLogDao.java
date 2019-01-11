
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

import com.aurospaces.neighbourhood.db.model.AurospacesOrderLog;


public class BaseAurospacesOrderLogDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO aurospaces_order_log( created_time, updated_time, order_id, aurospaces_log, user_id) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final AurospacesOrderLog aurospacesOrderLog) 
	{
	if(aurospacesOrderLog.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(aurospacesOrderLog.getCreatedTime() == null)
					{
					aurospacesOrderLog.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(aurospacesOrderLog.getCreatedTime().getTime()); 
							
					if(aurospacesOrderLog.getUpdatedTime() == null)
					{
					aurospacesOrderLog.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(aurospacesOrderLog.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, aurospacesOrderLog.getOrderId());
ps.setString(4, aurospacesOrderLog.getAurospacesLog());
ps.setInt(5, aurospacesOrderLog.getUserId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				aurospacesOrderLog.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE aurospaces_order_log  set order_id = ? ,aurospaces_log = ? ,user_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{aurospacesOrderLog.getOrderId(),aurospacesOrderLog.getAurospacesLog(),aurospacesOrderLog.getUserId(),aurospacesOrderLog.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM aurospaces_order_log WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public AurospacesOrderLog getById(int id) {
			String sql = "SELECT * from aurospaces_order_log where id = ? ";
			List<AurospacesOrderLog> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AurospacesOrderLog.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
