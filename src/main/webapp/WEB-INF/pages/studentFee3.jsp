<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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
														<form:input path="feeType" class="form-control" tabindex="6" placeholder="Enter Fee Amount" required="true"/>
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
													<input type="submit" class="btn btn-success" tabindex="8"/>
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
						
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="blog">
									<div id="editor"></div>
									<button class="btn btn-primary" id="pdfDownload">Download Students Fee List</button>
										<div id="tableId">
											<table id="itemContainer1" class="table table-bordered table-condensed no-margin">
											<thead>
									          <tr>
						                        <th>Student</th>
						                         <th>Father Name</th>
						                          <th>Mobile</th>
						                        <th>Class</th>
						                        <th>Board</th>
						                        <th>Medium</th>
						                        <th>Section</th>
						                        <th>Paid Fee</th>
						                        <th>Fee Date</th>
						                        <th>Fee Type</th>
									          </tr>
									        </thead>
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
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Paid Fee</th>
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Due Fee</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Fee Type</th>
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
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
			$("#basicExample tr td").remove();
			$("#basicExample td").remove();
			$("#itemContainer1 tr td").remove();
			$("#itemContainer1 td").remove();
			serviceUnitArray = {};
			$.each(listOrders,function(i, orderObj) {
								if(orderObj.dueFee==0.00){
									orderObj.dueFee =orderObj.netFee;
								}
								
// 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
								serviceUnitArray[orderObj.id] = orderObj;
								var id = '"' + orderObj.id + '"';
								var tblRow = "<tr align='center' role='row' class='odd'>" 
										+ "<td>"
										+ '<a href="javascript:void(0)" onclick=popupOpen('
										+ orderObj.id + ')'
										+ '  ><b>'+ orderObj.studentName+  '</b></a>' + '</td>'
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
										+ "<td title='"+orderObj.fee+"' >"
										+ orderObj.fee
										+ "</td>"
										+ "<td title='"+orderObj.dueFee+"' >"
										+ orderObj.dueFee
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.feeType+"'>"
										+ orderObj.feeType
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.feeDate+"' >"
										+ orderObj.feeDate
										+ "</td>"
										+ "<td align='center'>"
										+ '<a href="javascript:void(0)" onclick=editPack('
										+ orderObj.id + ')'
										+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '</td>'
										+ '</tr>';
								$(tblRow).appendTo("#basicExample");
								
								//* for download PDF option
								var tblRow1 = "<tr align='center' role='row' class='odd'>" 
									+ "<td>"
									+  orderObj.studentName+   '</td>'
									+ "<td class='hidden-sm hidden-xs' >"
									+ orderObj.fatherName
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' >"
									+ orderObj.mobile
									+ "</td>"
									+ "<td title='"+orderObj.className+"'>"
									+ orderObj.className
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"'>"
									+ orderObj.boardName
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"'>"
									+ orderObj.mediumName
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.sectionName+"'>"
									+ orderObj.sectionName
									+ "</td>"
									+ "<td title='"+orderObj.fee+"' >"
									+ orderObj.fee
									+ "</td>"
									+ "<td >"
									+ orderObj.dueFee
									+ "</td>"
									+ "<td title='"+orderObj.feeType+"' >"
									+ orderObj.feeType
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.feeDate+"'>"
									+ orderObj.feeDate
									+ "</td>"
									
									+ '</tr>';
							$(tblRow1).appendTo("#itemContainer1");
							// for download PDF option */
							
							});
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
    $('#dial').text("");
	var studentFeeId = id;

	$.ajax({
				type : "POST",
				url : "getPrintFee.json",
				data : "studentFeeId=" + studentFeeId,
				dataType : "json",
					success : function(response) {
// 						alert(response);
						var  popuptitle=null;
						$.each(response, function(i, tests) {		
						
								 var stockInformation1 ="<table class='table table-stripped table-bordered table-condensed' id='stockInformationTable' border='1' style='border: 2px solid blue;border-color: blue;width: 100%;'>" 
						
									 		+"<caption><h3 style='color: black;float: left;'>Akshara Vidyaniketan</h3> <span style='float: right;font-size: normal;color: blue;'>Date: "+tests.created_time+"</span></caption>"
								 			+"<tr><th>S.no</th><th>Fee Particulars</th><th>Amount</th></tr>"
								 			+"<tr><td>1</td><td><b>Student Name: </b>&nbsp;&nbsp;"+tests.studentName+"</td><td></td></tr>"
								 			+"<tr><td>1</td><td><b>Student Name: </b>&nbsp;&nbsp;"+tests.fatssherName+"</td><td></td></tr>"
									 		+"<tr><td></td><td><b>Board: </b>&nbsp;&nbsp;"+tests.boardName+"</td><td></td></tr>"
									 		+"<tr><td></td><td><b>Medium: </b>&nbsp;&nbsp;"+tests.medium+"</td><td></td></tr>"
									 		+"<tr><td></td><td><b>Class: </b>&nbsp;&nbsp;"+tests.className+"</td><td></td></tr>"
									 		+"<tr><td></td><td><b>Section: </b>&nbsp;&nbsp;"+tests.sectionName+"</td><td></td></tr>"
// 									 		+"<tr><td></td><td align='right'>School Fee</td><td align='center'>"+tests.fee+"/-</td></tr>"
								 			+"<tr><td></td><td align='right'>Amount Paid</td><td align='center'>"+tests.fee+"/-</td></tr>"
								 			+"<tr><td colspan='2' align='right'><br><b>Total Amount:</b></td><td align='center'><br>"+tests.fee+"/-</td></tr>"
									 		+"</table>"
									 		+"<input class='btn btn-default' type='button' value='Print' onclick=PrintElem('#dial') />"
									 		
									$(stockInformation1).appendTo("#dial");
								
						});
// 							 $(stockInformation2).appendTo("#stockInformationTable"); 
							 $('#dial').dialog({width:799,title:popuptitle,modal: true}).dialog('open');
					 
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			}); 
    }
    function PrintElem(elem)
    {
        Popup($(elem).html());
    }

    function Popup(data)
    {
        var mywindow = window.open('', 'new div', 'height=400,width=600');
        mywindow.document.write('<html><head><title>Fees Receipt</title>');
        /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="css/main.css" type="text/css" />');
        mywindow.document.write('</head><body >');
        mywindow.document.write(data);
        mywindow.document.write('</body></html>');
        mywindow.print();
        mywindow.close();
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
               doc.cell(1, 1, 84, 50, cell, i);  // 2nd parameter=top margin,1st=left margin 3rd=row cell width 4th=Row height
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
				 alert(response);  
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
</script>
