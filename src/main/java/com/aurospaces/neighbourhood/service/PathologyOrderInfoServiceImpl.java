package com.aurospaces.neighbourhood.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
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
import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.bean.OrderDescriptionBean;
import com.aurospaces.neighbourhood.bean.OrderLocationBean;
import com.aurospaces.neighbourhood.bean.OrderServiceBean;
import com.aurospaces.neighbourhood.bean.OrderStatusBean;
import com.aurospaces.neighbourhood.bean.OrderUserBean;
import com.aurospaces.neighbourhood.bean.PathologyDetailsBean;
import com.aurospaces.neighbourhood.bean.PathologyOrderInfoBean;
import com.aurospaces.neighbourhood.bean.SMSBean;
import com.aurospaces.neighbourhood.bean.StatusBean;
import com.aurospaces.neighbourhood.dao.CustomerDiscountDao;
import com.aurospaces.neighbourhood.dao.OrderDescriptionDao;
import com.aurospaces.neighbourhood.dao.OrderLocationDao;
import com.aurospaces.neighbourhood.dao.OrderPackageDao;
import com.aurospaces.neighbourhood.dao.OrderServiceDao;
import com.aurospaces.neighbourhood.dao.OrderStatusDao;
import com.aurospaces.neighbourhood.dao.OrderUserDao;
import com.aurospaces.neighbourhood.dao.PathologyOrderDetailsDao;
import com.aurospaces.neighbourhood.dao.PathologyOrderInfoDao;
import com.aurospaces.neighbourhood.util.EmailSendingUtil;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SMSUtil;

@Service
public class PathologyOrderInfoServiceImpl implements PathologyOrderInfoService {
	@Autowired
	PathologyOrderInfoDao objPathologyAddDao;
	@Autowired
	PathologyOrderInfoDao objPathologyOrderInfoDao;
	@Autowired
	PathologyOrderDetailsDao objPathologyOrderDetailsDao;
	@Autowired
	DataSourceTransactionManager transactionManager;
	@Autowired
	OrderStatusDao objOrderStatusDao;
	@Autowired
	StatusService objStatusService;
	@Autowired
	StatusBean objStatusBean;
	@Autowired
	OrderServiceDao objOrderServiceDao;
	@Autowired
	OrderUserDao objOrderUserDao;
	@Autowired
	ServletContext objContext;
	@Autowired
	OrderDescriptionDao objOrderDescriptionDao;
	@Autowired
	OrderLocationDao objOrderLocationDao;
	@Autowired
	OrderPackageDao objOrderPackageDao;
	@Autowired
	CustomerDiscountDao objCustomerDiscountDao;

	@Override
	public boolean getPathologyDetails(
			List<PathologyDetailsBean> objPathologyAddBean, String pathologyId) {
		boolean isInsert = false;
		try {
			// isInsert=objPathologyAddDao.getPathologyDetails(objPathologyAddBean,pathologyId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isInsert;
	}

	@Override
	public String getPathologyOrderInfo(
			PathologyOrderInfoBean objPathologyOrderInfoBean) {
		String isInsert = null;
		try {

			// isInsert=objPathologyAddDao.getPathologyOrderInfo(objPathologyOrderInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isInsert;

	}

	@Override
	public boolean insertPathologyOrderInfo(
			PathologyOrderInfoBean objPathologyOrderInfoBean) {
		String sOrederId = null;
		boolean isInsert = false;
		TransactionStatus objTransStatus = null;
		TransactionDefinition objTransDef = null;
		OrderStatusBean objOrderStatusBean = null;
		OrderServiceBean objOrderServiceBean = null;
		StatusBean objLocalStatusBean = null;
		EmailSendingUtil objEmailSendingUtil = null;
		OrderUserBean objOrderUserBean = null;
		OrderLocationBean objOrderLocationBean = null;
		NeighbourhoodUtil objNeighbourhoodUtil = null;
		Properties objProperties = null;
		InputStream objStream = null;
		String sPropFilePath = null;
		OrderBean objOrderBean = null;
		CustomerBean objCustomerBean = null;
		SMSBean objSmsBean = null;
		SMSUtil objSmsUtil = null;
		String sStatusId = null;
		String isPackageID = null;
		String isOthersID = null;
		String sCustomerDiscount = null;
		boolean isDetailInsert =false;
		boolean isCustomerDiscInsert = false;
		OrderDescriptionBean objOrderDescriptionBean = null;
		try {
			objTransDef = new DefaultTransactionDefinition();
			objTransStatus = transactionManager.getTransaction(objTransDef);
			objNeighbourhoodUtil = new NeighbourhoodUtil();
			synchronized (objNeighbourhoodUtil) {
				sOrederId = objNeighbourhoodUtil.randNum();
			}
			if (StringUtils.isNotEmpty(sOrederId)) {
				objPathologyOrderInfoBean.setOrderId(sOrederId);
				System.out.println(sOrederId+"pathology order id---"+objPathologyOrderInfoBean.getOrderId());
				if(objPathologyOrderInfoBean.isNewCustomer()){
					//getting discounted price...
					sPropFilePath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
					if(StringUtils.isNotBlank(sPropFilePath)){
						objProperties = new Properties();
						objStream = new FileInputStream(sPropFilePath);
						objProperties.load(objStream);
						sCustomerDiscount = objProperties.getProperty("CustomerDiscount");
						/*if(StringUtils.isNotBlank(sCustomerDiscount)){
							double d = Double.parseDouble(objPathologyOrderInfoBean.getNetAmount())-Double.parseDouble(sCustomerDiscount);
							if(d <= 0){
								objPathologyOrderInfoBean.setNetAmount("0");
							}else{
								objPathologyOrderInfoBean.setNetAmount(String.valueOf(d));
							}
							//objPathologyOrderInfoBean.setNetAmount(objPathologyOrderInfoBean.getNetAmount());
							System.out.println("after first discoutn---"+d);
						}*/
					}
				}
				}
				
				boolean isInfoInsert = objPathologyOrderInfoDao.insertPathologyOrderInfo(objPathologyOrderInfoBean);
				if (isInfoInsert) {
					isPackageID = objPathologyOrderInfoBean.getIsPackageID();
					isOthersID = objPathologyOrderInfoBean.getIsOthersID();
					System.out.println("isPackageID...."+isPackageID);
					System.out.println("isOthersID.."+isOthersID);
					
					if("true".equals(isOthersID)){
					isDetailInsert = objPathologyOrderDetailsDao
								.insertPathologyOrderDetails(objPathologyOrderInfoBean);
					}
					if("true".equals(isPackageID)){
						isDetailInsert = objOrderPackageDao.insertOrderPackage(objPathologyOrderInfoBean);
					}
					if (isDetailInsert) {
						objStatusBean.setStatusName("Ordered");
						objStatusBean.setServiceId(objPathologyOrderInfoBean
								.getServiceId());
						objLocalStatusBean = objStatusService.getStatus(
								objStatusBean, null);
						if (objLocalStatusBean != null) {
							sStatusId = objLocalStatusBean.getStatusId();
							objOrderStatusBean = new OrderStatusBean();
							objOrderStatusBean.setOrderId(sOrederId);
							objOrderStatusBean.setStatusId(sStatusId);
							objOrderStatusBean
									.setUpdatedDate(objPathologyOrderInfoBean
											.getBookedDate());
						}
						objOrderStatusBean
								.setUpdatedBy(objPathologyOrderInfoBean
										.getCustomerId());
						boolean isStatusInsert = objOrderStatusDao
								.insertOrderStatus(objOrderStatusBean);
						if (isStatusInsert) {
							objOrderServiceBean = new OrderServiceBean();
							objOrderServiceBean.setOrderId(sOrederId);
							objOrderServiceBean
									.setServiceId(objPathologyOrderInfoBean
											.getServiceId());
							boolean isOrderService = objOrderServiceDao
									.isInsertOrderService(objOrderServiceBean);
							if (isOrderService) {
								objOrderUserBean = new OrderUserBean();
								objOrderUserBean
										.setCustomerId(objPathologyOrderInfoBean
												.getCustomerId());
								objOrderUserBean.setOrderId(sOrederId);
								boolean isOrderUser = objOrderUserDao.isInserOrderUser(objOrderUserBean);
								if(isOrderUser){
								objOrderDescriptionBean = new OrderDescriptionBean();
								objOrderDescriptionBean.setOrderId(sOrederId);
								objOrderDescriptionBean.setOrderDescription(objPathologyOrderInfoBean.getOrderDescription());

								boolean isOrderDescription = objOrderDescriptionDao
										.insertOrderDescription(objOrderDescriptionBean);
								if (isOrderDescription) {
									objOrderLocationBean = new OrderLocationBean();
									objOrderLocationBean.setOrderId(sOrederId);
									objOrderLocationBean
											.setLocationId(objPathologyOrderInfoBean
													.getLocationId());
									System.out.println("loc--"+objPathologyOrderInfoBean.getLocationId());
									boolean isInserOrderLocation =  objOrderLocationDao.insertOrderLocation(objOrderLocationBean);
									if(isInserOrderLocation && objPathologyOrderInfoBean.isNewCustomer()){
										objCustomerBean = new CustomerBean();
										objCustomerBean.setOrderId(sOrederId);
										objCustomerBean.setCustomerId(objPathologyOrderInfoBean.getCustomerId());
										objCustomerBean.setRegisterDate(objPathologyOrderInfoBean.getBookedDate());
												if(StringUtils.isNotBlank(sCustomerDiscount)){
													objCustomerBean.setCustomerDiscount(sCustomerDiscount);	
												}
												isCustomerDiscInsert = objCustomerDiscountDao.isInsertCustomerDiscount(objCustomerBean);
										}
									
								if (isOrderUser && isInserOrderLocation ) {
									transactionManager.commit(objTransStatus);
									isInsert = true;
									objEmailSendingUtil = new EmailSendingUtil();
									objOrderBean = new OrderBean();
									objOrderBean.setOrderId(sOrederId);
									objOrderBean.setContactNo(objPathologyOrderInfoBean.getContactNo());
									objOrderBean.setServiceName("Pathology");
									objOrderBean.setContactEmail(objPathologyOrderInfoBean.getEmailId());
									objOrderBean.setAppointmentDate(objPathologyOrderInfoBean.getAppointmentDate());
									objOrderBean.setBookedDate(objPathologyOrderInfoBean.getBookedDate());
									objOrderBean.setNetAmount(objPathologyOrderInfoBean.getNetAmount());
									objOrderBean.setTimeName(objPathologyOrderInfoBean.getTimeName());
									objOrderBean.setSheduleName(objPathologyOrderInfoBean.getAppointmentDate());
									objOrderBean.setCustomerId(objPathologyOrderInfoBean.getContactNo());
									objOrderBean.setCustomerAddress(objPathologyOrderInfoBean.getOrderAddress());
									//objEmailSendingUtil.sendCustomerReport(objOrderBean, objContext,"customer");
									//objEmailSendingUtil.sendCustomerReport(objOrderBean, objContext,"admin");
									objSmsUtil = new SMSUtil();
									objSmsBean = new SMSBean();
									objSmsBean.setOrderId(sOrederId);
									objSmsBean.setMobileNo(objPathologyOrderInfoBean.getContactNo());
									objSmsBean.setNetAmt(objPathologyOrderInfoBean.getNetAmount());
									/*objSmsUtil.sendSms(objContext,objSmsBean, "customer" );
									//objSmsBean.setMobileNo("9742557757");
									objSmsBean.setMobileNo("7676575029");
									objSmsUtil.sendSms(objContext,objSmsBean, "order_admin");*/
									
								} else {
									System.out
											.println("fail in insertPathologyOrderInfo() in PathologyOrderInfoDaoImpl ");
									transactionManager.rollback(objTransStatus);
								}

							}
						}
					}
				}
					}
				}
		/*}*/
		} catch (Exception e) {
			transactionManager.rollback(objTransStatus);
			e.printStackTrace();
		} finally {
		}
		return isInsert;
	}

}
