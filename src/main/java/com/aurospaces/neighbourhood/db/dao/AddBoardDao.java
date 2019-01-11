package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.AddBoardBean;
import com.aurospaces.neighbourhood.bean.MediumBean;
import com.aurospaces.neighbourhood.db.basedao.AddBaseBoardDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
@Repository(value="AddBoardDao")
public class AddBoardDao extends AddBaseBoardDao {
	public List<Map<String, String>> getBoard( ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id as boardId,name from boardname ");
		
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "boardId","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	public AddBoardBean existingOrNot(String name ){
		
		
		
		String sql = "select id ,name from boardname where name =? ";
		List<AddBoardBean> retlist = jdbcTemplate.query(sql,
		new Object[]{name},
		ParameterizedBeanPropertyRowMapper.newInstance(AddBoardBean.class));
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
