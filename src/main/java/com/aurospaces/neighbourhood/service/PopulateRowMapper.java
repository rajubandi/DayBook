/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aurospaces.neighbourhood.bean.PopulateBean;

/**
 * @author Naresh
 * 
 */
public class PopulateRowMapper implements RowMapper<PopulateBean> {

	@Override
	public PopulateBean mapRow(ResultSet rs, int arg1) throws SQLException {
		PopulateBean ps = new PopulateBean();
		ps.setId(rs.getString(1));
		ps.setName(rs.getString(2));
		return ps;
	}

}
