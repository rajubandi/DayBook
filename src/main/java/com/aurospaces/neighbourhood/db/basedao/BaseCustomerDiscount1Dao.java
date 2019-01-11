
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

import com.aurospaces.neighbourhood.db.model.CustomerDiscount1;


public class BaseCustomerDiscount1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO customer_discount1( created_time, updated_time, old_customer_id, customer_id, register_date, used_date, discount, generated_order_id, order_id, mobile_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final CustomerDiscount1 customerDiscount1) 
	{
	if(customerDiscount1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(customerDiscount1.getCreatedTime() == null)
					{
					customerDiscount1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(customerDiscount1.getCreatedTime().getTime()); 
							
					if(customerDiscount1.getUpdatedTime() == null)
					{
					customerDiscount1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(customerDiscount1.getUpdatedTime().getTime()); 
							
					if(customerDiscount1.getRegisterDate() == null)
					{
					customerDiscount1.setRegisterDate( new Date());
					}
					java.sql.Timestamp registerDate = 
						new java.sql.Timestamp(customerDiscount1.getRegisterDate().getTime()); 
							
					if(customerDiscount1.getUsedDate() == null)
					{
					customerDiscount1.setUsedDate( new Date());
					}
					java.sql.Timestamp usedDate = 
						new java.sql.Timestamp(customerDiscount1.getUsedDate().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, customerDiscount1.getOldCustomerId());
ps.setInt(4, customerDiscount1.getCustomerId());
ps.setTimestamp(5, registerDate);
ps.setTimestamp(6, usedDate);
ps.setBigDecimal(7, customerDiscount1.getDiscount());
ps.setString(8, customerDiscount1.getGeneratedOrderId());
ps.setInt(9, customerDiscount1.getOrderId());
ps.setString(10, customerDiscount1.getMobileNumber());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				customerDiscount1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE customer_discount1  set updated_time = ? ,old_customer_id = ? ,customer_id = ? ,register_date = ? ,used_date = ? ,discount = ? ,generated_order_id = ? ,order_id = ? ,mobile_number = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{customerDiscount1.getUpdatedTime(),customerDiscount1.getOldCustomerId(),customerDiscount1.getCustomerId(),customerDiscount1.getRegisterDate(),customerDiscount1.getUsedDate(),customerDiscount1.getDiscount(),customerDiscount1.getGeneratedOrderId(),customerDiscount1.getOrderId(),customerDiscount1.getMobileNumber(),customerDiscount1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM customer_discount1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public CustomerDiscount1 getById(int id) {
			String sql = "SELECT * from customer_discount1 where id = ? ";
			List<CustomerDiscount1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(CustomerDiscount1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
