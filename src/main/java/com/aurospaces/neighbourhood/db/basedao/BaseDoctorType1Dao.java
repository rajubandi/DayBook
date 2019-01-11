
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

import com.aurospaces.neighbourhood.db.model.DoctorType1;


public class BaseDoctorType1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO doctor_type1( old_id, created_time, updated_time, name, price, discount, active) values (?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final DoctorType1 doctorType1) 
	{
	if(doctorType1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(doctorType1.getCreatedTime() == null)
					{
					doctorType1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(doctorType1.getCreatedTime().getTime()); 
							
					if(doctorType1.getUpdatedTime() == null)
					{
					doctorType1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(doctorType1.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, doctorType1.getOldId());
ps.setTimestamp(2, createdTime);
ps.setTimestamp(3, updatedTime);
ps.setString(4, doctorType1.getName());
ps.setBigDecimal(5, doctorType1.getPrice());
ps.setBigDecimal(6, doctorType1.getDiscount());
ps.setInt(7, doctorType1.getActive());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				doctorType1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE doctor_type1  set old_id = ? ,updated_time = ? ,name = ? ,price = ? ,discount = ? ,active = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{doctorType1.getOldId(),doctorType1.getUpdatedTime(),doctorType1.getName(),doctorType1.getPrice(),doctorType1.getDiscount(),doctorType1.getActive(),doctorType1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM doctor_type1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public DoctorType1 getById(int id) {
			String sql = "SELECT * from doctor_type1 where id = ? ";
			List<DoctorType1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(DoctorType1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
