
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

import com.aurospaces.neighbourhood.db.model.PartnerSession;


public class BasePartnerSessionDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO partner_session( partner_id, created_time, updated_time) values (?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final PartnerSession partnerSession) 
	{
	if(partnerSession.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(partnerSession.getCreatedTime() == null)
					{
					partnerSession.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(partnerSession.getCreatedTime().getTime()); 
							
					if(partnerSession.getUpdatedTime() == null)
					{
					partnerSession.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(partnerSession.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setInt(1, partnerSession.getPartnerId());
ps.setTimestamp(2, createdTime);
ps.setTimestamp(3, updatedTime);

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				partnerSession.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE partner_session  set partner_id = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{partnerSession.getPartnerId(),partnerSession.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM partner_session WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public PartnerSession getById(int id) {
			String sql = "SELECT * from partner_session where id = ? ";
			List<PartnerSession> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(PartnerSession.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
