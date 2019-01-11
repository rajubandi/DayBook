
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

import com.aurospaces.neighbourhood.bean.ClassSubjectBean;


public class AddClassSubjectBaseDao{

	@Autowired public JdbcTemplate jdbcTemplate;

	 
	public final String INSERT_SQL = "INSERT INTO classsubjects( created_time, updated_time,boardId,classId,subjectId) values (?,?,?,?,?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ClassSubjectBean subjectBean) 
	{
	if( subjectBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if( subjectBean.getCreatedTime() == null)
					{
					 subjectBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp( subjectBean.getCreatedTime().getTime()); 
							
					if( subjectBean.getUpdatedTime() == null)
					{
					 subjectBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp( subjectBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
	ps.setTimestamp(2, updatedTime);
	ps.setString(3,  subjectBean.getBoardId());
	ps.setString(4,  subjectBean.getClassId());
	ps.setString(5,  subjectBean.getSubjectId());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				 subjectBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE classsubjects  set updated_time = ? ,boardId=?,classId=?,subjectId=?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{ subjectBean.getUpdatedTime(), subjectBean.getBoardId(),subjectBean.getClassId(),subjectBean.getSubjectId(),subjectBean.getId()});
		}
	}
	
	@Transactional
	public void delete(int id) {
		boolean result=false;
		String sql = "DELETE FROM classsubjects WHERE id=?";
		int iresult=jdbcTemplate.update(sql, new Object[]{id});
		if(iresult>0) {
			result=true;
		}
	}
	
		/*@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM boardname WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public AddBoardBean getById(int id) {
			String sql = "SELECT * from boardname where id = ?";
			List<AddBoardBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AddBoardBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	
	 public List<Map<String, String>> existingOrNot(String name ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name from boardname where name ='"+name + "'");
		
		 String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
*/
	

}
