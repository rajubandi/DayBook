package com.aurospaces.neighbourhood.db.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;

public class SingleValueCallbackHandler implements RowCallbackHandler
{
	List<String> retList;
	String keyColumn;

	public SingleValueCallbackHandler(String keyColumn)
	{
		this.keyColumn = keyColumn;
		retList = new ArrayList<String>(); 
	}

	public List<String> getResult()
	{
		return retList;
	}
	
	
	public void processRow(ResultSet rs) throws SQLException {
		String jobid  = rs.getString(keyColumn);
		retList.add(jobid);
	
	}
		

	
}
