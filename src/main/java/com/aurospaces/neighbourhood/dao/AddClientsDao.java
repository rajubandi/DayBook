package com.aurospaces.neighbourhood.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.bean.ClientDetailsBean;
import com.aurospaces.neighbourhood.db.basedao.AddBaseClientsDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value="addClientsDao")
public class AddClientsDao extends AddBaseClientsDao {
	
	public List<Map<String, String>> getAccountHaed( ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id as accountId,clientName,phoneNumber,mail,address,fullamount,DATE_format(createddate,'%d-%M-%Y') as createddate,DATE_format(duedate,'%d-%M-%Y') as duedate  from clients ");
		
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "accountId","clientName","phoneNumber","mail","address","fullamount","createddate","duedate"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getAccountHaed( ) ---- : " +result);
			return result;			
		}
	
	public ClientDetailsBean  existingOrNot(String id ){			
		
		String sql = "select id ,clientName, phoneNumber, mail, address, fullamount, DATE_format(createddate,'%d-%M-%Y') as createddate, DATE_format(duedate,'%d-%M-%Y') as duedate from clients where id =? ";
		List<ClientDetailsBean> retlist = jdbcTemplate.query(sql,
		new Object[]{id},
		ParameterizedBeanPropertyRowMapper.newInstance(ClientDetailsBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
		
		}
	
	public List<Map<String, String>> getClientId( ){
		    StringBuffer objStringBuffer = new StringBuffer();
		    objStringBuffer.append("select max(id) as accountId from clients ");
		
		 	String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "accountId"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			System.out.println("In getClientId( ) ---- : " +result);
			return result;			
		}
}