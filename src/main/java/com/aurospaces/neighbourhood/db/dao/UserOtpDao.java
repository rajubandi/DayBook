
package com.aurospaces.neighbourhood.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.CategoryBean;
import com.aurospaces.neighbourhood.db.basedao.BaseUserOtpDao;
import com.aurospaces.neighbourhood.db.model.UserOtp;




@Repository(value = "userOtpDao")
public class UserOtpDao extends BaseUserOtpDao
{
@Autowired public JdbcTemplate jdbcTemplate;
	public boolean updateOtpStatus(UserOtp objUserOtp) {
		boolean isUpdate = false;
		try {
			String sSql = "UPDATE user_otp SET status = 'success' WHERE otp = ? and phone_no = ? ORDER BY created_time DESC LIMIT 1";
			int iCount = jdbcTemplate.update(sSql, new Object[]{objUserOtp.getOtp(),objUserOtp.getPhoneNo()});
			if (iCount != 0) {
				isUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isUpdate;
	}
}

