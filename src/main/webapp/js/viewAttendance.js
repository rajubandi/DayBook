
$(function() {

	$("#dob1").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-17:+0",
		showButtonPanel : false,
// 		minDate: '-50Y',
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});
	$("#dob2").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-17:+0",
		showButtonPanel : false,
// 		minDate: '-50Y',
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});
	
	/*$("#cancel").click(function () {
		$('#name').val("");
		$('#boardName').val("");
		$('#className').val("");
		$('#section').val("");
		$('#medium').val("");
		$('#dob1').val("");
		$('#dob2').val("");
	});*/
	
});

	function displayTable(listOrders) {
		$('#basicTable').html('');
		serviceUnitArray = {};
		var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
			+ '<thead>'
			+'<tr role="row">'
			+'<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Class</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Section</th>'
			+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Message</th>'
			+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Attendance<br>(AM | PM)</th>'
			+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Absent on</th>'
			+'</tr>'
			+'</thead>'
			+'<tbody></tbody></table>';
		$('#basicTable').html(tableHead);
		$
				.each(
						listOrders,
						function(i, orderObj) {
							
//								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
							serviceUnitArray[orderObj.studentId] = orderObj;
							var id = '"' + orderObj.studentId + '"';
							var tblRow = "<tr role='row' class='odd'>" 
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
									+ "<td align='left' title='"+orderObj.message+"'>"
									+ orderObj.message
									+ "</td>"
									+ "<td title='"+orderObj.absentSection+"'>"
									+ orderObj.absentSection
									+ "</td>"
									+ "<td title='"+orderObj.absentDate+"'>"
									+ orderObj.absentDate
									+ "</td>"
									+ '</tr>';
							$(tblRow).appendTo("#basicExample tbody");
							
							//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
						});
//$('#basicExample').dataTable();
}  
	

function searchStudent(){
	var studentName = $("#name").val();
	var boardName = $("#boardName").val();
	var className = $('#className').val();
	var section = $('#section').val();
	var name = $('#name').val();
	var medium =$("#medium").val();
	var dob1 =$("#dob1").val();
	var dob2 =$("#dob2").val();
	$.ajax({
		type : "POST",
		url : "filterAttendance.json",
		data : "boardName=" + boardName+"&studentName="+studentName+"&className="+className+"&section="+section+"&name="+name+"&medium="+medium+"&dob1="+dob1+"&dob2="+dob2,
		async:false,
		success : function(response) {
//				 alert(response); 
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

function classNameFilter(id){
	var boardId = $("#boardName").val();
	if(boardId.length !=0){
	$.ajax({
		type : "POST",
		url : "getClassNameFilter.json",
		data : "boardId=" + boardId,
		dataType : "json",
		async:false,
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
		async:false,
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
		async:false,
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