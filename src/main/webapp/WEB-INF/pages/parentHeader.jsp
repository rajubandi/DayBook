<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8" />
		<link rel="shortcut icon" href="img/logo (1).png">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<!-- <title>AKSHARA BHARATHI VIDYALAYAM</title> -->
			<title>Vivekanada Vidhyalayam</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
		<link href="css/animate.css" rel="stylesheet" media="screen" />
		<link href="css/main.css" rel="stylesheet" media="screen" />
		<link href="css/accordion.css" rel="stylesheet" media="screen" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" />
		<link href="css/barIndicator.css" rel="stylesheet" />
		<link href="css/chosen.css" rel="stylesheet"/>
		<link href="fonts/font-awesome.min.css" rel="stylesheet" />
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
		 <link rel="stylesheet" href="css/font-awesome.css">
		
		<!-- Data Tables -->
		<link href="css/datatables/dataTables.bs.min.css" rel="stylesheet"/>
		<link href="css/datatables/autoFill.bs.min.css" rel="stylesheet"/>
		<link href="css/datatables/fixedHeader.bs.css" rel="stylesheet"/>
		<link href="css/datatables/buttons.bs.css" rel="stylesheet"/>
		
<!-- 		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
		<script src="js/jquery.js"></script>
		
		<!-- HTML5 shiv and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="js/html5shiv.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
<style type="text/css">
span.has-error, #already_exist, .subjects_error
{
  font-weight:normal;
  color:red;
  margin:0px;
  display: block !important;
  position: absolute;
}
th{text-align: center;}
.mobileView{
		display: none !important;
	}
@media (max-width:660px)
{
	#scrollUp{
		display: none !important; 
	}
	.systemView{
		display: none !important;
	}
	.mobileView{
		display: block !important;
	}
}
.loadingajax{
    background-color: #333;
    opacity: 0.9;
    position: fixed;
    left: 0px;
    top: 0px;
    z-index: 99999999999;
    height: 100%;
    width: 100%;
    overflow: hidden;
    background-attachment: fixed;
    background-image: url("img/hloader.gif");
    background-position: center;
    background-repeat: no-repeat;
}
</style>
	</head>  

	<body>
<%
String url =request.getScheme() + "://" + request.getServerName() +      ":" +   request.getServerPort() +  request.getContextPath();

// System.out.println(url);
%>
<%-- <c:out value="${sessionScope.cacheUserBean.name }"/> --%>
		 <%
					HttpSession sess = request.getSession(false);
					if (sess.getAttribute("cacheUserBean") == null) {
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePage");
						dispatcher.forward(request, response);
					}
					
			%>  
			
		<!-- Header Start -->
		<header style="height: 50px;">

			<!-- Logo starts -->
			<div class="logo">
				<a href="#">
<!-- 					<a href="dashBoard" style="display:inline !important"><img src="img/ABV.png" style="width: 65px;height: 65px;" alt="AKSHARA BHARATHI VIDYALAYAM">&nbsp; &nbsp; &nbsp; <b style="font-size: 25px;color: white !important">ABV</b></a> -->
<!-- 					<a href="dashBoard" style="display:inline !important"><img src="img/logo (1).png" style="width: 65px;height: 65px;" alt="GRETNALTES">&nbsp; &nbsp; &nbsp; <b style="font-size: 25px;color: white !important"></b></a> -->
					<span class="menu-toggle hidden-xs" style="margin-top: 0px;">
						<i class="fa fa-bars"></i>
					</span>
				</a>
			</div>
			<div class="pull-right hidden-sm hidden-xs">
				<!-- <h1 style="color: white;font-family: sans-serif;margin: 10px;">Akshara Bharathi Vidyalayam</h1> -->
				<img src="img/logo.png" class="img-responsive" />
			</div>
			<!-- Logo ends -->

			<!-- Mini right nav starts -->
			<div class="pull-right">
				<ul id="mini-nav" class="clearfix">
					<li class="list-box hidden-lg hidden-md hidden-sm" id="mob-nav">
						<a href="#">
							<i class="fa fa-reorder"></i>
						</a>
					</li>
					
				</ul>
			</div>
			<!-- Mini right nav ends -->

		</header>
		<!-- Header ends -->

		<!-- Left sidebar starts -->
		<aside id="sidebar">

			<!-- Menu start -->
			<div id='menu'>
				<ul>
					<li class="">
						<a href='parentDashboard'>
							<i class="fa fa-tachometer"></i> <span>Dashboard</span>
<!-- 							<span class="current-page"></span> -->
						</a>
					</li>
					<li class="">
						<a href='changePasswordHome'>
							<i class="fa fa-eye-slash"></i> <span>Change Password</span>
<!-- 							<span class="current-page"></span> -->
						</a>
					</li>
					<li class="">
						<a href='parentViewStudent'>
							<i class="fa fa-users"></i> <span>View Student Details</span>
<!-- 							<span class="current-page"></span> -->
						</a>
					</li>
					<li class="">
						<a href='viewAttendanceParentHome'>
							<i class="fa fa-address-card-o"></i> <span>View Attendance</span>
<!-- 							<span class="current-page"></span> -->
						</a>
					</li>
					<li class="">
						<a href='viewEventsParent'>
							<i class="fa fa-envelope-open-o"></i> <span>View Notifications</span>
<!-- 							<span class="current-page"></span> -->
						</a>
					</li>
		<li><a style="" href="parentFeedback"><i class="fa fa-circle-o text-warning"></i><span>Send Feedback</span></a></li>
<!-- 		<li><a style="" href="http://www.gretnaltes.org/" target="_blank"><i class="fa fa-circle-o text-success"></i><span>Visit Site</span></a></li> -->
		<li><a style="" href="#" onclick="logout()"><i style="" class="fa fa-power-off"></i><span>Logout</span></a></li>
					
				</ul>
		  </div>
			<!-- Menu End -->

			<!-- Freebies Starts -->
			<div class="freebies">
				
				<!-- Sidebar Extras -->      
				<div class="sidebar-addons">
					<ul class="views">
						
					</ul>
				</div>

			</div>
		</aside>
		<!-- Left sidebar ends -->


	<script type="text/javascript">
	

 	function logout(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/logoutHome1.htm';
	}
	</script>
	 
	