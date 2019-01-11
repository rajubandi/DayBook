package com.aurospaces.neighbourhood.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.AddBoardBean;
import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.BusRouteBean;
import com.aurospaces.neighbourhood.bean.MediumBean;
import com.aurospaces.neighbourhood.db.basedao.AddBaseBoardDao;
import com.aurospaces.neighbourhood.db.basedao.BaseBusRouteDao;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
@Repository(value="BusRouteDao")
public class BusRouteDao extends BaseBusRouteDao {
	



	public List<Map<String, String>> getBusRoute( ){
		 StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id,routeName from busroute ");
		
		 String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","routeName"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	
	public BusRouteBean existingOrNotName(String routeName) {

		String sql = "select * from busroute where routeName=? ";
		List<BusRouteBean> retlist = jdbcTemplate.query(sql,
		new Object[]{routeName},
		ParameterizedBeanPropertyRowMapper.newInstance(BusRouteBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
	}
	public BusRouteBean existingOrNot(BusRouteBean busRouteBean ){
		
		
		
		String sql = "select * from busroute where  boardId = ? and mediamId =? and className=? and section=? and routeId=? ";
		List<BusRouteBean> retlist = jdbcTemplate.query(sql,
		new Object[]{busRouteBean.getBoardId(),busRouteBean.getMediumId(),busRouteBean.getClassName(),busRouteBean.getSection(),busRouteBean.getRouteId()},
		ParameterizedBeanPropertyRowMapper.newInstance(BusRouteBean.class));
		if(retlist.size() > 0)
			return retlist.get(0);
		return null;
		
		/* StringBuffer objStringBuffer = new StringBuffer();
		 objStringBuffer.append("select id ,name from boardname where name ='"+name + "'");
		
			String sql = objStringBuffer.toString();
			System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "id","name"});
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;*/
			
		}
	
	 public List<BusRouteBean> getBusRouteName(String sql ){
		 
			// String sql = "SELECT * from users where name = ? and password = ? and rolId =? ";
				List<BusRouteBean> retlist = jdbcTemplate.query(sql,ParameterizedBeanPropertyRowMapper.newInstance(BusRouteBean.class));
					return retlist;
		 }
	/* @SuppressWarnings("deprecation")
		public Long getBusFee(int id) {
			
			String sql ="select busFee from busroutefees where id=?";
			long lg = jdbcTemplate.queryForInt(sql, new Object[]{id});
			if(lg != 0) {
				return lg;
			}
			return null;
		
	  }*/
	
	
	  public List<Map<String, String>> getBusRouteFees(){
			
			String sql ="select bf.classId ,bf.boardId,bf.sectionId,bf.mediumId,bn.name as bordName,m.name as medium, " 
					 +  " ct.name as className,st.name as section,br.routeName,bf.routeId as routeId,bf.busFee "
					 + " from boardname bn,mediam m,classtable ct,sectiontable st,busroute br,busroutefees bf where " 
					 + " bf.boardId=bn.id and bf.mediumId=m.id and bf.classId=ct.id and bf.sectionId = st.id and bf.routeId=br.id" ;

			//System.out.println(sql);
			RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "classId","bordName","medium","className","section" ,"sectionId","borderId","mediamId","routeId",  "routeName", "busFee" });
			jdbcTemplate.query(sql, handler);
			List<Map<String, String>> result = handler.getResult();
			return result;
			
		}
	
}
