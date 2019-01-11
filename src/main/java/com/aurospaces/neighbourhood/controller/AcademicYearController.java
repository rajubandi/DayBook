package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aurospaces.neighbourhood.bean.AcademicYearBean;
import com.aurospaces.neighbourhood.db.dao.AddAcademicYearDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class AcademicYearController {

	Logger log = Logger.getLogger(AcademicYearController.class);
	private Logger logger = Logger.getLogger(AcademicYearController.class);
	@Autowired AddAcademicYearDao addAcademicYearDao;
	
	@RequestMapping(value = "/academicYearHome")
	public String academicYearHome(@ModelAttribute("academicYear") AcademicYearBean academicYearBean,ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		List<Map<String, Object>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String boardName=null;
		try{
			listOrderBeans = addAcademicYearDao.getAcademicYear();
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
			//studentDao.save(objClassBean);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in AcademicYearController class boardHome method");
		}

		return "academicYearHome";  
	}
	
	@RequestMapping(value = "/addAcademicYear")
	public String addAcademicYear(@ModelAttribute("academicYear") AcademicYearBean academicYearBean,ModelMap model,HttpServletRequest request, HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Home AcademicYearController...");
		List<Map<String, Object>> listOrderBeans = null;
		AcademicYearBean listOrderBeans1 = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		try{
			academicYearBean.setName(academicYearBean.getStartYear()+ "-" +academicYearBean.getEndYear());
			listOrderBeans1 = addAcademicYearDao.existingOrNot(academicYearBean.getName());
			int id = 0;
			 int dummyId = 0;
				if (listOrderBeans1 != null) {
					dummyId = listOrderBeans1.getId();
				}
				if (academicYearBean.getId() != 0) {
					id = academicYearBean.getId();
					if (id == dummyId || listOrderBeans1 == null) {

						addAcademicYearDao.save(academicYearBean);
						redir.addFlashAttribute("msg", "Record Updated Successfully");
						redir.addFlashAttribute("cssMsg", "warning");
					} else {
						redir.addFlashAttribute("msg", "Already Record Exist");
						redir.addFlashAttribute("cssMsg", "danger");
					}
				}
				if (academicYearBean.getId() == 0 && listOrderBeans1 == null) {
					
					
					
					addAcademicYearDao.save(academicYearBean);

					redir.addFlashAttribute("msg", "Record Inserted Successfully");
					redir.addFlashAttribute("cssMsg", "success");
				}
				if (academicYearBean.getId() == 0 && listOrderBeans1 != null) {
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			
			
			/*if(objAddBoardBean.getId() == 0){
				listOrderBeans1 = addBoardDao.existingOrNot(objAddBoardBean.getName());
				if(listOrderBeans1.size() == 0){
					addBoardDao.save(objAddBoardBean);
//					session.setAttribute("message", "Successfully Board is Created");
					redir.addFlashAttribute("msg", " Board Created  Successfully");
					redir.addFlashAttribute("cssMsg", "success");
				}
				else{
//					session.setAttribute("message", "Already Existed Record");
					redir.addFlashAttribute("msg", " Board Already  Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}else{
				addBoardDao.save(objAddBoardBean);
//				session.setAttribute("message", "Successfully Board is Updated");
				redir.addFlashAttribute("msg", " Board Updated  Successfully");
				redir.addFlashAttribute("cssMsg", "warning");
			}*/
			
			
			listOrderBeans = addAcademicYearDao.getAcademicYear();
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
			//studentDao.save(objClassBean);
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in AcademicYearController class addAcademicYear method");
			session.setAttribute("message", "Failed");
		}

		return "redirect:academicYearHome";  
	}
	
	@RequestMapping(value = "/activateAcademicYear")
	public @ResponseBody String activateAcademicYear(ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		List<Map<String, Object>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String id = null;
		try{
			id = request.getParameter("id");
			//String status = request.getParameter("status");
			
			if(StringUtils.isNotBlank(id)){
			addAcademicYearDao.activateAcademicYear(Integer.parseInt(id));		
			}
			listOrderBeans = addAcademicYearDao.getAcademicYear();
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
			}else{
				objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", "''");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in AcademicYearController class deleteAcademicYear method");
		}

		return sJson;  
	}
	
}
