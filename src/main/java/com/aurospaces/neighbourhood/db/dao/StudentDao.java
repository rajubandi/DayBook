package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.db.basedao.BaseStudentDao;

@Repository(value = "StudentDao")
public class StudentDao  extends BaseStudentDao{	 

	public List<Map<String, Object>> getFeesAndExpenses() {
		//jdbcTemplate = jdbcTemplate.getJdbcTemplate();
		 
		 /*String sql="select 'Total Amount' as totalFees, sum(s.netFee) as amount from student s where s.academicYearId = ? " 
				 + " union all  select 'Fee Collection' as totalFees, sum(sf.fee) as amount from studentfee sf where sf.academicYearId = ? " 
				 + " union all select 'Expenses' as toatalFees, sum(l.amount) as amount from ledger l where l.academicYearId = ? " ;*/
		
		String sql = "select 'Total Amount' as totalFees, sum(s.fullamount) as amount from collections s " + 
				" union all " + 
				" select 'Fee Collection' as totalFees, sum(sf.paidamount) as amount from collections sf " + 
				" union all " + 
				" select 'Expenses' as toatalFees, sum(l.amount) as amount from ledger l " ;
		   
		 List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{});		 
			return retlist;
	}

	public List<Map<String, Object>> getExpensessummary( ) {
		//jdbcTemplate = jdbcTemplate.getJdbcTemplate();
		 
		 /*String sql="select ah.name as accountHead ,sum(l.amount) as amount from ledger l,accounthead ah where l.accountHeadId = ah.id and academicYearId= ? GROUP BY accountHead " ;*/
		   
		String sql = "select ah.name as accountHead ,sum(l.amount) as amount from ledger l,accounthead ah  " 
		             +  "  where l.accountHeadId = ah.id GROUP BY accountHead  " ;
		 
		 
		 List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{});		
		 return retlist;
	}	 
}