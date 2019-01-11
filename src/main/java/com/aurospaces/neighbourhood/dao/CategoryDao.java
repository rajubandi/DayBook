/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.CategoryBean;

/**
 * @author Amit
 *
 */
public interface CategoryDao {
	boolean insertCategory(CategoryBean objCategoryBean);
	boolean updateCategory(CategoryBean objCategoryBean);
	List<CategoryBean> getCategorys(CategoryBean objCategoryBean, String likeSearch);
	CategoryBean getCategory(CategoryBean objCategoryBean, String likeSearch);
	boolean deleteCategory(CategoryBean objCategoryBean);
}
