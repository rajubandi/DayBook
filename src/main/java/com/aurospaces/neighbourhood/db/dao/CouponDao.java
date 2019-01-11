
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseCouponDao;
import com.aurospaces.neighbourhood.db.model.Coupon;

@Repository(value = "couponDao")
public class CouponDao extends BaseCouponDao {
	
	public Coupon getByCouponCodeId(int id) {
		String sql = "SELECT * from coupon where coupon_code_id = ? ";
		List<Coupon> retlist = jdbcTemplate.query(sql,
		new Object[]{id},
		ParameterizedBeanPropertyRowMapper.newInstance(Coupon.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}
}
