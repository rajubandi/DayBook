package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ClassBean;
import com.aurospaces.neighbourhood.bean.FilterBean;
import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.bean.StudentMarksBean;
import com.aurospaces.neighbourhood.db.basedao.BaseClassCreationDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "ClassCreationDao")
public class ClassCreationDao extends BaseClassCreationDao{
	  public List<Map<String, String>> getClassCreationData(){
			
			String sql ="select cr.id as classId,bn.name as bordName,m.name as medium,cr.className ,cr.section,bn.id as borderId,m.id as mediamId,"
					+ " ct.name as cname,st.name as sname,cr.fee,cr.admissionFee ,cr.tutionFee ,cr.transportationFee ,cr.hostelFee ,cr.stationaryFee,cr.termOne,cr.termTwo,cr.termThree  from classcreation cr,boardname bn,mediam m,classtable ct,sectiontable st where "
					+ "cr.boardId=bn.id and cr.mediamId=m.id and cr.className=ct.id and st.id=cr.section" ;

			//System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "classId","bordName","medium","className","section","borderId","mediamId","cname","sname","fee","admissionFee","tutionFee","transportationFee","hostelFee","stationaryFee","termOne","termTwo","termThree" });
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	  
	  public ClassBean getClassFee(StudentBean studentBean) {
			String sql = "SELECT * from classcreation where boardId = ? and mediamId =? and className=? and section=? ";
			List<ClassBean> retlist = jdbcTemplate.query(sql,
			new Object[]{studentBean.getBoardId(),studentBean.getMediumId(),studentBean.getClassId(),studentBean.getSectionId()},
			ParameterizedBeanPropertyRowMapper.newInstance(ClassBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
	  
	  public ClassBean getExistingOrNot(ClassBean objClassBean) {
			String sql = "SELECT * from classcreation where boardId = ? and mediamId =? and className=? and section=? ";
			List<ClassBean> retlist = jdbcTemplate.query(sql,
			new Object[]{objClassBean.getBoardId(),objClassBean.getMediumId(),objClassBean.getClassName(),objClassBean.getSection()},
			ParameterizedBeanPropertyRowMapper.newInstance(ClassBean.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
    
		public List<FilterBean> getClassName(String boardId)
		{

			String query = "select *,name as className from classtable where boardid=?";
			System.out.println(query);
			List<FilterBean> handler = jdbcTemplate.query(query, new Object[]{boardId},ParameterizedBeanPropertyRowMapper.newInstance(FilterBean.class));
			 System.out.println(query);
	     
			 return handler;
	  }
		public List<FilterBean> getClassName1(String boardId)
		{

			String query = "select ct.id,ct.name as className from boardname bn,classtable ct where bn.id =ct.boardId and bn.id=? group by ct.id";
			System.out.println(query);
			List<FilterBean> handler = jdbcTemplate.query(query, new Object[]{boardId},ParameterizedBeanPropertyRowMapper.newInstance(FilterBean.class));
			 System.out.println(query);
	     
			 return handler;
	  }
		
		public List<StudentMarksBean> getClassBySectionByStudentDao(String classId,String boardId,String sectionId)
		{

			String query = "select s.id,s.name as studentname from student s where boardName=? and className=? and section=? group by s.id";
			System.out.println(query);
			List<StudentMarksBean> handler = jdbcTemplate.query(query, new Object[]{classId,boardId,sectionId},ParameterizedBeanPropertyRowMapper.newInstance(StudentMarksBean.class));
			 System.out.println(handler.size());
	     
			 return handler;
	  }
		
		
		
		public List<StudentMarksBean> getClassBySectionDao(String classId,String boardId)
		{

			String query = "select st.id,st.name as sectionname from sectiontable st where boardid=? and classid=? group by st.id";
			System.out.println(query);
			List<StudentMarksBean> handler = jdbcTemplate.query(query, new Object[]{classId,boardId},ParameterizedBeanPropertyRowMapper.newInstance(StudentMarksBean.class));
			 System.out.println(handler.size());
	     
			 return handler;
	  }
		public List<FilterBean> getSectionFilter(String classId,String boardId)
		{

			String query = "select *,name as sectionName from sectiontable where classid=? and boardid=?";
			System.out.println(query);
			List<FilterBean> handler = jdbcTemplate.query(query, new Object[]{boardId,classId},ParameterizedBeanPropertyRowMapper.newInstance(FilterBean.class));
			 System.out.println(query);
	     
			 return handler;
	  }
		public List<FilterBean> getMediumFilter(String boardId,String classId ,String sectionId)
		{

			String query = "select m.id,m.name as mediumName from classcreation cc ,classtable ct,boardname bn, sectiontable st,mediam m "+
							" where cc.boardId = bn.id and ct.id =cc.className and st.id = cc.section  and m.id = cc.mediamId "+
							" and bn.id= ? and ct.id = ? and st.id = ? group by m.id";
			System.out.println(query);
			List<FilterBean> handler = jdbcTemplate.query(query, new Object[]{boardId,classId,sectionId},ParameterizedBeanPropertyRowMapper.newInstance(FilterBean.class));
			 System.out.println(query);
	     
			 return handler;
	  }

		
}

