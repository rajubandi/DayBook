
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

import com.aurospaces.neighbourhood.db.model.CouponCode;


public class BaseCouponCodeDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO coupon_code( base_code, display_text1, display_text2, created_time, updated_time, amount, number_times, total_count, expiry_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final CouponCode couponCode) 
	{
	if(couponCode.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(couponCode.getCreatedTime() == null)
					{
					couponCode.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(couponCode.getCreatedTime().getTime()); 
							
					if(couponCode.getUpdatedTime() == null)
					{
					couponCode.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(couponCode.getUpdatedTime().getTime()); 
							
					if(couponCode.getExpiryTime() == null)
					{
					couponCode.setExpiryTime( new Date());
					}
					java.sql.Timestamp expiryTime = 
						new java.sql.Timestamp(couponCode.getExpiryTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, couponCode.getBaseCode());
ps.setString(2, couponCode.getDisplayText1());
ps.setString(3, couponCode.getDisplayText2());
ps.setTimestamp(4, createdTime);
ps.setTimestamp(5, updatedTime);
ps.setDouble(6, couponCode.getAmount());
ps.setInt(7, couponCode.getNumberTimes());
ps.setInt(8, couponCode.getTotalCount());
ps.setTimestamp(9, expiryTime);

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				couponCode.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE coupon_code  set base_code = ? ,display_text1 = ? ,display_text2 = ? ,amount = ? ,number_times = ? ,total_count = ? ,expiry_time = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{couponCode.getBaseCode(),couponCode.getDisplayText1(),couponCode.getDisplayText2(),couponCode.getAmount(),couponCode.getNumberTimes(),couponCode.getTotalCount(),couponCode.getExpiryTime(),couponCode.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM coupon_code WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public CouponCode getById(int id) {
			String sql = "SELECT * from coupon_code where id = ? ";
			List<CouponCode> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(CouponCode.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
