
package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BasePartnerDao;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.Partner;

@Repository(value = "partnerDao")
public class PartnerDao extends BasePartnerDao {
	public Partner getPartnerDetails(Partner objPartner) {
		Partner objjPartner = null;
		try {
			String sql = "SELECT * FROM partner   WHERE  email='" + objPartner.getEmail() + "' and password='"
					+ objPartner.getPassword() + "'";
			List<Partner> retlist = jdbcTemplate.query(sql, new Object[] {},
					ParameterizedBeanPropertyRowMapper.newInstance(Partner.class));
			if (retlist != null && retlist.size() > 0) {
				System.out.println(retlist.size());
				objjPartner = retlist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objjPartner;
	}

	public List<Partner> getAll() {
		List<Partner> list = null;
		try {
			String sql = "SELECT * FROM partner";
			list = jdbcTemplate.query(sql, new Object[] {},
					ParameterizedBeanPropertyRowMapper.newInstance(Partner.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}
}
