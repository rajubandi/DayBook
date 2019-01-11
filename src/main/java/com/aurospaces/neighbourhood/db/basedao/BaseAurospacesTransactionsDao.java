
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

import com.aurospaces.neighbourhood.db.model.AurospacesTransactions;


public class BaseAurospacesTransactionsDao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO aurospaces_transactions( created_time, updated_time, vendor_id, ac_number, bank_name, branch_name, ifsc_code, transaction_date, amount) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final AurospacesTransactions aurospacesTransactions) 
	{
	if(aurospacesTransactions.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(aurospacesTransactions.getCreatedTime() == null)
					{
					aurospacesTransactions.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(aurospacesTransactions.getCreatedTime().getTime()); 
							
					if(aurospacesTransactions.getUpdatedTime() == null)
					{
					aurospacesTransactions.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(aurospacesTransactions.getUpdatedTime().getTime()); 
							
					if(aurospacesTransactions.getTransactionDate() == null)
					{
					aurospacesTransactions.setTransactionDate( new Date());
					}
					java.sql.Timestamp transactionDate = 
						new java.sql.Timestamp(aurospacesTransactions.getTransactionDate().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setInt(3, aurospacesTransactions.getVendorId());
ps.setInt(4, aurospacesTransactions.getAcNumber());
ps.setString(5, aurospacesTransactions.getBankName());
ps.setString(6, aurospacesTransactions.getBranchName());
ps.setString(7, aurospacesTransactions.getIfscCode());
ps.setTimestamp(8, transactionDate);
ps.setInt(9, aurospacesTransactions.getAmount());

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				aurospacesTransactions.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE aurospaces_transactions  set vendor_id = ? ,ac_number = ? ,bank_name = ? ,branch_name = ? ,ifsc_code = ? ,transaction_date = ? ,amount = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{aurospacesTransactions.getVendorId(),aurospacesTransactions.getAcNumber(),aurospacesTransactions.getBankName(),aurospacesTransactions.getBranchName(),aurospacesTransactions.getIfscCode(),aurospacesTransactions.getTransactionDate(),aurospacesTransactions.getAmount(),aurospacesTransactions.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM aurospaces_transactions WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public AurospacesTransactions getById(int id) {
			String sql = "SELECT * from aurospaces_transactions where id = ? ";
			List<AurospacesTransactions> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(AurospacesTransactions.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
