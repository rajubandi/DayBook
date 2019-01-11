
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.db.basedao.BaseCustomer1Dao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.Coupon1;
import com.aurospaces.neighbourhood.db.model.Customer1;
import com.aurospaces.neighbourhood.db.model.Service1;




@Repository(value = "customer1Dao")
public class Customer1Dao extends BaseCustomer1Dao 
{
	public boolean validtecustomer(String mobileNumber,String password){
		String sql="select * from customer1 where mobile_number='"+mobileNumber+"' and password='"+password+"' " ;
		List<Customer1> retlist = jdbcTemplate.query(sql,
				new Object[]{},
				ParameterizedBeanPropertyRowMapper.newInstance(Customer1.class));
		if(retlist.size() != 0){
			return true;
			}else{
				return false;
			}
	}
	
	
	 public List<Map<String,String>> getCustomerDetails(String  mobileNo, String  password)
		{

			//String query = "select sui.id as testId, vend.first_name as firstName, vend.last_name as lastName, sui.description as testDesc, sui.name as testName, suv.price as price, suv.discount as discount,sui.label as label,suv.vendor_id as vendor_id from service_unit1 sui, vendor1 vend, service_unit_vendor suv where sui.service_id = "+serviceId+" and vend.id = suv.vendor_id and suv.service_unit_id = sui.id";
		 //" select su.name as testName ,su.id as unique_id, suv.id as testId,v.id as vendor_id ,su.description as testDesc, suv.price as price ,v.first_name as firstName , v.last_name as lastName,su.label as label, suv.discount as discount  from service_unit1 su , service_unit_vendor suv, vendor1 v where su.id = suv.service_unit_id and suv.vendor_id = v.id and service_id ="+serviceId+" and v.serving_city ="+locationId ;
			String query =" SELECT mobile_number,email,address1,name FROM customer1 where mobile_number='"+mobileNo+"' and password='"+password+"' limit 1 " ;

			 RowValueCallbackHandler handler = new RowValueCallbackHandler (new String[]{ "mobile_number", "email","address1", "name"});
	     jdbcTemplate.query(query,handler);
	     List<Map<String,String>>  result = handler.getResult();
			 return result;
	  }
	 public int customerExistOrNot(String mobileNo){
			String sql = "select count(*) as count from customer1 where mobile_number ='" + mobileNo+"'" ;
		int count = jdbcTemplate.queryForInt(sql);
		//System.out.println(sql);
		return count;
		}
	 
	 public Customer1 getCustomerMobiledata(String  mobileNumber) {
			String sql = "SELECT * from customer1  where  mobile_number = ? ";
			List<Customer1> retlist = jdbcTemplate.query(sql,
			new Object[]{mobileNumber},
			ParameterizedBeanPropertyRowMapper.newInstance(Customer1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

}

