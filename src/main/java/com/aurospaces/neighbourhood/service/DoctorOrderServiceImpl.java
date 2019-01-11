package com.aurospaces.neighbourhood.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.DoctorOrderBean;
import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.bean.OrderDescriptionBean;
import com.aurospaces.neighbourhood.bean.OrderDoctorTypeBean;
import com.aurospaces.neighbourhood.bean.OrderInfoBean;
import com.aurospaces.neighbourhood.bean.OrderLocationBean;
import com.aurospaces.neighbourhood.bean.OrderServiceBean;
import com.aurospaces.neighbourhood.bean.OrderStatusBean;
import com.aurospaces.neighbourhood.bean.OrderUserBean;
import com.aurospaces.neighbourhood.bean.SMSBean;
import com.aurospaces.neighbourhood.bean.StatusBean;
import com.aurospaces.neighbourhood.dao.CustomerDiscountDao;
import com.aurospaces.neighbourhood.dao.DoctorOrderDao;
import com.aurospaces.neighbourhood.dao.OrderDescriptionDao;
import com.aurospaces.neighbourhood.dao.OrderDoctorTypeDao;
import com.aurospaces.neighbourhood.dao.OrderInfoDao;
import com.aurospaces.neighbourhood.dao.OrderLocationDao;
import com.aurospaces.neighbourhood.dao.OrderServiceDao;
import com.aurospaces.neighbourhood.dao.OrderStatusDao;
import com.aurospaces.neighbourhood.dao.OrderSymptomsDao;
import com.aurospaces.neighbourhood.dao.OrderUserDao;
import com.aurospaces.neighbourhood.util.EmailSendingUtil;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SMSUtil;

@Service
public class DoctorOrderServiceImpl implements DoctorOrderService {
	@Autowired
	DoctorOrderDao objDoctorOrderDao;
	@Autowired
	DataSourceTransactionManager transactionManager;
	@Autowired
	StatusService objStatusService;
	@Autowired
	OrderInfoDao objOrderInfoDao;
	@Autowired
	OrderSymptomsDao objOrderSymptomsDao;
	@Autowired
	OrderDoctorTypeDao objOrderDoctorTypeDao;
	@Autowired
	OrderStatusDao objOrderStatusDao;
	@Autowired
	OrderUserDao objOrderUserDao;
	@Autowired
	OrderServiceDao objOrderServiceDao;
	@Autowired
	OrderDescriptionDao objOrderDescriptionDao;
	@Autowired
	OrderLocationDao objOrderLocationDao;
	@Autowired
	ServletContext objContext;
	@Autowired
	CustomerDiscountDao objCustomerDiscountDao;
	@Override
	public boolean insertDocterOrder(DoctorOrderBean objDoctorOrderBean) {
		boolean isInsert = false;
		TransactionStatus objTransStatus = null;
		TransactionDefinition objTransDef = null;
		boolean isInsertOrderInfo = false;
		boolean isOrderSymptemsInsert = false;
		boolean isOrderDocterTypeInsert = false;
		boolean isOrderStatus = false;
		boolean isOrderUser = false;
		boolean isOrderService = false;
		boolean isCustomerDiscInsert = false;
		Properties objProperties = null;
		InputStream objStream = null;
		String sPropFilePath = null;
		OrderBean objOrderBean = null;
		CustomerBean objCustomerBean = null;
		SMSBean objSmsBean = null;
		SMSUtil objSmsUtil = null;
		StatusBean objStatusBean = null;
		StatusBean objLocalStatusBean = null;
		OrderInfoBean objOrderInfoBean = null;
		NeighbourhoodUtil objNeighbourhoodUtil = null;
		OrderDoctorTypeBean objDoctorTypeBean =null;
		OrderStatusBean objOrderStatusBean = null;
		OrderUserBean objOrderUserBean = null;
		OrderServiceBean objOrderServiceBean = null;
		EmailSendingUtil objEmailSendingUtil = null;
		OrderLocationBean objOrderLocationBean = null;
		OrderDescriptionBean objOrderDescriptionBean = null;
		String sDate = null;
		String sOrederId = null;
		String sCustomerDiscount = null;
		try {
			objTransDef = new DefaultTransactionDefinition();
			objTransStatus = transactionManager.getTransaction(objTransDef);
			objNeighbourhoodUtil = new NeighbourhoodUtil();
			synchronized (objNeighbourhoodUtil) {
				sOrederId = objNeighbourhoodUtil.randNum();
			}
			if (!StringUtils.isEmpty(sOrederId)) {
				objDoctorOrderBean.setOrderId(sOrederId);
				objOrderInfoBean = new OrderInfoBean();
				sDate = objNeighbourhoodUtil.getCurrentTimestamp("");
				objOrderInfoBean.setOrderId(objDoctorOrderBean.getOrderId());
				objOrderInfoBean.setAppointmentDate(objDoctorOrderBean.getAppointmentDate());
				objOrderInfoBean.setAppointmentSlotId(objDoctorOrderBean.getAppointmentSlotId());
				objOrderInfoBean.setContactEmail(objDoctorOrderBean.getContactEmail());
				objOrderInfoBean.setContactNo(objDoctorOrderBean.getContactNo());
				objOrderInfoBean.setBookedDate(objDoctorOrderBean.getBookedDate());
				objOrderInfoBean.setTotalPrice(objDoctorOrderBean.getTotalPrice());
				objOrderInfoBean.setTotalDiscount(objDoctorOrderBean.getTotalDiscount());
				objOrderInfoBean.setNetAmount(objDoctorOrderBean.getNetAmount());
				objOrderInfoBean.setOrderAddress(objDoctorOrderBean.getOrderAddress());
				if(objDoctorOrderBean.isNewCustomer()){
					//getting discounted price...
					sPropFilePath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
					if(StringUtils.isNotBlank(sPropFilePath)){
						objProperties = new Properties();
						objStream = new FileInputStream(sPropFilePath);
						objProperties.load(objStream);
						sCustomerDiscount = objProperties.getProperty("CustomerDiscount");
						/*if(StringUtils.isNotBlank(sCustomerDiscount)){
							double d = Double.parseDouble(objDoctorOrderBean.getNetAmount())-Double.parseDouble(sCustomerDiscount);
							if(d <= 0){
								objOrderInfoBean.setNetAmount("0");
							}else{
								objOrderInfoBean.setNetAmount(String.valueOf(d));
							}
							objDoctorOrderBean.setNetAmount(objOrderInfoBean.getNetAmount());
							System.out.println("after first discoutn---"+d);
						}*/
					}
				}
					
				isInsertOrderInfo = objOrderInfoDao.insertOrderInfo(objOrderInfoBean);
				
				if (isInsertOrderInfo) {
					isOrderSymptemsInsert = objOrderSymptomsDao.insertOrderSymptoms(objDoctorOrderBean);
					
					if (isOrderSymptemsInsert) {
						objDoctorTypeBean = new OrderDoctorTypeBean();
						objDoctorTypeBean.setDocotorTypeId(objDoctorOrderBean.getDoctortypeId());
						objDoctorTypeBean.setOrderId(objDoctorOrderBean.getOrderId());
						isOrderDocterTypeInsert = objOrderDoctorTypeDao.insertOrderDoctorTye(objDoctorTypeBean);
								
						if (isOrderDocterTypeInsert) {
							objStatusBean = new StatusBean();
							objStatusBean.setStatusName("Ordered");
							objStatusBean.setServiceId(objDoctorOrderBean.getServiceId());
							objLocalStatusBean = objStatusService.getStatus(objStatusBean, null);
							objOrderStatusBean = new OrderStatusBean();
							objOrderStatusBean.setStatusId(objLocalStatusBean.getStatusId());
							objOrderStatusBean.setUpdatedDate(sDate);
							objOrderStatusBean.setOrderId(objDoctorOrderBean.getOrderId());
							objOrderStatusBean.setUpdatedBy(objDoctorOrderBean.getCustomerId());
							isOrderStatus = objOrderStatusDao.insertOrderStatus(objOrderStatusBean);
							if (isOrderStatus) {
								objOrderUserBean = new OrderUserBean();
								objOrderUserBean.setCustomerId(objDoctorOrderBean	.getCustomerId());
								objOrderUserBean.setOrderId(objDoctorOrderBean.getOrderId());
								isOrderUser = objOrderUserDao.isInserOrderUser(objOrderUserBean);
								objOrderDescriptionBean = new OrderDescriptionBean();
								objOrderDescriptionBean.setOrderDescription(objDoctorOrderBean.getOrderDescription());
								objOrderDescriptionBean.setOrderId(sOrederId);
								boolean isInserOrderDescription = objOrderDescriptionDao.insertOrderDescription(objOrderDescriptionBean);
								System.out.println("isInsertDescription--"+isInserOrderDescription);
								if(isInserOrderDescription){
									objOrderLocationBean = new OrderLocationBean();
									objOrderLocationBean.setOrderId(sOrederId);
									System.out.println("loc----"+objDoctorOrderBean.getLocationId());
									objOrderLocationBean.setLocationId(objDoctorOrderBean.getLocationId());
									objOrderLocationDao.insertOrderLocation(objOrderLocationBean);
								}
								if (isOrderUser) {
									objOrderServiceBean = new OrderServiceBean();
									objOrderServiceBean.setServiceId(objDoctorOrderBean.getServiceId());
									objOrderServiceBean.setOrderId(objDoctorOrderBean.getOrderId());
									isOrderService = objOrderServiceDao.isInsertOrderService(objOrderServiceBean);
									if (isOrderService ) {
										if(objDoctorOrderBean.isNewCustomer()){
											//customer discount related stuff..
											objCustomerBean = new CustomerBean();
											objCustomerBean.setOrderId(sOrederId);
											objCustomerBean.setCustomerId(objDoctorOrderBean.getCustomerId());
											objCustomerBean.setRegisterDate(objDoctorOrderBean.getBookedDate());
												/*//getting discounted price...
												sPropFilePath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
												if(StringUtils.isNotBlank(sPropFilePath)){
													objProperties = new Properties();
													objStream = new FileInputStream(sPropFilePath);
													objProperties.load(objStream);
													sCustomerDiscount = objProperties.getProperty("CustomerDiscount");
													System.out.println("sCustomerDiscount--"+sCustomerDiscount);*/
													if(StringUtils.isNotBlank(sCustomerDiscount)){
														objCustomerBean.setCustomerDiscount(sCustomerDiscount);	
													}
													isCustomerDiscInsert = objCustomerDiscountDao.isInsertCustomerDiscount(objCustomerBean);
													
												}
										}
										
										if (isOrderDocterTypeInsert) {
											transactionManager.commit(objTransStatus);
											objEmailSendingUtil = new EmailSendingUtil();
											objOrderBean = new OrderBean();
											objOrderBean.setOrderId(objDoctorOrderBean.getOrderId());
											objOrderBean.setContactEmail(objDoctorOrderBean.getContactEmail());
											objOrderBean.setAppointmentDate(objDoctorOrderBean.getAppointmentDate());
											objOrderBean.setBookedDate(objDoctorOrderBean.getBookedDate());
											objOrderBean.setNetAmount(objDoctorOrderBean.getNetAmount());
											objOrderBean.setTimeName(objDoctorOrderBean.getTimeName());
											objOrderBean.setSheduleName(objDoctorOrderBean.getScheduleName());
											objOrderBean.setCustomerId(objDoctorOrderBean.getContactNo());
											objOrderBean.setCustomerAddress(objDoctorOrderBean.getOrderAddress());
											objOrderBean.setServiceName("Doctor");
											//objEmailSendingUtil.sendCustomerReport(objOrderBean, objContext, "customer");
											//objEmailSendingUtil.sendCustomerReport(objOrderBean, objContext, "admin");
											objSmsUtil = new SMSUtil();
											objSmsBean = new SMSBean();
											objSmsBean.setOrderId(sOrederId);
											objSmsBean.setMobileNo(objOrderInfoBean.getContactNo());
											objSmsBean.setNetAmt(objDoctorOrderBean.getNetAmount());
											/*objSmsUtil.sendSms(objContext,objSmsBean, "customer");
											//objSmsBean.setMobileNo("9742557757");
											objSmsBean.setMobileNo("7676575029");
											objSmsUtil.sendSms(objContext,objSmsBean, "order_admin");*/
											isInsert = true;
										}
									}
								}
							}

						}
					}
				}
			
	/*}*/
		} catch (Exception e) {
			//transactionManager.rollback(objTransStatus);
			e.printStackTrace();
		}

		return isInsert;
	}
}
