package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.AddBoardBean;
import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.db.basedao.BaseSubjectDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
@Repository(value="SubjectDao")
public class SubjectDao extends BaseSubjectDao {
	public List<Map<String, String>> getSubjects( ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id as subjectId,name from subject ");
		
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "subjectId","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	public StudentBean existingOrNot(String name ){
		
		String sql = "select id ,name from boardname where name =? ";
		List<StudentBean> retlist = jdbcTemplate.query(sql,
		new Object[]{name},
		ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
		
		
		/* StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name from subject where name ='"+name + "'");
		
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;*/
			
		}
}
