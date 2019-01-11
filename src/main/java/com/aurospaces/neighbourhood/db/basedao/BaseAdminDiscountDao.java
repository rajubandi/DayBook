
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

import com.aurospaces.neighbourhood.db.model.AdminDiscount;


public class BaseAdminDiscountDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO admin_discount( created_time, updated_time, title, percentage, amount) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final AdminDiscount adminDiscount) 
	{
	if(adminDiscount.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(adminDiscount.getCreatedTime() == null)
					{
					adminDiscount.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(adminDiscount.getCreatedTime().getTime()); 
							
					if(adminDiscount.getUpdatedTime() == null)
					{
					adminDiscount.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(adminDiscount.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, adminDiscount.getTitle());
ps.setDouble(4, adminDiscount.getPercentage());
ps.setDouble(5, adminDiscount.getAmount());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				adminDiscount.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE admin_discount  set title = ? ,percentage = ? ,amount = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{adminDiscount.getTitle(),adminDiscount.getPercentage(),adminDiscount.getAmount(),adminDiscount.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM admin_discount WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public AdminDiscount getById(int id) {
			String sql = "SELECT * from admin_discount where id = ? ";
			List<AdminDiscount> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AdminDiscount.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
