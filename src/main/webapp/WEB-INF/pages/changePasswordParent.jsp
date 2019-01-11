<%@ include file="parentHeader.jsp" %>

	<script type="text/javascript" src="js/changePasswordParent.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	
	<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">Change Password</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">
                <ol class="breadcrumb">
    	<li><a href="parentDashboard">Home</a></li>
    	<li><a href="#">Change Password</a></li>
     	</ol>
				
					<!-- Spacer starts -->
						<!-- Row Starts -->
						
						<div class="row">
						
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Create Change Password</h4>
					</div>
					<div class="panel-body collapse in">
										<form:form action="parentChangePassword" commandName="packCmd" method="post" class="form-horizontal" id="cp-form">
										<div class="row">
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Current Password</label>
												    <div class="col-sm-5">											
														<form:input path="oldPassword" type ="password"  tabindex="1" class="form-control" required="true"/>
														<span class="oldPassword_error" id="oldPassword_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">New Password</label>
												    <div class="col-sm-5">											
														<form:input path="password" type ="password" tabindex="2" class="form-control" required="true"/>
														<span class="password_error" id="password_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Confirm Password</label>
												    <div class="col-sm-5">
														<form:input path="retypePassword" type ="password" tabindex="3" class="form-control" required="true"/>
														<span class="retypePassword_error" id="retypePassword_error"></span>
													</div>
												</div>
											</div>
										
											<div class="col-lg-5 col-md-5 col-sm-7 col-sm-offset-4">
												<div class="form-group">
												  	<div class="col-sm-5 col-sm-offset-5">
														<input type="submit" class="btn btn-success" tabindex="4"/>
														<button type="button" class="btn btn-danger" id="cancel" tabindex="5">Reset</button>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7 col-sm-offset-4">
												<div class="form-group">
													<div class="col-sm-7 col-sm-offset-2">
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
								</div>
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

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<%@ include file="parentFooter.jsp" %>