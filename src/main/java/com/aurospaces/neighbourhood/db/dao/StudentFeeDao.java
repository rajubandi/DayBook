package com.aurospaces.neighbourhood.db.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.bean.StudentFeeBean;
import com.aurospaces.neighbourhood.db.basedao.BaseStudentFeeDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "StudentFeeDao")
public class StudentFeeDao extends BaseStudentFeeDao {
	public List<Map<String, String>> getallStudentsFee(String studetnId, String boardId, String classId,
			String sectionId, String mediamId,String academicYearId) {
		StringBuffer objStringBuffer = new StringBuffer();
		objStringBuffer
				.append("select sf.paymentDate as feeDate, s.boardName as boardId, s.medium as mediumId, s.className as classId, s.section as sectionId, sf.id,s.id as studentId, s.name as studentName,bn.name as boardName,st.name sectionName,m.name mediumName,"
						+ "sf.fee,sf.admissionFee,sf.tutionFee,sf.transportationFee,sf.hostelFee,sf.stationaryFee,ct.name as className ,s.fatherName,s.mobile, sf.dueFee1 as dueFee,s.netFee, u.name as cashier, sf.invoiceId as invoiceId , ay.name as academicyear,sf.academicyearId"
						+ " from student s,classtable ct,sectiontable st,mediam m,boardname bn ,studentfee sf, users u, academicyear ay  where s.className=ct.id and st.id=s.section "
						+ " and s.medium=m.id and bn.id=s.boardName and sf.studentId=s.id and sf.userId = u.id  and sf.academicYearId=ay.id and" 
						+ " sf.paymentDate = (SELECT max(paymentDate) FROM studentfee sf2 WHERE sf.studentId=sf2.studentId)");
		if (StringUtils.isNotBlank(studetnId)) {
			objStringBuffer.append(" and s.id=" + studetnId);
		}
		if (StringUtils.isNotBlank(boardId)) {
			objStringBuffer.append(" and bn.id=" + boardId);
		}
		if (StringUtils.isNotBlank(classId)) {
			objStringBuffer.append(" and ct.id=" + classId);
		}
		if (StringUtils.isNotBlank(sectionId)) {
			objStringBuffer.append(" and st.id=" + sectionId);
		}
		if (StringUtils.isNotBlank(mediamId)) {
			objStringBuffer.append(" and m.id=" + mediamId);
		}
		if (StringUtils.isNotBlank(academicYearId)) {
			objStringBuffer.append("  and  sf.academicYearId =" + academicYearId );
		}
		String sql = objStringBuffer.toString();
		System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(
				new String[] { "feeDate","boardName","mediumId","boardId","classId","sectionId", "id", "studentId", "studentName", "boardName", "sectionName", "mediumName",
						"fee","admissionFee","tutionFee","transportationFee","hostelFee","stationaryFee","className", "fatherName", "mobile","dueFee","netFee","cashier", "invoiceId" });
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;

	}

	public List<Map<String, Object>> getViwStudentFee(String studentId,String boardId,String classId,String sectionId,String mediumId,String academicYearId) {
		StringBuffer objStringBuffer = new StringBuffer();
		objStringBuffer.append("select s.id,ifnull(sf.paymentDate,'---') as feeDate,s.netFee,s.mobile,s.fatherName,s.totalFee,s.discountFee,s.boardName as boardId, " + 
				"bn.name as boardName,s.section as sectionId,st.name as sectionName,s.medium as mediumId,m.name as mediumName,s.className as classId, " + 
				"ct.name as className,  " + 
				"sum(ifnull(sf.fee,0)) as fee,s.netFee-sum(ifnull(sf.fee,0)) as dueFee,s.admissionFee-sum(ifnull(sf.admissionFee,0)) as admissionFee,  " + 
				"s.tutionFee-sum(ifnull(sf.tutionFee,0)) as tutionFee,s.transportationFee-sum(ifnull(sf.transportationFee,0)) as transportationFee,  " + 
				"s.hostelFee as netTotalTerms,s.hostelFee-sum(ifnull(sf.hostelFee,0)) AS AllTermDuehostelFee, " + 
				"s.termOne as netTermOne,sum(ifnull(sf.termOne,0)) as paidTermOne,s.termOne-sum(ifnull(sf.termOne,0)) as dueTermOne , " + 
				"s.termTwo as netTermTwo,sum(ifnull(sf.termTwo,0)) as paidTermTwo,s.termTwo-sum(ifnull(sf.termTwo,0)) as dueTermTwo , " + 
				"s.termThree as netTermThree,sum(ifnull(sf.termThree,0)) as paidTermThree,s.termThree-sum(ifnull(sf.termThree,0)) as dueTermThree," + 
				"s.stationaryFee-sum(ifnull(sf.stationaryFee,0)) AS stationaryFee,s.name as studentName, " + 
				"ay.name as academicYear ,s.academicYearId,   " + 
				"s.termOne-sum(ifnull(sf.termOne,0)) AS termOne , s.termTwo-sum(ifnull(sf.termTwo,0)) AS termTwo, " + 
				"s.termThree-sum(ifnull(sf.termThree,0)) AS termThree  " + 
				"from student s left join studentfee sf   on s.id =sf.studentId left join boardname bn on bn.id=s.boardName  " + 
				"left join sectiontable st on st.id=s.section left join classtable ct on s.className=ct.id left join mediam m on s.medium=m.id " + 
				" left join academicyear ay on s.academicYearId = ay.id  " + 
				"where  1=1   ");
		if (StringUtils.isNotBlank(studentId)) {
			objStringBuffer.append(" and s.id=" + studentId);
		}
		if (StringUtils.isNotBlank(boardId)) {
			objStringBuffer.append(" and bn.id=" + boardId);
		}
		if (StringUtils.isNotBlank(classId)) {
			objStringBuffer.append(" and ct.id=" + classId);
		}
		if (StringUtils.isNotBlank(sectionId)) {
			objStringBuffer.append(" and st.id=" + sectionId);
			
		}
		if (StringUtils.isNotBlank(mediumId)) {
			objStringBuffer.append(" and m.id=" + mediumId);
		}
		if (StringUtils.isNotBlank(academicYearId)) {
			
			objStringBuffer.append(" and s.academicYearId=" + academicYearId);
		}
		objStringBuffer.append("  GROUP BY s.id ");      

		String sql = objStringBuffer.toString();
		// System.out.println(sql);
//		RowValueCallbackHandler handler = new RowValueCallbackHandler(
//				new String[] { "feeDate", "id", "studentId", "studentName", "boardName", "sectionName", "mediumName",
//							"fee","admissionFee","tutionFee","transportationFee","hostelFee","stationaryFee","className", "fatherName", "mobile", "totalFee", "discountFee","dueFee","netFee" });
		System.out.println(sql);
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		return result;

	}

	public StudentFeeBean getDueFee(String studentId) {
		String sql = "select s.id,s.netFee as netFee,s.netFee-sum(ifnull(sf.fee,0)) as dueFee,sum(ifnull(sf.fee,0)) as totalPaidFee,s.admissionFee-sum(ifnull(sf.admissionFee,0))   as admissionFee, " + 
				"s.tutionFee-sum(ifnull(sf.tutionFee,0)) as tutionFee,s.transportationFee-sum(ifnull(sf.transportationFee,0)) as transportationFee, " + 
				"s.hostelFee-sum(ifnull(sf.hostelFee,0)) AS hostelFee,s.stationaryFee-sum(ifnull(sf.stationaryFee,0)) AS stationaryFee,s.name, " + 
				" s.termOne-sum(ifnull(sf.termOne,0)) AS termOne , s.termTwo-sum(ifnull(sf.termTwo,0)) AS termTwo, s.termThree-sum(ifnull(sf.termThree,0)) AS termThree "+
				"from student s left join studentfee sf   on s.id =sf.studentId where  s.id=? group by s.id ";
		List<StudentFeeBean> retlist = jdbcTemplate.query(sql, new Object[] { studentId },
				ParameterizedBeanPropertyRowMapper.newInstance(StudentFeeBean.class));
		if (retlist.size() > 0)
			return retlist.get(0);
		return null;
	}

	public List<Map<String, String>> getPrintFee(int studentfeeId) {
		StringBuffer objStringBuffer = new StringBuffer();
		objStringBuffer
				.append("select  s.id,s.name as studentName,ct.name as className,st.name as sectionName,bn.name as boardName,m.name as medium,sf.fee,sf.paymentDate,s.totalfee, s.discountfee,s.netfee "
						+ ",sf.admissionFee,sf.tutionFee,sf.transportationFee,sf.hostelFee,sf.stationaryFee,s.fatherName,s.mobile,sf.dueFee1 as dueFee, u.name as cashier, sf.invoiceId as invoiceId from studentfee sf,boardname bn ,classtable ct,sectiontable st,mediam m ,student s, users u where s.id=sf.studentId and ct.id = s.className and st.id=s.section "
						+ " and m.id=s.medium and s.boardName =bn.id and sf.userId = u.id   ");
		if (studentfeeId != 0) {
			objStringBuffer.append(" and sf.id=" + studentfeeId);
		}

		String sql = objStringBuffer.toString();
		// System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(
				new String[] { "id", "studentName", "className", "boardName", "sectionName", "medium", "fee",
						"paymentDate", "totalfee", "discountfee", "netfee","admissionFee","tutionFee","transportationFee","hostelFee","stationaryFee","fatherName", "mobile","dueFee", "cashier","invoiceId" });
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;

	}
	public List<Map<String, Object>> getHistoryFee(int studentfeeId) {

		String sql ="select s.netFee-(select sum(sf1.fee) from studentfee sf1 where sf.studentId =sf1.studentId) as dueFee, sf.*,DATE_FORMAT( Date(sf.paymentDate),'%d-%M-%Y') as createdate,s.name,s.fatherName,s.mobile,bn.name as boardName,st.name as sectionName," + 
				"m.name as mediumName,sf.dueFee1,ct.name as className from student s,classtable ct,sectiontable st,mediam m,boardname bn ,studentfee sf where s.id =sf.studentId and " + 
				"s.className=ct.id and st.id=s.section and m.id=s.medium and bn.id=s.boardName and ct.id=s.className and s.id=?" ;
				
		
		List<Map<String, Object>> retlist = jdbcTemplate.queryForList(sql, new Object[] { studentfeeId });
		if (retlist.size() > 0)
			return retlist;
		return null;

	}
	
	 public StudentFeeBean editStudentFee(String studentId,int id) {
			String sql = "select ifnull(sum(sf.fee),0.00) as fee, ifnull(s.admissionFee,0.00)-ifnull(sum(sf.admissionFee),0.00) as admissionFee,ifnull(s.tutionFee,0.00)- ifnull(sum(sf.tutionFee),0.00) as tutionFee," 
					+ " ifnull(s.transportationFee,0.00)-ifnull(sum(sf.transportationFee),0.00) as transportationFee,ifnull(s.hostelFee,0.00)- ifnull(sum(sf.hostelFee),0.00) as hostelFee," 
					+ "ifnull(s.stationaryFee,0.00)-ifnull(sum(sf.stationaryFee),0.00) as stationaryFee, ifnull(s.netFee,0.00)-ifnull(sum(fee),0.00) as dueFee" 
					+ " from studentfee sf, student s where sf.studentId=s.id and s.id=? and sf.id not in(?)" ;
			System.out.println(sql);
			List<StudentFeeBean> retlist = jdbcTemplate.query(sql,	new Object[]{studentId,id},	ParameterizedBeanPropertyRowMapper.newInstance(StudentFeeBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 @Transactional
		public void delete(int id) {
			String sql = "DELETE FROM studentfee WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
	 
	/* public StudentFeeBean editUserStudentFee(String studentId,int id) {
			String sql = "select ifnull(sum(sf.fee),0.00) as fee, ifnull(s.admissionFee,0.00)-ifnull(sum(sf.admissionFee),0.00) as admissionFee,ifnull(s.tutionFee,0.00)- ifnull(sum(sf.tutionFee),0.00) as tutionFee," 
					+ " ifnull(s.transportationFee,0.00)-ifnull(sum(sf.transportationFee),0.00) as transportationFee,ifnull(s.hostelFee,0.00)- ifnull(sum(sf.hostelFee),0.00) as hostelFee," 
					+ "ifnull(s.stationaryFee,0.00)-ifnull(sum(sf.stationaryFee),0.00) as stationaryFee, ifnull(s.netFee,0.00)-ifnull(sum(fee),0.00) as dueFee" 
					+ " from studentfee sf, student s where sf.studentId=s.id and s.id=? and sf.id not in(?)" ;
			System.out.println(sql);
			List<StudentFeeBean> retlist = jdbcTemplate.query(sql,	new Object[]{studentId,id},	ParameterizedBeanPropertyRowMapper.newInstance(StudentFeeBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	*/
	 public StudentFeeBean getTotalfee(String studentId,int id) {
			String sql = "select ifnull(sum(fee),0.00) as fee from studentfee where studentId =? and id not in(?)"  ;
			List<StudentFeeBean> retlist = jdbcTemplate.query(sql,	new Object[]{studentId,id},	ParameterizedBeanPropertyRowMapper.newInstance(StudentFeeBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	 
	 public StudentFeeBean getTotalIndividualfeeByStudentId(int studentId) {
			String sql = "select ifnull(sum(fee),0.0) as fee,ifnull(sum(admissionFee),0.0) as admissionFee ,ifnull(sum(tutionFee),0.0) as tutionFee,ifnull(sum(transportationFee) ,0.0)as transportationFee ,ifnull(sum(hostelFee),0.0) as hostelFee,ifnull(Sum(stationaryFee),0.0) as stationaryFee, ifnull(sum(dueFee1) ,0.0)as dueFee1  from studentfee where studentId =?"  ;
			List<StudentFeeBean> retlist = jdbcTemplate.query(sql,	new Object[]{studentId},	ParameterizedBeanPropertyRowMapper.newInstance(StudentFeeBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	public List<Map<String,Object>> dfCollection() {
		/* 
		 * date wise query
		 * select DATE(created_time),sum(sf.fee) as Fee from studentfee sf where date(created_time) between '2018-06-29' AND '2018-07-29' group by daTE(created_time)
		 *
		 */
		//String sql = " select ifnull(sum(sf.fee),0.00) as total,DATE_format(now(),'%d-%M-%Y') as createdTime from studentfee sf where DATE(paymentDate)=DATE(now())"  ;
		
		String sql = "select s.name,ct.name as className,m.name as medium ,sf.admissionFee,sf.tutionFee ,sf.transportationFee,sf.hostelFee,sf.stationaryFee,sf.fee as total,DATE_format(now(),'%d-%M-%Y') as createdTime " 
		+" from studentfee sf ,classtable ct,mediam m ,student s where  sf.studentId = s.id and s.className = ct.id and s.medium = m.id and DATE(paymentDate)=DATE(now())";
		List<Map<String,Object>> retlist = jdbcTemplate.queryForList(sql,new Object[]{}	);
		if(retlist.size() > 0)
			return retlist;
		return null;
	}

	public List<Map<String,Object>> dfCollectionBetweenTwoDates(Date from, Date to) throws ParseException {
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
//		Date date1 = formatter.parse(from.toString());
//		Date date2 = formatter.parse(to.toString());
		
		java.sql.Timestamp fromdate = 
				new java.sql.Timestamp(from.getTime()); 
		java.sql.Timestamp todate = 
				new java.sql.Timestamp(to.getTime());
		
		//String sql = " select DATE_format(paymentDate,'%d-%M-%Y') as createdTime,sum(sf.fee) as amount from studentfee sf where date(paymentDate) between Date('"+fromdate+"')  AND Date('"+todate+"') group by daTE(paymentDate)"  ;
		String sql = "select s.name,ct.name as className,m.name as medium ,sf.admissionFee,sf.tutionFee ,sf.transportationFee,sf.hostelFee,sf.stationaryFee,sf.fee as total,"
		+" DATE_format(paymentDate,'%d-%M-%Y') as createdTime from studentfee sf,classtable ct,mediam m ,student s where "
		+" date(paymentDate) between Date('"+fromdate+"')  AND Date('"+todate+"') and sf.studentId = s.id and s.className = ct.id and s.medium = m.id";
		
		List<Map<String,Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
		System.out.println(sql);
		if(retlist.size() > 0)
			return retlist;
		return null;
	}
}
