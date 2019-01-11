/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.bean.OrderDescriptionBean;
import com.aurospaces.neighbourhood.bean.OrderInfoBean;
import com.aurospaces.neighbourhood.bean.OrderLocationBean;
import com.aurospaces.neighbourhood.bean.OrderServiceBean;
import com.aurospaces.neighbourhood.bean.OrderStatusBean;
import com.aurospaces.neighbourhood.bean.OrderUserBean;
import com.aurospaces.neighbourhood.bean.SMSBean;
import com.aurospaces.neighbourhood.bean.ServicesBean;
import com.aurospaces.neighbourhood.bean.StatusBean;
import com.aurospaces.neighbourhood.dao.CustomerDiscountDao;
import com.aurospaces.neighbourhood.dao.OrderDescriptionDao;
import com.aurospaces.neighbourhood.dao.OrderInfoDao;
import com.aurospaces.neighbourhood.dao.OrderLocationDao;
import com.aurospaces.neighbourhood.dao.OrderServiceDao;
import com.aurospaces.neighbourhood.dao.OrderStatusDao;
import com.aurospaces.neighbourhood.dao.OrderUserDao;
import com.aurospaces.neighbourhood.dao.ServiceDao;
import com.aurospaces.neighbourhood.util.EmailSendingUtil;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SMSUtil;

/**
 * @author YOGI
 * 
 */
@Service
public class BookingOrderServiceImpl implements BookingOrderService {
	@Autowired
	OrderInfoDao objOrderInfoDao;
	@Autowired
	DataSourceTransactionManager transactionManager;
	@Autowired
	StatusBean objStatusBean;
	@Autowired
	StatusService objStatusService;
	@Autowired
	OrderStatusDao objOrderStatusDao;
	@Autowired
	OrderServiceDao objOrderServiceDao;
	@Autowired
	OrderUserDao objOrderUserDao;
	@Autowired
	ServicesBean objServicesBean;
	@Autowired
	ServiceDao objServiceDao;
	@Autowired
	OrderLocationDao objOrderLocationDao;
	@Autowired
	ServletContext objContext;
	Logger objLogger = Logger.getLogger(BookingOrderServiceImpl.class);
	@Autowired
	OrderDescriptionDao objOrderDescriptionDao;
	@Autowired
	CustomerDiscountDao objCustomerDiscountDao;
	
	@Override
	public boolean insertOrderInformation(OrderInfoBean objOrderInfoBean) {
		boolean isInsertOrderInfo = false;
		String sOrederId = null;
		TransactionStatus objTransStatus = null;
		TransactionDefinition objTransDef = null;
		OrderStatusBean objOrderStatusBean = null;
		NeighbourhoodUtil objNeighbourhoodUtil = null;
		OrderServiceBean objOrderServiceBean = null;
		ServicesBean objLocalServicesBean = null;
		StatusBean objLocalStatusBean = null;
		EmailSendingUtil objEmailSendingUtil = null;
		OrderUserBean objOrderUserBean = null;
		Properties objProperties = null;
		InputStream objStream = null;
		String sPropFilePath = null;
		OrderBean objOrderBean = null;
		CustomerBean objCustomerBean = null;
		SMSBean objSmsBean = null;
		SMSUtil objSmsUtil = null;
		String sServiceName = null;
		OrderDescriptionBean objOrderDescriptionBean = null;
		String sStatusId = null;
		String sCustomerDiscount = null;
		OrderLocationBean objOrderLocationBean = null;
		boolean isCustomerDiscInsert = false;
		try {
			objTransDef = new DefaultTransactionDefinition();
			objTransStatus = transactionManager.getTransaction(objTransDef);
			objNeighbourhoodUtil = new NeighbourhoodUtil();
			synchronized (objNeighbourhoodUtil) {
				sOrederId = objNeighbourhoodUtil.randNum();
			}
			
			System.out.println("booking order service orderId..."+sOrederId);

			if (StringUtils.isNotEmpty(sOrederId)) {
				objOrderInfoBean.setOrderId(sOrederId);
				if(objOrderInfoBean.isNewCustomer()){
					//getting discounted price...
					sPropFilePath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
					if(StringUtils.isNotBlank(sPropFilePath)){
						objProperties = new Properties();
						objStream = new FileInputStream(sPropFilePath);
						objProperties.load(objStream);
						sCustomerDiscount = objProperties.getProperty("CustomerDiscount");
						if(StringUtils.isNotBlank(sCustomerDiscount)){
								objOrderInfoBean.setNetAmount("-"+sCustomerDiscount);
							//objPathologyOrderInfoBean.setNetAmount(objPathologyOrderInfoBean.getNetAmount());
							System.out.println("after first discoutn---"+objOrderInfoBean.getNetAmount());
						}
					}
				}
				boolean isInfoInsert = objOrderInfoDao
						.insertOrderInfo(objOrderInfoBean);
				objLogger.error("insert into orderinfo--" + isInfoInsert);
				if (isInfoInsert) {
					objStatusBean.setStatusName("Ordered");
					objStatusBean.setServiceId(objOrderInfoBean.getServiceId());
					objLocalStatusBean = objStatusService.getStatus(
							objStatusBean, null);

					if (objLocalStatusBean != null) {
						sStatusId = objLocalStatusBean.getStatusId();
						objOrderStatusBean = new OrderStatusBean();
						objOrderStatusBean.setOrderId(sOrederId);
						objOrderStatusBean.setStatusId(sStatusId);
						objOrderStatusBean.setUpdatedDate(objOrderInfoBean
								.getBookedDate());
						objOrderStatusBean.setUpdatedBy(objOrderInfoBean
								.getCustomerId());
						boolean isStatusInsert = objOrderStatusDao
								.insertOrderStatus(objOrderStatusBean);
						objLogger.error("insert into OrderStatus--"
								+ isStatusInsert);
						if (isStatusInsert) {
							objOrderServiceBean = new OrderServiceBean();
							objOrderServiceBean.setOrderId(sOrederId);
							objOrderServiceBean.setServiceId(objOrderInfoBean
									.getServiceId());
							boolean isOrderService = objOrderServiceDao
									.isInsertOrderService(objOrderServiceBean);
							if (isOrderService) {
								objOrderUserBean = new OrderUserBean();
								objOrderUserBean.setCustomerId(objOrderInfoBean
										.getCustomerId());
								objOrderUserBean.setOrderId(sOrederId);
								boolean isOrderUser = objOrderUserDao
										.isInserOrderUser(objOrderUserBean);
								objOrderDescriptionBean = new OrderDescriptionBean();
								objOrderDescriptionBean.setOrderDescription(objOrderInfoBean.getOrderDescription());
								objOrderDescriptionBean.setOrderId(sOrederId);
								boolean isOrderDesc = objOrderDescriptionDao.insertOrderDescription(objOrderDescriptionBean);
								objOrderLocationBean = new OrderLocationBean();
								objOrderLocationBean.setOrderId(sOrederId);
								objOrderLocationBean.setLocationId(objOrderInfoBean.getLocationId());
								boolean isOrderLocation = objOrderLocationDao.insertOrderLocation(objOrderLocationBean);
								//
								System.out.println("sCustomerDiscount--"+sCustomerDiscount);
								if(StringUtils.isNotBlank(sCustomerDiscount)){
									objCustomerBean = new CustomerBean();
									objCustomerBean.setOrderId(sOrederId);
									objCustomerBean.setCustomerId(objOrderInfoBean.getCustomerId());
									objCustomerBean.setRegisterDate(objOrderInfoBean.getBookedDate());
									if(StringUtils.isNotBlank(sCustomerDiscount)){
										objCustomerBean.setCustomerDiscount(sCustomerDiscount);	
									}
									isCustomerDiscInsert = objCustomerDiscountDao.isInsertCustomerDiscount(objCustomerBean);
									System.out.println("new customer discount---"+isCustomerDiscInsert);
								}
								
								if (isOrderUser && isOrderDesc && isOrderLocation) {
									transactionManager.commit(objTransStatus);
									isInsertOrderInfo = true;
									objEmailSendingUtil = new EmailSendingUtil();
									objOrderBean = new OrderBean();
									objOrderBean.setOrderId(sOrederId);
									objOrderBean.setContactNo(objOrderInfoBean.getContactNo());
									if (objOrderInfoBean.getServiceId() != null) {
										/*objServicesBean.setServiceId(objOrderInfoBean.getServiceId());
										objLocalServicesBean = new ServicesBean();
										objLocalServicesBean = objServiceDao.getServiceName(objServicesBean, null);*/
										sServiceName = objOrderInfoBean.getServiceName();
										if (StringUtils.isNotEmpty(sServiceName)) {	
											objOrderBean.setServiceName(sServiceName);
											objOrderBean.setContactEmail(objOrderInfoBean.getContactEmail());
											objOrderBean.setAppointmentDate(objOrderInfoBean.getAppointmentDate());
											objOrderBean.setBookedDate(objOrderInfoBean.getBookedDate());
											objOrderBean.setNetAmount(objOrderInfoBean.getNetAmount());
											objOrderBean.setTimeName(objOrderInfoBean.getTimeName());
											objOrderBean.setSheduleName(objOrderInfoBean.getSheduleName());
											objOrderBean.setCustomerId(objOrderInfoBean.getContactNo());
											objOrderBean.setCustomerAddress(objOrderInfoBean.getOrderAddress());
											System.out.println("time name in service=---"+objOrderInfoBean.getAppointmentDate());
											if(StringUtils.isNotBlank(objOrderInfoBean.getNetAmount()) && Integer.parseInt(objOrderInfoBean.getNetAmount()) > 0){
												objOrderBean.setNetAmount(objOrderInfoBean.getNetAmount());
											}else{
												objOrderBean.setNetAmount("Cash on service");
											}
											//objEmailSendingUtil	.sendCustomerReport(objOrderBean,objContext,"customer");
											//objEmailSendingUtil	.sendCustomerReport(objOrderBean,objContext,"admin");
										}
										objSmsUtil = new SMSUtil();
										objSmsBean = new SMSBean();
										objSmsBean.setOrderId(sOrederId);
										if(StringUtils.isNotBlank(objOrderInfoBean.getNetAmount()) && Integer.parseInt(objOrderInfoBean.getNetAmount()) > 0){
											objSmsBean.setNetAmt(objOrderInfoBean.getNetAmount());
										}else{
											objSmsBean.setNetAmt("Cash on service");
										}
										/*objSmsBean.setMobileNo(objOrderInfoBean.getContactNo());
										objSmsUtil.sendSms(objContext,objSmsBean, "customer");
										//objSmsBean.setMobileNo("9742557757");
										objSmsBean.setMobileNo("7676575029");
										objSmsUtil.sendSms(objContext,objSmsBean, "order_admin");*/
									}
								} else {

									System.out
											.println("fail in insertPathologyOrderInfo() in PathologyOrderInfoDaoImpl ");
									//transactionManager.rollback(objTransStatus);
								}
							}

						}
					}
				}
			}
		} catch (Exception e) {
			objLogger
					.error("error ing insertOrderInformation() in bokkingOrderServiceImpl");
			transactionManager.rollback(objTransStatus);
			e.printStackTrace();
		} finally {
		}
		return isInsertOrderInfo;
	}

	@Override
	public ServicesBean getServiceName(ServicesBean objServicesBean) {
		try{
			
			objServicesBean = objServiceDao.getServiceName(objServicesBean, "");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
		}
		
		return objServicesBean;
	}
}
