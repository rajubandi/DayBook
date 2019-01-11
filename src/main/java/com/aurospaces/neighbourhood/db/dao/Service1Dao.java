package com.aurospaces.neighbourhood.db.dao;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.LoginBean;
import com.aurospaces.neighbourhood.db.basedao.BaseService1Dao;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.Service1;


@Repository(value = "service1Dao")
public class Service1Dao extends BaseService1Dao
{

@Autowired HttpSession session;
 public List<Service1> getByDisplayOrder(String order) {
      String sql = "SELECT * from service1 where active = 1 order by  display_order " + order +  ", is_bold desc ";
      List<Service1> retlist = jdbcTemplate.query(sql,
      new Object[]{},
      ParameterizedBeanPropertyRowMapper.newInstance(Service1.class));
      return retlist;
    }

	 public List<Service1> getAll(String string) {
			String sql = "SELECT * from service1 ";
			List<Service1> retlist = jdbcTemplate.query(sql,
			new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(Service1.class));
			return retlist;
		}

	 public List<Service1> getServices(Service1 objServicesBean,
				String likeSearch) {
			List<Service1> listServicesBeans = null;
			try {
				StringBuffer objStringBuffer = new StringBuffer();
				objStringBuffer.append("select * from service1 where parent_category='"+objServicesBean.getParentCategory()+"'");
				String sSql = objStringBuffer.toString();
				System.out.println(sSql);
				listServicesBeans = jdbcTemplate
						.query(sSql,
								new BeanPropertyRowMapper<Service1>(
										Service1.class));
			} catch (Exception e) {
				e.printStackTrace();
			
			} finally {
				
			}
			return listServicesBeans;
		}

	 
	 public List<Service1> getByDisplayOrder1(Service1 objServicesBean ) {
			String sql = "SELECT * from service1 where name = ? ";
			List<Service1> retlist = jdbcTemplate.query(sql,
			new Object[]{objServicesBean.getName()},
			ParameterizedBeanPropertyRowMapper.newInstance(Service1.class));
			return retlist;
		}


	 public Map<String,String> getServicesAsMap() {
		 LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
		
		 StringBuffer objStringBuffer = new StringBuffer();
	 KeyValueCallbackHandler handler = new KeyValueCallbackHandler("id","name");
	 objStringBuffer.append("SELECT s.id , s.name from service1 s,location_service1 ls where s.id =ls.service_id  "
				+" and s.is_bold=0 and s.parent_category "
				+ " is not null ");
	/* if(loginBean != null){
	 if(loginBean.getLocationId() != 0){
		 objStringBuffer.append(" and ls.location_id = "+loginBean.getLocationId());
	 }
	 }*/
	 objStringBuffer.append( " group by s.id order by s.display_order");
			String query =objStringBuffer.toString() ;
     jdbcTemplate.query(query,handler);
     return handler.getResult();
		}
	 
	 public List<Service1> getCatageryList(Service1 objServicesBean ) {
			String sql = "SELECT * from service1 where parent_category = ? ";
			List<Service1> retlist = jdbcTemplate.query(sql,
			new Object[]{objServicesBean.getParentCategory()},
			ParameterizedBeanPropertyRowMapper.newInstance(Service1.class));
			return retlist;
		}
	 
	 public List<Service1> searchService(Service1 objServicesBean ) {
			String sql = "SELECT * from service1 where name = ? ";
			List<Service1> retlist = jdbcTemplate.query(sql,
			new Object[]{objServicesBean.getName()},
			ParameterizedBeanPropertyRowMapper.newInstance(Service1.class));
			return retlist;
		}
	 public int getServiceId(String serviceName){
		 String sql = "select id from service1 where name = '"+serviceName+"' limit 1";
			int result = jdbcTemplate.queryForInt(sql);
		System.out.println(sql);
		 return result;
	 }


	public List<Service1> getServicesForCategory(String parentCategory)
	{

		String query = "select s.*  from service1 s , category1 c where s.parent_category = c.id and s.is_bold=0 and c.id = ?";
		System.out.println(query);
		List<Service1> handler = jdbcTemplate.query(query, new Object[]{parentCategory},ParameterizedBeanPropertyRowMapper.newInstance(Service1.class));
		 System.out.println(query);
     
		 return handler;
  }
}

