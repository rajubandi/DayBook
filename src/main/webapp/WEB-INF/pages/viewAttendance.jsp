<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


	
	<link href="css/datepicker1.css" rel="stylesheet">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/viewAttendance.js"></script>
	
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">View Attendance</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Message</a></li>
		<li><a href="#">View Attendance</a></li>
	    </ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>View Attendance</h4>
					</div>
					<div class="panel-body collapse in">
					<!-- Spacer starts -->
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								
										<form:form  commandName="packCmd" method="post" class="form-horizontal" id="student-form" >
										<div class="row">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">	
											  	<div class="form-group">
											    	<label for="inputEmail3" class="col-sm-4 control-label">Student Name</label>
											    	<div class="col-sm-5">
														<form:input path="name" placeholder="Enter Student Name" class="form-control onlyCharacters" tabindex="1" />
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
											    	<label for="inputPassword3" class="col-sm-4 control-label">Board</label>
											    	<div class="col-sm-5">
														<form:select path="boardName" class="form-control" tabindex="2" onchange="searchStudent(),classNameFilter()" >
															<form:option value="" >-- Choose Board --</form:option>
															<form:options items="${board}"></form:options>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Class</label>
												    <div class="col-sm-5">
														<form:select path="className" class="form-control" tabindex="3" onchange="searchStudent(),sectionFilter()" >
															<form:option value="" >-- Choose Class --</form:option>
<%-- 															<form:options items="${allClasses}"></form:options> --%>
														</form:select>
													</div>
												</div>
											</div>
									
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Section</label>
												    <div class="col-sm-5">
														<form:select path="section" class="form-control" tabindex="4"  onchange="searchStudent(),mediumFilter()">
															<form:option value="">-- Choose Section --</form:option>
<%-- 															<form:options items="${allSection}"></form:options> --%>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Medium</label>
												    <div class="col-sm-5">
														<form:select path="medium" tabindex="5" onchange="searchStudent();" class="form-control">
															<form:option value="">-- Choose Medium --</form:option>
<%-- 															<form:options items="${mediam}"></form:options> --%>
														</form:select>
														<span class="medium_error" id="medium_error"></span>
													</div>
												</div>
												<form:hidden path="id" />
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">From (date):</label>
												    <div class="col-sm-5">
														<input data-format="dd-MM-yyyy" placeholder="Select from Date" class="form-control" id="dob1" type="text" tabindex="6" readonly="readonly">
														<span class="dob1_error" id="dob1_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">To (date):</label>
												    <div class="col-sm-5">
														<input data-format="dd-MM-yyyy" placeholder="Select to Date" class="form-control" id="dob2" type="text" tabindex="7" readonly="readonly">
														<span class="dob2_error" id="dob2_error"></span>
													</div>
												</div>
												<form:hidden path="id" />
											</div>
										</div>
										<div class="row">
											<div class="col-sm-8 col-sm-offset-5">
											  	<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-2">
														<input type="button" class="btn btn-success" value="Search" onclick="searchStudent()" tabindex="8"/>
<!-- 														<input type="reset" class="btn btn-danger" id="cancel" value="Reset" tabindex="9"/> -->
														<a href="viewAttendanceHome" class="btn btn-danger" tabindex="9">Cancel</a>
													</div>
											   	</div>
											 </div>
										</div>
										</form:form>
										</div>
									</div> 
								</div>
							</div>
						<!-- Row Ends -->
						
						<!-- Row Starts -->
						<div class="row gutter">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Students Attendance List</h4>
					</div>
					<div class="panel-body collapse in">
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
													<div id="basicTable">
 														<table id="basicExample" style='width: -moz-max-content;min-width:500px;' class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Class</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Section</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Message</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Attendance<br>(AM | PM)</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Absent on</th>
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

		</div>
		<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

$( document ).ready(function() {
	$("#filterId").hide();
	
	
	var getTabName = window.location.pathname.split('/')[2];
	$("#mes_li").addClass('active');
	$("#mes_li ul").css('display','block');
	$("#mes_li ul li a[href='"+ getTabName +"']").addClass('subactive');

	
});

	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}

	

</script>
