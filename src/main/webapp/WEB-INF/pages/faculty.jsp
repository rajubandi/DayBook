<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script type="text/javascript" src="js/faculty.js"></script>
	<div class="loadingajax" id="loadAjax" style="display:none"></div>
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Add Faculty</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Configurations</a></li>
		<li><a href="#">Add Faculty</a></li>
	</ol>
				
										<div class="col-md-4">
										<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Create Faculty</h4>
					</div>
					<div class="panel-body collapse in">
										<form:form action="facultySubmit.htm" commandName="packCmd" method="post" class="form-horizontal" id="fac-form">
										<div class="row">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Faculty Name<span style="color: red;">*</span></label>
												    <div class="col-sm-6">											
														<form:input path="name" tabindex="1" placeholder="Faculty Name" class="form-control  onlyCharacters" required="true"/>
														<span class="name_error" id="name_error"></span>
													</div>
												</div>
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Gender<span style="color: red;">*</span></label>
												    <div class="col-sm-6">
													    <form:select path="gender" tabindex="2" class="form-control" required="true">
															<form:option value="">-- Choose Gender --</form:option>
															<form:option value="Male"> Male</form:option>
															<form:option value="Female">Female</form:option>
														</form:select>
														<span class="gender_error" id="gender_error"></span>
													</div>
												</div>
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Qualification<span style="color: red;">*</span></label>
												    <div class="col-sm-6">
														<form:input path="qualification" tabindex="3" placeholder="Qualification" class="form-control onlyCharacters" required="true"/>
														<span class="qualification_error" id="qualification_error"></span>
													</div>
												</div>
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Contact Number<span style="color: red;">*</span></label>
												    <div class="col-sm-6">
														<form:input path="contactNumber" tabindex="4" placeholder="Contact Mobile Number" class="form-control numericOnly" required="true" maxlength="10"/>
														<span class="contactNumber_error" id="contactNumber_error"></span>
													</div>
												</div>
											</div>
										<div class="row">
											<div class="col-sm-8 col-sm-offset-4">
												<form:hidden path="id"/>
												<div class="form-group">
													<input type="submit" id="submitId" value="Submit" class="btn btn-success" tabindex="5"/>
													<button type="button" class="btn btn-danger" id="cancel" tabindex="6">Reset</button>
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
										</form:form></div></div>
										</div>
										<div class="col-md-8 gutter">
										<div class="panel panel-info">
					<div class="panel-heading">
						<h4>List of Faculty</h4>
					</div>
					<div class="panel-body collapse in">
										<div class="">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Gender</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Qualification</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Mobile</th>
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
						
						<!-- Row Starts -->
						<div class="row gutter">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								
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

var listOrders1 = ${allOrders1};
if (listOrders1 != "") {
	displayTable(listOrders1);
}
var getTabName = window.location.pathname.split('/')[2];
$("#conf_li").addClass('active');
$("#conf_li ul").css('display','block');
$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');

</script>
