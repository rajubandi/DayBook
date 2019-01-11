package com.aurospaces.neighbourhood.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.bean.OrderInfoBean;
import com.aurospaces.neighbourhood.bean.OrderStatusBean;
import com.aurospaces.neighbourhood.bean.SMSBean;
import com.aurospaces.neighbourhood.bean.VendorOrderBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.dao.AdminOrderDao;
import com.aurospaces.neighbourhood.dao.OrderInfoDao;
import com.aurospaces.neighbourhood.dao.OrderStatusDao;
import com.aurospaces.neighbourhood.dao.VendorOrderDao;
import com.aurospaces.neighbourhood.dao.VendorRegisrationDao;
import com.aurospaces.neighbourhood.util.EmailSendingUtil;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SMSUtil;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {
	@Autowired
	AdminOrderDao objAdminOrderDao;
	@Autowired
	VendorOrderDao objVendorOrderDao;
	@Autowired
	OrderStatusDao objOrderStatusDao;
	@Autowired
	DataSourceTransactionManager transactionManager;
	@Autowired
	OrderInfoDao objOrderInfoDao;
	@Autowired
	ServletContext objContext;
	 @Autowired
	 VendorRegisrationDao objRegisrationDao;
	@Override
	public List<OrderBean> getOrders(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		try {
			listOrderBeans = objAdminOrderDao.getOrders(objOrderBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;

	}
	
	@Override
	public List<OrderBean> getAllOrders(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		try {
			listOrderBeans = objAdminOrderDao.getAllOrders(objOrderBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;
	}

	@Override
	public boolean assigntoVendor(OrderBean objOrderBean) {
		boolean isInsertVendorOrder = false;
		boolean isInsertOrderService = false;
		boolean isInsert = false;
		boolean isUpdateOrderInfo = false;
		String sUpdatedDate = null;
		String sSchedueDate = null;
		OrderStatusBean objOrderStatusBean = null;
		VendorOrderBean objVendorOrderBean = null;
		TransactionStatus objTransStatus = null;
		TransactionDefinition objTransDef = null;
		OrderInfoBean objOrderInfoBean = null;
		NeighbourhoodUtil objNeighbourhoodUtil =null;
		EmailSendingUtil objEmailSendingUtil = null;
		CustomerBean objCustomerBean = null;
		SMSUtil objSmsUtil = null;
		SMSBean objSmsBean = null;
		VendorRegistrationBean objProfileBean = null;
		try {
			
			
			
			objTransDef = new DefaultTransactionDefinition();
			objTransStatus = transactionManager.getTransaction(objTransDef);
			if (objOrderBean != null) {
				objVendorOrderBean = new VendorOrderBean();
				objVendorOrderBean.setOrderId(objOrderBean.getOrderId());
				objVendorOrderBean.setVendorId(objOrderBean.getVendorId());
				isInsertVendorOrder = objVendorOrderDao.insertVendorOrder(objVendorOrderBean);
			}

			if (isInsertVendorOrder) {
				objOrderStatusBean = new OrderStatusBean();
				objOrderStatusBean.setOrderId(objOrderBean.getOrderId());
				objOrderStatusBean.setStatusId(objOrderBean.getStatusId());
				objOrderStatusBean.setUpdatedBy("1");
				if(StringUtils.isEmpty(sUpdatedDate)){
					objNeighbourhoodUtil = new NeighbourhoodUtil();
					sUpdatedDate = objNeighbourhoodUtil.getCurrentTimestamp("");
					if(StringUtils.isEmpty(sUpdatedDate)){
						objOrderStatusBean.setUpdatedDate(sUpdatedDate);
					}
				}
				objOrderStatusBean.setUpdatedDate(sUpdatedDate);
				isInsertOrderService = objOrderStatusDao.insertOrderStatus(objOrderStatusBean);
				if(isInsertOrderService){
					//orderinfo
					objOrderInfoBean = new OrderInfoBean();
					objOrderInfoBean.setOrderId(objOrderBean.getOrderId());
					sSchedueDate =	objOrderBean.getAppointmentDate();
					System.out.println("sSchedueDate--service"+sSchedueDate);
					objOrderInfoBean.setAppointmentDate(objOrderBean.getAppointmentDate());
					objOrderInfoBean.setAppointmentSlotId(objOrderBean.getTimeSlotId());
					//customer details
					objCustomerBean = objOrderInfoDao.getCustomerDetails(objOrderInfoBean);
					if(objCustomerBean != null){
						objOrderBean.setCustomerAddress(objCustomerBean.getAddress1());
						objOrderBean.setCustomerMobile(objCustomerBean.getMobileNumber());
					}
					/*if(objCustomerBean != null){
						
						System.out.println("after discout--"+objOrderBean.getNetAmount());
						if(StringUtils.isNotBlank(objCustomerBean.getDiscountUsedDate())){
							objOrderInfoBean.setNetAmount(objOrderBean.getNetAmount());
						}else if(StringUtils.isNotBlank(objOrderBean.getNetAmount())){
							double d = Double.parseDouble(objOrderBean.getNetAmount())-Double.parseDouble(objCustomerBean.getCustomerDiscount());
							System.out.println("after discout--"+d);
							if(d <=0 ){
								objOrderInfoBean.setNetAmount("0");
							}else{
								objOrderInfoBean.setNetAmount(String.valueOf(d));
							}
						}
						
					}*/
					
					objOrderInfoBean.setTotalDiscount(objOrderBean.getTotalDiscount());
					objOrderInfoBean.setNetAmount(objOrderBean.getNetAmount());
					objOrderInfoBean.setTotalPrice(objOrderBean.getTotalPrice());
					isUpdateOrderInfo = objOrderInfoDao.updateOrderInfo(objOrderInfoBean);
				}
				if (isUpdateOrderInfo) {
					transactionManager.commit(objTransStatus);
					isInsert = true;
					//vendor details..
					objProfileBean = new VendorRegistrationBean();
					objProfileBean.setVendorId(objOrderBean.getVendorId());
					VendorRegistrationBean objRegistrationBean = objRegisrationDao.getVendor(objProfileBean);
					//for all sms...
					
					objSmsUtil = new SMSUtil();
					objSmsBean = new SMSBean();
					
					objSmsBean.setOrderId(objOrderBean.getOrderId());
					objSmsBean.setDiscount(objOrderBean.getTotalDiscount());
					sSchedueDate = objNeighbourhoodUtil.getSimpleDate(objOrderBean.getAppointmentDate());
					objSmsBean.setScheduleDate(sSchedueDate);
					objSmsBean.setVendorName(objRegistrationBean.getFirstName()+" "+objRegistrationBean.getLastName());
					objSmsBean.setVendorMobile(objRegistrationBean.getMobileNo());
					objSmsBean.setNetAmt(objOrderBean.getNetAmount());
					objSmsBean.setMobileNo(objRegistrationBean.getMobileNo());
					objSmsBean.setCustomerAddress(objCustomerBean.getAddress1());
					
					if("Morning(8-12)".equalsIgnoreCase(objOrderBean.getTimeSlotName())){
						objSmsBean.setScheduleTime("08 AM-12 PM");
					}else if("Afternoon(12-4PM)".equalsIgnoreCase(objOrderBean.getTimeSlotName())){
						objSmsBean.setScheduleTime("12 PM-04 PM");
					}else{
						objSmsBean.setScheduleTime("04 PM-07 PM");
					}
					
						if(objOrderBean.isTimeChange()){
							System.out.println("time changedd..");
							objSmsUtil = new SMSUtil();
							objSmsBean = new SMSBean();
							objSmsBean.setOrderId(objOrderBean.getOrderId());
							sSchedueDate = objNeighbourhoodUtil.getSimpleDate(sSchedueDate);
							objSmsBean.setScheduleDate(sSchedueDate);
							if("Morning(8-12)".equalsIgnoreCase(objOrderBean.getTimeSlotName())){
								objSmsBean.setScheduleTime("08 AM-12 PM");
							}else if("Afternoon(12-4PM)".equalsIgnoreCase(objOrderBean.getTimeSlotName())){
								objSmsBean.setScheduleTime("12 PM-04 PM");
							}else{
								objSmsBean.setScheduleTime("04 PM-07 PM");
							}
							objSmsBean.setDiscount(objOrderBean.getTotalDiscount());
							objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
							objSmsBean.setVendorName(objRegistrationBean.getFirstName()+" "+objRegistrationBean.getLastName());
							objSmsBean.setVendorMobile(objRegistrationBean.getMobileNo());
							objSmsBean.setCustomerId(objCustomerBean.getMobileNumber());
							//objSmsUtil.sendSms(objContext,objSmsBean, "sms_reschedule_customer");
						}
						if(objOrderBean.isStatusChange()){
							//status changing....
							
							/*if(isInsert && "Confirmed".equalsIgnoreCase(objOrderBean.getStatusName())){
								System.out.println("Status...."+objOrderBean.getStatusName());
								if(objRegistrationBean != null){
									objEmailSendingUtil = new EmailSendingUtil();
									objOrderBean.setVendorId(objOrderBean.getVendorId());
									if(objRegistrationBean.getFirstName() != null || objRegistrationBean.getLastName() != null){
										objOrderBean.setVendorName(objRegistrationBean.getFirstName()+" "+objRegistrationBean.getLastName());
										objOrderBean.setContactNo(objRegistrationBean.getMobileNo());
										objOrderBean.setContactEmail(objCustomerBean.getEmail());
										//sms to customer about vendor
										objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
										if(StringUtils.isNotBlank(objOrderBean.getNetAmount()) && Integer.parseInt(objOrderBean.getNetAmount()) > 0){
											objSmsUtil.sendSms(objContext,objSmsBean, "sms_cusotmer_orderpriceconfirm");	
										}else if("0".equalsIgnoreCase(objOrderBean.getNetAmount()) && !("0".equalsIgnoreCase(objOrderBean.getTotalPrice()))){
											objSmsUtil.sendSms(objContext,objSmsBean, "sms_cusotmer_freeprice");
										}
										else{
											objSmsUtil.sendSms(objContext,objSmsBean, "customerToAdmin");	
										}
										//sms to vendor confirmation
										objSmsBean.setMobileNo(objRegistrationBean.getMobileNo());
										objSmsUtil.sendSms(objContext,objSmsBean, "sms_vendor_confirmation" );
										
										//sms to vendor about customer
										objSmsBean.setCustomerId(objCustomerBean.getMobileNumber());
										objSmsUtil.sendSms(objContext,objSmsBean, "vendor_customer_details" );
									}
									objEmailSendingUtil.sendCustomerReport(objOrderBean, objContext, "customer_vendor");
									//objEmailSendingUtil.sendCustomerReport(objOrderBean, objContext, "vendor");
								}
							}
							
							if(isInsert && "Price On Inspection".equalsIgnoreCase(objOrderBean.getStatusName())){
								System.out.println("Status...."+objOrderBean.getStatusName());
								//sms to customer
								objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
								if(StringUtils.isNotBlank(objOrderBean.getNetAmount()) && Integer.parseInt(objOrderBean.getNetAmount()) > 0){
									objSmsUtil.sendSms(objContext,objSmsBean, "sms_customer_oninspection" );	
								}else if("0".equalsIgnoreCase(objOrderBean.getNetAmount()) && !("0".equalsIgnoreCase(objOrderBean.getTotalPrice()))){
									objSmsUtil.sendSms(objContext,objSmsBean, "sms_cusotmer_freeprice");
								}
								//sms to vendor
								objSmsBean.setMobileNo(objRegistrationBean.getMobileNo());
								if(StringUtils.isNotBlank(objOrderBean.getNetAmount()) && Integer.parseInt(objOrderBean.getNetAmount()) > 0){
									objSmsUtil.sendSms(objContext,objSmsBean, "sms_vendor_oninspection" );
								}
								else if("0".equalsIgnoreCase(objOrderBean.getNetAmount()) && !("0".equalsIgnoreCase(objOrderBean.getTotalPrice()))){
									objSmsUtil.sendSms(objContext,objSmsBean, "sms_vendor_oninspectionfree");
								}
							}
							if(isInsert && "Cancel".equalsIgnoreCase(objOrderBean.getStatusName())){
								System.out.println("Status...."+objOrderBean.getStatusName());
								//sms to customer
								objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
								objSmsUtil.sendSms(objContext,objSmsBean, "cancelCustomer" );
								//sms to vendor
								objSmsBean.setMobileNo(objRegistrationBean.getMobileNo());
								objSmsUtil.sendSms(objContext,objSmsBean, "cancelVendor" );
								
							}
							if(isInsert && "Paid".equalsIgnoreCase(objOrderBean.getStatusName())){
								System.out.println("Status...."+objOrderBean.getStatusName());
								
								//sms to customer
								objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
								objSmsUtil.sendSms(objContext,objSmsBean, "paidCustomer" );
								//sms to vendor
								objSmsBean.setNetAmt("");
								objSmsBean.setMobileNo(objRegistrationBean.getMobileNo());
								objSmsUtil.sendSms(objContext,objSmsBean, "paidVendor");
								//sms to customer
								objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
								objSmsUtil.sendSms(objContext,objSmsBean, "sms_customer_feedback" );
								//emai to customer regarding feedback
								if(objCustomerBean != null){
									objEmailSendingUtil = new EmailSendingUtil();
									objOrderBean.setContactEmail(objCustomerBean.getEmail());
									objEmailSendingUtil.sendCustomerReport(objOrderBean, objContext, "customer_feedback");
								}
							}
							if(isInsert && "Sample Collected".equalsIgnoreCase(objOrderBean.getStatusName())){
								System.out.println("Status...."+objOrderBean.getStatusName());
								objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
								objSmsUtil.sendSms(objContext,objSmsBean, "Customer_Sample_Collected" );
							}
							if(isInsert && "Reports Uploaded".equalsIgnoreCase(objOrderBean.getStatusName())){
								System.out.println("Status...."+objOrderBean.getStatusName());
								objSmsBean.setMobileNo(objCustomerBean.getMobileNumber());
								objSmsUtil.sendSms(objContext,objSmsBean, "Customer_reports_upload" );
							}*/
							
						}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return isInsert;
	}

	@Override
	public List<OrderBean> searchPhoneNumber(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		try {
			listOrderBeans = objAdminOrderDao.searchPhoneNumber(objOrderBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;

	}

	@Override
	public List<OrderBean> searchEmail(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		try {
			listOrderBeans = objAdminOrderDao.searchEmail(objOrderBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;
	}

	@Override
	public OrderBean getServiceId(OrderBean objOrderBean) {
		OrderBean objOrderBeans = null;
		try {
		objOrderBeans = objAdminOrderDao.getServiceId(objOrderBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objOrderBeans;
	}

	@Override
	public List<OrderBean> getAllPathologyOrders(OrderBean objOrderBean) {
		List<OrderBean> listOrderBeans = null;
		try {
			listOrderBeans = objAdminOrderDao.getAllPathologyOrders(objOrderBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listOrderBeans;
	}

}
