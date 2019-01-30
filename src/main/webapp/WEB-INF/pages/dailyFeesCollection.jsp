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
				<div class="page-title">Daily Collection</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
					<ol class="breadcrumb">
					    	<li><a href="dashBoard">Home</a></li>
					    	<li><a href="#">Financial</a></li>
					    	<li><a href="dailyCollection">Daily Collection</a></li>
						    </ol>
						    
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
					
							<div class="panel panel-info">
								<div class="panel-heading">
									<h4>Daily Collection</h4>
								</div>
								<div class="panel-body collapse in">						
									
									<!-- Row Starts -->
									<div class="row">
						
										<form:form id="dfc-form" commandName="dfc"  method="post" class="form-horizontal">										
										
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label  for="inputEmail3" class="col-sm-4 control-label">From </label>
												    <div class="col-sm-8">
												        <form:input id="from" name="from" data-format="dd-MM-yyyy" type="text" path="from" autocomplete="off"  placeholder="From Date" class="form-control validate"  required="true" tabindex="1" onfocus="removeBorder(this.id)" />														
														<span class="from_error" id="from_error"></span>
													</div>
											  	</div>
										</div>
											
											<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											  	<div class="form-group">
												    <label  for="inputEmail3" class="col-sm-4 control-label">To </label>
												    <div class="col-sm-8">
												    <form:input id="to" name="to" data-format="dd-MM-yyyy" type="text" path="to" autocomplete="off"  placeholder="To Date" class="form-control validate"  required="true" tabindex="1" onfocus="removeBorder(this.id)" />														
													<span class="to_error" id="to_error"></span>
													</div>
											  	</div>
											</div>
											
											<div class="col-sm-12">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="button" id="submitId" value="Get Daily Collection" class="btn btn-success"	/>
													<button type="button" class="btn btn-danger" id="cancel"	tabindex="9">Reset</button>
												</div>
											</div>
										
										</form:form>
									</div>
								</div>
								<!-- Row Ends -->
							</div>
						</div>
						
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top:20px">
									<div class="panel panel-info" id="todayFeeCollecitonDivId">
						<div class="panel-heading">
							<h4 id="todayFeeCollectoinheading">Today Collection</h4>
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
																	    <th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">DATE</th>
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Client Name</th>
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Description</th>																		
																		<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">PaidAmount</th>
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
							
								</div>										
		
					</div>					

				</div>			
	
			</div>

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
				from:{required:'Select From Date '},
				to:{required:'Select To Date'},
				
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
					
					displayTable(response);				
				
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
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">DATE</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Client Name</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Description</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">PaidAmount</th>'
					+ '</tr>' + '</thead>' + '<tbody></tbody></table>';
			$('#basicTable').html(tableHead);					
								
			$.each(listOrders, function(i, orderObj) {					
				
								var tblRow = "<tr align='center' role='row' class='odd'>" 
										+ "<td title='"+orderObj.date+"'>"
										+ orderObj.date
										+ "</td>"
										+ "<td title='"+orderObj.client+"'>"
										+ orderObj.client
										+ "</td>"
										+ "<td title='"+orderObj.description+"'>"
										+ orderObj.description
										+ "</td>"
										+ "<td title='"+orderObj.paidamount+"'>"
										+ orderObj.paidamount
										+ "</td>"										
										+ "</tr>";
								$(tblRow).appendTo("#basicExampleDFC tbody");
			});			
		} 
	}   		
		
</script>