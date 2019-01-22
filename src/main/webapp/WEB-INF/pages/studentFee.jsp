<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<link href="css/datepicker1.css" rel="stylesheet">


<style>
/* .ui-dialog .ui-widget .ui-widget-content .ui-corner-all .ui-front .ui-draggable .ui-resizable
#dial{
    position: relative;
    height: auto;
    width: 799px;
    top: -5em;
    display: block;
}*/
hr {
    margin-top: 5px !important;
    margin-bottom: 8px !important;
    border-top-style: dotted;
    border-color:1px #000;
}
hr {
   
    border-top: 1px dotted #333 !important;
}
.mediu {
width:200px;
}
.table-condensed > thead > tr > th, .table-condensed > tbody > tr > th, .table-condensed > tfoot > tr > th, .table-condensed > thead > tr > td, .table-condensed > tbody > tr > td, .table-condensed > tfoot > tr > td {
    padding: 2px 10px;
}
.form-control {
width:200px !important;
}
@media (min-width: 768px) {
.modal-dialog {
    width: 59%;
    margin: 30px auto;
}
}
</style>

<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script> -->
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
<!-- <script src="js/dropdownsearch.js"></script>
	<link href="css/dropdownsearch.css"/> -->
<!-- 	  <script src="js/chosen.jquery.js"></script> -->

<!-- Dashboard Wrapper starts -->
<div class="dashboard-wrapper">

	<!-- Top Bar starts -->
	<div class="top-bar">
		<div class="page-title">Fee Payment</div>
	</div>
	<!-- Top Bar ends -->

	<!-- Main Container starts -->
	<div class="main-container">

		<!-- Container fluid Starts -->
		<div class="container-fluid">
			<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Student Details</a></li>
		<li><a href="#">Fee Payment</a></li>
	    </ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Filter Student</h4>
					</div>
					<div class="panel-body collapse in">
			<!-- Spacer starts -->
				<!-- Row Starts -->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						
								<form:form id="fee-form" action="addStudentFee.htm"	commandName="packCmd" method="post" class="form-horizontal">
<!-- 										<input type="hidden" id="forFormValidation" required="required" />  -->
									<div class="row">
										
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Student<span style="color: red;">*</span></label>
												<div class="col-sm-8">
												
												<form:input path="studentId" class="form-control numericOnly" maxlength="6"  placeholder="Client Name" required="true" />
													<%-- <form:select path="studentId" 	class="form-control" required="true" onchange="getDueFee()">

														<form:option value="">-- Choose Student --</form:option> --%>
<%-- 														<form:options items="${allStudents}"></form:options> --%>
													<%-- </form:select> --%>
												</div>
											</div>
										</div>
										
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Payment Date:<span style="color: red;">*</span></label>
												 <div class="col-sm-8">
														<form:input path="paymentDate"  autocomplete="off" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate" type="text"  onfocus="removeBorder(this.id)" />
														<span class="from_error" id="from_error"></span>
													</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12" id="divAdmissionFee">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Amount</label>
												<span id="admissionNetFee"></span>
												<div class="col-sm-8">
													<form:input path="admissionFee" class="form-control numericOnly" maxlength="6"  placeholder="Admission Fee" required="true" />

												</div>
											</div>
										</div>
										
									<div class="clearfix"></div>
										<div class="col-sm-8 col-sm-offset-4">
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<span id="displayId"></span>
												</div>
											</div>
											<form:hidden path="id" />
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="submit" id="submitId" value="Submit" class="btn btn-success"	/>
													<button type="button" class="btn btn-danger" id="cancel"	>Reset</button>
												</div>
											</div>
										</div><div class="clearfix"></div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<!-- Row Ends -->

				<!-- <a data-toggle="modal" data-target="#myModal" data-keyboard="false" data-backdrop="static">Open Modal</a> -->

				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog" style="">

						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" style="color:#fff;">&times;</button>
								<h4 class="modal-title">Fee Receipt</h4>
							</div>
							<div class="modal-body" id='printTab'></div>
							<!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
						</div>

					</div>
				</div>

				<!-- Row Starts -->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="blog">
							<div id="editor"></div>
							<!-- 									<button class="btn btn-primary" id="pdfDownload">Download Students Fee List</button> -->
							<div id="tableId">
								<table id="itemContainer1"
									class="table table-bordered table-condensed no-margin">
									
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- Row Ends -->

				<!-- Row Starts -->
				<div class="row gutter">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="panel panel-info">
					<div class="panel-heading">
							<h4>List of Fee Payments</h4>
					</div> 
					<div class="panel-body collapse in">
								<div class="table-responsive">
									<div id="basicExample_wrapper"
										class="dataTables_wrapper form-inline dt-bootstrap">
										<div class="row">
											<div class="col-sm-12">
												<div id="basicTable">
													<table id="basicExample"	class="table table-striped table-condensed table-bordered no-margin dataTable"	role="grid" aria-describedby="basicExample_info">
														<thead>
															<tr role="row">
																<th class="sorting_asc"  style="width: 10px;" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">S.No</th>
																<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Father Name</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Mobile Number</th>
																<!-- <th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th> -->
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>
															<!--<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th> -->
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Admission Fees</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Tuition Fees</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Bus Fees</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Hostel Fees</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Stationary Fees</th>
																<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Paid Fee</th>
																<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Due Fee</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Fee Date</th>
																<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>
															</tr>
														</thead>
														<tbody>

														</tbody>
														<tfoot></tfoot>
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
				<!-- Row Ends -->

			<!-- Spacer ends -->

		</div>
		<!-- Container fluid ends -->

	</div>
	<!-- Main Container ends -->

	<div id="dial"	style="width: auto; min-height: 130px; max-height: none; height: auto; background-color: #c3dac3; display: none;"></div>
</div>
<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#fee").val("");
		$('.has-sub').trigger("click");
		 $( "#submitId" ).prop( "disabled",false );

		
		var getTabName = window.location.pathname.split('/')[2];
		$("#conf_li").addClass('active');
		$("#conf_li ul").css('display','block');
		$("#conf_li ul li a[href='"+ getTabName +"']").addClass('subactive');
		
		$("#paymentDate").datepicker({
			changeDate : true,
			changeMonth : true,
			changeYear : true,
			yearRange: "-17:+0",
			showButtonPanel : false,
//	 		minDate: '-50Y',
		    maxDate: '0', 
			dateFormat : 'dd-MM-yy'
		});
		
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
			
	 $("#admissionFee").val("");
	   $("#tutionFee").val("");
	   $("#transportationFee").val("");
	   $("#hostelFee").val("");
	   $("#stationaryFee").val("");
	jQuery.validator.addMethod('lettersonly', function(value, element) {
		return this.optional(element)
				|| /^[a-z. áãâäàéêëèíîïìóõôöòúûüùçñ]+$/i.test(value);
	}, "Please Enter Valid Name");

	jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
		phone_number = phone_number.replace(/\s+/g, "");
		return this.optional(element) || phone_number.length > 9
				&& phone_number.match(/^[7-9]\d+$/);
	}, "Invalid Mobile Number");
	
	jQuery.validator.addMethod( "money", function(value, element) {
		        var isValidMoney = /^\d{0,5}(\.\d{0,2})?$/.test(value);
		        return this.optional(element) || isValidMoney;
		    },
		    "Insert Valid Fee"
		);
	$("#fee-form").validate({
		errorElement : 'span',
		errorClass : 'has-error',
		rules : {
			 boardName:{required:true},
			className:{required:true},  
			section:{required:true},
			medium:{required:true}, 
			studentId : {
				required : true
			},
			fee : {
				required : true,
				number : true
			},
			feeType : {
				required : true
			},
			paymentDate:{required: true},
			 admissionFee: {required: true, number: true, money:true },
			    tutionFee: {required: true, number: true, money:true },
			    transportationFee: {required: true, number: true, money:true },
			    hostelFee: {required: true, number: true, money:true },
			    stationaryFee: {required: true, number: true, money:true },
			    //forFormValidation:{required:true}
		},
		messages : {
		    boardName:{required:'Please Choose Board'},
			className:{required:'Please Choose Class'},
			section:{required:'Please Choose Section'},
			medium:{required:'Please Choose Medium'},
			studentId : {required : 'Choose Student Name'},
			fee : {required : 'Fee Amount',number : 'Fee Amount'},
			feeType : {required : 'Fee Type'},
			paymentDate: {required : 'Select Payment Date'},
		    admissionFee: {required: 'Admission Fee', number: 'Numeric Characters'},
			tutionFee: {required: 'Tuition Fee', number: 'Numeric Characters'},
			transportationFee: {required: 'Bus Fee', number: 'Numeric Characters'},
			hostelFee: {required: 'Hostel Fee', number: 'Numeric Characters'},
			stationaryFee: {required: 'Stationary Fee', number: 'Numeric Characters'},
			//forFormValidation:{required:''}
		},
	});
	
	/* if($("#fee-form").valid()==true) {
		$("#submitId").attr("disabled",true);
		$("#submitId").val("Please wait...");
		$("form").submit();											
		event.preventDefault();
	}else {
		//event.preventDefault();
		//return false;
	} */
	
	 $('#submitId').click(function(){
		 
		 if($("#fee-form").valid()==true) {
			 
		 
	    	var admissionFee = $('#admissionFee').val();
	    	var tutionFee   = $('#tutionFee').val();
	    	var transportationFee = $('#transportationFee').val();
	    	var hostelFee = $('#hostelFee').val();
	    	var stationaryFee = $('#stationaryFee').val();
	    	var stationaryFee = $('#stationaryFee').val();
	    	$('#forFormValidation').val('');
	    	
	    	if( dueFee12 != 0){
		    	if(  admissionFee == "0"  && tutionFee == "0" && transportationFee == "0"  && hostelFee == "0" &&  stationaryFee == "0"   ){
		    		$('#forFormValidation').val();
		    		alert("insufficient fund");
		    		return false;
		    	}
	    	/* if(admissionFee =='' && tutionFee=='' && transportationFee == '' &&  hostelFee == '' && stationaryFee == '' ){
	    		//return false;
	    		$('#forFormValidation').val();
	    	} */
	    	else{// parseInt cuz of while dissabled the div path value getting String like ""
			    	if(admissionFee1 < parseInt(admissionFee)){
			    		alert("Maximum AdmissionFee is : "+admissionFee1);
			    		//$('#erroradmissionFee').text("Max Aoount is:"+admissionFee1);
				     return false;
				     }else if(tutionFee1 < parseInt(tutionFee)){
				    	 alert("Maximum TutionFee is : "+tutionFee1);
					     return false;
				     }else if(transportationFee1 < parseInt(transportationFee)){
				    	 alert("Maximum TransportationFee is : "+transportationFee1);
					     return false;
				     }else if(hostelFee1 < parseInt(hostelFee)){
				    	 alert("Maximum School/HostelFee is : "+hostelFee1);
					     return false;
				     }else if(stationaryFee1 < parseInt(stationaryFee)){
				    	 alert("Maximum StationaryFee is : "+stationaryFee1);
					     return false;
				     }else {
				    	 //$('#forFormValidation').val(1);
				    	 //$( "#submitId" ).prop( "disabled", true );
				    	 $("#submitId").attr("disabled",true);
						 $("#submitId").val("Please wait...");
						 $("form").submit();		
				    	 return true;
				     }
	    	}
	    	
	    	}else{
	    		
	    		//$('#forFormValidation').val();
	    		alert("There is no Due Amount");
	    		return false;
	    	}
	    	
	    	
	    	$("#admissionFee").prop("disabled", false);
	    	$("#tutionFee").prop("disabled", false);
	    	$("#transportationFee").prop("disabled", false);
	    	$("#hostelFee").prop("disabled", false);
	    	$("#stationaryFee").prop("disabled", false);
		 }else{
			 
			 return false;
		 }
	    	
	    });
	   
	$('#cancel').click(function() {
		$("#fee-form").validate().resetForm();
		$("#fee-form").removeClass("has-error");
		$("#boardName").val('');
		$("#className").val('');
		$("#section").val('');
		$("#medium").val('');
		$("#studentId").val('');
		$("#fee").val('');
		$("#paymentDate").val('');
		$("#admissionFee").val('');
		$("#admissionFee").prop("disabled", false);
		$("#admissionNetFee").text('');
		$("#tutionFee").val('');
		$("#tutionFee").prop("disabled", false);
		$("#tutionNetFee").text('');
		$("#transportationFee").val('');
		$("#transportationFee").prop("disabled", false);
		$("#transportationNetFee").text('');
		$("#hostelFee").val('');
		$("#hostelFee").prop("disabled", false);
		$("#hostelNetFee").text('');
		$("#stationaryFee").val('');
		$("#stationaryFee").prop("disabled", false);
		$("#stationaryNetFee").text('');
		$("#displayId").val('');
		$("#fee-form").addClass('form-horizontal');
		$("#submitId").val("Submit");
		$("#displayId").text('');
		$('#erroradmissionFee').text("");
  		$('#errortutionFee').text("");
  		$('#errortransportationFee').text("");
  		$('#errorhostelFee').text("");
  		$('#errorstationaryFee').text("");
  		 $( "#submitId" ).prop( "disabled", false );
	});
	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}

	function displayTable(listOrders) {
		if (listOrders != null) {
			$('#basicTable').html('');
			serviceUnitArray = {};
			var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
					+ '<thead>'
					+ '<tr role="row">'
					+ '<th class="sorting_asc"  style="width: 10px;" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">S.No</th>'
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Father Name</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Mobile Number</th>'
// 					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>'
// 					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>'
// 					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Admission Fees</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Tuition Fees</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Bus Fees</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">School Fees</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Stationary Fees</th>'
					+ '<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Paid Fee</th>'
					+ '<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Due Fee</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Fee Date</th>'
					+ '<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Invoice</th>'
					+ '<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>'
					+ '</tr>' + '</thead>' + '<tbody></tbody><tfoot><tr><th colspan="5">Total</th><th id="addmissionTotal">0.00</th><th id="tutionTotal">0.00</th><th id="busTotal">0.00</th><th id="schoolTotal">0.00</th><th id="stationaryTotal">0.00</th> <th id="paidFeeTotal">0.00</th><th id="dueFeeTotal">0.00</th><th></th><th></th></tr></tfoot></table>';
			$('#basicTable').html(tableHead);
			var addmissionTotal = 0;
			var tutionFeeTotal = 0;
			var transportationFeeTotal = 0;
			var hostelFeeTotal = 0; 
			var stationaryFeeTotal = 0;
			var paidFeeTotal = 0;
			var dueFeeTotal = 0;
			$.each(listOrders,
							 function(i, orderObj) {
				/*	if (orderObj.dueFee == 0.00) {
									orderObj.dueFee = orderObj.netFee;
								}
 */
								// 	contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
								serviceUnitArray[orderObj.id] = orderObj;
								var id = '"' + orderObj.id + '"';
								var sno = i+1;
								
								addmissionTotal += parseInt(orderObj.admissionFee);
								tutionFeeTotal += parseInt(orderObj.tutionFee);
								transportationFeeTotal += parseInt(orderObj.transportationFee);
								hostelFeeTotal += parseInt(orderObj.hostelFee);
								stationaryFeeTotal += parseInt( orderObj.stationaryFee);
								paidFeeTotal += parseInt( orderObj.fee);
								dueFeeTotal += parseInt(orderObj.dueFee);
								
								var tblRow = "<tr role='row' class='odd'>"
										+ "<td title='"+ sno +"'>"
										+ sno
										+ "</td>"
										+ "<td>"
										+ '<a style="cursor: pointer;" title="View Fee Receipt" data-toggle="modal" data-target="#myModal" data-keyboard="false" data-backdrop="static" onclick=popupOpen('
										+ orderObj.id
										+ ')>'
										+ '<b>'
										+ orderObj.studentName
										+ '</b></a>'
										+ '</td>'
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.fatherName+"'>"
										+ orderObj.fatherName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mobile+"'>"
										+ orderObj.mobile
										+ "</td>"
										/* + "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"'>"
										+ orderObj.boardName
										+ "</td>" */
										/* + "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"' >"
										+ orderObj.mediumName
										+ "</td>" */
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.className+"'>"
										+ orderObj.className
										+ "</td>"
										/* + "<td class='hidden-sm hidden-xs' title='"+orderObj.sectionName+"' >"
										+ orderObj.sectionName
										+ "</td>" */
										+ "<td class='hidden-sm hidden-xs'>"
										+ orderObj.admissionFee							
										+ "</td>"																		    
										+ "<td class='hidden-sm hidden-xs'>"
										+ orderObj.tutionFee		
										+ '</td>'
										+ "<td class='hidden-sm hidden-xs'>"
										+ orderObj.transportationFee		
										+ '</td>'
										+ "<td class='hidden-sm hidden-xs'>"
										+ orderObj.hostelFee		
										+ '</td>'
										+ "<td class='hidden-sm hidden-xs'>"
										+ orderObj.stationaryFee		
										+ '</td>'
										+ "<td title='"+orderObj.fee+"' >"
										+ orderObj.fee
										+ "</td>"
										+ "<td title='"+orderObj.dueFee+"' >"
										+ orderObj.dueFee
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.feeDate+"' >"
										+ orderObj.feeDate
										+ "</td>"
										+ "<td >"
										+ '<b>'
										+ orderObj.invoiceId
										+ '</b>'
										+ "</td>"
										+ "<td align='center'>"
										+ '<a href="javascript:void(0)" onclick=editPack('
										+ orderObj.id
										+ ')'
										+ '  ><i style="color: green;" class="fa fa-edit"></i></a>'+ '&nbsp; | &nbsp;'
										+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteStudentFee('
										+  orderObj.id + ')'
										+ '  ><i class="fa fa-trash-o"></i></a>'
										+ '</td>' + '</tr>';
								$(tblRow).appendTo("#basicExample tbody");

								//* for download PDF option
							/* 	var tblRow1 = "<tr role='row' class='odd'><th>Student Name</th><td>"
										+ orderObj.studentName
										+ "</td></tr>"
										+ "<tr><th>Father Name</th><td>"
										+ orderObj.fatherName
										+ "</td></tr>"
										+ "<tr><th>Mobile</th><td>"
										+ orderObj.mobile
										+ "</td></tr>"
										+ "<tr><th>Board</th><td title='"+orderObj.boardName+"'>"
										+ orderObj.boardName
										+ "</td></tr>"
										+ "<tr><th>Medium</th><td title='"+orderObj.mediumName+"'>"
										+ orderObj.mediumName
										+ "</td></tr>"
										+ "<tr><th>Class</th><td title='"+orderObj.className+"'>"
										+ orderObj.className
										+ "</td></tr>"
										+ "<tr><th>Section</th><td title='"+orderObj.sectionName+"'>"
										+ orderObj.sectionName
										+ "</td></tr>"
										+ "<tr><th>Fee Type</th><td title='"+orderObj.feeType+"'>"
										+ orderObj.feeType
										+ "</td></tr>"
										+ "<tr><th>Paid Fee</th><td title='"+orderObj.fee+"'>"
										+ orderObj.fee
										+ "</td></tr>"
										+ "<tr><th>Due Fee</th><td title='"+orderObj.dueFee+"'>"
										+ orderObj.dueFee
										+ "</td></tr>"
										+ "<tr><th>Fee Date</th><td title='"+orderObj.feeDate+"'>"
										+ orderObj.feeDate + "</td></tr>";
								$(tblRow1).appendTo("#itemContainer1"); */
								// for download PDF option */

							});
			      
			$("#addmissionTotal").text(addmissionTotal);
			$("#tutionTotal").text(tutionFeeTotal);
			$("#busTotal").text(transportationFeeTotal);
			$("#schoolTotal").text(hostelFeeTotal);
			$("#stationaryTotal").text(stationaryFeeTotal);
			$("#paidFeeTotal").text(paidFeeTotal);
			$("#dueFeeTotal").text(dueFeeTotal);
			
		} else {
			//alert('no data to display..');
		}
	}
	
	function editPack(id) {
		
		$("#admissionFee").prop("disabled", false);
		$("#tutionFee").prop("disabled", false);
		$("#transportationFee").prop("disabled", false);
		$("#hostelFee").prop("disabled", false);
		$("#stationaryFee").prop("disabled", false);
		
		$("#divAdmissionFee").show();  
		$("#divTutionFee").show();
		$("#divTransportationFee").show();
		$("#divHostelFee").show();
		$("#divStationaryFee").show();
		var transactionId = serviceUnitArray[id].id;
		$("#fee-form").validate().resetForm();
		$("#id").val(serviceUnitArray[id].id);
		$('#boardName').val(serviceUnitArray[id].boardId);
		classNameFilter();
		$('#className').val(serviceUnitArray[id].classId);
 		sectionFilter();
		
		$('#section').val(serviceUnitArray[id].sectionId);
 		mediumFilter();
		$('#medium').val(serviceUnitArray[id].mediumId);
		studentFilterDropdown();
		$('#studentId').val(serviceUnitArray[id].studentId);
		$('#paymentDate').val(serviceUnitArray[id].feeDate);
		editStudentFee(id,serviceUnitArray[id].studentId);
		$('#studentId').trigger("chosen:updated");
		
		$("#submitId").val("Update");
		
		$(window).scrollTop($('#boardName').offset().top);
	}

	function serviceFilter(id) {
		var borderId = $("#boardName").val();
		$.ajax({
			type : "POST",
			url : "getBordName.json",
			data : "borderId=" + borderId,
			dataType : "json",
			success : function(response) {
				var optionsForClass = "";
				optionsForClass = $("#medium").empty();
				optionsForClass.append(new Option("--Select--", ""));
				$.each(response, function(i, tests) {
					var id = tests.id;
					var name = tests.name;
					optionsForClass.append(new Option(name, id));
				});
				$('#medium').trigger("chosen:updated");
			}
		});
	}

	function classNameFilter() {
		var boardId = $("#boardName").val();
			$.ajax({
				type : "POST",
				url : "getClassNameFilter.json",
				data : "boardId=" + boardId,
				async:false,
				success : function(response) {
					
					var optionsForClass = "";
					optionsForClass = $("#className").empty();
					optionsForClass.append(new Option("-- Choose Class --", ""));
					$.each(response, function(i, tests) {
						var id = tests.id;
						var className = tests.className;
						optionsForClass.append(new Option(className, id));
					});
					
				}
			});
	}
	
	function sectionFilter() {
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		if (boardId.length != 0 ) {
			$.ajax({
				type : "POST",
				url : "getSectionFilter.json",
				data : "boardId=" + boardId + "&classId=" + classId,
				dataType : "json",
				async:false,
				success : function(response) {
					/* alert(response); */
					var optionsForClass = "";
					optionsForClass = $("#section").empty();
					optionsForClass.append(new Option("-- Choose Section --",""));
					$.each(response, function(i, tests) {
						var id = tests.id;
						var sectionName = tests.sectionName;
						optionsForClass.append(new Option(sectionName, id));
					});
				}
			});
		}
	}
	
	function mediumFilter() {
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		if (boardId.length != 0) {
			$.ajax({
				type : "POST",
				url : "getMediumFilter.json",
				data : "boardId=" + boardId + "&classId=" + classId
						+ "&sectionId=" + sectionId,
				dataType : "json",
				async:false,
				success : function(response) {
					/* alert(response); */
					var optionsForClass = "";
					optionsForClass = $("#medium").empty();
					optionsForClass
							.append(new Option("-- Choose Medium --", ""));
					$.each(response, function(i, tests) {
						var id = tests.id;
						var mediumName = tests.mediumName;
						optionsForClass.append(new Option(mediumName, id));
					});
				}
			});
		}
	}
	function studentFilterDropdown() {
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		var mediumId = $("#medium").val();
		
			$.ajax({
				type : "POST",
				url : "studentFilterDropdown.json",
				data : "boardId=" + boardId + "&classId=" + classId
						+ "&sectionId=" + sectionId + "&mediumId=" + mediumId,
				dataType : "json",
				async:false,
				success : function(response) {
					// 				 alert(response);  
					var optionsForClass = "";
					optionsForClass = $("#studentId").empty();
					optionsForClass.append(new Option("-- Choose Student --",
							""));
					$.each(response, function(i, tests) {
						var studentId = tests.studentId;
						var studentName = tests.studentName;
						optionsForClass.append(new Option(studentName,
								studentId));
					});
					
				}
			});
		
	}

	
	

	var admissionFee1 =0.00;
	var tutionFee1 = 0.00;
	var transportationFee1 = 0.00;
	var hostelFee1 = 0.00;
	var stationaryFee1 = 0.00;
	
	var dueFee12 ;
	function getDueFee() {
		
		
		var studentId = $("#studentId").val();
		if(studentId != ""){
		$.ajax({
			type : "POST",
			url : "getDueFee.json",
			data : "studentId=" + studentId,
			dataType : "json",
			async:false,
			success : function(response) {
					 console.log(response); 
				console.log(parseInt(response.dueFee));
				console.log(parseInt(response.netFee)); 
				console.log(!(parseInt(response.netFee) >= parseInt(response.dueFee))); 
				
				if(response.totalPaidFee == 0){
					firstFeePayment(response);
				
				}else if ((parseInt(response.netFee) > parseInt(response.dueFee)) && parseInt(response.dueFee) != 0 ) {// this condition is for when Student is paid full amount 
				
					firstFeePayment(response);
					
				}else{
					
					
					dueFee12=  response.netFee;
					$("#displayId").text("No due amount.!");
															
					$("#admissionFee").prop("disabled", true);
					$("#tutionFee").prop("disabled", true);
					$("#transportationFee").prop("disabled", true);
					$("#hostelFee").prop("disabled", true);
					$("#stationaryFee").prop("disabled", true);
					
					$("#divAdmissionFee").hide();  
					$("#divTutionFee").hide();
					$("#divTransportationFee").hide();
					$("#divHostelFee").hide();
					$("#divStationaryFee").hide();
					
				
				}
			},
		
		});
		}else{
			//$("#fee").val('');
			$("#displayId").text('');
		}
	}
	
		

	function firstFeePayment(response){
		
		$("#displayId").text("Due Fee: " + response.dueFee);
		
		if(response.admissionFee == 0){
			 $("#admissionFee").val(0);
			$("#admissionFee").prop("disabled", true);
			$("#divAdmissionFee").hide();  
		}else{
			
			$("#admissionFee").prop("disabled", false);
			$("#divAdmissionFee").show();  
			
			
		$("#admissionNetFee").text("Net Fee: " +response.admissionFee);
		 $("#admissionFee").val(0);
		
		}
		if(response.tutionFee == 0){
			 $("#tutionFee").val(0);
			$("#tutionFee").prop("disabled", true);
			$("#divTutionFee").hide();
		}else{
		
			$("#tutionFee").prop("disabled", false);
			$("#divTutionFee").show();
			
		$("#tutionNetFee").text("Net Fee: " +response.tutionFee);
		  $("#tutionFee").val(0);
		}
		if(response.transportationFee == 0){
			 $("#transportationFee").val(0);
			$("#transportationFee").prop("disabled", true);
			$("#divTransportationFee").hide();
			
		}else{
			
			$("#transportationFee").prop("disabled", false);
			$("#divTransportationFee").show();
			
		$("#transportationNetFee").text("Net Fee: " +response.transportationFee);
		  $("#transportationFee").val(0);
		}
		if(response.hostelFee == 0){
			$("#hostelFee").val(0);
			$("#hostelFee").prop("disabled", true);
			$("#divHostelFee").hide();
		}else{
			
			//if(response.termOne > 0 &&  response.termTwo > 0  && response.termThree > 0){
			
				$("#hostelFee").prop("disabled",false);
				$("#divHostelFee").show();
				
			$("#hostelNetFee").text("Term 1: " +response.termOne + " , Term 2: " +response.termTwo +", Term 3: " + response.termThree + ", Total Balance :" + response.hostelFee  );
			 $("#hostelFee").val(0);
			//}
		}
		if(response.stationaryFee == 0){
			 $("#stationaryFee").val(0);
			$("#stationaryFee").prop("disabled", true);
			$("#divStationaryFee").hide();
		}else{
		$("#stationaryFee").prop("disabled", false);
		$("#divStationaryFee").show();
		
		$("#stationaryNetFee").text("Net Fee: " +response.stationaryFee);
		  $("#stationaryFee").val(0);
		}
		 admissionFee1 = response.admissionFee;
		tutionFee1 = response.tutionFee;
		transportationFee1 = response.transportationFee;
		hostelFee1 = response.hostelFee;
		stationaryFee1 = response.stationaryFee; 
		
	}
	
	
function editStudentFee(id,studentId) {
				
		$.ajax({
			type : "POST",
			url : "editStudentFee.json",
			data : "id=" + id +"&studentId="+studentId,
			dataType : "json",
			async:false,
			success : function(response) {
							console.log(response); 
				
				if (response.dueFee == null || response.dueFee == 0) {
					
					dueFeeupdate=  response.netFee;
					$("#displayId").text("Due Fee: " + response.netFee);
															
					$("#admissionFee").prop("disabled", true);
					$("#tutionFee").prop("disabled", true);
					$("#transportationFee").prop("disabled", true);
					$("#hostelFee").prop("disabled", true);
					$("#stationaryFee").prop("disabled", true);
					
					$("#divAdmissionFee").hide();  
					$("#divTutionFee").hide();
					$("#divTransportationFee").hide();
					$("#divHostelFee").hide();
					$("#divStationaryFee").hide();
					
					 $('#forFormValidation').val('');
					
					
					
				} else {
						$("#displayId").text("Due Fee: " + response.dueFee);
						
						if(response.admissionFee == 0){
							$("#admissionNetFee").text("No Due in Addmission Fee" );
							$("#admissionFee").prop("disabled", true);
							//$("#divAdmissionFee").hide();  
						}else{ 
					 	
						$("#admissionNetFee").text("Net Fee: " +response.admissionFee);
						$("#admissionFee").val(0);
						
						}
						 if(response.tutionFee == 0){
							 $("#tutionFee").text("No Due in Tution Fee" );
							$("#tutionFee").prop("disabled", true);
							//$("#divTutionFee").hide();
						}else{  
						
						$("#tutionNetFee").text("Net Fee: " +response.tutionFee);
						  $("#tutionFee").val(0);
						}
						 if(response.transportationFee == 0){
							 $("#transportationFee").text("No Due in Transportation Fee" );
							$("#transportationFee").prop("disabled", true);
							//$("#divTransportationFee").hide();
							
						}else{  
						$("#transportationNetFee").text("Net Fee: " +response.transportationFee);
						$("#transportationFee").val(0);
						}
						 if(response.hostelFee == 0){
							 $("#hostelFee").text("No Due in Hostel Fee" );
							$("#hostelFee").prop("disabled", true);
							//$("#divHostelFee").hide();
						}else{  
						
						$("#hostelNetFee").text("Net Fee: " +response.hostelFee);
					  $("#hostelFee").val(0);
						}
						if(response.stationaryFee == 0){
							$("#stationaryFee").text("No Due in Stationary Fee" );
							$("#stationaryFee").prop("disabled", true);
							//$("#divStationaryFee").hide();
						} 
						
						$("#stationaryNetFee").text("Net Fee: " +response.stationaryFee);
						 $("#stationaryFee").val(0);
						
						admissionFee1 = response.admissionFee;
						tutionFee1 = response.tutionFee;
						transportationFee1 = response.transportationFee;
						hostelFee1 = response.hostelFee;
						stationaryFee1 = response.stationaryFee; 
				}
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {

				}
			}
		});
		
	}
	function deleteStudentFee(id){
		
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		
			$.ajax({
				type : "POST",
				url : "deleteStudentFee.json",
				data : "id=" + id ,
				dataType : "json",
				async:false,
				success : function(response) {
					displayTable(response);
					window.location.href='studentFeeHome';
				}
			});
		}else{
			
		}
	}

/* 	var dueFeeupdate;
function getDueFeeUpdateTime() {
		
		var studentId = $("#studentId").val();
		if(studentId != ""){
		$.ajax({
			type : "POST",
			url : "getDueFee.json",
			data : "studentId=" + studentId,
			dataType : "json",
			async:false,
			success : function(response) {
							// console.log(response); 
				
				if (response.dueFee == null || response.dueFee == 0) {
					
					dueFeeupdate=  response.netFee;
					$("#displayId").text("Due Fee: " + response.netFee);
															
					$("#admissionFee").prop("disabled", true);
					$("#tutionFee").prop("disabled", true);
					$("#transportationFee").prop("disabled", true);
					$("#hostelFee").prop("disabled", true);
					$("#stationaryFee").prop("disabled", true);
					
					$("#divAdmissionFee").hide();  
					$("#divTutionFee").hide();
					$("#divTransportationFee").hide();
					$("#divHostelFee").hide();
					$("#divStationaryFee").hide();
					
					 $('#forFormValidation').val('');
					
					
					
				} else {
					$("#displayId").text("Due Fee: " + response.dueFee);
					
				/* 	if(response.admissionFee == 0){
						$("#admissionFee").prop("disabled", true);
						$("#divAdmissionFee").hide();  
					}else{
				 	
					$("#admissionNetFee").text("Net Fee: " +response.admissionFee);
					// $("#admissionFee").val(0);
					
					//}
					/* if(response.tutionFee == 0){
						
						$("#tutionFee").prop("disabled", true);
						$("#divTutionFee").hide();
					}else{ */
					
				//	$("#tutionNetFee").text("Net Fee: " +response.tutionFee);
					  //$("#tutionFee").val(0);
				//	}
					/* if(response.transportationFee == 0){
						
						$("#transportationFee").prop("disabled", true);
						$("#divTransportationFee").hide();
						
					}else{ */
				//	$("#transportationNetFee").text("Net Fee: " +response.transportationFee);
					 // $("#transportationFee").val(0);
					//}
					/* if(response.hostelFee == 0){
						
						$("#hostelFee").prop("disabled", true);
						$("#divHostelFee").hide();
					}else{ 
					
					$("#hostelNetFee").text("Net Fee: " +response.hostelFee);
				/* 	 $("#hostelFee").val(0);
					}
					if(response.stationaryFee == 0){
						
						$("#stationaryFee").prop("disabled", true);
						$("#divStationaryFee").hide();
					}
					
					$("#stationaryNetFee").text("Net Fee: " +response.stationaryFee);
					//  $("#stationaryFee").val(0);
					
					admissionFee1 = response.admissionFee;
					tutionFee1 = response.tutionFee;
					transportationFee1 = response.transportationFee;
					hostelFee1 = response.hostelFee;
					stationaryFee1 = response.stationaryFee;
				}
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {

				}
			}
		});
		}else{
			//$("#fee").val('');
			$("#displayId").text('');
		}
	}
 */
	
	 

	function popupOpen(id) {
		$('#printTab').text("");
		var studentFeeId = id;

		$
				.ajax({
					type : "POST",
					url : "getPrintFee.json",
					data : "studentFeeId=" + studentFeeId,
					dataType : "json",
					success : function(response) {
						console.log(response);
						var popuptitle = null;
						for(var j=1; j<=2;j++){
						$.each(response, function(i, tests) {
										//var	schoolCopy = "<span>-----School Copy---------</span>"
											var stockInformation1 = "<table align='center' class='table table-stripped table-bordered table-condensed' id='stockInformationTable' style='font-family: 'Open Sans', arial, sans-serif;font-size: 16px;'>"
											
											/* + "<tr><td colspan='2'><img src='img/ABV-header.png' style='width: 100%;height: 70px;'></td></tr>" */
											+ "<tr><td  align='left'><img src='img/logoprint.png' style='height:38px;'></td>"
											+"<td><span style='font-size: normal;color: black;'> Invoice Number : <b> "+ tests.invoiceId+"</b></span></td>"
											+"</td></tr>"
											+ "<tr style='height: 22px;'>"
											+"<td ><span style='font-size: normal;color: blue;'>Cashier Name: "+tests.cashier + "</span></td>"
											+"<td ><span style='font-size: normal;color: blue;'>Date: "+ tests.paymentDate+ "</span></td></tr>"
											
											+ "<tr style='height: 22px;'>"
											+"<td><b>Student Name: </b>&nbsp;&nbsp;"+ tests.studentName+ "</td>"
											+ "<td><b>Father Name: </b>&nbsp;&nbsp;"+ tests.fatherName+ "</td></tr>"
											+ "<tr style='height: 22px;'><td colspan='2'><b>Mobile: </b>&nbsp;&nbsp;"+ tests.mobile+ "</td></tr>"
											+ "<tr style='height: 22px;'><td colspan='2'><span class='mediu'><b>Board: </b>&nbsp;&nbsp;"+ tests.boardName+ "</span>&nbsp;&nbsp;"
											+ 	"<span><b>Medium: </b>&nbsp;&nbsp;"+ tests.medium+ "</span>&nbsp;&nbsp;"+ "<span><b>Class: </b>&nbsp;&nbsp;"+ tests.className
											+ 	"</span>&nbsp;&nbsp;"+ "<span><b>Section: </b>&nbsp;&nbsp;"+ tests.sectionName
											+ "</span></td></tr>"
											
											+ "<tr style='height: 22px;'><th>Particulars</th><th>Amount</th></tr>"
											
											+ "<tr style='height: 22px;'><td align='center'>Admission Fee</td><td align='center'>"+ tests.admissionFee+ "</td></tr>"
											+ "<tr style='height: 22px;'><td align='center'>Tuition Fee</td><td align='center'>"+ tests.tutionFee+ "</td></tr>"
											+ "<tr style='height: 22px;'><td align='center'>Bus Fee</td><td align='center'>"+ tests.transportationFee+ "</td></tr>"
											+ "<tr style='height: 22px;'><td align='center'>School Fee</td><td align='center'>"+ tests.hostelFee+ "</td></tr>"
											+ "<tr style='height: 22px;'><td align='center'>Stationary Fee</td><td align='center'>"+ tests.stationaryFee+ "</td></tr>"
											+ "<tr style='height: 22px;'><td align='center'>Amount Paid</td><td align='center'>"+ tests.fee+ "/-</td></tr>"
											+ "<tr style='height: 22px;'><td align='right'><b>Total Amount:</b></td><td align=''>"+ tests.fee+ "/-</td></tr>"
											// + "<tr style='height: 35px;'><td colspan='2' id='totalId'><b>(Amount) in words: </b>"+ toWords(Math.round(tests.fee))+ "</td></tr>"
											+ "</table>"
											+ "<span><p><b>Due Fee : "+ tests.dueFee+ "</b></p></span>"

										//$(schoolCopy).appendTo("#printTab");
										$(stockInformation1).appendTo("#printTab");
										 var  horizontal="<hr size='+30+'>"
											$(horizontal).appendTo("#printTab"); 
										/* var	parentCopy = "<span>-----Parent Copy---------</span>"
											$(parentCopy).appendTo("#printTab"); */
										// toWords(tests.fee);

										});
						}
						var printbutton="<input id='printbtn' style='' class='btn btn-default' type='button' value='Print' onclick=PrintElem('#printTab') />"
							$(printbutton).appendTo("#printTab");
						// 							 $(stockInformation2).appendTo("#stockInformationTable"); 
						// 							 $('#dial').dialog({width:799,title:popuptitle,modal: true}).dialog('open');

					},
					
				});
	}
	function PrintElem(elem) {
		$("#printbtn").hide();
		Popup($(elem).html());
	}

	function Popup(data) {
		var mywindow = window.open('','new div');

	    var is_chrome = Boolean(mywindow.chrome);
	    var isPrinting = false;
	    mywindow.document.write('<html><head><title>Vivekananda Vidhyalayam</title> <link rel="stylesheet" type="text/css" href="../assets/css/img.css"> <link rel="stylesheet" type="text/css" href="css/printcss.css"><link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"></head><body>');
	    mywindow.document.write(data);
	   
	    mywindow.document.write('</body></html>');
	    mywindow.document.close(); // necessary for IE >= 10 and necessary before onload for chrome
		
	    if (is_chrome) {
	        mywindow.onload = function() { // wait until all resources loaded 
	            mywindow.focus(); // necessary for IE >= 10
	            mywindow.print();  // change window to mywindow
	            mywindow.close();// change window to mywindow
	        };
	    
	    
	   } else {
	        mywindow.document.close(); // necessary for IE >= 10
	        mywindow.focus(); // necessary for IE >= 10

	        mywindow.print();
	        mywindow.close();
	   }
		
		$("#printbtn").show();
		return true;
	}
	/*  var doc = new jsPDF();
	 var specialElementHandlers = {
	     '#editor': function (element, renderer) {
	         return true;
	     }
	 };

	 $('#pdfDownload').click(function () {
	     doc.fromHTML($('#itemContainer').html(), 15, 15, {
	         'width': 170,
	             'elementHandlers': specialElementHandlers
	     });
	     doc.save('sample-file.pdf');
	 }); */
	$("#itemContainer1").hide();
	$(function() {
		var doc = new jsPDF();
		var specialElementHandlers = {
			'#editor' : function(element, renderer) {
				return true;
			}
		};
	});
	$('#pdfDownload').click(function() {

		var table = tableToJson($('#itemContainer1').get(0))
		var doc = new jsPDF('p', 'pt', 'a4', true);
		doc.cellInitialize();
		$.each(table, function(i, row) {
			console.debug(row);
			$.each(row, function(j, cell) {
				doc.cell(1, 1, 120, 50, cell, i); // 2nd parameter=top margin,1st=left margin 3rd=row cell width 4th=Row height
			})
		})

		doc.save('StudentFees-List.pdf');
	});
	function tableToJson(table) {
		var data = [];

		// first row needs to be headers
		var headers = [];
		for (var i = 0; i < table.rows[0].cells.length; i++) {
			headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase()
					.replace(/ /gi, '');
		}

		// go through cells
		for (var i = 0; i < table.rows.length; i++) {

			var tableRow = table.rows[i];
			var rowData = {};

			for (var j = 0; j < tableRow.cells.length; j++) {

				rowData[headers[j]] = tableRow.cells[j].innerHTML;

			}

			data.push(rowData);
		}

		return data;
	}

	/* function searchStudetnFee() {
		var studentId = $('#studentId').val();
		var classId = $('#className').val();
		var boardId = $('#boardName').val();
		var sectionId = $('#section').val();
		var mediumId = $('#medium').val();
		$.ajax({
			type : "POST",
			url : "searchStudetnFee.json",
			data : "studentId=" + studentId + "&classId=" + classId
					+ "&sectionId=" + sectionId + "&mediumId=" + mediumId
					+ "&boardId=" + boardId,
			dataType : "json",
			success : function(response) {
				// 				 alert(response);  
				displayTable(response)

			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {

				}
			}
		});

	} */
	var th = ['','Thousand','million', 'billion','trillion'];
	 //uncomment this line for English Number System
	 //var th = ['','thousand','million', 'milliard','billion'];

	 var dg = ['Zero','One','Two','Three','Four', 'Five','Six','Seven','Eight','Nine']; 
	 var tn = ['Ten','Eleven','Twelve','Thirteen', 'Fourteen','Fifteen','Sixteen', 'Seventeen','Eighteen','Nineteen']; var tw = ['Twenty','Thirty','Forty','Fifty', 'Sixty','Seventy','Eighty','Ninety']; 
	 function toWords(s){s = s.toString(); s = s.replace(/[\, ]/g,''); if (s != parseFloat(s)) return 'not a number'; var x = s.indexOf('.'); if (x == -1) x = s.length; if (x > 15) return 'too big'; var n = s.split(''); var str = ''; var sk = 0; for (var i=0; i < x; i++) {if ((x-i)%3==2) {if (n[i] == '1') {str += tn[Number(n[i+1])] + ' '; i++; sk=1;} else if (n[i]!=0) {str += tw[n[i]-2] + ' ';sk=1;}} else if (n[i]!=0) {str += dg[n[i]] +' '; if ((x-i)%3==0) str += 'Hundred ';sk=1;} if ((x-i)%3==1) {if (sk) str += th[(x-i-1)/3] + ' ';sk=0;}} 
	 if (x != s.length)
	 {
	 	var y = s.length;
	 	str += 'point ';
	 	for (var i=x+1; i<y; i++) 
	 		str += dg[n[i]] +' ';
	 	} return str.replace(/\s+/g,' ');
	 	}
</script>
