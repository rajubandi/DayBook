package com.aurospaces.neighbourhood.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.FacultyBean;
import com.aurospaces.neighbourhood.bean.FacultySubjectsBean;
import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.db.dao.AttendanceDao;
import com.aurospaces.neighbourhood.db.dao.StudentDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.aurospaces.neighbourhood.db.model.Faculty;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;
import com.aurospaces.neighbourhood.util.SendSMS;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class FacultyController {
	@Autowired ServletContext objContext;
	@Autowired Faculty faculty;
	@Autowired StudentDao studentDao;
	@Autowired AttendanceDao attendanceDao;
	@Autowired com.aurospaces.neighbourhood.db.dao.FacultySubjectsDao objfacultysubjectDao;
	@Autowired usersDao1 usesDao1;
	@RequestMapping(value = "/addFaculty")
	public String getaddFaculty(@ModelAttribute("packCmd") FacultyBean objClassBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("alumini page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		try{
			listOrderBeans = faculty.getallFaculty();
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
				 // faculty.save(objClassBean);
			}else{
				 objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", "''");
//				session.setAttribute("message", "No Records found");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return "facultyHome";
	}
	
	
	@RequestMapping(value = "/facultySubmit")
	public String facultySubmit(@ModelAttribute("packCmd") FacultyBean facultybean, ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Home controller...");
		List<Map<String, String>> listOrderBeans =null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		System.out.println(facultybean.getName());
		FacultyBean listOrderBeans1 =null;
		String mobileNumber =null; 
		InputStream input = null;
		 Properties prop = new Properties();
		try{
		
			
			
			int id = 0;
			listOrderBeans1=faculty.getExistingOrNot(facultybean);
			
			
			 int dummyId = 0;
				if (listOrderBeans1 != null) {
					dummyId = listOrderBeans1.getId();
				}
				if (facultybean.getId() != 0) {
					id = facultybean.getId();
					if (id == dummyId || listOrderBeans1 == null) {
						
						
						faculty.save(facultybean);
						
						redir.addFlashAttribute("msg", "Record Updated Successfully");
						redir.addFlashAttribute("cssMsg", "warning");
					} else {
						redir.addFlashAttribute("msg", "Already Record Exist");
						redir.addFlashAttribute("cssMsg", "danger");
					}
				}
				if (facultybean.getId() == 0 && listOrderBeans1 == null) {
					
					
					 String propertiespath = objContext.getRealPath("Resources" +File.separator+"DataBase.properties");
						input = new FileInputStream(propertiespath);
						// load a properties file
						prop.load(input);
						
						NeighbourhoodUtil neighbour = new NeighbourhoodUtil();
						String randomNum = neighbour.randNum();
						
						UsersBean userbean=new UsersBean();
						userbean.setRolId("2");
						userbean.setName(facultybean.getName());
						userbean.setPassword(randomNum);
						userbean.setMobile(facultybean.getContactNumber());
						 usesDao1.save(userbean);
						 mobileNumber = facultybean.getContactNumber();
							String smsMessage ="Dear Faculty,\nThanks for Registering with us.\nYour Login details,\nUsername:"+facultybean.getName()+"\nPassword:"+userbean.getPassword();
//							smsMessage.replace("_facultyName_", facultybean.getName());
//							smsMessage.replace("_pass_",userbean.getPassword());
							if(StringUtils.isNotBlank(mobileNumber)){
								SendSMS.sendSMS(smsMessage, mobileNumber, objContext);
							}
					
					faculty.save(facultybean);

					redir.addFlashAttribute("msg", "Record Inserted Successfully");
					redir.addFlashAttribute("cssMsg", "success");
				}
				if (facultybean.getId() == 0 && listOrderBeans1 != null) {
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			
			
			
		
			
			
			listOrderBeans = faculty.getallFaculty();
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
			}else{
				 objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString("null");
				 request.setAttribute("allOrders1", "''");
			}
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			session.setAttribute("message", "fail");
		}

		return "redirect:addFaculty.htm";
	}
	@RequestMapping(value = "/deleteFaculty")
	public @ResponseBody String deleteFaculty(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("alumini page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String facultyId = null;
		try{
			facultyId=request.getParameter("facultyId");
			if(StringUtils.isNotBlank(facultyId)){
				faculty.delete(Integer.parseInt(facultyId));
				objfacultysubjectDao.deleteFacultySubject(Integer.parseInt(facultyId));
//				session.setAttribute("message", "delete Record");
			}
			
			listOrderBeans = faculty.getallFaculty();
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
				 // faculty.save(objClassBean);
			}else{
				 objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", "''");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return sJson;
	}
	
	@RequestMapping(value = "/facultySubject")
	public String addFacultySubject(@ModelAttribute("packCmd") FacultySubjectsBean objClassBean,ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("alumini page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		try{
			listOrderBeans = objfacultysubjectDao.getallFacultySubjects(null, null, null, null);
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
				 // faculty.save(objClassBean);
			}else{
				objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", "''");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return "facultySubject";
	}
	
	
	@RequestMapping(value = "/addFacultySubjects")
	public String addFacultySubjects(@ModelAttribute("packCmd") FacultySubjectsBean facultySubjectBean, ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Home controller...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		System.out.println(facultySubjectBean.getName());
		
		try{
			int id=0;
			FacultySubjectsBean listOrderBeans1 = objfacultysubjectDao.facultySubjectExistOrNot(facultySubjectBean);
			int dummyId = 0;
			if (listOrderBeans1 != null) {
				dummyId = listOrderBeans1.getId();
			}
			if (facultySubjectBean.getId() != 0) {
				id = facultySubjectBean.getId();
				if (id == dummyId || listOrderBeans1 == null) {

					objfacultysubjectDao.save(facultySubjectBean);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
				} else {
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}
			if (facultySubjectBean.getId() == 0 && listOrderBeans1 == null) {
				objfacultysubjectDao.save(facultySubjectBean);

				redir.addFlashAttribute("msg", "Record Inserted Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			if (facultySubjectBean.getId() == 0 && listOrderBeans1 != null) {
				redir.addFlashAttribute("msg", "Already Record Exist");
				redir.addFlashAttribute("cssMsg", "danger");
			}
			
			
			/*int id= facultySubjectBean.getId();
			if(id != 0){
				objfacultysubjectDao.save(facultySubjectBean);
//				session.setAttribute("message", "Successfully Faculty-Subject is Updated");
				 redir.addFlashAttribute("msg", " Successfully Faculty-Subject is Updated");
					redir.addFlashAttribute("cssMsg", "warning");
			}else{
				FacultySubjectsBean bean = objfacultysubjectDao.facultySubjectExistOrNot(facultySubjectBean);
				if(bean == null){
				objfacultysubjectDao.save(facultySubjectBean);
//				session.setAttribute("message", "Successfully Faculty-Subject is Created");
				redir.addFlashAttribute("msg", " Successfully Faculty-Subject is Created");
				redir.addFlashAttribute("cssMsg", "success");
				}else{
//					session.setAttribute("message", "Already Faculty-Subject is Exist");
					redir.addFlashAttribute("msg", "Faculty-Subject Already Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}*/
			
			listOrderBeans = objfacultysubjectDao.getallFacultySubjects(null, null, null, null);
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
		}

		return "redirect:facultySubject";
	}
	
	@RequestMapping(value = "/deleteFacultySubject")
	public @ResponseBody List<Map<String, String>> deleteFacultySubject( ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Home controller...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String facultySubjectId = null;
		
		try{
			facultySubjectId=request.getParameter("facultySubject");
			if(StringUtils.isNotBlank(facultySubjectId)){
				objfacultysubjectDao.delete(Integer.parseInt(facultySubjectId));
			}
			listOrderBeans = objfacultysubjectDao.getallFacultySubjects(null, null, null, null);
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}

		return listOrderBeans;
	}
	@ModelAttribute("faculty")
	public Map<String, String> populatefaculty() {
		Map<String, String> statesMap = new HashMap<String, String>();
		try {
			String sSql = "select id,name from faculty order by name asc";
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
	@ModelAttribute("board")
	public Map<String, String> populate() {
		Map<String, String> statesMap = new HashMap<String, String>();
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
	@ModelAttribute("allClasses")
	public Map<String, String> populateallClasses() {
		Map<String, String> statesMap = new HashMap<String, String>();
		try {
			String sSql = "select id,name from classtable order by name asc";
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
	@ModelAttribute("allSection")
	public Map<String, String> populateallSection() {
		Map<String, String> statesMap = new HashMap<String, String>();
		try {
			String sSql = "select id,name from sectiontable order by name asc";
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
	@ModelAttribute("mediam")
	public Map<String, String> populatemediam() {
		Map<String, String> statesMap = new HashMap<String, String>();
		try {
			String sSql = "select id,name from mediam order by name asc";
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
	@ModelAttribute("subject")
	public Map<String, String> populatesubject() {
		Map<String, String> statesMap = new HashMap<String, String>();
		try {
			String sSql = "select id,name from subject order by name asc";
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
	@ModelAttribute("allStudents")
	public Map<String, String> populateStudent() {
		Map<String, String> statesMap = new HashMap<String, String>();
		try {
			String sSql = "select id,name from student order by name asc";
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
