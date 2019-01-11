
$(function() {
	$("#dob1").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-50:+0",
		showButtonPanel : false,
// 		minDate: '-50Y',
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});
	$("#dob2").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-50:+0",
		showButtonPanel : false,
// 		minDate: '-50Y',
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});

});
 


function searchStudent(){

var dob1 =$("#dob1").val();
var dob2 =$("#dob2").val();
var id =$("#name").val();
$.ajax({
	type : "POST",
	url : "filterAttendance.json",
	data : "dob1="+dob1+"&dob2="+dob2+"&id="+id,
	success : function(response) {
//			 alert(response); 
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