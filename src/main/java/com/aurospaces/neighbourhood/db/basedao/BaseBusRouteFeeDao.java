
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


public class BaseBusRouteFeeDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO busroutefees( createdTime, updatedTime,boardId,classId,sectionId,mediumId,routeId,busFee) values (?, ?, ?,?,?,?,?,?)"; 

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
							ps.setString(3, busRouteBean.getBoardId());
							ps.setString(4, busRouteBean.getClassId());
							ps.setString(5, busRouteBean.getSectionId());
							ps.setString(6, busRouteBean.getMediumId());
							ps.setString(7, busRouteBean.getRouteId());
							ps.setDouble(8, busRouteBean.getBusFee());
							

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				busRouteBean.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE busroutefees  set updatedTime = ? ,boardId = ?,classId = ?,sectionId = ?,mediumId = ?,routeId = ?,busFee = ?   where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{busRouteBean.getUpdatedTime(),busRouteBean.getBoardId(),busRouteBean.getClassId(),busRouteBean.getSectionId(),busRouteBean.getMediumId(),busRouteBean.getRouteId(),busRouteBean.getBusFee(),busRouteBean.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM busroutefees WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public BusRouteBean getById(int id) {
			String sql = "SELECT * from busroutefees where id = ? ";
			List<BusRouteBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(BusRouteBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
