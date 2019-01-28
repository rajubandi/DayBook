package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.ExpensesBean;

public class BaseLedgerDao{

@Autowired public JdbcTemplate jdbcTemplate;
 
	public final String INSERT_SQL = "INSERT INTO ledger( createdTime,updatedTime,accountHeadId,discription,amount,dairydate ) values (?, ?,?, ?, ?, ?)";
 
	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public boolean save(final ExpensesBean expensesBean) 
	{
		boolean insert = false;
		try{
	if(expensesBean.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(expensesBean.getCreatedTime() == null)
					{
					expensesBean.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(expensesBean.getCreatedTime().getTime()); 
					
					if(expensesBean.getUpdatedTime() == null)
					{
					expensesBean.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(expensesBean.getUpdatedTime().getTime()); 					
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
										ps.setTimestamp(1, createdTime);
									ps.setTimestamp(2, updatedTime);
									ps.setString(3, expensesBean.getAccountHeadId());
									ps.setString(4, expensesBean.getDiscription());
									ps.setString(5, expensesBean.getAmount());
									ps.setTimestamp(6, new java.sql.Timestamp(expensesBean.getDairydate().getTime()));
									
									System.out.println(ps);
							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				expensesBean.setId(unId.intValue());				

		}
		else
		{
		 
			String sql = "UPDATE ledger  set  updatedTime=?,accountHeadId=?, discription=?,amount=?,dairydate=? where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{expensesBean.getUpdatedTime(), expensesBean.getAccountHeadId(), expensesBean.getDiscription(),expensesBean.getAmount(),expensesBean.getDairydate(),expensesBean.getId()});
		}
	insert= true;
		}catch(Exception e){
			System.out.println(e);
			insert= false;
		}
	return insert;
	}
		
		@Transactional
		public void delete(String  id) {
			String sql = "DELETE FROM ledger WHERE id in(" + id + " )";
			jdbcTemplate.update(sql, new Object[]{});
		}		

	 public ExpensesBean getById(int id) {
			String sql = "SELECT * from ledger where id = ? ";
			List<ExpensesBean> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(ExpensesBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 
	 public List<ExpensesBean> getExpensesBeanAll(String date) throws ParseException {
		 
		
		 StringBuffer buffer = new StringBuffer();
		 buffer.append("SELECT ld.*,ah.name as accountHead, DATE_FORMAT(Date(ld.dairydate),'%d-%M-%Y') as strDate from ledger ld, accounthead ah where ld.accountHeadId = ah.id ");
		 
		/* if (StringUtils.isNotBlank(academicYearId)) {
			 
			 buffer.append(" and academicYearId="+ academicYearId);
			}*/
		 if (StringUtils.isNotBlank(date)) {
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
				Date date1 = formatter.parse(date.toString());
			 buffer.append(" and Date(ld.dairydate)= Date('" + new java.sql.Timestamp(date1.getTime())+"')");
			}else {
				
				buffer.append(" and Date(ld.dairydate)=CURDATE()");
			}
		
			String sql = buffer.toString();
			List<ExpensesBean> retlist = jdbcTemplate.query(sql,new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(ExpensesBean.class));
			if(retlist.size() > 0)
				return retlist;
			return null;
		}	
}