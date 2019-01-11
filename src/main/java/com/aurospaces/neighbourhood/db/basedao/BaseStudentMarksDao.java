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

import com.aurospaces.neighbourhood.bean.StudentMarksBean;

public class BaseStudentMarksDao {
	@Autowired public JdbcTemplate jdbcTemplate;
	

	 
	public final String INSERT_SQL = "INSERT INTO studentmarks( createdTime, updatedTime, examTypeId, subjectId, studentMarks, subjectMaxMarks,studentId,classId,academicYearId,boardId, sectionId, mediumId ) values (?, ?, ?, ?, ?,?, ?,?,?,?,?,?)";
 
	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public boolean save(final StudentMarksBean studentMarksBean) 
	{
		boolean insert = false;
		try{
	if(studentMarksBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(studentMarksBean.getCreatedTime() == null)
					{
					studentMarksBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(studentMarksBean.getCreatedTime().getTime()); 
										
					if(studentMarksBean.getUpdatedTime() == null)
					{
					studentMarksBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(studentMarksBean.getUpdatedTime().getTime()); 
					
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, studentMarksBean.getExamTypeId());
ps.setString(4, studentMarksBean.getSubjectId());
ps.setString(5, studentMarksBean.getStudentMarks());
ps.setString(6, studentMarksBean.getSubjectMaxMarks());
ps.setString(7, studentMarksBean.getStudentId());
ps.setString(8,studentMarksBean.getClassId() );
ps.setInt(9,studentMarksBean.getAcademicYearId() );
ps.setString(10,studentMarksBean.getBoardId() );
ps.setString(11,studentMarksBean.getSectionId() );
ps.setString(12,studentMarksBean.getMedium() );


System.out.println(ps);
							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				studentMarksBean.setId(unId.intValue());
				

		}
		else
		{
		 
			String sql = "UPDATE studentmarks  set updatedTime =?, examTypeId =?, subjectId =?, studentMarks=?, subjectMaxMarks=?,studentId=?,classId=?,academicYearId=?,boardId=?,sectionId=?, mediumId=? where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{studentMarksBean.getExamTypeId(),studentMarksBean.getStudentId(),studentMarksBean.getStudentMarks(),studentMarksBean.getSubjectId(),studentMarksBean.getSubjectMaxMarks(),
					studentMarksBean.getCreatedTime(),studentMarksBean.getUpdatedTime(),studentMarksBean.getClassId(),studentMarksBean.getAcademicYearId(),studentMarksBean.getBoardId(),studentMarksBean.getSectionId(),studentMarksBean.getMedium(),studentMarksBean.getId()});
		}
	insert= true;
		}catch(Exception e){
			System.out.println(e);
			insert= false;
		}
	return insert;
	}
}
