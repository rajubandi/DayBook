
<%@ include file="parentHeader.jsp" %>
	<link href="css/datepicker1.css" rel="stylesheet">
	
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
<!-- 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">Send Feedback</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
					 <ol class="breadcrumb">
    	<li><a href="parentDashboard">Home</a></li>
    	<li><a href="#">Send Feedback</a></li>
     	</ol>
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Send Feedback</h4>
					</div>
					<div class="panel-body collapse in">
										<form:form   method="post" action="parentSendFeedback" commandName="packCmd" class="form-horizontal" id="feedback-form" >
										<div class="row">
											
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Student:</label>
												    <div class="col-sm-8">
												    	<form:select path="name" class="form-control" tabindex="1" onchange="searchStudent();" required="true">
															<form:option value="">-- Choose Student--</form:option>
															<form:options items="${students}"></form:options>
														</form:select>
														<span class="name_error" id="name_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Message:</label>
												    <div class="col-sm-8">
														<textarea placeholder="Enter Message" class="form-control" name="message" id="message" tabindex="2"></textarea>
														<span class="message_error" id="message_error"></span>
													</div>
												</div>
											</div>
											
										</div>
										<div class="row">
											<div class="col-sm-8 col-sm-offset-4">
												<div class="form-group">
											  		<div class="col-sm-8 col-sm-offset-2">
														<input type="submit" class="btn btn-success" value="Send"  tabindex="3"/>
														<input type="reset" class="btn btn-danger" id="cancel" tabindex="4"/>
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

<script type="text/javascript">

$("#feedback-form").validate({
    errorElement: 'span',
    errorClass: 'has-error',
	rules:
	{
	    name:{required:	true},
	    message:{required:	true}
	},
	messages:
	{
	    name:{required: 'Please Choose Student'},
	    message:{required: 'Please Enter Message'},
	},
	errorPlacement: function(error, element){
	      if(element.attr("name") == "name")
	        error.insertAfter(".name_error").css("color", "red");
	      else if(element.attr("name") == "message")
		    error.insertAfter(".message_error").css("color", "red");
	      else
		    error.insertAfter(element);
	}
});
	$('#cancel').click(function () {
	    $("#feedback-form").validate().resetForm();
	    $("#feedback-form").removeClass("has-error");
	    $("#name").val('');
	    $("#message").val('');
	    $("#feedback-form").addClass('form-horizontal');
    });

</script>
<%@ include file="parentFooter.jsp" %>