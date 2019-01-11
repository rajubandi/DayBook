package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
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

import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.BusRouteBean;
import com.aurospaces.neighbourhood.db.dao.BusRouteDao;
import com.aurospaces.neighbourhood.db.dao.BusRouteFeeDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
@Controller
public class BusRouteController {
	@Autowired BusRouteDao busRouteDao;
	@Autowired BusRouteFeeDao busRouteFeeDao;
	@Autowired usersDao1 usesDao1;
	Logger log = Logger.getLogger(BusRouteController.class);
	private Logger logger = Logger.getLogger(BusRouteController.class);
	@RequestMapping(value = "/addBusRoute")
	public String addBusRoute(@ModelAttribute("busRoute") BusRouteBean busRouteBean,ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		//String accountName=null;
		try{
			listOrderBeans = busRouteDao.getBusRoute();
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

		return "addBusRoute";  
	}
	
@RequestMapping(value = "/addBusRouteName")
public String addBusRoute(@ModelAttribute("busRoute") BusRouteBean busRouteBean,ModelMap model,HttpServletRequest request, HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("Home controller...");
	List<Map<String, String>> listOrderBeans = null;
	BusRouteBean listOrderBeans1 = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	try{
		listOrderBeans1 = busRouteDao.existingOrNotName(busRouteBean.getRouteName());
		int id = 0;
		 int dummyId = 0;
			if (listOrderBeans1 != null) {
				dummyId = listOrderBeans1.getId();
			}
			if (busRouteBean.getId() != 0) {
				id = busRouteBean.getId();
				if (id == dummyId || listOrderBeans1 == null) {

					busRouteDao.save(busRouteBean);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
				} else {
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}
			if (busRouteBean.getId() == 0 && listOrderBeans1 == null) {
				busRouteDao.save(busRouteBean);

				redir.addFlashAttribute("msg", "Record Inserted Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			if (busRouteBean.getId() == 0 && listOrderBeans1 != null) {
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
		
		
		listOrderBeans = busRouteDao.getBusRoute();
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

	return "redirect:addBusRoute";  
}

@RequestMapping(value = "/busRouteFee")
public String busRouteFee(@ModelAttribute("busRouteFee") BusRouteBean busRouteBean,ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
	List<Map<String, String>> listOrderBeans = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	//String accountName=null;
	try{
		listOrderBeans = busRouteFeeDao.getBusRouteFees();
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

	return "busRouteFee";  
}

@RequestMapping(value = "/addBusRouteFee")
public String addBusRouteFee(@ModelAttribute("busRouteFee") BusRouteBean busRouteBean,ModelMap model,HttpServletRequest request, HttpSession session,RedirectAttributes redir) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("Home controller...");
	List<Map<String, String>> listOrderBeans = null;
	BusRouteBean listOrderBeans1 = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	try{
		listOrderBeans1 = busRouteFeeDao.existingOrNot(busRouteBean);
		int id = 0;
		 int dummyId = 0;
			if (listOrderBeans1 != null) {
				dummyId = listOrderBeans1.getId();
			}
			if (busRouteBean.getId() != 0) {
				id = busRouteBean.getId();
				if (id == dummyId || listOrderBeans1 == null) {

					busRouteFeeDao.save(busRouteBean);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
				} else {
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}
			if (busRouteBean.getId() == 0 && listOrderBeans1 == null) {
				busRouteFeeDao.save(busRouteBean);

				redir.addFlashAttribute("msg", "Record Inserted Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			if (busRouteBean.getId() == 0 && listOrderBeans1 != null) {
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
		
		
		listOrderBeans = busRouteFeeDao.getBusRouteFees();
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

	return "redirect:busRouteFee";  
}


@RequestMapping(value = "/getBusFee")
public @ResponseBody String getBusFee( ModelMap model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("user controller...");
	String listOrderBeans=null ;
	ObjectMapper objectMapper = null;
	String sJson = "";
	String boardId = null;
	String classId = null;
	String sectionId = null;
	String mediumId = null;
	String routeId = null;
	try{
		boardId = request.getParameter("boardId");
		classId = request.getParameter("classId");
		sectionId = request.getParameter("sectionId");
		mediumId = request.getParameter("mediumId");
		routeId = request.getParameter("routeId");
		if(StringUtils.isNotBlank(boardId) && StringUtils.isNotBlank(classId) && StringUtils.isNotBlank(sectionId) && 
				StringUtils.isNotBlank(mediumId) && StringUtils.isNotBlank(routeId)){
		listOrderBeans = busRouteFeeDao.getBusFee(boardId,classId,sectionId,mediumId,routeId);
		}
		if(listOrderBeans == null) {
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
		logger.fatal("error in userLogin method in BusRouteController class getBusFee method");
	}

	return sJson;  
}

@RequestMapping(value = "/deleteBusRoute")
public @ResponseBody String deleteBusRoute(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
	List<Map<String, String>> listOrderBeans = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	String accountId = null;
	try{
		accountId = request.getParameter("id");
		if(StringUtils.isNotBlank(accountId)){
			busRouteDao.delete(Integer.parseInt(accountId));
			session.setAttribute("rounteNameDeleted", "Successfully Route Name is Deleted");
		}
		listOrderBeans = busRouteDao.getBusRoute();
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
		logger.fatal("error in school BusRouteController class deleteBoard method");
	}

	return sJson;  
}
@RequestMapping(value = "/deleteBusRouteFees")
public @ResponseBody String deleteBusRouteFees(ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
	List<Map<String, String>> listOrderBeans = null;
	ObjectMapper objectMapper = null;
	String sJson = "";
	String accountId = null;
	try{
		accountId = request.getParameter("id");
		if(StringUtils.isNotBlank(accountId)){
			busRouteFeeDao.delete(Integer.parseInt(accountId));		
			session.setAttribute("routeFeeDelete", "Successfully Route Fee is Deleted");
		}
		
		listOrderBeans = busRouteFeeDao.getBusRouteFees();
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
		logger.fatal("error in school BusRouteController class deleteBoard method");
	}

	return sJson;  
}
@ModelAttribute("busRouteNames")
public Map<Integer, String> getBusRouteName() {
	Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
	try {
		String sSql = "select id,routeName from busroute order by routeName asc";
		List<BusRouteBean> list= busRouteDao.getBusRouteName(sSql);
		for(BusRouteBean bean: list){
			statesMap.put(bean.getId(), bean.getRouteName());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
	}
	return statesMap;
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

