package com.aurospaces.neighbourhood.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.aurospaces.neighbourhood.db.model.OrderInfo1;

public class SMSUtil {
	public String sendSms(String smsUrl, String sUsername, String sPassword,
			String sMobileNo, String sSMSContent, OrderInfo1 object) {
		String chunk = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			try {
				System.out.println(smsUrl);
				if (smsUrl != null) {
					smsUrl = smsUrl.replace("_username_", sUsername);
					smsUrl = smsUrl.replace("_password_", sPassword);
					sSMSContent = sSMSContent.replace(" ", "%20");
					sSMSContent = sSMSContent.replace(",", "%2C");
					sSMSContent = sSMSContent.replace("&", "%26");
					sSMSContent = sSMSContent.replace("#", "%23");
					sSMSContent = sSMSContent.replace(":", "%3A");
					sSMSContent = sSMSContent.replace("+", "%2B");
					sSMSContent = sSMSContent.replace("'", "%27");
					smsUrl = smsUrl.replace("_message_", sSMSContent);
					
					smsUrl = smsUrl.replace("_mobile_", object.getContactNumber().replace("\"", "").trim());
					if(StringUtils.isNotBlank(object.getContactNumber())){
						System.out.println("Customer no.."+object.getContactNumber());
						smsUrl = smsUrl.replace("_uname_", object.getContactNumber().replace("\"", "").trim());	
					}
					/*if(StringUtils.isNotBlank(object.getPassword())){
						System.out.println("password.."+object.getPassword());
						smsUrl = smsUrl.replace("_pass_", object.getPassword().replace("\"", ""));	
					}*/
					if(StringUtils.isNotBlank(object.getGeneratedId())){
						smsUrl = smsUrl.replace("_order_", object.getGeneratedId().replace("\"", ""));
						System.out.println("order..." + object.getGeneratedId());
					}
					if (StringUtils.isNotBlank(object.getVendorMobile())) {
						smsUrl = smsUrl.replace("_vmobile_",object.getVendorMobile().replace("\"", ""));
						System.out.println("vendormobile..."+ object.getVendorMobile());
					}
					if (StringUtils.isNotBlank(object.getVendorName())) {
						smsUrl = smsUrl.replace("_name_",object.getVendorName().replace(" ", "%20"));
						System.out.println("vendorname..." + object.getVendorName());
					}
					if (object.getNetAmount() != null) {
						smsUrl = smsUrl.replace("_paidamount_",object.getNetAmount().toString().replace(" ", "%20"));
						System.out.println("net amount.."+object.getNetAmount());
					}
					if (StringUtils.isNotBlank(object.getAddress())) {
						smsUrl = smsUrl.replace("_addrs_",object.getAddress().replace("+", "%2B").replace(",", "%2C").replace("&", "%26").replace(" ", "%20").replace("\n", "%0A").replace("#", "%23"));
						System.out.println("address.."+object.getAddress());
					}
					if (StringUtils.isNotBlank(object.getContactNumber())) {
						smsUrl = smsUrl.replace("_cmobile_",object.getContactNumber().replace("\"", ""));
						System.out.println("_cmobile_.."+object.getContactNumber());
					}
					if (object.getAppointmentDate()!= null) {
						smsUrl = smsUrl.replace("_scheduleDate_",new SimpleDateFormat("dd-MM-yyyy").format(object.getAppointmentDate()).toString().replace(" ", "%20"));
						System.out.println("_scheduleDate_.."+object.getAppointmentDate());
					}
					if (StringUtils.isNotBlank(object.getAppointTimeName())) {
						smsUrl = smsUrl.replace("_scheduleTime_",object.getAppointTimeName().replace("\"", "").replace(" ", "%20"));
						System.out.println("_scheduleTime_.."+object.getAppointTimeName());
					}
					if (object.getTotalDiscount()!= null) {
						smsUrl = smsUrl.replace("_disc_",object.getTotalDiscount().toString().replace(" ", "%20").concat("rs"));
						System.out.println("discount..."+object.getTotalDiscount());
					}
					if (StringUtils.isNotBlank(object.getOtp())) {
						smsUrl = smsUrl.replace("_otp_",object.getOtp());
						System.out.println("_otp_..."+object.getOtp());
					}
					if (StringUtils.isNotBlank(object.getCouponCode())) {
						smsUrl = smsUrl.replace("_vcouponcode_",object.getCouponCode());
						System.out.println("_vcouponcode_..."+object.getCouponCode());
					}
				}
				
				
				
				System.out.println(smsUrl + "smsUrl");
				HttpGet httpGetRequest = new HttpGet(smsUrl);
				HttpResponse httpResponse = httpClient.execute(httpGetRequest);
				System.out.println("----------------------------------------");
				System.out.println(httpResponse.getStatusLine());
				System.out.println("----------------------------------------");
				org.apache.http.HttpEntity entity = httpResponse.getEntity();

				byte[] buffer = new byte[1024];
				if (entity != null) {
					InputStream inputStream = entity.getContent();
					try {
						int bytesRead = 0;
						BufferedInputStream bis = new BufferedInputStream(
								inputStream);
						while ((bytesRead = bis.read(buffer)) != -1) {
							chunk = new String(buffer, 0, bytesRead);
							System.out.println(chunk);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							inputStream.close();
						} catch (Exception ignore) {
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				httpClient.getConnectionManager().shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return chunk;
	}

	public int smsChecking(String sBalanceUrl, String sUsername,
			String sPassword) {
		int iSmsCount = 0;
		String chunk = null;
		try {
			if (sBalanceUrl != null) {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				System.out.println(sBalanceUrl);

				if (sBalanceUrl != null) {
					sBalanceUrl = sBalanceUrl.replace("_username_", sUsername);
					sBalanceUrl = sBalanceUrl.replace("_password_", sPassword);
				}
				System.out.println("sBalanceUrl--" + sBalanceUrl);
				HttpGet httpGetRequest = new HttpGet(sBalanceUrl);
				HttpResponse httpResponse = httpClient.execute(httpGetRequest);

				System.out.println("----------------------------------------");
				System.out.println(httpResponse.getStatusLine());
				System.out.println("----------------------------------------");
				org.apache.http.HttpEntity entity = httpResponse.getEntity();

				byte[] buffer = new byte[1024];
				if (entity != null) {
					InputStream inputStream = entity.getContent();
					try {
						int bytesRead = 0;
						BufferedInputStream bis = new BufferedInputStream(
								inputStream);
						while ((bytesRead = bis.read(buffer)) != -1) {
							chunk = new String(buffer, 0, bytesRead);
							System.out.println(chunk);
							if (chunk != null) {
								iSmsCount = Integer.parseInt(chunk);
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							inputStream.close();
						} catch (Exception ignore) {
						}
					}
				}
			}
		} catch (Exception e) {

		} finally {

		}
		return iSmsCount;
	}

	/*public String sendSms(ServletContext objContext, SMSBean object,
			String sSendTo) {
		String sSmsContent = null;
		String result = null;
		try {
			Properties objProperties = new Properties();
			String filePath = objContext.getRealPath("Resources"
					+ File.separator + "userDetails.properties");
			System.out.println("filePath--" + filePath);
			FileInputStream objFileInputStream;
			objFileInputStream = new FileInputStream(filePath);
			objProperties.load(objFileInputStream);
			String sSmsUrl = objProperties.getProperty("sms_content");
			String sSmsPassword = objProperties.getProperty("sms_password");
			String sSmsUsername = objProperties.getProperty("sms_username");
			// String sSmsBalaceUrl = objProperties.getProperty("sms_balance");
			if("Customer_Sample_Collected".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("Customer_Sample_Collected");
			}
			if ("customer".equalsIgnoreCase(sSendTo)) {
				sSmsContent = objProperties.getProperty("sms_message");
			}
			if ("sms_cusotmer_freeprice".equalsIgnoreCase(sSendTo)) {
				sSmsContent = objProperties.getProperty("sms_cusotmer_freeprice");
			}
			
			if ("customerToAdmin".equalsIgnoreCase(sSendTo)) {
				sSmsContent = objProperties.getProperty("sms_vendor_message");
			}
			if("customer_username".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_customer_username");
			}
			if("cancelCustomer".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_cancel_customer");
			}
			if("cancelVendor".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_cancel_vendor");
			}
			if("paidCustomer".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_paid_customer");
			}
			if("order_admin".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_order_admin");
			}
			if("vendor_customer_details".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("vendor_customer_details");
			}
			if("sms_customer_feedback".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_customer_feedback");
			}
			if("paidVendor".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_feedback");
			}
			if("sms_vendor_confirmation".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_confirmation");
			}
			if("sms_cusotmer_orderpriceconfirm".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_cusotmer_orderpriceconfirm");
			}
			if("sms_reschedule_customer".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_reschedule_customer");
			}
			if("sms_customer_oninspection".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_customer_oninspection");
			}
			if("sms_vendor_oninspection".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_oninspection");
			}
			if("sms_vendor_oninspectionfree".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_oninspectionfree");
			}
			if("user_otp".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("user_otp");
			}
			
			
			
			System.out.println(sSmsContent);
			
			 String smsMobile = objProperties.getProperty("mobile");

			SMSUtil smsUtil = new SMSUtil();
			// int iSmsCount = smsUtil.smsChecking(sSmsBalaceUrl,
			// sSmsUsername,sSmsPassword);
			result = smsUtil.sendSms(sSmsUrl, sSmsUsername, sSmsPassword, smsMobile,
					sSmsContent, object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}*/
	
	public String sendSms(ServletContext objContext, OrderInfo1 object,
			String sSendTo) {
		String sSmsContent = null;
		String result = null;
		try {
			Properties objProperties = new Properties();
			String filePath = objContext.getRealPath("Resources"
					+ File.separator + "userDetails.properties");
			System.out.println("filePath--" + filePath);
			FileInputStream objFileInputStream;
			objFileInputStream = new FileInputStream(filePath);
			objProperties.load(objFileInputStream);
			String sSmsUrl = objProperties.getProperty("sms_content");
			String sSmsPassword = objProperties.getProperty("sms_password");
			String sSmsUsername = objProperties.getProperty("sms_username");
			// String sSmsBalaceUrl = objProperties.getProperty("sms_balance");
			if("Customer_Sample_Collected".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("Customer_Sample_Collected");
			}
			if("Customer_reports_upload".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("Customer_reports_upload");
			}
			if ("customer".equalsIgnoreCase(sSendTo)) {
				sSmsContent = objProperties.getProperty("sms_message");
			}
			if ("sms_cusotmer_freeprice".equalsIgnoreCase(sSendTo)) {
				sSmsContent = objProperties.getProperty("sms_cusotmer_freeprice");
			}
			
			if ("sms_vendor_message".equalsIgnoreCase(sSendTo)) {
				sSmsContent = objProperties.getProperty("sms_vendor_message");
			}
			if("customer_username".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_customer_username");
			}
			if("sms_cancel_customer".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_cancel_customer");
			}
			if("sms_cancel_vendor".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_cancel_vendor");
			}
			if("sms_paid_customer".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_paid_customer");
			}
			if("order_admin".equalsIgnoreCase(sSendTo)){
				String adminMobile = objProperties.getProperty("adminmobile");
				System.out.println("----admin mobille"+adminMobile);
				object.setContactNumber(adminMobile);
				sSmsContent = objProperties.getProperty("sms_order_admin");
			}
			if("vendor_customer_details".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("vendor_customer_details");
			}
			if("sms_customer_feedback".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_customer_feedback");
			}
			if("sms_vendor_feedback".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_feedback");
			}
			if("sms_vendor_confirmation".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_confirmation");
			}
			if("sms_cusotmer_orderpriceconfirm".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_cusotmer_orderpriceconfirm");
			}
			if("sms_reschedule_customer".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_reschedule_customer");
			}
			if("sms_customer_oninspection".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_customer_oninspection");
			}
			if("sms_vendor_oninspection".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_oninspection");
			}
			if("sms_vendor_oninspectionfree".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_oninspectionfree");
			}
			if("user_otp".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("user_otp");
			}
			if("customer_alert".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("customer_alert");
			}
			if("sms_vendor_couponcode".equalsIgnoreCase(sSendTo)){
				sSmsContent = objProperties.getProperty("sms_vendor_couponcode");
			}
			System.out.println(sSmsContent);
			
			 String smsMobile = objProperties.getProperty("mobile");

			SMSUtil smsUtil = new SMSUtil();
			// int iSmsCount = smsUtil.smsChecking(sSmsBalaceUrl,
			// sSmsUsername,sSmsPassword);
			result = smsUtil.sendSms(sSmsUrl, sSmsUsername, sSmsPassword, smsMobile,
					sSmsContent, object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
}
