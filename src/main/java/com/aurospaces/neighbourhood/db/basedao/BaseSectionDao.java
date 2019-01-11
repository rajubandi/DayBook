
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

import com.aurospaces.neighbourhood.bean.ClassBean;
import com.aurospaces.neighbourhood.bean.SectionCreationBean;


public class BaseSectionDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO sectiontable( created_time, updated_time, name, classId, boardId) values (?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final SectionCreationBean  objClassBean) 
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
ps.setString(3, objClassBean.getSection());
ps.setString(4, objClassBean.getClassId());
ps.setString(5, objClassBean.getBoardId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				objClassBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE sectiontable  set boardid = ?,classid = ?, name= ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{objClassBean.getBoardId(),objClassBean.getClassId(),objClassBean.getSection(),objClassBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM sectiontable WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	/* public AdminDiscount getById(int id) {
			String sql = "SELECT * from classcreation where id = ? ";
			List<AdminDiscount> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AdminDiscount.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
*/
	

}
