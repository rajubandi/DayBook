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

.form-control {
width:200px !important;
}
td, th {
    padding: 0;
}

@media all {
	.page-break	{ display: none; }
}

@media print {
	.page-break	{ display: block; page-break-before: always; }
}
</style>

<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script> -->
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
<!-- <script src="js/dropdownsearch.js"></script>
	<link href="css/dropdownsearch.css"/> -->
<!-- 	  <script src="js/chosen.jquery.js"></script> -->

<!-- Dashboard Wrapper starts -->
<div class="dashboard-wrapper">

	<!-- Top Bar starts -->
	<div class="top-bar">
		<div class="page-title">Student Hall Ticket</div>
	</div>
	<!-- Top Bar ends -->

	<!-- Main Container starts -->
	<div class="main-container">

		<!-- Container fluid Starts -->
		<div class="container-fluid">
		<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Student Details</a></li>
		<li><a href="#">Student Hall Ticket</a></li>
	    </ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Student Hall Ticket</h4>
					</div>
					<div class="panel-body collapse in">
			<!-- Spacer starts -->
				<!-- Row Starts -->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<form:form id="fee-form" action="addStudentFee.htm"	commandName="packCmd" method="post" class="form-horizontal">

									<div class="row">
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Board Name<span style="color: red;">*</span></label>
												<div class="col-sm-4">
													<form:select path="boardName" 	onchange="classNameFilter(),searchStudetnFee()"	class="form-control">
														<form:option value="">-- Choose Board --</form:option>
														<form:options items="${board}"></form:options>
													</form:select>
													<span class="boardName_error" id="boardName_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Class<span style="color: red;">*</span></label>
												<div class="col-sm-4">
													<form:select path="className" 
														onchange="sectionFilter(),searchStudetnFee()"
														class="form-control">
														<form:option value="">-- Choose Class --</form:option>
<%-- 														<form:options items="${allClasses}"></form:options> --%>
													</form:select>
													<span class="className_error" id="className_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Section<span style="color: red;">*</span></label>
												<div class="col-sm-4">
													<form:select path="section" 
														onchange="mediumFilter(),searchStudetnFee()"
														class="form-control">
														<form:option value="">-- Choose Section --</form:option>
<%-- 														<form:options items="${allSection}"></form:options> --%>
													</form:select>
													<span class="section_error" id="section_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Medium<span style="color: red;">*</span></label>
												<div class="col-sm-4">
													<form:select path="medium" onchange="studentFilterDropdown(),searchStudetnFee()" class="form-control">
														<form:option value="">-- Choose Medium --</form:option>
<%-- 														<form:options items="${mediam}"></form:options> --%>
													</form:select>
													<span class="medium_error" id="medium_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Student<span style="color: red;">*</span></label>
												<div class="col-sm-4">
													<form:select path="studentId" 	class="form-control" required="true" onchange="getDueFee(),searchStudetnFee()">
														<form:option value="">-- Choose Student --</form:option>
														<form:options items="${allStudents}"></form:options>
													</form:select>
												</div>
											</div>
										</div>
										
									
										<div class="col-sm-8 col-sm-offset-4">
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<span id="displayId"></span>
												</div>
											</div>
											<form:hidden path="id"  />
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
<!-- 													<input type="submit" id="submitId" value="Search" class="btn btn-success"/> -->
													<button type="button" class="btn btn-danger" id="cancel" >Reset</button>
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

				<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
					<div class="modal-dialog" style="">

						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Download Hallticket</h4>
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
					<div class="panel panel-info">
					<div class="panel-heading">
					<h4>List of Student Hall Ticket</h4>
					</div>
					<div class="panel-body collapse in">
								<div class="table-responsive">
									<div id="basicExample_wrapper"
										class="dataTables_wrapper form-inline dt-bootstrap">
										<div class="row">
											<div class="col-sm-12">
											<input id="checkAll" class='checkall' type='checkbox'/>&nbsp; Select All
											<span class="btn btn-success btnsm" style="float:  right;" id="printHallticket" onclick="printHallticket()">Print Hallticket</span>
												<div id="basicTable">
													<table id="basicExample"	class="table table-striped table-condensed table-bordered no-margin dataTable"	role="grid" aria-describedby="basicExample_info">
														<thead>
															<tr role="row">
																<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Father Name</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Mobile Number</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>
																<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th>
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

	<div id="dial"
		style="width: auto; min-height: 130px; max-height: none; height: auto; background-color: #c3dac3; display: none;"></div>
</div>
<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
<script type="text/javascript">

var getTabName = window.location.pathname.split('/')[2];
$("#stu_li").addClass('active');
$("#stu_li ul").css('display','block');
$("#stu_li ul li a[href='"+ getTabName +"']").addClass('subactive');

	jQuery.validator.addMethod('lettersonly', function(value, element) {
		return this.optional(element)
				|| /^[a-z. áãâäàéêëèíîïìóõôöòúûüùçñ]+$/i.test(value);
	}, "Please Enter Valid Name");

	jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
		phone_number = phone_number.replace(/\s+/g, "");
		return this.optional(element) || phone_number.length > 9
				&& phone_number.match(/^[7-9]\d+$/);
	}, "Invalid Mobile Number");

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
			
		},
		messages : {
		boardName:{required:'Choose Board'},
			className:{required:'Choose Class'},
			section:{required:'Choose Section'},
			medium:{required:'Choose Medium'}, 
			studentId : {required : 'Choose Student Name'},
		},
	});
	
	   
	$('#cancel').click(function() {
		$("#fee-form").validate().resetForm();
		$("#fee-form").removeClass("has-error");
		$("#boardName").val('');
		$("#className").val('');
		$("#section").val('');
		$("#medium").val('');
		$("#studentId").val('');
		$("#displayId").val('');
		$("#fee-form").addClass('form-horizontal');
		$("#displayId").text('');
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
					+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Father Name</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Mobile Number</th>'
					/* + '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>' */
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Class</th>'
					+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Section</th>'
					+ '<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>'
					+ '</tr>' + '</thead>' + '<tbody></tbody></table>';
			$('#basicTable').html(tableHead);
			$.each(listOrders,	function(i, orderObj) {
								//console.log(orderObj);
								if (orderObj.dueFee == 0.00) {
									orderObj.dueFee = orderObj.netFee;
								}

								// 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
								serviceUnitArray[orderObj.id] = orderObj;
								var id = '"' + orderObj.id + '"';
								var tblRow = "<tr  role='row' class='odd'>"
										+ "<td>"
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
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"' >"
										+ orderObj.mediumName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.className+"'>"
										+ orderObj.className
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.sectionName+"' >"
										+ orderObj.sectionName
										+ "</td>"
										+ "<td align='center'>"
										+ '<a style="cursor: pointer;" title="Download Hallticket" data-toggle="modal" data-target="#myModal" data-keyboard="false" data-backdrop="static" onclick=popupOpen('
										+ orderObj.id
										+ ')>'
										+ 'Hallticket </a>&nbsp;'+"<input class='checkall multiplecheck' type='checkbox' name='checkboxName' id='"+orderObj.id+"' value='"+orderObj.id+"'/>"
										+ '</td>' + '</tr>';
								$(tblRow).appendTo("#basicExample tbody");


							});
		//	$('#basicExample').dataTable();
		} else {
			//alert('no data to display..');
		}
	}
	$("#checkAll").change(function () {
		oTable.$("input:checkbox").prop('checked', $(this).prop("checked"));
		var len=$("[name='checkboxName']:checked").length;
		if(len!=0)
		{
			$('#delbtn').show();
		}
		else
		{
			$('#delbtn').hide();
		}
	});
	function printHallticket(){
		
		var selected = new Array();
		$('#basicExample input[type="checkbox"]:checked').each(function() {
		    selected.push($(this).attr('id'));
		});
		if(selected.length > 0){
			$.ajax({
				type : "POST",
				url : "getHallticketAuto",
				data : {studentArry:selected},
				dataType : "json",
				success : function(response) {
					
					//console.log(response)
					
					//$('#myModal').modal();
					 hallticketDesign(response);
					 
					//$("#printbtn").click();
					 
				}
			
				});
		}else{
			
			alert("please select Student(s)");
		}
		
		
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
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {

				}
			}
		});
	}

	function classNameFilter(id) {
		var boardId = $("#boardName").val();
		if (boardId.length != 0) {
			$.ajax({
				type : "POST",
				url : "getClassNameFilter.json",
				data : "boardId=" + boardId,
				dataType : "json",
				success : function(response) {
					/* alert(response); */
					var optionsForClass = "";
					optionsForClass = $("#className").empty();
					optionsForClass
							.append(new Option("-- Choose Class --", ""));
					$.each(response, function(i, tests) {
						var id = tests.id;
						var className = tests.className;
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
	function sectionFilter() {
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		if (boardId.length != 0 && classId.length != 0) {
			$.ajax({
				type : "POST",
				url : "getSectionFilter.json",
				data : "boardId=" + boardId + "&classId=" + classId,
				dataType : "json",
				success : function(response) {
					/* alert(response); */
					var optionsForClass = "";
					optionsForClass = $("#section").empty();
					optionsForClass.append(new Option("-- Choose Section --",
							""));
					$.each(response, function(i, tests) {
						var id = tests.id;
						var sectionName = tests.sectionName;
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
	function mediumFilter() {
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		if (boardId.length != 0 && classId.length != 0 && sectionId.length != 0) {
			$.ajax({
				type : "POST",
				url : "getMediumFilter.json",
				data : "boardId=" + boardId + "&classId=" + classId
						+ "&sectionId=" + sectionId,
				dataType : "json",
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
	function studentFilterDropdown() {
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		var mediumId = $("#medium").val();
		if (boardId.length != 0 && classId.length != 0 && sectionId.length != 0
				&& mediumId.length != 0) {
			$.ajax({
				type : "POST",
				url : "studentFilterDropdown.json",
				data : "boardId=" + boardId + "&classId=" + classId
						+ "&sectionId=" + sectionId + "&mediumId=" + mediumId,
				dataType : "json",
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
	var admissionFee1 =0.00;
	var tutionFee1 = 0.00;
	var transportationFee1 = 0.00;
	var hostelFee1 = 0.00;
	var stationaryFee1 = 0.00;
	function getDueFee() {
		var studentId = $("#studentId").val();
		$.ajax({
			type : "POST",
			url : "getDueFee.json",
			data : "studentId=" + studentId,
			dataType : "json",
			success : function(response) {
				// 				 alert(response.totalFee); 
				
				if (response.dueFee == null) {
					$("#displayId").text("Due Fee: " + response.netFee);
				} else {
					$("#displayId").text("Due Fee: " + response.dueFee);
					$("#admissionFee").val(response.admissionFee);  
					$("#tutionFee").val(response.tutionFee);
					$("#transportationFee").val(response.transportationFee);
					$("#hostelFee").val(response.hostelFee);
					$("#stationaryFee").val(response.stationaryFee);
					
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

	
	 
	/* $(document).ready(function(){
	$("select").chosen({allow_single_deselect:true});
	}); */
	
	function hallticketDesign(response){
		$('#printTab').html('');
		 $.each(response,function(i, tests) {
				console.log(tests)  
		var tableHead = /* "<div style='margin-bottom:15px;' align='center' class='img'><img src='img/ABV-header.png' style='height: 70px;'></div>" */"<div style='margin-bottom:15px;' align='center' class='img'><img src='img/logoprint.png' style=''></div>"
			+ "<h4 style='text-align:center;'>" + tests.className +" <span style='color:red;'> "+tests.crTime+"</span></h4>"
			+ "<h4 style='text-align:center;'>Hallticket</h4>"
			/* + "<table style='font-size: 13px;'>"
			+ "<thead><tr><th style='float:left;'><h4>Roll No </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
			+ "<tr><th style='float:left;'><h4>Medium </h4></th><td style='color:green;'><h4>English</h4></td></tr>"
			+ "<tr><th style='float:left;'><h4>Name </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
			+ "<tr><th style='float:left;'><h4>Fathers name </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
			+ "<tr><th style='float:left;'><h4>Address </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
			+ "</tr></thead>"
			+ "</table>" */
			+ "<div class='col-md-7'>"
			+ "<table class='table-bordered table-striped' style='width:50%'>"
			+ "<tbody>"
			+ "<tr><td>Roll No</td><td><p style='color:green;margin-top:5px;'>"+tests.id+"</p></td></tr>"
			+ "<tr><td>Medium</td><td><p style='color:green;margin-top:5px;'>"+tests.medium+"</p></td></tr>"
			+ "<tr><td>Student Name</td><td><p style='color:green;margin-top:5px;'>"+tests.name+"</p></td></tr>"
			+ "<tr><td>Father's  Name</td><td><p style='color:green;margin-top:5px;'>"+tests.fatherName+"</p></td></tr>"
			+ "</tbody>"
			+ "</table>"
			+ "</div>"
			+ "<div class='col-md-5'>"
			+ "<img style='height:100px;width:100px' src='img/default.png' alt='Image' title='Student'>"
			+ "<div class='sign' style='background:#fff; boder='1px solid #000;'>"
			+ "</div>"
			+ "</div>"
			+ "<div class='clearfix'></div>"
			+ "<div style='margin-top:30px;' class='sub'>"
			+ "<table style='font-size: 13px;' align='center' class='table table-stripped table-bordered table-condensed'>"
			+ "<thead>"
			+ "<tr><th><b>Date</b></th><th>03/sep</th><th>03/sep</th><th>03/sep</th><th>03/sep</th><th>03/sep</th><th>03/sep</th></tr>"
			+ "</thead>"
			+ "<tbody>"
			+ "<tr><td><b>Subjects</b></td><td><p style='color:green;margin-top:5px;'>"+tests.id+"</p></td>"
			+ "<td><p style='color:green;margin-top:5px;'>"+tests.id+"</p></td>"
			+ "<td><p style='color:green;margin-top:5px;'>"+tests.id+"</p></td>"
			+ "<td><p style='color:green;margin-top:5px;'>"+tests.id+"</p></td>"
			+ "<td><p style='color:green;margin-top:5px;'>"+tests.id+"</p></td>"
			+ "<td><p style='color:green;margin-top:5px;'>"+tests.id+"</p></td></tr>"
			+ "<tr><td>Invigilator</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>"
			+ "</tbody>"
			+ "</table>"
			+ "</div><div class='page-break'></div>"
			+ '<br>'
			
			$('#printTab').append(tableHead);
		 });
		 Popup($('#printTab').html());
	}
	
	function popupOpen(id) {
		$('#printTab').text("");
		var studentFeeId = id;
		$.ajax({
					type : "POST",
					url : "getHallticket.json",
					data : "studentFeeId=" + studentFeeId,
					dataType : "json",
					success : function(response) {
						
						console.log(response)
						
						$('#myModal').modal();
							/*  $.each(response,function(i, tests) {
								console.log(tests)  */
								var tableHead = "<div style='margin-bottom:15px;' align='center' class='img'><img src='img/logoprint.png' style=''></div>"
									+ "<h4 style='text-align:center;'>" + response.className +" <span style='color:red;'> "+response.crTime+"</span></h4>"
									+ "<h4 style='text-align:center;'>Hallticket</h4>"
									/* + "<table style='font-size: 13px;'>"
									+ "<thead><tr><th style='float:left;'><h4>Roll No </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
									+ "<tr><th style='float:left;'><h4>Medium </h4></th><td style='color:green;'><h4>English</h4></td></tr>"
									+ "<tr><th style='float:left;'><h4>Name </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
									+ "<tr><th style='float:left;'><h4>Fathers name </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
									+ "<tr><th style='float:left;'><h4>Address </h4></th><td style='color:green;'><h4>xxxxxxxxxx</h4></td></tr>"
									+ "</tr></thead>"
									+ "</table>" */
									+ "<div class='col-md-9'>"
									+ "<table class='table-bordered table-striped' style='width:100%'>"
									+ "<tbody>"
									+ "<tr><td>Roll No</td><td><p style='color:green;margin-top:5px;'>"+response.id+"</p></td></tr>"
									+ "<tr><td>Medium</td><td><p style='color:green;margin-top:5px;'>"+response.medium+"</p></td></tr>"
									+ "<tr><td>Student Name</td><td><p style='color:green;margin-top:5px;'>"+response.name+"</p></td></tr>"
									+ "<tr><td>Father's  Name</td><td><p style='color:green;margin-top:5px;'>"+response.fatherName+"</p></td></tr>"
									+ "</tbody>"
									+ "</table>"
									+ "</div>"
									+ "</div>"
									+ "<div class='col-md-3'>"
									+ "<img style='height:121px;' src='img/default.png' alt='Image' title='Student'>"
									+ "<div class='sign' style='background:#fff; boder='1px solid #000;'>"
									+ "</div>"
									+ "</div>"
									+ "<div class='clearfix'></div>"
									+ "<div style='margin-top:30px;' class='sub'>"
									+ "<table style='font-size: 13px;' align='center' class='table table-stripped table-bordered table-condensed'>"
									+ "<thead>"
									+ "<tr><th><b>Date</b></th><th>03/sep</th><th>03/sep</th><th>03/sep</th><th>03/sep</th><th>03/sep</th><th>03/sep</th></tr>"
									+ "</thead>"
									+ "<tbody>"
									+ "<tr><td><b>Subjects</b></td><td><p style='color:green;margin-top:5px;'>"+response.id+"</p></td>"
									+ "<td><p style='color:green;margin-top:5px;'>"+response.id+"</p></td>"
									+ "<td><p style='color:green;margin-top:5px;'>"+response.id+"</p></td>"
									+ "<td><p style='color:green;margin-top:5px;'>"+response.id+"</p></td>"
									+ "<td><p style='color:green;margin-top:5px;'>"+response.id+"</p></td>"
									+ "<td><p style='color:green;margin-top:5px;'>"+response.id+"</p></td></tr>"
									+ "<tr><td>Invigilator</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>"
									+ "</tbody>"
									+ "</table>"
									+ "</div>"
									+ '<br>'
									+ '<br>'
									+  "<input id='printbtn' style='' class='btn btn-default' type='button' value='Print' onclick=PrintElem('#printTab') />"
									$('#printTab').html(tableHead); 
								
							
							//});
							
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
	    mywindow.document.write('<html><head><title>HallTikect</title> <style>@media all {.page-break	{ display: none; }}@media print {.page-break	{ display: block; page-break-before: always; }} td, th {padding: 0;}</style><link rel="stylesheet" type="text/css" href="../assets/css/img.css"><link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"></head><body>');
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

	 function searchStudetnFee() {
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

	}
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
