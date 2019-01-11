/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.DoctorDetailsBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;

/**
 * @author Hiteshaurospaces
 *
 */
@Repository
public class DoctorTypeDoctorDaoImpl extends DaoSupport implements DoctorTypeDoctorDao{

	@Override
	public boolean insertDoctorTypeDoctor(
			final List<DoctorDetailsBean> objDoctorDetailsBeans) {
		boolean isInsert = false;

		try {
			String sSql = "insert into doctor_type_doctor(doctorId, doctorTypeId) values(?,?)";
			getJdbcTemplate().batchUpdate(sSql,
					new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							DoctorDetailsBean objLocalInventoryBean =  objDoctorDetailsBeans	.get(i);
							ps.setString(1,	objLocalInventoryBean.getDoctorId());
							ps.setString(2,	objLocalInventoryBean.getDoctortypeId());
						}
						@Override
						public int getBatchSize() {
							return objDoctorDetailsBeans.size();
						}
					});
			isInsert = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isInsert;
	}

}
