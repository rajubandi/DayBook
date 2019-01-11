package com.aurospaces.neighbourhood.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.DoctorOrderBean;
import com.aurospaces.neighbourhood.bean.SymptomsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

@Repository
public class DoctorOrderDaoImpl extends DaoSupport implements DoctorOrderDao {

	@Override
	public List<DoctorOrderBean> getAllDoctorTypes() {
		List<DoctorOrderBean> listDoctorOrderBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from doctor_type");
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listDoctorOrderBeans = getJdbcTemplate().query(
					sSql,
					new BeanPropertyRowMapper<DoctorOrderBean>(
							DoctorOrderBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listDoctorOrderBeans;

	}

	@Override
	public List<SymptomsBean> getAllSymptoms() {
		List<SymptomsBean> listSymptomsBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			objStringBuffer.append("select * from symptoms");
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listSymptomsBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<SymptomsBean>(
									SymptomsBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listSymptomsBeans;
	}

	@Override
	public boolean insertDocterOrder(DoctorOrderBean objDoctorOrderBean) {
		DateFormat objDateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar objCal = Calendar.getInstance();
		String sDate = objDateFormate.format(objCal.getTime());
		boolean isInserDetails = false;
		try {

			String sSql = "insert into order_info(orderId, appointmentDate, appointmentSlotId,orderAddress,contactEmail,contactNo,bookedDate) values(?,?,?,?,?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] {
							objDoctorOrderBean.getOrderId(),
							objDoctorOrderBean.getAppointmentDate(),
							objDoctorOrderBean.getAppointmentSlotId(),
							// objDoctorOrderBean.getDoctortypeName(),
							objDoctorOrderBean.getOrderAddress(),
							objDoctorOrderBean.getContactEmail(),
							objDoctorOrderBean.getContactNo(), sDate });
			System.out.println(iCount);
			System.out.println(sSql);
			if (iCount != 0) {
				isInserDetails = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}

	@Override
	public boolean insertOrderSymtoms(final DoctorOrderBean objDoctorOrderBean) {
		boolean isInserDetails = false;
		try {
			String sSql = "insert into order_symptoms(orderId,symptomsId,symptomsDesc) values(?,?,?)";
			final List<SymptomsBean> listSymptomsBeans = objDoctorOrderBean
					.getListSymptomsBean();
			// final String sOrderId = objPathologyOrderInfoBean.getOrderId();
			getJdbcTemplate().batchUpdate(sSql,
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							SymptomsBean objSymptomsBean = listSymptomsBeans
									.get(i);

							ps.setString(1, objDoctorOrderBean.getOrderId());
							ps.setString(2, objSymptomsBean.getSymsptomsId());
							ps.setString(3,
									objDoctorOrderBean.getSymptomsDesc());
						}

						@Override
						public int getBatchSize() {
							return listSymptomsBeans.size();
						}
					});
			isInserDetails = true;
			System.out.println(sSql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}

	@Override
	public boolean insertOrderDocterType(DoctorOrderBean objDoctorOrderBean) {
		boolean isInserDetails = false;

		try {

			String sSql = "insert into order_doctor_type (orderId, docotorTypeId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objDoctorOrderBean.getOrderId(),
							objDoctorOrderBean.getDoctortypeId() });
			System.out.println(iCount);
			System.out.println(sSql);
			if (iCount != 0) {
				isInserDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}

	@Override
	public boolean insertOrderStatus(DoctorOrderBean objDoctorOrderBean) {
		boolean isInserDetails = false;
		NeighbourhoodUtil objNeighbourhoodUtil = null;
		String sDate = null;
		try {
			objNeighbourhoodUtil = new NeighbourhoodUtil();
			sDate=objNeighbourhoodUtil.getCurrentTimestamp("");
			String sSql = "insert into order_status (orderId, statusId,updatedDate,updatedBy) values(?,?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objDoctorOrderBean.getOrderId(),
							objDoctorOrderBean.getStatusId(),
							sDate,
							objDoctorOrderBean.getStatusId()
					});
			System.out.println(iCount);
			System.out.println(sSql);
			if (iCount != 0) {
				isInserDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}

	@Override
	public boolean insertOrderUser(DoctorOrderBean objDoctorOrderBean) {
		boolean isInserDetails = false;

		try {

			String sSql = "insert into order_user (orderId, userId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objDoctorOrderBean.getOrderId(),
							objDoctorOrderBean.getCustomerId() });
			System.out.println(iCount);
			System.out.println(sSql);
			if (iCount != 0) {
				isInserDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;
	}

	@Override
	public boolean insertOrderService(DoctorOrderBean objDoctorOrderBean) {
		boolean isInserDetails = false;

		try {

			String sSql = "insert into order_service (orderId, serviceId) values(?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objDoctorOrderBean.getOrderId(),
							objDoctorOrderBean.getServiceId() });
			System.out.println(iCount);
			System.out.println(sSql);
			if (iCount != 0) {
				isInserDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInserDetails;

	}

}
