package com.aurospaces.neighbourhood.db.dao;

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

@Repository(value="examMarksDao")
public class ExamMarksDao {
	
	
	
	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO exammarksmaster( created_time, updated_time, boardId, classId, subjectId, examtypeId, maxMarks) values ( ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ExamMarksBean examMarksBean) 
	{
	if(examMarksBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	
					if(examMarksBean.getCreatedTime() == null)
					{
						examMarksBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(examMarksBean.getCreatedTime().getTime()); 
							
					if(examMarksBean.getUpdatedTime() == null)
					{
						examMarksBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(examMarksBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
									ps.setTimestamp(1, createdTime);
									ps.setTimestamp(2, updatedTime);
									ps.setString(3, examMarksBean.getBoardId());
									ps.setString(4, examMarksBean.getClassId());
									ps.setString(5, examMarksBean.getSubjectId());
									ps.setString(6, examMarksBean.getExamtypeId());
									ps.setString(7, examMarksBean.getMaxMarks());

							return ps;
						}
				},	keyHolder);
				
				Number unId = keyHolder.getKey();
				examMarksBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE mediam  set updated_time = ? ,boardId=?, classId=?, subjectId=?, examtypeId=?, maxMarks=?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{examMarksBean.getUpdatedTime(),examMarksBean.getBoardId(),examMarksBean.getClassId(),examMarksBean.getSubjectId(),examMarksBean.getExamtypeId()
					,examMarksBean.getMaxMarks(),examMarksBean.getId()});
		}
	}
	
	

}
