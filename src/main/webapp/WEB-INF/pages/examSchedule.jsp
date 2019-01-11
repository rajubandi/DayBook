<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="js/moment.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script type="text/javascript" src="js/examSchedule.js"></script>
	<link href="css/datepicker1.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" />
	
	<script src="http://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<!-- <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/> -->
<!-- <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>	 -->

<!-- jQuery timepicker library -->
<!-- <link href="css/jquery.timepicker.min.css"> -->
<script src="js/jquery.timepicker.min.js"></script>
<script src="js/jquery-ui-timepicker-addon.js"></script>

		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">Exam Schedule</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
					<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Configurations</a></li>
		<li><a href="#">Exam Schedule</a></li>
	    </ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Exam Schedule</h4>
					</div>
					<div class="panel-body collapse in">
					<!-- Spacer starts -->
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:form action="SaveExamSchedule" commandName="examSchedule" method="post" class="form-horizontal" id="schedule-form">
										<div class="row">
<!-- 										<input id="checkAllStudents"    class='checkAllStudents'    type='checkbox'/>&nbsp; Get All Students -->
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Board Name<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="boardId"  tabindex="1" onchange="selectOrders(),classNameFilter()" class="validate form-control" required="true">
															<form:option value="">-- Choose Board --</form:option>
															<form:options items="${board}"></form:options>
														</form:select>
														<span class="boardName_error" id="boardName_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Class<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="classId" tabindex="2" onchange="selectOrders(),sectionFilter()" class="validate form-control" required="true">
															<form:option value="">-- Choose Class --</form:option>
<%-- 															<form:options items="${allClasses}"></form:options> --%>
														</form:select>
														<span class="className_error" id="className_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Section<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="sectionId" tabindex="3" onchange="selectOrders(),mediumFilter()" class="validate form-control" required="true">
															<form:option value="">-- Choose Section --</form:option>
<%-- 															<form:options items="${allSection}"></form:options> --%>
														</form:select>
														<span class="section_error" id="section_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Medium<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="medium" tabindex="4" onchange="selectOrders()" class="validate form-control" required="true">
															<form:option value="">-- Choose Medium --</form:option>
<%-- 															<form:options items="${mediam}"></form:options> --%>
														</form:select>
														<span class="medium_error" id="medium_error"></span>
													</div>
												</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												  <label class="col-sm-4 control-label">Exam Type<span style="color: red;">*</span></label>
												  <div class="col-sm-5">
													 <form:select path="examTypeId" 	class="form-control validate"  ><%-- onchange= "getExamPatternList();" --%> 
														 <form:option value="">-- Exam Type --</form:option>
														 <form:options items="${examType}"></form:options>
													
													</form:select>
												 </div>
											  </div>
											</div>
												
										</div>
										
											
											<form:hidden path="id" tabindex="1" />
											<div  id="subjectDiv"></div>
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="button" id="getSchedule" value="Get Schedule" class="btn btn-success"/>
													<input type="button" id="getSubjects" value="Get Subjects" class="btn btn-success"/>
													<input type="submit" id="createSchedule" value="Save Schedule" class="btn btn-success"/>
													<button type="button" class="btn btn-danger" id="cancel" >Reset</button>
												</div>
											</div>
											
											
										</form:form>
										<!-- <input type="button" value="selectAll" id="selectAll"> -->
									</div>
								</div>
							</div>
						</div>
						<!-- Row Ends -->
						
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="blog">
									<!-- <div class="blog-header">
										<h5 class="blog-title">Send Message/Email</h5>
									</div> -->
									<div class="blog-body">
													<%
														String message = null;
														message=(String)session.getAttribute("message");
												        if(message!=null)
												        {
															out.println("<span id='smsConfirmation' class='text-center' style='color: red;'>"+message+"</span>");
															session.setAttribute("message", null);
														}
											        %>
										<div id="filterId">
																						
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
														<input id="checkAll" class='checkall' name="fromAllStudent" type='checkbox'/>&nbsp; Select All
													<div id="basicTable">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info" style="width: 100%;">
															<thead>
																<tr role="row">
																	<th>#</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Adm. no</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Gender</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Father</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Email</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Address</th>
																</tr>
															</thead>
															<tbody>
																
															</tbody>
														</table>
													</div>
													</div>
												</div>
											</div>
										</div>
							
										<div class="row">
											<span class="studentId_error" id="studentId_error" style="color: red;margin: 0px;display: block !important;position: absolute;margin-left: 1em;"></span>
												
												<br><br><br>
												<div class="form-group">
											    	<label for="inputEmail3" class="col-sm-4 col-xs-4 control-label" style="text-align: right;">Message: </label>
											    	<div class="col-sm-8 col-xs-8">
														<textarea id="messageId" class="form-control" placeholder="Please Enter Message" style="margin: 0px;height: 75px;" required></textarea>
														<span class="messageId_error" id="messageId_error" style="color: red;"></span>
										            </div>
												</div>
												<br><br><br><br><br>
												
												<div class="clearfix"></div>
												<br>
												<div class="form-group">
											    	<label for="inputEmail3" class="col-sm-4 col-xs-4 control-label" style="text-align: right;">Notify Type: </label>
											    	<div class="col-sm-8 col-xs-8">
														<select id="notificatinId" class="form-control" required="required">
															<option value="">-- Select Notify Type --</option>
															<option value=1>SMS</option>
															<option value=2>Email</option>
															<option value=3>SMS+Email</option>
														</select>
														<span class="notificatinId_error" id="notificatinId_error" style="color: red;"></span>
										            </div>
												</div>
												<br><br><br>
												<div class="clearfix"></div>
												<div class="form-group">
    												<div class="col-sm-8 col-sm-offset-4 col-xs-offset-4">
														<input type="button" id="sendBtn" class="btn btn-info" value="Send" onclick="sendNotification()">
														<input type="button" class="btn btn-danger" id="cancel" value="Cancel" onclick="cancelForm()" >
													</div>
												</div>
											</div>
											
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Row Ends -->
						
					</div>
					<!-- Spacer ends -->

				</div>
				<!-- Container fluid ends -->

			</div>
			<!-- Main Container ends -->

		<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->

<script type="text/javascript">
 $( document ).ready(function() {
	 
	 
	 $("#filterId").hide();
	 $("#createSchedule").hide();
	 
	/* var listOrders1 = ${ExamScheduleList};
	if (listOrders1 != null) {
		//displayTable(listOrders1);
		
		displayExamScheduleListTable(listOrders1);
	
	} */
	
	//selectOrders();
	
}); 

var getTabName = window.location.pathname.split('/')[2];
$("#conf_li").addClass('active');
$("#conf_li ul").css('display','block');
$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');

$("#checkAll").change(function () {
	//$("input:checkbox").prop('checked', $(this).prop("checked"));
	$("input[name='checkboxName']").prop('checked', $(this).prop("checked"));
	var len=$("[name='checkboxName']:checked").length;
	/* if(len!=0)
	{
		$('#delbtn').show();
	}
	else
	{
		$('#delbtn').hide();
	} */
});

/* $("#checkAllStudents").change(function(){
	
	if($(this).prop("checked") == true){
		
				
		selectOrders();	
		//$("input[name='checkboxName']").prop('checked', $(this).prop("checked"));
		$("#checkAll").prop("checked",true).trigger('change');
		//$("#basicTable input[name='checkboxName']").prop('checked',true);
			
	}else{
		$('#basicTable').html('');
		$("#filterId").hide();
	}
	
});
 */

</script>
