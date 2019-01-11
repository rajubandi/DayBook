package com.aurospaces.neighbourhood.db.basedao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.FacultyBean;
import com.aurospaces.neighbourhood.db.model.AdminDiscount;


public class BaseFacultyDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO faculty( created_time, updated_time, name, gender, qualifaction,contactNumber) values (?, ?, ?, ?, ?,?)";
 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final FacultyBean facultyBean) 
	{
	if(facultyBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(facultyBean.getCreatedTime() == null)
					{
					facultyBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(facultyBean.getCreatedTime().getTime()); 
							
					if(facultyBean.getUpdatedTime() == null)
					{
					facultyBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(facultyBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, facultyBean.getName());
ps.setString(4, facultyBean.getGender());
ps.setString(5, facultyBean.getQualification());
ps.setString(6, facultyBean.getContactNumber());
System.out.println(ps);
							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				facultyBean.setId(unId.intValue());
				

		}
		else
		{
		 
			String sql = "UPDATE faculty  set name = ? ,gender = ?  ,qualifaction = ? ,contactNumber = ?  "
					+ " where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{facultyBean.getName(),facultyBean.getGender(),facultyBean.getQualification(),facultyBean.getContactNumber(),facultyBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM faculty WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public AdminDiscount getById(int id) {
			String sql = "SELECT * from faculty where id = ? ";
			List<AdminDiscount> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AdminDiscount.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
