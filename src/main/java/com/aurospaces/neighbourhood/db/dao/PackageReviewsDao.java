
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BasePackageReviewsDao;
import com.aurospaces.neighbourhood.db.model.PackageReviews;
import com.aurospaces.neighbourhood.db.model.ServiceUnitHappiness;




@Repository(value = "packageReviewsDao")
public class PackageReviewsDao extends BasePackageReviewsDao
{
	public PackageReviews getByServiceUnitId(int id) {
		String sql = "SELECT * from package_reviews where service_unit_id = ? ";
		List<PackageReviews> retlist = jdbcTemplate.query(sql,
		new Object[]{id},
		ParameterizedBeanPropertyRowMapper.newInstance(PackageReviews.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}


}

