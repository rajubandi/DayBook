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
	<script type="text/javascript" src="js/reports.js"></script>
	<script>
	window.setTimeout(function() {
		$(".msgcss").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 5000);
</script>
<style>
table{
        width: 100%;
        margin-bottom: 20px;
		border-collapse: collapse;
    }
    table, th, td{
        border: 1px solid #cdcdcd;
    }
    table th, table td{
        padding: 10px;
        text-align: left;
    }
</style>
	<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Reports</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    				<li><a href="dashBoard">Home</a></li>
    				<li><a href="#">Financial</a></li>
					<li><a href="reports">Reports</a></li>
				</ol>
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
							<div class="panel panel-info">
					<!-- <div class="panel-heading">
						<h4>Create Reports</h4>
					</div> -->
			<div class="">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Expenses List</h4>
					</div>
					<div class="panel-body collapse in">						
						
						<!-- Row Starts -->
						<div class="row">
						
								<form:form id="ledgerBwDate-form"  commandName="reports" method="post" class="form-horizontal">
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label  class="col-sm-4 control-label">From <span style="color: red;">*</span></label>
												    <div class="col-sm-8">
														<input id="from"  name="from" autocomplete="off" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate"   onfocus="removeBorder(this.id)" />
														<span class="from_error" id="name_error"></span>
													</div>
											  	</div>
											</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  	<div class="form-group">
											    <label  class="col-sm-4 control-label">To <span style="color: red;">*</span></label>
											    <div class="col-sm-8">
													<input id="to" name="to" autocomplete="off" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate"  onchange="getDatabtwdates()" onfocus="removeBorder(this.id)" />
													<span class="to_error" id="name_error"></span>
												</div>
										  	</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  	<div class="form-group">
											    <label  class="col-sm-4 control-label">Account Head <span style="color: red;">*</span></label>
											    <div class="col-sm-8">
											    <form:select path="accountHead" id="accountHead" name="accountHead" class="form-control "  onchange="getDatabtwdatesWithAccount()">
															<form:option value="" >-- Choose Account Head --</form:option>
															<form:options items="${accountHead}"></form:options>
												</form:select>
												<span class="accountHead_error" id="name_error"></span>
												</div>
											   
										  	</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
										  	<div class="form-group">
							<label class="col-sm-4 control-label">Month <span style="color: red;">*</span></label>
							<div class="col-sm-8">
				        		<input id="monthPicker" name="monthPicker" class="form-control "  onkeydown="removeBorder(this.id)"/>
							    <span class="monthPicker_error" id="name_error"></span>
							</div>
						</div>
					</div>
										
										<div class="col-sm-12">
											<div class="col-sm-8 col-sm-offset-2">
												<input type="button" id="ledgerBwDateSubmitId" value="Get Expenses" class="btn btn-success"/>  <!-- onclick="searchData()" -->
												<button type="button" class="btn btn-danger" id="cancel2"	>Cancel</button>
											</div>
										</div>
										
							</form:form>
									</div>
								</div>
								<!-- Row Ends -->
							</div>
						</div>
						
						<!-- Row Starts -->
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top:20px">
							<div class="panel panel-info">
					<div class="panel-heading">
						<h4 id="onDateExpensesHeading"> Monthly Expenses</h4>
					</div>
					<div class="panel-body collapse in">
										<div class="table-responsive">
											<div  class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="dayWiseExpenses" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Date</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Account Head</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Discription</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Amount</th>
<!-- 																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th> -->
																</tr>
															</thead>
															<tbody></tbody>
															<tfoot><tr><th colspan="3">Total</th><th  id="monthlyExpensesTotal">0.00</th></tr></tfoot>
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
							</div>
							</div>
							</div>
							</div>
							
<script>
var listOrders1 = ${dataJson};
if (listOrders1 != "") {
	displayTableDayWiseExpenses(listOrders1);
}

var getTabName = window.location.pathname.split('/')[2];
$("#conf_li").addClass('active');
$("#conf_li ul").css('display','block');
$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');

</script>