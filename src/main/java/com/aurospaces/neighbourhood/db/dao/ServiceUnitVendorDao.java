
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseServiceUnitVendorDao;
import com.aurospaces.neighbourhood.db.model.ServiceUnit1;
import com.aurospaces.neighbourhood.db.model.ServiceUnitVendor;




@Repository(value = "serviceUnitVendorDao")
public class ServiceUnitVendorDao extends BaseServiceUnitVendorDao
{

	public ServiceUnitVendor getByServiceUnitId(int id) {
		String sql = "SELECT * from service_unit_vendor where service_unit_id = ? ";
		List<ServiceUnitVendor> retlist = jdbcTemplate.query(sql,
		new Object[]{id},
		ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnitVendor.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}

}

