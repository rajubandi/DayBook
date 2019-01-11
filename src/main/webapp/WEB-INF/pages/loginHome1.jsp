<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<link rel="shortcut icon" href="img/logo (1).png">
		<!-- <title>Vijnana Vihara Nutakki</title> -->
<title>Day-Book</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
		<link href="css/animate.css" rel="stylesheet" media="screen" />
		<link href="css/main.css" rel="stylesheet" media="screen" />
		<link rel="stylesheet" type="text/css" href="css/datepicker.css" />
		<link href="css/barIndicator.css" rel="stylesheet" />
<!-- 		<link href="fonts/font-awesome.min.css" rel="stylesheet" /> -->

		<!-- HTML5 shiv and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="js/html5shiv.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<style type="text/css">
.blog {
    margin-bottom: 20px;
    background: #eee;
    position: relative;
}
.blog-header {
    position: relative;
    padding: 2px 15px;
    border: none !important;
    border-bottom: 0;
}
span.has-error, #already_exist, .subjects_error
{
  font-weight:normal;
  color:red;
  margin:0px;
  display: block !important;
  position: absolute;
}
.lf
{
	margin-top: 8em;
}
@media (max-width:660px)
{
	.lf{
		margin-top: 1em;
	}
	#scrollUp{
		display: none !important; 
	}
}
  </style>
<script>
var isClick = 'No';
    history.forward();
</script>
	</head>
<body style="background: #8eb6c1;">

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
					<div class="spacer">
						<!-- Row Starts -->
						<div class="row" style="">
							<div class="col-lg-4 col-md-4 hidden-sm hidden-xs"></div>
							
							<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 fadeInDown animated">
								<div class="blog lf">
									<div class="blog-header" align="center" style="height:89px;background: #dedede;">
										<!-- <img src="img/VVN.png" align="middle" style="width: 65px;height: 65px;" alt="Vijnana Vihara Nutakki">
										&nbsp; &nbsp; &nbsp; <b style="font-size: 25px;color: white !important">VVN</b> -->
<!-- 										<img src="img/loginp.png" align="middle" style="height: ;" alt="viekananda" class="img-responsive"> -->
										&nbsp; &nbsp; &nbsp; <!-- <b style="font-size: 25px;color: white !important">GRETNALTES</b> -->
									</div>
									<div class="blog-body" id="loginFormDiv">

										<form id="login-form" action="LoginHome1" method="post" class="form-horizontal" role="form">
											<div class="form-group">
											    <label for="inputEmail3" class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Role: </label>
											    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
										      		<select name="rolId" id="rolId" class="form-control"  required>
														<option value="">-- Choose Role --</option>
														<option value="1">Administrator</option>
<!-- 														<option value="2">Accountant</option> -->
<!-- 														<option value="3">Parent</option> -->
													</select>
												</div>
											</div>
											<div class="form-group">
											    <label for="inputEmail3" class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Username: </label>
											    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
													<input type="text"  class="form-control" placeholder="Enter Username" autocomplete="off" name="name" id="name" required/>
												</div>
											</div>
											<div class="form-group">
											    <label for="inputEmail3" class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Password: </label>
											    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
											    	<input type="password"  class="form-control" placeholder="Enter Password" name="password" id="password" required/>
											    </div>
											 </div>
											 <div class="form-group">
											 	<div class="col-sm-8 col-sm-offset-3">
											  		<input type="submit" class="btn btn-success"  value="Login"/>
											  		<button type="button" id="cancel"  class="btn btn-danger">Reset</button>
											  	</div>
											  	<div class="col-sm-8 col-sm-offset-3" style="margin-top:8px;">
											  		<a style="color: blue; margin-top:8px;" href="#" onclick="forgottenPassword()">Forgot Password?</a>
											  	</div>
											  	
											 </div>
											 <div class="form-group">
												<div class="col-sm-8 col-sm-offset-3">
												<span  id="changePasswordMsg" class='' style='color: red;'></span>
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
										</form>											
									</div>
									
									
										<form id="forgotPassword-form" action="forgotPassword" method="post" class="form-horizontal" role="form">
											<div class="blog-body" id="forgotPasswordDiv" style="display: none;">
		
												<fieldset id="roleId_fieldset" class="">
													<div id="roleDiv" style="display: none;">
														<div class="form-group" >
														    <label for="inputEmail3" class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Role: </label>
															    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
														      		<select id="newPswRolId" class="form-control selectcheck  validate"    onkeydown="removeBorder(this.id)">
																		<option value="0">-- Choose Role --</option>
																		<option value="1">Administrator</option>
																		<option value="2">Accountant</option>
																		<option value="3">Parent</option>
																	</select>
																</div>
															</div>
															
															<div class="form-group">
														 	<div class="col-sm-8 col-sm-offset-3">
														  		<input type="button" class="btn btn-success" id="nextButton"  value="Next"/>
														  	</div>
														 
														 </div>
														 	
														</div>
												</fieldset>
												<fieldset id="emailOrPhoneDiv_fieldset" class="">
														<div id="emailOrPhoneDiv" style="display: none;" >
															<div class="form-group"  >
															    <label for="inputEmail3" class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Mobile Number:</label>
															    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 ">
																	<input id="newPswEmailOrPhone" class="form-control mobileNO validate " placeholder="Mobile Number" autocomplete="off" maxlength="10"  />
																</div>
															</div>
														
															 <div class="form-group">
															 	<div class="col-sm-8 col-sm-offset-3">
															  		<input type="button" id="forgottenPasswordSubmit" class="btn btn-success"  value="Submit"/>
															  	</div>
															
															 </div>
														 </div>
												 </fieldset>
											 </div>
										</form>											
									</div>
									
								</div>
							</div>
							
						</div>
						<!-- Row Ends -->
					</div>
					<!-- Spacer ends -->

				</div>
				<!-- Container fluid ends -->


			<!-- Footer starts -->
			<!-- <footer class="navbar-fixed-bottom">Copyright Akshara Bharathi Vidyalayam, Mangalagiri.</footer> -->
			<!-- Footer ends -->
			
			<script src="js/bootstrap.min.js"></script>
		<script src="js/scrollup/jquery.scrollUp.js"></script>
<!--     	<script src="js/flot/jquery.flot.tooltip.min.js"></script> -->

<script type="text/javascript">
var isClick = 'Yes';
function forgottenPassword(){
	
	$("#loginFormDiv").hide();
	//$("#login-form").hide();
	$("#forgotPasswordDiv").show();
	$("#roleDiv").show();
	//$("#forgotPasswordDiv").css("style", "");
	
	//$("#forgotPasswordDiv").css({ 'display': "block" });
	//$("#roleDiv").css({ 'display': "block" });
}
	 	



  $("#login-form").validate({
	errorElement: 'span',
    errorClass: 'has-error',
	rules:
    {
		rolId:{required: true},
		name:{required: true},
		password:{required: true},
	},
	messages:
   	{
		rolId:{required: 'Select Role'},
		name:{required: 'Username'},
		password:{required: 'Password'},
	}	
  });
  $('#cancel').click(function () {
    $("#login-form").validate().resetForm();
    $("#login-form").removeClass("has-error");
    $("#rolId").val('');
    $("#name").val('');
    $("#password").val('');
    $("#login-form").addClass("form-horizontal");
  });
  
  $(function () {
	  
	  jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
		   phone_number = phone_number.replace(/\s+/g, ""); 
		 return this.optional(element) && phone_number.length > 9 &&
		   phone_number.match(/^[7-9]\d+$/) && phone_number != "";
		}, "Invalid Mobile Number");
	  
	  jQuery.validator.addMethod('selectcheck', function (value,element) {
			 return this.optional(element) || (value != '0');
	    }, "Select your role");
	  
	 /*  $.validator.addMethod("eitherEmailPhone", function(value, element) {
		 value = value.replace(/\s+/g, ""); 
          isPhone = this.optional(element) && value.length > 9 && value.match(/^[7-9]\d{9}$/);
          isEmail = this.optional(element) && /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(value);

          return isPhone || isEmail;

      }, "Please enter either phone or e-mail");
 */
		$('.validate').keydown(function() {
			var id = $(this).attr('id');
			removeBorder(id);
		});
		//remove borders
		function removeBorder(el){	
			  $("#"+el).css("border", "");
			  $("#"+el).css('color','black');
			  $('#'+el).addClass('default-class');
			  if ($("#" + el+"_chosen").length)
				{
					$("#" +el+"_chosen").children('a').css('border-color','black');
				}
		}

	  
	  
	    $('input[placeholder]').blur();
	    $('#rol').on('change',function () {
	        var ph = $(this).val();
	        if(ph == 'Administrator')
	        {
	        	$("#uname").attr("placeholder", "Enter Username").blur();
	            $("#upass").attr("placeholder", "Enter Password").blur();
	        }
	        else if(ph == 'Faculty') 
	        {
	            $("#uname").attr("placeholder", "Enter Registered Faculty Name as Username").blur();
	            $("#upass").attr("placeholder", "Enter Registered Mobile Number as Password").blur();
	        }
	        else if(ph == 'Parent') 
	        {
	            $("#uname").attr("placeholder", "Enter Registered Father Name as Username").blur();
	            $("#upass").attr("placeholder", "Enter Registered Mobile Number as Password").blur();
	        }
	    });
	    
	   
	    
	 $('#nextButton,#forgottenPasswordSubmit').click(function(){
		 
				 
		 $('#forgotPassword-form').validate({ // initialize the plugin
			 errorElement: 'span',
			    errorClass: 'has-error',
		        rules: {
		        	newPswRolId: {required: true,selectcheck: true},
		        	newPswEmailOrPhone:{required: true, number: true,mobileNO:true, minlength: 10, maxlength: 10}
		        },
		    	messages:
		       	{	newPswRolId:{required:'Select your role'},
		    		newPswEmailOrPhone:{required: 'Mobile Number' },
		    	},
		    	 errorPlacement: function(error, element){
		   	      if(element.attr("name") == "newPswRolId")
		   	        error.insertAfter(".newPswRolId_error").css("color", "red");
		   	       else if(element.attr("name") == "newPswEmailOrPhone")
		   	        error.insertAfter(".newPswEmailOrPhone-error").css("color","red");
		   	      else
		   	        error.insertAfter(element);
		   	      }
		    	
		    }); 
		 
		 
				if( this.id == "nextButton" && $("#forgotPassword-form").valid() == true) {
						$("#roleDiv").hide();
						$("#emailOrPhoneDiv").show();	
						//$("#forgotPassword-form").valid() == false;
					}else if(this.id == "forgottenPasswordSubmit" &&  $("#forgotPassword-form").valid() == true){
					
						  
						var newPswRolId= $('#newPswRolId').val();
						  var newPswEmailOrPhone= $('#newPswEmailOrPhone').val();  
						  
						$.ajax({
							type : "POST",
							url : "changePassword.json",
							data : "newPswRolId=" + newPswRolId+"&newPswEmailOrPhone="+newPswEmailOrPhone,
							dataType : "json",
							success : function(response) {
								
								//$("#login-form").hide();
								console.log(response);
								$("#forgotPasswordDiv").hide();
								$("#roleDiv").hide();
								
								$("#loginFormDiv").show();
								$("#changePasswordMsg").text(response);
								$('#changePasswordMsg').fadeIn('slow').delay(5000).fadeOut('slow');
								
								
								if(isClick == "Yes"){
									$('#newPswRolId').val('0');
									$("#emailOrPhoneDiv").hide();	
									$("#forgotPassword-form").validate().resetForm();
								}
							},
						
						});
						
						
						
					}else {
					
						event.preventDefault();
						return false;
					}
			 
			 
			 
		 });
	    
	    
	    
	});

</script>
		
</body>
</html>