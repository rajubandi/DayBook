package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.ClassBean;
import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.db.dao.AddAcademicYearDao;
import com.aurospaces.neighbourhood.db.dao.AddClassSubjectDao;
import com.aurospaces.neighbourhood.db.dao.BirthDayNotificationDao;
import com.aurospaces.neighbourhood.db.dao.BusRouteDao;
import com.aurospaces.neighbourhood.db.dao.ClassCreation1Dao;
import com.aurospaces.neighbourhood.db.dao.ClassCreationDao;
import com.aurospaces.neighbourhood.db.dao.EventDao;
import com.aurospaces.neighbourhood.db.dao.StudentDao;
import com.aurospaces.neighbourhood.db.dao.StudentFeeDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.aurospaces.neighbourhood.util.MailSender;
import com.aurospaces.neighbourhood.util.MiscUtils;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SendSMS;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
@Controller
public class StudentPromotionController {

	
	Logger log = Logger.getLogger(StudentPromotionController.class);
	@Autowired	ClassCreationDao objClassCreation;
	@Autowired StudentDao studentDao;
	@Autowired StudentFeeDao objStudentFeeDao;
	@Autowired usersDao1 usesDao1;
	@Autowired DataSourceTransactionManager transactionManager;
	@Autowired EventDao eventDao;
	@Autowired BirthDayNotificationDao birthDayNotificationDao;
	@Autowired ClassCreation1Dao objAddedClass;
	@Autowired AddClassSubjectDao objAddClassSubjectDao;
	@Autowired AddAcademicYearDao addAcademicYearDao;
	@Autowired BusRouteDao busRouteDao;
	@Autowired ServletContext objContext;
	private Logger logger = Logger.getLogger(StudentPromotionController.class);
	@RequestMapping(value = "/studentPromotion")
	public  String studentPromotion(@ModelAttribute("studentPromotion") StudentBean objClassBean, ModelMap model,HttpServletRequest request,HttpSession session)  {
		//System.out.println("StudentPromotionController");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "null";
		String message =null;
		String studentId = null;
		String baseUrl = MiscUtils.getBaseUrl(request);
		try{
			Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
			session.setAttribute("activeAcademicYearId", academicYearId);
				listOrderBeans = studentDao.getallStudentDetails(null,null,null,null,null,null,null,null,null,academicYearId.toString(),null);
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
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in Student Promotion Controller class  method");
		}

		return "studentPromotion";
	}
	
	@RequestMapping(value = "/studentPromotion",method = RequestMethod.POST )
	public String addStudent(@ModelAttribute("studentPromotion") StudentBean objStudentBean, ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException, ParseException, AddressException, MessagingException {
		System.out.println("Home controller...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String mobileNumber =null; 
		String  toAddress= null;
		StudentBean sbean1 = null;
		ClassBean classbean =new ClassBean();
		try{
		String baseUrl = MiscUtils.getBaseUrl(request);
		System.out.println(objStudentBean.getName());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		
		classbean=	objClassCreation.getClassFee(objStudentBean);
					objStudentBean.setAdmissionFee(0);
					objStudentBean.setTutionFee(classbean.getTutionFee());
					objStudentBean.setTransportationFee(classbean.getTransportationFee());
					objStudentBean.setHostelFee(classbean.getHostelFee());
					objStudentBean.setStationaryFee(classbean.getStationaryFee());
	
					double fee =objStudentBean.getAdmissionFee()+objStudentBean.getTutionFee()+objStudentBean.getTransportationFee()+objStudentBean.getHostelFee()+objStudentBean.getStationaryFee();
		
		objStudentBean.setNetFee(fee);
		
		String  studentIdArray[] =objStudentBean.getStudentId().split(",");
		
		Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
		
		for(int i=0; i < studentIdArray.length;i++) {
			
			StudentBean oldAcadamicYearData = studentDao.getById(Integer.parseInt(studentIdArray[i]), academicYearId);
			oldAcadamicYearData.setAcademicYearId(Integer.parseInt(objStudentBean.getAcademicYear()));
			oldAcadamicYearData.setBoardName(objStudentBean.getBoardId());
			oldAcadamicYearData.setClassName(objStudentBean.getClassId());
			oldAcadamicYearData.setSection(objStudentBean.getSectionId());
			oldAcadamicYearData.setMedium(objStudentBean.getMediumId());
			
			//New Fees 
			oldAcadamicYearData.setAdmissionFee(objStudentBean.getAdmissionFee());
			oldAcadamicYearData.setTutionFee(objStudentBean.getTutionFee());
			oldAcadamicYearData.setTransportationFee(objStudentBean.getTransportationFee());
			oldAcadamicYearData.setHostelFee(objStudentBean.getHostelFee());
			oldAcadamicYearData.setStationaryFee(objStudentBean.getStationaryFee());
			oldAcadamicYearData.setTotalFee(fee);

			oldAcadamicYearData.setNetFee(objStudentBean.getNetFee());
			oldAcadamicYearData.setDiscountFee(objStudentBean.getDiscountFee());
			
			
			oldAcadamicYearData.setSnoPk(0);
			studentDao.studentPromotionSave(oldAcadamicYearData);
//			session.setAttribute("message", "Successfully Student is Added");
			
			//NeighbourhoodUtil neighbour = new NeighbourhoodUtil();
			//String randomNum = neighbour.randNum();
			
			mobileNumber = oldAcadamicYearData.getMobile();
			String messageBody = "<table><tr>Dear Parent/Gaurdian,</tr><br><tr ><td style='padding-left:112px; padding-top:5px;'>Your Child :_username_ ,  Promoted to next Class Successfully .</td></tr><br></table><br><div style='width: 712.5pt;font-size: 14px; top:150px;'><ul>Thanks,<br/>Gretnaltes.</ul></div>";
			messageBody = messageBody.replace("_username_", oldAcadamicYearData.getName());
			//messageBody = messageBody.replace("_password_", randomNum);
			String smsMessage = "Dear Parent,\n Your Child "+ oldAcadamicYearData.getName() +" Promoted to next Class Successfully . Thanking You. Gretnaltes School";
			if(StringUtils.isNotBlank(mobileNumber)){
				SendSMS.sendSMS(smsMessage, mobileNumber, objContext);
			}
			
			 toAddress=  oldAcadamicYearData.getEmail();
			/*if(StringUtils.isNotBlank(toAddress)){
			MailSender.sendEmailWithAttachment(toAddress, "Regarding, School Notifications",messageBody,null,objContext);
			}*/
		
		}
			//Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
			listOrderBeans = studentDao.getallStudentDetails(null,null,null,null,null,null,null,null,null,academicYearId.toString(),null);
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				  request.setAttribute("baseUrl", baseUrl);
				 // System.out.println(sJson); 
			}
			
		
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
					logger.error(e);
					logger.fatal("error in userLogin method in school Homecontroller class addStudent method");
					session.setAttribute("message", "Failed");
				}
		redir.addFlashAttribute("msg", " Student Promoted  Successfully");
		redir.addFlashAttribute("cssMsg", "success");
		
		return "redirect:studentPromotion";  
	}
	
	@ModelAttribute("academicYear")
	public Map<String, String> academicYear() {
		
		
		return addAcademicYearDao.getNotActiveAcademicYearSelectList();
	}
	
	@ModelAttribute("board")
	public Map<String, String> populate() {
		Map<String, String> statesMap = new LinkedHashMap<String, String>();
		try {
			String sSql = "select id,name from boardname order by name asc";
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
