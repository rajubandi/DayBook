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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.ExamMarksBean;
import com.aurospaces.neighbourhood.bean.ExamScheduleBean;

public class BaseExamScheduleDao {
	
	
	
	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO examschedule( createdTime, updatedTime, boardId, classId, section, examtypeId, medium,subjectId,examDate,fromTime,toTime,academicYearId,randomnum) values ( ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)"; 


	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ExamScheduleBean examScheduleBean) 
	{
	if(examScheduleBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	
					if(examScheduleBean.getCreatedTime() == null)
					{
						examScheduleBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(examScheduleBean.getCreatedTime().getTime()); 
							
					if(examScheduleBean.getUpdatedTime() == null)
					{
						examScheduleBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(examScheduleBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
									ps.setTimestamp(1, createdTime);
									ps.setTimestamp(2, updatedTime);
									ps.setString(3, examScheduleBean.getBoardId());
									ps.setString(4, examScheduleBean.getClassId());
									ps.setString(5, examScheduleBean.getSectionId());
									ps.setString(6, examScheduleBean.getExamTypeId());
									ps.setString(7, examScheduleBean.getMedium());
									ps.setString(8, examScheduleBean.getSubjectId());
									ps.setString(9, examScheduleBean.getExamDate());
									ps.setString(10, examScheduleBean.getFromTime());
									ps.setString(11, examScheduleBean.getToTime());
									ps.setInt(12, examScheduleBean.getAcademicYearId());
									ps.setString(13, examScheduleBean.getRandomnum());
									

							return ps;
						}
				},	keyHolder);
				
				Number unId = keyHolder.getKey();
				examScheduleBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE examschedule  set updatedTime = ? ,boardId=?, classId=?, section=?, examtypeId=?,  medium=?,subjectId=?,examDate=?,fromTime=?,toTime=?,academicYearId=?,randomnum=?   where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{examScheduleBean.getUpdatedTime(),examScheduleBean.getBoardId(),examScheduleBean.getClassId(),examScheduleBean.getSectionId(),examScheduleBean.getExamTypeId()
					,examScheduleBean.getMedium(),examScheduleBean.getSubjectId(),examScheduleBean.getExamDate(),examScheduleBean.getFromTime(),examScheduleBean.getToTime(),examScheduleBean.getAcademicYearId(),examScheduleBean.getRandomnum(),examScheduleBean.getId()});
		}
	}
	
	

}
