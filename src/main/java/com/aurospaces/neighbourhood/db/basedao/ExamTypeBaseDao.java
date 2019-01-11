package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.ExamTypeBean;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

public class ExamTypeBaseDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public final String INSERT_SQL = "INSERT INTO exam_type( created_time, updated_time, examType) values ( ?, ?, ?)";

	@Transactional
	public void save(final ExamTypeBean examTypeBean) {
		if (examTypeBean.getId() == 0) {

			KeyHolder keyHolder = new GeneratedKeyHolder();
			int update = jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

					if (examTypeBean.getCreatedTime() == null) {
						examTypeBean.setCreatedTime(new Date());
					}
					java.sql.Timestamp createdTime = new java.sql.Timestamp(examTypeBean.getCreatedTime().getTime());

					if (examTypeBean.getCreatedTime() == null) {
						examTypeBean.setCreatedTime(new Date());
					}
					java.sql.Timestamp updatedTime = new java.sql.Timestamp(examTypeBean.getCreatedTime().getTime());

					PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
					ps.setTimestamp(1, createdTime);
					ps.setTimestamp(2, updatedTime);
					ps.setString(3, examTypeBean.getExamType());

					return ps;
				}
			}, keyHolder);

			Number unId = keyHolder.getKey();
			examTypeBean.setId(unId.intValue());

		} else {

			String sql = "UPDATE exam_type  set examType = ?  where id = ? ";

			jdbcTemplate.update(sql, new Object[] { examTypeBean.getExamType(), examTypeBean.getId() });
		}
	}

	@Transactional
	public void delete(int id) {
		String sql = "DELETE FROM exam_type WHERE id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	public List<Map<String, String>> getExamType() {
		StringBuffer objStringBuffer = new StringBuffer();
		objStringBuffer.append("select * from exam_type");

		String sql = objStringBuffer.toString();
		System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id", "examType" });
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;

	}
	
	 public ExamTypeBean recordExistOrNot(ExamTypeBean examTypeBean) {
			String sql = "SELECT * from exam_type where examType=? ";
			List<ExamTypeBean> retlist = jdbcTemplate.query(sql,
			new Object[]{examTypeBean.getExamType()},
			ParameterizedBeanPropertyRowMapper.newInstance(ExamTypeBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
 
	

}
