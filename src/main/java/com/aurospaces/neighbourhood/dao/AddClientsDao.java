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
		 objStringBuffer.append("select id as accountId,clientName,phoneNumber,mail,address from clients ");
		
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "accountId","clientName","phoneNumber","mail","address"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	
	public ClientDetailsBean  existingOrNot(String id ){			
		
		String sql = "select id ,clientName, phoneNumber, mail, address from clients where id =? ";
		List<ClientDetailsBean> retlist = jdbcTemplate.query(sql,
		new Object[]{id},
		ParameterizedBeanPropertyRowMapper.newInstance(ClientDetailsBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
		
		}
}