
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseVendorService1Dao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.OrderInfo1;
import com.aurospaces.neighbourhood.db.model.ServiceUnit1;
import com.aurospaces.neighbourhood.db.model.VendorService1;




@Repository(value = "vendorService1Dao")
public class VendorService1Dao extends BaseVendorService1Dao
{
	public List<VendorService1> getServicesForVendor(int vendorId)
	{
		return getServicesForVendor(vendorId  + "");
	}

	public List<VendorService1> getServicesForVendor(String vendorId)
	{

System.out.println(vendorId);
		String query = "select s.id serviceId, s.name as serviceName from service1 s,vendor_service1 vs where s.id = vs.service_id and vs.vendor_id = ? group by s.id";
		System.out.println(query);
		List<VendorService1> handler = jdbcTemplate.query(query, new Object[]{vendorId},ParameterizedBeanPropertyRowMapper.newInstance(VendorService1.class));
		 System.out.println(query);
     
		 return handler;
  }
	public void  getLastOrder(int VendorId)
	{
		String query = " Delete from vendor_service1 where vendor_Id = \"" + VendorId + "\" " ;
         jdbcTemplate.update(query);
		

	}
	
	
}

