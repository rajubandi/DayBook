
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

import com.aurospaces.neighbourhood.db.model.OrderSequence;


public class BaseOrderSequenceDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO order_sequence( service_id, sequence_string) values (?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final OrderSequence orderSequence) 
	{
	if(orderSequence.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setInt(1, orderSequence.getServiceId());
ps.setString(2, orderSequence.getSequenceString());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				orderSequence.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE order_sequence  set service_id = ? ,sequence_string = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{orderSequence.getServiceId(),orderSequence.getSequenceString(),orderSequence.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM order_sequence WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public OrderSequence getById(int id) {
			String sql = "SELECT * from order_sequence where id = ? ";
			List<OrderSequence> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderSequence.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
