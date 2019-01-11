package com.aurospaces.neighbourhood.db.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.db.basedao.BaseBirthDayNotification;

@Repository(value = "BirthDayNotificationDao")
public class BirthDayNotificationDao extends BaseBirthDayNotification {

	public List<StudentBean> upCommingBirthdays(StudentBean objStudentBean) {
		StringBuffer buffer = new StringBuffer();

		buffer.append(
				"SELECT *   FROM  ( SELECT Date(s.dob) as dob,s.id as id,s.name as name,bn.name as boardName ,m.name as medium,ct.name as className,st.name as section,"
						+ "s.fatherName,s.mobile, MONTH(dob) AS m , DAY(dob) As d   FROM student s,boardName bn,classtable ct,sectiontable st,mediam m where"
						+ " s.className=ct.id and s.boardName=bn.id and st.id=s.section and m.id=s.medium ");
		if (StringUtils.isNotBlank(objStudentBean.getClassName())) {
			buffer.append(" and ct.id = " + objStudentBean.getClassName());
		}
		if (StringUtils.isNotBlank(objStudentBean.getBoardName())) {
			buffer.append(" and bn.id = " + objStudentBean.getBoardName());
		}
		if (StringUtils.isNotBlank(objStudentBean.getSection())) {
			buffer.append(" and st.id = " + objStudentBean.getSection());
		}
		if (StringUtils.isNotBlank(objStudentBean.getMedium())) {
			buffer.append(" and m.id = " + objStudentBean.getMedium());
		}
		buffer.append(" ) AS tmp   ORDER BY (m,d) < ( MONTH(CURDATE()), DAY(CURDATE()) ) , m , d");
		String query = buffer.toString();
		System.out.println(query);
		List<StudentBean> handler = jdbcTemplate.query(query, new Object[] {},
				ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
		System.out.println(query);

		return handler;
	}

	public List<StudentBean> todayBirthDay() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("select * from student where  DATE_FORMAT(dob, '%m-%d') = DATE_FORMAT(CURRENT_DATE(), '%m-%d') ");

		String query = buffer.toString();
		System.out.println(query);
		List<StudentBean> handler = jdbcTemplate.query(query, new Object[] {},
				ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
		System.out.println(query);

		return handler;
	}

	public List<StudentBean> activeOrNot() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("select * from birthdaynotification where Date(created_time) = CURDATE() and active=1  ");

		String query = buffer.toString();
		System.out.println(query);
		List<StudentBean> handler = jdbcTemplate.query(query, new Object[] {},
				ParameterizedBeanPropertyRowMapper.newInstance(StudentBean.class));
		System.out.println(query);

		return handler;
	}
}
