/**
 * 
 */
package com.aurospaces.neighbourhood.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.aurospaces.neighbourhood.bean.LoginBean;
import com.aurospaces.neighbourhood.bean.OrderBean;
import com.aurospaces.neighbourhood.bean.VendorRegistrationBean;
import com.aurospaces.neighbourhood.daosupport.DaoSupport;
import com.aurospaces.neighbourhood.db.dao.OrderInfo1Dao;
import com.aurospaces.neighbourhood.db.model.OrderInfo1;

/**
 * @author YOGI
 * 
 */
public class EmailSendingUtil extends DaoSupport {
Logger objLogger = Logger.getLogger(EmailSendingUtil.class);
@Autowired
OrderInfo1Dao orderInfo1Dao;
	public String sendOrderReportToAdmin(LoginBean login, String proppath,
			String imagespath) {
		String reslutString = null;
		String toAddress = null;
		String ccAddress = null;
		String bccAddress = null;
		String subject = null;
		String htmlBody = null;
		Map<String, String> mapInlineImages = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream input = null;
		DecimalFormat df = new DecimalFormat("#.00");
		DateFormat objDateFormate = new SimpleDateFormat("dd,MMM yyyy");
		try {
			StringBuffer stringBuffer = new StringBuffer();
			/* String propertiespath = "D:/email.properties"; */

			String propertiespath = proppath;
			System.out.println("properties path" + propertiespath);
			input = new FileInputStream(propertiespath);
			// load a properties file
			prop.load(input);
			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String userName = prop.getProperty("usermail");
			String password = prop.getProperty("mailpassword");
			System.out.println(propertiespath.replace("database.properties",
					prop.getProperty("logoname")));
			String logo = propertiespath.replace("database.properties",
					prop.getProperty("logoname"));
			mapInlineImages.put("image1", logo);

			stringBuffer.append("yo");
			// toAddress = objVendorRegistrationBean.getEmail();
			toAddress = "ayogendra10@gmail.com";
			ccAddress = "yogendra@aurospaces.com";
			bccAddress = "yogendra@aurospaces.com";
			/*
			 * Iterator<SaleProductVo> saleiterator =
			 * branchWiseReportsBean.getHeighstSaleProductList().iterator();
			 * Iterator<StockProductVo> stockiterator =
			 * branchWiseReportsBean.getLessStockProductList().iterator();
			 * stringBuffer.append("<tr>" +
			 * "<td style=\"width:13%\"><div style=\"width:98%;height:100px;\"><table style=\"width:100%;height: 100%;border: 1px solid #FFA500;;border-spacing: 0px;\"><tr style=\"height: 50px;background-color: #FFA500;\"><td style=\"vertical-align:middle;color: white;\">Date</td></tr><tr style=\"height: 50px;background-color: white;\"><td>"
			 * +objDateFormate.format(branchWiseReportsBean.getDate())+
			 * "</td></tr></table></div></td>" +
			 * "<td style=\"width:13%\"><div style=\"width:98%;height:100px;\"><table style=\"width:100%;height: 100%;border: 1px solid #FFA500;border-spacing: 0px;\"><tr style=\"height: 50px;background-color: #FFA500;\"><td style=\"vertical-align:middle;color: white;\">Branch Name</td></tr><tr style=\"height: 50px;background-color: white;\"><td>"
			 * +
			 * branchWiseReportsBean.getBranchName()+"</td></tr></table></div></td>"
			 * +
			 * "<td style=\"width:13%\"><div style=\"width:98%;height:100px;\"><table style=\"width:100%;height: 100%;border: 1px solid #FFA500;border-spacing: 0px;\"><tr style=\"height: 50px;background-color: #FFA500;\"><td style=\"vertical-align:middle;color: white;\">Sales</td></tr><tr><td style=\"height: 50px;background-color: white;\">"
			 * +df.format(branchWiseReportsBean.getTotalSales())+
			 * "</td></tr></table></div></td>" +
			 * "<td style=\"width:13%\"><div style=\"width:98%;height:100px;\"><table style=\"width:100%;height: 100%;border: 1px solid #FFA500;border-spacing: 0px;\"><tr style=\"height: 50px;background-color: #FFA500;\"><td style=\"vertical-align:middle;color: white;\">Expenses</td></tr><tr style=\"height: 50px;background-color: white;\"><td>"
			 * +df.format(branchWiseReportsBean.getTotalExpenses())+
			 * "</td></tr></table></div></td>" +
			 * "<td style=\"width:13%\"><div style=\"width:98%;height:100px;\"><table style=\"width:100%;height: 100%;border: 1px solid #FFA500;border-spacing: 0px;\"><tr style=\"height: 50px;background-color: #FFA500;\"><td style=\"vertical-align:middle;color: white;\">Net Amount</td></tr><tr style=\"height: 50px;background-color: white;\"><td>"
			 * +df.format(branchWiseReportsBean.getNetAmount())+
			 * "</td></tr></table></div></td>" +
			 * "<td style=\"width:13%\"><div style=\"width:98%;height:100px;\"><table style=\"width:100%;height: 100%;border: 1px solid #FFA500;border-spacing: 0px;\"><tr style=\"height: 50px;background-color: #FFA500;\"><td style=\"vertical-align:middle;color: white;\">Heighest Sale product</td></tr><tr style=\"height: 50px;background-color: white;\"><td>"
			 * );
			 */
			/*
			 * while (saleiterator.hasNext()) { SaleProductVo saleProductVo2 =
			 * (SaleProductVo) saleiterator .next();
			 * stringBuffer.append("<li>"+saleProductVo2
			 * .getProductName()+"</li>"); }
			 * stringBuffer.append("</td></tr></table></div></td>" +
			 * "<td style=\"width:13%\"><div style=\"width:98%;height:100px;\"><table style=\"width:100%;height: 100%;border: 1px solid #FFA500;border-spacing: 0px;\"><tr style=\"height: 50px;background-color: #FFA500;\"><td style=\"vertical-align:middle;color: white;\">Less Stock Product</td></tr><tr style=\"height: 50px;background-color: white;\"><td>"
			 * ); while (stockiterator.hasNext()) { StockProductVo
			 * stockProductVo2 = (StockProductVo) stockiterator .next();
			 * stringBuffer
			 * .append("<li>"+stockProductVo2.getProductName()+"</li>"); }
			 */
			
			stringBuffer
					.append("</table></div>"
							+ "<div style=\"width: 100%;\"><table style=\"padding: 23px;width:100%;\"><tr><td valign=\"top\"><p><b></b></p></td></tr><tr><td valign=\"top\"><p><b><a href=\"#\" target=\"_blank\">mySales</a></b></p></td></tr></table></div>"
							+ "" + "</div>");
			// subject =
			// "Sale Report of "+branchWiseReportsBean.getBranchName();
			htmlBody = stringBuffer.toString();
			EmbeddedImageEmailUtil.send(host, port, userName, password,
					toAddress, ccAddress, bccAddress, subject, htmlBody,
					mapInlineImages);
			reslutString = "success";
		} catch (Exception e) {
			/*
			 * logger.error(e.getMessage());
			 * logger.fatal("error in getBranchMaxId() in BranchDaoImpl class");
			 */
			reslutString = "fail";
			e.printStackTrace();
		}

		return reslutString;
	}

	public String sendEmailToVendor(VendorRegistrationBean objVendorBean,
			String proppath, String imagespath) {
		System.out.println("sendEmailToUser Start");
		String reslutString = null;
		String toAddress = null;
		String ccAddress = null;
		String bccAddress = null;
		String subject = null;
		String htmlBody = null;
		Map<String, String> mapInlineImages = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream input = null;
		try {

			StringBuffer stringBuffer = new StringBuffer();
			subject = "Medicine Order";
			String propertiespath = proppath;
			System.out.println("properties path" + propertiespath);
			input = new FileInputStream(propertiespath);
			// load a properties file
			prop.load(input);
			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String userName = prop.getProperty("usermail");
			String password = prop.getProperty("mailpassword");
			System.out.println("ImagesPath:-" + imagespath);
			String logo = imagespath + File.separator
					+ prop.getProperty("logoname");
			mapInlineImages.put("image1", logo);

			stringBuffer
					.append("<table style=padding-left: 23px;padding-right: 23px;\">"
							+ "<tr>"
							+ "<td>"
							+ "<h3 style=\"color: orange\"><a href=\"#\" style=\"text-align: center;\"><img src=\"cid:image1\"></a></h3></td>"
							+ "<td style=\"text-align: right;\"><h3 style=\"color: orange\"></h3></td>"
							+ "</tr>"
							+ "</table>"
							+ "</div>"
							+ "<div><h2 style=\"text-align:center\">Welcome to Aurospaces</h2></div>");
			// toAddress = userEmailBean.getEmailid();
			toAddress = objVendorBean.getEmail();
			System.out.println("toAddress--" + toAddress);
			ccAddress = "ayogendra10@gmail.com";
			bccAddress = "yogendra@aurospaces.com";
			stringBuffer.append("<div><p>Dear  <b> "
					+ objVendorBean.getFirstName() + " "
					+ objVendorBean.getLastName() + "</b></p></div>");
			stringBuffer.append("<div><p>Your order is given below</p></div>");
			stringBuffer
					.append("<table style=\"width: 100%;text-align:center;font-weight: bold;\">");
			/*
			 * List<MedicineBean> listMedicineBeans =
			 * objVendorBean.getListMedicineBeans(); //Iterator<MedicineBean>
			 * stockiterator = listMedicineBeans.iterator(); for(MedicineBean
			 * objBean:listMedicineBeans){
			 * stringBuffer.append("<tr><td >"+"MedicneName"
			 * +objBean.getMedicineName()+"</td>" +
			 * "<td >"+objBean.getBrand()+"</td>" +
			 * "<td >"+objBean.getDosage()+"</td>" +
			 * "<td >"+objBean.getQuantity()+"</td>" +
			 * "<td >"+objBean.getOrderId()+"</td>"); }
			 */
			stringBuffer.append("</td></tr></table></div></td>");

			stringBuffer
					.append("<div><p>Thanks & Regards</p><p><b>Aurospaces Pvt. Ltd.</b></p></div>");
			htmlBody = stringBuffer.toString();
			System.out.println(htmlBody);
			System.out.println("toAddress::>>" + toAddress);
			EmbeddedImageEmailUtil.send(host, port, userName, password,
					toAddress, ccAddress, bccAddress, subject, htmlBody,
					mapInlineImages);
			System.out.println("sendEmailToUser End");
			reslutString = "success";
		} catch (Exception e) {
			e.printStackTrace();

			reslutString = "fail";
		}

		return reslutString;
	}

	/*public String sendCustomerReport(OrderBean objOrderBean,
			ServletContext objContext, String sMailTo) throws AddressException,
			MessagingException, IOException {
		String reslutString = null;
		String toAddress = null;
		String ccAddress = null;
		String bccAddress = null;
		String subject = null;
		String htmlBody = null;
		Map<String, String> mapInlineImages = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream input = null;
		NeighbourhoodUtil objUtil = null;
		try{
			//for date 
			
			
			StringBuffer stringBuffer = new StringBuffer();
			String propertiespath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
			//String propertiespath = "C:\\PRO\\Database.properties";
			objLogger.fatal("error in email sending...."+propertiespath);
			input = new FileInputStream(propertiespath);
			// load a properties file
			prop.load(input);
			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String userName = prop.getProperty("usermail");
			String password = prop.getProperty("mailpassword");
			String mailContent = null;
			
			if (objOrderBean != null ) {
				mapInlineImages.put("image1", objContext.getRealPath("images" +File.separator+"logo.png"));
				if("customer".equals(sMailTo)){
					//mapInlineImages.put("image1", objContext.getRealPath("images" +File.separator+"logo.png"));
					mailContent = prop.getProperty("customer_mail_content");
					mailContent = mailContent.replace("_order_", objOrderBean.getOrderId());
					mailContent = mailContent.replace("_service_", objOrderBean.getServiceName());
					if(StringUtils.isNotBlank(objOrderBean.getTimeName()) || StringUtils.isNotBlank(objOrderBean.getSheduleName())){
						objUtil = new NeighbourhoodUtil();
						objUtil.getSimpleDate(objOrderBean.getBookedDate());
						mailContent = mailContent.replace("_orderdate_", objUtil.getSimpleDate(objOrderBean.getBookedDate()));
						System.out.println(objUtil.getSimpleDate(objOrderBean.getBookedDate()));
						mailContent = mailContent.replace("_bookdate_", objOrderBean.getTimeName());
					}
					if(StringUtils.isNotBlank(objOrderBean.getCustomerId())){
						mailContent = mailContent.replace("_phone_", objOrderBean.getCustomerId());
					}
					if(StringUtils.isNotBlank(objOrderBean.getCustomerAddress())){
						mailContent = mailContent.replace("_addr_", objOrderBean.getCustomerAddress());
					}
					
					mailContent = mailContent.replace("_img_", "cid:image1");
					
					if(objOrderBean.getNetAmount() != null){
						mailContent = mailContent.replace("_price_", objOrderBean.getNetAmount());
						mailContent = mailContent.replace("_pamount_", objOrderBean.getNetAmount());
					}else{
						mailContent = mailContent.replace("_pamount_", "Cash on Service");
						mailContent = mailContent.replace("_price_", "Cash on Service");
					}
					
					toAddress = objOrderBean.getContactEmail();
					ccAddress = objOrderBean.getContactEmail();
					bccAddress = objOrderBean.getContactEmail();
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Order Report", mailContent,
							mapInlineImages);
				}
				if("vendor".equals(sMailTo)){
					mailContent = prop.getProperty("vendor_mail_content");
					mailContent = mailContent.replace("_phone_", objOrderBean.getContactNo());
					mailContent = mailContent.replace("_name_", objOrderBean.getVendorName());
					toAddress = objOrderBean.getContactEmail();
					ccAddress = objOrderBean.getContactEmail();
					bccAddress = objOrderBean.getContactEmail();
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Vendor Information", mailContent,
							mapInlineImages);
				}
				
				if("customer_vendor".equals(sMailTo)){
					mailContent = prop.getProperty("customer_vendor_content");
					mailContent = mailContent.replace("_phone_", objOrderBean.getContactNo());
					mailContent = mailContent.replace("_name_", objOrderBean.getVendorName());
					toAddress = objOrderBean.getContactEmail();
					ccAddress = objOrderBean.getContactEmail();
					bccAddress = objOrderBean.getContactEmail();
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Auro Professional Information", mailContent,
							mapInlineImages);
					
				}
				
				if("admin".equals(sMailTo)){
					mailContent = prop.getProperty("admin_mail_content");
					mailContent = mailContent.replace("_order_", objOrderBean.getOrderId());
					mailContent = mailContent.replace("_service_", objOrderBean.getServiceName());
					mailContent = mailContent.replace("_time_", objOrderBean.getTimeName());
					mailContent = mailContent.replace("_date_", objOrderBean.getAppointmentDate());
					if(StringUtils.isNotBlank(objOrderBean.getCustomerId())){
						mailContent = mailContent.replace("_phone_", objOrderBean.getCustomerId());
					}
					if(StringUtils.isNotBlank(objOrderBean.getCustomerAddress())){
						mailContent = mailContent.replace("_addr_", objOrderBean.getCustomerAddress());
					}
					mailContent = mailContent.replace("_img_", "cid:image1");
					toAddress = "yogendra.andraju@gmail.com";
					//System.out.println(userName);
					ccAddress =toAddress;
					//ccAddress = "raj@aurospaces.com";
					ccAddress = toAddress;
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Confirmatoin", mailContent,
							mapInlineImages);
				}
				if("customer_feedback".equals(sMailTo)){
					mailContent = prop.getProperty("customer_feedback");
					mailContent = mailContent.replace("_order_", objOrderBean.getOrderId());
					toAddress = objOrderBean.getContactEmail();
					System.out.println(objOrderBean.getContactEmail());
					ccAddress = toAddress;
					bccAddress = toAddress;
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Feedback", mailContent,
							mapInlineImages);
				}
				if("feedback".equals(sMailTo)){
					mailContent = prop.getProperty("admin_feedback");
					mailContent = mailContent.replace("_phone_", objOrderBean.getCustomerMobile());
					mailContent = mailContent.replace("_message_", objOrderBean.getDescription());
					toAddress = prop.getProperty("feedbackmail");
					System.out.println("to address...."+toAddress);
					ccAddress = toAddress;
					bccAddress = toAddress;
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Customer Feedback", mailContent,
							mapInlineImages);
				}
			}
			htmlBody = stringBuffer.toString();
			System.out.println(mailContent);
			objLogger.fatal("error in email sending...."+htmlBody);
			
		}catch(Exception e){
			objLogger.fatal("error in email sending...."+e.getMessage());
			e.printStackTrace();
		}finally{
		}
		return reslutString = "success";
	}*/
	
	public String sendEmail(OrderInfo1 objOrderBean,
			ServletContext objContext, String sMailTo) throws AddressException,
			MessagingException, IOException {
		String reslutString = null;
		String toAddress = null;
		String ccAddress = null;
		String bccAddress = null;
		String subject = null;
		String htmlBody = null;
		Map<String, String> mapInlineImages = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream input = null;
		NeighbourhoodUtil objUtil = null;
		try{
			//for date 
			
			
			StringBuffer stringBuffer = new StringBuffer();
			String propertiespath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
			//String propertiespath = "C:\\PRO\\Database.properties";
			objLogger.fatal("error in email sending...."+propertiespath);
			input = new FileInputStream(propertiespath);
			// load a properties file
			prop.load(input);
			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String userName = prop.getProperty("usermail");
			String password = prop.getProperty("mailpassword");
			String mailContent = null;
			
			if (objOrderBean != null ) {
				mapInlineImages.put("image1", objContext.getRealPath("images" +File.separator+"logo.png"));
				if("customer".equals(sMailTo)){
					mailContent = prop.getProperty("customer_mail_content");
					mailContent = mailContent.replace("_order_", objOrderBean.getGeneratedId());
					mailContent = mailContent.replace("_service_", objOrderBean.getServiceName());
					String S = new SimpleDateFormat("dd-MM-yyyy").format(objOrderBean.getAppointmentDate());
					System.out.println(S);
						mailContent = mailContent.replace("_orderdate_", S);
						mailContent = mailContent.replace("_bookdate_", objOrderBean.getAppointTimeName());
					
					if(StringUtils.isNotBlank(objOrderBean.getContactNumber())){
						mailContent = mailContent.replace("_phone_", objOrderBean.getContactNumber());
					}
					if(StringUtils.isNotBlank(objOrderBean.getAddress())){
						mailContent = mailContent.replace("_addr_", objOrderBean.getAddress());
					}
					
					mailContent = mailContent.replace("_img_", "cid:image1");
					
					if(objOrderBean.getNetAmount() != null){
						mailContent = mailContent.replace("_price_", objOrderBean.getNetAmount().toString());
						mailContent = mailContent.replace("_discount_", objOrderBean.getTotalDiscount().toString());
						mailContent = mailContent.replace("_pamount_", objOrderBean.getTotalPrice().toString());
					}else{
						mailContent = mailContent.replace("_pamount_", "Cash on Service");
						mailContent = mailContent.replace("_discount_", "Cash on Service");
						mailContent = mailContent.replace("_price_", "Cash on Service");
					}
					
					toAddress = objOrderBean.getContactEmail();
					if(objOrderBean.getLocationId() == 19){
						ccAddress = prop.getProperty("hydccadmin");
					}
					 else if (objOrderBean.getLocationId() == 20){
						ccAddress = prop.getProperty("puneccadmin");
					}else{
						ccAddress = prop.getProperty("ccadmin");
					}
					
					bccAddress = prop.getProperty("bccadmin");
					System.out.println(objOrderBean.getLocationId());
					try
					{
						System.out.println("host = " + host);
						System.out.println("port = " + port);
						System.out.println("userName = " + userName);
						System.out.println("password = " + password);
						System.out.println("toAddress = " + toAddress);
						System.out.println("ccAddress = " + ccAddress);
						System.out.println("bccAddress = " + bccAddress);
						EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
								ccAddress, bccAddress, "Order Report", mailContent,
								mapInlineImages);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				if("admin".equals(sMailTo)){
					mailContent = prop.getProperty("admin_mail_content");
					mailContent = mailContent.replace("_order_", objOrderBean.getGeneratedId());
					mailContent = mailContent.replace("_service_", objOrderBean.getServiceName());
					mailContent = mailContent.replace("_time_", objOrderBean.getAppointTimeName());
					String S = new SimpleDateFormat("dd-MM-yyyy").format(objOrderBean.getAppointmentDate());
					mailContent = mailContent.replace("_date_", S);
					if(StringUtils.isNotBlank(objOrderBean.getContactNumber())){
						mailContent = mailContent.replace("_phone_", objOrderBean.getContactNumber());
					}
					if(StringUtils.isNotBlank(objOrderBean.getAddress())){
						mailContent = mailContent.replace("_addr_", objOrderBean.getAddress());
					}
					mailContent = mailContent.replace("_img_", "cid:image1");
					toAddress = prop.getProperty("adminemail");
					ccAddress =toAddress;
					bccAddress = toAddress;
					try
					{
						System.out.println("host = " + host);
						System.out.println("port = " + port);
						System.out.println("userName = " + userName);
						System.out.println("password = " + password);
						System.out.println("toAddress = " + toAddress);
						System.out.println("ccAddress = " + ccAddress);
						System.out.println("bccAddress = " + bccAddress);

						EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Confirmatoin", mailContent,
							mapInlineImages);
							}
							catch(Exception eX)
							{
								eX.printStackTrace();
							}
				}
				if("customer_feedback".equals(sMailTo)){
					mailContent = prop.getProperty("customer_feedback");
					mailContent = mailContent.replace("_order_", objOrderBean.getGeneratedId());
					toAddress = objOrderBean.getContactEmail();
					System.out.println(objOrderBean.getContactEmail());
					ccAddress = toAddress;
					bccAddress = toAddress;
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Feedback", mailContent,mapInlineImages);
				}
				if("feedback".equals(sMailTo)){
					mailContent = prop.getProperty("admin_feedback");
					mailContent = mailContent.replace("_phone_", objOrderBean.getContactEmail());
					mailContent = mailContent.replace("_message_", objOrderBean.getDescription());
					toAddress = prop.getProperty("feedbackmail");
					System.out.println("to address...."+toAddress);
					ccAddress = toAddress;
					bccAddress = toAddress;
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Customer Feedback", mailContent,
							mapInlineImages);
				}
				if("customer_vendor".equals(sMailTo)){
					mailContent = prop.getProperty("customer_vendor_content");
					mailContent = mailContent.replace("_phone_", objOrderBean.getContactNumber());
					mailContent = mailContent.replace("_name_", objOrderBean.getVendorName());
					toAddress = objOrderBean.getContactEmail();
					ccAddress = objOrderBean.getContactEmail();
					bccAddress = objOrderBean.getContactEmail();
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Auro Professional Information", mailContent,
							mapInlineImages);
					
				}
				/*if("vendor".equals(sMailTo)){
					mailContent = prop.getProperty("vendor_mail_content");
					mailContent = mailContent.replace("_phone_", objOrderBean.getContactNo());
					mailContent = mailContent.replace("_name_", objOrderBean.getVendorName());
					toAddress = objOrderBean.getContactEmail();
					ccAddress = objOrderBean.getContactEmail();
					bccAddress = objOrderBean.getContactEmail();
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Vendor Information", mailContent,
							mapInlineImages);
				}
				
				if("customer_vendor".equals(sMailTo)){
					mailContent = prop.getProperty("customer_vendor_content");
					mailContent = mailContent.replace("_phone_", objOrderBean.getContactNo());
					mailContent = mailContent.replace("_name_", objOrderBean.getVendorName());
					toAddress = objOrderBean.getContactEmail();
					ccAddress = objOrderBean.getContactEmail();
					bccAddress = objOrderBean.getContactEmail();appointTimeName
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Auro Professional Information", mailContent,
							mapInlineImages);
					
				}
				
				if("admin".equals(sMailTo)){
					mailContent = prop.getProperty("admin_mail_content");
					mailContent = mailContent.replace("_order_", objOrderBean.getOrderId());
					mailContent = mailContent.replace("_service_", objOrderBean.getServiceName());
					mailContent = mailContent.replace("_time_", objOrderBean.getTimeName());
					mailContent = mailContent.replace("_date_", objOrderBean.getAppointmentDate());
					if(StringUtils.isNotBlank(objOrderBean.getCustomerId())){
						mailContent = mailContent.replace("_phone_", objOrderBean.getCustomerId());
					}
					if(StringUtils.isNotBlank(objOrderBean.getCustomerAddress())){
						mailContent = mailContent.replace("_addr_", objOrderBean.getCustomerAddress());
					}
					mailContent = mailContent.replace("_img_", "cid:image1");
					toAddress = "yogendra.andraju@gmail.com";
					//System.out.println(userName);
					ccAddress =toAddress;
					//ccAddress = "raj@aurospaces.com";
					ccAddress = toAddress;
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Confirmatoin", mailContent,
							mapInlineImages);
				}
				if("customer_feedback".equals(sMailTo)){
					mailContent = prop.getProperty("customer_feedback");
					mailContent = mailContent.replace("_order_", objOrderBean.getOrderId());
					toAddress = objOrderBean.getContactEmail();
					System.out.println(objOrderBean.getContactEmail());
					ccAddress = toAddress;
					bccAddress = toAddress;
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Feedback", mailContent,
							mapInlineImages);
				}
				if("feedback".equals(sMailTo)){
					mailContent = prop.getProperty("admin_feedback");
					mailContent = mailContent.replace("_phone_", objOrderBean.getCustomerMobile());
					mailContent = mailContent.replace("_message_", objOrderBean.getOrderDescription());
					toAddress = "feedback@aurospaces.com";
					System.out.println("to address...."+toAddress);
					ccAddress = toAddress;
					bccAddress = toAddress;
					mailContent = mailContent.replace("_img_", "cid:image1");
					EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress,
							ccAddress, bccAddress, "Customer Feedback", mailContent,
							mapInlineImages);
				}*/
			}
			htmlBody = stringBuffer.toString();
			System.out.println(mailContent);
			objLogger.fatal("error in email sending...."+htmlBody);
			
		}catch(Exception e){
			objLogger.fatal("error in email sending...."+e.getMessage());
			e.printStackTrace();
			return reslutString = "fail";
		}finally{
		}
		return reslutString = "success";
	}

	public static void main(String k[]) throws AddressException,
			MessagingException, IOException {
		OrderBean obBean = new OrderBean();
		obBean.setOrderId("12345");
		obBean.setContactEmail("yogendra@aurospaces.com");
		obBean.setNetAmount("12");
		obBean.setServiceId("Doctor At Home");
		obBean.setAppointmentDate("2015-05-06");
		obBean.setBookedDate("2015-05-08");
		System.out.println("one");
		EmailSendingUtil objEmailSendingUtil = new EmailSendingUtil();
		//objEmailSendingUtil.sendCustomerReport(obBean, null);
		/*objEmailSendingUtil.cronEmailForOrderDetails("/home/yogi/Desktop/Resuefy/NeighbourhoodPlatform/src/main/webapp/Resources/DataBase.properties");*/
	}
	
	
	public String java1234() {
		Map<String, String> mapInlineImages = new HashMap<String, String>();
		mapInlineImages.put("image1", "C://PRO//logo.png");
		EmbeddedImageEmailUtil emailUtil = new EmbeddedImageEmailUtil();
		try {
			emailUtil.send("smtp.gmail.com", "587", "yogendra@aurospaces.com", "yogendra@12", "yogendra@aurospaces.com", "yogendra@aurospaces.com", "yogendra@aurospaces.com", "Hi This is Sample Mail", "<html><body><img src=\"cid:image1\"></body></html>", mapInlineImages);
		
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	public  String cronEmailForOrderDetails(String proppath, List<OrderInfo1> orderList){
		String reslutString = null;
		String toAddress=null;
		String ccAddress=null;
		String bccAddress=null;
		String subject=null;
		 String htmlBody=null; 
		Map<String, String> mapInlineImages = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream input = null;
		DecimalFormat df = new DecimalFormat("#.00");
		DateFormat objDateFormate = new SimpleDateFormat("dd,MMM yyyy");
		try {
			StringBuffer stringBuffer = new StringBuffer();
			/*String propertiespath = "D:/email.properties";*/
			
			String propertiespath  = proppath;
			System.out.println("properties path"+propertiespath);
			input = new FileInputStream(propertiespath);
			// load a properties file
			prop.load(input);
			String host=prop.getProperty("host");
			String port=prop.getProperty("port");
			String userName=prop.getProperty("usermail");
			String password=prop.getProperty("mailpassword");
				toAddress = "opsblr@aurospaces.com";
				ccAddress = toAddress;
				bccAddress = toAddress;
				stringBuffer.append("<table align='center' width='80%' border='1'><tr><th>User</th>");
				stringBuffer.append("<th>Status</th>");
				stringBuffer.append("<th>Count</th></tr>");
				Iterator<OrderInfo1>  saleiterator = orderList.iterator();
				int count = 0;
				while (saleiterator.hasNext()) {
					OrderInfo1 saleProductVo2 = (OrderInfo1) saleiterator	.next();
					count = count+saleProductVo2.getCount();
					
					stringBuffer.append("<tr>");
					stringBuffer.append("<td>"+saleProductVo2.getUserName()+"</td><td>"+saleProductVo2.getStatusName()+"</td><td>"+saleProductVo2.getCount()+"</td>");
					stringBuffer.append("</tr>");
					}
				stringBuffer.append("<tr>");
				stringBuffer.append("<td colspan='3' align='center'><b>Grand Total:  "  +  count+"</b></td>");
				stringBuffer.append("</tr>");
				System.out.println(count);
					System.out.println(stringBuffer.toString());
					subject = "Daily Order Report";
			htmlBody = stringBuffer.toString();
			EmbeddedImageEmailUtil.send(host, port, userName, password, toAddress, ccAddress, bccAddress, subject, htmlBody, mapInlineImages);
			reslutString = "success";
		}
		catch(Exception e){
			e.printStackTrace();
			reslutString = "fail";
		}
		
		
		return reslutString;
	}
}
