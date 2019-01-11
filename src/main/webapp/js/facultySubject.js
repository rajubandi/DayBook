$(function(){
	
	jQuery.validator.addMethod('lettersonly', function(value, element) {
	    return this.optional(element) || /^[a-z. áãâäàéêëèíîïìóõôöòúûüùçñ]+$/i.test(value);
	}, "Please Enter Valid Name");

	jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
	   phone_number = phone_number.replace(/\s+/g, ""); 
	 return this.optional(element) || phone_number.length > 9 &&
	   phone_number.match(/^[7-9]\d+$/);
	}, "Invalid Mobile Number");
	   
	$("#sub-form").validate({
	    errorElement: 'span',
	    errorClass: 'has-error',
		rules:
		{
			facultyId:{required: true},
	        boardName:{required:true},
		    medium:{required:true},
		    className:{required:true},  
		    section:{required:true},
	        subject:{required:true},
		},
		messages:
	   	{
			facultyId:{required: 'Choose Faculty'},
			boardName:{required:'Choose Board'},
		    medium:{required:'Choose Medium'},
		    className:{required:'Choose Class'},
		    section:{required:'Choose Section'},
	        subject:{required:'Choose Subject'},
		},
	  });

	  $('#cancel').click(function () {
	    $("#sub-form").validate().resetForm();
	    $("#sub-form").removeClass("has-error");
	    $("#id").val(0);
	    $("#facultyId").val('');
	    $("#boardName").val('');
	    $("#className").val('');
	    $("#section").val('');
	    $("#medium").val('');
	    $("#subject").val('');
	    $("#submitId").val("Submit");
	    $("#sub-form").addClass('form-horizontal');
	    $("#headId").text("Add Faculty Subject");
	     });
});
		
	 	function displayTable(listOrders) {
			if (listOrders != null) {
				$("#basicExample tr td").remove();
				$("#basicExample td").remove();
				serviceUnitArray = {};
				$
						.each(
								listOrders,
								function(i, orderObj) {
									
//	 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
									serviceUnitArray[orderObj.id] = orderObj;
									var id = '"' + orderObj.id + '"';
									var tblRow = "<tr align='center'>" + "<td'><a  id='"
											+ orderObj.id
											+ "' href='javascript:forOrderDetails("
											+ id
											+ ")' style='font-color:red'>"
											+ orderObj.id
											+ "</a></td>"
											+ "<td id='"+orderObj.id+"'apdate"+" title='"+orderObj.facultyName+"'>"
											+ orderObj.facultyName
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"'>"
											+ orderObj.boardName
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"' >"
											+ orderObj.mediumName
											+ "</td>"
											+ "<td title='"+orderObj.className+"'>"
											+ orderObj.className
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.sectionName+"' >"
											+ orderObj.sectionName
											+ "</td>"
											+ "<td title='"+orderObj.subjectName+"' >"
											+ orderObj.subjectName
											+ "</td>"
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.id + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deletefacultysubject('
											+ orderObj.id + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
											
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
								});
			} else {
				//alert('no data to display..');
			}
		}  
	 	function editPack(id) {
			var transactionId = serviceUnitArray[id].id;
			$("#sub-form").validate().resetForm();
			$("#id").val(serviceUnitArray[id].id);
			$("#facultyId").val(serviceUnitArray[id].facultyId);
			$('#facultyId').trigger("chosen:updated");
			$('#boardName').val(serviceUnitArray[id].boardId);
			$('#boardName').trigger("chosen:updated");
			classNameFilter();
			
			$('#className').val(serviceUnitArray[id].classId);
			$('#className').trigger("chosen:updated");
			sectionFilter();
			$('#section').val(serviceUnitArray[id].sectionId);
			$('#section').trigger("chosen:updated");
//			mediumFilter();
			$('#medium').val(serviceUnitArray[id].mediumId);
			$('#medium').trigger("chosen:updated");
			 subjectFilter();
			$('#subject').val(serviceUnitArray[id].subjectId);
			$('#subject').trigger("chosen:updated");
			
			
			$("#submitId").val("Update");
			$("#headId").text("Edit Faculty Subject");
			$(window).scrollTop($('#facultyId').offset().top);
		} 
		
		function serviceFilter(id){
			var borderId = $("#boardName").val();
//			$('#loadAjax').show();
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
//					$('#loadAjax').hide();
					$('#medium').trigger("chosen:updated");
				},
				error : function(e) {
//					$('#loadAjax').hide();
				},
				statusCode : {
					406 : function() {
//						$('#loadAjax').hide();
				
					}
				}
			});
		} 
	 	function deletefacultysubject(id){
	 		var facultySubject = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
			  
			  $.ajax({
						type : "POST",
						url : "deleteFacultySubject.json",
						data : "facultySubject=" + facultySubject ,
						success : function(response) {
							displayTable(response);
							window.location.href='facultySubject';
						},
						error : function(e) {
						},
						statusCode : {
							406 : function() {
						
							}
						}
					});
				
			}else{
			return false;
			}
	 	}
	 	
	 	function classNameFilter(id){
			var boardId = $("#boardName").val();
			if(boardId.length !=0){
//				 $('#loadAjax').show();
			$.ajax({
				type : "POST",
				url : "getClassNameFilter.json",
				data : "boardId=" + boardId,
				dataType : "json",
				async:false,
				success : function(response) {
//	 				  alert(response);  
					var optionsForClass = "";
					optionsForClass = $("#className").empty();
					optionsForClass.append(new Option("-- Choose Class --", ""));
					$.each(response, function(i, tests) {
						var id=tests.id;
						var className=tests.className;
						optionsForClass.append(new Option(className, id));
					});
//					$('#loadAjax').hide();
					$('#className').trigger("chosen:updated");
				},
				error : function(e) {
//					 $('#loadAjax').hide();
				},
				statusCode : {
					406 : function() {
//						 $('#loadAjax').hide();
				
					}
				}
			});
//			$('#loadAjax').hide();
			}
		} 
	 	function sectionFilter(){
			var boardId = $("#boardName").val();
			var classId = $("#className").val();
			if(boardId.length !=0 && classId.length != 0){
//				 $('#loadAjax').show();
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
//					$('#loadAjax').hide();
					$('#section').trigger("chosen:updated");
				},
				error : function(e) {
//					 $('#loadAjax').hide();
				},
				statusCode : {
					406 : function() {
//						 $('#loadAjax').hide();
				
					}
				}
			});
//			$('#loadAjax').hide();
			}
		} 
	 	function mediumFilter(){
			var boardId = $("#boardName").val();
			var classId = $("#className").val();
			var sectionId = $("#section").val();
			
			if(boardId.length !=0 && classId.length != 0 &&  sectionId.length != 0){
//				 $('#loadAjax').show();
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
//					$('#loadAjax').hide();
					$('#section').trigger("chosen:updated");
				},
				error : function(e) {
//					 $('#loadAjax').hide();
				},
				statusCode : {
					406 : function() {
//						 $('#loadAjax').hide();
				
					}
				}
			});
//			$('#loadAjax').hide();
			}
		} 
	 	
	 	
	 	function subjectFilter(){
			var boardId = $("#boardName").val();
			var classId = $("#className").val();
			
			if(boardId.length !=0 && classId.length != 0){
			$.ajax({
				type : "POST",
				url : "getSubjectFilter.json",
				data : "boardId=" + boardId+"&classId="+classId,
				dataType : "json",
				async:false,
				success : function(response) {
					 /* alert(response); */  
					var optionsForClass = "";
					optionsForClass = $("#subject").empty();
					optionsForClass.append(new Option("-- Choose Subject --", ""));
					$.each(response, function(i, tests) {
						var id=tests.subjectId;
						var subjectName=tests.subjectName;
						optionsForClass.append(new Option(subjectName, id));
					});
					$('#subject').trigger("chosen:updated");
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