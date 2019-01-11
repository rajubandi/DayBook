<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<script src="js/js/jquery.js"></script>
<script src="js/js/material-charts.js"></script>
<link href="css/style.css" rel="stylesheet">
<title>Services</title>
<style>

</style>
 <link rel="stylesheet" href="css/css/example.css">
  <link rel="stylesheet" href="css/css/material-charts.css">

<script type="text/javascript">
	

	$(document).ready(function(){
		//$("#vendorId").hide();//for hide
		//$("#statusId").hide();//for hide
		var listOrders1 =${allOrders1};
		alert(listOrders1);
		var arr = [];
		var arr1 = [];
		if(listOrders1 != ""){
			$("#itemContainer ul li").remove();
			$("#itemContainer ul").remove();
			//displayTable(listOrders1);
			$.each(listOrders1, function(i, orderObj) {
				arr[i]=orderObj.numberOfOrders;
				arr1[i]=orderObj.userName;
			});
			var exampleBarChartData = {
				    "datasets": {
				        "values": arr,
				        "labels": arr1, "color": "blue"
				    },
				    "height": "500px",
				    "width": "1200px"
				};
			MaterialCharts.bar("#bar-chart-example", exampleBarChartData)  
			
		} 
	}); 
	
</script>

</head>
<body>
                        <div id="bar-chart-example"></div>
</body>
</html> 
