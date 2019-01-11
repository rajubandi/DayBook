
package com.aurospaces.neighbourhood.db.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseOrderSequenceDao;
import com.aurospaces.neighbourhood.db.model.OrderSequence;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;


@Repository(value = "orderSequenceDao")
public class OrderSequenceDao extends BaseOrderSequenceDao
{


	 public OrderSequence getByServiceId(String serviceId) {
			String sql = "SELECT * from order_sequence  where service_id in ( ? , 0) order by service_id desc limit 1";
			System.out.println("DEBUG " + sql);
			List<OrderSequence> retlist = jdbcTemplate.query(sql,
			new Object[]{serviceId},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderSequence.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}


}

