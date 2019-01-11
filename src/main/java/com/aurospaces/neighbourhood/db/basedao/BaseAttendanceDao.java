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

import com.aurospaces.neighbourhood.bean.AttendanceBean;


public class BaseAttendanceDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO attendance( created_time, updated_time, studentId, absentSection, senderId,message,notificationId) values (?, ?, ?, ?, ?,?,?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final AttendanceBean objAttendanceBean) 
	{
	if(objAttendanceBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(objAttendanceBean.getCreatedTime() == null)
					{
					objAttendanceBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(objAttendanceBean.getCreatedTime().getTime()); 
							
					if(objAttendanceBean.getUpdatedTime() == null)
					{
					objAttendanceBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(objAttendanceBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, objAttendanceBean.getStudentId());
ps.setString(4, objAttendanceBean.getAbsentSection());
ps.setString(5, objAttendanceBean.getSenderId());
ps.setString(6, objAttendanceBean.getMessage());
ps.setString(7, objAttendanceBean.getNotificationId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				objAttendanceBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE attendance  set studentId = ? ,absentSection = ? ,senderId = ?  ,senderId = ? ,message = ? ,notificationId = ? where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{objAttendanceBean.getStudentId(),objAttendanceBean.getAbsentSection(),objAttendanceBean.getSenderId(),objAttendanceBean.getMessage(),objAttendanceBean.getNotificationId(),objAttendanceBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM attendance WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	/* public AdminDiscount getById(int id) {
			String sql = "SELECT * from classcreation where id = ? ";
			List<AdminDiscount> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AdminDiscount.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
*/
	

}
