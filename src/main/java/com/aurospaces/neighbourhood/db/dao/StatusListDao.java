
package com.aurospaces.neighbourhood.db.dao;

import org.springframework.stereotype.Repository;

import java.util.*;

import com.aurospaces.neighbourhood.db.basedao.BaseStatusListDao;
import com.aurospaces.neighbourhood.db.model.StatusList;

import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;




@Repository(value = "statusListDao")
public class StatusListDao extends BaseStatusListDao
{

	/* Ignore te location id for now */	
	public List<Map<String,String>> getAllStatuses()
	{
		String query = "select id,name from status_list1";

		 RowValueCallbackHandler handler = new RowValueCallbackHandler (new String[]{ "id", "name"});
     jdbcTemplate.query(query,handler);
     List<Map<String,String>>  result = handler.getResult();
		 return result;
  }


	/* Ignore te location id for now */	
	public Map<String,String> getStatusesAsMap()
	{
		String query = "select id,name from status_list1";
		KeyValueCallbackHandler handler = new KeyValueCallbackHandler("id","name");
    jdbcTemplate.query(query,handler);
    return handler.getResult();
  }
	public Map<String,String> getApointmentDateMap()
	{
		String query = "select id as id ,label as name  from time_slots1";
		KeyValueCallbackHandler handler = new KeyValueCallbackHandler("id","name");
    jdbcTemplate.query(query,handler);
    return handler.getResult();
  }


}

