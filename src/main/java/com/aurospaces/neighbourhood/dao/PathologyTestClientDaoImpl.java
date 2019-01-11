package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyTestClientBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class PathologyTestClientDaoImpl extends DaoSupport implements PathologyTestClientDao {

	@Override
	public boolean insertPathologyTestClient(
			PathologyTestClientBean objPathologyTestClientBean) {
		boolean isInsert = false;
		try {
			String sSql = "insert into vendor_test(vendorId,testId) values(?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objPathologyTestClientBean.getTestClientId(),
					objPathologyTestClientBean.getTestId()
			});
			isInsert = true;
		System.out.println(sSql);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

	}
	return isInsert;
	}

}
