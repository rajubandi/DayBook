
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseVendorLocationDao;
import com.aurospaces.neighbourhood.db.model.Location1;
import com.aurospaces.neighbourhood.db.model.VendorLocation;




@Repository(value = "vendorLocationDao")
public class VendorLocationDao extends BaseVendorLocationDao
{
	 public  List<VendorLocation> getAll(int vendorId) {
			String sql = "select vl.id,vl.location_id,vl.vendor_id,v.first_name as vendorName,l.name as locationName from vendor_location vl,vendor1 v,location1 l where v.id =vl.vendor_id"
						+" and l.id =vl.location_id and vl.vendor_id="+vendorId ;
			System.out.println(sql);
			List<VendorLocation> retlist = jdbcTemplate.query(sql,
			new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(VendorLocation.class));
			System.out.println("vendor_location----"+retlist.size());
			return retlist;
		}


}

