 $( document ).ready(function() {
	 
	 
	 $("#schedule-form").validate(
				{
					errorElement: 'span',
				    errorClass: 'has-error',
					rules:
					{
						boardId: {required: true},
						medium: {required: true},
					    classId: {required: true},
					    sectionId: {required: true},
					    examTypeId: {required: true},
					},
					messages:
					{
						boardId: {required: 'Choose Board'},
						medium: {required: 'Choose Medium'},
						classId: {required: 'Choose Class'},
						sectionId: {required: 'Choose Section'},
						examTypeId: {required: 'Choose Exam Type'},
					},
					errorPlacement: function(error, element)
					{
					      if(element.attr("name") == "classId1")
					        error.insertAfter(".classId_error").css("color", "red");
					      else if(element.attr("name") == "boardId1")
					        error.insertAfter(".boardId_error").css("color", "red"); 
					       else if(element.attr("name") == "medium1")
					        error.insertAfter(".medium_error").css("color", "red");
					       else if(element.attr("name") == "sectionId1")
					        error.insertAfter(".sectionId_error").css("color", "red");
					       else if(element.attr("name") == "fee")
						        error.insertAfter(".examTypeId_error").css("color", "red");
					      else
					        error.insertAfter(element);
					}	
				});
	 
		$(".datepick").datepicker({
			changeDate : true,
			changeMonth : true,
			changeYear : true,
			//yearRange: "-50:+0",
			showButtonPanel : true,
	 		minDate: '0',
		   // maxDate: '0', 
			dateFormat : 'dd-MM-yy'
		});
		
		
		$("input[name='fromTime'],input[name='toTime'],#fromTime,#toTime").datetimepicker({
			
			 format: 'LT'
		});
	 
	 $('#cancel').click(function () {
		    $("#schedule-form").validate().resetForm();
		    $("#schedule-form").removeClass("has-error");
		    $("#boardId").val('');
		    $("#medium").val('');
		    $("#classId").val('');
		    $("#sectionId").val('');
		    $("#examTypeId").val('');
		    $('#subjectDiv').text('');
		    $("#schedule-form").addClass('form-horizontal');
		  });
	 
	// $('#examTypeId').on('change' ,function(){
		 $("#getSubjects").click(function(){
			 
			 if( $("#schedule-form").valid()== true){
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
						dynamicInputfields(response);
						 $("#createSchedule").show();
						 
						 if(isClick=="Yes"){
								$(".datepick").datepicker({
									changeDate : true,
									changeMonth : true,
									changeYear : true,
									//yearRange: "-50:+0",
									showButtonPanel : true,
							 		minDate: '0',
								   // maxDate: '0', 
									dateFormat : 'dd-MM-yy'
								});
								
								
								$("input[name='fromTime'],input[name='toTime'],#fromTime,#toTime").datetimepicker({
									
									 format: 'LT'
								});
								
							}	
					}
					});
			 }
	  });
		 
		 $("#getSchedule").click(function(){	
			 
			 if( $("#schedule-form").valid()== true){
				var boardId = $("#boardId").val();
				var classId = $("#classId").val();
				var sectionId = $("#sectionId").val();
				var mediumId = $("#medium").val();
				var examTypeId = $("#examTypeId").val();
				
				
				$.ajax({
					type : "POST",
					url : "getExamScheduleList.json",
					data : "boardId=" + boardId + "&classId=" + classId+ "&sectionId=" + sectionId + "&mediumId=" + mediumId + "&examTypeId="+ examTypeId,
					dataType : "json",
					async:false,
					success : function(response) {
						
						displayExamSchedule(response);
						
						if(isClick == 'Yes'){
							
								
								 $('#examSchedule').dataTable( {
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
							
							
							
							
							$(".datepick").datepicker({
								changeDate : true,
								changeMonth : true,
								changeYear : true,
								//yearRange: "-50:+0",
								showButtonPanel : true,
						 		minDate: '0',
							   // maxDate: '0', 
								dateFormat : 'dd-MM-yy'
							});
							
							
							$("input[name='fromTime'],input[name='toTime'],#fromTime,#toTime").datetimepicker({
								
								 format: 'LT'
							});
							}
						
						
					}
					});
			 }
		  }); 
		 
 });

 
/* $("#createSchedule").click(function(e){
	   
 
	 var boardName = $("#boardId").val();
	 var medium = $("#medium").val();
	 var className = $("#classId").val();
	 var section = $("#sectionId").val();
	 $.ajax({
			type : "POST",
			url : "saveExamSchedule.json",
			data : "boardName=" + boardName+"&medium="+medium +"&className="+className+"&section="+section,
			dataType : "json", 
			success : function(response) {
				 alert(response);  
				displayTable(response);
				//resetStatus(serviceId);
				//resetVendor(serviceId);
				
			},
			error : function(e) {
			}
		});
  
 });
*/

 
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
	
function classNameFilter(id){
	var boardId = $("#boardId").val();
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
			optionsForClass = $("#classId").empty();
			optionsForClass.append(new Option("-- Choose Class --", ""));
			$.each(response, function(i, tests) {
				var id=tests.id;
				var className=tests.className;
				optionsForClass.append(new Option(className, id));
			});
			$('#classId').trigger("chosen:updated");
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
	var boardId = $("#boardId").val();
	var classId = $("#classId").val();
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
			optionsForClass = $("#sectionId").empty();
			optionsForClass.append(new Option("-- Choose Section --", ""));
			$.each(response, function(i, tests) {
				var id=tests.id;
				var sectionName=tests.sectionName;
				optionsForClass.append(new Option(sectionName, id));
			});
			$('#sectionId').trigger("chosen:updated");
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
	var boardId = $("#boardId").val();
	var classId = $("#classId").val();
	var sectionId = $("#sectionId").val();
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
			$('#sectionId').trigger("chosen:updated");
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
	
	
	function dynamicInputfields(listOfSubjects){
		if (listOfSubjects != null) {
			$('#subjectDiv').html('');
			serviceUnitArray = {};
			var tableHead =	'<table id="examSchedule" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
							+ '<tr role="row">'
							+ '<thead>'
							+'<th>Subject Title</th>' 
							+'<th>Exam Date</th>' 
							+'<th>From(Hr:Min)</th>' 
							+'<th>To(Hr:Min)</th>' 
							+ '</tr></thead></table>';
						$('#subjectDiv').html(tableHead);
						
		$.each(listOfSubjects, function(i, tests) {

			var subjectName=tests.subjectName;
			var maxMarks=tests.maxMarks;
			var subId = tests.subjectId;
			var datename = parseInt(i)+1;
			
			var tblRow ="<tr  role='row' class='odd'>"
				    +'<td><input type="hidden" id="subjectId" name="subjectId" value="'+subId+'" /><label for="inputEmail3" class="col-sm-4 control-label"><b>'+ subjectName+'</b> </label></td>'
					+'<td><input id="examDate'+datename+'" name="examDate" type="text" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate datepick"  readonly="true" onfocus="removeBorder(this.id)" /></td>'
					+'<td><input id="fromTime'+datename+'" name="fromTime" type="text" class="form-control js-datetimepicker" tabindex="1" placeholder="Start time"/></td>'
					+'<td><input id="toTime'+datename+'" name="toTime" type="text" class="form-control js-datetimepicker" tabindex="1"  placeholder="End time"/></td></tr>';
				
		$(tblRow).appendTo("#examSchedule tbody");
			//optionsForClass.append(new Option(className, id));
		});
		$('#subjectDiv').append("<br>");
		}
		
	}
	
	var  examScheduleLength = 0 ; 
	var randomnum;
	function displayExamSchedule(listOfSubjects){
		if (listOfSubjects != null) {
			$('#subjectDiv').html('');
			serviceUnitArrayExamSchedule = {};
			var tableHead =	'<table id="examSchedule" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
							+ '<tr role="row">'
							+ '<thead>'
							+'<th>Subject Title</th>' 
							+'<th>Exam Date</th>' 
							+'<th>From(Hr:Min)</th>' 
							+'<th>To(Hr:Min)</th>' 
							+ '</tr></thead></table>';
						$('#subjectDiv').html(tableHead);
						
						examScheduleLength =listOfSubjects.length; 			
		$.each(listOfSubjects, function(i, tests) {
			//serviceUnitArrayExamSchedule[orderObj.randomnum] = tests;

			var subjectName=tests.subjectName;
			//var maxMarks=tests.maxMarks;
			var subId = tests.subjectId;
			var datename = parseInt(i)+1;
			randomnum=tests.randomnum;
			var tblRow ="<tr  role='row' class='odd'>"
				    +'<td><input type="hidden" id="subjectId" name="subjectId" value="'+subId+'" /><label id="lableid'+datename+'" for="inputEmail3" class="col-sm-4 control-label"><b>'+ subjectName+'</b> </label></td>'
					+'<td><input id="examDate'+datename+'" name="examDate" value="'+tests.examDate +'" type="text" data-format="dd-MM-yyyy" placeholder="Date" class="form-control validate datepick"  readonly="true" onfocus="removeBorder(this.id)" /></td>'
					+'<td><input id="fromTime'+datename+'" name="fromTime" type="text" value="'+tests.fromTime+'" class="form-control js-datetimepicker" tabindex="1" placeholder="Start time"/></td>'
					+'<td><input id="toTime'+datename+'" name="toTime" type="text"  value="'+tests.toTime+'" class="form-control js-datetimepicker" tabindex="1"  placeholder="End time"/></td></tr>';
				
		$(tblRow).appendTo("#examSchedule tbody");
			//optionsForClass.append(new Option(className, id));
		});
		
		$('#subjectDiv').append('<input id="randomnum" name="randomnum" type="hidden" class="form-control" tabindex="1" value="'+randomnum+'" />');
		
		$('#subjectDiv').append("<input id='printbtn' style='float: left;' class='btn btn-default' type='button' value='Print' onclick=PrintElem('#subjectDiv') />");
		
		$('#subjectDiv').append("<br>");
		}
		
		
	}


 
	function displayTable(listOrders) {
		$('#basicTable').html('');
		serviceUnitArray = {};
		var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
			+ '<thead>'
			+'<tr role="row">'
			+'<th>#</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Adm. no</th>'
			+'<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending">Gender</th>'
			+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Father</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Email</th>'
			+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending">Address</th>'
			+'</tr>'
			+'</thead>'
			+'<tbody></tbody></table>';
		$('#basicTable').html(tableHead);
			$.each(listOrders,	function(i, orderObj) {
								
// 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
								serviceUnitArray[orderObj.studentId] = orderObj;
								var id = '"' + orderObj.studentId + '"';
								var tblRow = "<tr align='center' role='row' class='odd'>"
										+"<td><input class='checkall' type='checkbox' name='checkboxName' id='"+orderObj.studentId+"' value='"+orderObj.studentId+"'/></td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.admissionNum+"'>"
										+ orderObj.admissionNum
										+ "</td>"
										+ "<td title='"+orderObj.studentName+"'>"
										+ orderObj.studentName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"' >"
										+ orderObj.boardName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"'>"
										+ orderObj.mediumName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.gender+"' >"
										+ orderObj.gender
										+ "</td>"
										+ "<td title='"+orderObj.fatherName+"' >"
										+ orderObj.fatherName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.email+"' >"
										+ orderObj.email
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.address+"' >"
										+ orderObj.address
										+ "</td>"
										+ '</tr>';
								$(tblRow).appendTo("#basicExample tbody");
								
								//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
							});
//$('#basicExample').dataTable();
	} 

	

	 function selectOrders(){
		 $("#filterId").show();
		 var boardName = $("#boardId").val();
		// alert(serviceId);
		 var medium = $("#medium").val();
		 var className = $("#classId").val();
		 var section = $("#sectionId").val();
// 		$("#basicExample tr").remove();
// 		$("#basicExample tr td").remove(); 
		 $.ajax({
				type : "POST",
				url : "getStudetnDetails.json",
				data : "boardName=" + boardName+"&medium="+medium +"&className="+className+"&section="+section,
				dataType : "json", 
				success : function(response) {
					/* alert(response); */ 
					displayTable(response);
					//resetStatus(serviceId);
					//resetVendor(serviceId);
					
				},
				error : function(e) {
				}
			});
	 }
	 
	 /*function getExamScheduleList(){
		 var boardName = $("#boardId").val();
		// alert(serviceId);
		 var medium = $("#medium").val();
		 var className = $("#classId").val();
		 var section = $("#sectionId").val();
		 var examTypeId = $("#examTypeId").val();
// 		$("#basicExample tr").remove();
// 		$("#basicExample tr td").remove(); 
		 $.ajax({
				type : "POST",
				url : "getExamScheduleList.json",
				data : "boardName=" + boardName+"&medium="+medium +"&className="+className+"&section="+section+"&examTypeId="+examTypeId,
				dataType : "json", 
				success : function(response) {
					 alert(response);  
					displayTable(response);
					//resetStatus(serviceId);
					//resetVendor(serviceId);
					
				},
				error : function(e) {
				}
			});
	 }*/
	 
	 function sendNotification(){
		 
		 $("#studentId_error").text('');
		 $("#messageId_error").text('');
		 $("#notificatinId_error").text('');
		 $("#absentId_error").text('');
			var studentId = [];
			$('input[name=checkboxName]:checked').map(function() {
				studentId.push($(this).val());
			});
			var message=$("#messageId").val();
			
			for(var i=0; i< examScheduleLength;i++){
				
				var id = parseInt(i)+1;
				
				message +="\n" 
				message +=$("#lableid"+id).text()+":";
				message += " ";
				message +=$("#examDate"+id).val();
				message += " From ";
				message +=$("#fromTime"+id).val();
				message += " To ";
				message +=$("#toTime"+id).val()+ " \n";
				
				
				
			}
			
			
			var absentId=$("#absentId").val();
			var notificatinId=$("#notificatinId").val();
			if(studentId.length == 0 || message.length ==0 || notificatinId.length == 0  ){
				
				if(studentId.length == 0){
// 					alert("please select student");
					$("#studentId_error").text('Select atleast One Student');
				}
				if(message.length == 0){
// 					alert("please select message");
					$("#messageId_error").text('Text Message');
				}
				if(notificatinId.length == 0){
// 					alert("please select notificatinId");
					$("#notificatinId_error").text('Choose Type of Notification');
				}
				
			}else{
				 $("#sendBtn").attr("disabled",true);
				 $("#sendBtn").val("Please wait...");
			 $.ajax({
					type : "POST",
					url : "sendEvent.htm",
					data : "studentId=" + studentId+"&message="+message +"&notificatinId="+notificatinId,
					success : function(response) {
						/* alert(response); */ 
						  location.reload();
						
					},
					error : function(e) {
					}
				});
			 
			 
			}
			
			if( isClick == 'Yes'){
				 setInterval(function(){ $('#smsConfirmation').text(''); }, 3000);
				 }
	 }
	 function cancelForm(){
		 /* $("#basicExample tr td").remove();
			$("#basicExample td").remove();
			$("#filterId").hide(); */
		window.location.href="eventsHome";
	 }
	 
	 $("#absentId").click(function () 
		  		{
		  			var value1 = "<%=hours%>";
		  			if(value1 >= 12){
		  	  			$('#absentId').children('option[value="morning"]').attr('disabled', true);
		  	  		}
		  			else if(value1 <= 12){
		  	  			$('#absentId').children('option[value="afternoon"]').attr('disabled', true);
		  	  		}
		  		});
	 
	 
	 function PrintElem(elem)
		{
			$("#printbtn").hide();
		    Popup($(elem).html());
		}

		function Popup(data)
		{
		    var mywindow = window.open('', 'new div');
		    mywindow.document.write('<html><head><title>Student Application</title></head>');
		    mywindow.document.write(data);
		    mywindow.print();
		    mywindow.close();
		    $("#printbtn").show();
		    return true;
		}
	
		/*$(".checkall").change(function () {
			var len=$("[name='checkboxName']:checked").length;
			if(len!=0)
			{
				$('#delbtn').show();
			}
			else
			{
				$('#delbtn').hide();
			}
		});*/
