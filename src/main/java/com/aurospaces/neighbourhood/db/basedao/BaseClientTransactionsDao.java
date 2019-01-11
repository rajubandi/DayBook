
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

import com.aurospaces.neighbourhood.db.model.ClientTransactions;


public class BaseClientTransactionsDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO client_transactions( created_time, updated_time, client_id, ac_number, bank_name, branch_name, ifsc_code, transaction_date, amount) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ClientTransactions clientTransactions) 
	{
	if(clientTransactions.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(clientTransactions.getCreatedTime() == null)
					{
					clientTransactions.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(clientTransactions.getCreatedTime().getTime()); 
							
					if(clientTransactions.getUpdatedTime() == null)
					{
					clientTransactions.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(clientTransactions.getUpdatedTime().getTime()); 
							
					if(clientTransactions.getTransactionDate() == null)
					{
					clientTransactions.setTransactionDate( new Date());
					}
					java.sql.Timestamp transactionDate = 
						new java.sql.Timestamp(clientTransactions.getTransactionDate().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, clientTransactions.getClientId());
ps.setInt(4, clientTransactions.getAcNumber());
ps.setString(5, clientTransactions.getBankName());
ps.setString(6, clientTransactions.getBranchName());
ps.setString(7, clientTransactions.getIfscCode());
ps.setTimestamp(8, transactionDate);
ps.setInt(9, clientTransactions.getAmount());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				clientTransactions.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE client_transactions  set client_id = ? ,ac_number = ? ,bank_name = ? ,branch_name = ? ,ifsc_code = ? ,transaction_date = ? ,amount = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{clientTransactions.getClientId(),clientTransactions.getAcNumber(),clientTransactions.getBankName(),clientTransactions.getBranchName(),clientTransactions.getIfscCode(),clientTransactions.getTransactionDate(),clientTransactions.getAmount(),clientTransactions.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM client_transactions WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public ClientTransactions getById(int id) {
			String sql = "SELECT * from client_transactions where id = ? ";
			List<ClientTransactions> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ClientTransactions.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
