/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.VendorPackageBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class VendorPackagesDaoImpl extends DaoSupport implements VendorPackagesDao {

	@Override
	public boolean insertVendorPackage(VendorPackageBean objVendorPackageBean) {
		boolean isInsert = false;
		try {
			String sSql = "insert into vendor_packages(vendorId,packageId) values(?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objVendorPackageBean.getVendorId(),
					objVendorPackageBean.getPackageId()
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
