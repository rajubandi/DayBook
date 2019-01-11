
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseCluster1Dao;
import com.aurospaces.neighbourhood.db.model.Cluster1;
import com.aurospaces.neighbourhood.db.model.Vendor1;




@Repository(value = "cluster1Dao")
public class Cluster1Dao extends BaseCluster1Dao
{

	public List<Cluster1> getAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from cluster1 ";
		List<Cluster1> retlist = jdbcTemplate.query(sql,
		new Object[]{},
		BeanPropertyRowMapper.newInstance(Cluster1.class));
		return retlist;
	}



}

