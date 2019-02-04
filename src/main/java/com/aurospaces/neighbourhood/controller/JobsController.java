package com.aurospaces.neighbourhood.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aurospaces.neighbourhood.dao.AddClientsDao;

@Controller
public class JobsController {
	private Logger logger = Logger.getLogger(JobsController.class);
	
	@Autowired AddClientsDao addAccountHeadDao;
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

		
		
	}
	   
	   /*****     back-end jobs   end        ********/
}
