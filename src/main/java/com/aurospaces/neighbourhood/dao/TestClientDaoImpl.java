package com.aurospaces.neighbourhood.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.TestClientBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class TestClientDaoImpl extends DaoSupport implements TestClientDao {

	@Override
	public boolean insertTestClient(TestClientBean objTestClientBean) {
		boolean isInsert = false;
		try {
			String sSql = "insert into test_client(testClientId,testClientName, testClientDesc) values(?,?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objTestClientBean.getTestClientId(),
					objTestClientBean.getTestClientName(),
					objTestClientBean.getTestClientDesc()
			});
			isInsert = true;
		System.out.println(sSql);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

	}
	return isInsert;
	}

	@Override
	public TestClientBean getTestClientId(TestClientBean objTestClientBean) {
		try {
			String sSql = "SELECT `vendorId`  FROM `vendor_profile` WHERE `firstName` = '"
					+ objTestClientBean.getTestClientName() + "'";
			objTestClientBean = getJdbcTemplate().queryForObject(sSql,
					new BeanPropertyRowMapper<TestClientBean>(TestClientBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return objTestClientBean;
	}

}
