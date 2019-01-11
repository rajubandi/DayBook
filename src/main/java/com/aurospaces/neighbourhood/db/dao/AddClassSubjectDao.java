package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ClassSubjectBean;
import com.aurospaces.neighbourhood.bean.ExamMarksBean;
import com.aurospaces.neighbourhood.bean.FilterBean;
import com.aurospaces.neighbourhood.db.basedao.AddClassSubjectBaseDao;

@Repository(value="addClassSubjectDao")
public class AddClassSubjectDao extends AddClassSubjectBaseDao {
	
	public List<ClassSubjectBean> getAllClassSubjects() {
		List<ClassSubjectBean> retlist = null;
		try {
			String sql = "SELECT s.name as subjectName,ct.name as className,bn.name as boardName,cs.* from classsubjects cs,classtable ct,subject s,boardname bn where cs.boardId=bn.id and cs.classId=ct.id and s.id=cs.subjectId";
			System.out.println(sql);
			retlist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ClassSubjectBean>(ClassSubjectBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retlist;
	}
	
	
	public List<ExamMarksBean> getAllClassSubjectsName(String boardId,String classId)
	{
		//This method is to get All Subject Names in examMarks.jsp field name "Subject" via Board and Class....

		String query = "select cs.subjectId,sb.name as subjectName from classsubjects cs ,subject  sb  where  cs.subjectId = sb.id  and  cs.boardId = ? and cs.classId = ? ";
		System.out.println(query);
		List<ExamMarksBean> handler = jdbcTemplate.query(query, new Object[]{boardId,classId},ParameterizedBeanPropertyRowMapper.newInstance(ExamMarksBean.class));
		 System.out.println(query);
     
		 return handler;
  }
	public ClassSubjectBean duplecateCheck(ClassSubjectBean classSubjectBean) {
		 //jdbcTemplate = custom.getJdbcTemplate();
			String sql = "SELECT * from classsubjects where boardId = ? and classId =? and subjectId =?";
			List<ClassSubjectBean> retlist = jdbcTemplate.query(sql,
			new Object[]{classSubjectBean.getBoardId(),classSubjectBean.getClassId(),classSubjectBean.getSubjectId()},
			ParameterizedBeanPropertyRowMapper.newInstance(ClassSubjectBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
}
