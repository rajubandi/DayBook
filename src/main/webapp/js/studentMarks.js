$( document ).ready(function() {
    $("#fee").val("");

$("#cls-form").validate(
		{
			errorElement: 'span',
		    errorClass: 'has-error',
			rules:
			{
				boardId: {required: true},
			    medium: {required: true},
				classId: {required: true},
			    sectionId: {required: true},
			    studentId: {required: true},
			    examTypeId: {required: true},
			},
			messages:
			{
				boardId: {required: 'Choose Board'},
				medium: {required: 'Choose Medium'},
				classId: {required: 'Choose Class'},
				sectionId: {required: 'Choose Section'},
				studentId: {required: 'Choose Student'},
				examTypeId: {required: 'Choose Exam Type'},
			},
			errorPlacement: function(error, element)
			{
			      if(element.attr("name") == "classI")
			        error.insertAfter(".classId_error").css("color", "red");
			      else if(element.attr("name") == "boardI")
			        error.insertAfter(".boardId_error").css("color", "red"); 
			       else if(element.attr("name") == "mediu")
			        error.insertAfter(".medium_error").css("color", "red");
			       else if(element.attr("name") == "studentI")
			        error.insertAfter(".studentId_error").css("color", "red");
			      
			      else
			        error.insertAfter(element);
			}	
		});

/*if($("#cls-form").valid()== true) {
	$("#submitId").attr("disabled",true);
	$("#submitId").val("Please wait...");
	$("cls-form").submit();											
}else {
	return false;
	event.preventDefault();
}*/

			  $('#cancel').click(function () {
			    $("#cls-form").validate().resetForm();
			    $("#cls-form")[0].reset();
			    $("#cls-form").removeClass("has-error");
			    $("#boardId").val('');
			    $("#medium").val('');
			    $("#classId").val('');
			    $("#sectionId").val('');
			    $("#studentId").val('');
			    $("#examTypeId").val('');
			    $("#subjectDiv").html('');
			    
			    window.location.href='?';
			    $("#fee").val('');
			    $("#cls-form").addClass('form-horizontal');
			  });
			  
			  
			  
			  
			  
			  
			  $('#examTypeId').on('change' ,function(){
					
					$("#examPatternTableDiv").show();
					var boardId = $("#boardId").val();
					var classId = $("#classId").val();
					var sectionId = $("#sectionId").val();
					var mediumId = $("#medium").val();
					var examTypeId = $("#examTypeId").val();
					
					
					$.ajax({
						type : "POST",
						url : "examPatternList.json",
						data : "boardId=" + boardId + "&classId=" + classId+ "&sectionId=" + sectionId + "&mediumId=" + mediumId + "&examTypeId="+ examTypeId,
						dataType : "json",
						async:false,
						success : function(response) {
							dynamicInputfields(response)
							/*$.each(response, function(i, tests) {
								var id=tests.subjectId;

								var subjectName=tests.subjectName;
								var maxMarks=tests.maxMarks;
								var subjectId = tests.subjectId;
								$('#subjectDiv').append(
										'<div class="col-md-2">'
										+'<input path="subjectId" type="hidden" class="form-control" tabindex="1"	value="'+subjectId+'"/>'
										+'<label for="inputEmail3" class="col-sm-4 control-label">'+ subjectName+':' 
										+ ' </label>' 
										+'<br>'
										+'<input path="studentMarks" type="number" class="form-control" tabindex="1"	max="'+maxMarks+'" placeholder="Enter Maximum Marks"/>'
										+'<input path="subjectMaxMarks" type="hidden" class="form-control" tabindex="1"	value="'+maxMarks+'"/>'
										+'</div>');
									
								$('#subjectDiv').append();
								//optionsForClass.append(new Option(className, id));
							});
							$('#loadAjax').hide();
							//$('#subjectId').trigger("chosen:updated");
							
							
							
						*/	
						}
						});
			  });
			  
			
			  $("#checkAll").change(function () {
				  oTable.$("input:checkbox").prop('checked', $(this).prop("checked"));
					var len=$("[name='checkboxName']:checked").length;
					/*if(len!=0)
					{
						$('#delbtn').show();
					}
					else
					{
						$('#delbtn').hide();
					}*/
				});
			  
});


function dynamicInputfields(listOfSubjects){
	
	$('#subjectDiv').empty();
	$.each(listOfSubjects, function(i, tests) {

		var subjectName=tests.subjectName;
		var maxMarks=tests.maxMarks;
		var subId = tests.subjectId;
		$('#subjectDiv').append(
				'<div class="col-md-2">'
				+'<label for="inputEmail3" class="col-sm-4 control-label">'+ subjectName+':' 
				+ ' </label>' 
				+'<br>'
				+'<input id="subjectId" name="subjectId" type="hidden" class="form-control" tabindex="1"	value="'+subId+'"/>'
				+'<input id="studentMarks" name="studentMarks" type="number" class="form-control" tabindex="1" min="'+0+'"	max="'+maxMarks+'" placeholder="Enter Maximum Marks"/>'
				+'<input id="subjectMaxMarks" name="subjectMaxMarks" type="hidden" class="form-control" tabindex="1"	min="'+0+'" value="'+maxMarks+'"/>'
				+'</div>');
			
		$('#subjectDiv').append();
		//optionsForClass.append(new Option(className, id));
	});
	$('#loadAjax').hide();
	//$('#subjectId').trigger("chosen:updated");
	
}


function displayTable(listOrders) {
			$("#basicExample tr td").remove();
			$("#basicExample td").remove();
			serviceUnitArray = {};
			$.each(listOrders, function(i, orderObj) {
								serviceUnitArray[orderObj.id] = orderObj;
								var id = '"' + orderObj.id + '"';
								var tblRow = "<tr align='center' role='row' class='odd'>" + "<td'><a  id='"
										+ orderObj.id
										+ "' href='javascript:forOrderDetails("
										+ id
										+ ")' style='font-color:red'>"
										+ orderObj.id
										+ "</a></td>"
										+ "<td  title='"+orderObj.studentName+"'>"
										+ orderObj.studentName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.totalStudentMarks+"'>"
										+ orderObj.totalStudentMarks
										+ "</td>"
										+ "<td title='"+orderObj.totalSubjectMarks+"'>"
										+ orderObj.totalSubjectMarks
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.examTypeName+"' >"
										+ orderObj.examTypeName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.examTypeName+"' >"
										+ orderObj.examTypeName
										+ "/-</td>"
										+ "<td>"
										+ '<a href="javascript:void(0)" onclick=getFulMarks('
										+ orderObj.studentId + ',\"' + orderObj.examTypeId + '\",'+ null+')>'
										+ /*'  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
										+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteClass('
										+ orderObj.studentId + ')'
										+ '  ><i class="fa fa-trash-o"></i></a>' +*/ 'Progress Card</a> <input class="checkall multiplecheck" type="checkbox" name="checkboxName" id="'+orderObj.studentId +'" value="'+orderObj.examTypeId +'"/></td>'
									
										+ '</tr>';
								$(tblRow).appendTo("#basicExample");
							});
	}

function getFulMarks(studentId,examTypeName,academicYear){
	
	$.ajax({
		type : "POST",
		url : "getPogressCard.json",
		data : "studentId="+studentId+"&examTypeName="+examTypeName+"&academicYear="+academicYear,
		dataType : "json",
		success : function(response) {
			
			//console.log(response)
			//$('#progressCardModal').html('');
				$('#pogressModal').modal();
			$("#studentLowLevelMarksListTable tr td").remove();
			$("#studentLowLevelMarksListTable td").remove();
			
			$("#boardId1").text(response[0].boardName);
			$("#classId1").text(response[0].className);
			$("#sectionId1").text(response[0].sectionName);
			$("#mediumId").text(response[0].medium);
		$("#examTypeTdId").text(response[0].examTypeName);
		$("#studentNameTd").text(response[0].studentName);
		//$("#studentIdButton").val(response[0].studentId);
		$("#studentIdButton").html(response[0].studentId);
		
		var totalStudentMarks = 0;
		var totalSubjectsMarks = 0;
		
			 $.each(response,function(i, tests) {
			//console.log(tests)  
			var sno = i+1;
			totalStudentMarks += parseInt(tests.studentMarks);
			totalSubjectsMarks += parseInt(tests.subjectMaxMarks);
			var tableHead = "<tr><td>"+sno+"</p></td>"
//				+ "<td><p style='margin-top:5px;'>"+tests.id+"</p></td>"
				+ "<td><p style='margin-top:5px;'>"+tests.subjectTitle+"</p></td>"
				+ "<td><p style='margin-top:5px;'>"+tests.studentMarks+"</p></td>"
				+ "<td><p style='margin-top:5px;'>"+tests.subjectMaxMarks+"</p></td>"
				+ "<td><p style='margin-top:5px;'>pass</p></td></tr>"
				
				$(tableHead).appendTo("#studentLowLevelMarksListTable tbody");
			
		
		});
			 var totalRow = "<tr><td  colspan='2'><b>Total</b></td><td><p style='margin-top:5px;'>"+totalStudentMarks+"</p></td><td><p style='margin-top:5px;'>"+totalSubjectsMarks+"</p></td><td></td><tr>"
			 $(totalRow).appendTo("#studentLowLevelMarksListTable tbody");
		}
	});
	
	
}
function PrintElem(elem)
{
	$("#printbtn").hide();
    Popup($(elem).html());
}
function Popup(data) {
	var mywindow = window.open('','new div');

    var is_chrome = Boolean(mywindow.chrome);
    var isPrinting = false;
    mywindow.document.write('<html><head><title>Strudent Marks</title> <style>@media all {.page-break	{ display: none; }}@media print {.page-break	{ display: block; page-break-before: always; }} td, th {padding: 0;}</style><link rel="stylesheet" type="text/css" href="../assets/css/img.css"><link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"></head><body>');
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

function printAllProgressCard(){
	
	 var map = new Object();//or{}
	var selected = new Array();
	var examTypeId = new Array();
	$('#basicExample input[type="checkbox"]:checked').each(function() {
	    selected.push($(this).attr('id'));
	    examTypeId.push($(this).attr('value'));
	    map[$(this).attr('id')] = $(this).attr('value')
	});
	
	
	if(selected.length > 0){
				
				$.ajax({
					type : "POST",
					url : "getToPrintAllPogressCard.json",
					data : {studentArry:selected,examtypeId:examTypeId},
					dataType : "json",
					success : function(response) {
						
						console.log(response)
				
						/*$("#studentLowLevelMarksListTable tr td").remove();
						$("#studentLowLevelMarksListTable td").remove();*/
						
						$('#printAllProgressCardDiv').html('');
			$.each(response,function(i, tests) {	
						/*$("#boardId1").text(tests[0].boardName);
						$("#classId1").text(tests[0].className);
						$("#sectionId1").text(tests[0].sectionName);
						$("#mediumId").text(tests[0].medium);
					$("#examTypeTdId").text(tests[0].examTypeName);
					$("#studentNameTd").text(tests[0].studentName);
					//$("#studentIdButton").val(response[0].studentId);
					$("#studentIdButton").html(tests[0].studentId);*/
					
					
					var uppertableHead = ' <table id="pogressCardStudentInfoTable" class="table table-bordered smarksp" style="width:100%;">'
				   +' <tbody>'
				   +' <tr style="border:none;"><td>Board Name</td><td id="boardId1">'+tests[0].boardName+' </td>'
				   +'<td>Class</td><td id="classId1">'+tests[0].className+'</td>'
				   +'<td rowspan="3" width="25%" style="padding-top:15px;">'
				   +'<span class="pull-right"><img src="img/logo (1).png" height="50" /> Hall Ticeket No &nbsp; '
				   +'<button id="studentIdButton" style="type:default;">'+tests[0].studentId+'</button></span></td></tr>'
				   +' <tr><td>Section</td><td id="sectionId1">'+ tests[0].sectionName +'</td>'
				   +'<td >Exam Type :</td> <td id="examTypeTdId"> '+tests[0].examTypeName +'</td></tr>'
				   +' <tr><td>Medium</td><td id="mediumId">'+tests[0].medium+'</td>'
				   +'<td >Student Name</td><td id="studentNameTd">'+tests[0].studentName+'</td></tr>'
				   +' <tr></tr>'
				   +'  <tr></tr>'
				   +'  </tbody>'
				   +' </table>';
				   
				   $('#printAllProgressCardDiv').append(uppertableHead);
					var totalStudentMarks = 0;
					var totalSubjectsMarks = 0;
					
					var tableHead =  "<br>"
	         			+"<table id='studentLowLevelMarksListTable' class='table table-bordered table-striped'>"
	         			+"<thead><tr><th>S.No</th><th>Subject Title</th><th>Marks</th><th>Total Marks</th><th>Result</th></tr></thead>"
	         			+" <tbody></tbody>"
	         			+"</table>";
					 $('#printAllProgressCardDiv').append(tableHead);
					 
					 $("#studentLowLevelMarksListTable tbody tr").remove(); 
						 $.each(tests,function(i, eachSubject) {
						//console.log(tests)  
						var sno = i+1;
						totalStudentMarks += parseInt(eachSubject.studentMarks);
						totalSubjectsMarks += parseInt(eachSubject.subjectMaxMarks);
						var tableBody = "<tr><td>"+sno+"</p></td>"
//							+ "<td><p style='margin-top:5px;'>"+tests.id+"</p></td>"
							+ "<td><p style='margin-top:5px;'>"+eachSubject.subjectTitle+"</p></td>"
							+ "<td><p style='margin-top:5px;'>"+eachSubject.studentMarks+"</p></td>"
							+ "<td><p style='margin-top:5px;'>"+eachSubject.subjectMaxMarks+"</p></td>"
							+ "<td><p style='margin-top:5px;'>pass</p></td></tr>"
							
							$(tableBody).appendTo("#studentLowLevelMarksListTable tbody");
						 });
					
						 var totalRow = "<tr><td  colspan='2'><b>Total</b></td><td><p style='margin-top:5px;'>"+totalStudentMarks+"</p></td><td><p style='margin-top:5px;'>"+totalSubjectsMarks+"</p></td><td></td><tr>"
						 $(totalRow).appendTo("#studentLowLevelMarksListTable tbody");
						
						 $('#printAllProgressCardDiv').append(" <div class='page-break'></div>");
						
					});
						 Popup($('#printAllProgressCardDiv').html());
					}
				});
				
				
			
		/*$.ajax({
			type : "POST",
			url : "printAllProgressCard",
			data : {studentArry:selected,examtypeId:examTypeId},
			dataType : "json",
			success : function(response) {
				
				console.log(response)
				
				//$('#myModal').modal();
				 hallticketDesign(response);
				 
				//$("#printbtn").click();
				 
			}
		
			});*/
	}else{
		
		alert("please select Student(s)");
	}
	
	
}


  function smsStudentMarks(){
	  var map = new Object();//or{}
	var selected = new Array();
	var selected1 = new Array();
	$('#basicExample input[type="checkbox"]:checked').each(function() {
	    selected.push($(this).attr('id'));
	    selected1.push($(this).attr('value'));
	    map[$(this).attr('id')] = $(this).attr('value');
	    
	});
	 //{studentArry:selected}
	console.log(JSON.stringify(map));
	if(selected.length > 0){
		$.ajax({
			type : "POST",
			url : "smsStudentMarks",
			data :{studentArry:selected,examtypeId:selected1},
			dataType : "json",
			success : function(response) {
				
				console.log(response)
				
				//$('#myModal').modal();
				 hallticketDesign(response);
				 
				//$("#printbtn").click();
				 
			}
		
			});
	}else{
		
		alert("please select Student(s)");
	}
	
	
}

	function editPack(id) {
		var transactionId = serviceUnitArray[id].classId;
		$("#id").val(serviceUnitArray[id].classId)
		$('#boardId').val(serviceUnitArray[id].borderId);
		$('#boardId').trigger("chosen:updated");
		$('#className').val(serviceUnitArray[id].className);
		$('#className').trigger("chosen:updated");
		$('#mediumId').val(serviceUnitArray[id].mediamId);
		$('#mediumId').trigger("chosen:updated");
		$('#section').val(serviceUnitArray[id].section);
		$('#section').trigger("chosen:updated");
		$('#fee').val(serviceUnitArray[id].fee);
		$("#submitId").val("Update");
		$("#headId").text("Edit Class");
	}
	
	
	function deleteClass(id){
		var classId = id;
		var count = 0;
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		  // do your code
//			$('#loadAjax').show();
		  
		  $.ajax({
					type : "POST",
					url : "deleteClass.json",
					data : "classId=" + classId ,
					success : function(response) {
						displayTable(response);
//						$('#loadAjax').hide();
						window.location.href='HomeControl1';
					},
					error : function(e) {
//						$('#loadAjax').hide();
					}
				});
		
		/* 	$.ajax({
				type : "POST",
				url : "deleteClass.htm",
				data : "classId=" + classId ,
				dataType : "json",
				success : function(response) {
					alert(response);
					if (response != "") {
						displayTable(response);
					}
				
				},
				error : function(e) {
				}
			}); */
			
		}else{
		return false;
		}
	}
	
	
	function classNameFilter(id){
		var boardId = $("#boardId").val();
		if(boardId.length !=0){
			$('#loadAjax').show();
		$.ajax({
			type : "POST",
			url : "getClassNameFilter1.json",
			data : "boardId=" + boardId,
			dataType : "json",
			async:false,
			success : function(response) {
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#classId").empty();
				optionsForClass.append(new Option("-- Choose Class --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var className=tests.className;
					optionsForClass.append(new Option(className, id));
				});
				$('#loadAjax').hide();
				$('#classId').trigger("chosen:updated");
			},
			error : function(e) {
				$('#loadAjax').hide();
			},
			statusCode : {
				406 : function() {
					$('#loadAjax').hide();
			
				}
			}
		});
		$('#loadAjax').hide();

		}
	} 
	function sectionFilter() {
		var boardId = $("#boardId").val();
		var classId = $("#classId").val();
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
					optionsForClass = $("#sectionId").empty();
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
		var boardId = $("#boardId").val();
		var classId = $("#classId").val();
		var sectionId = $("#sectionId").val();
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
		var boardId = $("#boardId").val();
		var classId = $("#classId").val();
		var sectionId = $("#sectionId").val();
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
	
	function getSubjects(){
		var boardId = $("#boardId").val();
		var classId = $("#classId").val();
		if(boardId.length !=0 && classId.length != 0){
			//$('#loadAjax').show();
		$.ajax({
			type : "POST",
			url : "getSubjectFilter.json",
			data : "boardId="+boardId+"&classId="+classId,
			dataType : "json",
			async:false,
			success : function(response) {
				console.log(response);
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#subjectId").empty();
				//optionsForClass.append(new Option("-- Choose Subject --", ""));
				$.each(response, function(i, tests) {
					var id=tests.subjectId;

					var subjectName=tests.subjectName;
					$('#subjectDiv').append(
							'<div class="col-md-2">'
							+'<label for="inputEmail3" class="col-sm-4 control-label">'+ subjectName+':' 
							+ ' </label>' 
							/*+'<br>'*/
							+'<input path=" '+ id+'" type="number" class="form-control" tabindex="1"	placeholder="Enter Maximum Marks"/>'
							+'</div>');
						
					$('#subjectDiv').append();
					//optionsForClass.append(new Option(className, id));
				});
				$('#loadAjax').hide();
				$('#subjectId').trigger("chosen:updated");
			},
			error : function(e) {
				$('#loadAjax').hide();
			},
			statusCode : {
				406 : function() {
					$('#loadAjax').hide();
			
				}
			}
		});
		//$('#loadAjax').hide();

		
	}
	}
	 function searchStudetnMarks() {
			var studentId = $('#studentId').val();
			var classId = $('#classId').val();
			var boardId = $('#boardId').val();
			var sectionId = $('#sectionId').val();
			var mediumId = $('#medium').val();
			var examTypeId = $('#examTypeId').val();
			
			$.ajax({
				type : "POST",
				url : "searchStudetnMarks.json",
				data : "studentId=" + studentId + "&classId=" + classId
						+ "&sectionId=" + sectionId + "&mediumId=" + mediumId
						+ "&boardId=" + boardId+"&examTypeId="+examTypeId,
				dataType : "json",
				success : function(response) {
					// 				 alert(response);  
					displayTable(response);
					
					if(isClick == 'Yes'){
						
						
						 oTable =  $('#basicExample,#dayWiseExpenses,#basicExampleDFC').dataTable( {
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
					                footer: true,
					                columns: "thead th:not(.noExport)"
					            },
					            {
					            	 extend: 'pdfHtml5',
						                orientation: 'landscape',
						                pageSize: 'LEGAL',
						                	footer: true,
						                	 columns: "thead th:not(.noExport)"
					            },
					            {
					                extend: 'print',
					                footer: true,
					                columns: "thead th:not(.noExport)"
					               
					            }
					        ]
					    
					    } );
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
	
	/*function searchStudent(){
		searchbtn=123;
		var studentName = $("#name").val();
		var boardName = $("#boardName").val();
		var admissionNum = $('#admissionNum').val();
		var medium = $('#medium').val();
		var caste = $('#caste').val();
		var email = $('#email').val();
		var studentName = $('#name').val();
		var className = $('#className').val();
		var section = $('#section').val();
		var mobile = $("#mobile").val();
		$('#loadAjax').show();
		$.ajax({
			type : "POST",
			url : "getStudetnDetails.json",
			dataType : "json",
			data : "boardName=" + boardName+"&admissionNum="+admissionNum +"&rollNum="+rollNum +"&medium="+medium+"&caste="+caste+"&email="+email+"&studentName="+studentName+"&className="+className+"&section="+section+"&mobile="+mobile+"&studentName="+studentName,
			success : function(response) {
// 				 alert(response); 
				 displayTable(response);
				 $('#loadAjax').hide();
			},
			error : function(e) {
				$('#loadAjax').hide();
			},
			statusCode : {
				406 : function() {
					$('#loadAjax').hide();
			
				}
			}
		});
		$('#loadAjax').hide();
	}
	*/