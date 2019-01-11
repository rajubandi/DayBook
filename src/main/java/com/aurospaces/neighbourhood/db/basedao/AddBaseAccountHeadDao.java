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

import com.aurospaces.neighbourhood.bean.AddAccountHeadBean;


public class AddBaseAccountHeadDao{

	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO accounthead( created_time, updated_time, name) values (?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final AddAccountHeadBean addAccountHeadBean) 
	{
		if(addAccountHeadBean.getId()== 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(addAccountHeadBean.getCreatedTime() == null)
					{
						addAccountHeadBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(addAccountHeadBean.getCreatedTime().getTime()); 
							
					if(addAccountHeadBean.getUpdatedTime() == null)
					{
						addAccountHeadBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(addAccountHeadBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
	ps.setTimestamp(2, updatedTime);
	ps.setString(3, addAccountHeadBean.getName());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				//addAccountHeadBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE accounthead  set updated_time = ? ,name = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{addAccountHeadBean.getUpdatedTime(),addAccountHeadBean.getName(),addAccountHeadBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM accounthead WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public AddAccountHeadBean getById(int id) {
			String sql = "SELECT * from accounthead where id = ?";
			List<AddAccountHeadBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AddAccountHeadBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
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

