package com.aurospaces.neighbourhood.dao;
import java.util.List;
	import java.util.Map;

	import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
	import org.springframework.stereotype.Repository;

	import com.aurospaces.neighbourhood.bean.AddAccountHeadBean;
	import com.aurospaces.neighbourhood.db.basedao.AddBaseAccountHeadDao;
	import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
	
	@Repository(value="addAccountHeadDao")
	public class AddAccountHeadDao extends AddBaseAccountHeadDao {
		public List<Map<String, String>> getAccountHaed( ){
			 StringBuffer objStringBuffer = new StringBuffer();
			 objStringBuffer.append("select id as accountId,name from accounthead ");
			
	String sql = objStringBuffer.toString();
				System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "accountId","name"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}
		
		public AddAccountHeadBean existingOrNot(String name ){			
			
			String sql = "select id ,name from accounthead where name =? ";
			List<AddAccountHeadBean> retlist = jdbcTemplate.query(sql,
			new Object[]{name},
			ParameterizedBeanPropertyRowMapper.newInstance(AddAccountHeadBean.class));
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