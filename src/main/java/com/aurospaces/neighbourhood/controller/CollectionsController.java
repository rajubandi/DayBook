package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

import com.aurospaces.neighbourhood.bean.ClientDetailsBean;
import com.aurospaces.neighbourhood.bean.CollectionBean;

import com.aurospaces.neighbourhood.dao.AddCollectionDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class CollectionsController {
	@Autowired AddCollectionDao addAccountHeadDao;
	@Autowired usersDao1 usesDao1;
	Map<Integer, String> statesMap1 = new LinkedHashMap<Integer, String>();
	
	@RequestMapping(value = "/collections")
	public String addAccountHead(@ModelAttribute("packCmd") CollectionBean objAddAccountHeadBean,ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		
		try{
			listOrderBeans = addAccountHeadDao.getAccountHaed();
			if(listOrderBeans != null && listOrderBeans.size() > 0) {
				  objectMapper = new ObjectMapper(); 
				  sJson =objectMapper.writeValueAsString(listOrderBeans);
				  request.setAttribute("allOrders1", sJson);
				  //request.setAttribute("showamount", "NotifyMsg");
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

		return "collections";  
	}
	
@RequestMapping(value = "/collectionName")
public String addAccountName(@ModelAttribute("packCmd") CollectionBean objAddAccountHeadBean,ModelMap model,HttpServletRequest request, HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("Home controller...");
	List<Map<String, String>> listOrderBeans = null;
	List<Map<String, String>> listOrderBeansId = null;
	List<Map<String, String>> listOrderBeansPaidamt = null;
	List<Map<String, String>> listOrderBeansFullamt = null;
	
	CollectionBean listOrderBeans1 = null;
	ObjectMapper objectMapper = null;
	String sJson = "";	
	
	try{
		System.out.println("addBoardaddBoardaddBoardaddBoard");
		listOrderBeans1 = addAccountHeadDao.existingOrNot(objAddAccountHeadBean.getDescription());		
		
		int id = 0;
		 int dummyId = 0;
			if (listOrderBeans1 != null) {
				dummyId = listOrderBeans1.getId();
			}
			if (objAddAccountHeadBean.getId() != 0) {
				id = objAddAccountHeadBean.getId();
				if (id == dummyId || listOrderBeans1 == null) {
					
					String selectOptionIntValue = request.getParameter("client");
					int gg = Integer.parseInt(selectOptionIntValue);
					String selectOptionStringValue = statesMap1.get(gg);
					
					/*String createdDate=request.getParameter("date");
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
					Date date1 = formatter.parse(createdDate.toString());
					// now, create a java.sql.Date from the java.util.Date
					java.sql.Date sqlcreatedDate = new java.sql.Date(date1.getTime());*/
					
					listOrderBeansId = addAccountHeadDao.getClientId(selectOptionStringValue);
					
					System.out.println("Id from clients: " +listOrderBeansId);
					
					int clientId=0 ;
					
					for (Iterator iterator = listOrderBeansId.iterator(); iterator.hasNext();) {
						Map<String, String> map = (Map<String, String>) iterator.next();
						System.out.println("In for loop: " +map.get("id"));	
						String ggg = map.get("id");					 
						clientId = Integer.parseInt(ggg);
					}
					
					listOrderBeansPaidamt = addAccountHeadDao.getPaidAmount(clientId);
					
					System.out.println("Paid amount from clients: " +listOrderBeansPaidamt);
					
					int paidamt=0 ;
					
					for (Iterator iterator = listOrderBeansPaidamt.iterator(); iterator.hasNext();) {
						Map<String, String> map = (Map<String, String>) iterator.next();
						System.out.println("In for loop: " +map.get("paidamount"));	
						String ggg = map.get("paidamount");					 
						paidamt = Integer.parseInt(ggg);
					}
					
					listOrderBeansFullamt = addAccountHeadDao.getFullAmount(clientId);
					
					System.out.println("Full amount from clients after getting ID: " +listOrderBeansFullamt);
					
					int fullamt=0 ;
					
					for (Iterator iterator = listOrderBeansFullamt.iterator(); iterator.hasNext();) {
						Map<String, String> map = (Map<String, String>) iterator.next();
						System.out.println("In for loop getting FullAmount: " +map.get("fullamount"));	
						String ggg = map.get("fullamount");					 
						fullamt = Integer.parseInt(ggg);
						System.out.println("In for loop2 fullamt value: " +fullamt);
					}
					
					System.out.println("Outside for loop2 fullamt value: " +fullamt);
					String convertedfullAmt =  String.valueOf(fullamt);
					
					addAccountHeadDao.save(objAddAccountHeadBean,selectOptionStringValue,paidamt,clientId,convertedfullAmt);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
				} else {
					redir.addFlashAttribute("msg", "Already Record Update Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}
			if (objAddAccountHeadBean.getId() == 0 && listOrderBeans1 == null) {
				
				String selectOptionIntValue = request.getParameter("client");
				int gg = Integer.parseInt(selectOptionIntValue);
				String selectOptionStringValue = statesMap1.get(gg);				
				
				/*String createdDate=request.getParameter("date");
				System.out.println("sqlcreateddate in string formate" +createdDate);
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
				
				Date date1 = formatter.parse(createdDate.toString());
				// now, create a java.sql.Date from the java.util.Date
				java.sql.Date sqlcreatedDate = new java.sql.Date(date1.getTime());
				System.out.println("sqlcreateddate in sql" +sqlcreatedDate);*/
				
				listOrderBeansId = addAccountHeadDao.getClientId(selectOptionStringValue);
				
				System.out.println("Id from clients: " +listOrderBeansId);
				
				int clientId=0 ;
				
				for (Iterator iterator = listOrderBeansId.iterator(); iterator.hasNext();) {
					Map<String, String> map = (Map<String, String>) iterator.next();
					System.out.println("In for loop getting ID: " +map.get("id"));	
					String ggg = map.get("id");					 
					clientId = Integer.parseInt(ggg);
				}
				
				listOrderBeansPaidamt = addAccountHeadDao.getPaidAmount(clientId);
				
				System.out.println("Paid amount from clients after getting ID: " +listOrderBeansPaidamt);
				
				int paidamt=0 ;
				
				for (Iterator iterator = listOrderBeansPaidamt.iterator(); iterator.hasNext();) {
					Map<String, String> map = (Map<String, String>) iterator.next();
					System.out.println("In for loop getting PaidAmount: " +map.get("paidamount"));	
					String ggg = map.get("paidamount");					 
					paidamt = Integer.parseInt(ggg);
					System.out.println("In for loop2 paidamt value: " +paidamt);
				}
				
				System.out.println("Outside for loop paidamt value: " +paidamt);
				
				listOrderBeansFullamt = addAccountHeadDao.getFullAmount(clientId);
				
				System.out.println("Full amount from clients after getting ID: " +listOrderBeansFullamt);
				
				int fullamt=0 ;
				
				for (Iterator iterator = listOrderBeansFullamt.iterator(); iterator.hasNext();) {
					Map<String, String> map = (Map<String, String>) iterator.next();
					System.out.println("In for loop getting FullAmount: " +map.get("fullamount"));	
					String ggg = map.get("fullamount");					 
					fullamt = Integer.parseInt(ggg);
					System.out.println("In for loop2 fullamt value: " +fullamt);
				}
				
				System.out.println("Outside for loop2 fullamt value: " +fullamt);
				
				int dueAmount = fullamt - paidamt;
				
				String notifyMsg = "FullAmount: "+fullamt +" PaidAmount: " +paidamt +" DueAmount:" +dueAmount ;
				
				//session.setAttribute("message", notifyMsg);
				String convertedfullAmt =  String.valueOf(fullamt);
				
				addAccountHeadDao.save(objAddAccountHeadBean,selectOptionStringValue,paidamt,clientId,convertedfullAmt);

				redir.addFlashAttribute("msg", "Record Inserted Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			if (objAddAccountHeadBean.getId() == 0 && listOrderBeans1 != null) {
				redir.addFlashAttribute("msg", "Already Record Insert Exist");
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

	return "redirect:collections";  
}

@RequestMapping(value = "/deleteCollection")
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

@ModelAttribute("client")
public Map<Integer, String> populateStudent() {
	Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
	try {
		String sSql = "select * from clients order by clientName asc";
		List<ClientDetailsBean> list= usesDao1.populateClient(sSql);
		for(ClientDetailsBean bean: list){
			statesMap.put(bean.getId(), bean.getClientName());
		}
				
				statesMap1 = statesMap;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
	}
	return statesMap;
}

@RequestMapping(value = "/getAmountData")
public @ResponseBody String getAmountData(@ModelAttribute("packCmd") CollectionBean objAddAccountHeadBean, ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
	
	List<Map<String, String>> listOrderBeansPaidamt = null;
	List<Map<String, String>> listOrderBeansFullamt = null;
	
	int clientid = Integer.parseInt(request.getParameter("clientid"));
	System.out.println("Client Id in Onchange() in getAmountData(): " +clientid);

	List<Map<String, String>> listOrderBeans = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	String sJson2 = "";
	
	try{
		listOrderBeans = addAccountHeadDao.getAccountHaed();
		if(listOrderBeans != null && listOrderBeans.size() > 0) {
			
			listOrderBeansPaidamt = addAccountHeadDao.getPaidAmount(clientid);			
			System.out.println("Paid amount from clients: " +listOrderBeansPaidamt);
			
			int paidamt=0 ;
			
			for (Iterator iterator = listOrderBeansPaidamt.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();
				System.out.println("In for loop PaidAmount value: " +map.get("paidamount"));	
				String ggg = map.get("paidamount");					 
				paidamt = Integer.parseInt(ggg);
			}
			
			listOrderBeansFullamt = addAccountHeadDao.getFullAmount(clientid);
			
			System.out.println("Full amount from clients after getting ID: " +listOrderBeansFullamt);
			
			int fullamt=0 ;
			
			for (Iterator iterator = listOrderBeansFullamt.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();
				System.out.println("In for loop getting FullAmount: " +map.get("fullamount"));	
				String ggg = map.get("fullamount");					 
				fullamt = Integer.parseInt(ggg);
				System.out.println("In for loop2 fullamt value: " +fullamt);
			}
			
			System.out.println("Outside for loop2 fullamt value: " +fullamt);
			
			int dueAmount = fullamt - paidamt;
			System.out.println("Dueamt value: " +dueAmount);
			
			String notifyMsg = "FullAmount: "+fullamt +" PaidAmount: " +paidamt +" DueAmount:" +dueAmount ;
			
			
			
			  objectMapper = new ObjectMapper(); 
			  sJson =objectMapper.writeValueAsString(listOrderBeans);
			  request.setAttribute("allOrders1", sJson);
			  
			  sJson2 =objectMapper.writeValueAsString(notifyMsg);
			  //request.setAttribute("showamount", notifyMsg);
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

	return sJson2;  
}

@RequestMapping(value = "/getDueAmount")
public @ResponseBody String getDueAmount(@ModelAttribute("packCmd") CollectionBean objAddAccountHeadBean, ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
	
	List<Map<String, String>> listOrderBeansPaidamt = null;
	List<Map<String, String>> listOrderBeansFullamt = null;
	
	int clientid = Integer.parseInt(request.getParameter("clientid"));	
	System.out.println("Client Id in OnSubmit() in getDueAmount(): " +clientid);
	
	int currentpaidAmt = Integer.parseInt(request.getParameter("paidamount"));
	System.out.println("currentpaidAmt in Onsubmit() in getDueAmount(): " +currentpaidAmt);	

	List<Map<String, String>> listOrderBeans = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	String sJson2 = "";
	
	try{
		listOrderBeans = addAccountHeadDao.getAccountHaed();
		if(listOrderBeans != null && listOrderBeans.size() > 0) {
			
			listOrderBeansPaidamt = addAccountHeadDao.getPaidAmount(clientid);			
			System.out.println("Paid amount from clients: " +listOrderBeansPaidamt);
			
			int paidamt=0 ;
			
			for (Iterator iterator = listOrderBeansPaidamt.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();
				System.out.println("In for loop PaidAmount value: " +map.get("paidamount"));	
				String ggg = map.get("paidamount");					 
				paidamt = Integer.parseInt(ggg);
			}
			
			listOrderBeansFullamt = addAccountHeadDao.getFullAmount(clientid);
			
			System.out.println("Full amount from clients after getting ID: " +listOrderBeansFullamt);
			
			int fullamt=0 ;
			
			for (Iterator iterator = listOrderBeansFullamt.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();
				System.out.println("In for loop getting FullAmount: " +map.get("fullamount"));	
				String ggg = map.get("fullamount");					 
				fullamt = Integer.parseInt(ggg);
				System.out.println("In for loop2 fullamt value: " +fullamt);
			}
			
			System.out.println("Outside for loop2 fullamt value: " +fullamt);
			
			int dueAmount = fullamt - (paidamt + currentpaidAmt);
			System.out.println("Dueamt value in int: " +dueAmount);
			
			String notifyMsg = "FullAmount: "+fullamt +" PaidAmount: " +paidamt +" DueAmount:" +dueAmount ;
			
			
			
			  objectMapper = new ObjectMapper(); 
			  sJson =objectMapper.writeValueAsString(listOrderBeans);
			  request.setAttribute("allOrders1", sJson);
			  
			  sJson2 =objectMapper.writeValueAsString(dueAmount);
			  System.out.println("Dueamt value in string: " +sJson2);
			  //request.setAttribute("showamount", notifyMsg);
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

	return sJson2;  
}

}