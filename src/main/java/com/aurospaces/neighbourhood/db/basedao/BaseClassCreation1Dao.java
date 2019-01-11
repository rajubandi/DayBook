
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

import com.aurospaces.neighbourhood.bean.ClassCreationBean;


public class BaseClassCreation1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO classtable( created_time, updated_time, name, boardid) values (?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ClassCreationBean objClassBean) 
	{
	if(objClassBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(objClassBean.getCreatedTime() == null)
					{
					objClassBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(objClassBean.getCreatedTime().getTime()); 
							
					if(objClassBean.getUpdatedTime() == null)
					{
					objClassBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(objClassBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, objClassBean.getClassName());
ps.setString(4, objClassBean.getBoardId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				objClassBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE classtable  set  name = ?, Boardid = ? where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{objClassBean.getClassName(),objClassBean.getBoardId(),objClassBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM classtable WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

}
