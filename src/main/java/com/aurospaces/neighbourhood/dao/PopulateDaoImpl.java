/**
 * Copyright MNTSOFT 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PopulateBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
import com.aurospaces.neighbourhood.service.PopulateRowMapper;

/**
 * @author Amith
 * 
 */
@Repository
public class PopulateDaoImpl extends DaoSupport implements PopulateDao {
	private Logger logger = Logger.getLogger(PopulateDaoImpl.class);

	@Override
	public List<PopulateBean> populate(String sql) {
		List<PopulateBean> list = null;
		try {
			list = getJdbcTemplate().query(sql, new PopulateRowMapper());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			logger.fatal("error in populate in PopulateDaoImpl");
		} finally {

		}
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer DuplicateCheck(String sql) {
		int i = 0;
		try {
			i = getJdbcTemplate().queryForInt(sql);

		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.fatal("error in DuplicateCheck in PopulateDaoImpl");
		} finally {

		}
		return i;
	}

	
}
