
<%@ include file="parentHeader.jsp"%>
<link href="css/datepicker1.css" rel="stylesheet">

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<style type="text/css">
.divopen {
	max-height: inherit !important;
}
</style>

<div class="dashboard-wrapper">

	<!-- Top Bar starts -->
	<div class="top-bar">
		<div class="page-title">View Notification</div>
	</div>
	<!-- Top Bar ends -->

	<!-- Main Container starts -->
	<div class="main-container">

		<!-- Container fluid Starts -->
		<div class="container-fluid">
         <ol class="breadcrumb">
    	<li><a href="parentDashboard">Home</a></li>
    	<li><a href="#">View Notifications</a></li>
     	</ol>
			<!-- Spacer starts -->
			<div class="spacer">
				<!-- Row Starts -->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="panel panel-info">
					<div class="panel-heading">
						<h4>View Notifiaction</h4>
					</div>
					<div class="panel-body collapse in">
								<form:form commandName="packCmd" method="post"
									class="form-horizontal" id="student-form">
									<div class="row">
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">Student:</label>
												<div class="col-sm-5">
													<form:select path="name" class="form-control" tabindex="5"
														onchange="searchStudent();" required="true">
														<form:option value="0">-- Choose Student--</form:option>
														<form:options items="${students}"></form:options>
													</form:select>
													<span class="name_error" id="name_error"></span>
												</div>
											</div>
										</div>

										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">From
													(date) </label>
												<div class="col-sm-5">
													<input data-format="dd-MM-yyyy"
														placeholder="Enter from Date" class="form-control"
														id="dob1" type="text" tabindex="6"> <span
														class="dob1_error" id="dob1_error"></span>
												</div>
											</div>
										</div>
										<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-4 control-label">To
													(date) </label>
												<div class="col-sm-5">
													<input data-format="dd-MM-yyyy" placeholder="Enter to Date"
														class="form-control" id="dob2" type="text" tabindex="6">
													<span class="dob2_error" id="dob2_error"></span>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-8 col-sm-offset-4">
											<form:hidden path="id" />
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-2">
													<input type="button" class="btn btn-success" value="Search"
														onclick="searchStudent()" tabindex="8" />
													<!-- 														<input type="reset" class="btn btn-danger" id="cancel" tabindex="9"/> -->
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
				<div class="row gutter">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="panel panel-info">
					<div class="panel-heading">
							<h4>
									Students Notification List &nbsp;&nbsp;
									<button type="button" id="delbtn"
										onclick="multipledeleteStudent()"
										style="display: none; border: none;">
										<i class="fa fa-trash" style="color: red;"></i>
									</button>
								</h4>
					</div>
					<div class="panel-body collapse in">
								<div class="table-responsive systemView">
									<div id="basicExample_wrapper"
										class="dataTables_wrapper form-inline dt-bootstrap">
										<div class="row">
											<div class="col-sm-12">
												<table id="basicExample"
													class="table table-striped table-condensed table-bordered no-margin dataTable"
													role="grid" aria-describedby="basicExample_info">
													<thead>
														<tr role="row">
															<th class="sorting_asc" tabindex="0"
																aria-controls="basicExample" rowspan="1" colspan="1"
																aria-sort="ascending"
																aria-label="Name: activate to sort column descending">Student</th>
															<th class="sorting hidden-sm hidden-xs" tabindex="0"
																aria-controls="basicExample" rowspan="1" colspan="1"
																aria-label="Position: activate to sort column ascending">Board</th>
															<th class="sorting hidden-sm hidden-xs" tabindex="0"
																aria-controls="basicExample" rowspan="1" colspan="1"
																aria-label="Position: activate to sort column ascending">Class</th>
															<th class="sorting hidden-sm hidden-xs" tabindex="0"
																aria-controls="basicExample" rowspan="1" colspan="1"
																aria-label="Office: activate to sort column ascending">Section</th>
															<th class="sorting" tabindex="0"
																aria-controls="basicExample" rowspan="1" colspan="1"
																aria-label="Age: activate to sort column ascending">Message</th>
															<th class="sorting" tabindex="0"
																aria-controls="basicExample" rowspan="1" colspan="1"
																aria-label="Start date: activate to sort column ascending">Notification
																on</th>
														</tr>
													</thead>
													<tbody>

													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div class="mobileView" id="mobileViewNotification"></div>
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

</div>
<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->

<script type="text/javascript">
	function getOpen(id) {
		if ($('#div_' + id).hasClass('active')) {
			$('#div_' + id).removeClass('active');
			$('#div_' + id).next('div').removeClass('divopen');
		} else {
			$('.accordion').removeClass('active');
			$('.accordion').next('div').removeClass('divopen');
			$('#div_' + id).addClass('active');
			$('#div_' + id).next('div').addClass('divopen');
		}
	}

	$(function() {
		$('#div_0').addClass('active');
		$('#div_0').next('div').addClass('divopen');
	});

	$(function() {
		$("#dob1").datepicker({
			changeDate : true,
			changeMonth : true,
			changeYear : true,
			yearRange : "-17:+0",
			showButtonPanel : false,
			// 		minDate: '-50Y',
			maxDate : '0',
			dateFormat : 'dd-MM-yy'
		});
		$("#dob2").datepicker({
			changeDate : true,
			changeMonth : true,
			changeYear : true,
			yearRange : "-17:+0",
			showButtonPanel : false,
			// 		minDate: '-50Y',
			maxDate : '0',
			dateFormat : 'dd-MM-yy'
		});

	});

	var listOrders1 = $
	{
		allOrders1
	};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}

	function displayTable(listOrders) {
		$("#basicExample tr td").remove();
		$("#basicExample td").remove();
		$("#mobileViewNotification").text('');
		serviceUnitArray = {};
		$
				.each(
						listOrders,
						function(i, orderObj) {

							serviceUnitArray[orderObj.studentId] = orderObj;
							var id = '"' + orderObj.studentId + '"';
							var tblRow = "<tr align='center' role='row' class='odd'>"
									+ "<td title='"+orderObj.studentName+"'>"
									+ orderObj.studentName
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs title='"+orderObj.boardName+"' >"
									+ orderObj.boardName
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs title='"+orderObj.className+"'>"
									+ orderObj.className
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs title='"+orderObj.sectionName+"'>"
									+ orderObj.sectionName
									+ "</td>"
									+ "<td title='"+orderObj.message+"'>"
									+ orderObj.message
									+ "</td>"
									+ "<td title='"+orderObj.absentDate+"'>"
									+ orderObj.absentDate + "</td>" + '</tr>';
							$(tblRow).appendTo("#basicExample");

							var mobileview = '<button type="button" style="padding: 5px;font-size: 15px;" class="accordion" id="div_'
									+ i
									+ '" onclick="getOpen('
									+ i
									+ ')">'
									+ orderObj.absentDate
									+ '</button>'
									+ '	<div class="panel" style="margin-bottom: 1px;margin-top: 3px;">'
									+ '	  <p id="notifyMessage">'
									+ orderObj.message + '</p>' + '	</div>';
							$(mobileview).appendTo("#mobileViewNotification");

							//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
						});
	}

	function searchStudent() {
		var id = $("#name").val();
		var dob1 = $("#dob1").val();
		var dob2 = $("#dob2").val();
		$.ajax({
			type : "POST",
			url : "filterEvent.json",
			data : "dob1=" + dob1 + "&dob2=" + dob2 + "&id=" + id,
			success : function(response) {
				// 				 alert(response); 
				displayTable(response);
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
<%@ include file="parentFooter.jsp"%>