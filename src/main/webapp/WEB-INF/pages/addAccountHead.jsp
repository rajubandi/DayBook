<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script type="text/javascript" src="js/addAccountHead.js"></script>
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title" id="headId">Day-Book Categories</div>
			</div>
			
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">
				<!-- Container fluid Starts -->
				<div class="container-fluid">
				<ol class="breadcrumb">
    			<li><a href="dashBoard">Home</a></li>
    			<li><a href="#">Financial</a></li>
				<li><a href="addAccountHead">Day-Book Categories</a></li>
				</ol>
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">							

			<div class="col-md-4">
			<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Account Head Creations</h4>
					</div>
                    
                    
                     <div class="panel-body">
									<form:form action="addAccountName.htm" commandName="packCmd" method="post" id="cls-form" class="form-horizontal">
											<div class="form-group">
											    <label for="inputEmail3" class="col-sm-4 control-label">Account Head Name <span style="color: red;">*</span></label>
											    <div class="col-lg-6 col-md-6 col-sm-6">
													<form:input path="name" class="form-control nospecialCharacter onlyCharacters" tabindex="1" placeholder="Account Head Name" required="true"/>
													<span class="name_error" id="name_error"></span>
												</div>
											</div>
											<form:hidden path="id"/>
												<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-4">
													<input type="submit" id="submitId" value="Submit" class="btn btn-success" tabindex="2"/>
													<button type="button" class="btn btn-danger" id="cancel" tabindex="3">Reset</button>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-8 col-sm-offset-4">
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
									</div>
									<div class="col-md-8 gutter">
									<div class="panel panel-info">
					<div class="panel-heading">
						<h4>List Of Account Names</h4>
					</div>  
                      <div class="panel-body">
									<div class="blog">
									
									<div class="blog-body">
										<div class="">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Account Name</th>
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
								</div></div></div>
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