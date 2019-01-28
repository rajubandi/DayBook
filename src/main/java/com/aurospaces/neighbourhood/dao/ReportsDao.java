package com.aurospaces.neighbourhood.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.db.basedao.BaseReportsDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

	@Repository(value = "ReportsDao")
	public class ReportsDao  extends BaseReportsDao{
		 public List<Map<String, String>> getallStudentDetails(){
			 StringBuffer objStringBuffer = new StringBuffer();
			 objStringBuffer.append("select distinct(s.id ) as studentId, DATE_FORMAT( Date(s.dob),'%d-%M-%Y') as dob,DATE_FORMAT( Date(s.admissionDate),'%d-%M-%Y') as admissionDate ,s.fatherName,s.fatherOccupation,s.motherName,s.motherOccupation,s.adharNumber ,s.name as studentName,bn.name as boardName,m.name as mediumName,s.rollNum,s.admissionNum, "
						+" s.caste,s.acomitation,s.buspesility,s.busroute,s.admissionFee,s.tutionFee,s.transportationFee,s.hostelFee,s.stationaryFee,s.religion,s.totalFee,s.discountFee,m.id as mediumId,bn.id as boardId,imagePath,"
						+ "ct.name as className,se.name as sectionName,ct.id as classId,se.id as sectionId,s.mobile,s.alternativeMobile,s.email,s.blodgroup,s.gender,s.region,s.address,s.previousInstitue  from "
						+" student s,boardname bn,mediam m,sectiontable se,classtable ct where "
						+" s.boardName=bn.id and s.medium=m.id and s.className=ct.id and s.section = se.id ");
			
	String sql = objStringBuffer.toString();
				System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "studentId","dob","admissionDate","fatherName","fatherOccupation","motherName",
						"motherOccupation","adharNumber","studentName","boardName","mediumName","rollNum","admissionNum",
						"caste","acomitation","buspesility","busroute","admissionFee","tutionFee","transportationFee","hostelFee",
						"stationaryFee","religion","totalFee","discountFee","mediumId","boardId","imagePath","className","sectionName","classId","sectionId","mobile","alternativeMobile","email","blodgroup","gender","region","address","previousInstitue"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}		

		public List<Map<String, Object>> getDayWiseExpenses() {			
			
			//String sql = "select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,sum(amount)  as amount from ledger group by date(dairydate)"  ;
			String sql = "select ld.id,ah.name as accountHead,DATE_format(ld.dairydate,'%d-%M-%Y') as strDate,ld.discription,ld.amount,monthName(curdate()) as monthName from ledger ld ,accounthead ah  where MONTH(dairydate) = MONTH(CURDATE()) and ld.accountHeadId = ah.id ";
			List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{});
			System.out.println(sql);
			if(retlist.size() > 0)
				return retlist;
			return null;
		}
		
		 public List<Map<String, Object>> reportsdailyExpensesBetweentwoDate(String from, String to,String accounthead,String month) throws ParseException {
			
				 StringBuffer objStringBuffer = new StringBuffer();
				//String sql = " select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,sum(sf.amount) as amount from ledger sf where date(dairydate) between  Date('"+fromdate+"')  AND Date('"+todate+"') group by daTE(dairydate)"  ;
				 objStringBuffer.append("select ld.id, ah.name as accountHead, DATE_format(ld.dairydate,'%d-%M-%Y') as strDate,ld.discription, ld.amount from ledger ld,accounthead ah   where  ld.accountHeadId = ah.id " ) ;
				 if (StringUtils.isNotBlank(from) && StringUtils.isNotBlank(to)) {
					 
					 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
						Date date1 = formatter.parse(from.toString());
						Date date2 = formatter.parse(to.toString());
						
						java.sql.Timestamp fromdate = 
								new java.sql.Timestamp(date1.getTime()); 
						java.sql.Timestamp todate = 
								new java.sql.Timestamp(date2.getTime());
						
					 objStringBuffer.append(" and date(ld.dairydate) between  Date('"+fromdate+"')  and Date('"+todate+"')");
				 }
				 
				 if (StringUtils.isNotBlank(accounthead)) {
					 
					 objStringBuffer.append("  and ld.accountHeadId="+accounthead);
				 }
				 if (StringUtils.isNotBlank(month)) {
					 
					 SimpleDateFormat formatter1 = new SimpleDateFormat("MM/yyyy");
					// DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yyyy");
						Date mon1 = formatter1.parse(month.toString());
						java.sql.Date onlyMon = new java.sql.Date(mon1.getTime()); 
						
						Calendar cal = Calendar.getInstance();
						cal.setTime(onlyMon);
						java.text.SimpleDateFormat df1 = new java.text.SimpleDateFormat("MM");
						String month2= df1.format(cal.getTime());
						//String month1 =formatter1.format( cal.get(Calendar.MONTH));
						
						//int day = cal.get(Calendar.DAY_OF_MONTH);
						int year = cal.get(Calendar.YEAR);
						
					 //objStringBuffer.append("  and MONTH(ld.dairydate) = MONTH('"+month1+"') and YEAR(ld.dairydate) = YEAR('"+year+"')");
						objStringBuffer.append("  and MONTH(ld.dairydate) ='" +month2+"' and YEAR(ld.dairydate) =" +year);
				 }
				 
				 String sql = objStringBuffer.toString();
				List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{});
				System.out.println(sql);
				//System.out.println(sql);
				if(retlist.size() > 0)
					return retlist;
				return null;
			} 

	}