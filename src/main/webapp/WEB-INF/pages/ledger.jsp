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
	<script type="text/javascript" src="js/ledger.js"></script>
	
	<link href="css/datepicker1.css" rel="stylesheet">
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
	
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Ledger</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    				<li><a href="dashBoard">Home</a></li>
    				<li><a href="#">Financial</a></li>
					<li><a href="ledger">Ledger</a></li>
				</ol>
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							<div class="panel panel-info">
					<div class="panel-heading" id="createLedgerHeading">
						<h4>Create Ledger</h4>
					</div>
					<div class="panel-body collapse in">
									
									<form:form action="saveLedger" commandName="ledger" method="post" id="ledger-form" class="form-horizontal">
								            <tr><td>
										<div class="form-group" id="expensiveDiv">
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Date:<span style="color: red;">*</span></label>
												 <div class="col-sm-8">
														<form:input id="dairydate" name="dairydate" path="dairydate"  autocomplete="off" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate" type="text"  onfocus="removeBorder(this.id)" required="true"/>
														<span class="dairydate_error" id="name_error"></span>
													</div>
											</div>
										</div>
										
										
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label class="col-sm-4 control-label">Account Head<span style="color: red;">*</span></label>
												 <div class="col-sm-8">
														<form:select id="accountHeadId" name="accountHeadId" path="accountHeadId" class="form-control" >
														<form:option value="">-- Choose Account Head --</form:option>
														<form:options items="${accountHead}"></form:options>
													</form:select>
														<span class="accountHeadId_error" id="name_error"></span>
													</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
											    <label  class="col-sm-4 control-label">Description<span style="color: red;">*</span></label>
											    <div class="col-lg-8">
											    <form:hidden path="id"  />
													<form:input id="discription" name="discription" path="discription" class="form-control" placeholder="Description" required="true"/>
													<span class="discription_error" id="name_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												 <label  class="col-sm-4 control-label">Amount<span style="color: red;">*</span></label>
											    <div class="col-lg-8">
													<form:input id="amount" name="amount" path="amount" onKeyPress="validatenum(event);" class="form-control" placeholder="Amount" required="true"/>
													<span class="amount_error" id="name_error"></span>
												</div>
											</div>
										</div>
												
												<!--<button type="button" value="Add" id="add-row">Add</button> -->
											</div></td></tr>
												<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-4">
													<input type="submit" id="submitId" value="Submit" class="btn btn-success" />
													<button type="button" class="btn btn-danger" id="cancel" >Reset</button>
													</div>
												</div>
											<c:if test="${not empty msg}">
												<div class="msgcss row">
													<div class="col-sm-4 col-sm-offset-4">
														<div class="form-group">
															<div class="alert alert-${cssMsg} fadeIn animated">${msg}</div>
														</div>
													</div>
												</div>
											</c:if> 
									</form:form>
									
									</div></div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							<div class="panel panel-info">
					<div class="panel-heading">
						<h4 >To Day Expenses</h4>
					</div>
					<div class="panel-body collapse in">
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																    <th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Account Head</th>
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Description</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Amount</th>
																	<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>
																</tr>
															</thead>															
															<tbody>
																
															</tbody>
															<tfoot><tr align='center' role='row' class='odd'>
																	<th colspan='2' class='hidden-sm hidden-xs' >Total Amount</th>
																	<th colspan='2' class='hidden-sm hidden-xs' id="ledgerTotalAmount"></th>
																	</tr>
															</tfoot>
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
						
						
						
						<!-- Row Ends -->
						
					</div>
					<!-- Spacer ends -->

				</div>
				<!-- Container fluid ends -->

			</div>
			<!-- Main Container ends -->

		</div>
		<!-- Dashboard Wrapper ends -->

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

// used URL: https://stackoverflow.com/questions/21203729/regular-expression-in-javascript-to-allow-only-numbers-with-optional-2-decimals
function validatenum(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /^[0-9]*$/;    // Valid characters: only Numbers. 
	  if( !regex.test(key) ) {
	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}

var listOrders1=${expensesList};

var getTabName = window.location.pathname.split('/')[2];
$("#conf_li").addClass('active');
$("#conf_li ul").css('display','block');
$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');

if (listOrders1 != "") {
	displayTable(listOrders1);
}else{
	
	displayTable(listOrders1);
		$("#emptyMessageId").val("No Results Found");
	}
</script>