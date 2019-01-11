$( document ).ready(function() {
	
	
	$("#examPatternTableDiv").hide();
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

			  $('#cancel').click(function () {
			    $("#cls-form").validate().resetForm();
			    $("#cls-form").removeClass("has-error");
			    $("#boardId").val('');
			    $("#medium").val('');
			    $("#classId").val('');
			    $("#sectionId").val('');
			    $("#examTypeId").val('');
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
							console.log(response);
							
								$('#examPatternTable').html('');
								serviceUnitArray = {};
								/*var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
										+ '<thead>'
										+ '<tr role="row">'
										+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Subject Name</th>'
										+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Maximum Marks</th>'
										+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Option</th>'
										+ '</tr>' + '</thead>' + '<tbody></tbody></table>';
								$('#examPatternTable').html(tableHead);
								$.each(response,
												 function(i, orderObj) {
										if (orderObj.dueFee == 0.00) {
														orderObj.dueFee = orderObj.netFee;
													}
					 
													// 	contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
													serviceUnitArray[orderObj.id] = orderObj;
													var id = '"' + orderObj.id + '"';
													var tblRow = "<tr align='center' role='row' class='odd'>"
															
															+ "<td class='hidden-sm hidden-xs' title='"+orderObj.subjectName+"'>"
															+ orderObj.subjectName
															+ "</td>"
															+ "<td class='hidden-sm hidden-xs' title='"+orderObj.maxMarks+"'>"
															+ orderObj.maxMarks
															+ "</td>"
															+ "<td align='center'>"
															+ '<a href="javascript:void(0)" onclick=editPack('
															+ orderObj.id
															+ ')'
															+ '  ><i style="color: green;" class="fa fa-edit"></i></a>'
															+ '</td>' + '</tr>';
													$(tblRow).appendTo("#examPatternTable tbody");

											

												});
								$('#examPatternTable').dataTable();*/
								
								
								
								var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
									+ '<thead>'
									+ '<tr role="row"><th>Subjects</th></tr>'
									+ '</thead><tbody><tr role="row"><th>Marks</th></tr></tbody></table>';
								var objId='';
								
							$('#examPatternTable').html(tableHead);
							allSubjects = response;
							
							/*var subMarks=	$.map(allSubjects, function(subject) {

									
									return subject.subjectName + ": " + subject.maxMarks;
							});
							console.log(subMarks);*/
							
						
							$.each(allSubjects,
											 function(i, orderObj) {
								/*	if (orderObj.dueFee == 0.00) {
													orderObj.dueFee = orderObj.netFee;
												}
				 */
												// 	contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
												serviceUnitArray[orderObj.subjectName] = orderObj.maxMarks;
												var id = '"' + orderObj.id + '"';
												var subjectRow = "<th class='hidden-sm hidden-xs' title='"+orderObj.subjectName+"'>"
														+ orderObj.subjectName
														+ "</th>";
												var marksRow   =  "<td class='hidden-sm hidden-xs' title='"+orderObj.maxMarks+"'>"
														+ orderObj.maxMarks
														+ "</td>";
												map.push(orderObj);
												
												$(subjectRow).appendTo("#basicExample thead tr");
												$(marksRow).appendTo("#basicExample tbody tr");
												objId=orderObj.id;
											});
							$('<th class="noExport">Action</th>').appendTo("#basicExample thead tr");
							$('<td><a href="javascript:void(0)" onclick="editPack()"><i style="color: green;" class="fa fa-edit"></i></a></td>').appendTo("#basicExample tbody tr");
						}
					
					
				});
				
					
					
				});
			  
});



function displayTable(listOrders) {
			$("#basicExample tr td").remove();
			$("#basicExample td").remove();
			serviceUnitArray = {};
			$
					.each(
							listOrders,
							function(i, orderObj) {
								serviceUnitArray[orderObj.classId] = orderObj;
								var id = '"' + orderObj.classId + '"';
								var tblRow = "<tr align='center' role='row' class='odd'>" + "<td'><a  id='"
										+ orderObj.classId
										+ "' href='javascript:forOrderDetails("
										+ id
										+ ")' style='font-color:red'>"
										+ orderObj.orderId
										+ "</a></td>"
										+ "<td  title='"+orderObj.bordName+"'>"
										+ orderObj.bordName
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.medium+"'>"
										+ orderObj.medium
										+ "</td>"
										+ "<td title='"+orderObj.cname+"'>"
										+ orderObj.cname
										+ "</td>"
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.sname+"' >"
										+ orderObj.sname
										+ "<td class='hidden-sm hidden-xs' title='"+orderObj.fee+"' >"
										+ orderObj.fee
										+ "/-</td>"
										+ "<td>"
										+ '<a href="javascript:void(0)" onclick=editPack('
										+ orderObj.classId + ')'
										+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
										+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteClass('
										+ orderObj.classId + ')'
										+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
									
										+ '</tr>';
								$(tblRow).appendTo("#basicExample");
							});
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
	
	
	function dynamicInputfields(listOfSubjects){
		
		$('#subjectDiv').empty();
		var randomnum;
		console.log(listOfSubjects);
		$.each(listOfSubjects, function(i, tests) {
			var subjectId=tests.subjectId;

			var subjectName=tests.subjectName;
			var maxMarks=tests.maxMarks;
			randomnum=tests.randomnum;
			$('#subjectDiv').append(
					'<div class="col-md-2">'
					+'<label for="inputEmail3" class="col-sm-4 control-label">'+ subjectName+':' 
					+ ' </label>' 
					+'<br>'
					
					+'<input id="subjectId" name="subjectId" type="hidden" class="form-control" tabindex="1" value="'+subjectId+'"/>'
					+'<input id="maxMarks" name="maxMarks" type="number" class="form-control" tabindex="1" value="'+maxMarks+'"	placeholder="Enter Maximum Marks"/>'
					+'</div>');
				
			$('#subjectDiv').append();
			//optionsForClass.append(new Option(className, id));
		});

		$('#subjectDiv').append('<input id="randomnum" name="randomnum" type="hidden" class="form-control" tabindex="1" value="'+randomnum+'" />');
		
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
				dynamicInputfields(response)
				 /* alert(response); */  
				/*var optionsForClass = "";
				optionsForClass = $("#subjectId").empty();*/
				
				
				//optionsForClass.append(new Option("-- Choose Subject --", ""));
				/*$.each(response, function(i, tests) {
					var id=tests.subjectId;

					var subjectName=tests.subjectName;
					$('#subjectDiv').append(
							'<div class="col-md-2">'
							+'<label for="inputEmail3" class="col-sm-4 control-label">'+ subjectName+':' 
							+ ' </label>' 
							+'<br>'
							+'<input id="'+ id +'" name="subjectId" type="hidden" class="form-control" tabindex="1" value="'+id+'"/>'
							+'<input id="1a'+subjectName +' "name="maxMarks" type="text" class="form-control" tabindex="1"	placeholder="Enter Maximum Marks"/>'
							+'</div>');
						
					$('#subjectDiv').append();
					//optionsForClass.append(new Option(className, id));
				});*/
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
	
	/*function getExamPatternList(){
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
				console.log(response);
				
					$('#examPatternTable').html('');
					serviceUnitArray = {};
					var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
							+ '<thead>'
							+ '<tr role="row">'
							+ '<th class="sorting_asc" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Subject Name</th>'
							+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Maximum Marks</th>'
							+ '<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Option</th>'
							+ '</tr>' + '</thead>' + '<tbody></tbody></table>';
					$('#examPatternTable').html(tableHead);
					$.each(response,
									 function(i, orderObj) {
							if (orderObj.dueFee == 0.00) {
											orderObj.dueFee = orderObj.netFee;
										}
		 
										// 	contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
										serviceUnitArray[orderObj.id] = orderObj;
										var id = '"' + orderObj.id + '"';
										var tblRow = "<tr align='center' role='row' class='odd'>"
												
												+ "<td class='hidden-sm hidden-xs' title='"+orderObj.subjectName+"'>"
												+ orderObj.subjectName
												+ "</td>"
												+ "<td class='hidden-sm hidden-xs' title='"+orderObj.maxMarks+"'>"
												+ orderObj.maxMarks
												+ "</td>"
												+ "<td align='center'>"
												+ '<a href="javascript:void(0)" onclick=editPack('
												+ orderObj.id
												+ ')'
												+ '  ><i style="color: green;" class="fa fa-edit"></i></a>'
												+ '</td>' + '</tr>';
										$(tblRow).appendTo("#examPatternTable tbody");

								

									});
					$('#examPatternTable').dataTable();
					
					
					
					var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
						+ '<thead>'
						+ '<tr role="row"><th>Subjects</th></tr>'
						+ '</thead><tbody><tr role="row"><th>Marks</th></tr></tbody></table>';
					var objId='';
					
				$('#examPatternTable').html(tableHead);
				allSubjects = response;
				
				var subMarks=	$.map(allSubjects, function(subject) {

						
						return subject.subjectName + ": " + subject.maxMarks;
				});
				console.log(subMarks);
				
			
				$.each(allSubjects,
								 function(i, orderObj) {
						if (orderObj.dueFee == 0.00) {
										orderObj.dueFee = orderObj.netFee;
									}
	 
									// 	contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
									serviceUnitArray[orderObj.subjectName] = orderObj.maxMarks;
									var id = '"' + orderObj.id + '"';
									var subjectRow = "<th class='hidden-sm hidden-xs' title='"+orderObj.subjectName+"'>"
											+ orderObj.subjectName
											+ "</th>";
									var marksRow   =  "<td class='hidden-sm hidden-xs' title='"+orderObj.maxMarks+"'>"
											+ orderObj.maxMarks
											+ "</td>";
									map.push(orderObj);
									
									$(subjectRow).appendTo("#basicExample thead tr");
									$(marksRow).appendTo("#basicExample tbody tr");
									objId=orderObj.id;
								});
				$('<th>Action</th>').appendTo("#basicExample thead tr");
				$('<td><a href="javascript:void(0)" onclick="editPack()"><i style="color: green;" class="fa fa-edit"></i></a></td>').appendTo("#basicExample tbody tr");
			}
		
		
	});
	}*/
	  var map = [];
	function editPack() {
		console.log(map);
		//getExamPatternList()
		dynamicInputfields(map);
		$.each(map, function(key,value) {
		/*$("#id").val(serviceUnitArray[id].id);
		$('#boardId').val(serviceUnitArray[id].boardId);
		classNameFilter();
		$('#classId').val(serviceUnitArray[id].classId);
 		sectionFilter();
		
		$('#sectionId').val(serviceUnitArray[id].sectionId);
 		mediumFilter();
		$('#medium').val(serviceUnitArray[id].mediumId);
		$('#examTypeId').val(serviceUnitArray[id].examTypeId);*/
		//dynamicInputfields(serviceUnitArray[id]);
//			alert(value);
		$("#"+key).val(value);
		
		
		});
		
		$("#submitId").val("Update");
		
		$(window).scrollTop($('#boardId').offset().top);
	}