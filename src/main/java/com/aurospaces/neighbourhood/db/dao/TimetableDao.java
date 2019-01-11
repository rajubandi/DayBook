package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseTimetableDao;

@Repository(value = "imetableDao")
public class TimetableDao extends BaseTimetableDao{
	
	
	
	public String getFilepath() {
		String sql = "SELECT filePath from timetable ";
		//String retlist = (String)jdbcTemplate.queryForObject(sql,String.class);
		 List<String> retlist = jdbcTemplate.queryForList(sql, String.class); 
		 System.out.println(retlist);
		    if (retlist.isEmpty()) {
		        return null;
		    } else {
		        return retlist.get(0);
		    }
	}

	
	
}

