
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.ClassCreationBean;
import com.aurospaces.neighbourhood.bean.TimetableBean;


public class BaseTimetableDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO timetable( created_time, updated_time, filePath) values (?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final TimetableBean timetableBean) 
	{
	if(timetableBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(timetableBean.getCreatedTime() == null)
					{
					timetableBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(timetableBean.getCreatedTime().getTime()); 
							
					if(timetableBean.getUpdatedTime() == null)
					{
					timetableBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(timetableBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, timetableBean.getFilePath());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				timetableBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE timetable  set  filePath = ? where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{timetableBean.getFilePath(),timetableBean.getId()});
		}
	}
		
		

}
