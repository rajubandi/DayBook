<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<script type="text/javascript" src="js/facultyAddStudent.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<style>
	.main-container {
    position: relative;
    padding: 0;
    min-height: 100%;
    margin: 0;
    overflow-x: hidden;
}
	.panel-default {
overflow-x:hidden;}
	</style>
	<link href="css/datepicker1.css" rel="stylesheet">
<!-- 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>

<!-- 	<script src="js/chosen.jquery.js"></script> -->
<div class="loadingajax" id="loadAjax" style="display:none"></div>

		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Add Student</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Student Details</a></li>
		<li><a href="#">Add Student</a></li>
	</ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Add Students</h4>
					</div>
					<div class="panel-body collapse in">
					<!-- Spacer starts -->
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							
										<form:form action="facultyAddStudent.htm" commandName="facultyAddStudent" method="post" class="form-horizontal" id="student-form" enctype="multipart/form-data">
											
										<div class="row">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Student Name <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="name" placeholder="Student Name" class="form-control validate onlyCharacters" tabindex="1" required="true"/>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Gender <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="gender"  class="form-control" required="true">
															<form:option value="">-- Choose Gender --</form:option>
															<form:option value="Male"> Male</form:option>
															<form:option value="Female">Female</form:option>
														</form:select>
														<span class="gender_error" id="gender_error"></span>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Father Name <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="fatherName" placeholder="Father Name" class="form-control onlyCharacters"  required="true"/>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Mobile <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="mobile" placeholder="Contact Number" class="form-control numericOnly" maxlength="10" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Date of Birth <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="dob1" data-format="dd-MM-yyyy" placeholder="Date of Birth" class="form-control validate"  required="true" readonly="true" onfocus="removeBorder(this.id)" />
														<span class="dob1_error" id="dob1_error"></span>
													</div>
											  	</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label  class="col-sm-4 control-label ">Aadhar Number <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="adharNumber" placeholder="Aadhar Card Number" class="form-control  validate numericOnly nospecialCharacter"  maxlength="16" required="true"/>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Email</label>
												    <div class="col-sm-5">
														<form:input path="email" placeholder="Email-Id" class="form-control" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Admission Date <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="admissionDate" data-format="dd-MM-yyyy" placeholder="AdmissionDate Date" class="form-control validate"  required="true" readonly="true" onfocus="removeBorder(this.id)" />
														<span class="admissionDate_error" id="dob1_error"></span>
													</div>
											  	</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
											    	<label for="inputPassword3" class="col-sm-4 control-label">Board Name <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="boardName" class="form-control validate" tabindex="2" onchange="classNameFilter(), getFee();" required="true">
															<form:option value="" >-- Choose Board --</form:option>
															<form:options items="${board}"></form:options>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Class <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="className" class="form-control" tabindex="3" onchange="sectionFilter(), getFee();" required="true">
															<form:option value="">-- Choose Class --</form:option>
<%-- 															<form:options items="${allClasses}"></form:options> --%>
														</form:select>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Section <span style="color: red;">*</span></label>
										    <div class="col-sm-5">
														<form:select path="section" class="form-control" tabindex="4"  onchange="mediumFilter(), getFee();" quired="true">
															<form:option value="">-- Choose Section --</form:option>
<%-- 															<form:options items="${allSection}"></form:options> --%>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
											    	<label for="inputPassword3" class="col-sm-4 control-label">Medium <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="medium" class="form-control" tabindex="5" onchange="getFee();" required="true">
															<form:option value="">-- Choose Medium --</form:option>
<%-- 															<form:options items="${mediam}"></form:options> --%>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label ">Admission No. <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="admissionNum" placeholder="Admission Number" class="form-control  validate1 nospecialCharacter"  required="true" readonly="readonly"/>
													</div>
											  	</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Accommodation<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="acomitation" tabindex="21" class="form-control">
															<form:option value="">-- Choose Accommodation --</form:option>
															<form:option value="Hostel">Hostel</form:option>
															<form:option value="Day-Scholar">Day-Scholar</form:option>
														</form:select>
													</div>
											  	</div>
											</div>
										
										
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="divBuspesility">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Bus Facility<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="buspesility"  class="form-control" >
															<form:option value="">-- Choose Bus Facility --</form:option>
															<form:option value="Yes"> Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="busRouteDiv">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Bus Route</label>
												    <div class="col-sm-5">
														<form:select path="busroute"  class="form-control" onchange="getBusFee();" >
															<form:option value="" >-- Choose Route --</form:option>
															<form:options items="${busRoute}"></form:options>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="totalFee" placeholder="Fee Amount" class="form-control numericOnly"  readonly="true" />
													</div>
											  	</div>
											</div>
										
											<%-- <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
											   	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Discount </label>
												    <div class="col-sm-8">
														<form:input path="discountFee1" placeholder="Enter Discount Fee Amount" class="form-control numericOnly" tabindex="7"/>
													</div>
											  	</div>
											</div> --%>
											<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Roll Number</label>
												    <div class="col-sm-5">
														<form:input path="rollNum" placeholder="Roll Number" class="form-control nospecialCharacter" tabindex="8"/>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Admission No. <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="admissionNum" placeholder="Admission Number" class="form-control nospecialCharacter" tabindex="9" required="true"/>
													</div>
											  	</div>
											</div>
									
 --%>									
											
											<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Alternative Mobile</label>
												    <div class="col-sm-5">
														<form:input path="alternativeMobile" placeholder="Alternate Contact Number" class="form-control numericOnly" tabindex="12"/>
													</div>
											  	</div>
											</div> --%>
										
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Email</label>
												    <div class="col-sm-5">
														<form:input path="email" placeholder="Email-Id" class="form-control" />
													</div>
											  	</div>
											</div>
											<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Blood Group</label>
												    <div class="col-sm-5">
														<form:select path="blodgroup" tabindex="14" class="form-control">
															<form:option value="">-- Choose Blood Group --</form:option>
															<form:option value="A+">A+</form:option>
															<form:option value="B+">B+</form:option>
															<form:option value="O+">O+</form:option>
															<form:option value="AB+">AB+</form:option>
															<form:option value="A-">A-</form:option>
															<form:option value="B-">B-</form:option>
															<form:option value="O-">O-</form:option>
															<form:option value="AB-">AB-</form:option>
														</form:select>
													</div>
											  	</div>
											</div> --%>
											
									
									
											<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Date of Birth <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="dob1" data-format="dd-MM-yyyy" placeholder="Date of Birth" class="form-control" tabindex="16" required="true" readonly="true"/>
														<span class="dob1_error" id="dob1_error"></span>
													</div>
											  	</div>
											</div> --%>
											<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Religion</label>
												    <div class="col-sm-5">
														<form:select path="religion" tabindex="17" class="form-control">
															<form:option value="">-- Choose Religion --</form:option>
															<form:option value="Hindu">Hindu</form:option>
															<form:option value="Muslim">Muslim</form:option>
															<form:option value="Christian">Christian</form:option>
															<form:option value="Sikh">Sikh</form:option>
															<form:option value="Jain">Jain</form:option>
															<form:option value="Parsi">Parsi</form:option>
															<form:option value="Buddhist">Buddhist</form:option>
															<form:option value="Jewish">Jewish</form:option>
														</form:select>
													</div>
											  	</div>
											</div> 
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Address <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="address" placeholder="Address" class="form-control" tabindex="18" required="true"/>
													</div>
											  	</div>
											</div>
									
									
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Previous Institute</label>
												    <div class="col-sm-5">
														<form:input path="previousInstitue" placeholder="Previous Institute Name" class="form-control  onlyCharacters" tabindex="19" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Caste</label>
												    <div class="col-sm-5">
														<form:select path="caste" tabindex="20" class="form-control">
															<form:option value="">-- Choose Caste --</form:option>
															<form:option value="OC">OC</form:option>
															<form:option value="BC">BC</form:option>
															<form:option value="SC/ST">SC/ST</form:option>
															<form:option value="OBC">OBC</form:option>
															<form:option value="Others">Others</form:option>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Accommodation<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="acomitation" tabindex="21" class="form-control">
															<form:option value="">-- Choose Accommodation --</form:option>
															<form:option value="Hostel">Hostel</form:option>
															<form:option value="Day-Scholar">Day-Scholar</form:option>
														</form:select>
													</div>
											  	</div>
											</div>
										
										
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="divBuspesility">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Bus Facility<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="buspesility" tabindex="22" class="form-control" >
															<form:option value="">-- Choose Bus Facility --</form:option>
															<form:option value="Yes"> Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="busRouteDiv">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Bus Route</label>
												    <div class="col-sm-5">
														<form:input path="busroute" placeholder="Bus Route" class="form-control" tabindex="23" />
													</div>
											  	</div>
											</div>
												<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Admission Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="admissionFee" placeholder="Admission Fee"  class="form-control numericOnly" tabindex="6" />
													</div>
											  	</div>
											</div>
											
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Tuition Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="tutionFee" placeholder="Tuition Fee"  class="form-control numericOnly" tabindex="6" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="transportationDiv">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Transportation Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="transportationFee" placeholder="Transportation Fee"  class="form-control numericOnly" tabindex="6" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="hostleDiv">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Hostel Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="hostelFee" placeholder="Hostel Fee" class="form-control numericOnly" tabindex="6" />
													</div>
											  	</div>
											</div>
										
										
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Stationary Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="stationaryFee" placeholder="Stationary Fee" class="form-control numericOnly" tabindex="6" />
													</div>
											  	</div>
											</div>
												<div class="clearfix"></div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
											    	<label for="inputEmail3" class="col-sm-4 control-label">Student Image</label>
											    	<div class="col-sm-5">
														<img id="blah" src='upload/default.png' alt="Student Image" align="middle" style="border-style: solid;height: 100px;width: 100px;border-bottom-style: none;border-left-style: none;border-top-style: none;">
														<input type="file" name="imageName" tabindex="24" id="imageName" onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])" accept="image/jpg,image/png,image/jpeg,image/gif">
											    	</div>
											  	</div>
											</div>
										</div>
										--%>
											<div class="col-sm-8 col-sm-offset-5">
												<form:hidden path="id" /><br>
											  	<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-2">
														<input type="submit" id="submitId" class="btn btn-success" value="Register" tabindex="25"/>
														<input type="button" class="btn btn-danger" id="cancel" value="Reset" tabindex="26"/>
													</div>
											  	</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-8 col-sm-offset-4">
												<div class="form-group">
													<div class="col-sm-8 col-sm-offset-2">
													<%
														String message = null;
														message=(String)session.getAttribute("message");
												        if(message!=null)
												        {
															out.println("<span class='animated fadeOut' style='animation-iteration-count:1;animation-duration:8s;color: red;'>"+message+"</span>");
															session.setAttribute("message", null);
														}
											        %>
													</div>
												</div>
											</div>
										</div>
										</form:form>
					
									</div>
									<div id="showData" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<input type ="hidden" value="${baseUrl }" id="baseUrl1">
									</div>
								</div>
							</div>
						<!-- Row Ends -->
						
						<!-- Row Starts -->
						<div class="row gutter" id="view_list1">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-info">
					<div class="panel-heading">
							<h4>List of Students
										&nbsp;&nbsp;
											<button type="button" id="delbtn" onclick="multipledeleteStudent()" style="display: none;border: none;"><i class="fa fa-trash" style="color: red;"></i></button>
										</h4>
					</div> 
					<div class="panel-body collapse in">
								<!-- <div class="blog">
									<div class="blog-header">
										<h4>List of Students
										&nbsp;&nbsp;
											<button type="button" id="delbtn" onclick="multipledeleteStudent()" style="display: none;border: none;"><i class="fa fa-trash" style="color: red;"></i></button>
										</h4>
									</div> 
									<div class="blog-body">-->
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
<!-- 																	<th><input id="checkAll" class='checkall' type='checkbox'/></th> -->
																	<th class="sorting" style="width: 10px;" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">S.No</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Father Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Mobile Number</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Image</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Admission No.</th>
<!-- 																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th> -->
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Class</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>
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
						<!-- Row Ends -->
			
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

$(function(){
	var nextaddmissionnumber=0;
	nextaddmissionnumber =	'0'+${admissionNum};
	$("#admissionNum").val(nextaddmissionnumber);
	 //$('#admissionNum').attr("disabled", true); 
	 /* $('#admissionFee').attr("disabled", true); 
	 $('#tutionFee').attr("disabled", true); 
	 $('#transportationFee').attr("disabled", true); 
	 $('#hostelFee').attr("disabled", true); 
	 $('#stationaryFee').attr("disabled", true); 
	 $('#totalFee').attr("disabled", true);  */
	 
	$("#admissionNum").prop("readonly", true);
	$("#admissionFee").prop("readonly", true);
	$("#tutionFee").prop("readonly", true);
	$("#transportationFee").prop("readonly", true);
	$("#hostelFee").prop("readonly", true);
	$("#stationaryFee").prop("readonly", true);
	$("#totalFee").prop("readonly", true);
	
});
var baseUrl2 =$("#baseUrl1").val();

var listOrders1 = ${allOrders1};
if (listOrders1 != "") {
	displayTable(listOrders1);
}

var getTabName = window.location.pathname.split('/')[2];
$("#stu_li").addClass('active');
$("#stu_li ul").css('display','block');
$("#stu_li ul li a[href='"+ getTabName +"']").addClass('subactive');
</script>
