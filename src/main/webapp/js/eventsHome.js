

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

 var selectAllPagination;
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
			if(isClick == 'Yes' ){
				
				
				selectAllPagination =    $('#basicExample').dataTable( {
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
				/* $('#basicExample').dataTable({
			        "order": []
			    }); */

			}
	} 

	

	 function selectOrders(){
		 $("#filterId").show();
		 var boardName = $("#boardName").val();
		// alert(serviceId);
		 var medium = $("#medium").val();
		 var className = $("#className").val();
		 var section = $("#section").val();
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
