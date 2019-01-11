/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 *
 */
@Repository
public class VendorCategoyDaoImpl extends DaoSupport implements VendorCategoryDao {

	@Override
	public boolean insertVendorCategory(
			VendorRegistrationBean objProfileBean) {
		boolean isVendorInsert = false;
		try {
			String sSql = "insert into vendor_category (vendorId,categoryId) values (?,?)";
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objProfileBean.getVendorId(),
							objProfileBean.getCategoryId() });
			System.out.println(iCount);
			if (iCount != 0) {
				isVendorInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return isVendorInsert;
	}
}
