
<%@ include file="parentHeader.jsp" %>

	
		<!-- Dashboard Wrapper starts -->
		<div class="dashboard-wrapper">

			<!-- Top Bar starts -->
			<div class="top-bar">
				<div class="page-title">View Student Details</div>
			</div>
			<!-- Top Bar ends -->

			<!-- Main Container starts -->
			<div class="main-container">

				<!-- Container fluid Starts -->
				<div class="container-fluid">

					<!-- Spacer starts -->
					<ol class="breadcrumb">
    	<li><a href="parentDashboard">Home</a></li>
    	<li><a href="#">View Student Details</a></li>
     	</ol>
						
						<!-- Row Starts -->
						<div class="row">

							<div id="showData" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<input type ="hidden" value="${baseUrl }" id="baseUrl1">
							</div>

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="view_list1">
							   <div class="panel panel-info">
					            <div class="panel-heading">
						          <h4>List of View Student Details</h4>
					            </div>
					             <div class="panel-body collapse in">
										<div class="table-responsive">
											<div id="basicExample_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
												<div class="row">
													<div class="col-sm-12">
 														<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">
															<thead>
																<tr role="row">
																	<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Name</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Image</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Roll No.</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>
																	<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Father</th>
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
<input type ="hidden" value="${baseUrl }" id="baseUrl1">
		</div>
		<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

var serviceUnitArray = {};
var baseUrl2 =$("#baseUrl1").val();


	 var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}

 	function displayTable(listOrders) {
			$("#basicExample tr td").remove();
			$("#basicExample td").remove();
			serviceUnitArray = {};
			$
					.each(
							listOrders,
							function(i, orderObj) {
								
								if(orderObj.imagePath == null){
									orderObj.imagePath="img/default.png"
								}
// 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
								serviceUnitArray[orderObj.studentId] = orderObj;
								var id = '"' + orderObj.studentId + '"';
								var tblRow = "<tr  role='row' class='odd'>" + "<td'><a id='"
										+ orderObj.studentId
										+ "' href='javascript:forOrderDetails("
										+ orderObj.studentId
										+ ")' style='font-color:red'>"
										+ orderObj.studentId
										+ "</a></td>"
										+ "<td title='"+orderObj.studentName+"'>"
										+ orderObj.studentName
										+ "</td>"
										+ "<td  class='hidden-sm hidden-xs'><img style='width: 65px;height: 65px;' src='"+baseUrl2+"/"+orderObj.imagePath+"'/>"
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.rollNum+"'>"
										+ orderObj.rollNum
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"' >"
										+ orderObj.boardName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"'>"
										+ orderObj.mediumName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.fatherName+"' >"
										+ orderObj.fatherName
										+ "</td>"
										+ "<td align='center'>"
										+ '<a onclick=getApplicant('+orderObj.studentId+')>'
										+ '<i style="cursor: pointer;color: blue;" class="fa fa-file-text"></i></a>' 
										+ '</td>'
										+ '</tr>';
								$(tblRow).appendTo("#basicExample");
								
								//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
							});
	}  
 	
	
/* 	function mediumFilter(id){
		var mediumId = $("#medium").val();
		$.ajax({
			type : "POST",
			url : "getMedium.json",
			data : "mediumId=" + mediumId,
			dataType : "json",
			success : function(response) {
				 alert(response);  
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
	} */
	


function getApplicant(id)
	{
		var image = null; image = serviceUnitArray[id].imagePath;
		if(image == null || image == ""){image= 'upload/default.png';}
		
		var name = null; name = serviceUnitArray[id].studentName;
		if(name == null || name == ""){name = "---";}
//	 	alert(serviceUnitArray[id].studentName);
		
		var board = null; board = serviceUnitArray[id].boardName;
		if(board == null || board == ""){board = "---";}
		
		var medium = null; medium = serviceUnitArray[id].mediumName;
		if(medium == null || medium == ""){medium = "---";}
		
		var clas = null; clas = serviceUnitArray[id].className;
		if(clas == null || clas == ""){clas = "---";}
		
		var section = null; section = serviceUnitArray[id].sectionName;
		if(section == null || section == ""){section = "---";}
		
		var rno = null; rno = serviceUnitArray[id].rollNum;
		if(rno == null || rno == ""){rno = "---";}
		
		var adno = null; adno = serviceUnitArray[id].admissionNum;
		if(adno == null || adno == ""){adno = "---";}
		
		var fname = null; fname = serviceUnitArray[id].fatherName;
		if(fname == null || fname == ""){fname = "---";}
		
		var mob = null; mob = serviceUnitArray[id].mobile;
		if(mob == null || mob == ""){mob = "---";}
		
		var alt = null; alt = serviceUnitArray[id].alternativeMobile;
		if(alt == null || alt == ""){alt = "---";}
		
		var email = null; email = serviceUnitArray[id].email;
		if(email == null || email == ""){email = "---";}
		
		var bg = null; bg = serviceUnitArray[id].blodgroup;
		if(bg == null || bg == ""){bg = "---";}
		
		var gender = null; gender = serviceUnitArray[id].gender;
		if(gender == null || gender == ""){gender = "---";}
		
	 	var dob = null; dob = serviceUnitArray[id].dob;
	 	if(dob == null || dob == ""){dob = "---";}
		
		var rel = null; rel = serviceUnitArray[id].religion;
		if(rel == null || rel == ""){rel = "---";}
		
		var add = null; add = serviceUnitArray[id].address;
		if(add == null || add == ""){add = "---";}
		
		var pre = null; pre = serviceUnitArray[id].previousInstitue;
		if(pre == null || pre == ""){pre = "---";}
		
		var caste = null; caste = serviceUnitArray[id].caste;
		if(caste == null || caste == ""){caste = "---";}
		
		var acc = null; acc = serviceUnitArray[id].acomitation;
		if(acc == null || acc == ""){acc = "---";}
		
		var bus = null; bus = serviceUnitArray[id].buspesility;
		if(bus == null || bus == ""){bus = "---";}
		
		var busrt = null; busrt = serviceUnitArray[id].busroute;
		if(busrt == null || busrt == ""){busrt = "---";}
		
		var tblRow = "<div class='table-responsive'><table class='table table-condensed' style='width: 50%;'>"
				+"<tr>"
				+	"<td colspan='2' style='border: none;'>"
				+		"<a style='cursor: pointer;' onclick='getBack()'><i class='fa fa-2x fa-times'></i></a>"
				+	"</td>"
				+ 	"<td style='border: none;'>"
				+ 		"<img style='width: 100px;height: 120px;' src='"+image+"'/>"
				+ 	"</td>"
				+"</tr>"
				
				+ "<tr>"
				+ 	"<td style='border: none;font-weight: bold;'>Name</td>"
				+ 	"<td style='border: none;'>:</td>"
				+ 	"<td style='border: none;'>"+name+"</td>"
				+ "</tr>"
				
				+ "<tr><td style='font-weight: bold;'>Type of Board</td><td>:</td><td style=''>"+board+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Medium</td><td>:</td><td style=''>"+medium+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Class</td><td>:</td><td style=''>"+clas+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Section</td><td>:</td><td style=''>"+section+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Roll No</td><td>:</td><td style=''>"+rno+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Admission No</td><td>:</td><td style=''>"+adno+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Fatder Name</td><td>:</td><td style=''>"+fname+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Mobile No</td><td>:</td><td style=''>"+mob+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Alternative No</td><td>:</td><td style=''>"+alt+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Email</td><td>:</td><td style=''>"+email+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Blood Group</td><td>:</td><td style=''>"+bg+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Gender</td><td>:</td><td style=''>"+gender+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Date Of Birtd</td><td>:</td><td style=''>"+dob+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Religion</td><td>:</td><td style=''>"+rel+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Address</td><td>:</td><td style=''>"+add+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Previous Institute</td><td>:</td><td style=''>"+pre+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Caste</td><td>:</td><td style=''>"+caste+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Accommodation</td><td>:</td><td style=''>"+acc+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Bus facility</td><td>:</td><td style=''>"+bus+"</td></tr>"
				
				+ "<tr><td style='font-weight: bold;'>Bus Route</td><td>:</td><td style=''>"+busrt+"</td></tr>"
				
				+"</table></div>"; 
		$(tblRow).appendTo("#showData");
		$('#view_list1').hide();
}

function getBack()
{
	$('#showData').html('');
	$('#view_list1').show();
}

</script>
<%@ include file="parentFooter.jsp" %>