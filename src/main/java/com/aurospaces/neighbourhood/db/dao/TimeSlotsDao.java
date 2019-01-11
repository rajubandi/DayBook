
package com.aurospaces.neighbourhood.db.dao;

import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.db.basedao.BaseTimeSlotsDao;
import com.aurospaces.neighbourhood.db.model.TimeSlots;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;




@Repository(value = "timeSlotsDao")
public class TimeSlotsDao extends BaseTimeSlotsDao
{


	 public List<TimeSlots> getAll() {
			String sql = "SELECT * from time_slots1 order by hour asc";
			List<TimeSlots> retlist = jdbcTemplate.query(sql,
			ParameterizedBeanPropertyRowMapper.newInstance(TimeSlots.class));
			return retlist;
		}

	/* Ignore te location id for now */	
	public 
	
List<Map<String,String>> 	
	
 getTimeSlotsAsMap()
	{
		String query = "select id as id ,label as name  from time_slots1";
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] {"id","name"});
    jdbcTemplate.query(query,handler);
    return handler.getResult();
  }
}

