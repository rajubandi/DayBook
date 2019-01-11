<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript" src="js/js/csvDownload1.js"></script>
<link href="css/style.css" rel="stylesheet">
<title>Services</title>
<style>
.your-class::-webkit-input-placeholder {
	color: red;
}

.default-class::-webkit-input-placeholder {
	color: red;
}
</style>

<style>
/* .table-list-blk ul li.quantity-boxxx{
width: 175px;
text-align:center;
} */
.two-boxxx {
	width: 100px;
}
.three-boxxx {
	width: 100px;
	text-align: center;
}
.stock-pcode-boxnew {
	width: 175px;
}
.butsave {
	cursor: pointer;
}
/* mouse over link */
.changeColor {
	
}
a:hover {
	color: #800000;
}
</style>
 

<script type="text/javascript">
	$(document).ready(function() {
		chosenDropDown();

	});

	$(document).ready(function(){
		//$("#vendorId").hide();//for hide
		//$("#statusId").hide();//for hide
		var listOrders1 =${allOrders1};
		if(listOrders1 != ""){
			$("#itemContainer ul li").remove();
			$("#itemContainer ul").remove();
			displayTable(listOrders1);
			
		} 
	});
	function displayTable(listOrders){
		$("#ulId").show();
		if (listOrders != null){
			$("#itemContainer ul li").remove();
			$("#itemContainer ul").remove();
			var m =0;
			var dummybookeddate = null;
			var dummyuserName = null;
			var subtotal = 0;
			var total=0;
			var tblRow = "";
			$.each(listOrders, function(i, orderObj) {
				if(orderObj.totalNetAmount==null){
					orderObj.totalNetAmount=0.00;
				}
				 if(i==0){
					 subtotal = subtotal + parseInt(orderObj.totalOrders);
					 total=total+parseInt(orderObj.totalOrders);
				 }
				if(i != 0){
					if(dummybookeddate ==  orderObj.bookedDate && dummyuserName == orderObj.userName){
						// var orders = parseInt(orderObj.totalOrders)
						subtotal = subtotal + parseInt(orderObj.totalOrders);
					}else{
						tblRow= "<ul>"
							+ "<li  class='two-boxxxxxx' style='background-color: #ff6699;'>Subtotal</li>"
							  + "<li class='two-boxxx' style='background-color: #ff6699;'>"+subtotal+"</li>"
								+ '</ul>';
						$(tblRow).appendTo("#itemContainer");
						subtotal = 0;
						subtotal = subtotal + parseInt(orderObj.totalOrders);
					}
					if(dummybookeddate ==  orderObj.bookedDate){
						total=total+parseInt(orderObj.totalOrders);
					}else{
						tblRow= "<ul>"
							+ "<li  class='two-boxxxxxx' style='background-color: #009899;'>Total</li>"
							  + "<li class='two-boxxx'style='background-color: #009899;'>"+total+"</li>"
								+ '</ul>';
						$(tblRow).appendTo("#itemContainer");
						total = 0;
						total=total+parseInt(orderObj.totalOrders);
					}
				} 
				
					//totalMoney = totalMoney + parseInt(orderObj.totalNetAmount);
					 tblRow = "<ul>"
						+ "<li class='two-boxxx'>"+orderObj.userName+"</li>"
							+ "<li class='two-boxxx'>"+orderObj.bookedDate+"</li>"
							+ "<li class='two-boxxx'>"+orderObj.month+"</li>"
							+ "<li class='two-boxxx'>"+orderObj.year+"</li>"
							+ "<li class='two-boxxx'>"+orderObj.statusName+"</li>"
							+ "<li class='two-boxxx'>"+orderObj.totalOrders+"</li>"
							+ "<li class='two-boxxx'>"+orderObj.totalNetAmount+"</li>"
							+ '</ul>';
					$(tblRow).appendTo("#itemContainer");
					m++;
					 dummybookeddate=orderObj.bookedDate;
					 dummyuserName=orderObj.userName; 
					 
					//$("#tamountId").text("Total Amount:"+totalMoney)
				});
				$("#totalId").text("Total days #"+m)
				tblRow= "<ul>"
					+ "<li  class='two-boxxxxxx' style='background-color: #ff6699;'>Subtotal</li>"
							  + "<li class='two-boxxx' style='background-color: #ff6699'>"+subtotal+"</li>"
								+ '</ul>';
						$(tblRow).appendTo("#itemContainer");
						subtotal = 0;
						tblRow= "<ul>"
							+ "<li  class='two-boxxxxxx' style='background-color: #009899;'>Total</li>"
							  + "<li class='two-boxxx' style='background-color: #009899;'>"+total+"</li>"
								+ '</ul>';
						$(tblRow).appendTo("#itemContainer");
						total = 0;
				paginationTable(18);
		}else{
			//alert('no data to display..');
		}
	}
	$(function() {
		$("#startdate").datepicker({
			changeDate : true,
			changeMonth : true,
			changeYear : true,
			showButtonPanel : false,
			dateFormat : 'yy-mm-dd'
		});

	});
	$(function() {
		$("#enddate").datepicker({
			changeDate : true,
			changeMonth : true,
			changeYear : true,
			showButtonPanel : false,
			dateFormat : 'yy-mm-dd'
		});

	});
	function formSubmit(){
		var userId=$('#userId').val();
		var status=$('#status').val();
		var startdate = $("#startdate").val();
		$.ajax({
			type : "POST",
			url : "DailyOrdersFilter.json",
			dataType : "json",
			data : {
				userId:userId,
				status:status,
				startdate : startdate,
			},
			success : function(response) {
				displayTable(response);
				if(response == null || response =="" ){
					$("#itemContainer ul li").remove();
					$("#itemContainer ul").remove();
				}
			
			}
		});
	}
</script>

</head>
<body>

	<div class="wrapper">
		<div class="container">
		<div class="main_content">
				<c:if test="${empty servEdit}">
					<div class="block">
						<h2>
							<span class="icon1">&nbsp;</span> <a href='javascript:void(0)'
								onclick='addPack()'> Filter Data</a>
							<!-- <div class="block-footer-right1 fail">
								

							</div> -->
						</h2>
						<!-- End Box Head -->
						<form:form action="" commandName="dailyCmd" method="post"
							id="addForm" cssClass="form-horizontal">
							<div class="block-box-small package-topbox block-box-top-header-dept" style= "height: 50px !important" >
                                <div class="block-input last"> 
											<label>Partner </label>
											<form:select path="userId" id="userId" cssClass="some-select" tabindex="1">
											<form:option value="">--Select--</form:option>
											<form:options items="${users}"></form:options>	
												</form:select>
											</div>
											<div class="block-input">
											<label>Status</label>
											 <form:select path="statusId" style="height:0px;" id="status"  cssClass="some-select" tabindex="2">
											<form:option value="">--Select--</form:option>
											<form:options items="${status}"></form:options>
											</form:select>	</div>
                                
                               <div class="block-input ">
								<label>Start Date<span style="color: red;">*</span></label> 
									<input  id="startdate" onkeydown="removeBorder(this.id)"  tabindex="3"/>
                               </div>
                               <!-- <div class="block-input ">
								<label>End Date<span style="color: red;">*</span></label> 
									<input  id="enddate" onkeydown="removeBorder(this.id)"   tabindex="5"/>
                               </div> -->
                              
							</div>
							<div class="block-footer">
							<!-- <span> <input class = "buttonproperty " type="button"  value="Status" onclick="status()"> </span>&nbsp;&nbsp;&nbsp; --> 
							 <!-- <span><input class = "buttonproperty net_un" type="button"  value="NetAmount" onclick="findTotalAmount()"></span>&nbsp;&nbsp;&nbsp;&nbsp; -->
							<span><input class = "buttonproperty search_un" type="button"  value="Search Orders" onclick="formSubmit()" tabindex="4"></span>
							</div>

						</form:form>
						</div>
				</c:if>


			</div>
			<!--Edit Box End  -->
			<div class="block">
						<div class="head-box">
							<h2>
							<p> <b id='noOrdrs'></b>   <b id='totalId'></b></p>
							 
								<span class="icon2">&nbsp;</span>Admin Order Details
							</h2>
							<a href="#" class="export" style="color: yellow;">Export Table data into CSV</a>
							<div  id="dupMessage" style="color: red;"></div>
							<div  id="upsus" style="color: green;"></div>
						</div>
						<div
							class="block-box-deptpurchaser purchases-downbox block-box-last-deptpurchaser"
							id="divheader">
							<div class="table-list-blk purchase-tablelist paginationParentDiv itemContainer"
								id="userdata" style="overflow-x: scroll;overflow-y: hidden; ">
							<ul class="table-list" style="width:127%;   font-weight: 600;" id="ulId">
								<li class="two-boxxx">Users</li>
								<li class="two-boxxx">Date</li>
								<li class="two-boxxx">Month</li>
								<li class="two-boxxx">Year</li>
								<li class="two-boxxx">Status</li>
								<li class="two-boxxx">Total Orders</li>
								<li class="two-boxxx">Total Amount</li>
							</ul>
								<div id="itemContainer" class="itemContainer" style="width: 127%">
								</div>
							</div>
							<div align="center">
								<h4 id="noSortData" style="display: none">No Data Found</h4>
							</div>
						</div>
						<div class="block-footer">
							<aside class="block-footer-left">
								<div id="legend2" class="savmarup"></div>
							</aside>
							<aside class="block-footer-right">
								<div class="pagenation">
									<div class="holder"></div>
								</div>
							</aside>
							<aside></aside>
						</div>
					</div>
							</div>
		<!-- End Content -->
	</div>
</body>
</html>
