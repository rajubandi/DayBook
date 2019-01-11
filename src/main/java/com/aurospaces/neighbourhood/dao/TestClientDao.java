package com.aurospaces.neighbourhood.dao;

import com.aurospaces.neighbourhood.bean.TestClientBean;

public interface TestClientDao {
	boolean insertTestClient(TestClientBean objTestClientBean);
	TestClientBean getTestClientId(TestClientBean objTestClientBean);

}
