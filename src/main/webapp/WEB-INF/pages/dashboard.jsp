<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<style>
#chartdiv1 {
/*   width: 40%; */
  height: 300px;
}

#chartdiv2 {
/*   width: 40%; */
  height: 300px;
}


</style>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<!-- Grapics Repots js  -->
	<script src="chat/amcharts.js"></script>
	<script src="chat/pie.js"></script>
	<script src="chat/export.min.js"></script>
	<link rel="stylesheet" href="chat/export.css" type="text/css" media="all" />
	<script src="chat/light.js"></script>
	<script src="chat/funnel.js"></script>
	<script type="text/javascript" src="chat/canvasjs.min.js"></script>
	<!-- Grapics Repots js  -->
	<script type="text/javascript" src="js/TableBarChart.js"></script>
	<link rel="stylesheet" href="css/TableBarChart.css" />
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">Dashboard</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Current Stats Start -->
					<div class="current-stats">
						<div class="row">							
							<div class="col-lg-2 col-md-4 col-sm-4 col-xs-6">
                            <a href="ledger">
								<div class="success-bg center-align-text">
									<div class="spacer-xs">
										<small class="text-white">Ledger</small>
										<h4 class="no-margin no-padding">Ledger</h4>
									</div>
								</div>
                                </a>
							</div>
							<div class="col-lg-2 col-md-4 col-sm-4 col-xs-6">
                            <a href="dailyCollection">
								<div class="info-bg center-align-text">
									<div class="spacer-xs">
									<small class="text-white">Daily</small>
										<h4 class="no-margin no-padding" title="Daily Collection">Collection</h4>
									</div>
								</div>
                                </a>
							</div>
							<div class="col-lg-2 col-md-4 col-sm-4 col-xs-6">
                            <a href="reports">
								<div class="info-bg center-align-text">
									<div class="spacer-xs">
									<small class="text-white">Reports</small>
										<h4 class="no-margin no-padding">Reports</h4>
									</div>
								</div>
                                </a>
							</div>
						</div>
					</div>
					<!-- Current Stats End -->

				</div>
				<!-- Container fluid ends -->

 	<div class="col-md-6">
	<h3>Collection </h3>
	<div id="chartdiv1"></div></div>
	
	<div class="col-md-6">
	<h3>Expenses </h3>
	<div id="chartdiv2"></div></div>	
	
			</div>
			<!-- Main Container ends -->

		</div>
		<!-- Dashboard Wrapper ends -->

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {	
	
	var getTabName = window.location.pathname.split('/')[2];
	$("#das_li").addClass('active');
	$("#das_li ul").css('display','block');
	$("#das_li ul li a[href='"+ getTabName +"']").addClass('subactive');
	
});

var feesAndExpenses =${feesAndExpenses};
var chart = AmCharts.makeChart( "chartdiv1", {
	  "type": "pie",
	  "theme": "light",
	  "dataProvider":feesAndExpenses,
	  "valueField": "amount",
	  "titleField": "totalFees",
	  "outlineAlpha": 0.4,
	  "depth3D": 15,
	  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
	  "angle": 30,
	  "export": {
	    "enabled": true
	  }
	} );
	
var expensessummary =${expensessummary};
var chart = AmCharts.makeChart( "chartdiv2", {
	  "type": "pie",
	  "theme": "dark",
	  "dataProvider":expensessummary,
	  "valueField": "amount",
	  "titleField": "accountHead",
	  "outlineAlpha": 0.4,
	  "depth3D": 15,
	  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
	  "angle": 30,
	  "export": {
	    "enabled": true
	  }
	} );

</script>