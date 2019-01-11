<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<script type="text/javascript" src="js/facultySubject.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<!-- 	<script src="js/dropdownsearch.js"></script> -->
<!-- 	<link href="css/dropdownsearch.css"/> -->

<!-- <div class="loadingajax" id="loadAjax" style="display:none"></div> -->
		<!-- Dashboard Wrapper starts -->
		
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Add Faculty Subject</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Configurations</a></li>
		<li><a href="#">Add Faculty Subjects</a></li>
	</ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Create Faculty Subjects</h4>
					</div>
					<div class="panel-body collapse in">
					<!-- Spacer starts -->
					
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								
										<form:form action="addFacultySubjects.htm" commandName="packCmd" method="post" class="form-horizontal" id="sub-form">
										<div class="row">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Faculty Name<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="facultyId"   class="form-control" required="true">
															<form:option value="" >-- Choose Faculty --</form:option>
															<form:options items="${faculty}"></form:options>
														</form:select>
														<span class="facultyId_error" id="facultyId_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Board Name<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="boardName"  onchange="classNameFilter(),serviceFilter()" class="form-control" required="true">
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
														<form:select path="className"  class="form-control" onchange="sectionFilter();subjectFilter()" required="true">
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
														<form:select path="section"  class="form-control"  required="true">
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
														<form:select path="medium" class="form-control"  required="true">
															<form:option value="">-- Choose Medium --</form:option>
														<form:options items="${mediam}"></form:options>
														</form:select>
														<span class="medium_error" id="medium_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Subject<span style="color: red;">*</span></label>
												    <div class="col-sm-5">
														<form:select path="subject" class="form-control" required="true">
															<form:option value="">-- Choose Subject --</form:option>
<%-- 															<form:options items="${subject}"></form:options> --%>
														</form:select>
														<span class="subject_error" id="subject_error"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-6 col-sm-offset-4">
												<form:hidden path="id"/>
												<div class="form-group">
													<div class="col-sm-8 col-sm-offset-2">
														<input type="submit" id="submitId" value="Submit" class="btn btn-success" />
														<button type="button" class="btn btn-danger" id="cancel" >Reset</button>
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
						</div></div></div>
						<!-- Row Ends -->
						
						<!-- Row Starts -->
						<div class="row gutter">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="panel panel-info">
					<div class="panel-heading">
						<h4>List of Faculty Subjects</h4>
					</div>
					<div class="panel-body collapse in">
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Subject</th>
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
