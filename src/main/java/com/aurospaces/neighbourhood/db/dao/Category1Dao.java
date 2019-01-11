
package com.aurospaces.neighbourhood.db.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.RestService1;
import com.aurospaces.neighbourhood.custommodel.ServiceCategory;
import com.aurospaces.neighbourhood.db.basedao.BaseCategory1Dao;
import com.aurospaces.neighbourhood.db.callback.ServiceCategoryCallbackHandler;
import com.aurospaces.neighbourhood.db.model.Category1;



@Repository(value = "category1Dao")
public class Category1Dao extends BaseCategory1Dao
{

	public Collection<ServiceCategory> getCategoriesForMobile(String baseUrl,int locationId)
	{
		//String query = "select c.id as category_id, c.name as category_name,s.icon_img as img,c.img_url as cimg, s.id as service_id, s.name as service_name from category1 c, service1 s where s.parent_category = c.id and s.is_dummy = 0  and s.id in (select distinct service_id from service_unit1 ) and s.is_bold = 0 order by s.display_order asc ";
String query =" select c.id as category_id, c.name as category_name, s.icon_img as img,"
		+ " c.img_url as cimg, s.id as service_id, s.name as service_name from category1 c, service1 s, "
		+ " location_service1 ls where s.id = ls.service_id and  s.parent_category = c.id and s.is_dummy = 0 "
		+ " and s.id in (select distinct service_id from service_unit1 ) and ls.location_id="+locationId+" and s.is_bold = 0"
		+ " order by s.display_order asc ";
		ServiceCategoryCallbackHandler handler = new 
			ServiceCategoryCallbackHandler(baseUrl);

     jdbcTemplate.query(query,handler);
     return handler.getServiceCategory();
  }

	public List<Category1> getAll() {
		String sql = "SELECT * from category1 ";
		List<Category1> retlist = jdbcTemplate.query(sql,
		new Object[]{},
		ParameterizedBeanPropertyRowMapper.newInstance(Category1.class));
		return retlist;
	}
	
	public Collection<RestService1> getServicesForMobile(String baseUrl,int locationId)
	{
		String query = "select concat ('"+baseUrl+"' ,s.img_url)  as service_img,s.id as service_id, s.name as service_name,s.description as description from service1 s ,location_service1 ls where ls.service_id=s.id and s.is_dummy = 0  and s.id in (select distinct service_id from service_unit1 ) and s.is_bold = 0 and ls.location_id ="+locationId+" order by s.display_order asc";

		/*ServiceCategoryCallbackHandler handler = new 
			ServiceCategoryCallbackHandler(baseUrl);*/

	 return jdbcTemplate.query(query, new BeanPropertyRowMapper<RestService1>(RestService1.class));
	 /*return handler.getServiceCategory();*/
	}
	

}

