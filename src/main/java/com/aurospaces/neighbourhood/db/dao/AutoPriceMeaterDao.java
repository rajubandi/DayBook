package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseAutoPriceMeaterDao;
import com.aurospaces.neighbourhood.db.model.AutoPriceMeater;

@Repository(value = "autoPriceMeaterDao")
public class AutoPriceMeaterDao extends BaseAutoPriceMeaterDao {
	 public AutoPriceMeater getByGendrtatedId(String order_id) {
			String sql = "SELECT * from auto_price_meater where generated_id = ? ORDER BY created_time DESC LIMIT 1 ";
			List<AutoPriceMeater> retlist = jdbcTemplate.query(sql,
			new Object[]{order_id},
			ParameterizedBeanPropertyRowMapper.newInstance(AutoPriceMeater.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

}
