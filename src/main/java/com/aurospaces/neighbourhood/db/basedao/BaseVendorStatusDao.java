
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

import com.aurospaces.neighbourhood.db.model.VendorStatus;


public class BaseVendorStatusDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO vendor_status( statusname) values (?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final VendorStatus vendorStatus) 
	{
	if(vendorStatus.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setString(1, vendorStatus.getStatusname());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				vendorStatus.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE vendor_status  set statusname = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{vendorStatus.getStatusname(),vendorStatus.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM vendor_status WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public VendorStatus getById(int id) {
			String sql = "SELECT * from vendor_status where id = ? ";
			List<VendorStatus> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(VendorStatus.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
