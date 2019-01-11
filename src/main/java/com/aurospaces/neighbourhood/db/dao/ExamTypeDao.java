package com.aurospaces.neighbourhood.db.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ExamTypeBean;
import com.aurospaces.neighbourhood.db.basedao.ExamTypeBaseDao;
@Repository(value="examTypeDao")
public class ExamTypeDao extends ExamTypeBaseDao {
	
	
	public  Map<String, String> getAllExamType()
	{

		
		Map<String, String> statesMap = new LinkedHashMap<String, String>();
		try {
			String query = "select id,examType  from exam_type ";
			List<ExamTypeBean> list = jdbcTemplate.query(query,ParameterizedBeanPropertyRowMapper.newInstance(ExamTypeBean.class));
			for(ExamTypeBean bean: list){
				String id = String.valueOf(bean.getId());
				statesMap.put(id, bean.getExamType());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return statesMap;
     
  }
}
