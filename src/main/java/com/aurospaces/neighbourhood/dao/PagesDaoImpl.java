package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PagesBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
@Repository
public class PagesDaoImpl extends DaoSupport implements PagesDao {

	@Override
	public boolean insertPages(PagesBean objPagesBean) {
		boolean isInsertPage = false;
		try {
			String sSql = "insert into pages(pageId, PageName) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objPagesBean.getPageId(),
							objPagesBean.getPageName()});
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

	@Override
	public List<PagesBean> getServices(PagesBean objPagesBean, String likeSearch) {
		List<PagesBean> listpPagesBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from pages " );
			if (objPagesBean.getPageName() != null) {
				if ("both".equals(likeSearch)) {
					objStringBuffer.append("where pageName` like '%"
							+ objPagesBean.getPageName() + "%'");
				} else if ("left".equals(likeSearch)) {
					objStringBuffer.append(" where pageName` like '%"
							+ objPagesBean.getPageName() + "'");
				} else if ("right".equals(likeSearch)) {
					objStringBuffer.append(" where pageName` like '"
							+ objPagesBean.getPageName() + "%'");
				} else {
					objStringBuffer.append(" where pageName = '"
							+ objPagesBean.getPageName() + "'");
				}

			}
			if (objPagesBean.getPageId() != null) {
				objStringBuffer.append(" and pageId != '"
						+ objPagesBean.getPageId() + "'");
			}
			
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listpPagesBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<PagesBean>(
									PagesBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listpPagesBeans;
	}

	@Override
	public PagesBean getPage(PagesBean objPagesBean) {
		PagesBean objLocalPagesBean = null;
		String sSql = null;
		try {
			sSql = "SELECT `pageName` FROM `services` WHERE `serviceId`='"
					+ objPagesBean.getServiceId() + "'";
			objLocalPagesBean = getJdbcTemplate().queryForObject(sSql,
					new BeanPropertyRowMapper<PagesBean>(PagesBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return objLocalPagesBean;
	}

}
