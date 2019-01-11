package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.StudentBean;

public class BaseSubjectDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public final String INSERT_SQL = "INSERT INTO subject( created_time, updated_time, name) values ( ?, ?, ?)";

	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final StudentBean studentBean) {
		if (studentBean.getId() == 0) {

			KeyHolder keyHolder = new GeneratedKeyHolder();
			int update = jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

					if (studentBean.getCreatedTime() == null) {
						studentBean.setCreatedTime(new Date());
					}
					java.sql.Timestamp createdTime = new java.sql.Timestamp(studentBean.getCreatedTime().getTime());

					if (studentBean.getUpdatedTime() == null) {
						studentBean.setUpdatedTime(new Date());
					}
					java.sql.Timestamp updatedTime = new java.sql.Timestamp(studentBean.getUpdatedTime().getTime());

					PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
					ps.setTimestamp(1, createdTime);
					ps.setTimestamp(2, updatedTime);
					ps.setString(3, studentBean.getName());

					return ps;
				}
			}, keyHolder);

			Number unId = keyHolder.getKey();
			studentBean.setId(unId.intValue());

		} else {

			String sql = "UPDATE subject  set name = ?  where id = ? ";

			jdbcTemplate.update(sql, new Object[] { studentBean.getName(), studentBean.getId() });
		}
	}

	@Transactional
	public void delete(int id) {
		String sql = "DELETE FROM subject WHERE id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	
}
