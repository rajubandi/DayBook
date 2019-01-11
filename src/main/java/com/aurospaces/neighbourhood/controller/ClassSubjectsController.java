package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.aurospaces.neighbourhood.bean.ClassCreationBean;
import com.aurospaces.neighbourhood.bean.ClassSubjectBean;
import com.aurospaces.neighbourhood.bean.FacultyBean;
import com.aurospaces.neighbourhood.bean.FacultySubjectsBean;
import com.aurospaces.neighbourhood.bean.FilterBean;
import com.aurospaces.neighbourhood.db.dao.AddClassSubjectDao;
import com.aurospaces.neighbourhood.db.dao.AttendanceDao;
import com.aurospaces.neighbourhood.db.dao.StudentDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.aurospaces.neighbourhood.db.model.Faculty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ClassSubjectsController {
	@Autowired ServletContext objContext;
	@Autowired Faculty faculty;
	@Autowired StudentDao studentDao;
	@Autowired AttendanceDao attendanceDao;
	@Autowired com.aurospaces.neighbourhood.db.dao.FacultySubjectsDao objfacultysubjectDao;
	@Autowired usersDao1 usesDao1;
	@Autowired AddClassSubjectDao objAddClassSubjectDao;
	
	@RequestMapping(value = "/classSubjects")	
	public String classSubjects(@ModelAttribute("classSubjectCmd") ClassSubjectBean classSubjectBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("classSubjects");
		List<ClassSubjectBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		try{
			listOrderBeans = objAddClassSubjectDao.getAllClassSubjects();
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
		return "classSubjects";
	}
	
	
	
	@RequestMapping(value = "/saveClassSubject")
	public String saveClassSubject(@ModelAttribute("classSubjectCmd") ClassSubjectBean classSubjectBean, ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException
	{
		ClassSubjectBean listOrderBeans = null;
		try {
			
			System.out.println("---list---"+classSubjectBean);
			listOrderBeans = objAddClassSubjectDao.duplecateCheck(classSubjectBean);
//			System.out.println("---list---"+listOrderBeans.size());
			if(listOrderBeans !=null ) {
				
//				session.setAttribute("message", "Record already exist.");
				redir.addFlashAttribute("msg", " Record already exist");
				redir.addFlashAttribute("cssMsg", "danger");
				
			}else {
				System.out.println("------------------------"+classSubjectBean.getId());
				if(classSubjectBean.getId()==0) {
					objAddClassSubjectDao.save(classSubjectBean);
//					session.setAttribute("message", "Successfully subject  created for class");
					redir.addFlashAttribute("msg", " Successfully subject  created for class");
					redir.addFlashAttribute("cssMsg", "success");
				}else {
					objAddClassSubjectDao.save(classSubjectBean);
//					session.setAttribute("message", "Update sucessfully.");
					redir.addFlashAttribute("msg", " Successfully Subject  Updated For Class");
					redir.addFlashAttribute("cssMsg", "warning");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return "redirect:classSubjects";
		
	}
	@RequestMapping(value = "/deleteClassSubject")
	public @ResponseBody String deleteClassSubject( ModelMap model,HttpServletRequest request,HttpSession session)  {
		System.out.println("Home controller...");
		List<ClassSubjectBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		String message =null;
		String classId = null;
		int id=0;
		try{
			classId = request.getParameter("id");
			if(StringUtils.isNotBlank(classId)){
				id=Integer.parseInt(classId);
				objAddClassSubjectDao.delete(id);
//				session.setAttribute("message", "Successfully Class is Deleted");
			}
			
			listOrderBeans = objAddClassSubjectDao.getAllClassSubjects();
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				 // System.out.println(sJson); 
			}
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			session.setAttribute("message", "Failed");
		}

		return sJson;
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
		Map<String, String> statesMap = new LinkedHashMap<String, String>();
		try {
			String sSql = "select id,name from classtable ";
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
