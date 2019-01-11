package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.StudentBean;
import com.aurospaces.neighbourhood.bean.StudentMarksBean;
import com.aurospaces.neighbourhood.db.dao.AddAcademicYearDao;
import com.aurospaces.neighbourhood.db.dao.ClassCreationDao;
import com.aurospaces.neighbourhood.db.dao.ExamTypeDao;
import com.aurospaces.neighbourhood.db.dao.StudentDao;
import com.aurospaces.neighbourhood.db.dao.StudentMarksDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.aurospaces.neighbourhood.util.SendSMS;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class StudentMarksController {
	
	Logger log = Logger.getLogger(StudentMarksController.class);
	@Autowired usersDao1 usesDao1;
	@Autowired ServletContext objContext;
	@Autowired StudentMarksDao studentMarksDao;
	@Autowired ClassCreationDao objClassCreation;
	@Autowired  ExamTypeDao  examTypeDao;
	@Autowired StudentDao studentDao;
	@Autowired AddAcademicYearDao addAcademicYearDao;
	private Logger logger = Logger.getLogger(StudentMarksController.class);
	@RequestMapping("/studentMarks")
	public String studentMarksPage(@ModelAttribute("studentMarksCmd") StudentMarksBean studentMarksBean,Model model,HttpServletRequest request,HttpSession session) {
		List<StudentMarksBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		model.addAttribute("examType", examTypeDao.getAllExamType()) ;
		//model.addAttribute("studentsHighLevelMarks", studentMarksDao.getStudentsHighlevelMarks());
		Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
		session.setAttribute("activeAcademicYearId", academicYearId);
		try {
			listOrderBeans=studentMarksDao.getStudentsHighlevelMarks(null,null,null,null,null,null,academicYearId.toString());
			System.out.println(listOrderBeans);
			if(listOrderBeans != null) {
			objectMapper= new  ObjectMapper();
			sJson = objectMapper.writeValueAsString(listOrderBeans);
			request.setAttribute("studentsHighLevelMarks", sJson);
			}else {
				
				request.setAttribute("studentsHighLevelMarks", "''");
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			logger.error(e);
			logger.fatal("error in userLogin method in StudentMarksController class studentMarksPage method");

		}	
		 
		
		
		
		return "studentMarks";
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
		
		
		@RequestMapping(value = "/savingStudentMarks",method = RequestMethod.POST)
		public String savingStudentMarks(@ModelAttribute("studentMarksCmd") StudentMarksBean studentMarksBean ,Model model)  {
			String  subjectArray[] =studentMarksBean.getSubjectId().split(",");
			String  studentMarksArray[] =studentMarksBean.getStudentMarks().split(",");
			  String  subjectMaxMarksArray[] =studentMarksBean.getSubjectMaxMarks().split(",");
			  /*Random rand = new Random();
			    // Generate random integers in range 0 to 999
		        int rand_int1 = rand.nextInt(1000);
			if(StringUtils.isNotBlank(studentMarksBean.getRandomnum())) {
				
				examPatternDao.removeOldRecordForUpdate(studentMarksBean.getRandomnum());
			}*/
			  studentMarksBean.setAcademicYearId(addAcademicYearDao.getActiveAcademicYearId());
			 for(int i=0;i<subjectArray.length;i++){
				 
				 studentMarksBean.setId(0);
				 studentMarksBean.setSubjectId(subjectArray[i]);
				 studentMarksBean.setSubjectMaxMarks(subjectMaxMarksArray[i]);
				 studentMarksBean.setStudentMarks(studentMarksArray[i]);
				 studentMarksDao.save(studentMarksBean) ;
			 }
			
			return "redirect:studentMarks";
		}
		
		
		
		@RequestMapping(value = "/getPogressCard")
		public @ResponseBody String getPogressCard( ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
			System.out.println("searchStudetnFee controller...");
			List<StudentMarksBean> listOrderBeans = null;
			ObjectMapper objectMapper = null;
			String sJson = "";
			String studetnId = null;
			/*String boardId = null;
			String classId = null;
			String sectionId = null;
			String mediamId = null;
			String studentId = null;
			*/String exampTypeId = null;
			String acadamicYearId = null;
			try{
				studetnId = request.getParameter("studentId");
				exampTypeId = request.getParameter("examTypeName");
				//acadamicYearId = request.getParameter("academicYear");
				Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
				
				//boardId = request.getParameter("boardId");
				//classId = request.getParameter("classId");
				//sectionId = request.getParameter("sectionId");
				//mediamId = request.getParameter("mediumId");
			
				listOrderBeans = studentMarksDao.getPogressCard(studetnId,exampTypeId,academicYearId);
				
				
				if(listOrderBeans != null && listOrderBeans.size() > 0) {
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOrderBeans);
					 // request.setAttribute("studentSubjectMarksList", sJson);
					 // System.out.println(sJson); 
				}else{
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOrderBeans);
					 // request.setAttribute("allOrders1", "''");
				}
				//studentDao.save(objClassBean);
			}catch(Exception e){
	e.printStackTrace();
		System.out.println(e);
				logger.error(e);
				logger.fatal("error in userLogin method in school Homecontroller class searchStudentFee1 method");
			}

			return sJson;  
		}
		
		
		@RequestMapping(value = "/getToPrintAllPogressCard")
		public @ResponseBody String getToPrintAllPogressCard(@RequestParam(value = "studentArry[]") String[] map,@RequestParam(value="examtypeId[]") String[] examtypeId, ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
			System.out.println("searchStudetnFee controller...");
			List<StudentMarksBean> listOrderBeans = null;
			List<List<StudentMarksBean>> listOfBeans = new ArrayList<>();
			
			ObjectMapper objectMapper = null;
			String sJson = "";
			
			try{
				
				Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
				
				
				for(int i=0;i<map.length;i++) {
				listOrderBeans = studentMarksDao.getPogressCard(map[i],examtypeId[i],academicYearId);
				listOfBeans.add(listOrderBeans);
				}
				
				if(listOfBeans != null && listOfBeans.size() > 0) {
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOfBeans);
					 // request.setAttribute("studentSubjectMarksList", sJson);
					 // System.out.println(sJson); 
				}else{
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOrderBeans);
					 // request.setAttribute("allOrders1", "''");
				}
				
				//studentDao.save(objClassBean);
			}catch(Exception e){
	e.printStackTrace();
		System.out.println(e);
				logger.error(e);
				logger.fatal("error in userLogin method in StudentMarksController class getToPrintAllPogressCard method");
			}

			return sJson;  
		}
		
		
		
		@RequestMapping(value = "/smsStudentMarks")
		public @ResponseBody String smsStudentMarks(@RequestParam(value = "studentArry[]") String[] map,@RequestParam(value="examtypeId[]") String[] examtypeId, ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
			List<StudentMarksBean> listOrderBeans = null;
			ListIterator<StudentMarksBean> litr = null;
			//List<StudentMarksBean> marksList = new ArrayList<>();
			ObjectMapper objectMapper = null;
			String sJson = "";
			String studetnId = null;
			String mobileNumber = null;
		String  boardName = request.getParameter("map");
			//String map= request.getParameter("map1");
			 
			try{
				Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
					for(int i=0;i<=map.length;i++) {
					//String studentIdAndExamTypeId = entry.getValue();
					
					listOrderBeans = studentMarksDao.getPogressCard(map[i],examtypeId[i],null);
					
						StudentBean studentBean = studentDao.getById(Integer.parseInt(map[i]),academicYearId);
			        	
			        mobileNumber = studentBean.getMobile();
			        String smsMessage="";
					//messageBody = messageBody.replace("_password_", randomNum);
			        Iterator<StudentMarksBean> litr1=listOrderBeans.listIterator();
			        StringBuffer subAndMarks = new StringBuffer();
			        String examName = null;
			        String className =null;
					while(litr1.hasNext()){
						StudentMarksBean smb = litr1.next();
						examName = smb.getExamTypeName();
						className = smb.getClassName();
						
													
							subAndMarks.append(smb.getSubjectTitle() + " : "+" "+ smb.getStudentMarks() +" "+ " Out of "+ smb.getSubjectMaxMarks());
							subAndMarks.append(System.getProperty("line.separator"));

						
					}
					String messageBody = "<table><tr>Dear Parent/Gaurdian,</tr><br><tr ><td style='padding-left:112px; padding-top:5px;'>Thanks for Registering with us.</td></tr><br></table><table ><tr><td style='padding-left:10px;'><b>Your Login Details:</b></td></tr><tr><td style='padding-left:30px;'>Username: _username_</td></tr><tr><td style='padding-left:30px;'>Password: _password_</td></tr></table><br><div style='width: 712.5pt;font-size: 14px; top:150px;'><ul>Thanks,<br/>Vivekananda vidhyalayam.</ul></div>";
					messageBody = messageBody.replace("_username_", studentBean.getFatherName());
					smsMessage = "Dear Parent,\n Your Child " + studentBean.getName()
							+ ", Class"+ className +" /n Marks  in "+examName +" are ,"+"\n"+subAndMarks+" \nThank You,\n Vivekananda vidhyalayam.";
					
					System.out.println("msgmarksmsgmarksmsgmarksmsgmarksmsgmarks"+ smsMessage );
					if(StringUtils.isNotBlank(mobileNumber)){
						SendSMS.sendSMS(smsMessage, mobileNumber, objContext);
					}
			        
			        } 
				
			}catch(Exception e){
	e.printStackTrace();
		System.out.println(e);
				logger.error(e);
				logger.fatal("error in userLogin method in school Homecontroller class sending sms for fees method");
			}

			return "";  
		}
		
		@RequestMapping(value = "/searchStudetnMarks")
		public @ResponseBody String searchStudetnFee1( ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
			System.out.println("searchStudetnFee controller...");
			List<StudentMarksBean> listOrderBeans = null;
			ObjectMapper objectMapper = null;
			String sJson = "";
			String studetnId = null;
			String boardId = null;
			String classId = null;
			String sectionId = null;
			String mediamId = null;
			String examTypeId = null;
			try{
				studetnId = request.getParameter("studentId");
				boardId = request.getParameter("boardId");
				classId = request.getParameter("classId");
				sectionId = request.getParameter("sectionId");
				mediamId = request.getParameter("mediumId");
				examTypeId =request.getParameter("examTypeId");
				
				Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
				//session.setAttribute("activeAcademicYearId", academicYearId);
				listOrderBeans = studentMarksDao.getStudentsHighlevelMarks(boardId,classId,sectionId,mediamId,examTypeId,studetnId,academicYearId.toString());
				if(listOrderBeans != null && listOrderBeans.size() > 0) {
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOrderBeans);
					  request.setAttribute("studentsHighLevelMarks", sJson);
					 // System.out.println(sJson); 
				}else{
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(listOrderBeans);
					  request.setAttribute("studentsHighLevelMarks", "''");
				}
				//studentDao.save(objClassBean);
			}catch(Exception e){
	e.printStackTrace();
		System.out.println(e);
				logger.error(e);
				logger.fatal("error in userLogin method in school Homecontroller class searchStudentFee1 method");
			}

			return sJson;  
		}
		
}
