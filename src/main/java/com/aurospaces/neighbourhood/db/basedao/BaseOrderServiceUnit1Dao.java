
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

import com.aurospaces.neighbourhood.db.model.OrderServiceUnit1;


public class BaseOrderServiceUnit1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO order_service_unit1( created_time, updated_time, service_unit_id, order_id) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final OrderServiceUnit1 orderServiceUnit1) 
	{
	if(orderServiceUnit1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(orderServiceUnit1.getCreatedTime() == null)
					{
					orderServiceUnit1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(orderServiceUnit1.getCreatedTime().getTime()); 
							
					if(orderServiceUnit1.getUpdatedTime() == null)
					{
					orderServiceUnit1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(orderServiceUnit1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, orderServiceUnit1.getServiceUnitId());
ps.setInt(4, orderServiceUnit1.getOrderId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				orderServiceUnit1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE order_service_unit1  set updated_time = ? ,service_unit_id = ? ,order_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{orderServiceUnit1.getUpdatedTime(),orderServiceUnit1.getServiceUnitId(),orderServiceUnit1.getOrderId(),orderServiceUnit1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM order_service_unit1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public OrderServiceUnit1 getById(int id) {
			String sql = "SELECT * from order_service_unit1 where id = ? ";
			List<OrderServiceUnit1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderServiceUnit1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
