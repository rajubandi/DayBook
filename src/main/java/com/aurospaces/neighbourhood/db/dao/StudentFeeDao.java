package com.aurospaces.neighbourhood.db.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.db.basedao.BaseStudentFeeDao;

@Repository(value = "StudentFeeDao")
public class StudentFeeDao extends BaseStudentFeeDao {	

	public List<Map<String,Object>> dfCollection() {
		/* 
		 * date wise query
		 * select DATE(created_time),sum(sf.fee) as Fee from studentfee sf where date(created_time) between '2018-06-29' AND '2018-07-29' group by daTE(created_time)
		 *
		 */
		//String sql = " select ifnull(sum(sf.fee),0.00) as total,DATE_format(now(),'%d-%M-%Y') as createdTime from studentfee sf where DATE(paymentDate)=DATE(now())"  ;
		
		String sql = "select DATE_format(date,'%d-%M-%Y') as date,client,description,paidamount from collections where DATE(date) = CAST(CURRENT_TIMESTAMP AS DATE)";
		
		List<Map<String,Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{}	);
		if(retlist.size() > 0)
			return retlist;
		return null;
	}

	public List<Map<String,Object>> dfCollectionBetweenTwoDates(Date from, Date to) throws ParseException {
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		//Date date1 = formatter.parse(from.toString());
		//Date date2 = formatter.parse(to.toString());		
		
		java.sql.Timestamp fromdate = new java.sql.Timestamp(from.getTime()); 
		java.sql.Timestamp todate = new java.sql.Timestamp(to.getTime());
		
		//String sql = " select DATE_format(paymentDate,'%d-%M-%Y') as createdTime,sum(sf.fee) as amount from studentfee sf where date(paymentDate) between Date('"+fromdate+"')  AND Date('"+todate+"') group by daTE(paymentDate)"  ;
		String sql = "select DATE_format(date,'%d-%M-%Y') as date,client,description,paidamount from collections where date(date) between Date('"+fromdate+"')  AND Date('"+todate+"')";
		
		List<Map<String,Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
		System.out.println(sql);
		if(retlist.size() > 0)
			return retlist;
		return null;
	}
}