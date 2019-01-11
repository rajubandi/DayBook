<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<link href="css/datepicker1.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<style>
	@media only screen and (min-width: 768px) {
.modal-dialog {
    width: 850px;
    margin: 30px auto;
}
}
	
	</style>
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">DFC</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
					<ol class="breadcrumb">
					    	<li><a href="dashBoard">Home</a></li>
					    	<li><a href="#">Daily Fees Collection</a></li>
						    </ol>
						<div class="col-sm-4">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h4>DFC</h4>
								</div>
								<div class="panel-body collapse in">						
									
									<!-- Row Starts -->
									<div class="row">
						
										<form:form id="dfc-form" commandName="dfc"  method="post" class="form-horizontal">
										
										
										<div class="col-lg-6 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label  class="col-sm-4 control-label">From <span style="color: red;">*</span></label>
												    <div class="col-sm-8">
														<form:input path="from"  autocomplete="off" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate" type="text"  onfocus="removeBorder(this.id)" />
														<span class="from_error" id="from_error"></span>
													</div>
											  	</div>
											</div>
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label  class="col-sm-4 control-label">To <span style="color: red;">*</span></label>
												    <div class="col-sm-8">
														<form:input path="to"  autocomplete="off" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate" type="text" onfocus="removeBorder(this.id)" />
														<span class="to_error" id="to_error"></span>
													</div>
											  	</div>
											</div>
											
											<div class="col-sm-12">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="button" id="submitId" value="Get DFC" class="btn btn-success"	/>
													<button type="button" class="btn btn-danger" id="cancel"	tabindex="9">Reset</button>
												</div>
											</div>
										
										</form:form>
									</div>
								</div>
								<!-- Row Ends -->
							</div>
						</div>
						<div class="col-md-8">
									<div class="panel panel-info" id="todayFeeCollecitonDivId">
						<div class="panel-heading">
							<h4 id="todayFeeCollectoinheading">Today Fee Collection</h4>
						</div>
						<div class="panel-body collapse in">	
											<div class="table-responsive">
												<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
													<div class="row">
														<div class="col-sm-12">
														<div id="basicTable">
	 														<table id="basicExampleDFC" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
																<thead>
																	<tr role="row">
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Class</th>
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Medium</th>
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Fee Category</th>
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">DATE</th>
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">AMOUNT</th>
																	</tr>
																</thead>
																<tbody>
																	
																</tbody>
															</table>
														</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
											
							<!-- Row Starts -->
						<!-- 	<div class="row gutter" id="BetweenTwoDatesListId">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="panel panel-info">
						<div class="panel-heading" >
							<h4>List of DFC</h4>
						</div>
						<div class="panel-body collapse in">	
											<div class="table-responsive">
												<div id="betweenDatesDiv" class="dataTables_wrapper form-inline dt-bootstrap">
													<div class="row">
														<div class="col-sm-12">
														<div id="betweenDatesTable">
	 														<table id="betweenDatesTableId" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
																<thead>
																	<tr role="row">
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Date</th>
																		<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Amount</th>
																	</tr>
																</thead>
																<tbody>
																	
																</tbody>
															</table>
														</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div> -->
							<!-- Row Ends -->
								</div>
				
							<!-- Row Starts -->
							<div class="row gutter">
								
							</div>
							<!-- Row Ends -->
					
		
					</div>
					<!-- Spacer ends -->
				<!-- Container fluid ends -->

				</div>
			<!-- Main Container ends -->

	
			</div>
		<!-- Dashboard Wrapper ends -->


<script type="text/javascript">
//$('#BetweenTwoDatesListId').hide();
var getTabName = window.location.pathname.split('/')[2];
$("#conf_li").addClass('active');
$("#conf_li ul").css('display','block');
$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');
$(function () {
			var getTabName = window.location.pathname.split('/')[2];
	$("#from").val("");
	$("#to").val("");
	//$('#basicExample').dataTable();
	

	//$('#betweenDatesTableId').dataTable();
	
	$("#from,#to").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-50:+0",
		showButtonPanel : false,
// 		minDate: '-50Y',
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});
	
	 $("#dfc-form").validate({
			errorElement : 'span',
			errorClass : 'has-error',
			rules : {
				 from:{required:true},
				 to:{required:true},  
				
			},
			messages : {
				from:{required:'Select Date '},
				to:{required:'Select Date'},
				
			},
			errorPlacement: function(error, element){
			      if(element.attr("name") == "from")
			        error.insertAfter(".from_error").css("color", "red");
			      else if(element.attr("name") == "to")
			        error.insertAfter(".to_error").css("color", "red"); 
			      					    
			      else
			        error.insertAfter(element);
			      }
		});
		

			$("#stu_li").addClass('active');
			$("#stu_li ul").css('display','block');
			$("#stu_li ul li a[href='"+ getTabName +"']").addClass('subactive');
			
			$('#cancel').click(function () {
				window.location.href = '?';
			  	$("#dfc-form").validate().resetForm();
			    $("#dfc-form").removeClass("has-error");
			    $("#from").val('');
			    $("#to").val('');
			    
			   /*  $('#todayFeeCollecitonDivId').show();
				$('#BetweenTwoDatesListId').hide(); */
			    
			});
			
			

	 
});

$("#submitId").click(function(e){
	  
	 if ( $("#dfc-form").valid() == true){
	 
	var  data = $('#dfc-form').serialize();
	console.log(data);
	 
	 $.ajax({
			type : "POST",
			url : "dailyFeesCollectionBetweentwoDate.json",
			data : data ,
			async:false,
			success : function(response) {
					//displayTableDfcListBetweenTwoDates(response);
					displayTable(response);
					
					//$('#todayFeeCollecitonDivId').hide();
					//$('#BetweenTwoDatesListId').show();
// 					return false;
				
			}
			
		});
	 
	 $("#todayFeeCollectoinheading").text('Fee Collection');
	 if(isClick == 'Yes'){
		 
		 
		 $('#basicExampleDFC').dataTable( {
	    	 "order": [],
	    	 "defaultContent": "",
	    	 "defaultContent": "",
	    	 aLengthMenu: [
	    	         [25, 50, 100, 200, -1],
	    	         [25, 50, 100, 200, "All"]
	    	     ],
	    	     iDisplayLength: -1,	
	        dom: 'lBfrtip',
	      
	        buttons: [
	            'copy',
	            {
	                extend: 'excel',
	                footer: true
	            },
	            {
	            	 extend: 'pdfHtml5',
		                orientation: 'landscape',
		                pageSize: 'LEGAL',
		                	footer: true
	            },
	            {
	                extend: 'print',
	                footer: true,
	               
	            }
	        ]
	    
	    } );
	 }
	
	 }
	
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
		
	 var listOrders1 = ${dfcList};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}
	
	
	function displayTable(listOrders) {
		if (listOrders != null) {
			$('#basicTable').html('');
			$("#basicExample tr td").remove();
			$("#basicExample td").remove();
			serviceUnitArray = {};
			var tableHead = '<table id="basicExampleDFC" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
					+ '<thead>'
					+ '<tr role="row">'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Class</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Medium</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Fee Category</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">DATE</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">AMOUNT</th>'
					+ '</tr>' + '</thead>' + '<tbody></tbody><tfoot><tr><th colspan="5">Total</th><th id="dfcTotal">0.00</th></tfoot></table>';
			$('#basicTable').html(tableHead);
			
			
			var dfcTotal = 0.0;
								
			$.each(listOrders, function(i, orderObj) {	
				var feecategory = '' ;
				
				if(orderObj.admissionFee > 0){
					
					feecategory += "Admission Fee";
				}
				if(orderObj.tutionFee > 0){
					
					if(feecategory != ''){
					
					feecategory += ", Tution Fee"
					}else{
						
						feecategory += "Tution Fee";
					}
				}
				if(orderObj.transportationFee > 0){
					if(feecategory != ''){
						
						feecategory += ", Bus Fee"
					}else{
						feecategory += " Bus Fee"
					}
				}
				if(orderObj.hostelFee > 0){
					if(feecategory != ''){
						
					feecategory += ", School Fee"
					}else{
						feecategory += " School Fee"
					}
				}
				if(orderObj.stationaryFee > 0){
					if(feecategory != ''){
						
					feecategory += ", Stationary Fee"
					}else{
						
						feecategory += " Stationary Fee"
					}
				}
				
				dfcTotal += orderObj.total;
								var tblRow = "<tr align='center' role='row' class='odd'>" 
										+ "<td title='"+orderObj.name+"'>"
										+ orderObj.name
										+ "</td>"
										+ "<td title='"+orderObj.className+"'>"
										+ orderObj.className
										+ "</td>"
										+ "<td title='"+orderObj.medium+"'>"
										+ orderObj.medium
										+ "</td>"
										+ "<td title='"+feecategory+"'>"
										+ feecategory
										+ "</td>"
										+ "<td title='"+orderObj.createdTime+"'>"
										+ orderObj.createdTime
										+ "</td>"
										+ "<td title='"+orderObj.total+"'>"
										+ orderObj.total
										+ "</td>"
										+ "</tr>";
								$(tblRow).appendTo("#basicExampleDFC tbody");
			});
			
			$("#dfcTotal").text(dfcTotal);
			
		} 
	}  
 	
	
		/* 
		function displayTableDfcListBetweenTwoDates(listOrders) {
		console.log(listOrders);
		if (listOrders != null) {
			$('#betweenDatesTable').html('');
			var tableHead1 = '<table id="betweenDatesTableId" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
					+ '<thead>'
					+ '<tr role="row">'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">DATE</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Class</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Medium</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Fee Category</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Amount</th>'
					+ '</tr>' + '</thead>' + '<tbody></tbody><tfoot><tr><th colspan="5">Total</th><th id="bwtwodatesDfc">0.00</th></tfoot></table>';
			$('#betweenDatesTable').html(tableHead1);
				var totalAmountBetweenTwoDates=0;
			$.each(listOrders, function(i, orderObj) {
				
				totalAmountBetweenTwoDates  +=    parseInt(orderObj.amount);
				
				var tblRow1 = "<tr align='center' role='row' class='odd'>"
						+ "<td title='"+orderObj.createdTime+"'>"
						+ orderObj.createdTime + "</td>"
						+ "<td title='"+orderObj.name+"'>"
						+ orderObj.name
						+ "</td>"
						+ "<td title='"+orderObj.className+"'>"
						+ orderObj.className
						+ "</td>"
						+ "<td title='"+orderObj.medium+"'>"
						+ orderObj.medium
						+ "</td>"
						+ "<td title='"+feecategory+"'>"
						+ feecategory
						+ "</td>"
						+ "<td title='"+orderObj.amount+"'>" + orderObj.amount
						+ "</td>" + "</tr>";
				$(tblRow1).appendTo("#betweenDatesTableId tbody");
					console.log(totalAmountBetweenTwoDates);
			});
			/* var totalRow = "<tr align='center' role='row' class='odd'>"
							+ "<td title='Total Amount'><b>Total Amount </b></td>"
							+ "<td title='"+totalAmountBetweenTwoDates+"'><b>" +totalAmountBetweenTwoDates
							+ "</b></td></tr>";
			$(totalRow).appendTo("#betweenDatesTableId tbody");
 
 
			$("#bwtwodatesDfc").text(totalAmountBetweenTwoDates);
		}
	} */
</script>
