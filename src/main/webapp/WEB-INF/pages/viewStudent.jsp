<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


		<!-- Data Tables -->
		<!-- <script src="js/datatables/dataTables.min.js"></script>
		<script src="js/datatables/dataTables.bootstrap.min.js"></script>
		<script src="js/datatables/dataTables.tableTools.js"></script>
		<script src="js/datatables/autoFill.min.js"></script>
		<script src="js/datatables/autoFill.bootstrap.min.js"></script>
		<script src="js/datatables/fixedHeader.min.js"></script> -->
	<script type="text/javascript" src="js/viewStudent.js"></script>	
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<style>
	.table-condensed > thead > tr > th, .table-condensed > tbody > tr > th, .table-condensed > tfoot > tr > th, .table-condensed > thead > tr > td, .table-condensed > tbody > tr > td, .table-condensed > tfoot > tr > td {
    padding: 5px 10px;
    font-size: 12px !important;
    font-weight: normal !important;
    font-family: 'Open Sans', sans-serif; !important;
}
.panel-default {
overflow-x:hidden;}
	</style>
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">View Student</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Student Details</a></li>
		<li><a href="#">View Student</a></li>
	    </ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>View Students</h4>
					</div>
					<div class="panel-body collapse in">
					<!-- Spacer starts -->
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								
										<form:form  commandName="packCmd" method="post" class="form-horizontal" id="student-form">
										
										<div class="row">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">	
												<div class="form-group">
											    	<label for="inputEmail3" class="col-sm-4 control-label">Student Name</label>
											    	<div class="col-sm-5">
														<form:input path="name" placeholder="Student Name" class="form-control nospecialCharacter onlyCharacters"  />
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  		<div class="form-group">
										    		<label for="inputPassword3" class="col-sm-4 control-label">Board Name</label>
										    		<div class="col-sm-5">
														<form:select path="boardName" class="form-control"  onchange="searchStudent(),classNameFilter()">
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
														<form:select path="className" class="form-control"    onchange="searchStudent(),sectionFilter()">
															<form:option value="">-- Choose Class --</form:option>
<%-- 															<form:options items="${allClasses}"></form:options> --%>
														</form:select>
													</div>
											  	</div>
											</div>
										
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  		<div class="form-group">
										    		<label for="inputPassword3" class="col-sm-4 control-label">Section</label>
										    		<div class="col-sm-5">
														<form:select path="section" class="form-control"  onchange="searchStudent(),mediumFilter()" >
															<form:option value="">-- Choose Section --</form:option>
<%-- 															<form:options items="${allSection}"></form:options> --%>
														</form:select>
													</div>
										  		</div>
										  	</div>
										  	<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  		<div class="form-group">
										    		<label for="inputPassword3" class="col-sm-4 control-label">Medium</label>
										    		<div class="col-sm-5">
														<form:select path="medium" class="form-control"  onchange="searchStudent()">
															<form:option value="">-- Choose Medium --</form:option>
													<%-- 		<form:options items="${mediam}"></form:options> --%>
														</form:select>
													</div>
										  		</div>
										  	</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  		<div class="form-group">
										    		<label for="inputPassword3" class="col-sm-4 control-label">Roll Number</label>
										    		<div class="col-sm-5">
														<form:input path="rollNum" placeholder="Roll Number" class="form-control nospecialCharacter"  />
													</div>
										  		</div>
										  	</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  		<div class="form-group">
										    		<label for="inputPassword3" class="col-sm-4 control-label">Admission No.</label>
												    <div class="col-sm-5">
														<form:input path="admissionNum" placeholder="Admission Number" class="form-control nospecialCharacter"  />
													</div>
										  		</div>
										  	</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  		<div class="form-group">
										    		<label for="inputPassword3" class="col-sm-4 control-label">Mobile</label>
										    		<div class="col-sm-5">
														<form:input path="mobile" placeholder="Contact Number" class="form-control numericOnly" maxlength="10" />
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
												    <label for="inputPassword3" class="col-sm-4 control-label">Caste</label>
												    <div class="col-sm-5">
														<form:select path="caste"  class="form-control">
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
										</div>
										<div class="row">
											<div class="col-sm-8 col-sm-offset-5">
												<form:hidden path="id" /><br>
										  		<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-2">
														<input type="button" class="btn btn-success" value="Search" onclick="searchStudent()" />
														<input type="reset" class="btn btn-danger" id="cancel" />
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
							</div></div>
						<!-- Row Ends -->
						
						<!-- Row Starts -->
						<div class="row" id="view_list1">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-info">
					<div class="panel-heading">
							<h4>List of Students</h4>
					</div> 
					<div class="panel-body collapse in">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
													<input type="checkbox" class="form-check-input"  id="passOutStudentsCheckBoxs"> <label class="form-check-label">Show Passed Out Students</label>
													<div id="basicTable">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">S.No</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Father Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Mobile Number</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Image</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Admission No.</th>
<!-- 																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th> -->
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
<!-- <script type="text/javascript" src="js/viewStudent.js"></script> -->
<script type="text/javascript">
// var serviceUnitArray = {};


$( document ).ready(function() {
	var getTabName = window.location.pathname.split('/')[2];
	$("#stu_li").addClass('active');
	$("#stu_li ul").css('display','block');
	$("#stu_li ul li a[href='"+ getTabName +"']").addClass('subactive');

	
});


var baseUrl2 =$("#baseUrl1").val();

	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}
	
	

</script>
