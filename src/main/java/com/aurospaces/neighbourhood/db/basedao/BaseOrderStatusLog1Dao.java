
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

import com.aurospaces.neighbourhood.db.model.OrderStatusLog1;


public class BaseOrderStatusLog1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO order_status_log1( created_time, updated_time, order_id, status_id, vendor_id) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final OrderStatusLog1 orderStatusLog1) 
	{
	if(orderStatusLog1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(orderStatusLog1.getCreatedTime() == null)
					{
					orderStatusLog1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(orderStatusLog1.getCreatedTime().getTime()); 
							
					if(orderStatusLog1.getUpdatedTime() == null)
					{
					orderStatusLog1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(orderStatusLog1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, orderStatusLog1.getOrderId());
ps.setInt(4, orderStatusLog1.getStatusId());
ps.setInt(5, orderStatusLog1.getVendorId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				orderStatusLog1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE order_status_log1  set order_id = ? ,status_id = ? ,vendor_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{orderStatusLog1.getOrderId(),orderStatusLog1.getStatusId(),orderStatusLog1.getVendorId(),orderStatusLog1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM order_status_log1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public OrderStatusLog1 getById(int id) {
			String sql = "SELECT * from order_status_log1 where id = ? ";
			List<OrderStatusLog1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderStatusLog1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
