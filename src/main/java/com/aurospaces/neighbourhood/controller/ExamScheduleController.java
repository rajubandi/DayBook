package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.ExamScheduleBean;
import com.aurospaces.neighbourhood.db.dao.AddAcademicYearDao;
import com.aurospaces.neighbourhood.db.dao.ExamScheduleDao;
import com.aurospaces.neighbourhood.db.dao.ExamTypeDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ExamScheduleController {
	
	Logger log = Logger.getLogger(ExamScheduleController.class);
	private Logger logger = Logger.getLogger(ExamScheduleController.class);
	@Autowired usersDao1 usesDao1;
	@Autowired ServletContext objContext;
	@Autowired private ExamTypeDao  examTypeDao;
	@Autowired ExamScheduleDao examScheduleDao;
	@Autowired AddAcademicYearDao addAcademicYearDao;
	@RequestMapping("/examSchedule")
	public String examScheduleHome(@ModelAttribute("examSchedule") ExamScheduleBean examScheduleBean,Model model,HttpServletRequest request) {
		ObjectMapper objectMapper = null;
		String sJson = "";
		//model.addAttribute("examType", examTypeDao.getAllExamType()) ;
		//model.addAttribute("studentsHighLevelMarks", studentMarksDao.getStudentsHighlevelMarks());
		model.addAttribute("examType", examTypeDao.getAllExamType()) ;
		
		try {
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			logger.error(e);
			logger.fatal("error in userLogin method in ExamScheduleController class Home method");

		}	
		 
		return "examSchedule";
	}
	
	@RequestMapping(value = "/SaveExamSchedule")
	public String SaveExamSchedule(@ModelAttribute("examSchedule") ExamScheduleBean examScheduleBean, ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		
		String  subjectArray[] =examScheduleBean.getSubjectId().split(",");
		  String  maxMarksArray[] =examScheduleBean.getExamDate().split(",");
		  String  fromTime[] =examScheduleBean.getFromTime().split(",");
		  String  toTime[] =examScheduleBean.getToTime().split(",");
		System.out.println("Home controller...");
		List<Map<String, String>> listOrderBeans = null;
		String mobileNumber =null; 
		String  toAddress= null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		
		 Random rand = new Random();
		    // Generate random integers in range 0 to 999
	        int rand_int1 = rand.nextInt(1000);
	        examScheduleBean.setAcademicYearId(addAcademicYearDao.getActiveAcademicYearId());
		if(StringUtils.isNotBlank(examScheduleBean.getRandomnum())) {
			
			examScheduleDao.removeOldRecordForUpdate(examScheduleBean.getRandomnum());
		}
		for(int i=0;i<subjectArray.length;i++) {
			 examScheduleBean.setId(0);
			 examScheduleBean.setSubjectId(subjectArray[i]);
			 examScheduleBean.setExamDate(maxMarksArray[i]);
			 examScheduleBean.setFromTime(fromTime[i]);
			 examScheduleBean.setToTime(toTime[i]);
			 examScheduleBean.setRandomnum(Integer.toString(rand_int1));
			 examScheduleDao.save(examScheduleBean);
		 }
		/*try{
			double fee =examScheduleBean.getAdmissionFee()+examScheduleBean.getTutionFee()+examScheduleBean.getTransportationFee()+examScheduleBean.getHostelFee()+examScheduleBean.getStationaryFee();
			
			StudentBean objStudent = studentDao.getById(Integer.parseInt(examScheduleBean.getStudentId()));
			StudentFeeBean studentfee = objStudentFeeDao.getTotalfee(examScheduleBean.getStudentId(),examScheduleBean.getId());
			examScheduleBean.setFee(fee);
			
				double dueFee1=objStudent.getNetFee()-(fee+studentfee.getFee());
				examScheduleBean.setDueFee1(dueFee1);
				UsersBean userBean= (UsersBean) session.getAttribute("cacheUserBean");
				examScheduleBean.setUserId(userBean.getId());
				 Random rand = new Random();
				 
			        // Generate random integers in range 0 to 999
			        int rand_int1 = rand.nextInt(100000);
			        examScheduleBean.setInvoiceId(rand_int1);
			objStudentFeeDao.save(examScheduleBean);
			
			StringBuffer feeAppender = new StringBuffer();
			String admissionFee="",tutionFee="",transportationFee="",schoolFee="",stationaryFee="";
			if(examScheduleBean.getAdmissionFee() != 0.0) {
				
				 admissionFee = "Admission Fee";
				 
				 
				 feeAppender.append(admissionFee);
			}
			if(examScheduleBean.getTutionFee() != 0.0) {
				
				tutionFee = "Tution Fee";
				if(feeAppender != null) {
					
					feeAppender.append(tutionFee);
				}
				feeAppender.append(","+tutionFee);
			}
			if(examScheduleBean.getTransportationFee() != 0.0) {
				transportationFee = "Bus Fee";
				
					if(feeAppender != null) {
					
						feeAppender.append(","+transportationFee);
					}
				feeAppender.append(transportationFee);
			}
			if(examScheduleBean.getHostelFee() != 0.0) {
				
				schoolFee = "School Fee";
				
				if(feeAppender != null) {
					
					feeAppender.append(","+schoolFee);
				}
				feeAppender.append(schoolFee);
			}
			if(examScheduleBean.getStationaryFee() != 0.0) {
				
				stationaryFee = "Book & Stationary Fee";
					if(feeAppender != null) {
					
					feeAppender.append(","+stationaryFee);
				}
				feeAppender.append(stationaryFee);
				
			}
			
			String messageBody = "<table><tr>Dear Parent/Gaurdian <b>_username_ </b>,</tr><br><tr ><td style='padding-left:112px; padding-top:5px;'>Your child _studentName_ _fee_ payment has been processed successfully and Invoice Id:<b>_invoiceId_<b></td></tr>    <tr ><td style='padding-left:112px; padding-top:5px;'>Amount:<b>_amount_</b></td></tr>   <tr ><td style='padding-left:112px; padding-top:5px;'>Due Amount:<b>_due_</b></td></tr></table><br><div style='width: 712.5pt;font-size: 14px; top:150px;'><ul>Thanks,<br/>Vivekananda vidhyalayam.</ul></div>";
			messageBody = messageBody.replace("_username_", objStudent.getFatherName());
			messageBody = messageBody.replace("_studentName_", objStudent.getName());
			messageBody = messageBody.replace("_fee_", feeAppender);
			messageBody = messageBody.replace("_invoiceId_", Integer.toString(examScheduleBean.getInvoiceId()));
			messageBody = messageBody.replace("_amount_", Double.toString(examScheduleBean.getFee()));
			messageBody = messageBody.replace("_due_", Double.toString(examScheduleBean.getDueFee1()));
			String smsMessage = "Dear Parent,\n Your Child "+ objStudent.getName() +" _fee_ payment has been processed successfully and Invoice Id:"+examScheduleBean.getInvoiceId()+".\nAmount:"+examScheduleBean.getFee()+"Due Amount:"+examScheduleBean.getDueFee1()+"\n Thanks,Vivekananda vidhyalayam." ;
			smsMessage = smsMessage.replace("_fee_", feeAppender);
			
			mobileNumber = objStudent.getMobile();
			
			if(StringUtils.isNotBlank(mobileNumber)){
				SendSMS.sendSMS(smsMessage, mobileNumber, objContext);
			}
			 toAddress=  objStudent.getEmail();
			if(StringUtils.isNotBlank(toAddress)){
			MailSender.sendEmailWithAttachment(toAddress, "Regarding, School Notifications",messageBody,null,objContext);
			}
			
			
			listOrderBeans = objStudentFeeDao.getallStudentsFee(null,null,null,null,null);
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
			}
			//studentDao.save(objClassBean);
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class addStudentFee method");
		}*/

		return "redirect:examSchedule";  
	}
	
	
	@RequestMapping(value = "/getExamScheduleList")
	public @ResponseBody String getExamScheduleList( ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		List<ExamScheduleBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String examTypeId = null;
		String boardId = null;
		String classId = null;
		String sectionId = null;
		String mediamId = null;
		Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
		try{
			examTypeId = request.getParameter("examTypeId");
			boardId = request.getParameter("boardId");
			classId = request.getParameter("classId");
			sectionId = request.getParameter("sectionId");
			mediamId = request.getParameter("medium");
		
			listOrderBeans = examScheduleDao.getExamScheduleList(examTypeId,boardId,classId,sectionId,mediamId,academicYearId.toString());
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("examScheduleList", sJson);
				 // System.out.println(sJson); 
			}else{
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("examScheduleList", "''");
			}
			//studentDao.save(objClassBean);
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in ExamScheduleController class getExamScheduleList method");
		}

		return sJson;  
	}
	
	
	
	@ModelAttribute("board")
	public Map<String, String> populate() {
		Map<String, String> statesMap = new LinkedHashMap<String, String>();
		try {
			String sSql = "select id,name from boardname order by name asc";
			List<BoardBean> list = usesDao1.populate(sSql);
			for (BoardBean bean : list) {
				statesMap.put(bean.getId(), bean.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return statesMap;
	}

}
