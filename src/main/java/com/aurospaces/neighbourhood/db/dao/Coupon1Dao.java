
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseCoupon1Dao;
import com.aurospaces.neighbourhood.db.model.Coupon1;
import com.aurospaces.neighbourhood.db.model.ServiceUnitVendor;




@Repository(value = "coupon1Dao")
public class Coupon1Dao extends BaseCoupon1Dao
{

	public ServiceUnitVendor getCouponcodePercentage(String couponcode , int serviceId ,int vendorId,int packageId){
		
		
		String sql = "select suv.coupon_discount from coupon1 c ,service_unit_vendor suv,service_unit1 su " 
							+" where  su.service_id = "+serviceId 
							+" and suv.id = "+packageId +" and suv.vendor_id = "+vendorId +" and c.code = '"+ couponcode+"' limit 1 " ;
		List<ServiceUnitVendor> retlist = jdbcTemplate.query(sql,
		new Object[]{},
		ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnitVendor.class));
		//System.out.println(sql);
		if(retlist.size() != 0){
		return retlist.get(0);
		}else{
			return null;
		}
	}
public boolean couponweb(String couponcode,int serviceId){
	String sql="select * from coupon1 where code='"+couponcode+"' and service_id="+serviceId ;
	List<Coupon1> retlist = jdbcTemplate.query(sql,
			new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(Coupon1.class));
	if(retlist.size() != 0){
		return true;
		}else{
			return false;
		}

}

}

