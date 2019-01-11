package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyOrderBean;
import com.aurospaces.neighbourhood.bean.PathologyTestBean;
import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class PathologyOrderDaoImpl extends DaoSupport implements PathologyOrderDao {

	@Override
	public String insertPathologyOrder(PathologyOrderBean objPathologyOrderBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PathologyTestTypeBean> getPathologyType(
			PathologyTestTypeBean objPathologyTestTypeBean) {
		List<PathologyTestTypeBean> listPathologyTestTypeBeans=null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("SELECT * FROM pathology_test_types ORDER BY `testTypeName` ");
			
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listPathologyTestTypeBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyTestTypeBean>(
							PathologyTestTypeBean.class));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return listPathologyTestTypeBeans;
	}

}
