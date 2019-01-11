<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>

	<script type="text/javascript" src="js/homejsp.js"></script>
	
<!-- 	<div class="loadingajax" id="loadAjax" style="display:none"></div> -->
	
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Fee Defination</div>
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
		<li><a href="#">Fee Defination</a></li>
	</ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Fee Defination </h4>
					</div>
					<div class="panel-body collapse in">
					
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							
									<form:form action="addclass.htm" commandName="packCmd" method="post" id="cls-form" class="form-horizontal">
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Board Name<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
												    <form:select path="boardId" tabindex="1" class="form-control" required="true"  onchange="classNameFilter();">
														<form:option value="">-- Choose Board --</form:option>
														<form:options items="${board}"></form:options>
													</form:select>
													<span class="boardId_error" id="boardId_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Class/Branch<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
												    <form:select path="className" tabindex="3" class="form-control" required="true" onchange="sectionFilter();">
														<form:option value="">-- Choose Class --</form:option>
<%-- 														<form:options items="${allClasses}"></form:options> --%>
													</form:select>
<%-- 													<form:input path="className" class="form-control" tabindex="3" placeholder="Enter Class/Branch" required="true"/> --%>
													<span class="className_error" id="className_error"></span>
												</div>
											</div>
										</div>
								
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Section<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
												    <form:select path="section" tabindex="4"   class="form-control" required="true">
														<form:option value="">-- Choose Section --</form:option>
<%-- 														<form:options items="${allSection}"></form:options> --%>
													</form:select>
<%-- 													<form:input path="section" class="form-control" tabindex="4" placeholder="Enter Section" required="true"/> --%>
													<span class="section_error" id="section_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Medium<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
												    <form:select path="mediumId" tabindex="2"  class="form-control" required="true">
														<form:option value="">-- Choose Medium --</form:option>
														<form:options items="${mediam}"></form:options>
													</form:select>
<%-- 													<form:input path="mediumId" class="form-control onlyCharacters" tabindex="2" placeholder="Enter Medium" required="true"/> --%>
													<span class="mediumId_error" id="mediumId_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Admission Fees<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
													<form:input path="admissionFee" class="form-control numericOnly" tabindex="5" placeholder="Admission Fee" required="true"/>
													<span class="fee_error" id="fee_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Tuition Fees<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
													<form:input path="tutionFee" class="form-control numericOnly" tabindex="5" placeholder="Tuition Fee" required="true"/>
													<span class="fee_error" id="fee_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Transportation Fees<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
													<form:input path="transportationFee" class="form-control numericOnly" tabindex="5" placeholder="Transportation Fee" required="true"/>
													<span class="fee_error" id="fee_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="hostleDiv">
											<div class="form-group" id="forTermsDiv" >
											    <label for="inputEmail3" class="col-sm-4 control-label">School Fees<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
													<form:input path="hostelFee" class="form-control numericOnly" tabindex="5" placeholder="School Fee" required="true"/>
													<span class="fee_error" id="fee_error"></span>
												</div>
												<input type="button" class="btn btn-success" id="more_fields" onclick="add_fields();" value="Add Terms" /><br>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Stationary Fees<span style="color: red;">*</span></label>
											    <div class="col-sm-6">
													<form:input path="stationaryFee" class="form-control numericOnly" tabindex="5" placeholder="Stationary Fee" required="true"/>
													<span class="fee_error" id="fee_error"></span>
												</div>
											</div>
										</div>
									<div class="clearfix"></div>
										<div class="col-sm-8 col-sm-offset-4">
											<form:hidden path="id"/>
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="submit" id="submitId" value="Submit" class="btn btn-success" tabindex="6"/>
													<button type="button" class="btn btn-danger" id="cancel" tabindex="7">Reset</button>
												</div>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
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
									</div><div class="clearfix"></div>
									</form:form>
								
							</div>
						</div>
						</div></div>
						<!-- Row Ends -->
						
						<!-- Row Starts -->
						<div class="row gutter">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-info">
					<div class="panel-heading">
						<h4>List of Class Fee </h4>
					</div>
					<div class="panel-body collapse in">
								
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Board</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Admission Fee</th>
																    <th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Tution Fee</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Transportation Fee</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">School Fee</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Term 1</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Term 2</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Term 3</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Stationary Fee</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Total Fee</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>
																</tr>
															</thead>
															<!-- <tfoot>
																<tr><th rowspan="1" colspan="1">Board</th><th rowspan="1" colspan="1">Medium</th><th rowspan="1" colspan="1">Class</th><th rowspan="1" colspan="1">Section</th><th rowspan="1" colspan="1">Fees</th><th rowspan="1" colspan="1">Action</th></tr>
															</tfoot> -->
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
<script>
	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}else{
		$("#emptyMessageId").val("No Results Found");
	}
	var getTabName = window.location.pathname.split('/')[2];
	$("#conf_li").addClass('active');
	$("#conf_li ul").css('display','block');
	$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');

</script>
