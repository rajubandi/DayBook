
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

import com.aurospaces.neighbourhood.bean.BusRouteBean;
import com.aurospaces.neighbourhood.db.model.User;


public class BaseBusRouteDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO busroute( createdTime, updatedTime, routeName) values (?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final BusRouteBean busRouteBean) 
	{
	if(busRouteBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(busRouteBean.getCreatedTime() == null)
					{
					busRouteBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(busRouteBean.getCreatedTime().getTime()); 
							
					if(busRouteBean.getUpdatedTime() == null)
					{
					busRouteBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(busRouteBean.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
							ps.setTimestamp(1, createdTime);
							ps.setTimestamp(2, updatedTime);
							ps.setString(3, busRouteBean.getRouteName());
							//ps.setDouble(4, busRouteBean.getBusFee());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				busRouteBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE busroute  set updatedTime = ? ,routeName = ?   where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{busRouteBean.getUpdatedTime(),busRouteBean.getRouteName(),busRouteBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM busroute WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public BusRouteBean getById(int id) {
			String sql = "SELECT * from busroute where id = ? ";
			List<BusRouteBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(BusRouteBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
