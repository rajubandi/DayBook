package com.aurospaces.neighbourhood.db.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.db.basedao.BaseLedgerDao;


@Repository(value = "LedgerDao")
public class LedgerDao  extends BaseLedgerDao{												

	public List<Map<String, Object>> getDayWiseExpenses() {		
		
		//String sql = "select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,sum(amount)  as amount from ledger group by date(dairydate)"  ;
		String sql = "select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,discription,amount,monthName(curdate()) as monthName from ledger where MONTH(dairydate) = MONTH(CURDATE()) ";
		List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{});
		System.out.println(sql);
		if(retlist.size() > 0)
			return retlist;
		return null;
	}
	
	 public List<Map<String, Object>> dailyExpensesBetweentwoDate(String from, String to) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
			Date date1 = formatter.parse(from.toString());
			Date date2 = formatter.parse(to.toString());
			
			java.sql.Timestamp fromdate = 
					new java.sql.Timestamp(date1.getTime()); 
			java.sql.Timestamp todate = 
					new java.sql.Timestamp(date2.getTime());
			
			//String sql = " select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,sum(sf.amount) as amount from ledger sf where date(dairydate) between  Date('"+fromdate+"')  AND Date('"+todate+"') group by daTE(dairydate)"  ;
			String sql = "select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,discription, amount from ledger sf where  date(dairydate) between  Date('"+fromdate+"')  AND Date('"+todate+"') "  ;
			List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{});
			System.out.println(sql);
			if(retlist.size() > 0)
				return retlist;
			return null;
		}	 
}