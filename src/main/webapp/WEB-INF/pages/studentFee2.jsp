<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<style>
/* .ui-dialog .ui-widget .ui-widget-content .ui-corner-all .ui-front .ui-draggable .ui-resizable
#dial{
    position: relative;
    height: auto;
    width: 799px;
    top: -5em;
    display: block;
}*/
</style>

<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script> -->
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
	<!-- <script src="js/dropdownsearch.js"></script>
	<link href="css/dropdownsearch.css"/> -->
<!-- 	  <script src="js/chosen.jquery.js"></script> -->

		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">Student Fee</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
					<div class="spacer">
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="blog" style="border: 1px solid;">
									<!-- <div class="blog-header">
										<h5 class="blog-title">Student Fee</h5>
									</div> -->
									<div class="blog-body">
										<form:form id="fee-form" action="addStudentFee.htm" commandName="packCmd" method="post" class="form-horizontal">
										
										<div class="row">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Board Name</label>
												    <div class="col-sm-8">
														<form:select path="boardName" tabindex="1" onchange="classNameFilter(),searchStudetnFee()" class="form-control" >
															<form:option value=""  >-- Choose Board --</form:option>
															<form:options items="${board}"></form:options>
														</form:select>
														<span class="boardName_error" id="boardName_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Class</label>
												    <div class="col-sm-8">
														<form:select path="className" tabindex="2" onchange="sectionFilter(),searchStudetnFee()" class="form-control" >
															<form:option value=""  >-- Choose Class --</form:option>
															<form:options items="${allClasses}"></form:options>
														</form:select>
														<span class="className_error" id="className_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Section</label>
												    <div class="col-sm-8"> 
														<form:select path="section" tabindex="3" onchange="mediumFilter(),searchStudetnFee()" class="form-control" >
															<form:option value=""  >-- Choose Section --</form:option>
															<form:options items="${allSection}"></form:options>
														</form:select>
														<span class="section_error" id="section_error"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Medium</label>
												    <div class="col-sm-8">	
														<form:select path="medium" tabindex="4" onchange="studentFilterDropdown(),searchStudetnFee()" class="form-control" >
															<form:option value=""  >-- Choose Medium --</form:option>
															<form:options items="${mediam}"></form:options>
														</form:select>
														<span class="medium_error" id="medium_error"></span>
													</div>
												</div>
											</div>
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Student</label>
												    <div class="col-sm-8">	
														<form:select path="studentId" tabindex="5" class="form-control" required="true" onchange="getDueFee(),searchStudetnFee()" >
															<form:option value=""  >-- Choose Student --</form:option>
															<form:options items="${allStudents}"></form:options>
														</form:select>
													</div>
												</div>
											</div>
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Fee Type</label>
												    <div class="col-sm-8">	
														<form:input path="feeType" class="form-control" tabindex="6" placeholder="Enter Fee Type" required="true"/>
													</div>
												</div>
											</div>
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<div class="form-group">
												    <label for="inputEmail3" class="col-sm-4 control-label">Fee</label>
												    <div class="col-sm-8">
														<form:input path="fee" class="form-control numericOnly" tabindex="7" placeholder="Enter Fee Amount" required="true"/>
														<span class="fee_error" id="fee_error"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-8 col-sm-offset-4">
												<div class="form-group">
												    <div class="col-sm-8 col-sm-offset-2">
														<span id="displayId"></span>
													</div>
												</div>
												<form:hidden path="id" tabindex="1" />
												<div class="form-group">
												  	<div class="col-sm-8 col-sm-offset-2">
													<input type="submit" value="Submit" class="btn btn-success" tabindex="8"/>
													<button type="button" class="btn btn-danger" id="cancel" tabindex="9">Reset</button>
													</div>
												</div>
											</div>
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
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Fee Receipt</h4>
        </div>
        <div class="modal-body" id='printTab'>
          
        </div>
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
									<button class="btn btn-primary" id="pdfDownload">Download Students Fee List</button>
										<div id="tableId">
											<table id="itemContainer1" class="table table-bordered table-condensed no-margin">
											<!-- <thead>
									          <tr><th>Student Name</th></tr>
						                      <tr><th>Father Name</th></tr>
						                      <tr><th>Mobile</th></tr>
						                      <tr><th>Class</th></tr>
						                      <tr><th>Board</th></tr>
						                      <tr><th>Medium</th></tr>
						                      <tr><th>Section</th></tr>
						                      <tr><th>Fee Type</th></tr>
						                      <tr><th>Paid Fee</th></tr>
						                      <tr><th>Due Fee</th></tr>
						                      <tr><th>Fee Date</th></tr>
									        </thead> -->
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
								<div class="blog">
									<div class="blog-header">
										<h4>List of Student Fees</h4>
									</div>
									<div class="blog-body">
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
													<div id="basicTable">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Father Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Mobile Number</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Fee Type</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Paid Fee</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Due Fee</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Fee Date</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>
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
						<!-- Row Ends -->
						
					</div>
					<!-- Spacer ends -->

				</div>
				<!-- Container fluid ends -->

			</div>
			<!-- Main Container ends -->

		<div id="dial" style="width: auto;min-height: 130px;max-height: none;height: auto;background-color: #c3dac3;display: none;"></div>
		</div>
		<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
<script type="text/javascript">

$(document).ready(function () 
		{
			$("#fee").val("");
		});

 
 jQuery.validator.addMethod('lettersonly', function(value, element) {
    return this.optional(element) || /^[a-z. áãâäàéêëèíîïìóõôöòúûüùçñ]+$/i.test(value);
}, "Please Enter Valid Name");

jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
   phone_number = phone_number.replace(/\s+/g, ""); 
 return this.optional(element) || phone_number.length > 9 &&
   phone_number.match(/^[7-9]\d+$/);
}, "Invalid Mobile Number");
   
$("#fee-form").validate({
    errorElement: 'span',
    errorClass: 'has-error',
	rules:
	{
        /* boardName:{required:true},
	    className:{required:true},  
	    section:{required:true},
	    medium:{required:true}, */
	    studentId:{required: true},
        fee:{required:true, number:true},
        feeType:{required: true},
	},
	messages:
   	{
		/* boardName:{required:'Please Choose Board'},
	    className:{required:'Please Choose Class'},
	    section:{required:'Please Choose Section'},
	    medium:{required:'Please Choose Medium'}, */
	    studentId:{required: 'Please Choose Student Name'},
        fee:{required:'Please Enter Fee Amount',number:'Please Enter Fee Amount'},
        feeType:{required:'Please Enter Fee Type'},
	},
	
  });
 
  $('#cancel').click(function () {
    $("#fee-form").validate().resetForm();
    $("#fee-form").removeClass("has-error");
    $("#studentId").val('');
    $("#fee").val('');
    $("#fee-form").addClass('form-horizontal');
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
				+'<tr role="row">'
				+'<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Father Name</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Mobile Number</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Fee Type</th>'
				+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Paid Fee</th>'
				+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Due Fee</th>'
				+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Fee Date</th>'
				+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>'
				+'</tr>'
				+'</thead>'
				+'<tbody></tbody></table>';
			$('#basicTable').html(tableHead);
			$
					.each(
							listOrders,
							function(i, orderObj) {
								if(orderObj.dueFee==0.00){
									orderObj.dueFee =orderObj.netFee;
								}
								
// 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
								serviceUnitArray[orderObj.id] = orderObj;
								var id = '"' + orderObj.id + '"';
								var tblRow = "<tr align='center' role='row' class='odd'>" 
										+ "<td>"
										+ '<a style="cursor: pointer;" title="View Fee Receipt" data-toggle="modal" data-target="#myModal" data-keyboard="false" data-backdrop="static" onclick=popupOpen('+orderObj.id+')>'
										+ '<b>'+ orderObj.studentName+  '</b></a>' + '</td>'
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.fatherName+"'>"
										+ orderObj.fatherName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mobile+"'>"
										+ orderObj.mobile
										+ "</td>"
									
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"'>"
										+ orderObj.boardName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"' >"
										+ orderObj.mediumName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.className+"'>"
										+ orderObj.className
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.sectionName+"' >"
										+ orderObj.sectionName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.feeType+"'>"
										+ orderObj.feeType
										+ "</td>"
										+ "<td title='"+orderObj.fee+"' >"
										+ orderObj.fee
										+ "</td>"
										+ "<td title='"+orderObj.dueFee+"' >"
										+ orderObj.dueFee
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.feeDate+"' >"
										+ orderObj.feeDate
										+ "</td>"
										+ "<td align='center'>"
										+ '<a href="javascript:void(0)" onclick=editPack('
										+ orderObj.id + ')'
										+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '</td>'
										+ '</tr>';
								$(tblRow).appendTo("#basicExample tbody");
								
								//* for download PDF option
								var tblRow1 = "<tr role='row' class='odd'><th>Student Name</th><td>"+orderObj.studentName+"</td></tr>"
									+ "<tr><th>Father Name</th><td>"+orderObj.fatherName+"</td></tr>"
									+ "<tr><th>Mobile</th><td>"+orderObj.mobile+"</td></tr>"
									+ "<tr><th>Board</th><td title='"+orderObj.boardName+"'>"+orderObj.boardName+"</td></tr>"
									+ "<tr><th>Medium</th><td title='"+orderObj.mediumName+"'>"+orderObj.mediumName+"</td></tr>"
									+ "<tr><th>Class</th><td title='"+orderObj.className+"'>"+orderObj.className+"</td></tr>"
									+ "<tr><th>Section</th><td title='"+orderObj.sectionName+"'>"+orderObj.sectionName+"</td></tr>"
									+ "<tr><th>Fee Type</th><td title='"+orderObj.feeType+"'>"+orderObj.feeType+"</td></tr>"
									+ "<tr><th>Paid Fee</th><td title='"+orderObj.fee+"'>"+ orderObj.fee+"</td></tr>"
									+ "<tr><th>Due Fee</th><td title='"+orderObj.dueFee+"'>"+ orderObj.dueFee+"</td></tr>"
									+ "<tr><th>Fee Date</th><td title='"+orderObj.feeDate+"'>"+orderObj.feeDate+"</td></tr>";
							$(tblRow1).appendTo("#itemContainer1");
							// for download PDF option */
							
							});
$('#basicExample').dataTable();
		} else {
			//alert('no data to display..');
		}
	}  
 	function editPack(id) {
		var transactionId = serviceUnitArray[id].id;
		$("#id").val(serviceUnitArray[id].id);
		
		$('#studentId').val(serviceUnitArray[id].studentId);
		$('#studentId').trigger("chosen:updated");
		$('#fee').val(serviceUnitArray[id].fee);
		$('#feeType').val(serviceUnitArray[id].feeType);
	} 
	
	function serviceFilter(id){
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
					var id=tests.id;
					var name=tests.name;
					optionsForClass.append(new Option(name, id));
				});
				$('#medium').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
	} 
 	
 	
 	function classNameFilter(id){
		var boardId = $("#boardName").val();
		if(boardId.length !=0){
		$.ajax({
			type : "POST",
			url : "getClassNameFilter.json",
			data : "boardId=" + boardId,
			dataType : "json",
			success : function(response) {
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#className").empty();
				optionsForClass.append(new Option("-- Choose Class --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var className=tests.className;
					optionsForClass.append(new Option(className, id));
				});
				$('#className').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
		}
	} 
 	function sectionFilter(){
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		if(boardId.length !=0 && classId.length != 0){
		$.ajax({
			type : "POST",
			url : "getSectionFilter.json",
			data : "boardId=" + boardId+"&classId="+classId,
			dataType : "json",
			success : function(response) {
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#section").empty();
				optionsForClass.append(new Option("-- Choose Section --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var sectionName=tests.sectionName;
					optionsForClass.append(new Option(sectionName, id));
				});
				$('#section').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
		}
	} 
 	function mediumFilter(){
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		if(boardId.length !=0 && classId.length != 0 &&  sectionId.length != 0){
		$.ajax({
			type : "POST",
			url : "getMediumFilter.json",
			data : "boardId=" + boardId+"&classId="+classId+"&sectionId="+sectionId,
			dataType : "json",
			success : function(response) {
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#medium").empty();
				optionsForClass.append(new Option("-- Choose Medium --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var mediumName=tests.mediumName;
					optionsForClass.append(new Option(mediumName, id));
				});
				$('#section').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
		}
	} 
 	function studentFilterDropdown(){
 		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		var mediumId = $("#medium").val();
		if(boardId.length !=0 && classId.length != 0 &&  sectionId.length != 0 && mediumId.length !=0){
		$.ajax({
			type : "POST",
			url : "studentFilterDropdown.json",
			data : "boardId=" + boardId+"&classId="+classId+"&sectionId="+sectionId+"&mediumId="+mediumId,
			dataType : "json",
			success : function(response) {
// 				 alert(response);  
				var optionsForClass = "";
				optionsForClass = $("#studentId").empty();
				optionsForClass.append(new Option("-- Choose Student --", ""));
				$.each(response, function(i, tests) {
					var studentId=tests.studentId;
					var studentName=tests.studentName;
					optionsForClass.append(new Option(studentName, studentId));
				});
				$('#studentId').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
		}
 	}
 	
 	/* $("#search").on("keyup", function() {
 	    var value = $(this).val();

 	    $("table tr").each(function(index) {
 	        if (index !== 0) {

 	            $row = $(this);

 	            var id = $row.find("td:first").text();

 	            if (id.indexOf(value) !== 0) {
 	                $row.hide();
 	            }
 	            else {
 	                $row.show();
 	            }
 	        }
 	    });
 	}); */

 	function getDueFee(){
 		var studentId = $("#studentId").val();
 		$.ajax({
			type : "POST",
			url : "getDueFee.json",
			data : "studentId=" + studentId,
			dataType : "json",
			success : function(response) {
// 				 alert(response.totalFee);  
				 if(response.dueFee == null){
					 $("#displayId").text("Due Fee: "+ response.netFee);
				 }else{
				 $("#displayId").text("Due Fee: "+ response.dueFee);
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
 	
 	 /* $(document).ready(function(){
 		$("select").chosen({allow_single_deselect:true});
    }); */
  function popupOpen(id){
    $('#printTab').text("");
	var studentFeeId = id;

	$.ajax({
				type : "POST",
				url : "getPrintFee.json",
				data : "studentFeeId=" + studentFeeId,
				dataType : "json",
					success : function(response) {
						alert(response);
						var  popuptitle=null;
						$.each(response, function(i, tests) {		
						
								 var stockInformation1 ="<table align='center' class='table table-stripped table-bordered table-condensed' id='stockInformationTable' style='font-family: Baskerville Old Face, cursive;font-size: 18px;'>" 
						
									 		+"<tr><td colspan='2'><img src='img/ABV-header.png' style='width: 100%;'></td></tr>"
									 		+"<tr style='height: 35px;'><td colspan='2'><span style='float: right;font-size: normal;color: blue;'>Date: "+tests.created_time+"</span></td></tr>"
								 			
									 		+"<tr style='height: 35px;'><td colspan='2'><b>Student Name: </b>&nbsp;&nbsp;"+tests.studentName+"</td></tr>"
								 			+"<tr style='height: 35px;'><td colspan='2'><b>Father Name: </b>&nbsp;&nbsp;"+tests.fatherName+"</td></tr>"
								 			+"<tr style='height: 35px;'><td colspan='2'><b>Mobile: </b>&nbsp;&nbsp;"+tests.mobile+"</td></tr>"
									 		
								 			+"<tr style='height: 35px;'><td colspan='2'><b>Board: </b>&nbsp;&nbsp;"+tests.boardName+"&nbsp;&nbsp;"
									 		+"<b>Medium: </b>&nbsp;&nbsp;"+tests.medium+"&nbsp;&nbsp;"
									 		+"<b>Class: </b>&nbsp;&nbsp;"+tests.className+"&nbsp;&nbsp;"
									 		+"<b>Section: </b>&nbsp;&nbsp;"+tests.sectionName+"</td></tr>"
								 			
									 		+"<tr style='height: 35px;'><th>Particulars</th><th>Amount</th></tr>"
									 		
									 		+"<tr style='height: 35px;'><td align='center'>Fee Type</td><td align='center'>"+tests.feeType+"</td></tr>"
								 			+"<tr style='height: 35px;'><td align='center'>Amount Paid</td><td align='center'>"+tests.fee+"/-</td></tr>"
								 			+"<tr style='height: 35px;'><td align='right'><b>Total Amount:</b></td><td align=''>"+tests.fee+"/-</td></tr>"
								 			+"<tr style='height: 35px;'><td colspan='2' id='totalId'><b>(Amount) in words: </b>"+toWords(Math.round(tests.fee)) +"</td></tr>"
									 		+"</table>"
									 		+"<input id='printbtn' style='' class='btn btn-default' type='button' value='Print' onclick=PrintElem('#printTab') />"
									 		
									$(stockInformation1).appendTo("#printTab");
									 	//	toWords(tests.fee);
								
						});
// 							 $(stockInformation2).appendTo("#stockInformationTable"); 
// 							 $('#dial').dialog({width:799,title:popuptitle,modal: true}).dialog('open');
					 
				},
				error : function(e) {
// 					alert('Error: ' + e);
				}
			}); 
    }
    function PrintElem(elem)
    {
    	$("#printbtn").hide();
        Popup($(elem).html());
    }

    function Popup(data)
    {
        var mywindow = window.open('', 'new div');
        mywindow.document.write('<html><head><title>Fees Receipt</title>');
        /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="css/main.css" type="text/css" />');
        mywindow.document.write('</head><body >');
        mywindow.document.write(data);
        mywindow.document.write('</body></html>');
        mywindow.print();
        mywindow.close();
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
    $(function(){
        var doc = new jsPDF();
   var specialElementHandlers = {
       '#editor': function (element, renderer) {
           return true;
       }
   };
    });
  $('#pdfDownload').click(function () {

       var table = tableToJson($('#itemContainer1').get(0))
       var doc = new jsPDF('p','pt', 'a4', true);
       doc.cellInitialize();
       $.each(table, function (i, row){
           console.debug(row);
           $.each(row, function (j, cell){
               doc.cell(1, 1, 120, 50, cell, i);  // 2nd parameter=top margin,1st=left margin 3rd=row cell width 4th=Row height
           })
       })


       doc.save('StudentFees-List.pdf');
   });
   function tableToJson(table) {
   var data = [];

   // first row needs to be headers
   var headers = [];
   for (var i=0; i<table.rows[0].cells.length; i++) {
       headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase().replace(/ /gi,'');
   }


   // go through cells
   for (var i=0; i<table.rows.length; i++) {

       var tableRow = table.rows[i];
       var rowData = {};

       for (var j=0; j<tableRow.cells.length; j++) {

           rowData[ headers[j] ] = tableRow.cells[j].innerHTML;

       }

       data.push(rowData);
   }       

   return data;
}

    
   function searchStudetnFee(){
	var studentId	=$('#studentId').val();
	var classId	=$('#className').val();
	var boardId	=$('#boardName').val();
	var sectionId=	$('#section').val();
	var mediumId=	$('#medium').val();
	$.ajax({
		type : "POST",
		url : "searchStudetnFee.json",
		data : "studentId="+ studentId+"&classId="+classId+"&sectionId="+sectionId+"&mediumId="+mediumId+"&boardId="+boardId,
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
	   
   }
   var th = ['','Thousand','million', 'billion','trillion'];
 //uncomment this line for English Number System
 //var th = ['','thousand','million', 'milliard','billion'];

 var dg = ['Zero','One','Two','Three','Four', 'Five','Six','Seven','Eight','Nine']; 
 var tn = ['Ten','Eleven','Twelve','Thirteen', 'Fourteen','Fifteen','Sixteen', 'Seventeen','Eighteen','Nineteen']; var tw = ['Twenty','Thirty','Forty','Fifty', 'Sixty','Seventy','Eighty','Ninety']; 
 function toWords(s){
	 s = s.toString(); s = s.replace(/[\, ]/g,'');
	 if (s != parseFloat(s)) return 'not a number'; 
	 var x = s.indexOf('.'); if (x == -1) x = s.length; if (x > 15) return 'too big'; var n = s.split(''); var str = ''; var sk = 0; for (var i=0; i < x; i++) {if ((x-i)%3==2) {if (n[i] == '1') {str += tn[Number(n[i+1])] + ' '; i++; sk=1;} else if (n[i]!=0) {str += tw[n[i]-2] + ' ';sk=1;}} else if (n[i]!=0) {str += dg[n[i]] +' '; if ((x-i)%3==0) str += 'Hundred ';sk=1;} if ((x-i)%3==1) {if (sk) str += th[(x-i-1)/3] + ' ';sk=0;}} 
 if (x != s.length)
 {
 	var y = s.length;
 	str += 'point ';
 	for (var i=x+1; i<y; i++) 
 		str += dg[n[i]] +' ';
 	} return str.replace(/\s+/g,' ');
 	}

</script>
