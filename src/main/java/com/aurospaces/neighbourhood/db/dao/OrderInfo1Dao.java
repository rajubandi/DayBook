package com.aurospaces.neighbourhood.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.aurospaces.neighbourhood.bean.LoginBean;
import com.aurospaces.neighbourhood.db.basedao.BaseOrderInfo1Dao;
import com.aurospaces.neighbourhood.db.callback.BeanUtilsCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.KeyValueCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.RowValueCallbackHandler;
import com.aurospaces.neighbourhood.db.callback.SingleValueCallbackHandler;
import com.aurospaces.neighbourhood.db.model.CouponCode;
import com.aurospaces.neighbourhood.db.model.CustomerOrderDetails;
import com.aurospaces.neighbourhood.db.model.Reports;
import com.aurospaces.neighbourhood.db.model.OrderInfo1;
import com.aurospaces.neighbourhood.db.model.OrderSequence;
import com.aurospaces.neighbourhood.db.model.OrderStatusLog1;
import com.aurospaces.neighbourhood.util.AuroConstants;

@Repository(value = "orderInfo1Dao")
public class OrderInfo1Dao extends BaseOrderInfo1Dao {
	Logger logger = Logger.getLogger(OrderInfo1Dao.class);
@Autowired HttpSession session;
  @Autowired
	  OrderStatusLog1Dao orderStatusLog1Dao;

	public List<Map<String, String>> getOrdersByParams(String serviceId , String phoneNo , String emailId, String orderId,String statusId,String userId,String clientId,String startDate,String endDate,String vendorId,String vendorstatusId) {
		StringBuffer objStringBuffer = new StringBuffer();
		String query = null;
				
		objStringBuffer.append("select distinct (o.generated_id) as orderId, o.id as gid,o.user_id as userId , o.client_log as clientlog,o.auro_log as aurolog,o.vendor_service_charge as vendorCharge,"
				+ "  o.booked_date as bookedDate,"
				+ "  o.appointment_date as appointmentDate,"
				+ "  o.contact_number as contactNo,"
				+ "  o.contact_email as contactEmail,o.isPause as isPause,"
				+ "  o.address as orderAddress,"
				+ "  o.total_price as totalPrice,DATE(o.invoice_date) as invoiceDate, "
				+ "  o.total_discount as totalDiscount,"
				+ "  o.net_amount as netAmount,"
				+ "  o.vendor_id as vendorId,"
				+ "  o.status_id as statusId,"
				+ "  o.service_id as serviceId,"
				+ "  stat.name as statusName,"
				+ "  serv.name as serviceName,"
				+ "  o.appointment_slot_id as timeSlotId,"
				+ "  tsl.label as timeSlotName,"
				+ "  o.description as orderDescription,"
				+ "  0 as b2bPrice, "
				+ "  v.first_name as vendorName,"
				+ "  o.address as customerAddress,"
				+ " o.contact_number as customerMobile,"
				+ " tsl.label as slotLabel,"
				+ "o.vendor_status as vendorstatus,"
				+ " loc.name as locationName, cdisc.discount as customerDiscount, " 
				+ "	o.is_new_customer as newCustomer, vvs.allvendorIds as all_vendorIds,o.customer_name as customerName ,"
				+ " o.no_bhk as nobhk,o.completionDate as completionDate ,o.billingto as billingto ,o.ownername as ownername,o.client_order_id as clientId,o.client_log as clientlog,o.coupon_code as couponcode,o.watsup_location as watsuplocation,o.location_id as locationId,vvs.serving_city as vendorcity from "
				+ "  order_info1 o inner join service1 serv on o.service_id = serv.id "
				+ "  inner join status_list1 stat on stat.id = o.status_id "
				+ "  left join time_slots1 tsl on tsl.id = o.appointment_slot_id "
				+ "  left join vendor1 v on o.vendor_id = v.id"
				+ "  left join users us on o.user_id = us.id"
				+ "  left join vendor_status vst on o.vendor_status = vst.id"
				+ "  left join  (select v.serving_city, vs.service_id, "
				+"	GROUP_CONCAT( distinct v.id  ORDER BY   v.id  SEPARATOR ', ' ) as allvendorIds from vendor1 "
				+"	 v , vendor_service1 vs,order_info1 o where 	 vs.vendor_id = v.id and " 
				+"	vs.service_id = o.service_id and v.serving_city = o.location_id 	group by " 
				+"	 vs.service_id,v.serving_city) vvs on (vvs.service_id = o.service_id )  "
				+ "  left join location1 loc on loc.id = o.location_id"
				+ "  left join customer_discount1 cdisc on cdisc.order_id = o.id  "
				+ " where DATE(o.booked_date) <= '2019-09-09'  ");
	
				
		if (StringUtils.isNotEmpty(serviceId) && !(serviceId.equalsIgnoreCase("null"))) {
			objStringBuffer.append("  and o.service_id in ("
					+ serviceId + ")");
		}
		if (StringUtils.isNotEmpty(phoneNo)) {
			objStringBuffer.append("  and o.contact_number in ("
					+ phoneNo + ")");
		}
		if (StringUtils.isNotEmpty(emailId)) {
			objStringBuffer.append("  and  o.contact_email in ("
					+ emailId + ")");
		}
		if (StringUtils.isNotEmpty(orderId)) {
			objStringBuffer.append("  and  o.generated_id in ("
					+ orderId + ")");
		}
		if (StringUtils.isNotEmpty(clientId)) {
			objStringBuffer.append("  and  o.client_order_id in ("
					+ clientId + ")");
		}
		if (StringUtils.isNotEmpty(statusId) && !(statusId.equalsIgnoreCase("null"))) {
			objStringBuffer.append("  and  o.status_id in ("
					+ statusId + ")");
		}
		if (StringUtils.isNotEmpty(userId) && !(userId.equalsIgnoreCase("null"))) {
			objStringBuffer.append("  and  o.user_id in ("
					+ userId + ")");
		}
	/*	if (StringUtils.isNotEmpty(userId) && (userId=="")) {
			objStringBuffer.append("  and  o.location_id in ("
					+ userId + ")");
		}*/
		if (StringUtils.isNotEmpty(vendorId) && !(vendorId.equalsIgnoreCase("null"))) {
			objStringBuffer.append("  and  o.vendor_id in ("
					+ vendorId + ")");
		}
		if (StringUtils.isNotEmpty(vendorstatusId) && !(vendorstatusId.equalsIgnoreCase("null"))) {
			objStringBuffer.append("  and  o.vendor_status in ("
					+ vendorstatusId + ")");
		}
		LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
		if(loginBean != null && ! (loginBean.getUserId().equals("1")) ){
			//System.out.println(loginBean.getRoleId());
			if(loginBean.getUserName().equals("opshyd")){
				objStringBuffer.append("  and  o.location_id ="	+19 );
			}else if(loginBean.getUserName().equals("opsban")){
				objStringBuffer.append("  and  o.location_id ="	+24 );
			}else if(loginBean.getUserName().equals("opspune")){
				objStringBuffer.append("  and  o.location_id ="	+20 );
			}else{
			objStringBuffer.append("  and  o.user_id ="
					+ loginBean.getUserId() );
			}
		}
	
		
		if (StringUtils.isNotEmpty(startDate) && StringUtils.isNotBlank(endDate) ) {
			objStringBuffer.append("  and  o.booked_date BETWEEN DATE('"+startDate+"') and DATE('"+endDate+"')");
		}
		//objStringBuffer.append(" and o.service_id not in(56) ");
		objStringBuffer.append("  order by Date(o.booked_date) desc limit 300");
		query = objStringBuffer.toString();
		//System.out.println(query);
		
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "orderId","gid","userId","clientlog","aurolog","vendorCharge", "bookedDate",
				"appointmentDate", "contactNo", "contactEmail","isPause", "orderAddress", "totalPrice","invoiceDate", "totalDiscount",
				"netAmount", "vendorId", "statusId", "serviceId", "statusName", "serviceName", "timeSlotId",
				"timeSlotName", "orderDescription", "b2bPrice", "vendorName", "customerAddress", "customerMobile",
				"slotLabel","vendorstatus", "locationName",  "newCustomer", "all_vendorIds","customerName",
				"nobhk", "completionDate", "billingto",  "ownername","clientId", "clientlog","couponcode","watsuplocation","locationId","vendorcity"});
		jdbcTemplate.query(query, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
	}

	public OrderInfo1 getByGeneratedId(String orderId) {
		String sql = "SELECT * from order_info1 where  generated_id = '" + orderId+"'";
		List<OrderInfo1> retlist = jdbcTemplate.query(sql, new Object[]{} ,
				ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
		if (retlist.size() > 0){
			return retlist.get(0);
		}else{
		return null;
		}
	}
	public List<OrderInfo1> getAllOrders(OrderInfo1 objOrderBean){
		String generatedId = objOrderBean.getGeneratedId();
		
		String sql = "SELECT ts.label as appointTimeName,oi.generated_id as generatedId, Date(oi.booked_date) as bookedDate,oi.appointment_date as appointmentDate,oi.contact_number as contactNumber,oi.contact_email as contactEmail, s.name as serviceName,"
                      +"oi.address as address ,oi.description as description FROM order_info1 oi, service1 s,time_slots1 ts where s.id = oi.service_id and ts.id = oi.appointment_slot_id  and oi.generated_id = '" + generatedId+"'" ;
		List<OrderInfo1> retlist = jdbcTemplate.query(sql,
		new Object[]{},
		ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
		System.out.println(sql);
		return retlist;
		
	}
	public List<OrderInfo1> getPathologyOrder(OrderInfo1 objOrderBean){
		String generatedId = objOrderBean.getGeneratedId();
		//String sql = "SELECT ts.label as appointTimeName,oi.generated_id as generatedId,oi.id as oid, CONCAT(ve.first_name, ' ', ve.last_name) as vendorName ,sl.name as statusName,ve.mobile_number as vendorMobile, "
		
		/*String sql ="SELECT ts.label as appointTimeName,oi.generated_id as generatedId,oi.id as oid, sl.name as statusName,"
				+ " Date(oi.booked_date) as bookedDate,oi.appointment_date as appointmentDate,oi.contact_number as contactNumber,"
				+ "oi.contact_email as contactEmail, s.name as serviceName,oi.address as address ,oi.description as description "
				+ "FROM order_info1 oi  join  status_list1 sl on sl.id = oi.status_id"
				+ "  join    service1 s on oi.service_id= s.id   join time_slots1 ts on ts.id = oi.appointment_slot_id   "
				+ "and oi.generated_id = '"+generatedId+"' group by generated_id";
		*/
		String sql = "SELECT ts.label as appointTimeName,oi.generated_id as generatedId,oi.id as oid,sl.name as statusName, oi.goodsName as goodsName,oi.goodPaidBy as goodPaidBy,"
				 +"Date(oi.booked_date) as bookedDate,oi.appointment_date as appointmentDate, oi.description as description,oi.client_order_id as clientOrderId,"
				 +"oi.contact_number as contactNumber,oi.contact_email as contactEmail, "
				 +"s.name as serviceName,oi.customer_name as customerName,"
				 +"s.name as serviceName,oi.vendor_service_charge as vendorServiceCharge,oi.goods_charge as goodsCharge,"
				 +"oi.margin_value as marginValue,oi.no_of_hours_work as noOfHoursWork,oi.transportaion_charge as transportaionCharge,"
				 +"oi.no_of_visits as noOfVisits,oi.fixed_charge as fixedCharge,oi.watsup_location as watsupLocation,"  
				 +"oi.auro_log as auroLog,u.name as userName ,CONCAT(v.first_name, ' ', v.last_name) as vendorName, vs.statusname as vendorStatusName ,"
				+ "(select GROUP_CONCAT(su.name SEPARATOR ' , ') from order_service_unit1 osu ,service_unit1 su, service_unit_vendor suv " 
				+" where osu.service_unit_id = suv.id and su.id = suv.service_unit_id and oi.id = osu.order_id ) as tests,"
				 +"oi.address as address ,oi.description as description FROM "
				 + " order_info1 oi left join vendor1 v on oi.vendor_id = v.id left join vendor_status vs on oi.vendor_status = vs.id, status_list1 sl, users u, " 
				 +"service1 s,time_slots1 ts   where s.id = oi.service_id  and sl.id = oi.status_id and   oi.user_id=u.id "
				 +"and ts.id = oi.appointment_slot_id   and oi.generated_id = '" + generatedId+"'" ;
	List<OrderInfo1> retlist = jdbcTemplate.query(sql,
	new Object[]{},
	ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
	//System.out.println(sql);
	return retlist;
	}
	public List<OrderInfo1> getDoctorOrders(OrderInfo1 objOrderBean){
		String generatedId = objOrderBean.getGeneratedId();
		String sql = "SELECT ts.label as appointTimeName,oi.generated_id as generatedId,"
						+" Date(oi.booked_date) as bookedDate,oi.appointment_date as appointmentDate,"
						+"oi.contact_number as contactNumber,oi.contact_email as contactEmail, "
						+"s.name as serviceName,"
						+"(select GROUP_CONCAT(su.name SEPARATOR ' , ') from order_symptom1 osu ,symptom1 su "
						+"where osu.symptom_id = su.id and oi.id = osu.order_id ) as symtoms,"
						+"oi.address as address ,oi.description as description FROM order_info1 oi, "
						+"service1 s,time_slots1 ts   where s.id = oi.service_id "
						+"and ts.id = oi.appointment_slot_id   and oi.generated_id = '" + generatedId+"'";
	List<OrderInfo1> retlist = jdbcTemplate.query(sql,
	new Object[]{},
	ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
	//System.out.println(sql);
	return retlist;
	}
	
	
	public int getCustomerInfo(String mobileNo){
		String sql = "select count(*) as count from order_info1 where contact_number ='" + mobileNo+"'" ;
	int count = jdbcTemplate.queryForInt(sql);
	//System.out.println(sql);
	return count;
	}
	
	public int get(String mobileNo){
		String sql = "select count(*) as count from order_info1 where contact_number ='" + mobileNo+"'" ;
	int count = jdbcTemplate.queryForInt(sql);
	//System.out.println(sql);
	return count;
	}


	public  void addStatus(String orderId, int status)
	{

		OrderStatusLog1 osl = new OrderStatusLog1();
		OrderInfo1 orderInfo = this.getByGeneratedId(orderId);
		if(osl.getStatusId() != status)
		{
			osl.setStatusId(status);
			osl.setOrderId(orderInfo.getId());
			orderInfo.setStatusId(status);

			orderStatusLog1Dao.save(osl);
			this.save(orderInfo);
		}
	}

public List<String>  getOrderIdsByPhone(String phone)
{
	String query = "select generated_id from order_info1 where status_id = " + AuroConstants.enRoute ;
	SingleValueCallbackHandler handler = new SingleValueCallbackHandler("generated_id");
	jdbcTemplate.query(query, handler);
	List<String> result = handler.getResult();
		return result;
}

public List<OrderInfo1>  getOrderDataByPhone(String phone)
{
	String query = "select oi.generated_id, v.mobile_number as vendorMobile from order_info1 oi, vendor1 v  where oi.vendor_id = v.id and  status_id = " + AuroConstants.start ;
	List<OrderInfo1> list = jdbcTemplate.query(query, new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
	return list;
}
	

public void addFeedback(OrderInfo1 orderInfo, String happy_rating, String happy_comments)
{

	String query = " insert ignore into order_happiness( created_time, order_id, service_unit_id, happiness, feedback ) " +
	" (select now() , o1.id, sun.service_unit_id , \"" + happy_rating + "\", \"" + 
	happy_comments + "\" from order_info1 o1, order_service_unit1 sun where o1.id = sun.order_id  and o1.id = ? )";
	jdbcTemplate.update(query, new Object[] {orderInfo.getId()});


query = " select suv.service_unit_id from order_service_unit1 osu, service_unit_vendor suv   where osu.service_unit_id = suv.id and order_id = " + orderInfo.getId();
	SingleValueCallbackHandler handler = new SingleValueCallbackHandler("service_unit_id");
	jdbcTemplate.query(query, handler);
	List<String> result = handler.getResult();

	StringBuilder bls = new StringBuilder("(");
	int ct = 0;
	for(String eachR : result)
	{
		if(ct != 0)
		{
			bls.append(",");
		}
		else
		{
			ct++;
		}
		bls.append(eachR);
	}
	bls.append(")");

	query = "select service_unit_id, count(id)+1 as served_number from order_service_unit1 where service_unit_id in "
		+ bls.toString() + " group by service_unit_id";

		KeyValueCallbackHandler handler2 = new KeyValueCallbackHandler  ("service_unit_id","served_number");
		jdbcTemplate.query(query, handler2);

		Map<String, String> result2 = handler2.getResult();

	query = "update service_unit_happiness suh set served_number = ? where serviice_unit_id = ?";

	Set<String> keys = result2.keySet();

	for(String eachkey : keys)
	{
		jdbcTemplate.update(query , new Object[]{eachkey, result2.get(eachkey) });
	}


//	query = " insert ignore into service_unit_happiness ( created_time, service_unit_id, happiness ) (select now(), service_unit_id , avg(happiness) from order_happiness where order_id = ? group by service_unit_id )" ;
//	jdbcTemplate.update(query, new Object[] {orderInfo.getId()});

//	query = " update service_unit_happiness suh, order_happiness oh  set suh.happiness = avg( oh.happiness)  where oh.order_id = ? group by oh.service_unit_id )" ;
//	jdbcTemplate.update(query, new Object[] {orderInfo.getId()});


//	query = " 
//	replace into service_unit_happiness 
//	( created_time,  service_unit_id, vendor_id, happiness , time_to_serve, served_number ) 
//	
//	ignore into order_happiness( created_time, order_id, service_unit_id, vendor_id,happiness, feedback ) " +
//	" (select now() , o1.id, sun.id , o1.vendor_id, \"" + happy_rating + "\", \"" + 
//	happy_comments + "\" from order_info1 o1, order_service_unit1 sun where o1.id = sun.order_id  )";
//	jdbcTemplate.update(query);

}

		public OrderInfo1  getLastOrder(String mobileNumber)
		{
			String query = " 	select * from order_info1 where contact_number = \"" + mobileNumber + "\" order by id desc limit 1" ;
	List<OrderInfo1> list = jdbcTemplate.query(query, new Object[]{},
			ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
			if(list != null)
			{
				return list.get(0);
			}
			return null;

		}
		
		public List<OrderInfo1> getOrders(String phone)
		{

			//System.out.println(phone);
			String query = "select * from order_info1 where contact_number = \"" + phone + "\" order by id desc";
			///System.out.println(query);
			List<OrderInfo1> handler = jdbcTemplate.query(query, ParameterizedBeanPropertyRowMapper.newInstance(OrderInfo1.class));
			 //System.out.println(query);
	     
			 return handler;
	  }
		
		public List<Object> getCustomerOrderDetail(String phone, Map<String , OrderSequence> orderSeqMap, String baseUrl) throws Exception
		{
			
		 BeanUtilsCallbackHandler handler = new BeanUtilsCallbackHandler(
		 "com.aurospaces.neighbourhood.db.model.CustomerOrderDetails" , new String[] { "order_id", "service_name","package_name", "vendor" ,"img_url", "total_amount", "status_id", "service_id", "time_slot"});
		 
		String query = "  select o.appointment_slot_id as time_slot,su.name as package_name,o.status_id as status_id ,concat('"+baseUrl+"' , su.img_url) as img_url,  o.generated_id as order_id, s1.id as service_id, s1.name as service_name,suv.final_price as total_amount,  v.first_name  as vendor from order_info1 o, service1 s1, status_list1 sl, vendor1 v, order_service_unit1 osu, service_unit1 su, service_unit_vendor suv   where suv.service_unit_id = su.id and  v.id = o.vendor_id and s1.id = o.service_id and o.status_id = sl.id and o.status_id not in (4,6,9,12,18) and osu.order_id = o.id  and suv.id = osu.service_unit_id and o.contact_number="+phone;
	//System.out.println("getCustomerOrderDetail...."+query);	
	     jdbcTemplate.query(query,handler);
	     List<Object> details  =  handler.getResult();
			 for(Object obj  : details)
			 {
			 		CustomerOrderDetails detail = (CustomerOrderDetails) obj;
			 		OrderSequence stat = orderSeqMap.get(detail.service_id);
					detail.setStatus(stat);
			 }
			 return details;
	}
		//for mobile validating coupon code..
		
		public List<CouponCode> validateCoupon(String couponCode){
			List<CouponCode> listCode = null;
			try{
				String sql ="select c.id as coupon_id from coupon c , coupon_code cc where c.coupon_code_id = cc.id and c.code = '"+couponCode+"' and date(cc.expiry_time) >= date(now());";
				listCode = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CouponCode>(CouponCode.class));
			}catch(Exception e){
				e.printStackTrace();
			}
			return listCode;
		}
		
		public List<OrderInfo1> getOrderClinetLog(int orderId){
			List<OrderInfo1> listLog = null;
			try{
				String sql ="select updated_time as updatedTime, client_log as clientLog from client_order_log where order_id ="+orderId;
				listLog = jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderInfo1>(OrderInfo1.class));
			}catch(Exception e){
				e.printStackTrace();
			}
			return listLog;
		}
		
		public List<OrderInfo1> getOrderAuroLog(int orderId){
			List<OrderInfo1> listLog = null;
			try{
				String sql ="select updated_time as updatedTime, aurospaces_log as auroLog from aurospaces_order_log where order_id ="+orderId;
				listLog = jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderInfo1>(OrderInfo1.class));
			}catch(Exception e){
				e.printStackTrace();
			}
			return listLog;
		}

			public List<Map<String, String>> getFilterOrder(OrderInfo1 objOrderInfo) {
				StringBuffer objStringBuffer = new StringBuffer();
				String query = null;
				int id = 0;
				String date = ""; 
				String date1 = ""; 
				objStringBuffer.append("select  o.generated_id as orderId, o.id as gid,o.user_id as userId , o.client_log as clientlog,o.auro_log as aurolog,"
						+ "  o.booked_date as bookedDate,"
						+ "  o.appointment_date as appointmentDate,"
						+ "  o.contact_number as contactNo,"
						+ "  o.contact_email as contactEmail,"
						+ "  o.address as orderAddress,"
						+ "  o.total_price as totalPrice,"
						+ "  o.total_discount as totalDiscount,"
						+ "  o.net_amount as netAmount,"
						+ "  o.vendor_id as vendorId,"
						+ "  o.status_id as statusId,"
						+ "  o.service_id as serviceId,"
						+ "  stat.name as statusName,"
						+ "  serv.name as serviceName,"
						+ "  o.appointment_slot_id as timeSlotId,"
						+ "  tsl.label as timeSlotName,"
						+ "  o.description as orderDescription,"
						+ "  v.first_name as vendorName,"
						+ "  o.address as customerAddress,"
						+ " o.contact_number as customerMobile,"
						+ " tsl.label as slotLabel,"
						+ " loc.name as locationName, "
						+ "	o.is_new_customer as newCustomer from "
						+ "  order_info1 o inner join service1 serv on o.service_id = serv.id "
						+ "  inner join status_list1 stat on stat.id = o.status_id "
						+ "  left join time_slots1 tsl on tsl.id = o.appointment_slot_id "
						+ "  left join vendor1 v on o.vendor_id = v.id"
						+ "  left join location1 loc on loc.id = o.location_id"
						+ "  "
						+ "where serv.active = "+1);
						 id = objOrderInfo.getStatusId();
						 date = objOrderInfo.getAddress();
						 date1 =objOrderInfo.getClientOrderId();
				if (id == 3) {
					objStringBuffer.append("  and o.status_id = "+id);
				}
				if (id == 4) {
					objStringBuffer.append("  and o.status_id NOT IN (4,9,18)");
				}
				if (id == 18) {
					objStringBuffer.append("  and o.status_id = "+id);
				}
				if (id == 2) {
					objStringBuffer.append("  and o.status_id = "+id);
				}
				if(date1 != null && date != null){
					objStringBuffer.append("  and o.booked_date BETWEEN DATE('"+date+"') and DATE('"+date1+"')");
				}
				LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
				if(loginBean != null && ! (loginBean.getUserId().equals("1")) ){
					//System.out.println(loginBean.getRoleId());
					if(loginBean.getUserName().equals("opshyd")){
						objStringBuffer.append("  and  o.location_id ="	+19 );
					}else if(loginBean.getUserName().equals("opsban")){
						objStringBuffer.append("  and  o.location_id ="	+24 );
					}else if(loginBean.getUserName().equals("opspune")){
						objStringBuffer.append("  and  o.location_id ="	+20 );
					}else{
					objStringBuffer.append("  and  o.user_id ="
							+ loginBean.getUserId() );
					}
				}
				//cal.date BETWEEN '2009-06-25' AND '2009-07-01';
				objStringBuffer.append("  order by o.booked_date desc");
				query = objStringBuffer.toString();
				System.out.println(query);
				
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "orderId","gid","userId","clientlog","aurolog", "bookedDate",
						"appointmentDate", "contactNo", "contactEmail", "orderAddress", "totalPrice", "totalDiscount",
						"netAmount", "vendorId", "statusId", "serviceId", "statusName", "serviceName", "timeSlotId",
						"timeSlotName", "orderDescription",  "vendorName", "customerAddress", "customerMobile",
						"slotLabel", "locationName", "newCustomer" });
				jdbcTemplate.query(query, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
			}
			
			public double totalNetAmount( OrderInfo1 orderInfo1){
				double listCode = 0;
				 String date = orderInfo1.getAddress();
				 String date1 =	orderInfo1.getClientOrderId();
				try{
					String sql ="SELECT sum(net_amount)   FROM order_info1 where (booked_date BETWEEN DATE('"+date+"') and DATE('"+date1+"') );";
					listCode = jdbcTemplate.queryForObject(sql, (Double.class));
					
				}catch(Exception e){
					e.printStackTrace();
				}
				return listCode;
			}
			
			public List<Map<String, String>> getMonthlyAmount(){
				
			/*	String sql ="SELECT sum(net_amount) as totalNetAmount,monthname(booked_date) as month ,year(booked_date) as year,count(*) as totalOrders  FROM order_info1 " 
								+"GROUP BY month(booked_date),  year(booked_date);" ;
*/
				String sql = "SELECT sum(o.net_amount) as totalNetAmount,avg(o.net_amount) as avgNetamout, monthname(o.booked_date) as month , year(o.booked_date) as year,count(*) as totalOrders, u.name as userName FROM order_info1 o ,users u where o.user_id=u.id"  
					         +" GROUP BY user_id, month(booked_date),  year(booked_date)";
				
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "totalNetAmount","avgNetamout","month","year","totalOrders","userName" });
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}
          public List<Map<String, String>> getdailyOrders(String userName,String statusName,String startDate){
        	  StringBuffer objStringBuffer = new StringBuffer();
				String sql =null;
				objStringBuffer.append("SELECT sum(o.net_amount) as totalNetAmount,date(o.booked_date) as bookedDate ,s.name as statusName,"+
						"monthname(o.booked_date) as month , year(o.booked_date) as year,count(*) as totalOrders,"+
						"u.name as userName,o.user_id as userId FROM order_info1 o ,users u,status_list1 s where o.user_id=u.id and o.status_id=s.id   ");
				if (StringUtils.isNotEmpty(statusName) && !(statusName.equalsIgnoreCase("null"))) {
					objStringBuffer.append("  and  o.status_id in ("
							+ statusName + ")");
				}
				if (StringUtils.isNotEmpty(userName) && !(userName.equalsIgnoreCase("null"))) {
					objStringBuffer.append("  and  o.user_id in ("
							+ userName + ")");
				}
				if (StringUtils.isNotEmpty(startDate)) {
					objStringBuffer.append("  and  date(o.booked_date) in ('"+startDate+"')");
				}
				
				objStringBuffer.append(" GROUP BY user_id,status_id,date(bookedDate) ,month(bookedDate), year(bookedDate)  order By date(bookedDate) desc");
				sql = objStringBuffer.toString();
				//System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "totalNetAmount","bookedDate","month","year","totalOrders","userName","statusName"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}
          public List<Map<String, String>> servicereport(String startDate,String endDate){
        	  StringBuffer objStringBuffer = new StringBuffer();
				String sql =null;
				objStringBuffer.append("SELECT sum(o.total_price) as totalNetAmount,date(o.booked_date) as bookedDate ,o.margin_value as marginValue,o.goods_charge as goodsCharge,sl.name as serviceName,"+
                                       "count(*) as totalOrders,u.name as userName,o.user_id as userId FROM order_info1 o ,service1 sl,"+
                                       "users u where o.user_id=u.id and o.service_id=sl.id ");
				if(StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
					objStringBuffer.append("  and o.booked_date BETWEEN DATE('"+startDate+"') and DATE('"+endDate+"')");
				}
				LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
				if(loginBean != null && ! (loginBean.getRoleId().equals("1")) ){
					//System.out.println(loginBean.getRoleId());
					objStringBuffer.append("  and  o.user_id ="
							+ loginBean.getUserId() );
				}
				objStringBuffer.append(" GROUP BY user_id,service_id,date(bookedDate) order By date(bookedDate) desc");
				sql = objStringBuffer.toString();
				//System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "totalNetAmount","bookedDate","marginValue","goodsCharge","totalOrders","userName","serviceName"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}
          public List<Map<String, String>> getWeeklyOrders(){
        	  StringBuffer objStringBuffer = new StringBuffer();
        	  String sql =null;
        	  objStringBuffer.append("SELECT sum(o.vendor_service_charge) as vendorCharge,sum(o.margin_value) as marginvalue,sum(o.goods_charge) as goodscharge,sum(fixed_charge) as fixedCharge,u.name as clientName, COUNT(*) as orders, sum(net_amount) as netAmount,DATE_ADD( DATE(o.booked_date)," 
								+"INTERVAL (7 - DAYOFWEEK( o.booked_date )) DAY) weekending,o.user_id as userId"
								+" FROM order_info1 o"
								+ "  left join location1 loc on loc.id = o.location_id left join users u on o.user_id = u.id ") ;
        	  
        	  LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
				if(loginBean != null && ! (loginBean.getUserId().equals("1")) ){
					//System.out.println(loginBean.getRoleId());
					if(loginBean.getUserName().equals("opshyd")){
						objStringBuffer.append("  and  o.location_id ="	+19 );
					}else if(loginBean.getUserName().equals("opsban")){
						objStringBuffer.append("  and  o.location_id ="	+24 );
					}else{
					objStringBuffer.append("  and  o.user_id ="
							+ loginBean.getUserId() );
					}
				}
				objStringBuffer.append( " WHERE DATE(o.booked_date) <= CURDATE() and DATE(o.appointment_date) <= CURDATE()");
				objStringBuffer.append( " GROUP BY weekending,o.user_id order by weekending desc;");
				//System.out.println(sql);
				sql=objStringBuffer.toString();
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "fixedCharge","goodscharge","marginvalue","vendorCharge","clientName","orders","netAmount","weekending","userId"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}
          public List<Map<String, String>> getstatusBetween(OrderInfo1 orderInfo){
        	  String sql = null;
        	  int id = 0;
				StringBuffer objStringBuffer = new StringBuffer();
        	  objStringBuffer.append("select sl.name as statusName , count(*) as numberOfOrders ,u.name as userName "
						+" from order_info1 oi , status_list1 sl,users u where oi.status_id = sl.id and oi.user_id = u.id ");
        	  id = orderInfo.getStatusId();
						
					if(StringUtils.isNotEmpty(orderInfo.getAddress()) && StringUtils.isNotEmpty(orderInfo.getClientOrderId())){
						objStringBuffer.append(" and oi.booked_date BETWEEN DATE('"+orderInfo.getAddress()+"') and DATE('"+orderInfo.getClientOrderId()+"')");
						
					}
					 
						objStringBuffer.append("  and oi.status_id = " +3);
					
					objStringBuffer.append(" group by statusName,userName order by userName");
					sql = objStringBuffer.toString();
							//System.out.println(sql);
							RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "statusName","numberOfOrders","userName"});
							jdbcTemplate.query(sql, handler);
							List<Map<String, String>> result = handler.getResult();
							return result;
											
			}
          public List<Map<String, String>> getstatusopenBetween(OrderInfo1 orderInfo){
        	  String sql = null;
        	  int id = 0;
				StringBuffer objStringBuffer = new StringBuffer();
        	  objStringBuffer.append("select sl.name as statusName , count(*) as numberOfOrders ,u.name as userName "
						+" from order_info1 oi , status_list1 sl,users u where oi.status_id = sl.id and oi.user_id = u.id ");
        	  id = orderInfo.getStatusId();
						
					if(StringUtils.isNotEmpty(orderInfo.getAddress()) && StringUtils.isNotEmpty(orderInfo.getClientOrderId())){
						objStringBuffer.append(" and oi.booked_date BETWEEN DATE('"+orderInfo.getAddress()+"') and DATE('"+orderInfo.getClientOrderId()+"')");
						
					}
					 
						LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
			    		if(loginBean != null && ! (loginBean.getRoleId().equals("1"))){
			    			//System.out.println(loginBean.getRoleId());
			    			objStringBuffer.append("  and  oi.user_id ="
			    					+ loginBean.getUserId() );
			    		}
					
					objStringBuffer.append(" group by statusName,userName order by userName");
					sql = objStringBuffer.toString();
							//System.out.println(sql);
							RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "statusName","numberOfOrders","userName"});
							jdbcTemplate.query(sql, handler);
							List<Map<String, String>> result = handler.getResult();
							return result;
											
			}
          public List<Map<String, String>> getstatusclosedBetween(OrderInfo1 orderInfo){
        	  String sql = null;
        	  int id = 0;
				StringBuffer objStringBuffer = new StringBuffer();
        	  objStringBuffer.append("select sl.name as statusName , count(*) as numberOfOrders ,u.name as userName "
						+" from order_info1 oi , status_list1 sl,users u where oi.status_id = sl.id and oi.user_id = u.id ");
        	  id = orderInfo.getStatusId();
						
					if(StringUtils.isNotEmpty(orderInfo.getAddress()) && StringUtils.isNotEmpty(orderInfo.getClientOrderId())){
						objStringBuffer.append(" and oi.booked_date BETWEEN DATE('"+orderInfo.getAddress()+"') and DATE('"+orderInfo.getClientOrderId()+"')");
						
					}
					 
						objStringBuffer.append("  and oi.status_id = " +9);
						LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
			    		if(loginBean != null && ! (loginBean.getRoleId().equals("1"))){
			    			//System.out.println(loginBean.getRoleId());
			    			objStringBuffer.append("  and  oi.user_id ="
			    					+ loginBean.getUserId() );
			    		}
					
					objStringBuffer.append(" group by statusName,userName order by userName");
					sql = objStringBuffer.toString();
							//System.out.println(sql);
							RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "statusName","numberOfOrders","userName"});
							jdbcTemplate.query(sql, handler);
							List<Map<String, String>> result = handler.getResult();
							return result;
											
			}
          public List<Map<String, String>> getstatusassignedBetween(OrderInfo1 orderInfo){
        	  String sql = null;
        	  int id = 0;
				StringBuffer objStringBuffer = new StringBuffer();
        	  objStringBuffer.append("select sl.name as statusName , count(*) as numberOfOrders ,u.name as userName "
						+" from order_info1 oi , status_list1 sl,users u where oi.status_id = sl.id and oi.user_id = u.id ");
        	  id = orderInfo.getStatusId();
						
					if(StringUtils.isNotEmpty(orderInfo.getAddress()) && StringUtils.isNotEmpty(orderInfo.getClientOrderId())){
						objStringBuffer.append(" and oi.booked_date BETWEEN DATE('"+orderInfo.getAddress()+"') and DATE('"+orderInfo.getClientOrderId()+"')");
						
					}
					 
						objStringBuffer.append("  and oi.status_id = " +2);
					
					objStringBuffer.append(" group by statusName,userName order by userName");
					sql = objStringBuffer.toString();
							//System.out.println(sql);
							RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "statusName","numberOfOrders","userName"});
							jdbcTemplate.query(sql, handler);
							List<Map<String, String>> result = handler.getResult();
							return result;
											
			}
          public List<Map<String, String>> grapic(){
				
				String sql ="select service_id as service ,count(*) as orders from order_info1 group by service_id" ;

				//System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "service","orders"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
				
			}
          
          
          public List<Map<String, String>> getVendorServiceBased(){
  				
  				String sql ="select v.id as vendorId,CONCAT(v.first_name, ' ', v.last_name) as vendorName,s.name as serviceName,s.id as serviceId  from vendor1 v, order_info1 oi ,service1 s, "
						+" vendor_service1 vs where "
						+" oi.service_id =vs.service_id and v.id = vs.vendor_id and s.id = vs.service_id group by v.id ,s.name,s.id";

  				//System.out.println(sql);
  				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "vendorId","vendorName","serviceName","serviceId"});
  				jdbcTemplate.query(sql, handler);
  				List<Map<String, String>> result = handler.getResult();
  				return result;
        	  
  			
  		}
          public List<Map<String, String>> getRevenuReport(String startdate,String enddate,String userId,String statusId,String serviceId,String locationId){
        	  String sql = null;
        	  StringBuffer objStringBuffer = new StringBuffer();
        	  objStringBuffer.append("SELECT sum(o.net_amount) as totalNetAmount,(sum(o.net_amount)/na)*100 as avgNetamout, "
							+" monthname(o.booked_date) as month ,month(o.booked_date) as monthnum, year(o.booked_date) as year,"
							+"count(*) as totalOrders, (count(*)/rs)*100 as averageOrders, u.name as userName FROM "
							+"(select count(*) as rs,sum(net_amount) as na from order_info1) as ts ,order_info1 o ,users u " 
							+"where o.user_id=u.id");
        	  if(StringUtils.isNotBlank(startdate) && StringUtils.isNotBlank(enddate) ){
        		  objStringBuffer.append(" and o.booked_date BETWEEN DATE('"+startdate+"') and DATE('"+enddate+"')");
        	  }
        	  if (StringUtils.isNotEmpty(userId) && !(userId.equalsIgnoreCase("null"))) {
        		  objStringBuffer.append(" and o.user_id in ("+userId+")");
      		}
        	  
        	  
        	  if(  StringUtils.isNotEmpty(statusId) && !(statusId.equalsIgnoreCase("null")) ){
        		  objStringBuffer.append(" and o.status_id in ("+statusId+")");
        	  }
        	  if(  StringUtils.isNotEmpty(serviceId) && !(serviceId.equalsIgnoreCase("null"))){
        		  objStringBuffer.append(" and o.service_id in ("+serviceId+")");
        	  }
        	  if(  StringUtils.isNotEmpty(locationId) && !(locationId.equalsIgnoreCase("null"))){
        		  objStringBuffer.append(" and o.location_id in ("+locationId+")");
        	  }
        	  objStringBuffer.append(" and DATE(o.booked_date) < CURDATE() ");
        	  objStringBuffer.append(" GROUP BY user_id, month(booked_date), year(booked_date) order by year(o.booked_date) desc, MONTH(o.booked_date) desc ");
        	  
        	  sql = objStringBuffer.toString();
				System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "totalNetAmount","avgNetamout","month","year","totalOrders","averageOrders","userName"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
      	  
			
		}
          
          public HashMap<Integer, String>   getAllVendors1() {
        	  HashMap<Integer, String> map = new HashMap<Integer, String>();
  			String sql = "SELECT id, first_name , last_name from vendor1";
  			SqlRowSet  rs = jdbcTemplate.queryForRowSet(sql);
  			String fullName = "";
  			while (rs.next()) {
  				if (StringUtils.isNotBlank(rs.getString("first_name"))) {
  					fullName = rs.getString("first_name");
  				}
  				if (StringUtils.isNotBlank(rs.getString("last_name"))) {
  					fullName = fullName + " " + rs.getString("last_name");
  				}
  				fullName = fullName.trim();
  				
  				map.put(rs.getInt("id"), fullName);
  			}
  			
  			
  			return map;
  		}

          public List<OrderInfo1> getCronData(){
      		String sql = "SELECT sl.name as statusName, count(*) as count, us.name as userName from order_info1 oi, users us, status_list1 sl "
      				+ "where oi.status_id = sl.id and oi.user_id = us.id "
      				+ "and DATE(oi.booked_date) = Date(now()) group by oi.status_id ,userName;" ;
      		List<OrderInfo1> retlist = jdbcTemplate.query(sql,new BeanPropertyRowMapper<OrderInfo1>(OrderInfo1.class));
      		//System.out.println(sql);
      		return retlist;
      		
      	}
          public List<Map<String, String>> getBookingOrders() {
      		StringBuffer objStringBuffer = new StringBuffer();
      		String query = null;
      				
      		objStringBuffer.append("select o.generated_id as orderId, o.id as gid,o.user_id as userId , o.client_log as clientlog,o.auro_log as aurolog,o.vendor_service_charge as vendorCharge,"
      				+ "  o.booked_date as bookedDate,"
      				+ "  o.appointment_date as appointmentDate,"
      				+ "  o.contact_number as contactNo,"
      				+ "  o.contact_email as contactEmail,"
      				+ "  o.address as orderAddress,"
      				+ "  o.total_price as totalPrice,"
      				+ "  o.total_discount as totalDiscount,"
      				+ "  o.net_amount as netAmount,"
      				+ "  o.vendor_id as vendorId,"
      				+ "  o.status_id as statusId,"
      				+ "  o.service_id as serviceId,"
      				+ "  stat.name as statusName,"
      				+ "  serv.name as serviceName,"
      				+ "  o.appointment_slot_id as timeSlotId,"
      				+ "  tsl.label as timeSlotName,"
      				+ "  o.description as orderDescription,"
      				+ "  0 as b2bPrice,"
      				+ "  v.first_name as vendorName,"
      				+ "  o.address as customerAddress,"
      				+ " o.contact_number as customerMobile,"
      				+ " tsl.label as slotLabel,"
      				+ "o.vendor_status as vendorstatus,"
      				+ " loc.name as locationName, cdisc.discount as customerDiscount, "
      				+ "	o.is_new_customer as newCustomer, vvs.allvendorIds as all_vendorIds,o.customer_name as customerName  from "
      				+ "  order_info1 o inner join service1 serv on o.service_id = serv.id "
      				+ "  inner join status_list1 stat on stat.id = o.status_id "
      				+ "  left join time_slots1 tsl on tsl.id = o.appointment_slot_id "
      				+ "  left join vendor1 v on o.vendor_id = v.id"
      				+ "  left join (select vs.service_id,  GROUP_CONCAT( distinct v.id  ORDER BY   v.id  SEPARATOR ', ') as allvendorIds from "
      				+ "  vendor1 v  left JOIN vendor_service1  vs ON (vs.vendor_id = v.id) group by"
      				+ "  vs.service_id) vvs on (vvs.service_id = o.service_id)"
      				+ "  left join location1 loc on loc.id = o.location_id"
      				+ "  left join customer_discount1 cdisc on cdisc.order_id = o.id "
      				+ "where serv.active = 1 ");
      		LoginBean loginBean = (LoginBean)session.getAttribute("cacheUserBean");
    		if(loginBean != null && ! (loginBean.getRoleId().equals("1"))){
    			//System.out.println(loginBean.getRoleId());
    			objStringBuffer.append("  and  o.user_id ="
    					+ loginBean.getUserId() );
    		}
      		objStringBuffer.append("  order by o.booked_date desc limit 50");
    		query = objStringBuffer.toString();
    		//System.out.println(query);
    		
    		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "orderId","gid","userId","clientlog","aurolog","vendorCharge", "bookedDate",
    				"appointmentDate", "contactNo", "contactEmail", "orderAddress", "totalPrice", "totalDiscount",
    				"netAmount", "vendorId", "statusId", "serviceId", "statusName", "serviceName", "timeSlotId",
    				"timeSlotName", "orderDescription", "b2bPrice", "vendorName", "customerAddress", "customerMobile",
    				"slotLabel","vendorstatus", "locationName", "customerDiscount", "newCustomer", "all_vendorIds","customerName" });
    		jdbcTemplate.query(query, handler);
    		List<Map<String, String>> result = handler.getResult();
    		return result;
      	
     }
          public List<OrderInfo1>  getInvoiceDetails(String orderId,String bookedDate,int userInd){
        	  String sql = null;
				List<OrderInfo1> listLog = null;
				try{
					StringBuffer objStringBuffer = new StringBuffer();
		        	  objStringBuffer.append("SELECT u.display_name as displayName,o.total_price as totalPrice,o.total_discount as totalDiscount,o.goodsName,o.user_id, o.description, o.completionDate, o.address,booked_date as bookedDate,appointment_date as appointmentDate ,group_concat(distinct generated_id) as orderId,"
									+" sum(fixed_charge) as fixedCharge,"
									+"group_concat(distinct o.id) as ids,"
									+" o.id as id,o.vendor_service_charge as vendorServiceCharge,v.address as vendoraddress,o.no_of_hours_work as noOfHoursWork , "
									+"group_concat(distinct s.name) as serviceName,concat_ws (' ',v.first_name,v.last_name) as vendorName, "
									+" sum(goods_charge) as goodsCharge,sum(vendor_service_charge) as vendorServiceCharge, "
									+" sum(transportaion_charge) as transportaionCharge,"
									+"sum(margin_value) as marginValue,"
									+"client_order_id as clientOrderId,"
									+"o.customer_name as customerName, "
									+"o.ownername as ownerName, o.billingto as billingTo,"
									+"u.name as userName,v.account_number as accountNumber,v.bank_name as bankName,v.ifsc_code as ifscCode,v.branch_name as branchName,o.invoice_date as invoiceDate  "
									+"from order_info1 o,service1 s,users u,vendor1 v where v.id =o.vendor_id and o.service_id = s.id and o.user_id = u.id  and o.booked_date = '"+ bookedDate + "' ");
									if(userInd == 1 || userInd == 3){
										objStringBuffer.append(" and generated_id = '"+ orderId + "' ");
									}else{
										objStringBuffer.append(" and client_order_id = '"+ orderId + "' ");
									}
									
									
						objStringBuffer.append( "group by client_order_id,o.user_id,booked_date ");
		        	 
		        	  
		        	  sql = objStringBuffer.toString();
		        	  System.out.println("Query:"+sql);
					listLog = jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderInfo1>(OrderInfo1.class));
				}catch(Exception e){
					e.printStackTrace();
				}
				return listLog;
			
		}
  public List<Map<String, String>> getprofitReport(String startdate,String enddate){
        	  String sql = null;
        	  StringBuffer objStringBuffer = new StringBuffer();
        	  objStringBuffer.append("select sum(net_amount)+sum(goods_charge)+sum(fixed_charge)+sum(vendor_service_charge) +sum(transportaion_charge) as serviceCharge ,count(*) as totalOrders,"
									  +"margin_value as profit ,CONCAT(monthname(booked_date),'-',year(booked_date) ) as monthyear,us.name as clientname from order_info1 oi,users us where oi.user_id = us.id " 
        			  
										+ "group by monthname(booked_date),year(booked_date),user_id order by year(booked_date),month(booked_date)");
        	  
        	  sql = objStringBuffer.toString();
				//System.out.println(sql);
				RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "serviceCharge","totalOrders","profit","monthyear","totalOrders","clientname"});
				jdbcTemplate.query(sql, handler);
				List<Map<String, String>> result = handler.getResult();
				return result;
      	  
			
		}
  public List<Map<String, String>> vendorsummaryreport(String startDate,String endDate){
	  StringBuffer objStringBuffer = new StringBuffer();
		String sql =null;
		objStringBuffer.append("SELECT sum(o.vendor_service_charge) as totalVendorAmount,date(o.booked_date) as bookedDate ,"+
                               "o.margin_value as marginValue,o.goods_charge as goodsCharge,concat_ws (' ',v.first_name,v.last_name) as vendorName,l.name as locationName,"+
                               "count(*) as totalOrders FROM order_info1 o,vendor1 v,location1 l where o.vendor_id=v.id and "+
                                "o.location_id=l.id ");
		if(StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
			objStringBuffer.append("  and o.booked_date BETWEEN DATE('"+startDate+"') and DATE('"+endDate+"')");
		}
		objStringBuffer.append(" GROUP BY vendor_id,date(bookedDate) order By date(bookedDate) desc");
		sql = objStringBuffer.toString();
		//System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "totalVendorAmount","bookedDate","marginValue","goodsCharge","totalOrders","vendorName","locationName"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
		
	}
  public List<Map<String, String>> vendorDetailreport(String vendorId,String startDate,String endDate){
	  StringBuffer objStringBuffer = new StringBuffer();
		String sql =null;
		objStringBuffer.append("SELECT sum(o.vendor_service_charge) as totalVendorAmount,date(o.booked_date) as bookedDate ,"+
                               "o.generated_id as orderId,o.customer_name as customerName,s.name as serviceName,o.vendor_id as vendorId,"+
                               "o.goods_charge as goodsCharge,sl.name as statusName,vs.statusname as vendorStatus"+
                               " FROM service1 s,status_list1 sl ,order_info1 o LEFT JOIN vendor_status vs ON (vs.id = o.vendor_status) "
                               + "where o.service_id=s.id and o.status_id=sl.id");
		if (StringUtils.isNotEmpty(vendorId) && !(vendorId.equalsIgnoreCase("null"))) {
			objStringBuffer.append("  and  o.vendor_id in ("
					+ vendorId + ")");
		}
		if(StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
			objStringBuffer.append("  and o.booked_date BETWEEN DATE('"+startDate+"') and DATE('"+endDate+"')");
		}
		objStringBuffer.append(" GROUP BY date(bookedDate) order By date(bookedDate) desc");
		sql = objStringBuffer.toString();
		//System.out.println(sql);
		RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[] { "orderId","totalVendorAmount","bookedDate","goodsCharge","customerName","statusName","vendorStatus","serviceName"});
		jdbcTemplate.query(sql, handler);
		List<Map<String, String>> result = handler.getResult();
		return result;
		
	}
  public List<Map<String,String>> getVendorOrderHistory(String mobile_number ) {
	  String query = "select o.generated_id  as OrderId,s.name as serviceName,o.contact_email,o.contact_number,o.address,"
						+"o.description,Date(o.appointment_date) as serviceDate,ts.label as time_slot,o.latitude,o.longitude,sl.name as status ,o.status_id as statusId"
						 +" from order_info1 o ,vendor1 v,service1 s,time_slots1 ts,status_list1 sl where sl.id=o.status_id and "
						+" o.appointment_slot_id = ts.id and o.vendor_id=v.id and s.active=1 and o.service_id=s.id and v.mobile_number='"+mobile_number+"' " ;

	  	 RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
	  		{"OrderId","serviceName", "contact_email", "contact_number","address", "description", "serviceDate","time_slot", "latitude","longitude","status","statusId" });
	       jdbcTemplate.query(query, handler);
	       return handler.getResult();
	  		}
  public List<Map<String,String>> getVendorOrderListMobile(String mobile_number ) {
	  String query = "select o.isPause as isPause, o.generated_id  as OrderId,s.name as serviceName,o.contact_email,o.contact_number,o.address,o.customer_name,"
						+"o.description,Date(o.appointment_date) as serviceDate,ts.label as time_slot,o.latitude,o.longitude,sl.name as status ,o.status_id as statusId,o.net_amount as netAmount"
						 +" from order_info1 o ,vendor1 v,service1 s,time_slots1 ts,status_list1 sl where sl.id=o.status_id and "
						+" o.appointment_slot_id = ts.id and o.vendor_id=v.id and o.service_id not in(56) and  s.active=1 and o.status_id not in(18,9,4,6,5) and o.service_id=s.id and v.mobile_number='"+mobile_number+"' " ;

	  	 RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
	  		{"isPause","OrderId","serviceName", "contact_email", "contact_number","address","customer_name", "description", "serviceDate","time_slot", "latitude","longitude","status","statusId","netAmount" });
	       jdbcTemplate.query(query, handler);
	       return handler.getResult();
	  		}
  public List<Map<String,String>> getVendorOrderDetailsMobile(String order_id ) {
	  String query = "select o.isPause as isPause, o.generated_id  as OrderId,s.name as serviceName,o.contact_email,o.contact_number,o.address,o.customer_name,"
						+"o.description,Date(o.appointment_date) as serviceDate,ts.label as time_slot,o.latitude,o.longitude,sl.name as status ,o.status_id as statusId"
						 +" from order_info1 o ,vendor1 v,service1 s,time_slots1 ts,status_list1 sl where sl.id=o.status_id and "
						+" o.appointment_slot_id = ts.id and o.service_id not in(56) and o.vendor_id=v.id and s.active=1  and o.service_id=s.id and o.generated_id='"+order_id+"'  " ;

	  	 RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
	  		{"isPause","OrderId","serviceName", "contact_email", "contact_number","address","customer_name", "description", "serviceDate","time_slot", "latitude","longitude","status","statusId" });
	       jdbcTemplate.query(query, handler);
	       return handler.getResult();
	  		}
  
  public List<Map<String,String>> getVendorCompletedOrders(String mobile_number ) {
	  String query = "select o.generated_id  as OrderId,s.name as serviceName,o.contact_email,o.contact_number,o.address,o.customer_name,"
						+"o.description,Date(o.appointment_date) as serviceDate,ts.label as time_slot,o.latitude,o.longitude,sl.name as status ,o.status_id as statusId,o.net_amount as netAmount"
						 +" from order_info1 o ,vendor1 v,service1 s,time_slots1 ts,status_list1 sl where sl.id=o.status_id and "
						+" o.appointment_slot_id = ts.id and o.vendor_id=v.id and  s.active=1 and o.status_id  in(18) and o.service_id=s.id and v.mobile_number='"+mobile_number+"' " ;

	  	 RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
	  		{"OrderId","serviceName", "contact_email", "contact_number","address","customer_name", "description", "serviceDate","time_slot", "latitude","longitude","status","statusId","netAmount" });
	       jdbcTemplate.query(query, handler);
	       return handler.getResult();
	  		}
  public List<Map<String,String>> getVendorCancelOrders(String mobile_number ) {
	  String query = "select o.generated_id  as OrderId,s.name as serviceName,o.contact_email,o.contact_number,o.address,o.customer_name,"
						+"o.description,Date(o.appointment_date) as serviceDate,ts.label as time_slot,o.latitude,o.longitude,sl.name as status ,o.status_id as statusId,o.net_amount as netAmount"
						 +" from order_info1 o ,vendor1 v,service1 s,time_slots1 ts,status_list1 sl where sl.id=o.status_id and "
						+" o.appointment_slot_id = ts.id and o.vendor_id=v.id and  s.active=1 and o.status_id  in(4) and o.service_id=s.id and v.mobile_number='"+mobile_number+"' " ;

	  	 RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
	  		{"OrderId","serviceName", "contact_email", "contact_number","address","customer_name", "description", "serviceDate","time_slot", "latitude","longitude","status","statusId","netAmount" });
	       jdbcTemplate.query(query, handler);
	       return handler.getResult();
	  		}
  public List<Reports> monthlyReport() {
		List<Reports> retlist = null;
		try {
			String sql = "select count(*) as count ,sum(net_amount) as sumofNetAmount,monthname(booked_date) as monthName,year(booked_date) as year " 
						+" from order_info1  where service_id not in(56) and user_id not in(60,20,46,57) group by monthname(booked_date),year(booked_date) order by year(booked_date),month(booked_date) ";
			retlist = jdbcTemplate.query(sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(Reports.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retlist;
	}
  public List<Reports> clientReport() {
		List<Reports> retlist = null;
		try {
			String sql = "select u.name as clientNmae, count(*) as count ,sum(net_amount) as sumofNetAmount,monthname(booked_date) as monthName,year(booked_date) as year"
						+" from order_info1 o,users u where service_id not in(56) and user_id not in(60,20,46,57) and   u.id =o.user_id group by monthname(booked_date),year(booked_date),o.user_id order by year(booked_date),month(booked_date)";
			retlist = jdbcTemplate.query(sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(Reports.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retlist;
	}
  public List<Reports> monthlyServiceReport() {
		List<Reports> retlist = null;
		try {
			String sql = "select s.name as serviceName, count(*) as count,sum(net_amount) as sumofNetAmount,monthname(booked_date) as monthName,year(booked_date) as year "
						+" from order_info1 o,service1 s where  s.id=o.service_id and service_id not in(56) and user_id not in(60,20,46,57)    group by monthname(booked_date),year(booked_date),o.service_id order by year(booked_date),month(booked_date) ";
			retlist = jdbcTemplate.query(sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(Reports.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retlist;
	}
  public List<Reports> monthlyVendorReport() {
		List<Reports> retlist = null;
		try {
			String sql ="select v.first_name as vendorName, count(*) as count,sum(net_amount) as sumofNetAmount,monthname(booked_date) as monthName,year(booked_date)as year from order_info1 o,vendor1 v where  v.id=o.vendor_id and o.service_id not in(56) and o.user_id not in(60,20,46,57)  group by monthname(booked_date),year(booked_date),o.vendor_id order by year(booked_date),month(booked_date)";
			retlist = jdbcTemplate.query(sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(Reports.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retlist;
	}
  
  public List<Map<String,String>> getAuroTransactionDetails() {
	  String query = "SELECT DATE(at.transaction_date) as transactionDate, at.id as id,at.`ac_number` as acountNumber,at.`vendor_id` as achountHolderName,at.`bank_name` as bankName,at.`branch_name` as branchName,at.`ifsc_code` as ifscCode,at.`amount` as amount,concat_ws(' ',v.first_name,v.last_name) as vendorName FROM `aurospaces_transactions` at ,vendor1 v where at.vendor_id=v.id";

	  	 RowValueCallbackHandler handler = new RowValueCallbackHandler(new String[]
	  		{"transactionDate","id","acountNumber", "achountHolderName", "bankName","branchName","ifscCode", "amount","vendorName" });
	       jdbcTemplate.query(query, handler);
	       return handler.getResult();
	  		}
  
  public List<OrderInfo1> getDoctorOrders1(String objOrderBean){
	  
		String sql = "SELECT client_order_id,ownername from order_info1 where user_id=2 and  client_order_id = '" + objOrderBean+"'";
		List<OrderInfo1>  retlist =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderInfo1>(OrderInfo1.class));
	//System.out.println(sql);
	if(retlist != null){
	return retlist;
	}else {
		return null;
	}
	
	}
}