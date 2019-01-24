/*package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.db.dao.AddAcademicYearDao;
import com.aurospaces.neighbourhood.db.dao.AttendanceDao;
import com.aurospaces.neighbourhood.db.dao.EventDao;
import com.aurospaces.neighbourhood.db.dao.StudentDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.aurospaces.neighbourhood.util.MailSender;
// import com.aurospaces.neighbourhood.util.MailSender; i com
import com.aurospaces.neighbourhood.util.MiscUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ParentController {
	private Logger logger = Logger.getLogger(ParentController.class);
	@Autowired 
	usersDao1 usesDao1;
	@Autowired 
	AttendanceDao attendanceDao;
	@Autowired
	EventDao  eventDao;
	@Autowired
	StudentDao studentDao;
	@Autowired ServletContext objContext;
	@Autowired HttpSession session1;
	@Autowired AddAcademicYearDao addAcademicYearDao;
	@RequestMapping(value = "/viewAttendanceParentHome")
	public String viewAttendanceHome(@ModelAttribute("packCmd") StudentBean objStudentBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("viewAttendanceParentHome controller...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		UsersBean  objuserBean1 = null;
		UsersBean  objuserBean = null;

		try{
			  objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
			if(objuserBean != null){
				int rolId1 = Integer.parseInt(objuserBean.getRolId());
				if(rolId1 == 3){
				  objuserBean1 = usesDao1.loginDetails(objuserBean);
				  objStudentBean.setMobile(objuserBean1.getMobile());
				}
			}
			 
			
			listOrderBeans = attendanceDao.getAttendance(objStudentBean);
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
			}else{
				 request.setAttribute("allOrders1", "''");
			}
			//studentDao.save(objClassBean);
		}catch(Exception e){
e.printStackTrace();
//			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class viewAttendanceHome method");
		}

		return "parentAttendance";  
	}
	@RequestMapping(value = "/viewEventsParent")
	public String viewEvents(@ModelAttribute("packCmd") StudentBean objStudetnBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("viewAttendanceHome controller...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		UsersBean  objuserBean1 = null;
		UsersBean  objuserBean = null;
		try{
			
			 objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
				if(objuserBean != null){
					int rolId1 = Integer.parseInt(objuserBean.getRolId());
					if(rolId1 == 3){
					  objuserBean1 = usesDao1.loginDetails(objuserBean);
					  objStudetnBean.setMobile(objuserBean1.getMobile());
					}
				}
			
			listOrderBeans = eventDao.getEvents(objStudetnBean);
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
			}else{
				 request.setAttribute("allOrders1", "''");
			}
			//studentDao.save(objClassBean);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class viewEvents method");
		}

		return "parentViewEvent";  
	}
	@RequestMapping(value = "/parentViewStudent")
	public  String viewStudent(@ModelAttribute("packCmd") StudentBean objStudetnBean, ModelMap model,HttpServletRequest request,HttpSession session)  {
		System.out.println("Home controller...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "null";
		String message =null;
		String studentId = null;
		String baseUrl = MiscUtils.getBaseUrl(request);
		UsersBean  objuserBean1 = null;
		UsersBean  objuserBean = null;
		try{
			Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
			 objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
				if(objuserBean != null){
					int rolId1 = Integer.parseInt(objuserBean.getRolId());
					if(rolId1 == 3){
					  objuserBean1 = usesDao1.loginDetails(objuserBean);
					  objStudetnBean.setMobile(objuserBean1.getMobile());
					}
				}
			
				listOrderBeans = studentDao.getallStudentDetails(null,null,null,null,null,null,null,null,objStudetnBean.getMobile(),academicYearId.toString(),null);
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				 objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				  request.setAttribute("baseUrl", baseUrl);
				 // System.out.println(sJson); 
			}else{
				 objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", "''");
				  request.setAttribute("baseUrl", baseUrl);
			}
		}catch(Exception e){
e.printStackTrace();
//			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class viewStudent method");
		}

		return "parentViewStudent";
	}
	@RequestMapping(value = "/changePasswordHome")
	public String HomePage(@ModelAttribute("packCmd") UsersBean objUsersBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("changePasswordHome...");
	
         
		try{
			
		}catch(Exception e){
			e.printStackTrace();
//			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class changePasswordHome method  ");
			return "loginHome1";
			
		}
		return "changePasswordParent";
	}
	@RequestMapping(value = "/parentChangePassword")
	public String HomePage1(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
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
					return "redirect:changePasswordHome";
				}
			
				userBean= (UsersBean)session.getAttribute("cacheUserBean");
				userPassword = userBean.getPassword();
				if(!userPassword.equals(oldPassword)){
					session.setAttribute("message", "Invalid Current Password");
					return "redirect:changePasswordHome";
				}else{
					userBean.setPassword(password);
					usesDao1.save(userBean);
					session.setAttribute("message", "Successfully Password Changed");
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
//			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school parent controll class parentChangePassword method  ");
			session.setAttribute("message", "fail login");
		}
		return "redirect:changePasswordHome";
	}
	@RequestMapping(value = "/oldPasswordCheck")
	public @ResponseBody String oldPasswordCheck(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
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
//			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class HomePage1 method  ");
			session.setAttribute("message", "fail login");
		}
		return "redirect:changePasswordHome";
	}
	
	
	@RequestMapping(value = "/parentFeedback")
	public String parentFeedback( @ModelAttribute("packCmd") StudentBean objStudetnBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("parentFeedback page...");
		UsersBean userBean = null;
		UsersBean objuserBean = null;
		String oldPassword = null;
		String password = null;
		String message = null;
		String toAddress = null;
		try{
			
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
//			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school parent controll class parentFeedback method  ");
			session.setAttribute("message", "fail login");
		}
		return "parentFeedBack";
	}
	
	@RequestMapping(value = "/parentSendFeedback")
	public String parentSendFeedback(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("parentSendFeedback page...");
		UsersBean userBean = null;
		UsersBean objuserBean = null;
		String name = null;
		String password = null;
		String message = null;
		String toAddress = null;
		StudentBean objStudentBean =null;
		try{
			name = request.getParameter("name");
			Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
			if(StringUtils.isNotBlank(name)){
				objStudentBean=		studentDao.getById(Integer.parseInt(name),academicYearId);
			}
			
			message =  request.getParameter("message");
		
			
			
//			toAddress=  objStudentBean.getEmail();
//			if(StringUtils.isNotBlank(toAddress)){
			MailSender.sendEmailWithAttachment("noreply2stjohns@gmail.com", "Regarding, FeedBack from "+objStudentBean.getFatherName() ,message,null,objContext); // i com
			session.setAttribute("message", "Successfully Mail has been Sended");
//			}
			
		}catch(Exception e){
			e.printStackTrace();
//			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school parent controll class parentChangePassword method  ");
			session.setAttribute("message", "fail login");
		}
		return "redirect:parentFeedback";
	}
	@ModelAttribute("students")
	public Map<String, String> populateStudent() {
		Map<String, String> statesMap = new LinkedHashMap<String, String>();
	UsersBean objuserBean =null;
	UsersBean objuserBean1 =null;
		try {
			StringBuffer buffer = new StringBuffer();
			 objuserBean =(UsersBean) session1.getAttribute("cacheUserBean");
				if(objuserBean != null){
					int rolId1 = Integer.parseInt(objuserBean.getRolId());
					if(rolId1 == 3){
					  objuserBean1 = usesDao1.loginDetails(objuserBean);
					}
				}
			buffer.append(" select id,name from student " );
			if( objuserBean != null ){
				buffer.append(" where mobile = "+objuserBean1.getMobile() );
			}
			String sSql = buffer.toString();
			List<BoardBean> list= usesDao1.populate(sSql);
			for(BoardBean bean: list){
				statesMap.put(bean.getId(), bean.getName());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return statesMap;
	}
}
*/