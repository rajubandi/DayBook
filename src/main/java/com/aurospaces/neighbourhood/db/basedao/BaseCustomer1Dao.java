
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.db.model.Customer1;


public class BaseCustomer1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO customer1( created_time, updated_time, name, mobile_number, email, address1, city, pincode, state, password, old_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Customer1 customer1) 
	{
	if(customer1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(customer1.getCreatedTime() == null)
					{
					customer1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(customer1.getCreatedTime().getTime()); 
							
					if(customer1.getUpdatedTime() == null)
					{
					customer1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(customer1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, customer1.getName());
ps.setString(4, customer1.getMobileNumber());
ps.setString(5, customer1.getEmail());
ps.setString(6, customer1.getAddress1());
ps.setString(7, customer1.getCity());
ps.setString(8, customer1.getPincode());
ps.setString(9, customer1.getState());
ps.setString(10, customer1.getPassword());
ps.setString(11, customer1.getOldId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				customer1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE customer1  set updated_time = ? ,name = ? ,mobile_number = ? ,email = ? ,address1 = ? ,city = ? ,pincode = ? ,state = ? ,password = ? ,old_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{customer1.getUpdatedTime(),customer1.getName(),customer1.getMobileNumber(),customer1.getEmail(),customer1.getAddress1(),customer1.getCity(),customer1.getPincode(),customer1.getState(),customer1.getPassword(),customer1.getOldId(),customer1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM customer1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Customer1 getById(int id) {
			String sql = "SELECT * from customer1 where id = ? ";
			List<Customer1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Customer1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
