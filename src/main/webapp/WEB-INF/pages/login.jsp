<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/demos.css" />
<link rel="stylesheet" href="js/jqueryui.css" />
<link rel="stylesheet" href="css/jquery-ui.css" />
<link rel="stylesheet"
	href="js/jquery-ui-1.10.3/themes/base/jquery-ui.css" />
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/MntValidator.js"></script>
<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

.error {
	border: 2px solid #f00;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#submitId').click(function(event) {
			$('#loginForm').validate({
				rules : {
					userName : {
						required : true,
						alphanumeric : true,
						specialcharacters : true

					},
					password : {
						required : true
					}

				},

				errorPlacement : function() {
					return false;
				},
			/* messages : {
				userName : {
					required : "<font style='color: red;'><b>User Name is Required</b></font>",
					alphanumeric : "<font style='color: red;'><b>First letter should be an alphanumeric.</b></font>",
					specialcharacters : "<font style='color: red;'><b>Special Characters except &,_ are not allowed </b></font>"
				},
				password:{required : "<font style='color: red;'><b>Password is Required</b></font>",}

			}, */

			});

		});
	});
</script>
</HEAD>
<BODY>

	<div class="header"></div>
	<div class="content">
		<div class="leftpanel">
			<div class="flip-container"
				ontouchstart="this.classList.toggle('hover');">
				<div class="flipper">
					<div class="front" id="leftpanel">
						<!-- front content -->
						<table class="table">
							<tr>
								<td>
									<!--<p class="vbox">Integration</P>
<p class="vbox">Stock Optimization</P>
<p class="vbox">Improved Customer Service</P>--> <img
									src="css/images/147852.png" class="imagealign" />

								</td>
								<td></td>
							</tr>
						</table>
					</div>
					<div class="back">
						<!-- back content -->
						<div class="contentdata">PROVIDES OPERATIONAL EXCELLENCE
							WITH AN INTEGRATED RETAIL PLANNING SOLUTION</div>

						<div class="contentdata1">SIMPLIFIES THE RETAIL PLANNING
							PROCESS TO GAIN GREATER VISIBILITY AND CONTROL OF YOUR BUSINESS</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<div class="rightpanel">
		<div>
			<div align="center">
				<c:forEach var="FailMessage" items="${FailMessage}">
					<font color="red" size="4"> <c:out value="${FailMessage}"></c:out></font>
				</c:forEach>
			</div>
			<form:form method="post" action="loginUserHome.htm" id="loginForm" commandName="loginCmd">
				<div class="form">
					<table class="tableGeneral">
						<!--  <tr>
							<td>Company ID</td>
							<td><input type="text" placeholder="Company ID"></td> 
						</tr> -->
						<tr>
							<td colspan="2"><c:forEach var="FailMessage"
									items="${FailMessage}">
									<font color="red" size="5"> <c:out
											value="${FailMessage}"></c:out></font>
								</c:forEach></td>
						</tr>
						<tr>
							<td colspan="2"><spring:message code="label.lang" /> : <a
								href="?lang=en">English</a>|<a href="?lang=hi">Hindi</a>|<a
								href="?lang=te">Telugu</a></td>
						</tr>
						<tr>
							<td><label><spring:message code="label.username" /></label></td>
							<td><input type="text" name="userName" value=""
								placeholder="User Name" maxlength="30"></td>
						</tr>
						<tr>
							<td><label><spring:message code="label.password" /></label></td>
							<td><input type="password" name="password" value=""
								placeholder="Password" maxlength="20"></td>
						</tr>
						<tr>
							<td><input type="reset" class="button"
								value="<spring:message code="label.clear" />" /> <input
								type="submit" class="button"
								value="<spring:message code="label.login" /> " id="submitId" /></td>
						</tr>
					</table>
				</div>
			</form:form>
			<div class="forgot">
				<spring:message code="label.forgot" />
			</div>
		</div>
		<div class="data">
			<spring:message code="label.autusers" />
		</div>
	</div>
</BODY>

</HTML>
 --%>


<%-- <!doctype html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<head>
<meta charset="utf8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Neighberhood Platform</title>
<style>
.your-class::-webkit-input-placeholder {
    color: red;
}
.default-class::-webkit-input-placeholder {
    color: red;
}
</style>
<!-- <link rel="stylesheet" href="Branding/css/nivo-slider.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="Branding/css/login-style.css" /> -->
<script src="Branding/js/login.js"></script>

<script type="text/javascript" src="Branding/js/jquery.vticker-min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#news-container').vTicker({
			speed : 50000000,
			pause : 30,

			showItems : 12.5
		});
	});
</script>
<style type="text/css">
.required {
	color: red;
	font-style: Bold;
}

.error {
	border: 2px solid #f00;
}
</style>
 <style>
      @import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
	margin: 0;
	padding: 0;
	background: #fff;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(http://ginva.com/wp-content/uploads/2012/07/city-skyline-wallpapers-008.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
	z-index: 0;
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header_1{
	position: absolute;
	top: calc(50% - 35px);
	left: calc(50% - 255px);
	z-index: 2;
}

.header_1 div{
	loat: left;
    color: #6F5252;
    font-family: 'Exo', sans-serif;
    font-size: 35px;
    font-weight: 500;
    margin-top: -74px;
}

.header_1 div span{
	color: #5379fa !important;
}

.login{
	position: absolute;
	top: calc(50% - 149px);
	left: calc(50% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.login input[type=text]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}
.logo{
    margin-left: -78px;
    margin-top: -18px;
}
.submit{
    width: 118px;
    border: 2px solid #8554B7;
    color: black;
    height: 30px;
    border-radius: 12px;
}
.login input[type=password]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

.login input[type=button]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.login input[type=button]:hover{
	opacity: 0.8;
}

.login input[type=button]:active{
	opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=button]:focus{
	outline: none;
}

::-webkit-input-placeholder{
   color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}
    </style>
<script type="text/javascript" src="Branding/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="Branding/js/MntValidator.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#email').focus();
		$('#login').click(function(event) {
			
			 if($('#email').val().length == 0  || $('#password').val().length == 0  ){			    
			 if($('#email').val().length == 0 ) {
			    $('#email').css('color','red');
			    $("#email").css("border-color","red");
			    $("#email").attr("placeholder","UserName is Required");
			    $('#email').addClass('your-class');
			     			    } 
			 if($('#password').val().length == 0 ) {
				$('#password').css('color','red');
				$("#password").css("border-color","red");
				$("#password").attr("placeholder","Password is Required");
				$('#password').addClass('your-class');
				     			 }
				 return false;
			}	

		});
	});
</script>
 <script type="text/javascript">
function removeBorder1(el){
	 $("#"+el).css("border", "2px solid #767676"); 	 
	  $("#"+el).css('color','black');
	  $('#'+el).addClass('default-class'); 
}
function addBorder(el){
	 $("#"+el).css("border", "1px solid #AAA"); 	 
	  $("#"+el).css('color','black');
	  $('#'+el).addClass('default-class'); 
}
</script> 
</head>
<body>
<!-- Google Tag Manager -->


<!-- End Google Tag Manager -->
    <div class="body"></div>
		<div class="grad"></div>
		<div class="header_1">
		    <div><img class="logo" src="images/logo.png" alt="Aurospaces logo"></div>
			<div>Aurospaces</div>
		</div>
		<br>
		<div class="login">
								<form:form id="loginForm" action="loginUserHome.htm" method="post" commandName="loginCmd" >
								<!-- <img src="images/compu.png" width="359" height="52" alt=""> -->
											<label style="font-family:Constantia"></label><p class="remember">User Name</p><input type="text" name="mobileOrEmail"
												id="email" style="width: 200px;" onkeydown="removeBorder(this.id)" tabindex="1" />
											<label for="password" style="font-family:Constantia"></label><p class="remember">Password</p><input type="password"
												name="password" id="password" style="width: 200px;" onkeydown="removeBorder(this.id)" tabindex="2" />
											<div>
											<label for="checkbox"> <input type="checkbox"

												id="checkbox" onfocus="removeBorder1(this.id)" onblur="addBorder(this.id)" /></label><p class="remember"> Remember me</p>
</div>
										 <input class="submit" type="submit" id="login" value="SignIn" id="submitId" onfocus="removeBorder1(this.id)" onblur="addBorder(this.id)">

									<!-- <div class="block-footer"> -->
								<!-- <aside class="block-footer-left1 sucessfully"> -->
								
									<div id="addsus" style="display: block;">
										<c:forEach var="success" items="${param.Fail}">
										<!-- <div class="boxclass"> -->
											<div class="errmsgclass">												
											<span style="color: red;"><spring:message code="label.loginFail" /></span>
											</div>
											<!-- </div> -->
										</c:forEach>
									</div>
									
									<div id="salesFail" style="display: block;">
										<c:forEach var="success" items="${param.SalesFail}">
										<!-- <div class="boxclass"> -->
											<div class="errmsgclass">												
											<span style="color: red;"><spring:message code="label.salesLoginFail" /></span>
											</div>
											<!-- </div> -->
										</c:forEach>
									</div>
									<!-- </aside> -->
									<!-- </div> -->
								</form:form>
								
		</div>
			<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
			<script type="text/javascript">
				$(window).load(function() {
					$('#slider').nivoSlider({
						directionNavHide : false
					});
				});
			</script>
			<footer id="footer">
      <p class="copyrigh" style="font-family:Arial"> &copy; All Rights reserved by Aurospaces Soft PVT.Ltd.</p>
    </footer>
			
</body>

</html>  --%>




<!-- -------------------------------------login page starts------------------------- -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aurospaces :: Login</title>
<link rel="shortcut icon" href="images/ico/favicon.ico">
<script type="text/javascript" src="Branding/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="Branding/js/MntValidator.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);

@import
	url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300)
	;

body {
	margin: 0;
	padding: 0;
	background: #fff;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body {
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image:url(./nbdimages/Home/internet.jpg);
	background-size: cover;
	/* -webkit-filter: blur(5px); */
	z-index: 0;
}

.grad {
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(0, 0
		, 0, 0)), color-stop(100%, rgba(0, 0, 0, 0.65)));
	/* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header_1 {
	position: absolute;
	top: calc(50% - 35px);
	left: calc(50% - 255px);
	z-index: 2;
}

.header_1 div {
	float: left;
	color: #6F5252;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 500;
	margin-top: -250px;
	margin-left:95%;
}

.header_1 div span {
	color: #5379fa !important;
}

.login {
	position: absolute;
	top: calc(50% - 149px);
	left: calc(44% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.login input[type=text] {
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.logo {
	margin-left: -78px;
	margin-top: -18px;
}
.user{
    color: #5D494D;
    -moz-color:#5D494D;
    font-size: 15px;
    font-weight: 600;
}
.pass{
    color: #5D494D;
    -moz-color:#5D494D;
    font-size: 15px;
    font-weight: 600;
 }
.submit {
	width: 118px;
	border: 2px solid #8554B7;
	color: black;
	height: 30px;
	border-radius: 12px;
}

.login input[type=password] {
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 0px;
}

.login input[type=button] {
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.login input[type=button]:hover {
	opacity: 0.8;
}

.login input[type=button]:active {
	opacity: 0.6;
}

.login input[type=text]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.login input[type=password]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.login input[type=button]:focus {
	outline: none;
}
.your-class::-webkit-input-placeholder {
    color: red;
}
::-moz-input-placeholder {
	color: red;
}
</style>
<script src="Branding/js/login.js"></script>
<script type="text/javascript" src="Branding/js/jquery.vticker-min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#news-container').vTicker({
			speed : 50000000,
			pause : 30,

			showItems : 12.5
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#email').focus();
				$('#login').click(
						function(event) {

							if ($('#email').val().length == 0
									|| $('#password').val().length == 0) {
								if ($('#email').val().length == 0) {
									$('#email').css('color', 'red');
									$("#email").css("border-color", "red");
									$("#email").attr("placeholder","UserName is Required");
									$('#email').addClass('your-class');
								}
								if ($('#password').val().length == 0) {
									$('#password').css('color', 'red');
									$("#password").css("border-color", "red");
									$("#password").attr("placeholder",
											"Password is Required");
									$('#password').addClass('your-class');
								}
								return false;
							}

						});
			});
</script>
<script type="text/javascript">
	function removeBorder1(el) {
		$("#" + el).css("border", "2px solid #8554B7");
		$("#" + el).css('color', 'black');
		$('#' + el).addClass('default-class');
	}
	function addBorder(el) {
		$("#" + el).css("border", "2px solid #8554B7");
		$("#" + el).css('color', 'black');
		$('#' + el).addClass('default-class');
	}
</script>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header_1">
		<div>
			<img class="logo" src="images/logo.png" alt="Aurospaces logo">
		</div>
		<div>Aurospaces</div>
	</div>
	<br>
	<div class="login">
		<form:form id="loginForm" action="loginUserHome.htm" method="post"
			commandName="loginCmd">
			<label style="font-family: Constantia"></label>
			<p class="user">User Name</p>
			<input type="text" name="mobileOrEmail" id="email"
				style="width: 200px;background-color:#eee;" onkeydown="removeBorder(this.id)" tabindex="1" />
			<label for="password" style="font-family: Constantia"></label>
			<p class="pass">Password</p>
			<input type="password" name="password" id="password"
				style="width: 200px;background-color:#eee;" onkeydown="removeBorder(this.id)" tabindex="2" />
			<div style="padding-top: 20px;">
				<label for="checkbox"> <input type="checkbox" id="checkbox"
					onfocus="removeBorder1(this.id)" onblur="addBorder(this.id)" />&nbsp; &nbsp;Remember me  </label>
				<p>&nbsp;</p>
			</div>
			<input class="submit" type="submit" id="login" value="SignIn"
				id="submitId" onfocus="removeBorder1(this.id)"
				onblur="addBorder(this.id)">
			<div id="addsus" style="display: block;">
				<c:forEach var="success" items="${param.Fail}">
					<div class="errmsgclass">
						<span style="color: red;"><spring:message
								code="label.loginFail" /></span>
					</div>
				</c:forEach>
			</div>
			<div id="salesFail" style="display: block;">
				<c:forEach var="success" items="${param.SalesFail}">
					<div class="errmsgclass">
						<span style="color: red;"> <spring:message
								code="label.salesLoginFail" /></span>
					</div>
				</c:forEach>
			</div>
		</form:form>
	</div>
	<script type="text/javascript">
		$(window).load(function() {
			$('#slider').nivoSlider({
				directionNavHide : false
			});
		});
	</script>
	<footer>
		<p class="copyrigh" style="font-family: Arial">&copy; All Rights
			reserved by Aurospaces Soft PVT.Ltd.</p>
	</footer>
</body>
</html>
