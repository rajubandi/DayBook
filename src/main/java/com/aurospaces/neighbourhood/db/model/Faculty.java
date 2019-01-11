package com.aurospaces.neighbourhood.db.model;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ClassBean;
import com.aurospaces.neighbourhood.bean.FacultyBean;
import com.aurospaces.neighbourhood.db.basedao.BaseFacultyDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "Faculty")
public class Faculty extends BaseFacultyDao{
	public List<FacultyBean> getBoardName(String parentCategory)
	{

		String query = "select m.id,cc.boardId,m.name from classcreation cc,mediam m where boardId=? and m.id=cc.mediamId group by m.id";
		System.out.println(query);
		List<FacultyBean> handler = jdbcTemplate.query(query, new Object[]{parentCategory},ParameterizedBeanPropertyRowMapper.newInstance(FacultyBean.class));
		 System.out.println(query);
     
		 return handler;
  }
	public List<FacultyBean> getMedium(String parentCategory)
	{

		String query = "select cc.name from classcreation cc where mediamId=?  group by className";
		System.out.println(query);
		List<FacultyBean> handler = jdbcTemplate.query(query, new Object[]{parentCategory},ParameterizedBeanPropertyRowMapper.newInstance(FacultyBean.class));
		 System.out.println(query);
     
		 return handler;
  }
	 public List<Map<String, String>> getallFaculty(){
			
			String sql ="select id,name as facutltyName, gender,qualifaction,contactNumber from faculty";

			//System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","facutltyName","gender","qualifaction","contactNumber"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	  public FacultyBean getExistingOrNot(FacultyBean objClassBean) {
			String sql = "SELECT * from faculty where contactNumber=? ";
			List<FacultyBean> retlist = jdbcTemplate.query(sql,
			new Object[]{objClassBean.getContactNumber()},
			ParameterizedBeanPropertyRowMapper.newInstance(FacultyBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
}
