
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

import com.aurospaces.neighbourhood.db.model.ClientOrderLog;


public class BaseClientOrderLogDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO client_order_log( created_time, updated_time, order_id, client_log, user_id) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ClientOrderLog clientOrderLog) 
	{
	if(clientOrderLog.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(clientOrderLog.getCreatedTime() == null)
					{
					clientOrderLog.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(clientOrderLog.getCreatedTime().getTime()); 
							
					if(clientOrderLog.getUpdatedTime() == null)
					{
					clientOrderLog.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(clientOrderLog.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, clientOrderLog.getOrderId());
ps.setString(4, clientOrderLog.getClientLog());
ps.setInt(5, clientOrderLog.getUserId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				clientOrderLog.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE client_order_log  set order_id = ? ,client_log = ? ,user_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{clientOrderLog.getOrderId(),clientOrderLog.getClientLog(),clientOrderLog.getUserId(),clientOrderLog.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM client_order_log WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ClientOrderLog getById(int id) {
			String sql = "SELECT * from client_order_log where id = ? ";
			List<ClientOrderLog> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ClientOrderLog.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
