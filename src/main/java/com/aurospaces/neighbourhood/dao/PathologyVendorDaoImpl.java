package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ServicesBean;
import com.aurospaces.neighbourhood.bean.PathologyVendorBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class PathologyVendorDaoImpl extends DaoSupport implements PathologyVendorDao {

	@Override
	public boolean insertVendor(PathologyVendorBean objProfileBean) {
		boolean isVendorInsert = false;
		try {
			String sSql = "insert into pathology_vendor(pathologyvendorId,firstName,lastName,middleName,"
					+ "organization,address1,address2,city,pin,state,vatno,cstno,panno,mobileNo,"
					+ "email,website,nativeState,profileDesc,expiryDate) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objProfileBean.getVendorId(),
							objProfileBean.getFirstName(),
							objProfileBean.getLastName(),
							objProfileBean.getMiddleName(),
							objProfileBean.getOrganisationName(),
							objProfileBean.getAddress1(),
							objProfileBean.getAddress2(),
							objProfileBean.getCity(),
							objProfileBean.getPincode(),
							objProfileBean.getState(),
							objProfileBean.getVatNo(),
							objProfileBean.getCstNo(),
							objProfileBean.getPanNo(),
							objProfileBean.getMobileNo(),
							objProfileBean.getEmail(),
							objProfileBean.getWebsite(),
							objProfileBean.getNativeState(),
							objProfileBean.getProfileDesc(),
							objProfileBean.getExpiryDate()});
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

	@Override
	public boolean updateVendor(PathologyVendorBean objProfileBean) {
		boolean isCategoryUpdate = false;
		try {
			String sSql = "update pathology_vendor set firstName=?,lastName=?,middleName=?,"
					+ "organization=?,address1=?,address2=?,city=?,pin=?,state=?,vatno=?,cstno=?,panno=?,mobileNo=?,"
					+ "email=?,website=?,nativeState=?,profileDesc=?,expiryDate=? where vendorId=?";
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { 
							objProfileBean.getFirstName(),
							objProfileBean.getLastName(),
							objProfileBean.getMiddleName(),
							objProfileBean.getOrganisationName(),
							objProfileBean.getAddress1(),
							objProfileBean.getAddress2(),
							objProfileBean.getCity(),
							objProfileBean.getPincode(),
							objProfileBean.getState(),
							objProfileBean.getVatNo(),
							objProfileBean.getCstNo(),
							objProfileBean.getPanNo(),
							objProfileBean.getMobileNo(),
							objProfileBean.getEmail(),
							objProfileBean.getWebsite(),
							objProfileBean.getNativeState(),
							objProfileBean.getProfileDesc(),
							objProfileBean.getExpiryDate(),
							objProfileBean.getVendorId()});
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
	public List<PathologyVendorBean> getVendors(
			PathologyVendorBean objProfileBean) {
		List<PathologyVendorBean> listPathologyVendorBean = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from pathology_vendor");
			/*
			 * if (objCategoryBean.getCategoryName() != null) {
			 * if("both".equals(likeSearch)){
			 * objStringBuffer.append(" where categoryName like '%" +
			 * objCategoryBean.getCategoryName() + "%'"); } else
			 * if("left".equals(likeSearch)){
			 * objStringBuffer.append(" where categoryName like '%" +
			 * objCategoryBean.getCategoryName() + "'"); }else
			 * if("right".equals(likeSearch)){
			 * objStringBuffer.append(" where categoryName like '" +
			 * objCategoryBean.getCategoryName() + "%'"); }else {
			 * objStringBuffer.append(" where categoryName = '" +
			 * objCategoryBean.getCategoryName() + "'"); }
			 * 
			 * } if (objCategoryBean.getCategoryId() != null) {
			 * objStringBuffer.append(" and categoryId != '" +
			 * objCategoryBean.getCategoryId() + "'"); }
			 */
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listPathologyVendorBean = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<PathologyVendorBean>(
							PathologyVendorBean.class));
			System.out.println(listPathologyVendorBean.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyVendorBean;
	}

	@Override
	public PathologyVendorBean getVendor(
			PathologyVendorBean objProfileBean) {
		PathologyVendorBean objPathologyVendorBean = null;
		List<ServicesBean> listVendorBean = null;
		try {
			String sSql = "SELECT * FROM pathology_vendor v, `vendor_category` c, vendor_service s WHERE c.`vendorId`=v.`vendorId` AND s.`vendorId` = v.`vendorId` AND v.vendorId ='"
					+ objProfileBean.getVendorId() + "'  GROUP BY v.`vendorId`";
			if("edit".equals(objProfileBean.getEditMode())){
				String sql =" SELECT  s.serviceId, s.serviceName FROM `services` s, `vendor_service` v WHERE s.serviceId = v.serviceId AND v.`vendorId`='"+objProfileBean.getVendorId() + "' ";
				listVendorBean = getJdbcTemplate().query(
						sql,
						new BeanPropertyRowMapper<ServicesBean>(
								ServicesBean.class));
			}
			System.out.println(sSql);
			objPathologyVendorBean = getJdbcTemplate().queryForObject(
					sSql,
					new BeanPropertyRowMapper<PathologyVendorBean>(
							PathologyVendorBean.class));
			if(objPathologyVendorBean != null){
				objPathologyVendorBean.setListServicesBean(listVendorBean);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objPathologyVendorBean;
	}

	@Override
	public boolean deleteVendor(PathologyVendorBean objProfileBean) {
		boolean isVendorDelete = false;
		try {
			String sSql = "delete from pathology_vendor where pathologyvendorId ='"
					+ objProfileBean.getVendorId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			if (iDeleteCount != 0) {
				isVendorDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorDelete;
	}
}
