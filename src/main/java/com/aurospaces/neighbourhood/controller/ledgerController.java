package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.AddAccountHeadBean;
import com.aurospaces.neighbourhood.bean.ExpensesBean;
import com.aurospaces.neighbourhood.db.dao.LedgerDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ledgerController {
	
	@Autowired ServletContext objContext;
	@Autowired LedgerDao ledgerDao;
	@Autowired usersDao1 usesDao1;	
	private Logger logger = Logger.getLogger(ledgerController.class);
	
	@RequestMapping(value = "/ledger")
	public String dailyFeesCollection(@ModelAttribute("ledger") ExpensesBean expensesBean,HttpServletRequest request, Model model,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		List<ExpensesBean> expensesBeanList = null;
		List<Map<String, Object>> dayWiseExpenses = null;
		ObjectMapper objectMapper = null;
		ObjectMapper objectMapper1 = null;
		String sJson = "";
		String dayWiseJson="";
		/*Integer academicYearId = addAcademicYearDao.getActiveAcademicYearId();
		session.setAttribute("activeAcademicYearId", academicYearId);*/
		try{
			Date toDate = new Date();
			expensesBeanList = ledgerDao.getExpensesBeanAll(null);
			/*dayWiseExpenses = ledgerDao.getDayWiseExpenses();*/
			//model.addAttribute(accountHead, );			
			
			if(expensesBeanList != null) {
				
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(expensesBeanList);
				  request.setAttribute("expensesList", sJson);
				 // System.out.println(sJson); 
			}else{
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(expensesBeanList);
				  request.setAttribute("expensesList", "''");
			}			
			
			/*if(dayWiseExpenses != null) {
				
				 objectMapper1 =  new ObjectMapper(); 
				  dayWiseJson =objectMapper1.writeValueAsString(dayWiseExpenses);
				   request.setAttribute("dayWiseExpenses", dayWiseJson);
				 // System.out.println(sJson); 
			}else{
				  objectMapper1 =  new ObjectMapper(); 
				 // dayWiseJson =objectMapper1.writeValueAsString(dayWiseJson);
				  request.setAttribute("dayWiseExpenses","''");
			}*/
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in saveLedger class");
		}
		
		return "ledger";
	}
	
	
	@RequestMapping(value = "saveLedger")
	public String saveLedger(@ModelAttribute("ledger") ExpensesBean expensesBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		
		try{
			
			//expensesBean.setAcademicYearId(addAcademicYearDao.getActiveAcademicYearId());
			 ledgerDao.save(expensesBean);
			
			
			/*String message = "null";
			if(expensesBeanList != null) {
				
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(expensesBeanList);
				  //request.setAttribute("dfcListBetweenTwoDates", sJson);
				 // System.out.println(sJson); 
			}else{
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(expensesBeanList);
				  request.setAttribute("dfcList", "''");
			}*/
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in saveLedger class");
		}			
		
		return "redirect:ledger";
	}	
	
	@RequestMapping(value = "/dailyExpensesBetweentwoDate")
	public @ResponseBody  String dailyExpensesBetweentwoDate(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		List<Map<String, Object>> dfcList = null;
		ObjectMapper objectMapper = null;
		String sJson = "";

		String fromDate=request.getParameter("from");
		String toDate= request.getParameter("to");
		
		try{
			dfcList = ledgerDao.dailyExpensesBetweentwoDate(fromDate,toDate);			
			
			String message = "null";
			if(dfcList != null) {
				
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(dfcList);
				  //request.setAttribute("dfcListBetweenTwoDates", sJson);
				 // System.out.println(sJson); 
			}else{
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(dfcList);
				  request.setAttribute("dfcList", "''");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in DFCController class");
		}			
		
		return sJson;
	}
	
	@RequestMapping(value = "/onDateExpensesList")
	public @ResponseBody String onDateExpensesList(HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		List<ExpensesBean> expensesBeanList = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		
		try{
			String fromDate=request.getParameter("onDate");
			expensesBeanList = ledgerDao.getExpensesBeanAll(fromDate);		
			
			if(expensesBeanList != null) {
				
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(expensesBeanList);
				 // request.setAttribute("expensesList", sJson);
				 // System.out.println(sJson); 
			}else{
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(expensesBeanList);
				  //request.setAttribute("expensesList", "''");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in saveLedger class");
		}
		
		return sJson;
	}	

	@RequestMapping(value = "deleteExpens")
	public @ResponseBody String deleteExpens(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		
		try{			
			
			 ledgerDao.delete(request.getParameter("expensId"));			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in deleteExpens class");
		}			
		
		return "deleted";
	}
	
	@ModelAttribute("accountHead")
	public Map<Integer, String> populateStudent() {
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		try {
			String sSql = "select * from accounthead order by name asc";
			List<AddAccountHeadBean> list= usesDao1.populate1(sSql);
			for(AddAccountHeadBean bean: list){
				statesMap.put(bean.getId(), bean.getName());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return statesMap;
	}
}