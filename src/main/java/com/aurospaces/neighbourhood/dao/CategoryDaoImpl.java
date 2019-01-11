/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.bean.CategoryBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class CategoryDaoImpl extends DaoSupport implements CategoryDao {

	@Override
	public boolean insertCategory(CategoryBean objCategoryBean) {
		boolean isCategoryInsert = false;
		try {
			String sSql = "insert into category(categoryId, categoryName, categoryDesc) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objCategoryBean.getCategoryId(),
							objCategoryBean.getCategoryName(), "" });
			System.out.println(iCount);
			if (iCount != 0) {
				isCategoryInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCategoryInsert;
	}

	@Override
	public boolean updateCategory(CategoryBean objCategoryBean) {
		boolean isCategoryUpdate = false;
		try {
			String sSql = "update category set categoryName = ? where categoryId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objCategoryBean.getCategoryName(),
					objCategoryBean.getCategoryId());
			if (iCount != 0) {
				isCategoryUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCategoryUpdate;
	}

	@Override
	public List<CategoryBean> getCategorys(CategoryBean objCategoryBean, String likeSearch) {
		List<CategoryBean> listCategoryBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from category");
			if (objCategoryBean.getCategoryName() != null) {
				if("both".equals(likeSearch)){
				objStringBuffer.append(" where categoryName like '%"
						+ objCategoryBean.getCategoryName() + "%'");
				}
				else if("left".equals(likeSearch)){
					objStringBuffer.append(" where categoryName like '%"
							+ objCategoryBean.getCategoryName() + "'");
				}else if("right".equals(likeSearch)){
					objStringBuffer.append(" where categoryName like '"
							+ objCategoryBean.getCategoryName() + "%'");
				}else {
					objStringBuffer.append(" where categoryName = '"
							+ objCategoryBean.getCategoryName() + "'");
				}
				
			}
			if (objCategoryBean.getCategoryId() != null) {
				objStringBuffer.append(" and categoryId != '"
						+ objCategoryBean.getCategoryId() + "'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listCategoryBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<CategoryBean>(
									CategoryBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listCategoryBeans;
	}

	@Override
	public CategoryBean getCategory(CategoryBean objCategoryBean, String likeSearch) {
		CategoryBean objCatBean = null;
		try {
			String sSql = "select * from category where categoryId ='"
					+ objCategoryBean.getCategoryId() + "'";
			objCatBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<CategoryBean>(
									CategoryBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objCatBean;
	}

	@Override
	public boolean deleteCategory(CategoryBean objCategoryBean) {
		boolean isCategoryDelete = false;
		try {
			String sSql = "delete from category where categoryId ='"
					+ objCategoryBean.getCategoryId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isCategoryDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCategoryDelete;
	}
}
