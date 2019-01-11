
package com.aurospaces.neighbourhood.db.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseServiceUnit1Dao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.ServiceUnitReviewCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.SingleValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.ServiceUnit1;
import com.aurospaces.neighbourhood.db.model.ServiceUnitReviews;




@Repository(value = "serviceUnit1Dao")
public class ServiceUnit1Dao extends BaseServiceUnit1Dao 
{

	 public List<ServiceUnit1> getByServiceAndLocationId(int serviceId , int locationId) {
			String sql = "SELECT su.* from service_unit1 su,service_unit_location1 sul"
					+ " where sul.location_id = ? and sul.service_unit_id = su.id "
					+ " and su.service_id = ?";
			List<ServiceUnit1> retlist = jdbcTemplate.query(sql,
			new Object[]{locationId, serviceId},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnit1.class));
			return retlist;
		}
		

	/* Ignore te location id for now */	
	 public List<Map<String,String>> getAllServiceUnit1s(int serviceId, int locationId, String baseUrl)
		{

			//String query = "select sui.id as testId, vend.first_name as firstName, vend.last_name as lastName, sui.description as testDesc, sui.name as testName, suv.price as price, suv.discount as discount,sui.label as label,suv.vendor_id as vendor_id from service_unit1 sui, vendor1 vend, service_unit_vendor suv where sui.service_id = "+serviceId+" and vend.id = suv.vendor_id and suv.service_unit_id = sui.id";
		 //" select su.name as testName ,su.id as unique_id, suv.id as testId,v.id as vendor_id ,su.description as testDesc, suv.price as price ,v.first_name as firstName , v.last_name as lastName,su.label as label, suv.discount as discount  from service_unit1 su , service_unit_vendor suv, vendor1 v where su.id = suv.service_unit_id and suv.vendor_id = v.id and service_id ="+serviceId+" and v.serving_city ="+locationId ;
			String query =" select su.name as testName ,su.id as unique_id, suv.id as testId,v.id as vendor_id ,su.description as testDesc, suv.price as price ,v.first_name as firstName , v.last_name as lastName,su.label as label, suv.discount as discount,suv.coupon_discount as couponCodeDiscount,ROUND((suv.price * (100 - suv.discount)/ 100 ),0) as finalPrice,concat('" +
		baseUrl +"/"+ "',img_url) as img_url from service_unit1 su , service_unit_vendor suv, vendor1 v where su.id = suv.service_unit_id and su.active=1 and suv.vendor_id = v.id and service_id ="+serviceId+" and v.serving_city ="+locationId;

			 RowValueCallbackHandler handler = new RowValueCallbackHandler (new String[]{ "testId", "firstName","lastName", "testDesc", "testName", "price", "discount", "label","vendor_id", "unique_id","couponCodeDiscount","finalPrice","img_url"});
	     jdbcTemplate.query(query,handler);
	     List<Map<String,String>>  result = handler.getResult();
			 return result;
	  }


	/* Ignore te location id for now */	
	public List<String> getAllLabels(int serviceId, int locationId)
	{

		String query = " select distinct sid.label as label from service_unit1 sid where sid.service_id = " + serviceId ;


		 SingleValueCallbackHandler handler = new SingleValueCallbackHandler("label");
     jdbcTemplate.query(query,handler);
     List<String>  result = handler.getResult();
		 if(result.size() == 1)
			{
				String label = result.get(0);
				if(label.trim().equals(""))
				{
					return new ArrayList<String>();
				}
			}
		 return result;
  }

	public List<Map<String, String>> getAllTests(int service_id,  String baseUrl,int locationId) {
//		String query = "select suh.happiness as happy_percentage, suh.time_to_serve as time_to_serve,  suh.served_number as served_number ,  s.id as id,v.id as vendor_id ,s.name as name, s.description as description, label as category, v.first_name as vendor , s.price as base_price, discount as discount_percent, s.discount_price as discount_price , s.final_price as total_price  , from service_unit1 s inner join vendor1 v on s.vendor_id = v.id right join service_unit_happiness suh on suh.service_unit_id = s.id and suh.vendor_id = v.id where 	 s.service_id =  " + service_id ;

String query = "  select IF(suh.happiness IS NULL, 80, suh.happiness) as happy_percentage, IF(suh.time_to_serve IS NULL, 3, suh.time_to_serve)  as time_to_serve,  IF(suh.served_number IS NULL, 1, suh.served_number) as served_number  ,  suv.id as id,v.id as vendor_id ,s.name as name, s.description as description, suv.label as category, v.first_name as vendor , suv.price as base_price, ceil(suv.discount) as discount_percent, ceil((suv.price*suv.discount)/100)  as discount_price , ceil(suv.final_price) as total_price ,  concat('" +
		baseUrl +"/"+ "',img_url) as img_url from service_unit1 s join service_unit_vendor suv on suv.service_unit_id = s.id left join service_unit_happiness suh on suh.service_unit_id = suv.id inner join vendor1 v on s.vendor_id = v.id   where s.service_id = " + service_id +" and v.serving_city =" + locationId +" and s.active=1 group by suv.id";


		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
				{ "happy_percentage","time_to_serve", "served_number",  "id","vendor_id", "name" ,"description", "category","vendor","base_price","discount_percent","discount_price","total_price","img_url"});


		jdbcTemplate.query(query, handler);
		List<Map<String, String>> result = handler.getResult();
		for(Map<String,String> eachResult : result)
		{
				String hpc = eachResult.get("happy_percentage");
				String tts = eachResult.get("time_to_serve");
				if((hpc == null) || hpc.equals("0") || hpc.equalsIgnoreCase("NULL"))
				{
					eachResult.put("happy_percentage","n/a");
					eachResult.put("time_to_serve","3");
					eachResult.put("served_number","n/a");
				}
				else
				{
//					eachResult.put("time_to_serve", tts + "h");
//					eachResult.put("happy_percentage",hpc + "%");
				}
		}
		
		return result;
	}
	public List<ServiceUnit1> getAll(ServiceUnit1 objServiceUnit1) {
		StringBuffer objStringBuffer=new StringBuffer();
		objStringBuffer.append("SELECT su.id as package_vendor_id,su.id as id,  su.name as name , su.description as description,su.img_url as imgUrl, suv.price as price, suv.discount as discount,suv.coupon_discount as coupondiscount FROM service_unit1 su,service_unit_vendor suv where su.id= suv.service_unit_id ");
		if(objServiceUnit1.getVendorId()!=0){
			objStringBuffer.append("and  su.vendor_id="+objServiceUnit1.getVendorId());
		}
		if(objServiceUnit1.getServiceId()!=0){
			objStringBuffer.append(" and service_id="+objServiceUnit1.getServiceId());
		}
		objStringBuffer.append(" group by id");
		String sql = objStringBuffer.toString();
		List<ServiceUnit1> retlist = jdbcTemplate.query(sql,
				new Object[]{},
				ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnit1.class));
		System.out.println(sql);
				return retlist;
		/*String sql = "select * from service_unit1 where vendor_id=? and service_id= ?";
		List<ServiceUnit1> retlist = jdbcTemplate.query(sql,
		new Object[]{objServiceUnit1.getVendorId(),objServiceUnit1.getServiceId()},
		ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnit1.class));
		return retlist;*/
	}
	 public List<ServiceUnit1> searchPackage(ServiceUnit1 objServiceUnit1 ) {
			String sql = "SELECT * from service_unit1 where name = ? ";
			List<ServiceUnit1> retlist = jdbcTemplate.query(sql,
			new Object[]{objServiceUnit1.getName()},
			ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnit1.class));
			return retlist;
		}
	
	 public Collection<ServiceUnitReviews> getVendorPackageDate(int package_id,  String baseUrl) {

		/*String query = " select suv.id as package_id,pr.id as review_id ,pr.name as name, pr.review as review , concat('"+baseUrl +"/"+"',pr.profile_pic) as profile_photo , su.name as package_name, suv.final_price as package_cost, suh.happiness as happy_percent,suh.time_to_serve as tts, suh.served_number as served_nos, v.first_name as vendor, su.description as package_description, concat('" +
				baseUrl+"/"+"',img_url) as pacakge_image_url  from service_unit1 su , service_unit_vendor suv, service_unit_happiness suh, vendor1 v, package_reviews pr  where su.id = suv.service_unit_id and su.id = suh.service_unit_id and v.id = suv.vendor_id and pr.service_unit_id = su.id and suv.id  =  " + package_id;
*/

		 String query =" select suv.id as package_id,pr.id as review_id ,pr.name as name, pr.review as review , "
		 		+ "concat('"+baseUrl +"/"+"',pr.profile_pic) as profile_photo , su.name as package_name, "
		 				+ "ceil(suv.final_price) as package_cost,suv.discount as discount,suh.happiness as happy_percent,suh.time_to_serve as tts, "
		 				+ "suh.served_number as served_nos, v.first_name as vendor, su.description as package_description, "
		 				+ "concat('" +baseUrl+"/"+"',su.img_url) as pacakge_image_url from service_unit_vendor suv,service_unit1 su, "
		 				+ "service_unit_happiness suh, package_reviews pr, vendor1 v   where su.id = suv.service_unit_id "
		 				+ "and suh.service_unit_id = suv.id and pr.service_unit_id =suv.id  and v.id = suv.vendor_id  "
		 				+ " and suv.id="+package_id +" group by suv.id ";
		 
		 
/*			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
					{"package_name" ,"package_cost", "happy_percent","tts", "served_nos",  "vendor","package_description","pacakge_image_url"});*/

System.out.println(query);
		ServiceUnitReviewCallbackHandler handler = new 
				ServiceUnitReviewCallbackHandler(baseUrl);

	     

		jdbcTemplate.query(query,handler);
		List<Map<String, String>> result = handler.getResult();
	    
	     
	  /*   List<Map<String, String>> result = handler.getServiceCategory();
			for(Map<String,String> eachResult : result)
			{
					String hpc = eachResult.get("happy_percentage");
					String tts = eachResult.get("time_to_serve");
					if((hpc == null) || hpc.equals("0") || hpc.equalsIgnoreCase("NULL"))
					{
						eachResult.put("happy_percentage","n/a");
						eachResult.put("time_to_serve","3");
						eachResult.put("served_number","n/a");
					}
					else
					{
//						eachResult.put("time_to_serve", tts + "h");
//						eachResult.put("happy_percentage",hpc + "%");
					}
			}*/
			 return handler.getServiceCategory();
		}

	 public  String getServiceunitid(String  name, String description, int service_id)throws SQLException {
	        String sql = "SELECT id from service_unit1  where name = '"+name + "' and description='" +description +"' and service_id=" +service_id;
	        System.out.println(sql);
	       /*  retlist = 0;
	                        retlist = jdbcTemplate.queryForObject(
	    sql, new Object[] {  }, Integer.class);
	        if(retlist == 0){
	                retlist = 0;        
	        }
	        return retlist;
	        */
	        
	        List<String> certs = jdbcTemplate.queryForList(sql, String.class); 
	        if (certs.isEmpty()) {
	            return null;
	        } else {
	            return certs.get(0);
	        }
	}
	 
	 
	 public List<Map<String,String>> gettagsPrice( String baseUrl)
		{

			//String query = "select sui.id as testId, vend.first_name as firstName, vend.last_name as lastName, sui.description as testDesc, sui.name as testName, suv.price as price, suv.discount as discount,sui.label as label,suv.vendor_id as vendor_id from service_unit1 sui, vendor1 vend, service_unit_vendor suv where sui.service_id = "+serviceId+" and vend.id = suv.vendor_id and suv.service_unit_id = sui.id";
		 //" select su.name as testName ,su.id as unique_id, suv.id as testId,v.id as vendor_id ,su.description as testDesc, suv.price as price ,v.first_name as firstName , v.last_name as lastName,su.label as label, suv.discount as discount  from service_unit1 su , service_unit_vendor suv, vendor1 v where su.id = suv.service_unit_id and suv.vendor_id = v.id and service_id ="+serviceId+" and v.serving_city ="+locationId ;
			String query =" select LCASE(su.name) as service_name ,su.id as unique_id, suv.id as testId,v.id as vendor_id ,LCASE(su.description) as service_details, suv.price as price ,v.first_name as firstName , v.last_name as lastName,su.label as label, suv.discount as discount,suv.coupon_discount as couponCodeDiscount,ROUND((suv.price * (100 - suv.discount)/ 100 ),0) as finalPrice,concat('" +
		baseUrl +"/"+ "',img_url) as img_url from service_unit1 su , service_unit_vendor suv, vendor1 v where su.id = suv.service_unit_id and su.active=1 and suv.vendor_id = v.id and  v.serving_city ="+24 +" and su.service_id not in (10)" ;

			 RowValueCallbackHandler handler = new RowValueCallbackHandler (new String[]{  "service_details", "service_name", "price" });
	     jdbcTemplate.query(query,handler);
	     List<Map<String,String>>  result = handler.getResult();
			 return result;
	  }

	}



