
package com.aurospaces.neighbourhood.db.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.db.basedao.BaseCity1Dao;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;

@Repository(value = "city1Dao")
public class City1Dao extends BaseCity1Dao {
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public Map<String, String> getAll() {
		KeyValueCallbackHandler handler = new KeyValueCallbackHandler("id", "name");
		String query = "SELECT id  , name  from city1	";
		jdbcTemplate.query(query, handler);
		return handler.getResult();
	}
}
