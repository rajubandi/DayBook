package com.aurospaces.neighbourhood.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * 
 */

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.dao.AddCollectionDao;
import com.aurospaces.neighbourhood.db.dao.StudentDao;
import com.aurospaces.neighbourhood.db.dao.StudentFeeDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SendSMS;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class SchoolHomecontroller implements Job{
	
	Logger log = Logger.getLogger(SchoolHomecontroller.class);
	@Autowired ServletContext objContext;
	@Autowired StudentFeeDao objStudentFeeDao;
	@Autowired usersDao1 usesDao1;
	@Autowired	DataSourceTransactionManager transactionManager;
	@Autowired StudentDao studentDao;
	@Autowired AddCollectionDao addAccountHeadDao;
	@Autowired SendSMS sendSMS;
	static Map< String,String> hm8 =  new HashMap< String,String>();
	static String phnumber;
	
	private Logger logger = Logger.getLogger(SchoolHomecontroller.class);
	
	@RequestMapping(value = "/HomePage")
	public String HomePage(@ModelAttribute("packCmd") UsersBean objUsersBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HomePage page...");
		UsersBean objuserBean = null;
         
		try{
			 objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
				if(objuserBean != null){
					if(Integer.parseInt(objuserBean.getRolId()) == 1){						
						
						String mobileNumber = objuserBean.getMobile();
						/*String messageBody = "<table><tr>Dear Parent/Gaurdian,</tr><br><tr ><td style='padding-left:112px; padding-top:5px;'>Thanks for Registering with us.</td></tr><br></table><table ><tr><td style='padding-left:10px;'><b>Your Login Details:</b></td></tr><tr><td style='padding-left:30px;'>Username: _username_</td></tr><tr><td style='padding-left:30px;'>Password: _password_</td></tr></table><br><div style='width: 712.5pt;font-size: 14px; top:150px;'><ul>Thanks,<br/>Vivekananda vidhyalayam.</ul></div>";
						messageBody = messageBody.replace("_username_", objStudentBean.getFatherName());
						messageBody = messageBody.replace("_password_", randomNum);*/
						String smsMessage = "Hi  "+ objuserBean.getName() +",\n You are Successfully login to Administrator Dashboard,\n"+" Vivekananda vidhyalayam. ";
						if(StringUtils.isNotBlank(mobileNumber)){
							SendSMS.sendSMS(smsMessage, mobileNumber, objContext);
						}
						return "redirect:dashBoard.htm";
						}
					
						if(Integer.parseInt(objuserBean.getRolId()) == 3){
							return "redirect:parentDashboard.htm";
				
						}
						
				}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class HomePage method  ");
			return "loginHome1";
			
		}
		return "loginHome1";
	}
	
	@RequestMapping(value = "/LoginHome1")
	public String HomePage1(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("LoginHome1 page...");
		UsersBean userBean = null;
		UsersBean objuserBean = null;
		List<Map<String, Object>> academicYearBean = null;
		String name = null;
		String password = null;
		String rolId = null;
		String academicYearJson = null;
		ObjectMapper objectMapper=null;
		try{
			
			userBean= new UsersBean();
			name = request.getParameter("name");
			password = request.getParameter("password");
			rolId = request.getParameter("rolId");
			userBean.setRolId(rolId);
			userBean.setPassword(password);
			userBean.setName(name);			
			
			objuserBean = usesDao1.loginDetails(userBean);
			
			if (objuserBean != null) {
				session.setAttribute("cacheUserBean", objuserBean);
				session.setAttribute("rolId", objuserBean.getRolId());
				if(StringUtils.isNotBlank(rolId)){
					if(Integer.parseInt(objuserBean.getRolId()) == 1){
						
						String mobileNumber = objuserBean.getMobile();
						/*String messageBody = "<table><tr>Dear Parent/Gaurdian,</tr><br><tr ><td style='padding-left:112px; padding-top:5px;'>Thanks for Registering with us.</td></tr><br></table><table ><tr><td style='padding-left:10px;'><b>Your Login Details:</b></td></tr><tr><td style='padding-left:30px;'>Username: _username_</td></tr><tr><td style='padding-left:30px;'>Password: _password_</td></tr></table><br><div style='width: 712.5pt;font-size: 14px; top:150px;'><ul>Thanks,<br/>Vivekananda vidhyalayam.</ul></div>";
						messageBody = messageBody.replace("_username_", objStudentBean.getFatherName());
						messageBody = messageBody.replace("_password_", randomNum);*/
						String smsMessage = "Hi "+ objuserBean.getName() +",\n You are Successfully login to Administrator Dashboard,\n"+" Vivekananda vidhyalayam. ";
						System.out.println(smsMessage);
						if(StringUtils.isNotBlank(mobileNumber)){
							SendSMS.sendSMS(smsMessage, mobileNumber, objContext);
						}
					return "redirect:dashBoard.htm";
					}
					if(Integer.parseInt(objuserBean.getRolId()) == 3){
						return "redirect:parentDashboard.htm";
						}else {
							
							return "redirect:userStudentFeeHome.htm";
						}
				}
			}
			else{
				if(name != null)
				session.setAttribute("message", "Invalid Credentials");
			}
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class HomePage1 method  ");
			session.setAttribute("message", "fail login");
		}
		return "redirect:HomePage";
	}
	
	@RequestMapping(value = "/logoutHome1")
	public String logoutHome(ModelMap model,HttpServletRequest request,HttpSession objSession,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("logout page...");
		try{
			
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.removeAttribute("cacheUserBean");
				session.invalidate();
				response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
				response.setHeader("Pragma","no-cache"); //HTTP 1.0
				response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
				    //String baseUrl = MiscUtils.getBaseUrl(request);
			 		//System.out.println(baseUrl);
//			 		response.sendRedirect(baseUrl+"/LoginHome1.htm" );
			}
			return "redirect:HomePage.htm";
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class logoutHome method  ");
		}
		return "loginHome1";
	}	
	
	@RequestMapping(value = "/dashBoard")
	public String dashBoard(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("alumini page...");
		List<Map<String, String>> listOrderBeansClientid = null;
		List<Map<String, String>> listOrderBeansClientName = null;
		List<Map<String, Object>> feesAndExpenses = null;
		List<Map<String, Object>> expensessummary = null;
		List<Map<String, String>> listOrderBeansFullamt = null;
		List<Map<String, String>> listOrderBeansPaidamt = null;	
		List<Map<String, String>> listOrderBeansPhoneNumber = null;
		List<Map<String, String>> listOrderBeansadminphone = null;
		
		ObjectMapper objectMapper = null;
		String sJson = null;
		String year="";
		String mon="";
		String day="";		
		ArrayList al = new ArrayList();
		//ArrayList al2 = new ArrayList();
		Map< Integer,String> hm =  new HashMap< Integer,String>();
		Map< Integer,Integer> hm2 =  new HashMap< Integer,Integer>();
		Map< Integer,Integer> hm3 =  new HashMap< Integer,Integer>();
		Map< Integer,Integer> hm4 =  new HashMap< Integer,Integer>();
		Map< Integer,Object> hm5 =  new HashMap< Integer,Object>();
		Map< Integer,String> hm6 =  new HashMap< Integer,String>();
		Map< String,String> hm7 =  new HashMap< String,String>();
		
		
		List<Map<String, String>> listOrderBeansduedate = null;		
		listOrderBeansduedate = addAccountHeadDao.getDueDate();		
		System.out.println("duedate from collections: " +listOrderBeansduedate);		
		
		String ggg ="";
		int id = 0;
		int dueamt=0 ;
		
		
		for (Iterator iterator = listOrderBeansduedate.iterator(); iterator.hasNext();) {
			Map<String, String> map = (Map<String, String>) iterator.next();				
			ggg = map.get("duedate");					
			
			if (ggg!="") {
				
				String[] splited = ggg.split(" ");
				System.out.println(splited[0]);
				
				String[] splited2 = splited[0].split("-");				
				year = splited2[0];
				mon = splited2[1];
				day = splited2[2];				
				
			} else {

			}
		}		
		
		int monint = Integer.parseInt(mon);
		int dayint = Integer.parseInt(day);
		System.out.println("year: " +year +" month: " +mon +" day: " +day);
		System.out.println("Month INT: "+monint +" day INT: " +dayint );

		listOrderBeansClientid = addAccountHeadDao.getClientIdBasedOnDuedate();		
		System.out.println("clientId from collections: " +listOrderBeansClientid);		
		
		String clntId ="";
		String clntName ="";		
		
		for (Iterator iterator = listOrderBeansClientid.iterator(); iterator.hasNext();) {
			Map<String, String> map = (Map<String, String>) iterator.next();				
			clntId = map.get("clntid");	
			System.out.println("ClientId: " +clntId);			
			
			al.add(clntId);
		}
		
		System.out.println("clientId ArrayList : " +al);
		
		for(Object obj : al) {
			
			String ss = (String)obj;			
			id = Integer.parseInt(ss);
			
		//Integer a = (Integer)obj;
			if (id!=0) {
				listOrderBeansClientName = addAccountHeadDao.getClientName(id);
			
				
		System.out.println("clientName from collections: " +listOrderBeansClientName);			
		
		for (Iterator iterator = listOrderBeansClientName.iterator(); iterator.hasNext();) {
			Map<String, String> map = (Map<String, String>) iterator.next();				
			clntName = map.get("client");	
			//System.out.println("ClientName: " +clntName);
			//String ss = "Id: " +obj +" ClientName: " +clntName;
			hm.put(id, clntName);
			//al2.add(ss);			
		}	
			}
			
		}
		
		System.out.println("clientName Details Map : " +hm);
		
		for(Object obj : al) {
			
			String ss = (String)obj;			
			id = Integer.parseInt(ss);
		if (id!=0) {
		listOrderBeansFullamt = addAccountHeadDao.getFullAmount(id);
		
		System.out.println("Full amount from clients after getting ID: " +listOrderBeansFullamt);
		
		int fullamt=0 ;
		
		for (Iterator iterator = listOrderBeansFullamt.iterator(); iterator.hasNext();) {
			Map<String, String> map = (Map<String, String>) iterator.next();
			//System.out.println("In for loop getting FullAmount: " +map.get("fullamount"));	
			String famt = map.get("fullamount");					 
			fullamt = Integer.parseInt(famt);
			hm2.put(id, fullamt);
			//System.out.println("In for loop2 fullamt value: " +fullamt);
		}
		}
}
		System.out.println("client FullAmount Details Map : " +hm2);
		
for(Object obj : al) {
			
			String ss = (String)obj;			
			id = Integer.parseInt(ss);
		if (id!=0) {
			listOrderBeansPaidamt = addAccountHeadDao.getPaidAmount(id);
			
			System.out.println("Paid amount from clients: " +listOrderBeansPaidamt);
			
			int paidamt=0 ;
			
			
			for (Iterator iterator = listOrderBeansPaidamt.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();
				//System.out.println("In for loop: " +map.get("paidamount"));	
				String pamt = map.get("paidamount");					 
				paidamt = Integer.parseInt(pamt);
				hm3.put(id, paidamt);
			}
			
			listOrderBeansPhoneNumber = addAccountHeadDao.getPhoneNumber(id);
			
			System.out.println("PhoneNumber from clients: " +listOrderBeansPhoneNumber);
			
			//int phNo=0 ;
			
			
			for (Iterator iterator = listOrderBeansPhoneNumber.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();
				//System.out.println("In for loop: " +map.get("paidamount"));	
				String pno = map.get("phoneNumber");					 
				//phNo = Integer.parseInt(pno);
				hm6.put(id, pno);
			}
			
			
			
			// Returns Set view      
			Set< Map.Entry< Integer,String> > st = hm.entrySet();
		    Set< Map.Entry< Integer,Integer> > st2 = hm2.entrySet();    
		    Set< Map.Entry< Integer,Integer> > st3 = hm3.entrySet();
		    Set< Map.Entry< Integer,Integer> > st4 = hm4.entrySet();

		    for (Map.Entry< Integer,Integer> me:st2) 
		    { 		    	
		    	for (Map.Entry< Integer,Integer> me2:st3) 
		        { 	      		            
		            if (me.getKey() == me2.getKey()) {
		            	dueamt = me.getValue() - me2.getValue();
		            	hm4.put(id, dueamt);						
					}
		        }     	
		        
		    } 	
		    
		    for (Map.Entry< Integer,String> me:st) 
		    { 		    	
		    	for (Map.Entry< Integer,Integer> me2:st2) 
		        { 	
		    		for (Map.Entry< Integer,Integer> me3:st3) 		        
			    { 		    	
			    	for (Map.Entry< Integer,Integer> me4:st4) 
			        { 	
			    		if ((me.getKey() == me2.getKey()) == (me3.getKey() == me4.getKey())) {
			            	
			    			String details =  "Name: " +me.getValue() + " FullAmount: " + me2.getValue() + " PaidAmount: " +me3.getValue() + " DueAmount: " +me4.getValue();
			            	hm5.put(id, details);						
						}
		    
			        }
			    }
		        }
		    }
		    
		    Set< Map.Entry< Integer,Object> > st5 = hm5.entrySet();
		    Set< Map.Entry< Integer,String> > st6 = hm6.entrySet();
		    
		    for (Map.Entry< Integer,Object> me5:st5) 
		    { 		    	
		    	for (Map.Entry< Integer,String> me6:st6) 
		        { 	      		            
		            if (me5.getKey() == me6.getKey()) {	            	
		            	
		            	hm7.put(me6.getValue(), (String)me5.getValue());
		            	/*sendSMS.sendSMS(" Message from Schedule task of DayBook project","9676944419");
		            	sendSMS.sendSMS((String)me5.getValue(),me6.getValue());*/
					}
		        }     	
		        
		    } 	
		    
		    
		    
			
		}
}
	System.out.println("client PaidAmount Details Map : " +hm3);
	System.out.println("client DueAmount Details Map : " +hm4);
	System.out.println("client Phone Details Map : " +hm6);
	System.out.println("client Full Details Map : " +hm5);
	System.out.println("client Phone & Full Details Map : " +hm7);
	hm8=hm7;
	System.out.println("hm8 in dashboard : " +hm8);
	
	listOrderBeansadminphone = addAccountHeadDao.getPhoneNumberOfAdmin();
	
	System.out.println("Phone number of ADMIN: " +listOrderBeansadminphone);	
	
	for (Iterator iterator = listOrderBeansadminphone.iterator(); iterator.hasNext();) {
		Map<String, String> map = (Map<String, String>) iterator.next();
		String mobile = map.get("mobile");	
		phnumber = mobile;		
	}
		System.out.println("Phone number in dashboard: " +phnumber); 
// used URL: http://java.candidjava.com/tutorial/Quartz-Scheduer-Cron-Trigger-example-using-java.htm
try {
	
	String cronexmp = "0/20 * * * * ?";
	//cronexmp = "0/5" + " * * * * ?";
	//cronexmp = "0 50 16 " +dayint +" " +monint +" 5 " +year;
	
	cronexmp = "0 53 17 " +dayint +" "  +monint +" ? " +year;	
	
	//0 39 16 day mon 5 year;
 
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
 
			JobDetail job = JobBuilder.newJob(SchoolHomecontroller.class)
					.withIdentity("dummyJobName", "group1").build();
 
			Date startTime = DateBuilder.nextGivenSecondDate(null, 10);
 
			// run every 20 seconds infinite loop
			CronTrigger crontrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("TwentySec", "group1")
					.startAt(startTime)
					// startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule(cronexmp))
					.build();
 
			scheduler.start();
			scheduler.scheduleJob(job, crontrigger);
 
			// scheduler.shutdown();
 
		} catch (SchedulerException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}


		
		/*Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
		session.setAttribute("activeAcademicYearId", academicYearId);*/
		try{
			feesAndExpenses = studentDao.getFeesAndExpenses()	;
			if(feesAndExpenses != null){
				objectMapper = new ObjectMapper();
				request.setAttribute("feesAndExpenses", objectMapper.writeValueAsString(feesAndExpenses));
				//System.out.println("feesAndExpenses in if: " +objectMapper.writeValueAsString(feesAndExpenses));
			}else{
				request.setAttribute("feesAndExpenses", "''");
				//System.out.println("feesAndExpenses in else: " +objectMapper.writeValueAsString(feesAndExpenses));
			}
			
			expensessummary = 	studentDao.getExpensessummary();
			if(expensessummary != null){
				objectMapper = new ObjectMapper();
				request.setAttribute("expensessummary", objectMapper.writeValueAsString(expensessummary));
				//System.out.println("expensessummary in if: " +objectMapper.writeValueAsString(expensessummary));
			}else{
				request.setAttribute("expensessummary", "''");
				//System.out.println("expensessummary in else: " +objectMapper.writeValueAsString(expensessummary));
			}
			
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class dashBoard method");
		}
		return "dashBoard";
	}
	
	@RequestMapping(value = "/parentDashboard")
	public String parentDashboard(ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("parentDashboard page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try{
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class dashBoard method");
		}
		return "parentDashBoard";
	}		

@RequestMapping(value = "/changePassword")
public @ResponseBody String changePassword( HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException, AddressException, MessagingException {
	UsersBean userBean = null;
	userBean= new UsersBean();
	
	
	String json = "";
	String rolId = request.getParameter("newPswRolId");
	String mobileOrEmail = request.getParameter("newPswEmailOrPhone");
	
	userBean = usesDao1.getByMobileAndRole(mobileOrEmail, rolId);
	
	if(userBean != null) {
	
	NeighbourhoodUtil neighbour = new NeighbourhoodUtil();
	String randomNum = neighbour.randNum();
	userBean.setPassword(randomNum);
	usesDao1.save(userBean);
	
	String mobileNumber = userBean.getMobile();
	String messageBody = "<table><tr>Hi _username_ ,</tr><br><tr ><td style='padding-left:112px; padding-top:5px;'>Successfully changed the password.</td></tr><br></table><table ><tr><td style='padding-left:30px;'>Username: _username_</td></tr><tr><td style='padding-left:30px;'>Password: _password_</td></tr></table><br><div style='width: 712.5pt;font-size: 14px; top:150px;'><ul>Thanks,<br/>Vivekananda vidhyalayam.</ul></div>";
	messageBody = messageBody.replace("_username_", userBean.getName());
	messageBody = messageBody.replace("_password_", randomNum);
	String smsMessage = "Hi "+ userBean.getName() +" Successfully changed the password.\nYour login details:\nUsername: "+userBean.getName()+"\nPassword: "+randomNum;
	if(StringUtils.isNotBlank(mobileNumber)){
		SendSMS.sendSMS(smsMessage, mobileNumber, objContext);
	}
	 String toAddress= null;
	if(StringUtils.isNotBlank(toAddress)){	
	
	}
	}else {
		String failedmsg = "Provieded details are not found " ;
		ObjectMapper objmapper1 = new ObjectMapper();
		json = objmapper1.writeValueAsString(failedmsg);
		// System.out.println("listServiceUnit1.size()==="+listServiceUnit1.size());
		request.setAttribute("failedmsg", json);
		 
		return json;				
	}
	
	String successMsg ="Successfully changed the password and it will be sent to Provieded Mobile Number, Thanking You";
	ObjectMapper objmapper = new ObjectMapper();
	json = objmapper.writeValueAsString(successMsg);
	// System.out.println("listServiceUnit1.size()==="+listServiceUnit1.size());
	request.setAttribute("successMsg", json);

	return  json;
	
}

@RequestMapping(value = "/adminChangePasswordHome")
public String adminChangePasswordHome(@ModelAttribute("packCmd") UsersBean objUsersBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("adminchangePasswordHome...");

     
	try{
		
	}catch(Exception e){
		e.printStackTrace();
//		System.out.println(e);
		logger.error(e);
		logger.fatal("error in userLogin method in school Homecontroller class changePasswordHome method  ");
		return "loginHome1";
		
	}
	return "adminChangePasswordHome";
}

@RequestMapping(value = "/adminChangePassword")
public String adminChangePassword(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("LoginHome1 page...");
	UsersBean userBean = null;
	UsersBean objuserBean = null;
	String oldPassword = null;
	String password = null;
	String userPassword = null;
	String retypePassword = null;
	try{
		
		userBean= new UsersBean();
		oldPassword = request.getParameter("oldPassword");
		password = request.getParameter("password");
		retypePassword = request.getParameter("retypePassword");
		if(StringUtils.isNotBlank(retypePassword) && StringUtils.isNotBlank(password)){
			if(password.equals(retypePassword)){
				
			}else{
				session.setAttribute("message", "Password and Confirm Password is mismatch");
				return "redirect:adminChangePasswordHome";
			}
		
			userBean= (UsersBean)session.getAttribute("cacheUserBean");
			userPassword = userBean.getPassword();
			if(!userPassword.equals(oldPassword)){
				session.setAttribute("message", "Invalid Current Password");
				return "redirect:adminChangePasswordHome";
			}else{
				userBean.setPassword(password);
				usesDao1.save(userBean);
				session.setAttribute("message", "Successfully Password Changed");
			}
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
//		System.out.println(e);
		logger.error(e);
		logger.fatal("error in userLogin method in school parent controll class parentChangePassword method  ");
		session.setAttribute("message", "fail login");
	}
	return "redirect:adminChangePasswordHome";
}

@RequestMapping(value = "/adminoldPasswordCheck")
public @ResponseBody String adminoldPasswordCheck(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("LoginHome1 page...");
	UsersBean userBean = null;
	UsersBean objuserBean = null;
	String oldPassword = null;
	String password = null;
	
	try{
		oldPassword =request.getParameter("oldPassword");
		userBean= (UsersBean)session.getAttribute("cacheUserBean");
		password = userBean.getPassword();
		if(!password.equals(oldPassword)){
			
		}
		
	}catch(Exception e){
		e.printStackTrace();

		logger.error(e);
		logger.fatal("error in userLogin method in school Homecontroller class HomePage1 method  ");
		session.setAttribute("message", "fail login");
	}
	return "redirect:adminChangePasswordHome";
}

@Override
public void execute(JobExecutionContext context) throws JobExecutionException {
	// TODO Auto-generated method stub
	System.out.println("Trigger Starts in SchoolHomeController.. "+new Date());
	System.out.println("hm8 value: " +hm8);
	System.out.println("Phone number in execute method: " +phnumber);
		
	SendSMS sms = new SendSMS();	
		 
	 if (hm8!=null) {		 
		 
	        Set<Map.Entry<String,String>> set1 = hm8.entrySet(); 	        
	        
	        for (Map.Entry<String,String> me : set1) 
	        {
	            System.out.print(me.getKey() + ": ");
	            System.out.println(me.getValue());
	            
	            sms.sendSMS((String)me.getValue(),phnumber);
	            sms.sendSMS((String)me.getValue(),me.getKey());
				
	        }		 		
	 }	
}
}