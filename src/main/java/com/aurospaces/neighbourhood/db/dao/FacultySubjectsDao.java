package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.FacultySubjectsBean;
import com.aurospaces.neighbourhood.db.basedao.BaseFacultySubjects;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "FacultySubjectsDao")
public class FacultySubjectsDao  extends BaseFacultySubjects{
	
	 public List<Map<String, String>> getallFacultySubjects(String boardName,String medium,String className,String section){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select fs.id, f.name as facultyName,b.name boardName,m.name mediumName,ct.name as className,st.name as sectionName,su.name as subjectName,"
		 		+" f.id as facultyId,b.id as boardId,m.id as mediumId,ct.id as classId,st.id as sectionId,su.id as subjectId "
				 + " from faculty f,facultysubjects fs,boardname b, "+
								" classtable ct,mediam m,sectiontable st,subject su where f.id=fs.facultyId and fs.boardId=b.id and fs.mediumId=m.id and "+
								" fs.classId=ct.id and fs.sectionId=st.id and su.id =fs.subjectId  ");
	
String sql = objStringBuffer.toString();
			//System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] {"id", "facultyName","boardName","mediumName","className","sectionName","subjectName",
					"facultyId","boardId","mediumId","classId","sectionId","subjectId"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	 @Transactional
		public void deleteFacultySubject(int id) {
			String sql = "DELETE FROM facultysubjects WHERE facultyId=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		
	 public FacultySubjectsBean facultySubjectExistOrNot(FacultySubjectsBean facultySubjectsBean) {
			String sql = "SELECT * from facultysubjects where facultyId = ? and boardId = ? and mediumId = ? and classId = ? and sectionId = ? and subjectId = ? ";
			List<FacultySubjectsBean> retlist = jdbcTemplate.query(sql,
			new Object[]{facultySubjectsBean.getFacultyId(),facultySubjectsBean.getBoardName(),facultySubjectsBean.getMedium(),facultySubjectsBean.getClassName(),facultySubjectsBean.getSection(),facultySubjectsBean.getSubject()},
			ParameterizedBeanPropertyRowMapper.newInstance(FacultySubjectsBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
}
