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

import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.bean.UsersBean;


public class BaseUsersDao1{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO users( created_time, updated_time, name,password,rolId) values (?,?,?,?,?)";
 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final UsersBean usersBean) 
	{
	if(usersBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(usersBean.getCreatedTime() == null)
					{
					usersBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(usersBean.getCreatedTime().getTime()); 
							
				
					if(usersBean.getUpdatedTime() == null)
					{
					usersBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(usersBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, usersBean.getName());
ps.setString(4, usersBean.getPassword());
ps.setString(5, usersBean.getRolId());

System.out.println(ps);
							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				usersBean.setId(unId.intValue());
				

		}
		else
		{
		 
			/*String sql = "UPDATE student  set name=?,boardName=?,medium=?,className=?,section=?,rollNum=?,admissionNum=?,fatherName=?,mobile=?,"
					+ " alternativeMobile=?,email=?,blodgroup=?,gender=?,region=?,address=?,previousInstitue=?,caste=?,acomitation=?,"
					+ " buspesility=?,busroute=?,religion=?,totalFee=?,imagePath=?,discountFee=?,netFee=?  "
					+ " where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{usersBean.getName(),usersBean.getBoardName(),usersBean.getMedium(),usersBean.getClassName(),
					usersBean.getSection(),usersBean.getRollNum(),usersBean.getAdmissionNum(),usersBean.getFatherName(),usersBean.getMobile(),
					usersBean.getAlternativeMobile(),usersBean.getEmail(),usersBean.getBlodgroup(),usersBean.getGender(),
					usersBean.getRegion(),usersBean.getAddress(),usersBean.getPreviousInstitue(),usersBean.getCaste(),usersBean.getAcomitation(),
					usersBean.getBuspesility(),usersBean.getBusroute(),usersBean.getReligion(),usersBean.getTotalFee(),usersBean.getImagePath(),usersBean.getDiscountFee(),usersBean.getNetFee(),
					usersBean.getId()});*/
		}
	}
		
		@Transactional
		public void delete(String  id) {
			String sql = "DELETE FROM users WHERE id in(" + id + " )";
			jdbcTemplate.update(sql, new Object[]{});
		}
		

	 public UsersBean getById(int id) {
			String sql = "SELECT * from users where id = ? ";
			List<UsersBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(UsersBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 public List<StudentBean> getByIdAll() {
			String sql = "SELECT * from users  ";
			List<StudentBean> retlist = jdbcTemplate.query(sql,
			new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
			if(retlist.size() > 0)
				return retlist;
			return null;
		}
	

}
