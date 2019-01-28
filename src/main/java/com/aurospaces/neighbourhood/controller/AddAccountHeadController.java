package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import com.aurospaces.neighbourhood.bean.AddAccountHeadBean;
import com.aurospaces.neighbourhood.dao.AddAccountHeadDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class AddAccountHeadController {
	@Autowired AddAccountHeadDao addAccountHeadDao;
	@RequestMapping(value = "/addAccountHead")
	public String addAccountHead(@ModelAttribute("packCmd") AddAccountHeadBean objAddAccountHeadBean,ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		String accountName=null;
		try{
			listOrderBeans = addAccountHeadDao.getAccountHaed();
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
			
		}

		return "addAccountHead";  
	}
	
@RequestMapping(value = "/addAccountName")
public String addAccountName(@ModelAttribute("packCmd") AddAccountHeadBean objAddAccountHeadBean,ModelMap model,HttpServletRequest request, HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("Home controller...");
	List<Map<String, String>> listOrderBeans = null;
	AddAccountHeadBean listOrderBeans1 = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	try{
		System.out.println("addBoardaddBoardaddBoardaddBoard");
		listOrderBeans1 = addAccountHeadDao.existingOrNot(objAddAccountHeadBean.getName());
		int id = 0;
		 int dummyId = 0;
			if (listOrderBeans1 != null) {
				dummyId = listOrderBeans1.getId();
			}
			if (objAddAccountHeadBean.getId() != 0) {
				id = objAddAccountHeadBean.getId();
				if (id == dummyId || listOrderBeans1 == null) {

					addAccountHeadDao.save(objAddAccountHeadBean);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
				} else {
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}
			if (objAddAccountHeadBean.getId() == 0 && listOrderBeans1 == null) {
				addAccountHeadDao.save(objAddAccountHeadBean);

				redir.addFlashAttribute("msg", "Record Inserted Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			if (objAddAccountHeadBean.getId() == 0 && listOrderBeans1 != null) {
				redir.addFlashAttribute("msg", "Already Record Exist");
				redir.addFlashAttribute("cssMsg", "danger");
			}
		
		
		/*if(objAddBoardBean.getId() == 0){
			listOrderBeans1 = addBoardDao.existingOrNot(objAddBoardBean.getName());
			if(listOrderBeans1.size() == 0){
				addBoardDao.save(objAddBoardBean);
//				session.setAttribute("message", "Successfully Board is Created");
				redir.addFlashAttribute("msg", " Board Created  Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			else{
//				session.setAttribute("message", "Already Existed Record");
				redir.addFlashAttribute("msg", " Board Already  Exist");
				redir.addFlashAttribute("cssMsg", "danger");
			}
		}else{
			addBoardDao.save(objAddBoardBean);
//			session.setAttribute("message", "Successfully Board is Updated");
			redir.addFlashAttribute("msg", " Board Updated  Successfully");
			redir.addFlashAttribute("cssMsg", "warning");
		}*/
		
		
		listOrderBeans = addAccountHeadDao.getAccountHaed();
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
		/*logger.error(e);
		logger.fatal("error in school Homecontroller class addAccountHead method");*/
		session.setAttribute("message", "Failed");
	}

	return "redirect:addAccountHead";  
}

@RequestMapping(value = "/deleteAccount")
public @ResponseBody String deleteAccountHead(ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
	List<Map<String, String>> listOrderBeans = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	String accountId = null;
	try{
		accountId = request.getParameter("id");
		if(StringUtils.isNotBlank(accountId)){
			addAccountHeadDao.delete(Integer.parseInt(accountId));		
		}
		listOrderBeans = addAccountHeadDao.getAccountHaed();
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
		/*logger.error(e);
		logger.fatal("error in school Homecontroller class deleteBoard method");*/
	}

	return sJson;  
}
}

