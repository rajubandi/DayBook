<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script type="text/javascript" src="js/studenttimetable.js"></script>
<style>
.btnsm {
	margin: 0.5px;
}
.table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th {
    border: 1px solid #ddd;
    width: 130px;
}
.table-striped>tbody>tr:nth-of-type(odd) {
    background-color: #dddddd69 !important;
}
.form-horizontal .control-label {
    padding-top: 7px;
    margin-bottom: 0;
    text-align: right;
    margin-bottom: 8px;
}
</style>
<!-- Dashboard Wrapper starts -->
<div class="dashboard-wrapper">

	<!-- Top Bar starts -->
	<div class="top-bar">
		<div class="page-title" id="headId">Import Time Table</div>
	</div>
	<!-- Top Bar ends -->

	<!-- Main Container starts -->
	<div class="main-container">

		<!-- Container fluid Starts -->
		<div class="container-fluid">

			<!-- Spacer starts -->
<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">TimeTable</a></li>
	    </ol>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Import Time Table</h4>
					</div>
<!-- 					<div class="panel-body collapse in"> -->
<!-- 				Row Starts -->
<!-- 				<div class="row"> -->
<!-- 					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> -->
<%-- 																	<%${message} %> --%>

<%-- 			<form:form action="#" commandName="timetableCmd" method="post" id="cls-form" class="form-horizontal"> --%>
<!-- 									<div class="form-group row"> -->
<!-- 										<div class="col-md-2"> -->
<!-- 											<label class="control-label">Board Name:</label> -->
<%-- 												<form:select path="boardId" tabindex="1" --%>
<%-- 													class="form-control" required="true" --%>
<%-- 													onchange="classNameFilter(this.id);"> --%>
<%-- 													<form:option value="">-- Choose Board --</form:option> --%>
<%-- 													<form:options items="${board}" /> --%>
<%-- 												</form:select> --%>
<!-- 										</div> -->
<!-- 										<div class="col-md-2"> -->
<!-- 											<label class="control-label">Class:</label> -->
<%-- 												<form:select path="classId" tabindex="2" --%>
<%-- 													class="form-control" required="true" --%>
<%-- 													onchange="sectionFilter(this.id);"> --%>
<%-- 													<form:option value="">--Choose Class--</form:option> --%>
<%-- 													<form:options items="${subject}" ></form:options> --%>
<%-- 												</form:select> --%>

<!-- 										</div> -->
<!-- 										<div class="col-md-2"> -->
<!-- 											<label class="control-label">Section:</label> -->
<%-- 												<form:select path="sectionId" tabindex="2" --%>
<%-- 													class="form-control" required="true" --%>
<%-- 													onchange=""> --%>
<%-- 													<form:option value="">--Choose Section--</form:option> --%>
<%-- 													<form:options items="${subject}" ></form:options> --%>
<%-- 												</form:select> --%>

<!-- 										</div> -->
										<div class="panel panel-default">

						
					</div>
					<div class="panel-body collapse in">
					<!-- Spacer starts -->
					
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:form id="mform" action="importtimetable" method="post" class="form-horizontal" enctype="multipart/form-data">
											<div class="form-group">
												<label for="inputPassword3" class="col-sm-2  control-label"><h5>Select File: <span style="color: red;">*</span></h5></label>
												<div class="col-sm-4 col-xs-12">
<!-- 													<input class="form-control" name="excelfile2007" type="file" tabindex="1" required="required" style="margin-top:5px; border:none;"> -->
													<input type="file" name="file" class="col-md-8" style="margin-top: 4%;" id="filePath" onchange="" placeholder="">
													<span class="excelfile2007-error" id="excelfile2007-error"></span>		
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-2 col-sm-offset-2 col-xs-12">
													<input type="submit" class="btn btn-success" tabindex="2" value="Upload">
													<input type="reset" class="btn btn-danger" id="cancel" value="Reset" tabindex="3"/>
												</div>
											</div>
											<p style="font-size:14px;">Sample File   <a href ="${url}/${filepath}" style="color:#006699;">   Download</a></p>
										</form:form>
									</div>
								</div>
							</div>
						</div>
						
								
<!-- 								
		<div class="col-md-2"> -->
<!-- 											<label class="control-label">Student:</label> -->
<%-- 												<form:select path="studentId" tabindex="1" --%>
<%-- 													class="form-control" required="true" --%>
<%-- 													onchange="getClassBySectionByStudentByExamType(this.id);"> --%>
<!-- 													<option value="">-- Select Student --</option> -->
<%-- 													<form:option value="">--Select Student--</form:option> --%>
<%-- <%-- 													<form:options items="${allStudents}"></form:options> --%> 
<%-- 												</form:select> --%>
<!-- 										</div> -->
<!-- 										<div class="col-md-2"> -->
<!-- 											<label class="control-label">Exam Type:</label> -->
<%-- 												<form:select path="examTypeId" tabindex="1" --%>
<%-- 													class="form-control" required="true"> --%>
<%-- 													<form:option value="">-- Exam Type --</form:option> --%>
<%-- 													<form:options items="${examType}"></form:options> --%>
<%-- 													<c:forEach var="exampType" items="${exampType}">
<%-- 														<option value="${exampType.key}">${exampType.value}</option> --%>
<%-- 													</c:forEach> --%> 
<%-- 												</form:select> --%>
<!-- 											</div> -->
<!-- 										</div> -->
									
									
									
								<%-- 	
									
									<div class="row">
										<div class="col-sm-8 col-sm-offset-4">
											<form:hidden path="id" />
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="submit" id="submitId" onsubmit="getExamList" value="Enter Student Marks"
														class="btn btn-success" tabindex="6" />
													<button type="button" class="btn btn-danger" id="cancel"
														tabindex="7">Reset</button>
												</div>
											</div>
										</div> --%>
<!-- 									</div> -->
									
								
<!-- 								<table class="table table-bordered table-striped"> -->
<!-- 								<tr><th></th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th><th>Saturday</th><th>Sunday</th></tr> -->
<!-- 								<tr><th>Subjects</th><td><select> -->
<!-- 								  <option value="">--Select--</option> -->
<!--   <option value="Telugu">Telugu</option> -->
<!--   <option value="English">English</option> -->
<!--   <option value="Mathmatics">Mathmatics</option> -->
<!--   <option value="Science">Science</option> -->
<!--   <option value="Social">Social</option> -->
<!-- </select></td><td></td><td></td><td></td><td></td><td></td><td></td></tr> -->
<!-- 								<tr><th>09:00 to 09:45</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>09:45 to 10:30</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>10:45 to 11:30</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>11:30 to 12:15</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>12:15 to 01:00</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>01:00 to 02:00</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>02:00 to 02:45</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>02:45 to 03:30</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>03:30 to 04:15</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
<!-- 								<tr><th>04:15 to 05:00</th><td></td><td></td><td></td><td></td><td></td><td></td><td></tr> -->
								
<!-- 								</table> -->
<!-- 							</div> -->

<!-- 						</div> -->
					</div>
				</div>
			</div>
			<!-- Row Ends -->

			<!-- Row Starts -->
			
			<!-- Spacer ends -->

		</div>
		<!-- Container fluid ends -->

	</div>
	<!-- Main Container ends -->

</div>
<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<script type="text/javascript">

var getTabName = window.location.pathname.split('/')[2];
$("#stu_li").addClass('active');
$("#stu_li ul").css('display','block');
$("#stu_li ul li a[href='"+ getTabName +"']").addClass('subactive');

	var filepath1='${filepath}';
	console.log(filepath1);
	
	
</script>
