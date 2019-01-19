package com.aurospaces.neighbourhood.dao;

    import java.util.List;
	import java.util.Map;

	import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
	import org.springframework.stereotype.Repository;
	
	import com.aurospaces.neighbourhood.bean.CollectionBean;
	import com.aurospaces.neighbourhood.db.basedao.AddBaseCollectionDao;
	import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
	
	@Repository(value="addCollectionDao")
	public class AddCollectionDao extends AddBaseCollectionDao {
		
		public List<Map<String, String>> getAccountHaed( ){
			 StringBuffer objStringBuffer = new StringBuffer();
			 objStringBuffer.append("select id as accountId, DATE_format(date,'%d-%M-%Y') as date,client,description,fullamount,paidamount,dueamount from collections ");
			
	String sql = objStringBuffer.toString();
				System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "accountId","date","client","description","fullamount","paidamount","dueamount"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}
		
		public CollectionBean existingOrNot(String id ){			
			
			String sql = "select id , DATE_format(date,'%d-%M-%Y') as date, client, description, fullamount, paidamount, dueamount from collections where id =? ";
			List<CollectionBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(CollectionBean.class));
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


