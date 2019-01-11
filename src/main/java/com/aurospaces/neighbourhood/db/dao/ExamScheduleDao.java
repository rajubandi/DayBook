package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ExamPatternBean;
import com.aurospaces.neighbourhood.bean.ExamScheduleBean;
import com.aurospaces.neighbourhood.db.basedao.BaseExamScheduleDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value="examScheduleDao")
public class ExamScheduleDao extends BaseExamScheduleDao{
	
	@Autowired public JdbcTemplate jdbcTemplate;

	 
	


	public void removeOldRecordForUpdate(String randomnum) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM examschedule WHERE randomnum=?";
		jdbcTemplate.update(sql, new Object[]{randomnum});
		
	}




public List<ExamScheduleBean> getExamScheduleList(String examTypeId, String boardId, String classId,String sectionId, String mediumId,String academicYearId ) {
		
		StringBuffer objStringBuffer = new StringBuffer();
		objStringBuffer.append("select ep.id,b.name as boardName,ep.boardId as boardId,cl.name as className,ep.classId as classId,sec.name as section, " 
				+ " ep.section as  sectionId,m.name as medium,ep.medium as mediumId,et.examType as examType,ep.examTypeId as examTypeId, "
				+ " sub.name as subjectName,ep.subjectId as subjectId,ep.examDate,ep.fromTime,ep.toTime, ep.academicYearId, ay.name as academicYear, ep.randomnum as randomnum from "
				+ " examschedule ep , mediam m,sectiontable sec, classtable cl,boardname b,subject sub, exam_type et , academicyear ay where "
				+ " ep.boardId=b.id and ep.section=sec.id and ep.classId=cl.id and ep.medium=m.id and ep.examTypeId=et.id and ep.subjectId=sub.id and ep.academicYearId = ay.id  ");
		if (StringUtils.isNotBlank(examTypeId)) {
			objStringBuffer.append(" and ep.examTypeId=" + examTypeId);
		}
		if (StringUtils.isNotBlank(boardId)) {
			objStringBuffer.append(" and ep.boardId=" + boardId);
		}
		if (StringUtils.isNotBlank(classId)) {
			objStringBuffer.append(" and ep.classId=" + classId);
		}
		if (StringUtils.isNotBlank(sectionId)) {
			objStringBuffer.append(" and ep.section=" + sectionId);
			
		}
		if (StringUtils.isNotBlank(mediumId)) {
			objStringBuffer.append(" and ep.medium=" + mediumId);
		}
		if (StringUtils.isNotBlank(academicYearId)) {
			objStringBuffer.append(" and ep.academicYearId=" + academicYearId);
		}

		String sql = objStringBuffer.toString();
		System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(
				new String[] {"id", "boardName","boardId","classId","className","sectionId", "section","mediam","mediumId","examType","examTypeId",  
						"subjectName","subjectId","examDate","fromTime","toTime","academicYearId","academicYear","randomnum"});
		List<ExamScheduleBean> result = jdbcTemplate.query(sql, new Object[] { }, ParameterizedBeanPropertyRowMapper.newInstance(ExamScheduleBean.class));
		
		return result;
	}
	
	
	
}
