
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseServiceUnitHappinessDao;
import com.aurospaces.neighbourhood.db.model.ServiceUnitHappiness;
import com.aurospaces.neighbourhood.db.model.ServiceUnitVendor;




@Repository(value = "serviceUnitHappinessDao")
public class ServiceUnitHappinessDao extends BaseServiceUnitHappinessDao
{
	public ServiceUnitHappiness getByServiceUnitId(int id) {
		String sql = "SELECT * from service_unit_happiness where service_unit_id = ? ";
		List<ServiceUnitHappiness> retlist = jdbcTemplate.query(sql,
		new Object[]{id},
		ParameterizedBeanPropertyRowMapper.newInstance(ServiceUnitHappiness.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}


}

