<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DWR Demo</title>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/DWRCommonUtil.js"></script>
</head>
<body>
<!-- Google Tag Manager -->

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-63399103-1', 'auto');
  ga('send', 'pageview');

</script>
<!-- End Google Tag Manager -->
	<input value="click me!!!" type="button" onclick="update();" />
	<div
		style="background-color: #ffeaa7; font-weight: bold; width: 300px;"
		id="divResponse">Message From Server</div>
	<script type="text/javascript">
		function update() {
			alert("hiiii");
			DWRCommonUtil.getMessage(function(data) {
				alert(data);
				dwr.util.setValue("divResponse", data);
				alert(data);
			});
		}
		
		
		function getDetailsFromServer() {
			DWRCommonUtil.getDetails2(fillProductSelect);
			DWRCommonUtil.getProductUnit("C0002A0001B0001P0008",fillProductUnit);
		}
		function handleReceivedData(obj) {
			alert(obj.length);
			var i;
			for (i = 0; i < obj.length; ++i) {
	 			alert(obj[i].productCode);
				alert(obj[i].productName);   
				}
		}
		
		
		
		function fillProductSelect(productBean){
		    if(productBean != null && productBean.length > 0){
		        dwr.util.removeAllOptions("productSelect");
		        dwr.util.addOptions("productSelect", productBean, "productCode", "productName");
		    }
		}
		
		function fillProductUnit(productUnits){
			alert(productUnits+"productUnits");
		    if(productUnits != null && productUnits.length > 0){
		       document.getElementById("prodUnitId").innerHTML=productUnits;
		    }
		}
		
		function getDetailsFromServers1() {
			DWRCommonUtil.getDetails1(handleReceivedData1);
		}
		function handleReceivedData1(obj) {
			alert(obj.length);
		DWRUtil.setValue("firstname", productObj.productCode);
		DWRUtil.setValue("lastname", productObj.productName);  	
		}
		
		
	</script>
	<SELECT name="productSelect" id="productSelect">
		<OPTION value="in">India</OPTION>
		<OPTION value="de">Germany</OPTION>
		<OPTION value="fr">France</OPTION>
		<OPTION value="us">United States</OPTION>
	</SELECT>
	<br /> FirstName:
	<span id="firstname"></span>
	<br /> LastName:
	<span id="lastname"></span>
	<br />
	<div id="prodUnitId">Java</div>
	
	<button onclick="getDetailsFromServer()">submit</button>
</body>
</html>
