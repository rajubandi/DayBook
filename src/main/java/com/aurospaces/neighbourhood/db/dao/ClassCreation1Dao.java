package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ClassCreationBean;
import com.aurospaces.neighbourhood.bean.FilterBean;
import com.aurospaces.neighbourhood.db.basedao.BaseClassCreation1Dao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "ClassCreation1Dao")
public class ClassCreation1Dao extends BaseClassCreation1Dao
{
	public List<Map<String, String>> getClassCreationData()
	{
		String sql ="select ct.id as classId, ct.name as className,bn.id as boardId, bn.name as boardName from classtable ct, boardname bn where ct.Boardid=bn.id;" ;
//		System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "classId","className","boardId","boardName"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
			
	}
	  
	public ClassCreationBean getExistingOrNot(ClassCreationBean objClassBean)
	{
		String sql = "SELECT * from classtable where name= ? and boardid = ? ";
		List<ClassCreationBean> retlist = jdbcTemplate.query(sql,
			new Object[]{objClassBean.getClassName(),objClassBean.getBoardId()},
		ParameterizedBeanPropertyRowMapper.newInstance(ClassCreationBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}
    
	/*public List<FilterBean> getClassName(String boardId)
	{
		String query = "select ct.id,ct.name as className from classcreation cc ,classtable ct,boardname bn  "+
                          " where cc.boardId = bn.id and ct.id =cc.className and bn.id= ? group by ct.id ";
		System.out.println(query);
		List<FilterBean> handler = jdbcTemplate.query(query, new Object[]{boardId},ParameterizedBeanPropertyRowMapper.newInstance(FilterBean.class));
		System.out.println(query);
	     
		return handler;
	}
		
	public List<FilterBean> getSectionFilter(String boardId,String classId)
	{
		String query = "select st.id,st.name as sectionName from classcreation cc ,classtable ct,boardname bn, sectiontable st "
                            +"  where cc.boardId = bn.id and ct.id =cc.className and st.id = cc.section and bn.id= ? and ct.id = ? group by st.id";
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
	}*/
}

