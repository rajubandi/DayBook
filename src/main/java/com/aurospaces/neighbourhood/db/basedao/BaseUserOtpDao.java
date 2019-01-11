
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

import com.aurospaces.neighbourhood.db.model.UserOtp;


public class BaseUserOtpDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO user_otp( phone_no, otp, created_time, updated_time, status) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final UserOtp userOtp) 
	{
	if(userOtp.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(userOtp.getCreatedTime() == null)
					{
					userOtp.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(userOtp.getCreatedTime().getTime()); 
							
					if(userOtp.getUpdatedTime() == null)
					{
					userOtp.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(userOtp.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, userOtp.getPhoneNo());
ps.setString(2, userOtp.getOtp());
ps.setTimestamp(3, createdTime);
ps.setTimestamp(4, updatedTime);
ps.setString(5, userOtp.getStatus());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				userOtp.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE user_otp  set phone_no = ? ,otp = ? ,updated_time = ? ,status = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{userOtp.getPhoneNo(),userOtp.getOtp(),userOtp.getUpdatedTime(),userOtp.getStatus(),userOtp.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM user_otp WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public UserOtp getById(int id) {
			String sql = "SELECT * from user_otp where id = ? ";
			List<UserOtp> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(UserOtp.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
