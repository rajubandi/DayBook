package com.aurospaces.neighbourhood.db.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.AcademicYearBean;
import com.aurospaces.neighbourhood.db.basedao.AddBaseAcademicYearDao;
@Repository(value="AddAcademicYearDao")
public class AddAcademicYearDao extends AddBaseAcademicYearDao {
	
	public List<Map<String, Object>> getAcademicYearSelectList( ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name, status from academicyear ");
		
		 	String sql = objStringBuffer.toString();
			
			List<Map<String, Object>> result = jdbcTemplate.queryForList(sql );
			return result;
			
		}
	
	public Map<String, String> getNotActiveAcademicYearSelectList( ){
		 
		 Map<String, String> statesMap = new LinkedHashMap<String, String>();
				StringBuffer sSql = new StringBuffer();
				sSql.append("select id ,name from academicyear where status <> 1 ");
		 	String sql = sSql.toString();
			
			List<AcademicYearBean> result = jdbcTemplate.query(sql,ParameterizedBeanPropertyRowMapper.newInstance(AcademicYearBean.class) );
			for(AcademicYearBean bean: result){
				statesMap.put(String.valueOf(bean.getId()), bean.getName());
			}
			
			
			return statesMap;
			
		}
	public List<Map<String, Object>> getAcademicYear( ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name, status from academicyear ");
		
		 	String sql = objStringBuffer.toString();
			
			List<Map<String, Object>> result = jdbcTemplate.queryForList(sql );
			return result;
			
		}
	public int getActiveAcademicYearId( ){
		
	 	String sql =  "select id from academicyear where status=1 ";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
		
	}
	public AcademicYearBean existingOrNot(String name ){
		
		
		
		String sql = "select id ,name from academicyear where name =? ";
		List<AcademicYearBean> retlist = jdbcTemplate.query(sql,
		new Object[]{name},
		ParameterizedBeanPropertyRowMapper.newInstance(AcademicYearBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
		
		/* StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name from boardname where name ='"+name + "'");
		
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;*/
			
		}
	
}
