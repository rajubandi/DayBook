<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		 <link rel="shortcut icon" href="img/daybookshort.png">
		<script src="js/moment.min.js"></script>
		<!-- <title>Vijnana Vihara Nutakki</title> -->
		<title>Day-Book</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
		<link href="css/animate.css" rel="stylesheet" media="screen" />
		<link href="css/main.css" rel="stylesheet" media="screen" />
<!-- 		<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" /> -->
<!-- 		<link href="css/barIndicator.css" rel="stylesheet" /> -->
<!-- 		<link href="css/chosen.css" rel="stylesheet"/> -->
<!-- 		<link href="fonts/font-awesome.min.css" rel="stylesheet" /> -->
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
		 <link rel="stylesheet" href="css/font-awesome.css">
		
		<!-- Data Tables -->
		<!--  <link href="css/datatables/dataTables.bs.min.css" rel="stylesheet"/>
		<link href="css/datatables/autoFill.bs.min.css" rel="stylesheet"/>
		<link href="css/datatables/fixedHeader.bs.css" rel="stylesheet"/>
		<link href="css/datatables/buttons.bs.css" rel="stylesheet"/>  -->
		
<!-- 		<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/> -->
		<link href="datatable/buttons.dataTables.min.css"/>
		<link rel="stylesheet" type="text/css" href="datatable/jquery.dataTables.min.css">
		

		
	
<!-- 		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
<!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script> -->
		<script src="js/jquery.js"></script> 
		
		<!-- HTML5 shiv and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="js/html5shiv.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
<style type="text/css">
@media only screen and (max-width: 1900px) and (min-width: 1280px) {
.academicyear {
padding-top: 15px;
    color: #fff;
    font-size: 14px;
    float: right;
    margin-right: 0px !important;
}
}
@media only screen and (min-width:1024px){
.academicyear {
padding-top: 15px;
    color: #fff;
    font-size: 14px;
    float: right;
    margin-right: 50px;
}
}

.table-responsive {
    min-height: .01%;
    overflow-x: inherit;
}
@media only screen and (max-width: 640px) and (min-width: 320px) {
ul#mini-nav {
 margin: -10px 0 15px -85px;
 
}
.table-responsive {
    min-height: .01%;
    overflow-x: scroll;
}
.academicyear {
display:none;}
ul#mini-nav #mob-nav {
    background-color: #2e2e2e;
    padding: 0;
    margin-top: -26px;
    margin-left: -39px;
}
.logoimg {
float:right !important;
}
header {
height: 60px !important;
    margin-top: -8px;
}
}

.msgcss
{
/* 	width: 50% !important; */
/* 	font-weight: bold; */
	margin: auto;
	text-align: center;
	top: 3px !important;
	left:0;
	right:0;
	position: fixed;
	font-size: 14px;
	z-index:99999;
}
span.has-error, #already_exist, .subjects_error
{
  font-weight:normal;
  color:red;
  margin:0px;
  display: block !important;
  position: absolute;
}
th{text-align: center;}

@media (max-width:660px)
{
	#scrollUp{
		display: none !important; 
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
.alert {
    padding: 0px;
    margin-bottom: 11px;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    border-radius: 2px;
    border: none;
}
.custom-select {
  position: relative;
  font-family: Arial;
}
.custom-select select {
  display: none; /*hide original SELECT element:*/
}
.select-selected {
  background-color: #262626;
}
/*style the arrow inside the select element:*/
.select-selected:after {
  position: absolute;
  content: "";
  top: 14px;
  right: 10px;
  width: 0;
  height: 0;
  border: 6px solid transparent;
  border-color: #fff transparent transparent transparent;
}
/*point the arrow upwards when the select box is open (active):*/
.select-selected.select-arrow-active:after {
  border-color: transparent transparent #fff transparent;
  top: 7px;
}
/*style the items (options), including the selected item:*/
.select-items div,.select-selected {
  color: #ffffff;
  padding: 8px 16px;
  border: 1px solid transparent;
  border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
  cursor: pointer;
  user-select: none;
}
/*style items (options):*/
.select-items {
  position: absolute;
  background-color: #005c77;
  top: 100%;
  left: 0;
  right: 0;
  z-index: 99;
}
/*hide the items when the select box is closed:*/
.select-hide {
  display: none;
}
.select-items div:hover, .same-as-selected {
  background-color: rgba(0, 0, 0, 0.1);
}
</style>
	</head>  

	<body>
	
	<script type="text/javascript">
	var isClick = 'No';
	window.setTimeout(function() {
	    $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
	        $(this).remove(); 
	    });
	}, 5000);
	</script>
	
	
	<%-- <c:if test="${rolId=='2'}">
 <div id='menu'>
				<ul>
					<li class="">
						<a href='dashBoard'>
							<i class="fa fa-tachometer"></i> <span>Dashboard</span>
<!-- 							<span class="current-page"></span> -->
						</a>
					</li>
				</ul>
</div>				
</c:if>  --%>

<%
String url =request.getScheme() + "://" + request.getServerName() +      ":" +   request.getServerPort() +  request.getContextPath();
session.setAttribute("url", url);
// System.out.println(url);
%>
		 	<%
				 	HttpSession sess = request.getSession(false);
					 
					if (sess.getAttribute("cacheUserBean") == null) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePage");
						dispatcher.forward(request, response);
					}else{
						 String testId = (String)sess.getAttribute("rolId");
						int rolid22 = Integer.parseInt(testId);
						 if (rolid22 == 1 || rolid22 ==2) {
							
							 
						}  else{
							
							RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePage");
							dispatcher.forward(request, response);
						}
					}
			%>  
			
		<!-- Header Start -->
		<header style="height: 50px; ">

			<!-- Logo starts -->
			<div class="logo">
				<a href="#">
					<!-- <a href="dashBoard" style="display:inline !important"><img src="img/VVN.png" style="width: 65px;height: 65px;" alt="AKSHARA BHARATHI VIDYALAYAM">&nbsp; &nbsp; &nbsp; <b style="font-size: 25px;color: white !important">VVN</b></a> -->
<!-- 					<a href="dashBoard" style="display:inline !important"><img src="img/logo (1).png" style="width: 65px;height: 65px;" alt="GRETNALTES">&nbsp; &nbsp; &nbsp; <b style="font-size: 25px;color: white !important"></b></a> -->
					<span data-toggle="tooltip" title="Menu" data-placement="bottom" class="menu-toggle hidden-xs">
						<i class="fa fa-bars"></i>
					</span>
				</a>
			</div>
			
			<div class="col-md-3">
				<!-- <h1 style="color: white;font-family: sans-serif;margin: 10px;">Vijnana Vihara Nutakki</h1> -->
				<!-- <h1 style="color: white;font-family: sans-serif;margin: 10px;">GRETNALTES</h1> -->
<!-- 				<img src="img/logo.png" class="img-responsive logoimg" style="height:45px; padding-top:2px;"/> -->
			</div>
<!-- 			<div class="col-md-7"><label class="academicyear" style="padding-top:15px; color:#fff;font-size:14px; float:right;" for="academic">Academic Year</label></div><div class="clerfix"></div> -->
			<div class="col-md-1 pull-right">
			<div  class="custom-select" style="width:180px; margin-top:8px;float:right;">
<!-- 	  <select id="academicYearList" onchange="activateAcademicYear()"> -->
	    
	   
<!-- 	  </select> -->
</div></div>
			<c:if test="${not empty msg}">
		<div class="msgcss row">
			<div class="col-sm-4 col-sm-offset-4">
				<div class="form-group">
					<div class="alert alert-${cssMsg} fadeIn animated">${msg}</div>
				</div>
			</div>
		</div>
		</c:if>
		
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
				 <c:if test="${rolId == '1' }">
					<li class="" id="das_li">
						<a href='dashBoard'>
							<i class="fa fa-tachometer"></i> <span>Dashboard</span>
<!-- 							<span class="current-page"></span> -->
						</a>
					</li>
					
					<li class='has-sub' id="conf_li">
						<a href='#'><i class="fa fa-cogs"></i><span>Financial</span></a>
						<ul>
<!-- 							<li><a href="academicYearHome"><span>Academic Year Creation</span></a></li> -->
							<li><a href="addAccountHead"><span>Day-Book Catagories</span></a></li>
							<li><a href="ledger"><span>Ledger</span></a></li>
							<li><a href="collections"><span>Collections</span></a></li>
							<li><a href="dailyFeesCollection"><span>Daily Collection</span></a></li>
<!-- 							<li><a href="studentFeeHome"><span>Collection</span></a></li> -->
							<li><a href="reports"><span>Reports</span></a></li>
							<li><a href="addClient"><span>Add Client</span></a></li>
							<!-- <li><a href="boardHome"><span>Board Creation</span></a></li>
							<li><a href="classHome"><span>Class Creation</span></a></li>
							<li><a href="sectionHome"><span>Section Creation</span></a></li>
							<li><a href="mediumHome"><span>Medium Creation</span></a></li>
							<li><a href="feeDefinationHome" id="addClass"><span>Fee Definition</span></a></li>
							<li><a href='subjectHome' id="subjectHome" ><span> Subject Creation</span></a></li>
							<li><a href='classSubjects' ><span>Class Subjects</span></a></li>
							<li><a href='addFaculty' id="addfaculty" ><span>Add Faculty</span></a></li>
							<li><a href='facultySubject' id="addfacultySubjects" ><span>Assign Faculty Subjects</span></a></li>
							 <li><a href='examType' id="" onclick="examType()"><span>Exam Types</span></a></li>
							 <li><a href='examPattern' id=""><span>Exam Pattern</span></a></li>
							 <li><a href='examSchedule' id=""><span>Exam Schedule</span></a></li>
							 <li><a href="addBusRoute"><span>Add Van Route</span></a></li>
							<li><a href="busRouteFee"><span>Van Route Fees</span></a></li> -->
						</ul>
					</li>
							 </c:if>
					<%-- <li class='has-sub' id="stu_li">
						<a href='#'><i class="fa fa-users"></i><span>Student Details </span></a>
						<ul>
						
						    <c:if test="${rolId=='2' }">
  						     <li><a href='facultyAddStudentHome'><span>Add Student</span></a></li>
						     <li><a href='userStudentFeeHome' ><span>Fee Payment</span></a></li>
						     
						  </c:if>	
						  
						  
						  <c:if test="${rolId=='1' }">					   
							<li><a href='studentHome' id="addStudent" ><span>Add Student</span></a></li>
							<li><a href='viewStudent' id="viewStudent" ><span>View Student</span></a></li>
							<li><a href='studentFeeHome' ><span>Fee Payment</span></a></li>
							<li><a href='viewStudentFee' ><span> View Student Fee</span></a></li>
							<li><a href='importStudent' ><span>Import Student</span></a></li>
							<li><a href='exportStudent' ><span>Export Student</span></a></li>
							<li><a href='studentMarks'><span>Student Marks</span></a></li>
							<li><a href="hallticket"><span>Student Hallticket</span></a></li>
							<li><a href="studenttimetable"><span>Time Table</span></a></li>
							<li><a href="studentPromotion"><span>Student Promotion</span></a></li>
							
							 </c:if>
						</ul>
										    <c:if test="${rolId=='2' }">
										<li class=""><a style="" href="#" onclick="logout()"><i style="" class="fa fa-power-off"></i><span>Logout</span></a></li></c:if>	
													
						
					</li> --%>
					<%-- <c:if test="${rolId=='1' }">
					<li class='has-sub' id="mes_li">
						<a href='#'><i class="fa fa-envelope"></i><span>Message</span></a>
						<ul>
							<li><a href='attendanceHome' id="messageDisplayId" ><span>Attendance</span></a></li>
							
							<li><a href='viewAttendanceHome' ><span>View Attendance</span></a></li>
							 <li><a href='eventsHome' ><span>Notifications</span></a></li>
							<li><a href='viewEvents' ><span>View Notifications</span></a></li> 
						</ul>
					</li> --%>
					
		    <li class="has-sub" id="Logout">
					<a style="" href="#" ><i style="" class="fa fa-power-off"></i><span>Logout</span></a> 
		    <ul>
		   		 	<li><a href='adminChangePasswordHome' id="changePassword" ><span>Change Password</span></a></li>
		     		<li><a href='#' onclick="logout()" ><span>Logout</span></a></li>
		    </ul>
		    </li>
<%-- 				 </c:if>		  --%>
					<!-- <li class='has-sub'>
						<a href='#'><i class="fa fa-clipboard"></i><span>Exams</span></a>
						<ul>
							<li><a href='#' id="messageDisplayId"><span>Exam Terms</span></a></li>
							

							<li><a href='#' onclick=""><span>Exam Common Types</span></a></li>
							 <li><a href='examType' id="" onclick="examType()"><span>Exam Types</span></a></li>
							<li><a href='#' onclick=""><span>Grade Systems</span></a></li> 
							<li><a href='#' id="messageDisplayId" onclick=""><span>Subject Areas</span></a></li>
							
							<li><a href='#' onclick=""><span>Exam Systems</span></a></li>
							 <li><a href='#' onclick=" "><span>Exams</span></a></li>
							<li><a href='examMarks' onclick="examMarks()"><span>Exam Marks</span></a></li> 
							<li><a href='#' id="messageDisplayId" onclick=""><span>Exam Subject Area Marks</span></a></li>
							
							<li><a href='#' onclick=""><span>Co-Scholastic Areas</span></a></li>
							 <li><a href='#' onclick=""><span>Co-Scholastic Grade Systems</span></a></li>
							<li><a href='#' onclick=""><span>Co-Scholastic Marks</span></a></li> 
							<li><a href='hallticket' id="" onclick=""><span>Hall Tickets</span></a></li>
							
							<li><a href='#' onclick=""><span>Progress Report</span></a></li>
							 <li><a href='#' onclick=""><span>Promote Exam Structure</span></a></li>
							<li><a href='#' onclick=""><span>Online Exam</span></a></li> 
							 
						</ul>
					</li> -->
<!-- <li><a href='#' onclick="backUpdata()"><i class="fa fa-database"></i><span>BackupData</span></a></li> -->
				</ul>
		  </div>
			<!-- Menu End -->

			<!-- Freebies Starts -->
		<!-- 	<div class="freebies">
				
				
				<div class="sidebar-addons">
					<ul class="views">
						
						<li>
							<i style="color:#fff;" class="fa fa-power-off"></i>
							<div class="details">
								<a style="color: white;" href="#" onclick="logout()">Logout</a>
							</div>
						</li>
					</ul>
				</div>

			</div> -->
		</aside>
		<!-- Left sidebar ends -->
		


	<script type="text/javascript">
  var acadamicYear = '<%= session.getAttribute("academicYear") %>'; 
	//var acadamicYear = ${academicYear};
   // console.log(acadamicYear);
    
    var optionsForClass ;
	optionsForClass = $("#academicYearList").empty();
	//optionsForClass = $("#academicYearList");
	//optionsForClass.append(new Option("-- Choose A --", ""));
	$.each(JSON.parse(acadamicYear), function(i, tests) {
		var id = tests.id;
		var name = tests.name;
		optionsForClass.append(new Option(name, id));
		if(tests.status==1){
  		  $("#academicYearList").val(id);
  		
  	}
	});
	
	
    
   /*  $.each(acadamicYear, function(index, item) {
    	
    	$("#academicYearList").append(
    	        $('<option></option>').val(item.id).html(item.name));
    	
    	if(item.status==1){
    		  $("#academicYearList").val(acadamicYear.id);
    		
    	}
    	  //$("#academicYearList").append(new Option(item.name, item.id));
    	}); */
    
	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip();  
	   
	});
/* function activateAcademicYear(){
			
			var id = $("#academicYearList").val();; 
			
			  $.ajax({
						type : "POST",
						url : "activateAcademicYear.json",
						data : "id="+id ,
						success : function(response) {
							var jsonobj = $.parseJSON(response);
							var alldata = jsonobj.allOrders1;
							displayTable(alldata);
							window.location.href='academicYearHome';
						},
						error : function(e) {
						}
					});
			
		}
		 */
	
	function addclass(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/HomeControl1';
	}
	function addStudent(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/studentHome';	
	}
	function addFaculty(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/addFaculty';
	}
	function addFacultySubjects(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/facultySubject';
	}
	function messageDisplay(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/attendanceHome';
	}
	function importStudent(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/importStudent';
	}
	function viewStudent(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/viewStudent';
	}
	function exportStudent(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/exportStudent';
	}
	function studentFee(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/studentFeeHome';
	}
	function logout(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/logoutHome1.htm';
	}
	function viewAttendanceHome(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/viewAttendanceHome';
	}
	function viewStudentFee(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/viewStudentFee';
	}
	function eventHome(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/eventsHome';
	}
	function viewEvents(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/viewEvents';
	}
	function backUpdata(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/backupData';
	}
	function subjectHome(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/subjectHome';
	}
	function examMarks(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/examMarks';
	}
	
	function examType(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/examType';
	
	}
	function hallticket(){
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		window.location.href = baseUrl+'/hallticket';
	
	}
 	function searchTable() {
 	    var input, filter, found, table, tr, td, i, j;
 	    input = document.getElementById("search");
 	    filter = input.value.toUpperCase();
 	    table = document.getElementById("itemContainer");
 	    tr = table.getElementsByTagName("tr");
 	    for (i = 0; i < tr.length; i++) {
 	        td = tr[i].getElementsByTagName("td");
 	        for (j = 0; j < td.length; j++) {
 	            if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
 	                found = true;
 	            }
 	        }
 	        if (found) {
 	            tr[i].style.display = "";
 	            found = false;
 	        } else {
 	            tr[i].style.display = "none";
 	        }
 	    }
 	}
	</script>
	
	 <script>
var x, i, j, selElmnt, a, b, c;
/*look for any elements with the class "custom-select":*/
x = document.getElementsByClassName("custom-select");
for (i = 0; i < x.length; i++) {
  selElmnt = x[i].getElementsByTagName("select")[0];
  /*for each element, create a new DIV that will act as the selected item:*/
  a = document.createElement("DIV");
  a.setAttribute("class", "select-selected");
  a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
  x[i].appendChild(a);
  /*for each element, create a new DIV that will contain the option list:*/
  b = document.createElement("DIV");
  b.setAttribute("class", "select-items select-hide");
  for (j = 0; j < selElmnt.length; j++) {
    /*for each option in the original select element,
    create a new DIV that will act as an option item:*/
    c = document.createElement("DIV");
    c.innerHTML = selElmnt.options[j].innerHTML;
    c.addEventListener("click", function(e) {
        /*when an item is clicked, update the original select box,
        and the selected item:*/
        var y, i, k, s, h;
        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
        h = this.parentNode.previousSibling;
        for (i = 0; i < s.length; i++) {
          if (s.options[i].innerHTML == this.innerHTML) {
            s.selectedIndex = i;
            h.innerHTML = this.innerHTML;
            y = this.parentNode.getElementsByClassName("same-as-selected");
            for (k = 0; k < y.length; k++) {
              y[k].removeAttribute("class");
            }
            this.setAttribute("class", "same-as-selected");
            break;
          }
        }
        h.click();
    });
    b.appendChild(c);
  }
  x[i].appendChild(b);
  a.addEventListener("click", function(e) {
      /*when the select box is clicked, close any other select boxes,
      and open/close the current select box:*/
      e.stopPropagation();
      closeAllSelect(this);
      this.nextSibling.classList.toggle("select-hide");
      this.classList.toggle("select-arrow-active");
    });
}
function closeAllSelect(elmnt) {
  /*a function that will close all select boxes in the document,
  except the current select box:*/
  var x, y, i, arrNo = [];
  x = document.getElementsByClassName("select-items");
  y = document.getElementsByClassName("select-selected");
  for (i = 0; i < y.length; i++) {
    if (elmnt == y[i]) {
      arrNo.push(i)
    } else {
      y[i].classList.remove("select-arrow-active");
    }
  }
  for (i = 0; i < x.length; i++) {
    if (arrNo.indexOf(i)) {
      x[i].classList.add("select-hide");
    }
  }
}
/*if the user clicks anywhere outside the select box,
then close all select boxes:*/
document.addEventListener("click", closeAllSelect);</script>
	