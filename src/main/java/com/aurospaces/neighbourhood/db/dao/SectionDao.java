package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.FilterBean;
import com.aurospaces.neighbourhood.bean.SectionCreationBean;
import com.aurospaces.neighbourhood.db.basedao.BaseSectionDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;

@Repository(value = "SectionDao")
public class SectionDao extends BaseSectionDao{
	  public List<Map<String, String>> getSectionCreationData(){
			
			String sql ="select st.id as sectionId, st.name as sectionName, ct.id as classId, ct.name as className, bn.id as boardId, bn.name as boardName from sectiontable st, boardname bn, classtable ct where"
					+ " st.Boardid = bn.id and st.Classid = ct.id" ;

			System.out.println("--sql-- "+sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "sectionId","sectionName","classId","className","boardId","boardName"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	  
	  public SectionCreationBean getExistingOrNot(SectionCreationBean objClassBean) {
			String sql = "SELECT * from sectiontable where boardid = ? and classid=? and name=? ";
			List<SectionCreationBean> retlist = jdbcTemplate.query(sql,
			new Object[]{objClassBean.getBoardId(),objClassBean.getClassId(),objClassBean.getSection()},
			ParameterizedBeanPropertyRowMapper.newInstance(SectionCreationBean.class));
			System.out.println("list size----"+retlist);
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}
    
		public List<FilterBean> getClassNameViaBoardName(String boardId)
		{
			String query = "select ct.id,ct.name as className from classtable ct,boardname bn where ct.Boardid= bn.id and ct.Boardid= ?";
			List<FilterBean> handler = jdbcTemplate.query(query, new Object[]{boardId},ParameterizedBeanPropertyRowMapper.newInstance(FilterBean.class));
			System.out.println(query);
		     
			return handler;
		}
}

