
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

import com.aurospaces.neighbourhood.db.model.VendorDetail1;


public class BaseVendorDetail1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO vendor_detail1( created_time, updated_time, name, price) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final VendorDetail1 vendorDetail1) 
	{
	if(vendorDetail1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(vendorDetail1.getCreatedTime() == null)
					{
					vendorDetail1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(vendorDetail1.getCreatedTime().getTime()); 
							
					if(vendorDetail1.getUpdatedTime() == null)
					{
					vendorDetail1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(vendorDetail1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, vendorDetail1.getName());
ps.setBigDecimal(4, vendorDetail1.getPrice());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				vendorDetail1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE vendor_detail1  set updated_time = ? ,name = ? ,price = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{vendorDetail1.getUpdatedTime(),vendorDetail1.getName(),vendorDetail1.getPrice(),vendorDetail1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM vendor_detail1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public VendorDetail1 getById(int id) {
			String sql = "SELECT * from vendor_detail1 where id = ? ";
			List<VendorDetail1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(VendorDetail1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
