package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PageServicesBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class PageServicesDaoImpl extends DaoSupport implements PageServicesDao {

	@Override
	public boolean insertPagesService(PageServicesBean objPageServicesBean) {
		boolean isInsertPage = false;
		try {
			String sSql = "insert into page_services(pageId, serviceId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objPageServicesBean.getPageId(),
							objPageServicesBean.getServiceId()});
			System.out.println(iCount);
			if (iCount != 0) {

				isInsertPage = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInsertPage;
	}

}
