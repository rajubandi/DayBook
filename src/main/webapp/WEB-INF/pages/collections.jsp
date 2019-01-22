<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
	
	<link href="css/datepicker1.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' href='css/MonthPicker.min.css' /> 
    <script type='text/javascript' src='js/MonthPicker.min.js'></script>
	
	<script type="text/javascript" src="js/collection.js"></script>
	
	<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script> -->

	<script>
	window.setTimeout(function() {
		$(".msgcss").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 5000);
</script>

		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Collections</div>
			</div>
			
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">
				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="collections"></a>Collections</li>
	</ol>
						<div class="row">
							<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
							
			<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Collections</h4>
					</div>                    
                    
                    <div class="panel-body collapse in">
                    
                    <!-- Row Starts -->
						<div class="row">
									<form:form action="collectionName.htm" onsubmit="return checkAmount(this);" commandName="packCmd" method="post" id="cls-form" class="form-horizontal">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											<label  for="inputEmail3" class="col-sm-4 control-label">Date </label>
											<div class="col-sm-8">
											<form:input id="date" name="date" data-format="dd-MM-yyyy" type="text" path="date" autocomplete="off"  placeholder="Date" class="form-control validate"  required="true" tabindex="1" onfocus="removeBorder(this.id)" />
											<span class="date_error" id="name_error"></span>
											</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  	<div class="form-group">
											<label  for="inputEmail3" class="col-sm-4 control-label">Client</label>
											<div class="col-sm-8">
											<form:select path="client" name="client" class="form-control" onchange="searchData()"> <!-- onchange="searchData()" -->
											<form:option value="" >-- Choose Client --</form:option>
											<form:options items="${client}"></form:options>
											</form:select>
											<span class="client_error" id="name_error"></span>
											</div>											  
											</div>
											</div>	
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Description</label>
											   <div class="col-sm-8">
													<form:input name="description" path="description" class="form-control nospecialCharacter onlyCharacters" tabindex="1" placeholder="Description" required="true"/>
													<span class="description_error" id="name_error"></span>
												</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Full Amount</label>
											    <div class="col-sm-8">
													<form:input name="fullamount" path="fullamount" type="number" min="0" oninput="this.value = Math.abs(this.value)" class="form-control" tabindex="1" placeholder="Full Amount" required="true"/>
													<span class="fullamount_error" id="name_error"></span>
												</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Paid Amount</label>
											    <div class="col-sm-8">
													<form:input name="paidamount" path="paidamount" type="number" min="0" oninput="this.value = Math.abs(this.value)" class="form-control" tabindex="1" placeholder="Paid Amount" required="true"/>
													<span class="paidamount_error" id="name_error"></span>
												</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											<label  id="endTimeLabel" style="display: none" for="inputEmail3" class="col-sm-4 control-label">DueDate</label>
											<div class="col-sm-8">
			     							<form:input id="duedate"  name="duedate" data-format="dd-MM-yyyy" style="display: none" path="duedate" type="text" autocomplete="off"  placeholder="DueDate" class="form-control" tabindex="1" onfocus="removeBorder(this.id)" />
											</div>
											</div>
											</div>
											
											<form:hidden path="id"/>
												<div class="col-sm-12">
												  	<div class="col-sm-8 col-sm-offset-2">
													<input type="submit" id="submitId" value="Submit" class="btn btn-success" tabindex="2"/>
													<button type="button" class="btn btn-danger" id="cancel" tabindex="3">Reset</button>
													</div>
												</div>
												
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label id="showamount" style="display: none" for="inputEmail3" class="col-sm-4 control-label">Show Amount</label>
											    <div class="col-sm-8">
													<%-- <form:input name="showamount" path="paidamount" type="number" min="0" oninput="this.value = Math.abs(this.value)" class="form-control" tabindex="1" placeholder="Paid Amount" required="true"/> --%>
													<span class="paidamount_error" id="name_error"></span>
												</div>
											</div>
											</div>
												
												<div class="col-sm-12">
													<div class="col-sm-8 col-sm-offset-2">
													<%
														String message = null;
														message=(String)session.getAttribute("message");
												        if(message!=null)
												        {
															out.println("<span class='animated fadeOut' style='animation-iteration-count: 1;animation-duration: 10s;color: red;'>"+message+"</span>");
															session.setAttribute("message", null);
														}
											        %>
													</div>
												</div>
									</form:form></div></div>
									</div></div>
									
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top:20px">
									<div class="panel panel-info">
					<div class="panel-heading">
						<h4>List of Collection Details</h4>
					</div>  
                      <div class="panel-body collapse in">
									
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Date</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Client</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Description</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Full Amount</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Paid Amount</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Due Amount</th>
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
								</div></div></div>
									</div>
									
								</div>
							</div>
					
						<!-- Row Ends -->
						
						<!-- Row Starts -->
						<!-- <div class="row gutter">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								
							</div>
						</div> -->
						<!-- Row Ends -->
						
					<!-- </div> -->
					<!-- Spacer ends -->

				<!-- </div> -->
				<!-- Container fluid ends -->

			<!-- </div> -->
			<!-- Main Container ends -->

		<!-- </div> -->
		<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

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

 /*   var showamt = ${showamount};  
 
 if (showamt != "") {
	showAmountFunc(showamt);
}  */ 
</script>
