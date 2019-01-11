<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<script type="text/javascript" src="js/student1.js"></script>
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


/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #eef3f8;
    background-color: #eef3f8;
    margin-top:10px;
}

/* Style the buttons inside the tab */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 8px 16px;
    transition: 0.3s;
    font-size: 13px;
    font-weight: 400;
    letter-spacing: .5px;
}
.tabcontent {
	margin-top:30px;
}
/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #13353f;
    color:#fff;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #005c77;
    color: #fff;
}

/* Step Bar Start */

.steps-form-2 {
    display: table;
    width: 100%;
    position: relative; }
.steps-form-2 .steps-row-2 {
    display: table-row; }
.steps-form-2 .steps-row-2:before {
    top: 14px;
    bottom: 0;
    position: absolute;
    content: " ";
    width: 100%;
    height: 2px;
    background-color: #7283a7;
    margin-top:40px; }
.steps-form-2 .steps-row-2 .steps-step-2 {
    display: table-cell;
    text-align: center;
    position: relative; }
.steps-form-2 .steps-row-2 .steps-step-2 p { }
.steps-form-2 .steps-row-2 .steps-step-2 button[disabled] {
    opacity: 1 !important;
    filter: alpha(opacity=100) !important; }
.steps-form-2 .steps-row-2 .steps-step-2 .btn-circle-2 {
    width: 70px;
    height: 70px;
    border: 2px solid #59698D;
    background-color: white;
    color: #59698D !important;
    border-radius: 50%;
    padding: 22px 18px 15px 18px;
    margin-top: 20px; }
.steps-form-2 .steps-row-2 .steps-step-2 .btn-circle-2:hover {
    border: 2px solid #4285F4;
    color: #005C77 !important;
     }
.steps-form-2 .steps-row-2 .steps-step-2 .btn-circle-2 .fa {
    font-size: 1.7rem;
    }
.steps-form-2 .steps-row-2 .steps-step-2 .btn-circle-2 .fa:hover {
    color:#005c77 !important; }
.steps-form-2 .steps-row-2 .steps-step-2 .btn-circle-2:hover {
    color: #13353f !important;}
.steps-row-2 .active
{
background-color: #005c77 !important;
}
.steps-row-2 .active .fa
{
   color: #fff !important;
}
/* Step Bar End */

	</style>
	<link href="css/datepicker1.css" rel="stylesheet">
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
		<li><a href="#">Add Student </a></li>
	</ol>
				<div class="panel panel-info" style="border:none !important;">
					<!-- <div class="panel-heading">
						<h4>Add Students</h4>
					</div> -->
					<!-- <div class="tab">
  						<button class="tablinks" onclick="openCity(event, 'generalInfo')" id="defaultOpen">General Information</button>
  						<button class="tablinks"  onclick="openCity(event, 'educationInfo')" id="educationInfoId">Educational Information</button>
  						<button class="tablinks" onclick="openCity(event, 'feesInfo')"  id="feesInfoId">Fees</button>
					</div> -->
					<div class="steps-form-2">
					    <div class="steps-row-2 setup-panel-2 d-flex justify-content-between border">
					        <div class="steps-step-2">
					            <a href="#" onclick="openCity(event, 'generalInfo')" id="defaultOpen" type="button" class=" tablinks btn btn-amber btn-circle-2 waves-effect ml-0" data-toggle="tooltip" data-placement="top" title="Personal Information"><i class="fa fa-user" aria-hidden="true"></i></a>
					        </div>
					        <div class="steps-step-2">
					            <a href="#" onclick="openCity(event, 'educationInfo')" id="educationInfoId" type="button" class=" tablinks btn btn-blue-grey btn-circle-2 waves-effect" data-toggle="tooltip" data-placement="top" title="Educational Information"><i class="fa fa-book" aria-hidden="true"></i></a>
					        </div>
					        <div class="steps-step-2">
					            <a href="#" onclick="openCity(event, 'feesInfo')"  id="feesInfoId" type="button" class="tablinks btn btn-blue-grey btn-circle-2 waves-effect" data-toggle="tooltip" data-placement="top" title="Fees"><i class="fa fa-check" aria-hidden="true"></i></a>
					        </div>
					    </div>
					</div>
					<!-- <ul class="pagination">
  						<li><a href="#generalInfo">General Information</a></li>
  						<li><a href="#educationInfo">Educational Information</a></li>
  						<li><a href="#feesInfo">Fees</a></li>
					</ul> -->
					<!-- Spacer starts -->
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="multipleFieldsetForClear">
							
										<form:form action="addStudent.htm" commandName="packCmd" method="post" class="form-horizontal border" id="student-form" enctype="multipart/form-data">
											
										<div class="row">
										<fieldset id="general_information" class="">
								<div id="generalInfo" class="tabcontent">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Student Name <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="name" placeholder="Student Name" class="form-control validate nospecialCharacter onlyCharacters"  required="true"/>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Gender <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="gender" tabindex="15" class="form-control validate" required="true" onfocus="removeBorder(this.id)">
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
														<form:input path="fatherName" placeholder="Father Name" class="form-control validate nospecialCharacter onlyCharacters"  required="true"/>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Father Occupation <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="fatherOccupation" placeholder="Father Occupation" class="form-control validate nospecialCharacter onlyCharacters"  required="true"/>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Mother Name <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="motherName" placeholder="Mother Name" class="form-control validate nospecialCharacter onlyCharacters"  required="true"/>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Mother Occupation <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="motherOccupation" placeholder="Mother Occupation" class="form-control validate nospecialCharacter onlyCharacters"  required="true"/>
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
												    <label for="inputPassword3" class="col-sm-4 control-label">Mobile <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="mobile" placeholder="Contact Number" class="form-control validate  numericOnly" maxlength="10" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Alternative Mobile</label>
												    <div class="col-sm-5">
														<form:input path="alternativeMobile" placeholder="Alternate Contact Number" class="form-control numericOnly" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Email</label>
												    <div class="col-sm-5">
														<form:input path="email" placeholder="Email-Id" class="form-control validate" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Blood Group</label>
												    <div class="col-sm-5">
														<form:select path="blodgroup"  class="form-control">
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
												    <label for="inputPassword3" class="col-sm-4 control-label">Admission Date <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="admissionDate" data-format="dd-MM-yyyy" placeholder="AdmissionDate Date" class="form-control validate"  required="true" readonly="true" onfocus="removeBorder(this.id)" />
														<span class="admissionDate_error" id="dob1_error"></span>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Religion</label>
												    <div class="col-sm-5">
														<form:select path="religion"  class="form-control">
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
														<form:textarea path="address" placeholder="Address" class="form-control validate "  required="true"></form:textarea>
													</div>
											  	</div>
											</div>
												<div class="clearfix"></div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
											    	<label for="inputEmail3" class="col-sm-4 control-label">Student Image</label>
											    	<div class="col-sm-5">
														<img id="blah" src='upload/default.png' alt="Student Image" align="middle" style="border-style: solid;height: 100px;width: 100px;border-bottom-style: none;border-left-style: none;border-top-style: none;">
														<input type="file" name="imageName"  id="imageName" onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])" accept="image/jpg,image/png,image/jpeg,image/gif">
											    	</div>
											  	</div>
											</div>
											<div class="col-sm-8 col-sm-offset-5">
												<form:hidden path="id" /><br>
											  	<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-2">
												  		
														<input type="button" id="generalInfoContinue" class="btn btn-success" value="Next >" tabindex=""/>
														<input type="button" class="btn btn-danger" id="cancel1" value="Reset" />
													</div>
											  	</div>
											</div>
										</div>
									</fieldset>
									<fieldset id="education_information" class="">
								<div id="educationInfo" class="tabcontent">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
											    	<label for="inputPassword3" class="col-sm-4 control-label">Board Name <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="boardName" class="form-control validate1"  onchange="classNameFilter()"  required="true">
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
														<form:select path="className" class="form-control validate1"  onchange="sectionFilter();" required="true">
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
														<form:select path="section" class="form-control validate1"   onchange="mediumFilter();" quired="true">
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
														<form:select path="medium" class="form-control validate1"  onchange="getFee();" required="true">
															<form:option value="">-- Choose Medium --</form:option>
<%-- 															<form:options items="${mediam}"></form:options> --%>
														</form:select>
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
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Roll Number</label>
												    <div class="col-sm-5">
														<form:input path="rollNum" placeholder="Roll Number" class="form-control nospecialCharacter" />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label ">Admission No. <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="admissionNum" placeholder="Admission Number" class="form-control  validate1 nospecialCharacter"  required="true" readonly="true"/>
													</div>
											  	</div>
											</div>
							
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Previous School</label>
												    <div class="col-sm-5">
														<form:input path="previousInstitue" placeholder="Previous Institute Name" class="form-control   nospecialCharacter onlyCharacters"  />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Caste</label>
												    <div class="col-sm-5">
														<form:select path="caste"  class="form-control">
															<form:option value="">-- Choose Caste --</form:option>
															<form:option value="OC">OC</form:option>
															<form:option value="BC-A">BC-A</form:option>
															<form:option value="BC-B">BC-B</form:option>
															<form:option value="BC-C">BC-C</form:option>
															<form:option value="BC-D">BC-D</form:option>
															<form:option value="BC-E">BC-E</form:option>
															<form:option value="SC">SC</form:option>
															<form:option value="ST">ST</form:option>
															<form:option value="OBC">OBC</form:option>
															<form:option value="Others">Others</form:option>
														</form:select>
													</div>
											  	</div>
											</div>
											<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Accommodation<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="acomitation"  class="form-control validate1">
															<form:option value="">-- Choose Accommodation --</form:option>
															<form:option value="Hostel">School</form:option>
															<form:option value="Day-Scholar">Day-Scholar</form:option>
														</form:select>
													</div>
											  	</div>
											</div> --%>
										
										
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="divBuspesility">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label ">Bus Facility<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="buspesility"  class="form-control validate1" >
															<form:option value="">-- Choose Bus Facility --</form:option>
															<form:option value="Yes"> Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select>
													</div>
											  	</div>
											</div>
											<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="busRouteDiv">
											  	<div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Bus Route</label>
												    <div class="col-sm-5">
														<form:input path="busroute" placeholder="Bus Route" class="form-control nospecialCharacter "  />
													</div>
											  	</div>
											</div> --%>
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
											<div class="col-sm-8 col-sm-offset-5">
												<form:hidden path="id" /><br>
											  	<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-2">
												  	    <input type="button" id="educationPrevious" class="btn btn-success" value="< Previous" tabindex=""/>
														<input type="button" id="educationInfoContinue" class="btn btn-success" value="Next >" tabindex=""/>
														<input type="button" class="btn btn-danger" id="cancel2" value="Reset" tabindex="26"/>
													</div>
											  	</div>
											</div>
								</div>
								</fieldset>
								<fieldset id="fees_information" class="">
								<div id="feesInfo" class="tabcontent">
									
												<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Admission Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="admissionFee" placeholder="Admission Fee"  class="form-control numericOnly"  />
													</div>
											  	</div>
											</div>
											
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Tuition Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="tutionFee" placeholder="Tuition Fee"  class="form-control numericOnly"  />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="transportationDiv">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Transportation Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="transportationFee" placeholder="Transportation Fee"  class="form-control numericOnly"  />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="hostleDiv">
											    <div class="form-group" id="forTermsDiv" >
												    <label for="inputPassword3" class="col-sm-4 control-label">Total School Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5" >
														<form:input path="hostelFee" placeholder="School Fee" class="form-control numericOnly"  />
													</div>
<!-- 														<input type="button" class="btn btn-success" id="more_fields" onclick="add_fields();" value="Add Terms" /> -->
														
														<br>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="hostleDiv">
											    <div class="form-group" id="forTermsDiv" >
												    <label for="inputPassword3" class="col-sm-4 control-label">School Fee Term 1 <span style="color: red;">*</span></label>
												    <div class="col-sm-5" >
														<form:input path="termOne" placeholder="School Fee" class="form-control numericOnly"  />
													</div>
														
														<br>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="hostleDiv">
											    <div class="form-group" id="forTermsDiv" >
												    <label for="inputPassword3" class="col-sm-4 control-label">School Fee Term 2 <span style="color: red;">*</span></label>
												    <div class="col-sm-5" >
														<form:input path="termTwo" placeholder="School Fee" class="form-control numericOnly"  />
													</div>
														
														<br>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="hostleDiv">
											    <div class="form-group" id="forTermsDiv" >
												    <label for="inputPassword3" class="col-sm-4 control-label">School Fee Term 3<span style="color: red;">*</span></label>
												    <div class="col-sm-5" >
														<form:input path="termThree" placeholder="School Fee" class="form-control numericOnly"  />
													</div>
														
														<br>
											  	</div>
											</div>
										
										
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Stationary Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="stationaryFee" placeholder="Stationary Fee" class="form-control numericOnly"  />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											    <div class="form-group">
												    <label for="inputPassword3" class="col-sm-4 control-label">Total Fees <span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:input path="totalFee" placeholder="Fee Amount" class="form-control numericOnly"  readonly="true" />
													</div>
											  	</div>
											</div>
										
										
										
											<div class="col-sm-8 col-sm-offset-5">
												<form:hidden path="id" /><br>
											  	<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-2">
												  	    <input type="button" id="feesPrevious" class="btn btn-success" value="< Previous" tabindex=""/>
														<input type="submit" id="submitId" class="btn btn-success" value="Register" />
													<input type="button" class="btn btn-danger" id="cancel3" value="Reset" />
													</div>
											  	</div>
											</div>
								</div>
								</fieldset>
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
																	<th class="sorting noExport" style="width: 10px;" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">S.No</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Father Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Mobile Number</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Image</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Admission No.</th>
<!-- 																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th> -->
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Class</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>
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
//$(function(){
	var nextaddmissionnumber=0;
	nextaddmissionnumber =${admissionNum};
	if(admissionNum != ''){
		nextaddmissionnumber =	'0'+${admissionNum};
		}else{
			
			nextaddmissionnumber = 1;
		}
		$("#admissionNum").val(nextaddmissionnumber);
		//$('#admissionNum').attr("readonly", true); 
//});
var baseUrl2 =$("#baseUrl1").val();

var listOrders1 = ${allOrders1};
if (listOrders1 != "") {
	displayTable(listOrders1);
}

var getTabName = window.location.pathname.split('/')[2];
$("#stu_li").addClass('active');
$("#stu_li ul").css('display','block');
$("#stu_li ul li a[href='"+ getTabName +"']").addClass('subactive');



function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    if(evt.currentTarget){
    evt.currentTarget.className += " active";
    }else{
    	
    	evt.target.className += " active"
    }
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
