package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.db.basedao.BaseAttendanceDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "attendanceDao")
public class AttendanceDao extends BaseAttendanceDao {
	@Autowired HttpSession session;
	
	public List<Map<String, String>> getAttendance(StudentBean objStudentBean ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select s.id as studentId,s.name as studentName,att.absentSection,DATE_FORMAT( Date(att.created_time),'%d-%M-%Y') as absentDate,att.message ,"
		 		+ "ct.name as className,st.name as sectionName,bn.name as boardName,s.admissionNum from attendance att,student s,classtable ct,sectiontable st,boardname bn,mediam m where " 
				 	+" s.id=att.studentId and s.section=st.id and "
				 	+" s.className=ct.id and st.id=s.section and s.boardName=bn.id and m.id=s.medium ");
		if (StringUtils.isNotBlank(objStudentBean.getBoardName())) {
			objStringBuffer.append(" and bn.id=" + objStudentBean.getBoardName());
		}
		if (StringUtils.isNotBlank(objStudentBean.getClassName())) {
			objStringBuffer.append(" and ct.id=" + objStudentBean.getClassName());
		}
	
		if (StringUtils.isNotBlank(objStudentBean.getSection())) {
			objStringBuffer.append(" and st.id=" + objStudentBean.getSection());
		}
		if (StringUtils.isNotBlank(objStudentBean.getAdmissionNum())) {
			objStringBuffer.append(" and s.admissionNum=" + objStudentBean.getAdmissionNum());
		}
		if (StringUtils.isNotBlank(objStudentBean.getMedium())) {
			objStringBuffer.append(" and m.id=" + objStudentBean.getMedium());
		}
		if (StringUtils.isNotBlank(objStudentBean.getName())) {
			objStringBuffer.append("  and  s.name  LIKE '%"+ objStudentBean.getName() +"%'" );
		}
		if (StringUtils.isNotBlank(objStudentBean.getDob1()) && StringUtils.isNotBlank(objStudentBean.getDob2()) ) {
			objStringBuffer.append("  and  Date(att.created_time) BETWEEN Date('"+new java.sql.Timestamp(objStudentBean.getDob().getTime()) +"') AND Date('"+new java.sql.Timestamp(objStudentBean.getDob3().getTime()) +"') " );
		}
		if (StringUtils.isNotBlank(objStudentBean.getMobile()) ) {
			objStringBuffer.append("  and  s.mobile= '"+objStudentBean.getMobile() +"'  " );
		}
		if (objStudentBean.getId() != 0 ) {
			objStringBuffer.append("  and  s.id= "+objStudentBean.getId() );
		}
		UsersBean objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
		if(objuserBean != null){
			int rolId1 = Integer.parseInt(objuserBean.getRolId());
			if(rolId1 == 3){
				objStringBuffer.append(" and s.mobile='" + objuserBean.getMobile()+"'");
			}
		}
		
		objStringBuffer.append("  order by att.created_time desc limit 50" );
		
String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "studentId","studentName","absentSection","absentDate","message","className",
					"sectionName","boardName","admissionNum"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
}
