
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

import com.aurospaces.neighbourhood.db.model.OrderHappiness;


public class BaseOrderHappinessDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO order_happiness( created_time, updated_time, order_id, service_unit_id, happiness, time_to_serve, feedback) values (?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final OrderHappiness orderHappiness) 
	{
	if(orderHappiness.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(orderHappiness.getCreatedTime() == null)
					{
					orderHappiness.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(orderHappiness.getCreatedTime().getTime()); 
							
					if(orderHappiness.getUpdatedTime() == null)
					{
					orderHappiness.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(orderHappiness.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, orderHappiness.getOrderId());
ps.setInt(4, orderHappiness.getServiceUnitId());
ps.setInt(5, orderHappiness.getHappiness());
ps.setInt(6, orderHappiness.getTimeToServe());
ps.setString(7, orderHappiness.getFeedback());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				orderHappiness.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE order_happiness  set order_id = ? ,service_unit_id = ? ,happiness = ? ,time_to_serve = ? ,feedback = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{orderHappiness.getOrderId(),orderHappiness.getServiceUnitId(),orderHappiness.getHappiness(),orderHappiness.getTimeToServe(),orderHappiness.getFeedback(),orderHappiness.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM order_happiness WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public OrderHappiness getById(int id) {
			String sql = "SELECT * from order_happiness where id = ? ";
			List<OrderHappiness> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderHappiness.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
