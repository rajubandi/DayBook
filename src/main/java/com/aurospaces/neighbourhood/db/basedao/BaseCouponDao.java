
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

import com.aurospaces.neighbourhood.db.model.Coupon;


public class BaseCouponDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO coupon( coupon_code_id, code, vendor_code, created_time, updated_time, redeemed_date, sent_date, redeemed, sent, redeemed_by) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Coupon coupon) 
	{
	if(coupon.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(coupon.getCreatedTime() == null)
					{
					coupon.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(coupon.getCreatedTime().getTime()); 
							
					if(coupon.getUpdatedTime() == null)
					{
					coupon.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(coupon.getUpdatedTime().getTime()); 
							
					if(coupon.getRedeemedDate() == null)
					{
					coupon.setRedeemedDate( new Date());
					}
					java.sql.Timestamp redeemedDate = 
						new java.sql.Timestamp(coupon.getRedeemedDate().getTime()); 
							
					if(coupon.getSentDate() == null)
					{
					coupon.setSentDate( new Date());
					}
					java.sql.Timestamp sentDate = 
						new java.sql.Timestamp(coupon.getSentDate().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setInt(1, coupon.getCouponCodeId());
ps.setString(2, coupon.getCode());
ps.setString(3, coupon.getVendorCode());
ps.setTimestamp(4, createdTime);
ps.setTimestamp(5, updatedTime);
ps.setTimestamp(6, redeemedDate);
ps.setTimestamp(7, sentDate);
ps.setInt(8, coupon.getRedeemed());
ps.setInt(9, coupon.getSent());
ps.setInt(10, coupon.getRedeemedBy());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				coupon.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE coupon  set coupon_code_id = ? ,code = ? ,vendor_code = ? ,redeemed_date = ? ,sent_date = ? ,redeemed = ? ,sent = ? ,redeemed_by = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{coupon.getCouponCodeId(),coupon.getCode(),coupon.getVendorCode(),coupon.getRedeemedDate(),coupon.getSentDate(),coupon.getRedeemed(),coupon.getSent(),coupon.getRedeemedBy(),coupon.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM coupon WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Coupon getById(int id) {
			String sql = "SELECT * from coupon where id = ? ";
			List<Coupon> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Coupon.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
