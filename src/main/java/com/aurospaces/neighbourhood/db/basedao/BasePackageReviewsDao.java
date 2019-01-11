
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.db.model.PackageReviews;


public class BasePackageReviewsDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO package_reviews( created_time, updated_time, service_unit_id, name, profile_pic, review) values (?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final PackageReviews packageReviews) 
	{
	if(packageReviews.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(packageReviews.getCreatedTime() == null)
					{
					packageReviews.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(packageReviews.getCreatedTime().getTime()); 
							
					if(packageReviews.getUpdatedTime() == null)
					{
					packageReviews.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(packageReviews.getUpdatedTime().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, packageReviews.getServiceUnitId());
ps.setString(4, packageReviews.getName());
ps.setString(5, packageReviews.getProfilePic());
ps.setString(6, packageReviews.getReview());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				packageReviews.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE package_reviews  set service_unit_id = ? ,name = ? ,profile_pic = ? ,review = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{packageReviews.getServiceUnitId(),packageReviews.getName(),packageReviews.getProfilePic(),packageReviews.getReview(),packageReviews.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM package_reviews WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public PackageReviews getById(int id) {
			String sql = "SELECT * from package_reviews where id = ? ";
			List<PackageReviews> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(PackageReviews.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
