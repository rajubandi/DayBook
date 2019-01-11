
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseLocationService1Dao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;




@Repository(value = "locationService1Dao")
public class LocationService1Dao extends BaseLocationService1Dao
{

	public List<Map<String,String>> getLocationsForService(String serviceId)
	{


		String query = "	select l.id as locationId, l.name as locationName from location1 l, location_service1 ls where  ls.service_id = " + serviceId  +
		" and ls.location_id = l.id and l.active = 1 order by l.display_order asc";

		 RowValueCallbackHandler handler = new RowValueCallbackHandler (new String[]{"locationId", "locationName"});
     jdbcTemplate.query(query,handler);
     List<Map<String,String>>  result = handler.getResult();
		 if(result.size() == 1)
		 {
			 Map<String,String>  firstRow = result.get(0);
			 //System.out.println("first row is  " + firstRow.get("locationId"));
			// System.out.println("first Column is  " + firstRow.get("locationName"));
			 if(firstRow.get("locationId").equals("-1"))
			 {
					query = "	select l.id as locationId, l.name as locationName from location1 l where l.parent_city = 1 and l.id > 0 order by l.display_order asc";
					jdbcTemplate.query(query,handler);
     		  result = handler.getResult();
			 }
		 }
		 return result;
  }


	public List<Map<String,String>> getServicesForLocation(String locationId)
	{


		String query = "	select distinct s.id as serviceId, s.name as serviceName,s.is_bold as isbold,s.is_dummy as isdummy from service1 s, location_service1 ls where  ls.location_id in (" + locationId  +
		", -1 )  and ls.service_id = s.id and s.active = 1 order  by s.display_order asc";

		 RowValueCallbackHandler handler = new RowValueCallbackHandler (new String[]{"serviceId", "serviceName","isbold","isdummy"});
     jdbcTemplate.query(query,handler);
     List<Map<String,String>>  result = handler.getResult();
		 return result;
  }




}

