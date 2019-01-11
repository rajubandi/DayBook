<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script> -->
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script type="text/javascript" src="js/examPattern.js"></script>
<style>
.btnsm {
	margin: 0.5px;
}
.form-horizontal .control-label {
    padding-top: 7px;
    margin-bottom: 0;
    text-align: right;
    margin-bottom: 8px;
}
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}
.smarks tbody {
padding:20px;
}
/* Modal Content */
.modal-content {
    position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top:-300px; opacity:0} 
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}
table tr {
border:none !important;}
.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 0px 16px;
    
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 0px 16px;
   
}
.smarksp {
    border-collapse: inherit !important;
}
.smarksp>tbody>tr>td {
border:none !important;
}
</style>
<!-- Dashboard Wrapper starts -->
<div class="dashboard-wrapper">

	<!-- Top Bar starts -->
	<div class="top-bar">
		<div class="page-title" id="headId">Exam Pattern</div>
	</div>
	<!-- Top Bar ends -->

	<!-- Main Container starts -->
	<div class="main-container">

		<!-- Container fluid Starts -->
		<div class="container-fluid">

			<!-- Spacer starts -->
<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Configurations</a></li>
		<li><a href="#">Exam Pattern</a></li>
	    </ol>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Exam Pattern </h4>
					</div> 
					<div class="panel-body collapse in">
				<!-- Row Starts -->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<%-- 									<%${message} %> --%>

			<form:form action="examPattern" commandName="examPattern" method="post" id="cls-form" class="form-horizontal">
									<div class="form-group row">
										<div class="col-md-2">
											<label class="control-label">Board Name:<span style="color: red;">*</span></label>
												<form:select path="boardId" 	class="form-control" 	onchange="classNameFilter(this.id);">
													<form:option value="">-- Choose Board --</form:option>
													<form:options items="${board}" />
												</form:select>
										</div>
										<div class="col-md-2">
											<label class="control-label">Class:<span style="color: red;">*</span></label>
												<form:select path="classId" 	class="form-control"  onchange="sectionFilter();">
													<form:option value="">--Choose Class--</form:option>
													<%-- <form:options items="${subject}" ></form:options> --%>
												</form:select>

										</div>
										<div class="col-md-2">
											<label class="control-label">Section:<span style="color: red;">*</span></label>
												<form:select path="sectionId" 	class="form-control" 	onchange="mediumFilter();">
													<form:option value="">--Choose Section--</form:option>
													<%-- <form:options items="${subject}" ></form:options> --%>
												</form:select>

										</div>
										<div class="col-md-2">
											<label class="control-label">Medium:<span style="color: red;">*</span></label>
												<form:select path="medium" 	class="form-control"  onchange= "getSubjects()"   >

														<form:option value="">-- Choose Medium --</form:option>
											<%--<form:options items="${mediam}"></form:options> --%>
													</form:select>

										</div>
										<%-- <div class="col-md-2">
											<label class="control-label">Student:</label>
												<form:select path="studentId" 	class="form-control" >	onchange="getClassBySectionByStudentByExamType(this.id);"
												<!-- 	<option value="">-- Select Student --</option> -->
													<form:option value="">--Select Student--</form:option>
										<form:options items="${allStudents}"></form:options>
												</form:select>
										</div> --%>
										<div class="col-md-2">
											<label class="control-label">Exam Type:<span style="color: red;">*</span></label>
												<form:select path="examTypeId" 	class="form-control"  ><%-- onchange= "getExamPatternList();" --%> 
													<form:option value="">-- Exam Type --</form:option>
													<form:options items="${examType}"></form:options>
													<%-- <c:forEach var="exampType" items="${exampType}">
														<option value="${exampType.key}">${exampType.value}</option>
													</c:forEach> --%>
												</form:select>
											</div>
											
											
										</div>
									
										<div  id="subjectDiv"></div>
										
									
									
									
									<%-- 	<form:hidden path="id"/> --%>

									<div class="form-group">
										<div class="col-sm-8 col-sm-offset-4">
											<%
												String message = null;
													message = (String) session.getAttribute("message");
													if (message != null) {
														out.println(
																"<span class='animated fadeOut' style='animation-iteration-count:1;animation-duration:8s;color: red;'>"
																		+ message + "</span>");
														session.setAttribute("message", null);
													}
											%>
										</div>
									</div>
									
									
									<div class="row">
										<div class="col-sm-8 col-sm-offset-4">
											<form:hidden path="id" />
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="submit" id="submitId" onsubmit="getExamList" value="Submit"	class="btn btn-success"  />
													<button type="button" class="btn btn-danger" id="cancel"	>Reset</button>
												</div>
											</div>
										</div>
									</div>
									
								</form:form>
							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- Row Ends -->
			<!-- Row Starts -->
			<div class="row gutter" id="examPatternTableDiv">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="blog">
						<div class="blog-header">
							<div class="col-md-12">
								<div class="col-md-4">
									<h4>Exam Pattern</h4>
								</div>

								<!-- <div class="col-md-8" align="right">
									<span class="btn btn-primary btnsm">
									<span
										class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
										Save </span> <span class="btn btn-warning btnsm"><span
										class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										Cancel </span> <span class="btn btn-success btnsm"><span
										class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
										SMS Marks</span>
								</div> -->

							</div>
							<div class="blog-body">
								<div class="table-responsive">
									<div class="panel-body">
									<div id="examPatternTable">
										<table >
										<!--<thead>
										 <th>Board Name</th>
										<th>Medium</th>
										<th>Class</th>
										<th>Section</th>
										<th>Exam Type</th> 
										<th>Subject</th>
										<th>Maximum Marks</th>
										<th>Action</th>
										</thead>-->
										<tbody></tbody>									
										</table>
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
<!-- <button id="myBtn">Open Modal</button> -->

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h4>Student Marks</h4>
    </div>
    <div class="modal-body">
    <div align="center"><img src="img/logoprint.png" class="img-responsive" height="71px"/></div>
    
    <table class="table table-bordered smarksp" style="width:100%;">
    <tbody>
    <tr border="none"><td>Board Name</td><td>Class</td><td rowspan="3" width="25%" style="padding-top:15px;"><span class="pull-right"><img src="img/logo (1).png" height="50" /> Hall Ticeket No &nbsp; <button type="default">HT1234567</button></span></td></tr>
    <tr><td>Section</td><td>Exam Type </td></tr>
    <tr><td>Medium</td><td>Student Name</td></tr>
     <tr></tr>
     <tr></tr>
     </tbody>
    </table>
    <br>
    <table class="table table-bordered table-striped">
    <tr><th>S.No</th><th>Subject Title</th><th>Marks</th><th>Total Marks</th><th>Result</th></tr>
    
    <tr><td colspan="2">Passed <span class="pull-right">Total</span></td><td>100</td><td>100</td><td></td></tr>
    </table>
    </div>
    
  </div>

</div>
		</div>
		<!-- Container fluid ends -->
 
	</div>
	<!-- Main Container ends -->

</div>
<!-- Dashboard Wrapper ends -->
	<!-- Pop Start -->
				
<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<!-- <script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	/*  var listExamPattern = ${examPattern};
	if (listExamPattern != "") {
		displayTable(listExamPattern);
	} else {
		$("#emptyMessageId").val("No Results Found");
	}  */
	
	var getTabName = window.location.pathname.split('/')[2];
	$("#conf_li").addClass('active');
	$("#conf_li ul").css('display','block');
	$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');
</script>
