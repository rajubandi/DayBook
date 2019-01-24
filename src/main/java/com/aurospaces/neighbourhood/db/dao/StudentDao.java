/*package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.db.basedao.BaseStudentDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "StudentDao")
public class StudentDao  extends BaseStudentDao{
	 public List<Map<String, String>> getallStudentDetails(String boardName,String medium,String className,String section,String email,	String caste,String admissionNum,String studentName,String mobile,String status){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select distinct(s.id ) as studentId, DATE_FORMAT( Date(s.dob),'%d-%M-%Y') as dob,DATE_FORMAT( Date(s.admissionDate),'%d-%M-%Y') as admissionDate ,s.fatherName,s.fatherOccupation,s.motherName,s.motherOccupation,s.adharNumber ,s.name as studentName,bn.name as boardName,m.name as mediumName,s.rollNum,s.admissionNum, "
					+" s.caste,s.acomitation,s.buspesility,s.busroute,s.admissionFee,s.tutionFee,s.transportationFee,s.hostelFee,s.stationaryFee,s.religion,s.totalFee,s.discountFee,m.id as mediumId,bn.id as boardId,imagePath,"
					+ "ct.name as className,se.name as sectionName,ct.id as classId,se.id as sectionId,s.mobile,s.alternativeMobile,s.email,s.blodgroup,s.gender,s.region,s.address,s.previousInstitue, ay.name as academicyear,s.academicyearId,s.termOne,s.termTwo,s.termThree   from "
					+" student s,boardname bn,mediam m,sectiontable se,classtable ct , academicyear ay where "
					+" s.boardName=bn.id and s.medium=m.id and s.className=ct.id and s.section = se.id ");
		
		 if (StringUtils.isNotBlank(boardName)) {
			objStringBuffer.append(" and bn.id=" + boardName);
		}
		if (StringUtils.isNotBlank(className)) {
			objStringBuffer.append(" and ct.id=" + className);
		}
		if (StringUtils.isNotBlank(medium)) {
			objStringBuffer.append(" and m.id=" + medium);
		}
		if (StringUtils.isNotBlank(section)) {
			objStringBuffer.append(" and se.id=" + section);
		}
		if (StringUtils.isNotBlank(email)) {
			objStringBuffer.append("  and  s.email = '"+ email+"' " );
		}
		if (StringUtils.isNotBlank(caste)) {
			objStringBuffer.append("  and  s.caste  LIKE '%"+ caste +"%'");
		}
		if (StringUtils.isNotBlank(admissionNum)) {
			objStringBuffer.append(" and s.admissionNum=" + admissionNum);
		}
		if (StringUtils.isNotBlank(studentName)) {
			objStringBuffer.append("  and  s.name  LIKE '%"+ studentName +"%'" );
		}
		if (StringUtils.isNotBlank(mobile)) {
			objStringBuffer.append("  and  s.mobile =" + mobile );
		}
		if (StringUtils.isNotBlank(academicYearId)) {
			objStringBuffer.append("  and  s.academicYearId =" + academicYearId );
		}
		if (StringUtils.isNotBlank(status)) {
			objStringBuffer.append(" and s.status=" + status);
		}else {
			objStringBuffer.append(" and s.status=1 ");
			}
			objStringBuffer.append(" order by s.created_time desc " );
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "studentId","dob","admissionDate","fatherName","fatherOccupation","motherName",
					"motherOccupation","adharNumber","studentName","boardName","mediumName","rollNum","admissionNum",
					"caste","acomitation","buspesility","busroute","admissionFee","tutionFee","transportationFee","hostelFee",
					"stationaryFee","religion","totalFee","discountFee","mediumId","boardId","imagePath","className","sectionName","classId","sectionId","mobile","alternativeMobile","email","blodgroup","gender","region","address","previousInstitue","termOne","termTwo","termThree"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	 
	 public StudentBean getBordId(String boardName) {
			String sql = "SELECT * from boardname where name = ? ";
			List<StudentBean> retlist = jdbcTemplate.query(sql,
			new Object[]{boardName},
			ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 
	 public StudentBean getMediumId(String mediumName) {
			String sql = "SELECT * from mediam where name = ? ";
			List<StudentBean> retlist = jdbcTemplate.query(sql,
			new Object[]{mediumName},
			ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 
	 public StudentBean getClassId(String className) {
			String sql = "SELECT * from classtable where name = ? ";
			List<StudentBean> retlist = jdbcTemplate.query(sql,
			new Object[]{className},
			ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 
	 public StudentBean getSectionId(String sectionName) {
			String sql = "SELECT * from sectiontable where name = ? ";
			List<StudentBean> retlist = jdbcTemplate.query(sql,
			new Object[]{sectionName},
			ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
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
	 
	 public List<Map<String, String>> getBordId1(String boardName){
		
String sql = "selec"
			//System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "studentId","studentName","boardName","mediumName","rollNum","admissionNum",
					"fatherName","mobile","alternativeMobile","email","blodgroup","gender","region"
					,"address","previousInstitue","caste","acomitation","buspesility","busroute","religion","fee","mediumId","boardId","imagePath"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	 
	public StudentBean duplicateCheckStudentAadhar(String adharNumber) {
		
		String sql = "SELECT * from student where adharNumber = ? ";
		List<StudentBean> retlist = jdbcTemplate.query(sql,
		new Object[]{adharNumber},
		ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}

	public List<Map<String, Object>> getFeesAndExpenses(Integer academicYearId) {
		//jdbcTemplate = jdbcTemplate.getJdbcTemplate();
		
		select 'Total Amount' as totalFees, sum(s.fullamount) as amount from collections s  
			union all  select 'Fee Collection' as totalFees, sum(sf.paidamount) as amount from collections sf   
			union all select 'Expenses' as toatalFees, sum(l.amount) as amount from ledger l
		 * 
		 * 
		 
		 String sql="select 'Total Amount' as totalFees, sum(s.netFee) as amount from student s where s.academicYearId = ? " 
				 + " union all  select 'Fee Collection' as totalFees, sum(sf.fee) as amount from studentfee sf where sf.academicYearId = ? " 
				 + " union all select 'Expenses' as toatalFees, sum(l.amount) as amount from ledger l where l.academicYearId = ? " ;
		   
		 List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{academicYearId,academicYearId,academicYearId});
		 //System.out.println(sql);
			return retlist;
	}

	public List<Map<String, Object>> getExpensessummary(Integer academicYearId) {
		//jdbcTemplate = jdbcTemplate.getJdbcTemplate();
		 
		
		 * 


			select ah.name as accountHead ,sum(l.amount) as amount from ledger l,accounthead ah where l.accountHeadId = ah.id 
			GROUP BY accountHead
		 * 
		 * 
		
		 String sql="select ah.name as accountHead ,sum(l.amount) as amount from ledger l,accounthead ah where l.accountHeadId = ah.id and academicYearId= ? GROUP BY accountHead " ;
		   
		 List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{academicYearId});
		 //System.out.println(sql);
			return retlist;
	}
}*/