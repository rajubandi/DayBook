/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.PathologyPackagesBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Amit
 * 
 */
@Repository
public class PathologyPackagesDaoImpl extends DaoSupport implements PathologyPackagesDao {

	@Override
	public boolean insertPathologyPackages(
			PathologyPackagesBean objPathologyPackagesBean) {
		boolean isInsert = false;
		try {
			String sSql = "insert into pathology_packages(packageId,packageName, packageDesc, price,discount) values(?,?,?,?,?)";
			getJdbcTemplate().update(sSql, new Object[]{
					objPathologyPackagesBean.getPackageId(),
					objPathologyPackagesBean.getPackageName(),
					objPathologyPackagesBean.getPackageDesc(),
					objPathologyPackagesBean.getPrice(),
					objPathologyPackagesBean.getDiscount()
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
	public List<PathologyPackagesBean> getFilterPackage(
			PathologyPackagesBean objPathologyPackagesBean) {
		List<PathologyPackagesBean> listPathologyPackagesBeans = null;
		try {
			String sSql = "SELECT vp.`packageId` as testId, vpr.`firstName`, pp.`price`  , pp.`discount`,pp.`packageName` as testName,  pp.`packageDesc` as testDesc" 
							+" FROM `pathology_packages` pp, `vendor_packages` vp, `vendor_profile` vpr WHERE pp.`packageId` = vp.`packageId`"
							+" AND vpr.`vendorId` = vp.`vendorId` order by pp.`packageName`";
			System.out.println("filter by name---"+sSql);
			listPathologyPackagesBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyPackagesBean>(
							PathologyPackagesBean.class));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
		return listPathologyPackagesBeans;
	}

	

		}
