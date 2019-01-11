
package com.aurospaces.neighbourhood.db.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseDoctorType1Dao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.DoctorType1;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import java.util.List;
import java.util.Map;

@Repository(value = "doctorType1Dao")
public class DoctorType1Dao extends BaseDoctorType1Dao {

	public List<DoctorType1> getAll() {

		String query = "select * from doctor_type1 where active = 1";

		List<DoctorType1> retlist = jdbcTemplate.query(query, new Object[] {},
				ParameterizedBeanPropertyRowMapper.newInstance(DoctorType1.class));
		return retlist;
	}

	public List<Map<String, String>> getAllDoctors() {
		String query = "select id as doctor_type_id, name as doctor_type_name, icon as doctor_type_icon, price as doctor_base_price, discount as doctor_discount, price-(discount/100 *price) as doctor_total_price from doctor_type1 where active = 1";
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "doctor_type_id", "doctor_type_name" ,"doctor_type_icon","doctor_base_price","doctor_discount","doctor_total_price"});
		jdbcTemplate.query(query, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
	}

}
