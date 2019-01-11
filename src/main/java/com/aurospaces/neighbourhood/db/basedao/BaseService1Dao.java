
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

import com.aurospaces.neighbourhood.db.model.Service1;


public class BaseService1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO service1( created_time, updated_time, name, description, parent_category, old_id, page_name, display_text, img_url, display_order, is_bold, is_dummy, active, popup_message, keywords) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final Service1 service1) 
	{
	if(service1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(service1.getCreatedTime() == null)
					{
					service1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(service1.getCreatedTime().getTime()); 
							
					if(service1.getUpdatedTime() == null)
					{
					service1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(service1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, service1.getName());
ps.setString(4, service1.getDescription());
ps.setString(5, service1.getParentCategory());
ps.setString(6, service1.getOldId());
ps.setString(7, service1.getPageName());
ps.setString(8, service1.getDisplayText());
ps.setString(9, service1.getImgUrl());
ps.setInt(10, service1.getDisplayOrder());
ps.setInt(11, service1.getIsBold());
ps.setInt(12, service1.getIsDummy());
ps.setInt(13, service1.getActive());
ps.setString(14, service1.getPopupMessage());
ps.setString(15, service1.getKeywords());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				service1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE service1  set name = ? ,description = ? ,parent_category = ? ,old_id = ? ,page_name = ? ,display_text = ? ,img_url = ? ,display_order = ? ,is_bold = ? ,is_dummy = ? ,active = ? ,popup_message = ? ,keywords = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{service1.getName(),service1.getDescription(),service1.getParentCategory(),service1.getOldId(),service1.getPageName(),service1.getDisplayText(),service1.getImgUrl(),service1.getDisplayOrder(),service1.getIsBold(),service1.getIsDummy(),service1.getActive(),service1.getPopupMessage(),service1.getKeywords(),service1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM service1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public Service1 getById(int id) {
			String sql = "SELECT * from service1 where id = ? ";
			List<Service1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(Service1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
