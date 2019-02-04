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

import com.aurospaces.neighbourhood.bean.CollectionBean;

public class AddBaseCollectionDao {

	@Autowired public JdbcTemplate jdbcTemplate;
	java.sql.Timestamp createdTime,updatedTime,createdDueTime,updatedDueTime;
	//java.sql.Date createdDate, updatedDate,createdDueDate,updatedDueDate;
	String dueAmountInSave,dueAmountInUpdate;
	//java.sql.Date sqlStartDate;
	 
	public final String INSERT_SQL = "INSERT INTO collections( date, client, description, fullamount, paidamount, dueamount, duedate, clientid) values (?, ?, ?, ?, ?, ?, ?, ?)"; 

	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final CollectionBean addAccountHeadBean, final String clientName, final int paidAmount, final int clientId, final String fullAmount) 
	{		
		
		if(addAccountHeadBean.getId()== 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
						
						/*// create a java calendar instance
						Calendar calendar = Calendar.getInstance();

						// get a java date (java.util.Date) from the Calendar instance.
						// this java date will represent the current date, or "now".
						java.util.Date currentDate = calendar.getTime();

						// now, create a java.sql.Date from the java.util.Date
						java.sql.Date date = new java.sql.Date(currentDate.getTime());
						System.out.println("Converted sql formated date: " +date);*/						
						
						if(addAccountHeadBean.getDate() == null)
						{
							addAccountHeadBean.setDate( new Date());
						}
						createdTime = new java.sql.Timestamp(addAccountHeadBean.getDate().getTime()); 
						
						if(addAccountHeadBean.getDuedate() == null)
						{
							addAccountHeadBean.setDuedate( new Date());
						}
						createdDueTime = new java.sql.Timestamp(addAccountHeadBean.getDuedate().getTime());
						
						//createdDate = addAccountHeadBean.getDate();
						//createdDueDate = addAccountHeadBean.getDuedate();
						//createdTime = new java.sql.Timestamp(addAccountHeadBean.getDate().getTime());
						
						 int dueAmtInSave = Integer.parseInt(fullAmount) - Integer.parseInt(addAccountHeadBean.getPaidamount()) ;
						 int afterRemoveallPaidAmnts = dueAmtInSave - paidAmount;
						 System.out.println("Due amount in save: " +afterRemoveallPaidAmnts);
						 dueAmountInSave = String.valueOf(afterRemoveallPaidAmnts);						 
						 
						 /*String startDate="19-01-2019";
						 SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");
						 java.util.Date date2;
						try {
							date2 = sdf1.parse(startDate);
							sqlStartDate = new java.sql.Date(date2.getTime());
							
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						  
						 
					PreparedStatement ps =	connection.prepareStatement(INSERT_SQL,new String[]{"id"});
					ps.setTimestamp(1, createdTime);
					//ps.setDate(1, createdDate);					
	ps.setString(2, clientName);
	ps.setString(3, addAccountHeadBean.getDescription());
	ps.setString(4, fullAmount);
	ps.setString(5, addAccountHeadBean.getPaidamount());
	ps.setString(6, dueAmountInSave);
	
	if (dueAmtInSave==0) {
		ps.setTimestamp(7, null);
	} else {
		ps.setTimestamp(7, createdDueTime);
	}
	
	ps.setInt(8, clientId);
	

							return ps;
						}
				},
				keyHolder);
				
				//Number unId = keyHolder.getKey();
				//addAccountHeadBean.setId(unId.intValue());				

		}
		else
		{		
			
			updatedTime = new java.sql.Timestamp(addAccountHeadBean.getDate().getTime());	
			updatedDueTime = new java.sql.Timestamp(addAccountHeadBean.getDuedate().getTime());
			
			int dueAmtInUpdate = Integer.parseInt(fullAmount) - Integer.parseInt(addAccountHeadBean.getPaidamount());
			
			int afterRemoveallPaidAmnts = dueAmtInUpdate - paidAmount;			
			System.out.println("Due amount in update: " +afterRemoveallPaidAmnts);
			dueAmountInUpdate = String.valueOf(afterRemoveallPaidAmnts);			
			
			//updatedDate = addAccountHeadBean.getDate();
			//updatedDueDate = addAccountHeadBean.getDuedate();

			String sql = "UPDATE collections  set date = ? ,client = ? ,description = ?,fullamount = ?,paidamount = ?,dueamount = ?,duedate = ?,clientid = ? where id = ? ";
	
			if (dueAmtInUpdate==0) {
				jdbcTemplate.update(sql, new Object[]{updatedTime,clientName,addAccountHeadBean.getDescription(),fullAmount,addAccountHeadBean.getPaidamount(),dueAmountInUpdate,null,clientId,addAccountHeadBean.getId()});
			} else {
				jdbcTemplate.update(sql, new Object[]{updatedTime,clientName,addAccountHeadBean.getDescription(),fullAmount,addAccountHeadBean.getPaidamount(),dueAmountInUpdate,updatedDueTime,clientId,addAccountHeadBean.getId()});
			}
			
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM collections WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public CollectionBean getById(int id) {
			String sql = "SELECT * from collections where id = ?";
			List<CollectionBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(CollectionBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

}