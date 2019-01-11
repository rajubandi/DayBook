package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.FacultyBean;
import com.aurospaces.neighbourhood.bean.FacultySubjectsBean;
import com.aurospaces.neighbourhood.db.model.AdminDiscount;


public class BaseFacultySubjects{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO facultysubjects( created_time, updated_time, facultyId, boardId,mediumId,classId,sectionId,subjectId) values (?, ?, ?, ?, ?,?,?,?)";
 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final FacultySubjectsBean facultyBean) 
	{
	if(facultyBean.getId() == 0)	{
		System.out.println("subject id "+facultyBean.getSubject());

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(facultyBean.getCreatedTime() == null)
					{
					facultyBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(facultyBean.getCreatedTime().getTime()); 
							
					if(facultyBean.getUpdatedTime() == null)
					{
					facultyBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(facultyBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, facultyBean.getFacultyId());
ps.setString(4, facultyBean.getBoardName());
ps.setString(5, facultyBean.getMedium());
ps.setString(6, facultyBean.getClassName());
ps.setString(7, facultyBean.getSection());
ps.setString(8, facultyBean.getSubject());
System.out.println(ps);
							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				facultyBean.setId(unId.intValue());
				

		}
		else
		{
		 
			String sql = "UPDATE facultysubjects  set facultyId = ? ,boardId = ? ,mediumId = ? ,classId = ? ,sectionId = ?,subjectId = ?  "
					+ " where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{facultyBean.getFacultyId(),facultyBean.getBoardName(),facultyBean.getMedium(),
					facultyBean.getClassName(),facultyBean.getSection(),facultyBean.getSubject(),facultyBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM facultysubjects WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public FacultySubjectsBean getById(int id) {
			String sql = "SELECT * from facultysubjects where id = ? ";
			List<FacultySubjectsBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(FacultySubjectsBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
