package com.aurospaces.neighbourhood.db.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ExpensesBean;
import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.db.basedao.BaseLedgerDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "LedgerDao")
public class LedgerDao  extends BaseLedgerDao{
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

	 public StudentBean duplicateCheckStudent(String adminsionNumber) {
			String sql = "SELECT * from student where admissionNum = ? ";
			List<StudentBean> retlist = jdbcTemplate.query(sql,
			new Object[]{adminsionNumber},
			ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	public List<Map<String, Object>> getDayWiseExpenses() {
		
		
		//String sql = "select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,sum(amount)  as amount from ledger group by date(dairydate)"  ;
		String sql = "select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,discription,amount,monthName(curdate()) as monthName from ledger where MONTH(dairydate) = MONTH(CURDATE()) ";
		List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{});
		System.out.println(sql);
		if(retlist.size() > 0)
			return retlist;
		return null;
	}
	 public List<Map<String, Object>> dailyExpensesBetweentwoDate(String from, String to,String academicYearId) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
			Date date1 = formatter.parse(from.toString());
			Date date2 = formatter.parse(to.toString());
			
			java.sql.Timestamp fromdate = 
					new java.sql.Timestamp(date1.getTime()); 
			java.sql.Timestamp todate = 
					new java.sql.Timestamp(date2.getTime());
			
			//String sql = " select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,sum(sf.amount) as amount from ledger sf where date(dairydate) between  Date('"+fromdate+"')  AND Date('"+todate+"') group by daTE(dairydate)"  ;
			String sql = "select id,DATE_format(dairydate,'%d-%M-%Y') as strDate,discription, amount from ledger sf where  date(dairydate) between  Date('"+fromdate+"')  AND Date('"+todate+"') and academicYearId=?"  ;
			List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{academicYearId});
			System.out.println(sql);
			if(retlist.size() > 0)
				return retlist;
			return null;
		}

	 

}
