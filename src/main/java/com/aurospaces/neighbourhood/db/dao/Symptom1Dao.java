
package com.aurospaces.neighbourhood.db.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseSymptom1Dao;
import com.aurospaces.neighbourhood.db.model.Symptom1;


import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import java.util.List;


@Repository(value = "symptom1Dao")
public class Symptom1Dao extends BaseSymptom1Dao
{


	public List<Symptom1> getAll()
	{

		String query = "select * from symptom1 where active = 1";

		List<Symptom1> retlist = jdbcTemplate.query(query,
		new Object[]{},
		ParameterizedBeanPropertyRowMapper.newInstance(Symptom1.class));
		return retlist;
  }

}
