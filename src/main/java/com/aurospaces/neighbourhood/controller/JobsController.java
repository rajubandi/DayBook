package com.aurospaces.neighbourhood.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aurospaces.neighbourhood.dao.AddCollectionDao;
import com.aurospaces.neighbourhood.util.SendSMS;

@Controller
public class JobsController {
	private Logger logger = Logger.getLogger(JobsController.class);
	
	//@Autowired AddClientsDao addAccountHeadDao;
	@Autowired AddCollectionDao addAccountHeadDao;
	static Map< String,String> hm8 =  new HashMap< String,String>();
	static String phnumber;
	
	//@Autowired
	//UsersDao objUsersDao;
	/*@Autowired UserrequirementDao objUserrequirementDao;
	@Autowired StateDao stateDao;
	 @Autowired CastDao objCastDao;
	@Autowired UserSettingsDao settingsDao;
	 @Autowired	ServletContext objContext;*/
	
	   
	   /*****     back-end jobs    start       ********/
	   //@RequestMapping(value="/weeklyMatchEmails")
	   public String weeklyMatchEmails(){
		  // UsersBean userSessionBean = (UsersBean) session.getAttribute("cacheGuest");
		   /*if(userSessionBean==null)
			   return "redirect:HomePage";*/
		   System.out.println("### in weeklyMatchEmails");
		  // List<Map<String,Object>> activeProfilesList = objUsersDao.getAllSubscribedUsersForWeeklyMatchEmails();
		   //System.out.println("### activeProfilesList:"+activeProfilesList);
		  // String baseUrl = objUsersDao.getBaseUrl(); //"http://localhost:8080/NBD/"
		   //baseUrl += "users";
		  /* if(activeProfilesList != null && activeProfilesList.size()>0){
			   for(Map<String,Object> profile:activeProfilesList){
				   UsersBean receiverBean = new UsersBean();
				   receiverBean.setId((Integer)profile.get("id"));
				   receiverBean.setUsername((String)profile.get("username"));
				   receiverBean.setUnique_code((String)profile.get("unique_code"));
				   Object emailId = profile.get("email");
				   receiverBean.setEmail((String)emailId);
				   List<Map<String,String>> preferredProfiles = objUsersDao.getProfilesFilteredByPreferences(profile);
				   System.out.println("### preferredProfiles size:"+preferredProfiles.size());
				   try{
					   if(preferredProfiles != null && preferredProfiles.size()>0){
						   EmailUtil.sendProfilesListEmail(receiverBean,preferredProfiles, "profiles_list_email",objContext,baseUrl);
						   System.out.println("### matches sent");
					   }
				   }catch(Exception e){
					   e.printStackTrace();
				   }
				   
			   } 
		   }*/
		   
		   
		   return "";
	   }
	   
	 
	   /*****     Not required in current release -- as per client      ************/
	   /*
	   @RequestMapping(value="/dailyMatchEmails")
	   public String dailyMatchEmails(HttpSession session,HttpServletRequest request){
		   List<Map<String,Object>> activeProfilesList = objUsersDao.getAllSubscribedUsersForDailyMatchEmails();
		   for(Map<String,Object> profile:activeProfilesList){
			   UsersBean receiverBean = new UsersBean();
			   receiverBean.setId((Integer)profile.get("id"));
			   receiverBean.setUsername((String)profile.get("username"));
			   receiverBean.setUnique_code((String)profile.get("unique_code"));
			   Object emailId = profile.get("email");
			   receiverBean.setEmail((String)emailId);
			   List<Map<String,String>> preferredProfiles = objUsersDao.getProfilesFilteredByPreferences(profile);
			   try{
				   EmailUtil.sendProfilesListEmail(receiverBean,preferredProfiles, "profiles_list_email",objContext,request);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   
		   }
		   
		   return "";
	   }
	   */
	   
	    /* 
	    * checks the validity of each paid member and updates his status accordingly */
	    
	   //@RequestMapping(value="/checkMembershipValidity")
	   public void checkMembershipValidity(){
		   
		  // int updated_count = objUsersDao.updateMembershipStatusBasedOnValidity();
		   
			  // System.out.println("Membership plan duration completed for:"+updated_count+": members");
		   
		   
	   }
	   
	    /* Total profiles list should be divided equally  among all the employees of aarna matrimony */
	    
	   //@RequestMapping(value="/splitProfilesToEmployees")
	   public String splitProfilesToEmployees(){
		   try{
			  // int free_users_count = objUsersDao.getFreeMembersCount();
			  // List<Map<String, Object>> emp_list = objUsersDao.getEmployeesList();
			   int slot_size = 0;
			  /* if(emp_list!=null && emp_list.size()>0){
				   slot_size = free_users_count/emp_list.size();
			   }
			   int start_index = 1;
			   for(Map<String,Object> emp:emp_list){
				   objUsersDao.updateEmployeeProfilesSlot((Integer)emp.get("id"), start_index, slot_size);
				   start_index += slot_size;
			   }*/
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   
		   
		   return "";
	   }
	   
	   
	   /* To rotate the profiles_slots  among the employees...this script runs every month end.
	     Before running this URL..run 'splitProfilesToEmployees' URL */
	    
	   //@RequestMapping(value="/rotateEmployeesProfilesSlot")
	   public String rotateEmployeesProfilesSlot(){
		   try{
			 //  int free_users_count = objUsersDao.getFreeMembersCount(); 
			  // objUsersDao.rotateEmployeesProfilesSlot(free_users_count);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   
		   
		   return "";
	   }
	   
	   
	    /*
	     * 	    
	   @RequestMapping(value="/createActivityLogDataForOldReqs")
	   public String createActivityLogDataForOldReqs(HttpSession session,HttpServletRequest request){
		   try{
			   List<Map<String,Object>> old_requests = objUsersDao.getOldRequests(); 
			   for(Map<String,Object> req:old_requests){
				   StringBuffer buffer = new StringBuffer("");
					try{
						String status = (String)req.get("status");
						String mobile_no_viewed_status = (String)req.get("mobile_no_viewed_status");
						String message_sent_status = (String)req.get("message_sent_status");
						String message_status = (String)req.get("message_status");
						if(status.equalsIgnoreCase("1")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','interest_request',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						if(status.equalsIgnoreCase("2")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','interest_request',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
							
							buffer = new StringBuffer("");
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','interest_accepted',"+req.get("profile_id")+","+req.get("user_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						if(status.equalsIgnoreCase("3")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','interest_request',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
							
							buffer = new StringBuffer("");
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','interest_rejected',"+req.get("profile_id")+","+req.get("user_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						if(mobile_no_viewed_status.equalsIgnoreCase("1")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','mobile_no_viewed',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						if(message_sent_status.equalsIgnoreCase("1")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','email',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						if(message_status.equalsIgnoreCase("1")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','email',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
							
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','message_accepted',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						if(message_status.equalsIgnoreCase("2")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','email',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
							
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','message_replied',"+req.get("profile_id")+","+req.get("user_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						if(message_status.equalsIgnoreCase("3")){
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','email',"+req.get("user_id")+","+req.get("profile_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
							
							buffer.append("insert into users_activity_log(created_time,activity_type,act_done_by_user_id,act_done_on_user_id) "
									+" values('"+req.get("created_on")+"','message_rejected',"+req.get("profile_id")+","+req.get("user_id")+")");
							objUsersDao.createActivityLogEntry(buffer.toString());
						}
						
						//boolean inserted = objUsersDao.createActivityLogEntry(buffer.toString());
						
					}catch(Exception e){
						e.printStackTrace();
					} 
			   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   
		   
		   return "";
	   }
	   */
	   
	   //@RequestMapping(value="/sendEmails")
	   public String sendEmails(){
		  // EmailUtil.sendEmails(objContext,objUsersDao);
		   return "";
	   }

	   public void accordingToDueDateSendMessage() {
		   
		    List<Map<String, String>> listOrderBeansClientid = null;
			List<Map<String, String>> listOrderBeansClientName = null;			
			List<Map<String, String>> listOrderBeansFullamt = null;
			List<Map<String, String>> listOrderBeansPaidamt = null;	
			List<Map<String, String>> listOrderBeansPhoneNumber = null;
			List<Map<String, String>> listOrderBeansadminphone = null;			
			
			
			ArrayList al = new ArrayList();			
		    Map< Integer,String> hm =  new HashMap< Integer,String>();
			Map< Integer,Integer> hm2 =  new HashMap< Integer,Integer>();
			Map< Integer,Integer> hm3 =  new HashMap< Integer,Integer>();
			Map< Integer,Integer> hm4 =  new HashMap< Integer,Integer>();
			Map< Integer,Object> hm5 =  new HashMap< Integer,Object>();
			Map< Integer,String> hm6 =  new HashMap< Integer,String>();
			Map< String,String> hm7 =  new HashMap< String,String>();
			
			
			List<Map<String, String>> listOrderBeansduedate = null;		
			listOrderBeansduedate = addAccountHeadDao.getDueDate();		
			System.out.println("duedate from collections: " +listOrderBeansduedate);		
			
			String ggg ="";
			int id = 0;
			int dueamt=0 ;		

			listOrderBeansClientid = addAccountHeadDao.getClientIdBasedOnDuedate();		
			System.out.println("clientId from collections: " +listOrderBeansClientid);		
			
			String clntId ="";
			String clntName ="";		
			
			for (Iterator iterator = listOrderBeansClientid.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();				
				clntId = map.get("clntid");	
				System.out.println("ClientId: " +clntId);			
				
				al.add(clntId);
			}
			
			System.out.println("clientId ArrayList : " +al);
			
			for(Object obj : al) {
				
				String ss = (String)obj;			
				id = Integer.parseInt(ss);				
			
				if (id!=0) {
					listOrderBeansClientName = addAccountHeadDao.getClientName(id);
				
					
			System.out.println("clientName from collections: " +listOrderBeansClientName);			
			
			for (Iterator iterator = listOrderBeansClientName.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();				
				clntName = map.get("client");	
				
				hm.put(id, clntName);							
			}	
				}
				
			}
			
			System.out.println("clientName Details Map : " +hm);
			
			for(Object obj : al) {
				
				String ss = (String)obj;			
				id = Integer.parseInt(ss);
			if (id!=0) {
			listOrderBeansFullamt = addAccountHeadDao.getFullAmount(id);
			
			System.out.println("Full amount from clients after getting ID: " +listOrderBeansFullamt);
			
			int fullamt=0 ;
			
			for (Iterator iterator = listOrderBeansFullamt.iterator(); iterator.hasNext();) {
				Map<String, String> map = (Map<String, String>) iterator.next();					
				String famt = map.get("fullamount");					 
				fullamt = Integer.parseInt(famt);
				hm2.put(id, fullamt);				
			}
			}
	}
			System.out.println("client FullAmount Details Map : " +hm2);
			
	for(Object obj : al) {
				
				String ss = (String)obj;			
				id = Integer.parseInt(ss);
			if (id!=0) {
				listOrderBeansPaidamt = addAccountHeadDao.getPaidAmount(id);
				
				System.out.println("Paid amount from clients: " +listOrderBeansPaidamt);				
				int paidamt=0 ;				
				
				for (Iterator iterator = listOrderBeansPaidamt.iterator(); iterator.hasNext();) {
					Map<String, String> map = (Map<String, String>) iterator.next();
					//System.out.println("In for loop: " +map.get("paidamount"));	
					String pamt = map.get("paidamount");					 
					paidamt = Integer.parseInt(pamt);
					hm3.put(id, paidamt);
				}
				
				listOrderBeansPhoneNumber = addAccountHeadDao.getPhoneNumber(id);				
				System.out.println("PhoneNumber from clients: " +listOrderBeansPhoneNumber);			
				
				for (Iterator iterator = listOrderBeansPhoneNumber.iterator(); iterator.hasNext();) {
					Map<String, String> map = (Map<String, String>) iterator.next();						
					String pno = map.get("phoneNumber");					
					hm6.put(id, pno);
				}
				
				
				
				// Returns Set view      
				Set< Map.Entry< Integer,String> > st = hm.entrySet();
			    Set< Map.Entry< Integer,Integer> > st2 = hm2.entrySet();    
			    Set< Map.Entry< Integer,Integer> > st3 = hm3.entrySet();
			    Set< Map.Entry< Integer,Integer> > st4 = hm4.entrySet();

			    for (Map.Entry< Integer,Integer> me:st2) 
			    { 		    	
			    	for (Map.Entry< Integer,Integer> me2:st3) 
			        { 	      		            
			            if (me.getKey() == me2.getKey()) {
			            	dueamt = me.getValue() - me2.getValue();
			            	hm4.put(id, dueamt);						
						}
			        }     	
			        
			    } 	
			    
			    for (Map.Entry< Integer,String> me:st) 
			    { 		    	
			    	for (Map.Entry< Integer,Integer> me2:st2) 
			        { 	
			    		for (Map.Entry< Integer,Integer> me3:st3) 		        
				    { 		    	
				    	for (Map.Entry< Integer,Integer> me4:st4) 
				        { 	
				    		if ((me.getKey() == me2.getKey()) == (me3.getKey() == me4.getKey())) {
				            	
				    			String details =  "Name: " +me.getValue() + " FullAmount: " + me2.getValue() + " PaidAmount: " +me3.getValue() + " DueAmount: " +me4.getValue();
				            	hm5.put(id, details);						
							}
			    
				        }
				    }
			        }
			    }
			    
			    Set< Map.Entry< Integer,Object> > st5 = hm5.entrySet();
			    Set< Map.Entry< Integer,String> > st6 = hm6.entrySet();
			    
			    for (Map.Entry< Integer,Object> me5:st5) 
			    { 		    	
			    	for (Map.Entry< Integer,String> me6:st6) 
			        { 	      		            
			            if (me5.getKey() == me6.getKey()) {	            	
			            	
			            	hm7.put(me6.getValue(), (String)me5.getValue());			            	
						}
			        }     	
			        
			    } 	
			    
			    
			    
				
			}
	}
		System.out.println("client PaidAmount Details Map : " +hm3);
		System.out.println("client DueAmount Details Map : " +hm4);
		System.out.println("client Phone Details Map : " +hm6);
		System.out.println("client Full Details Map : " +hm5);
		System.out.println("client Phone & Full Details Map : " +hm7);
		hm8=hm7;
		System.out.println("hm8 while assigned to hm7  : " +hm8);	
		
		listOrderBeansadminphone = addAccountHeadDao.getPhoneNumberOfAdmin();
		
		System.out.println("Phone number of ADMIN: " +listOrderBeansadminphone);	
		
		for (Iterator iterator = listOrderBeansadminphone.iterator(); iterator.hasNext();) {
			Map<String, String> map = (Map<String, String>) iterator.next();
			String mobile = map.get("mobile");	
			phnumber = mobile;		
		}
			System.out.println("Phone number in dashboard: " +phnumber); 
			
			System.out.println("Trigger Starts in JobController.. "+new Date());
			System.out.println("hm8 value after triggerstarts : " +hm8);
			System.out.println("Phone number after triggerstarts: " +phnumber);	
				
			SendSMS sms = new SendSMS();	
				 
			 if (hm8!=null) {		 
				 
			        Set<Map.Entry<String,String>> set1 = hm8.entrySet(); 	        
			        
			        for (Map.Entry<String,String> me : set1) 
			        {
			            System.out.print(me.getKey() + ": ");
			            System.out.println(me.getValue());
			            
			            sms.sendSMS((String)me.getValue(),phnumber);
			            sms.sendSMS((String)me.getValue(),me.getKey());
						
			        }		 		
			 }			
		
	   }
	   
	   /*****     back-end jobs   end        ********/
}