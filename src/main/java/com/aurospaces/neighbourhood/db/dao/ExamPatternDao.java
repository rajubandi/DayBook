package com.aurospaces.neighbourhood.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ExamPatternBean;
import com.aurospaces.neighbourhood.bean.StudentFeeBean;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value="examPatternDao")
public class ExamPatternDao {
	
	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO exampattern( createdTime, updatedTime, boardId, classId, subjectId, examtypeId,sectionId, maxMarks,mediumId,randomnum) values ( ?, ?, ?, ?, ?, ?, ?,?,?,?)"; 


	public void save( final ExamPatternBean examPatternBean) {
		// TODO Auto-generated method stub
		if(examPatternBean.getId() == 0)	{

			KeyHolder keyHolder = new GeneratedKeyHolder();
			int update = jdbcTemplate.update(
					new PreparedStatementCreator() {
							public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			
							if(examPatternBean.getCreatedTime() == null)
							{
								examPatternBean.setCreatedTime( new Date());
							}
							java.sql.Timestamp createdTime = 
								new java.sql.Timestamp(examPatternBean.getCreatedTime().getTime()); 
									
							if(examPatternBean.getUpdatedTime() == null)
							{
								examPatternBean.setUpdatedTime( new Date());
							}
							java.sql.Timestamp updatedTime = 
								new java.sql.Timestamp(examPatternBean.getUpdatedTime().getTime()); 
									
							PreparedStatement ps =
											connection.prepareStatement(INSERT_SQL,new String[]{"id"});
											ps.setTimestamp(1, createdTime);
											ps.setTimestamp(2, updatedTime);
											ps.setString(3, examPatternBean.getBoardId());
											ps.setString(4, examPatternBean.getClassId());
											ps.setString(5, examPatternBean.getSubjectId());
											ps.setString(6, examPatternBean.getExamTypeId());
											ps.setString(7, examPatternBean.getSectionId());
											ps.setString(8, examPatternBean.getMaxMarks());
											ps.setString(9, examPatternBean.getMedium());
											ps.setString(10, examPatternBean.getRandomnum());

									return ps;
								}
						},	keyHolder);
						
						Number unId = keyHolder.getKey();
						//examPatternBean.setId(unId.intValue());
						

				}
				else
				{

					String sql = "UPDATE exampattern  set updatedTime = ? ,boardId=?, classId=?, subjectId=?, examtypeId=?,sectionId=?, maxMarks=?, mediumId=?  where id = ? and randomnum=? ";
			
					jdbcTemplate.update(sql, new Object[]{examPatternBean.getUpdatedTime(),examPatternBean.getBoardId(),examPatternBean.getClassId(),examPatternBean.getSubjectId(),examPatternBean.getExamTypeId()
							,examPatternBean.getMaxMarks(),examPatternBean.getId(),examPatternBean.getSectionId(),examPatternBean.getMedium()});
					examPatternBean.setId(0);
				}
		
		
	}


	public List<ExamPatternBean> getExamPatternList(String boardId, String classId,String sectionId, String mediamId, String examtypeId) {
		
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer
					.append("select ep.id,b.name as boardName,ep.boardId as boardId,cl.name as className,ep.classId as classId,sec.name as sectionName," 
							 +"ep.sectionId as  sectionId,m.name as mediam,ep.mediumId as mediumId,et.examType as examType,ep.examTypeId as examTypeId,"
							 + "sub.name as subjectName,ep.subjectId as subjectId,ep.maxMarks as maxMarks,ep.randomnum as randomnum from " 
							 + "exampattern ep , mediam m,sectiontable sec, classtable cl,boardname b,subject sub, exam_type et"
							 + " where ep.boardId=b.id and ep.sectionId=sec.id and ep.classId=cl.id and ep.mediumId=m.id and ep.examTypeId=et.id and ep.subjectId=sub.id and ep.examTypeId=? ");
			
			/*if (StringUtils.isNotBlank(boardId)) {
				objStringBuffer.append(" and bn.id=" + boardId);
			}
			if (StringUtils.isNotBlank(classId)) {
				objStringBuffer.append(" and ct.id=" + classId);
			}
			if (StringUtils.isNotBlank(sectionId)) {
				objStringBuffer.append(" and st.id=" + sectionId);
			}
			if (StringUtils.isNotBlank(mediamId)) {
				objStringBuffer.append(" and m.id=" + mediamId);
			}
			if (StringUtils.isNotBlank(examtypeId)) {
				objStringBuffer.append(" and m.id=" + examtypeId);
			}
*/
			String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(
					new String[] {"id", "boardName","boardId","classId","className","sectionId", "sectionName","mediam","mediumId","examType","examTypeId",  
							"subjectName","subjectId","maxMarks","randomnum"});
			List<ExamPatternBean> result = jdbcTemplate.query(sql, new Object[] { examtypeId },
					ParameterizedBeanPropertyRowMapper.newInstance(ExamPatternBean.class));
			//= handler.getResult();
			
			return result;
		
		
		
	}


	public void removeOldRecordForUpdate(String randomnum) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM exampattern WHERE randomnum=?";
		jdbcTemplate.update(sql, new Object[]{randomnum});
		
	}
	
	
}
