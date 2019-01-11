
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

import com.aurospaces.neighbourhood.db.model.Partner;


public class BasePartnerDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO partner( mobile, email, password, salt, created_time, updated_time, name) values (?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Partner partner) 
	{
	if(partner.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(partner.getCreatedTime() == null)
					{
					partner.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(partner.getCreatedTime().getTime()); 
							
					if(partner.getUpdatedTime() == null)
					{
					partner.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(partner.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, partner.getMobile());
ps.setString(2, partner.getEmail());
ps.setString(3, partner.getPassword());
ps.setString(4, partner.getSalt());
ps.setTimestamp(5, createdTime);
ps.setTimestamp(6, updatedTime);
ps.setString(7, partner.getName());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				partner.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE partner  set mobile = ? ,email = ? ,password = ? ,salt = ? ,name = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{partner.getMobile(),partner.getEmail(),partner.getPassword(),partner.getSalt(),partner.getName(),partner.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM partner WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Partner getById(int id) {
			String sql = "SELECT * from partner where id = ? ";
			List<Partner> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Partner.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
