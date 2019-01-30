package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.AddAccountHeadBean;
import com.aurospaces.neighbourhood.bean.ExpensesBean;
import com.aurospaces.neighbourhood.dao.ReportsDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

    @Controller
	public class ReportsController {
		@Autowired ServletContext objContext;
		@Autowired ReportsDao reportsDao;
		@Autowired usersDao1 usesDao1;
		private Logger logger = Logger.getLogger(ReportsController.class);
		Date date1,date2;
		
		@RequestMapping(value = "/reports")
		public String reports(@ModelAttribute("reports") ExpensesBean expensesBean,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
			
			List<Map<String, Object>> dfcList1 = null;			
			ObjectMapper objectMapper2 = null;			
			String dataJson="";
			
			try{
				Date toDate = new Date();				
				dfcList1 = reportsDao.reportsdailyExpensesBetweentwoDate(null,null,null,null);
				
				if(dfcList1 != null) {
					
					  objectMapper2 = new ObjectMapper(); 
					  dataJson =objectMapper2.writeValueAsString(dfcList1);
					  request.setAttribute("dataJson", dataJson);
					 // System.out.println(sJson); 
				}else{					 
					  request.setAttribute("dataJson", "''");
				}				
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e);
				logger.error(e);
				logger.fatal("error in saveLedger class");
			}
			
			return "reports";
		}		
		
		@RequestMapping(value = "saveReports")
		public String saveLedger(@ModelAttribute("reports") ExpensesBean expensesBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
			
			try{				
				
				reportsDao.save(expensesBean);					
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e);
				logger.error(e);
				logger.fatal("error in saveLedger class");
			}				
			
			return "redirect:reports";
		}		
		
		@RequestMapping(value = "/reportsdailyExpensesBetweentwoDate")
		public @ResponseBody  String dailyExpensesBetweentwoDate(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
			List<Map<String, Object>> dfcList = null;
			ObjectMapper objectMapper = null;
			String sJson = "";

			String fromDate=request.getParameter("from");
			String toDate= request.getParameter("to");
			String accountHead=request.getParameter("accountHead");
			String month= request.getParameter("monthPicker");
			System.out.println("From value: " +fromDate +" To value: " +toDate +" accounthead value: " +accountHead +" monthpicker value:  " +month );
			try{
				System.out.println("In try block of reports controller....");
				dfcList = reportsDao.reportsdailyExpensesBetweentwoDate(fromDate,toDate,accountHead,month);				
				
				String message = "null";
				if(dfcList != null) {
					System.out.println("In if block of reports controller");
					
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(dfcList);
					  //request.setAttribute("dfcListBetweenTwoDates", sJson);
					 // System.out.println(sJson); 
				}else{
					System.out.println("In else block of reports controller");
					 /* objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(dfcList);*/
					 // request.setAttribute("dfcList", "''");
					return null;
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e);
				logger.error(e);
				logger.fatal("error in DFCController class");
			}				
			
			return sJson;
		}		
		
		@RequestMapping(value = "/reportsBetweentwoDates")
		public @ResponseBody  String dailyFeesCollectionBetweentwoDate(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
			List<Map<String,Object>>  dfcList = null;
			ObjectMapper objectMapper = null;
			String sJson = "";
			
			String fromDate=request.getParameter("from");
			String toDate= request.getParameter("to");
			System.out.println("From value in reportsBetweentwoDates: " +fromDate +" To value in reportsBetweentwoDates: " +toDate);

			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MMMM-yyyy");			
			
			try {				
			
			if (fromDate == null) {
				date1 = new Date();
			}else {
				date1 = formatter1.parse(fromDate);
			}
			
			if (toDate == null) {
				date2 = new Date();
			}else {
				date2 = formatter1.parse(toDate);
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  						
			
			try{				
				
				System.out.println(" In try block From value in reportsBetweentwoDates: " +fromDate +" To value in reportsBetweentwoDates: " +toDate);
				dfcList = reportsDao.reportsBetweenTwoDates(date1,date2);				
				
				if(dfcList != null) {
					
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(dfcList);
					  //request.setAttribute("dfcListBetweenTwoDates", sJson);				 
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
		
		@RequestMapping(value = "/reportsBetweentwoDatesWithAccount")
		public @ResponseBody  String dailyFeesCollectionBetweentwoDateWithAccount(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
			List<Map<String,Object>>  dfcList = null;
			ObjectMapper objectMapper = null;
			String sJson = "";
			List<Map<String, String>> listOrderBeansPaidamt = null;
			
			String fromDate=request.getParameter("from");
			String toDate= request.getParameter("to");
			String accountHead=request.getParameter("accountHead");
			
			System.out.println("From value in reportsBetweentwoDates: " +fromDate +" To value in reportsBetweentwoDates: " +toDate +" accountHead value in reportsBetweentwoDates: " +accountHead);

			listOrderBeansPaidamt = reportsDao.getName(Integer.parseInt(accountHead));
			
			System.out.println("Accounter name  from accounthead after getting ID: " +listOrderBeansPaidamt);
			
			String ggg="";
			
			for (Iterator iterator = listOrderBeansPaidamt.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();
				System.out.println("In for loop getting name: " +map.get("AccounterName"));	
				ggg = map.get("AccounterName");					 
				//paidamt = Integer.parseInt(ggg);
				System.out.println("In for loop2 getting name value: " +ggg);
			}
			
			System.out.println("Outside for loop getting name value: " +ggg);
			
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MMMM-yyyy");			
			
			try {				
			
			if (fromDate == null) {
				//date1 = new Date();
				System.out.println("From date in if: " +fromDate);
			}else {
				System.out.println("From date in else: " +fromDate);
				date1 = formatter1.parse(fromDate);
			}
			
			if (toDate == null) {
				//date2 = new Date();
				System.out.println("To date in if: " +toDate);
			}else {
				System.out.println("To date in else: " +toDate);
				date2 = formatter1.parse(toDate);
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  						
			
			try{				
				
				System.out.println(" In try block From value in reportsBetweentwoDates: " +fromDate +" To value in reportsBetweentwoDates: " +toDate+" accountHead value in reportsBetweentwoDates: " +accountHead);
				dfcList = reportsDao.reportsBetweenTwoDatesWithAccount(date1,date2,ggg);				
				
				if(dfcList != null) {
					
					System.out.println("In if block of reports controller dfclist value: " +dfcList);
					
					  objectMapper = new ObjectMapper(); 
					  sJson =objectMapper.writeValueAsString(dfcList);
					  //request.setAttribute("dfcListBetweenTwoDates", sJson);				 
				}else{
					System.out.println("In else block of reports controller dfclist value: " +dfcList);
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
		
		
		@RequestMapping(value = "/reportsonDateExpensesList")
		public @ResponseBody String onDateExpensesList(HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
			List<ExpensesBean> expensesBeanList = null;
			ObjectMapper objectMapper = null;
			String sJson = "";
			
			try{
				String fromDate=request.getParameter("onDate");
				expensesBeanList = reportsDao.getExpensesBeanAll(fromDate);				
				
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

		@RequestMapping(value = "reportsDeleteExpens")
		public @ResponseBody String deleteExpens(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
			
			try{				
				
				reportsDao.delete(request.getParameter("expensId"));				
				
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