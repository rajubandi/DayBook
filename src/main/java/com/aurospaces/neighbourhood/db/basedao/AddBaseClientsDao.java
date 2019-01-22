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

import com.aurospaces.neighbourhood.bean.ClientDetailsBean;
import com.aurospaces.neighbourhood.bean.CollectionBean;

public class AddBaseClientsDao {

	@Autowired public JdbcTemplate jdbcTemplate;
	java.sql.Timestamp createdTime,updatedTime,createdDueTime,updatedDueTime;
	//String dueAmountInSave,dueAmountInUpdate;
		 
	public final String INSERT_SQL = "INSERT INTO clients( clientName, phoneNumber, mail, address, fullamount, createddate, duedate) values (?, ?, ?, ?, ?, ?, ?)"; 

	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final ClientDetailsBean addAccountHeadBean) 
	{
		if(addAccountHeadBean.getId()== 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {	
						
						if(addAccountHeadBean.getCreateddate() == null)
						{
							addAccountHeadBean.setCreateddate( new Date());
						}
						createdTime = new java.sql.Timestamp(addAccountHeadBean.getCreateddate().getTime()); 
						
						if(addAccountHeadBean.getDuedate() == null)
						{
							addAccountHeadBean.setDuedate( new Date());
						}
						createdDueTime = new java.sql.Timestamp(addAccountHeadBean.getDuedate().getTime());
						
						/*int dueAmtInSave = Integer.parseInt(addAccountHeadBean.getFullamount())   - Integer.parseInt(addAccountHeadBean.getPaidamount());
						dueAmountInSave = String.valueOf(dueAmtInSave);*/
	
					PreparedStatement ps =	connection.prepareStatement(INSERT_SQL,new String[]{"id"});
					ps.setString(1, addAccountHeadBean.getClientName());
					
	ps.setString(2, addAccountHeadBean.getPhoneNumber());
	ps.setString(3, addAccountHeadBean.getMail());
	ps.setString(4, addAccountHeadBean.getAddress());
	ps.setString(5, addAccountHeadBean.getFullamount());
	//ps.setString(6, addAccountHeadBean.getPaidamount());
	ps.setTimestamp(6, createdTime);
	ps.setTimestamp(7, createdDueTime);
	
	/*if (dueAmtInSave==0) {
		ps.setTimestamp(7, null);
	} else {
		ps.setTimestamp(7, createdDueTime);
	}*/	

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				//addAccountHeadBean.setId(unId.intValue());
				

		}
		else
		{		
			updatedTime = new java.sql.Timestamp(addAccountHeadBean.getCreateddate().getTime());	
			updatedDueTime = new java.sql.Timestamp(addAccountHeadBean.getDuedate().getTime());
			
			/*int dueAmtInUpdate = Integer.parseInt(addAccountHeadBean.getFullamount())   - Integer.parseInt(addAccountHeadBean.getPaidamount());
			dueAmountInUpdate = String.valueOf(dueAmtInUpdate);*/

			String sql = "UPDATE clients  set clientName = ? ,phoneNumber = ? ,mail = ?,address = ?,fullamount = ?,createddate = ?,duedate = ?  where id = ? ";	
			
			jdbcTemplate.update(sql, new Object[]{addAccountHeadBean.getClientName(),addAccountHeadBean.getPhoneNumber(),addAccountHeadBean.getMail(),addAccountHeadBean.getAddress(),addAccountHeadBean.getFullamount(),updatedTime,updatedDueTime,addAccountHeadBean.getId()});
			
			/*if (dueAmtInUpdate==0) {
			jdbcTemplate.update(sql, new Object[]{addAccountHeadBean.getClientName(),addAccountHeadBean.getPhoneNumber(),addAccountHeadBean.getMail(),addAccountHeadBean.getAddress(),addAccountHeadBean.getFullamount(),addAccountHeadBean.getPaidamount(),updatedTime,null,addAccountHeadBean.getId()});
			} else {
			jdbcTemplate.update(sql, new Object[]{addAccountHeadBean.getClientName(),addAccountHeadBean.getPhoneNumber(),addAccountHeadBean.getMail(),addAccountHeadBean.getAddress(),addAccountHeadBean.getFullamount(),addAccountHeadBean.getPaidamount(),updatedTime,updatedDueTime,addAccountHeadBean.getId()});
			}*/
			
			}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM clients WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}		

	 public ClientDetailsBean getById(int id) {
			String sql = "SELECT * from clients where id = ?";
			List<ClientDetailsBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ClientDetailsBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}	

}