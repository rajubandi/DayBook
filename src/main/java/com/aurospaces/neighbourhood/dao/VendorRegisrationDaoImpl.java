package com.aurospaces.neighbourhood.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.ServicesBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

@Repository
public class VendorRegisrationDaoImpl extends DaoSupport implements
		VendorRegisrationDao {

	@Override
	public boolean insertVendor(VendorRegistrationBean objProfileBean) {
		boolean isVendorInsert = false;
		try {
			String sSql = "insert into vendor_profile (vendorId,firstName,lastName,middleName,"
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
	public boolean updateVendor(VendorRegistrationBean objProfileBean) {
		boolean isVendorUpdate = false;
		try {
			String sSql = "update vendor_profile set firstName=?,lastName=?,middleName=?,"
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
				isVendorUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isVendorUpdate;
	}

	@Override
	public List<VendorRegistrationBean> getVendors(
			VendorRegistrationBean objProfileBean) {
		List<VendorRegistrationBean> listVendorRegistrationBean = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from vendor_profile v, states s where s.state_Id = v.state");
			if(objProfileBean.getVendorId() != null){
				objStringBuffer.append(" and v.vendorId = '"+objProfileBean.getVendorId()+"'");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listVendorRegistrationBean = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<VendorRegistrationBean>(
							VendorRegistrationBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listVendorRegistrationBean;
	}

	@Override
	public VendorRegistrationBean getVendor(
			VendorRegistrationBean objProfileBean) {
		VendorRegistrationBean objVendorRegistrationBean = null;
		List<ServicesBean> listVendorBean = null;
		try {
			String sSql = "SELECT * FROM vendor_profile v, `vendor_category` c, vendor_service s WHERE c.`vendorId`=v.`vendorId` AND s.`vendorId` = v.`vendorId`  AND v.vendorId ='"
					+ objProfileBean.getVendorId() + "'  GROUP BY v.`vendorId`";
			if("edit".equals(objProfileBean.getEditMode())){
				String sql =" SELECT  s.serviceId, s.serviceName FROM `services` s, `vendor_service` v WHERE s.serviceId = v.serviceId AND v.`vendorId`='"+objProfileBean.getVendorId() + "' ";
				listVendorBean = getJdbcTemplate().query(
						sql,
						new BeanPropertyRowMapper<ServicesBean>(
								ServicesBean.class));
			}
			System.out.println(sSql);
			objVendorRegistrationBean = getJdbcTemplate().queryForObject(
					sSql,
					new BeanPropertyRowMapper<VendorRegistrationBean>(
							VendorRegistrationBean.class));
			if(objVendorRegistrationBean != null){
				objVendorRegistrationBean.setListServicesBean(listVendorBean);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objVendorRegistrationBean;
	}

	@Override
	public boolean deleteVendor(VendorRegistrationBean objProfileBean) {
		boolean isVendorDelete = false;
		try {
			String sSql = "delete from vendor_profile where vendorId ='"
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

	@Override
	public VendorRegistrationBean getVendorId(
			VendorRegistrationBean objVendorRegistrationBean) {
	
		try {
			String sSql = "SELECT `vendorId` FROM `vendor_profile` WHERE `firstName` = '"
					+ objVendorRegistrationBean.getFirstName() + "'";
			objVendorRegistrationBean = getJdbcTemplate().queryForObject(sSql,
					new BeanPropertyRowMapper<VendorRegistrationBean>(VendorRegistrationBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objVendorRegistrationBean;
	}
}
