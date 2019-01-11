
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

import com.aurospaces.neighbourhood.db.model.OrderSymptom1;


public class BaseOrderSymptom1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO order_symptom1( created_time, updated_time, order_id, generated_order_id, old_symptom_id, symptom_id) values (?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final OrderSymptom1 orderSymptom1) 
	{
	if(orderSymptom1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(orderSymptom1.getCreatedTime() == null)
					{
					orderSymptom1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(orderSymptom1.getCreatedTime().getTime()); 
							
					if(orderSymptom1.getUpdatedTime() == null)
					{
					orderSymptom1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(orderSymptom1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, orderSymptom1.getOrderId());
ps.setString(4, orderSymptom1.getGeneratedOrderId());
ps.setString(5, orderSymptom1.getOldSymptomId());
ps.setInt(6, orderSymptom1.getSymptomId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				orderSymptom1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE order_symptom1  set updated_time = ? ,order_id = ? ,generated_order_id = ? ,old_symptom_id = ? ,symptom_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{orderSymptom1.getUpdatedTime(),orderSymptom1.getOrderId(),orderSymptom1.getGeneratedOrderId(),orderSymptom1.getOldSymptomId(),orderSymptom1.getSymptomId(),orderSymptom1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM order_symptom1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public OrderSymptom1 getById(int id) {
			String sql = "SELECT * from order_symptom1 where id = ? ";
			List<OrderSymptom1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderSymptom1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
