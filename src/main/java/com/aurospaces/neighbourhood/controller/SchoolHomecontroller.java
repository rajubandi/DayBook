package com.aurospaces.neighbourhood.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aurospaces.neighbourhood.bean.UsersBean;

import com.aurospaces.neighbourhood.db.dao.StudentFeeDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;

import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SendSMS;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class SchoolHomecontroller {
	
	Logger log = Logger.getLogger(SchoolHomecontroller.class);
	@Autowired ServletContext objContext;
	@Autowired StudentFeeDao objStudentFeeDao;
	@Autowired usersDao1 usesDao1;
	@Autowired	DataSourceTransactionManager transactionManager;
	
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
			/*academicYearBean =addAcademicYearDao.getAcademicYearSelectList();
			
			if (academicYearBean != null) {
			objectMapper = new ObjectMapper(); 
			academicYearJson =objectMapper.writeValueAsString(academicYearBean);
			session.setAttribute("academicYear", academicYearJson);
			//request.setAttribute("academicYear", academicYearJson);
			System.out.println(academicYearJson);
			}else {
				
				objectMapper = new ObjectMapper(); 
				academicYearJson =objectMapper.writeValueAsString(academicYearBean);
				//session.setAttribute("academicYear", academicYearBean);
				session.setAttribute("academicYear", academicYearJson);
			}*/
			
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
//				    String baseUrl = MiscUtils.getBaseUrl(request);
//			 		System.out.println(baseUrl);
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
		List<Map<String, String>> listOrderBeans = null;
		List<Map<String, Object>> feesAndExpenses = null;
		List<Map<String, Object>> expensessummary = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		/*Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
		session.setAttribute("activeAcademicYearId", academicYearId);*/
		try{
			/*feesAndExpenses = studentDao.getFeesAndExpenses(academicYearId)	;
			if(feesAndExpenses != null){
				objectMapper = new ObjectMapper();
				request.setAttribute("feesAndExpenses", objectMapper.writeValueAsString(feesAndExpenses));
			}else{
				request.setAttribute("feesAndExpenses", "''");
			}
			
			expensessummary = 	studentDao.getExpensessummary(academicYearId);
			if(expensessummary != null){
				objectMapper = new ObjectMapper();
				request.setAttribute("expensessummary", objectMapper.writeValueAsString(expensessummary));
			}else{
				request.setAttribute("expensessummary", "''");
			}*/
			
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
	
	@RequestMapping(value = "/deleteStudentFee")
	public @ResponseBody List<Map<String, String>> deleteStudentFee( ModelMap model,HttpServletRequest request)  {
		System.out.println("Home controller...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String message =null;
		String id = null;
		try{
			id = request.getParameter("id");
			objStudentFeeDao.delete(Integer.parseInt(id));
			// Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId(); icom
				listOrderBeans =  objStudentFeeDao.getallStudentsFee(null,null,null,null,null,String.valueOf(15));
				if(listOrderBeans != null && listOrderBeans.size() > 0) {
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOrderBeans);
					  request.setAttribute("allOrders1", sJson);
					 // System.out.println(sJson); 
				}else{
					 objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOrderBeans);
					  request.setAttribute("allOrders1", "''");
				}
		}catch(Exception e){
				e.printStackTrace();
					System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class deleteStudent method");
		}

		return listOrderBeans;
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
//		System.out.println(e);
		logger.error(e);
		logger.fatal("error in userLogin method in school Homecontroller class HomePage1 method  ");
		session.setAttribute("message", "fail login");
	}
	return "redirect:adminChangePasswordHome";
}

}