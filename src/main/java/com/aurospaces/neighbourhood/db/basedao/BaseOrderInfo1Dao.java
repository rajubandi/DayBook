
package com.aurospaces.neighbourhood.db.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurospaces.neighbourhood.db.model.OrderInfo1;


public class BaseOrderInfo1Dao{

@Autowired public JdbcTemplate jdbcTemplate;

 
	public final String INSERT_SQL = "INSERT INTO order_info1( created_time, updated_time, generated_id, booked_date, appointment_date, appointment_slot_old_id, appointment_slot_id, status_id, contact_number, contact_email, address, total_price, total_discount, net_amount, description, gender, service_id, vendor_id, sub_category, is_new_customer, location_id, latitude, longitude, coupon_code, is_admin_order, user_id, watsup_location, priority, customer_name, client_order_id, vendor_service_charge, goods_charge, margin_value, no_of_hours_work, transportaion_charge, no_of_visits, fixed_charge, auro_log_id, client_log_id, invoice_file, feedback_form, region_id, auro_log, client_log, goodsName, goodPaidBy, vendor_status, no_bhk, completionDate, billingto, ownername, isPause, kissantax, sestax, sbstax, invoice_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 





	/* this should be conditional based on whether the id is present or not */
	@Transactional
	public void save(final OrderInfo1 orderInfo1) 
	{
	if(orderInfo1.getId() == 0)	{

	KeyHolder keyHolder = new GeneratedKeyHolder();
	int update = jdbcTemplate.update(
			new PreparedStatementCreator() {
					public PreparedStatement 
					createPreparedStatement(Connection connection) throws SQLException {
	
					if(orderInfo1.getCreatedTime() == null)
					{
					orderInfo1.setCreatedTime( new Date());
					}
					java.sql.Timestamp createdTime = 
						new java.sql.Timestamp(orderInfo1.getCreatedTime().getTime()); 
							
					if(orderInfo1.getUpdatedTime() == null)
					{
					orderInfo1.setUpdatedTime( new Date());
					}
					java.sql.Timestamp updatedTime = 
						new java.sql.Timestamp(orderInfo1.getUpdatedTime().getTime()); 
							
					if(orderInfo1.getBookedDate() == null)
					{
					orderInfo1.setBookedDate( new Date());
					}
					java.sql.Timestamp bookedDate = 
						new java.sql.Timestamp(orderInfo1.getBookedDate().getTime()); 
							
					if(orderInfo1.getAppointmentDate() == null)
					{
					orderInfo1.setAppointmentDate( new Date());
					}
					java.sql.Timestamp appointmentDate = 
						new java.sql.Timestamp(orderInfo1.getAppointmentDate().getTime()); 
							
					if(orderInfo1.getGender() == null)
					{
					orderInfo1.setGender("m");
					}
					
					if(orderInfo1.getCompletionDate() == null)
					{
					orderInfo1.setCompletionDate( new Date());
					}
					java.sql.Timestamp completionDate = 
						new java.sql.Timestamp(orderInfo1.getCompletionDate().getTime()); 
							
					if(orderInfo1.getInvoiceDate() == null)
					{
					orderInfo1.setInvoiceDate( new Date());
					}
					java.sql.Timestamp invoiceDate = 
						new java.sql.Timestamp(orderInfo1.getInvoiceDate().getTime()); 
							
					PreparedStatement ps =
									connection.prepareStatement(INSERT_SQL,new String[]{"id"});
	ps.setTimestamp(1, createdTime);
ps.setTimestamp(2, updatedTime);
ps.setString(3, orderInfo1.getGeneratedId());
ps.setTimestamp(4, bookedDate);
ps.setTimestamp(5, appointmentDate);
ps.setString(6, orderInfo1.getAppointmentSlotOldId());
ps.setInt(7, orderInfo1.getAppointmentSlotId());
ps.setInt(8, orderInfo1.getStatusId());
ps.setString(9, orderInfo1.getContactNumber());
ps.setString(10, orderInfo1.getContactEmail());
ps.setString(11, orderInfo1.getAddress());
ps.setBigDecimal(12, orderInfo1.getTotalPrice());
ps.setBigDecimal(13, orderInfo1.getTotalDiscount());
ps.setBigDecimal(14, orderInfo1.getNetAmount());
ps.setString(15, orderInfo1.getDescription());
ps.setString(16, orderInfo1.getGender());
ps.setInt(17, orderInfo1.getServiceId());
ps.setInt(18, orderInfo1.getVendorId());
ps.setInt(19, orderInfo1.getSubCategory());
ps.setInt(20, orderInfo1.getIsNewCustomer());
ps.setInt(21, orderInfo1.getLocationId());
ps.setDouble(22, orderInfo1.getLatitude());
ps.setDouble(23, orderInfo1.getLongitude());
ps.setString(24, orderInfo1.getCouponCode());
ps.setInt(25, orderInfo1.getIsAdminOrder());
ps.setInt(26, orderInfo1.getUserId());
ps.setString(27, orderInfo1.getWatsupLocation());
ps.setString(28, orderInfo1.getPriority());
ps.setString(29, orderInfo1.getCustomerName());
ps.setString(30, orderInfo1.getClientOrderId());
ps.setDouble(31, orderInfo1.getVendorServiceCharge());
ps.setDouble(32, orderInfo1.getGoodsCharge());
ps.setDouble(33, orderInfo1.getMarginValue());
ps.setInt(34, orderInfo1.getNoOfHoursWork());
ps.setDouble(35, orderInfo1.getTransportaionCharge());
ps.setInt(36, orderInfo1.getNoOfVisits());
ps.setDouble(37, orderInfo1.getFixedCharge());
ps.setInt(38, orderInfo1.getAuroLogId());
ps.setInt(39, orderInfo1.getClientLogId());
ps.setString(40, orderInfo1.getInvoiceFile());
ps.setString(41, orderInfo1.getFeedbackForm());
ps.setInt(42, orderInfo1.getRegionId());
ps.setString(43, orderInfo1.getAuroLog());
ps.setString(44, orderInfo1.getClientLog());
ps.setString(45, orderInfo1.getGoodsName());
ps.setString(46, orderInfo1.getGoodPaidBy());
ps.setInt(47, orderInfo1.getVendorStatus());
ps.setString(48, orderInfo1.getNoBhk());
ps.setTimestamp(49, completionDate);
ps.setString(50, orderInfo1.getBillingto());
ps.setString(51, orderInfo1.getOwnername());
ps.setInt(52, orderInfo1.getIsPause());
ps.setInt(53, orderInfo1.getKissantax());
ps.setInt(54, orderInfo1.getSestax());
ps.setInt(55, orderInfo1.getSbstax());
ps.setTimestamp(56, invoiceDate);

							return ps;
						}
				},
				keyHolder);
				
				Number unId = keyHolder.getKey();
				orderInfo1.setId(unId.intValue());
				

		}
		else
		{

			String sql = "UPDATE order_info1  set generated_id = ? ,booked_date = ? ,appointment_date = ? ,appointment_slot_old_id = ? ,appointment_slot_id = ? ,status_id = ? ,contact_number = ? ,contact_email = ? ,address = ? ,total_price = ? ,total_discount = ? ,net_amount = ? ,description = ? ,gender = ? ,service_id = ? ,vendor_id = ? ,sub_category = ? ,is_new_customer = ? ,location_id = ? ,latitude = ? ,longitude = ? ,coupon_code = ? ,is_admin_order = ? ,user_id = ? ,watsup_location = ? ,priority = ? ,customer_name = ? ,client_order_id = ? ,vendor_service_charge = ? ,goods_charge = ? ,margin_value = ? ,no_of_hours_work = ? ,transportaion_charge = ? ,no_of_visits = ? ,fixed_charge = ? ,auro_log_id = ? ,client_log_id = ? ,invoice_file = ? ,feedback_form = ? ,region_id = ? ,auro_log = ? ,client_log = ? ,goodsName = ? ,goodPaidBy = ? ,vendor_status = ? ,no_bhk = ? ,completionDate = ? ,billingto = ? ,ownername = ? ,isPause = ? ,kissantax = ? ,sestax = ? ,sbstax = ? ,invoice_date = ?  where id = ? ";
	
			jdbcTemplate.update(sql, new Object[]{orderInfo1.getGeneratedId(),orderInfo1.getBookedDate(),orderInfo1.getAppointmentDate(),orderInfo1.getAppointmentSlotOldId(),orderInfo1.getAppointmentSlotId(),orderInfo1.getStatusId(),orderInfo1.getContactNumber(),orderInfo1.getContactEmail(),orderInfo1.getAddress(),orderInfo1.getTotalPrice(),orderInfo1.getTotalDiscount(),orderInfo1.getNetAmount(),orderInfo1.getDescription(),orderInfo1.getGender(),orderInfo1.getServiceId(),orderInfo1.getVendorId(),orderInfo1.getSubCategory(),orderInfo1.getIsNewCustomer(),orderInfo1.getLocationId(),orderInfo1.getLatitude(),orderInfo1.getLongitude(),orderInfo1.getCouponCode(),orderInfo1.getIsAdminOrder(),orderInfo1.getUserId(),orderInfo1.getWatsupLocation(),orderInfo1.getPriority(),orderInfo1.getCustomerName(),orderInfo1.getClientOrderId(),orderInfo1.getVendorServiceCharge(),orderInfo1.getGoodsCharge(),orderInfo1.getMarginValue(),orderInfo1.getNoOfHoursWork(),orderInfo1.getTransportaionCharge(),orderInfo1.getNoOfVisits(),orderInfo1.getFixedCharge(),orderInfo1.getAuroLogId(),orderInfo1.getClientLogId(),orderInfo1.getInvoiceFile(),orderInfo1.getFeedbackForm(),orderInfo1.getRegionId(),orderInfo1.getAuroLog(),orderInfo1.getClientLog(),orderInfo1.getGoodsName(),orderInfo1.getGoodPaidBy(),orderInfo1.getVendorStatus(),orderInfo1.getNoBhk(),orderInfo1.getCompletionDate(),orderInfo1.getBillingto(),orderInfo1.getOwnername(),orderInfo1.getIsPause(),orderInfo1.getKissantax(),orderInfo1.getSestax(),orderInfo1.getSbstax(),orderInfo1.getInvoiceDate(),orderInfo1.getId()});
		}
	}
		
		@Transactional
		public void delete(int id) {
			String sql = "DELETE FROM order_info1 WHERE id=?";
			jdbcTemplate.update(sql, new Object[]{id});
		}
		

	 public OrderInfo1 getById(int id) {
			String sql = "SELECT * from order_info1 where id = ? ";
			List<OrderInfo1> retlist = jdbcTemplate.query(sql,
			new Object[]{id},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
			if(retlist.size() > 0)
				return retlist.get(0);
			return null;
		}

	

}
