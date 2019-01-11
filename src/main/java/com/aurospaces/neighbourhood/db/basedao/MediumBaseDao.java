
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aurospaces.neighbourhood.bean.AddBoardBean;
import com.aurospaces.neighbourhood.bean.MediumBean;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;


public class MediumBaseDao{

	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO mediam( created_time, updated_time, name) values (?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final MediumBean mediumBean) 
	{
	if(mediumBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(mediumBean.getCreatedTime() == null)
					{
						mediumBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(mediumBean.getCreatedTime().getTime()); 
							
					if(mediumBean.getUpdatedTime() == null)
					{
						mediumBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(mediumBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
	ps.setTimestamp(2, updatedTime);
	ps.setString(3, mediumBean.getName());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				mediumBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE mediam  set updated_time = ? ,name = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{mediumBean.getUpdatedTime(),mediumBean.getName(),mediumBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM mediam WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public MediumBean getById(int id) {
			String sql = "SELECT * from mediam where id = ?";
			List<MediumBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(MediumBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	
	 /*public List<Map<String, String>> existingOrNot(String name ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name from mediam where name ='"+name + "'");
		
		 String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}*/

	

}
