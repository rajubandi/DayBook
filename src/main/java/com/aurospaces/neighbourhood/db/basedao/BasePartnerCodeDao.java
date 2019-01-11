
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

import com.aurospaces.neighbourhood.db.model.PartnerCode;


public class BasePartnerCodeDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO partner_code( coupon_code_id, partner_id, created_time, updated_time) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final PartnerCode partnerCode) 
	{
	if(partnerCode.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(partnerCode.getCreatedTime() == null)
					{
					partnerCode.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(partnerCode.getCreatedTime().getTime()); 
							
					if(partnerCode.getUpdatedTime() == null)
					{
					partnerCode.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(partnerCode.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setInt(1, partnerCode.getCouponCodeId());
ps.setInt(2, partnerCode.getPartnerId());
ps.setTimestamp(3, createdTime);
ps.setTimestamp(4, updatedTime);

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				partnerCode.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE partner_code  set coupon_code_id = ? ,partner_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{partnerCode.getCouponCodeId(),partnerCode.getPartnerId(),partnerCode.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM partner_code WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public PartnerCode getById(int id) {
			String sql = "SELECT * from partner_code where id = ? ";
			List<PartnerCode> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(PartnerCode.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
