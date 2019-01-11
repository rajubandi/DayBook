/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.DoctorDetailsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Amit
 * 
 */
@Repository
public class DoctorDetailsDaoImpl extends DaoSupport implements DoctorDetailsDao {

	@Override
	public boolean insertDoctorDetails(final List<DoctorDetailsBean> listDoctorDetailsBean) {
		boolean isMedicineInsert = false;
		try {
		String sSql = "insert into doctor_details(doctorId,name, mobileNo, emailId,address,clinic) values(?,?,?,?,?,?)";
			getJdbcTemplate().batchUpdate(sSql,
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							DoctorDetailsBean objDoctorDetailsBean = listDoctorDetailsBean.get(i);
							String sdoctorId = new NeighbourhoodUtil().getGUId();
							if (sdoctorId != null) {
								objDoctorDetailsBean.setDoctorId(sdoctorId);
							}
							System.out.println(sdoctorId);
							ps.setString(1, objDoctorDetailsBean.getDoctorId());
							ps.setString(2, objDoctorDetailsBean.getName());
							ps.setString(3, objDoctorDetailsBean.getMobileNo());
							ps.setString(4, objDoctorDetailsBean.getEmailId());
							ps.setString(5, objDoctorDetailsBean.getAddress());
							ps.setString(6, objDoctorDetailsBean.getClinic());
							
							
						}
             	@Override
						public int getBatchSize() {
							return listDoctorDetailsBean.size();
						}
					});
			isMedicineInsert = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isMedicineInsert;
	}
	public void doctorTestBean() {
		  try {
		   String sSql = "select * from doctor_details";
		   List<DoctorDetailsBean> list = getJdbcTemplate().query(
		     sSql,
		     new BeanPropertyRowMapper<DoctorDetailsBean>(
		       DoctorDetailsBean.class));
		

		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {

		  }
	}


	@Override
	public List<DoctorDetailsBean> getDoctorDetails(
			DoctorDetailsBean objDoctorDetailsBean, String likeSearch) {
	
			List<DoctorDetailsBean> listDoctorDetailsBean = null;
			try {
				StringBuffer objStringBuffer = new StringBuffer();
				objStringBuffer.append("select * from doctor_details");
				
				String sSql = objStringBuffer.toString();
				System.out.println(sSql);
				listDoctorDetailsBean = getJdbcTemplate()
						.query(sSql,
								new BeanPropertyRowMapper<DoctorDetailsBean>(
										DoctorDetailsBean.class));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
			return listDoctorDetailsBean;
		
	
		

		}
	}
