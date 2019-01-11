
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

import com.aurospaces.neighbourhood.db.model.Coupon1;


public class BaseCoupon1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO coupon1( code, percentage, price, service_id) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Coupon1 coupon1) 
	{
	if(coupon1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, coupon1.getCode());
ps.setString(2, coupon1.getPercentage());
ps.setDouble(3, coupon1.getPrice());
ps.setInt(4, coupon1.getServiceId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				coupon1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE coupon1  set code = ? ,percentage = ? ,price = ? ,service_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{coupon1.getCode(),coupon1.getPercentage(),coupon1.getPrice(),coupon1.getServiceId(),coupon1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM coupon1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Coupon1 getById(int id) {
			String sql = "SELECT * from coupon1 where id = ? ";
			List<Coupon1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Coupon1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
