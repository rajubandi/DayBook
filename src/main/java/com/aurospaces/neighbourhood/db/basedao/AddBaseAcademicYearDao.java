
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

import com.aurospaces.neighbourhood.bean.AcademicYearBean;


public class AddBaseAcademicYearDao{

	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO academicyear( created_time, updated_time, name,status) values (?, ?, ?,?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final AcademicYearBean academicYearBean) 
	{
	if(academicYearBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(academicYearBean.getCreatedTime() == null)
					{
					academicYearBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(academicYearBean.getCreatedTime().getTime()); 
							
					if(academicYearBean.getUpdatedTime() == null)
					{
					academicYearBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(academicYearBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =	connection.prepareStatement(INSERT_SQL,new String[]{"id"});
											ps.setTimestamp(1, createdTime);
											ps.setTimestamp(2, updatedTime);
											ps.setString(3, academicYearBean.getName());
											ps.setInt(4, academicYearBean.getStatus());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				academicYearBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE academicyear  set updated_time = ? ,name = ?,status=?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{academicYearBean.getUpdatedTime(),academicYearBean.getName(),academicYearBean.getStatus(),academicYearBean.getId()});
		}
	}
		
		@Transactional
		public void delete(String status,int id) {
			String sql = "Update academicyear set status=? WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{status,id});
		}
		

		@Transactional
		public void activateAcademicYear(int id) {
			//String sql = "Update academicyear set status=? WHERE id=?";
			String sql = "UPDATE academicyear SET status = CASE WHEN id=? THEN 1 ELSE 0 END";
			jdbcTemplate.update(sql, new Object[]{id});
		}
	
	 /*public AddBoardBean existingOrNot(String name ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name from boardname where name ='"+name + "'");
		
		 String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}*/

	

}
