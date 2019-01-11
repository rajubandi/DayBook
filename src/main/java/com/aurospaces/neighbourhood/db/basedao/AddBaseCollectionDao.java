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
import com.aurospaces.neighbourhood.bean.CollectionBean;

public class AddBaseCollectionDao {

	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO collections( date, client, description, amount) values (?, ?, ?, ?)"; 

	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final CollectionBean addAccountHeadBean) 
	{
		if(addAccountHeadBean.getId()== 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, addAccountHeadBean.getDate());
	ps.setString(2, addAccountHeadBean.getClient());
	ps.setString(3, addAccountHeadBean.getDescription());
	ps.setString(4, addAccountHeadBean.getAmount());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				//addAccountHeadBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE collections  set date = ? ,client = ? ,description = ?,amount = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{addAccountHeadBean.getDate(),addAccountHeadBean.getClient(),addAccountHeadBean.getDescription(),addAccountHeadBean.getAmount(),addAccountHeadBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM collections WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public CollectionBean getById(int id) {
			String sql = "SELECT * from collections where id = ?";
			List<CollectionBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(CollectionBean.class));
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


