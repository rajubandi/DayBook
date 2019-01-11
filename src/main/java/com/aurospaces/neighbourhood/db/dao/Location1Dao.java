
package com.aurospaces.neighbourhood.db.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import com.aurospaces.neighbourhood.db.basedao.BaseLocation1Dao;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.Location1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;




@Repository(value = "location1Dao")
public class Location1Dao extends BaseLocation1Dao
{



 public Location1 getDefaultLocation() {
		String sql = "SELECT * from location1 where active = 1 and is_default = 1";
		List<Location1> retlist = jdbcTemplate.query(sql,
		new Object[]{},
		ParameterizedBeanPropertyRowMapper.newInstance(Location1.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}

 public List<Location1> getActiveByDisplayOrder(String order) {
		String sql = "SELECT * from location1 where active = 1 order by  display_order " + order;
		List<Location1> retlist = jdbcTemplate.query(sql,
		new Object[]{},
		ParameterizedBeanPropertyRowMapper.newInstance(Location1.class));
		return retlist;
	}
 
 public  List<Location1> getAll(int city) {
		String sql = "SELECT * from location1  where parent_city = "+city+" order by updated_time desc";
		System.out.println(sql);
		List<Location1> retlist = jdbcTemplate.query(sql,
		new Object[]{},
		ParameterizedBeanPropertyRowMapper.newInstance(Location1.class));
		System.out.println("location1----"+retlist.size());
		return retlist;
	}




 //for mobile..
 public List<Map<String,String>> getAllLocations(String order) {
	 
	 String query = "	select l.id as location_id, l.name as location_name from location1 l where active = 1 and is_dummy=0 ";

				 RowValueCallbackHandler handler = new RowValueCallbackHandler (new String[]{"location_id", "location_name"});
				 jdbcTemplate.query(query,handler);
				 List<Map<String,String>>  result = handler.getResult();
				 return result;
				 
		
	}
 @Autowired
	public JdbcTemplate jdbcTemplate;

	public Map<String, String> getAllLocations() {
		KeyValueCallbackHandler handler = new KeyValueCallbackHandler("id", "name");
		String query = "SELECT id  ,name  from location1";
		jdbcTemplate.query(query, handler);
		return handler.getResult();
	}
	
	 public  int getLocationName(String  locationName) {
			String sql = "SELECT id from location1  where name = '"+locationName+"' limit 1 ";
			System.out.println(sql);
			int retlist = jdbcTemplate.queryForObject(
                    sql, new Object[] {  }, Integer.class);
			if(retlist == 0){
				retlist = 24;	
			}
			return retlist;
		}
}
