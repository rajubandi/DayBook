/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.VendorExperienceBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 *
 */
@Repository
public class VendorExperienceDaoImpl extends DaoSupport implements VendorExperienceDao{

	@Override
	public boolean insertVendorExperience(
			VendorExperienceBean objVendorExperienceBean) {
		boolean isVendorExperienceInsert = false;
		try {
			String sSql = "insert into vendor_experience(vendorId, experianceId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objVendorExperienceBean.getVendorId(),
							objVendorExperienceBean.getExperianceId() });
			System.out.println(iCount);
			if (iCount != 0) {
				isVendorExperienceInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorExperienceInsert;
	}

}
