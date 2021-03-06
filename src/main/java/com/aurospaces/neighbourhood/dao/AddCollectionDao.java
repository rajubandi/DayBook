package com.aurospaces.neighbourhood.dao;

    import java.text.SimpleDateFormat;
import java.util.Date;
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
							
			}
		
		public List<Map<String, String>> getClientId(String clientName ){
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select id from clients where clientName = '"+ clientName +"'");
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getClientId( ) ---- : " +result);
			return result;			
		}
		
		public List<Map<String, String>> getPaidAmount(int id ){
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select sum(paidamount) as paidamount from collections where clientid ="+id);
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "paidamount"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getPaidAmount( ) ---- : " +result);
			return result;			
		}
		
		public List<Map<String, String>> getFullAmount(int id ){
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select fullamount from collections where clientid ="+id);
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "fullamount"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getFullAmount( ) ---- : " +result);
			return result;			
		}
		
		public List<Map<String, String>> getDueDate(){
		    StringBuffer objStringBuffer = new StringBuffer();
		    
		    String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			System.out.println("yyyy-MM-dd "  +date);
			
			 objStringBuffer.append("select duedate from collections WHERE duedate = ' " +date +" '");
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "duedate"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getDueDate( ) ---- : " +result);
			return result;			
		}
		
		public List<Map<String, String>> getClientIdBasedOnDuedate(){
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			System.out.println("yyyy-MM-dd "  +date);
			
			
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select clientid as clntid from collections WHERE duedate = ' " +date +" '");
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "clntid"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getClientIdBasedOnDuedate( ) ---- : " +result);
			return result;			
		}
		
		public List<Map<String, String>> getClientName(int id ){			
			
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select client from collections where clientid ="+id);
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "client"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getClientName( ) ---- : " +result);
			return result;			
		}
		
		public List<Map<String, String>> getPhoneNumber(int id){
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select phoneNumber from clients where id = "+id);
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "phoneNumber"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getPhoneNumber( ) ---- : " +result);
			return result;			
		}
		
		public List<Map<String, String>> getPhoneNumberOfAdmin(){			
						
			String admin = "admin";
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select mobile from users where name = '" +admin +"'");
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "mobile"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getPhoneNumberOfAdmin( ) ---- : " +result);
			return result;			
		}
	}