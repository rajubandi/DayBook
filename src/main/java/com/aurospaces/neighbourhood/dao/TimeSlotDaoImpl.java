/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.aurospaces.neighbourhood.bean.TimeSlotBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
import com.aurospaces.neighbourhood.util.EmailSendingUtil;

/**
 * @author Amit
 * 
 */
@Repository
public class TimeSlotDaoImpl extends DaoSupport implements TimeSlotDao {
	Logger objLogger = Logger.getLogger(EmailSendingUtil.class);

	@Autowired
	ServletContext objContext;
	@Override
	public boolean insertTimeslot(TimeSlotBean objTimeSlotBean) {
		boolean isCategoryInsert = false;
		try {
			String sSql = "insert into pathology_time_slots(slotId, slotLabel, slotDesc) values(?,?,?)";
			System.out.println(sSql);
			int iCount = getJdbcTemplate().update(
					sSql,
					new Object[] { objTimeSlotBean.getSlotId(),
							objTimeSlotBean.getSlotLabel(), objTimeSlotBean.getSlotDesc() });
			System.out.println(iCount);
			if (iCount != 0) {
				isCategoryInsert = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCategoryInsert;
	}

	@Override
	public boolean updateTimeslot(TimeSlotBean objTimeSlotBean) {
		boolean isCategoryUpdate = false;
		try {
			String sSql = "update pathology_time_slots set slotLabel=?, slotDesc = ? where slotId = ?";
			int iCount = getJdbcTemplate().update(sSql,
					objTimeSlotBean.getSlotLabel(),
					objTimeSlotBean.getSlotDesc(),
					objTimeSlotBean.getSlotId());
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
	public List<TimeSlotBean> getTimeslots(TimeSlotBean objTimeSlotBean, String likeSearch) {
		InputStream input = null;
		Properties prop = new Properties();
		List<TimeSlotBean> listTimeSlotBeans = null;
		try {
			StringBuffer objStringBuffer = new StringBuffer();
			//objStringBuffer.append("select * from pathology_time_slots");
			String propertiespath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
			//String propertiespath = "C:\\PRO\\Database.properties";
			objLogger.fatal("error in email sending...."+propertiespath);
			input = new FileInputStream(propertiespath);
			// load a properties file
			prop.load(input);
			String protectionServer = prop.getProperty("protectionServer");
			
			if((protectionServer != null ) &&  protectionServer.equals("true")){
			objStringBuffer.append("SELECT slotId,slotLabel,HOUR(DATE_ADD(NOW(),    INTERVAL '+5: 30' HOUR_MINUTE)) AS  HOUR FROM pathology_time_slots");
			}else{
				objStringBuffer.append("SELECT slotId,slotLabel,HOUR(DATE_ADD(NOW(),    INTERVAL '0: 0' HOUR_MINUTE)) AS  HOUR FROM pathology_time_slots");
			}
			String sSql = objStringBuffer.toString();
			System.out.println(sSql);
			listTimeSlotBeans = getJdbcTemplate()
					.query(sSql,
							new BeanPropertyRowMapper<TimeSlotBean>(
									TimeSlotBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listTimeSlotBeans;
	}	
	@Override
	public TimeSlotBean getTimeslot(TimeSlotBean objTimeSlotBean, String likeSearch) {
		TimeSlotBean objCatBean = null;
		try {
			String sSql = "select * from pathology_time_slots where slotId ='"
					+ objTimeSlotBean.getSlotId() + "'";
			objCatBean = getJdbcTemplate()
					.queryForObject(
							sSql,
							new BeanPropertyRowMapper<TimeSlotBean>(
									TimeSlotBean.class));
			System.out.println(sSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objCatBean;
	}

	@Override
	public boolean deleteTimeslot(TimeSlotBean objTimeSlotBean) {
		boolean isCategoryDelete = false;
		try {
			String sSql = "delete from pathology_time_slots where slotId ='"
					+ objTimeSlotBean.getSlotId() + "'";
			int iDeleteCount = getJdbcTemplate().update(sSql);
			System.out.println(sSql);
			if (iDeleteCount != 0) {
				isCategoryDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isCategoryDelete;
	}
}
