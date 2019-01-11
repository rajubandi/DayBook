package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.bean.StudentMarksBean;
import com.aurospaces.neighbourhood.db.basedao.BaseStudentMarksDao;

@Repository(value = "StudentMarksDao")
public class StudentMarksDao extends BaseStudentMarksDao{
	
	
	public List<StudentMarksBean> getStudentsHighlevelMarks(String board,String clasId,String sectionId,String mediumId,String examTypeId,String studentId,String academicYearId) {
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select sm.id,sm.studentId,s.mobile as mobileNumber,s.fatherName, sm.examTypeId,sum(sm.studentMarks) as totalStudentMarks,sum(sm.subjectMaxMarks) as totalSubjectMarks ,et.examType as examTypeName ,s.name  as studentName , sm.academicYearId,ay.name as academicYear "
				+" from studentmarks sm, exam_type et,student s, academicyear ay  where sm.examTypeId = et.id and sm.studentId=s.id and  " 
				+ "sm.academicYearId = ay.id and  "
				 + "sm.academicYearId =? ");
		 
		 if (StringUtils.isNotBlank(board)) {
				objStringBuffer.append(" and sm.boardId=" + board);
			}
			if (StringUtils.isNotBlank(clasId)) {
				objStringBuffer.append(" and sm.classId=" + clasId);
			}
			if (StringUtils.isNotBlank(sectionId)) {
				objStringBuffer.append(" and sm.sectionId=" + sectionId);
			}
			if (StringUtils.isNotBlank(mediumId)) {
				objStringBuffer.append(" and sm.mediumId=" + mediumId);
			}
			if (StringUtils.isNotBlank(examTypeId)) {
				objStringBuffer.append(" and sm.examTypeId=" + examTypeId);
			}
			if (StringUtils.isNotBlank(studentId)) {
				objStringBuffer.append(" and sm.studentId=" + studentId);
			}
			
			objStringBuffer.append("  group by sm.studentId " );
			
			System.out.println(objStringBuffer.toString());
		List<StudentMarksBean> retlist = jdbcTemplate.query(objStringBuffer.toString(), new Object[]{academicYearId}, ParameterizedBeanPropertyRowMapper.newInstance(StudentMarksBean.class));
		if(retlist.size() > 0)
			return retlist;
		return null;
	}

	public List<StudentMarksBean> getPogressCard(String studetnId, String exampTypeId, Integer acadamicYearId) {
		
		/*String sql = "select sm.id,sm.studentId,sb.name as subjectTitle,sm.studentMarks,sm.subjectMaxMarks, sm.examTypeId,et.examType as examTypeName ,s.name  as studentName " + 
				" from studentmarks sm,exam_type et,student s ,subject sb  where sm.examTypeId = et.id and sm.studentId = s.id and sm.subjectId=sb.id and sm.studentId=? and sm.examTypeId=?";*/
		
		String sql = "	select sm.id,sm.studentId,sb.name as subjectTitle,sm.studentMarks,sm.subjectMaxMarks, sm.examTypeId,et.examType as examTypeName ,"
		+" s.name  as studentName,ct.name as className,m.name as medium,st.name as sectionName, b.name as boardName from studentmarks sm,exam_type et,student s ,boardname b,classtable ct,sectiontable st,mediam m,subject sb "  
		+" where sm.examTypeId = et.id and sm.studentId = s.id and s.className = ct.id and s.boardName = b.id and s.medium = m.id and s.section= st.id and sm.subjectId=sb.id and sm.studentId=? and sm.examTypeId=? and sm.academicYearId=? " ;
		
		List<StudentMarksBean> retlist = jdbcTemplate.query(sql, new Object[]{studetnId,exampTypeId,acadamicYearId},ParameterizedBeanPropertyRowMapper.newInstance(StudentMarksBean.class));
		if(retlist.size() > 0)
			return retlist;
		return null;
	}
	

	
}
