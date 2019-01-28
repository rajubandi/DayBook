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
	
	<script type="text/javascript" src="js/addClient.js"></script>
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
				<div class="page-title" id="headId">Add Client</div>
			</div>
			
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">
				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="collections"></a>Add Client</li>
	</ol>
						<div class="row">
							<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
							
			<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Add Client</h4>
					</div>                    
                    
                    <div class="panel-body collapse in">
                    
                    <!-- Row Starts -->
						<div class="row">
									<form:form action="addClientName.htm" onsubmit="return checkAmount(this);" commandName="packCmd" method="post" id="cls-form" class="form-horizontal">
																																	
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Client Name</label>
											   <div class="col-sm-8">
													<form:input path="clientName" class="form-control nospecialCharacter onlyCharacters" tabindex="1" placeholder="Client Name" required="true"/>
													<span class="clientName_error" id="name_error"></span>
												</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Phone Number</label>
											    <div class="col-sm-8">
													<form:input path="phoneNumber" type="number" min="0" oninput="this.value = Math.abs(this.value)" class="form-control" tabindex="1" placeholder="Phone Number" required="true"/>
													<span class="phoneNumber_error" id="name_error"></span>
												</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">email id</label>
											   <div class="col-sm-8">
													<form:input path="mail" type="email" class="form-control" tabindex="1" placeholder="email id" required="true"/>
													<span class="mail_error" id="name_error"></span>
												</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Address</label>
											   <div class="col-sm-8">
													<form:input path="address" class="form-control" tabindex="1" placeholder="Address" required="true"/>
													<span class="address_error" id="name_error"></span>
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
											<label  for="inputEmail3" class="col-sm-4 control-label">Created Date </label>
											<div class="col-sm-8">
											<form:input id="createddate" name="createddate" data-format="dd-MM-yyyy" type="text" path="createddate" autocomplete="off"  placeholder="CreatedDate" class="form-control validate"  required="true" tabindex="1" onfocus="removeBorder(this.id)" />
											<span class="createddate_error" id="name_error"></span>
											</div>
											</div>
											</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											<label  id="endTimeLabel" style="display: none" for="inputEmail3" class="col-sm-4 control-label">DueDate</label>
											<div class="col-sm-8">
			     							<form:input id="duedate" style="display: none" name="duedate" data-format="dd-MM-yyyy" path="duedate" type="text" autocomplete="off"  placeholder="DueDate" class="form-control" tabindex="1" onfocus="removeBorder(this.id)" />
											<span class="duedate_error" id="name_error"></span>
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
						<h4>List of Clients Details</h4>
					</div>  
                      <div class="panel-body collapse in">
									
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Client Name</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Phone Number</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">email id</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Address</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">FullAmount</th>
																	<!-- <th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">PaidAmount</th> -->
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">CreatedDate</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">DueDate</th>
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
</script>