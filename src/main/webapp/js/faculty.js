$(document).ready (function(){
	
	jQuery.validator.addMethod('lettersonly', function(value, element) {
	    return this.optional(element) || /^[a-z. áãâäàéêëèíîïìóõôöòúûüùçñ]+$/i.test(value);
	}, "Valid Name");

	jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
	   phone_number = phone_number.replace(/\s+/g, ""); 
	 return this.optional(element) || phone_number.length > 9 &&
	   phone_number.match(/^[7-9]\d+$/);
	}, "Invalid Mobile Number");
	   
	$("#fac-form").validate({
	    errorElement: 'span',
	    errorClass: 'has-error',
		rules:
		{
	    	name:{required: true,lettersonly:true},
	        gender:{required: true},
	        /* boardName:{required:true},
		    medium:{required:true},
		    className:{required:true},  
		    section:{required:true},
	        subject:{required:true}, */
	        qualification:{required: true,lettersonly:true},
	        contactNumber:{required:true, number:true, mobileNO:true, minlength:10, maxlength:10},
		},
		messages:
	   	{
			name:{required: 'Faculty Name'},
			gender:{required:'Choose Gender'},
			/* boardName:{required:'Please Choose Board'},
		    medium:{required:'Please Choose Medium'},
		    className:{required:'Please Choose Class'},
		    section:{required:'Please Choose Section'},
	        subject:{required:'Please Choose Subject'}, */
	        qualification:{required:'Qualification'},
	        contactNumber:{required:'Contact Number',number:'only numbers'},
		},
		errorPlacement: function(error, element){
		      if(element.attr("name") == "gender")
		        error.insertAfter(".gender_error").css("color", "red");
		      else
		          error.insertAfter(element);
		}
	  });

	  $('#cancel').click(function () {
	    $("#fac-form").validate().resetForm();
	    $("#fac-form").removeClass("has-error");
	    $("#id").val(0);
	    $("#name").val('');
	    $("#gender").val('');
	    $("#subject").val('');
	    $("#qualification").val('');
	    $("#contactNumber").val('');
	    $("#submitId").val("Submit");
	    $("#fac-form").addClass('form-horizontal');
	    $("#headId").text("Add Faculty");
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
									
//	 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
									serviceUnitArray[orderObj.id] = orderObj;
									var id = '"' + orderObj.id + '"';
									var tblRow = "<tr  role='row' class='odd'>" + "<td'><a  id='"
											+ orderObj.id
											+ "' href='javascript:forOrderDetails("
											+ id
											+ ")' style='font-color:red'>"
											+ orderObj.id
											+ "</a></td>"
											+ "<td id='"+orderObj.id+"'apdate"+" title='"+orderObj.facutltyName+"'>"
											+ orderObj.facutltyName
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.gender+"'>"
											+ orderObj.gender
											+ "</td>"
											+ "<td  title='"+orderObj.qualifaction+"'>"
											+ orderObj.qualifaction
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.contactNumber+"'>"
											+ orderObj.contactNumber
											+ "</td>"
											+ "</td>"
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.id + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>'+ '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteFaculty('
											+ orderObj.id + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>' + '</tr>';
									$(tblRow).appendTo("#basicExample");
								});
		}  
	 	
	 	function editPack(id) {
			var transactionId = serviceUnitArray[id].id;
			 $("#fac-form").validate().resetForm();
			$("#id").val(serviceUnitArray[id].id);
			$("#name").val(serviceUnitArray[id].facutltyName);
			$('#gender').val(serviceUnitArray[id].gender);
			$('#gender').trigger("chosen:updated");
			$('#contactNumber').val(serviceUnitArray[id].contactNumber);
			$('#qualification').val(serviceUnitArray[id].qualifaction);
			$("#submitId").val("Update");
			$("#headId").text("Edit Faculty");
		} 
		
		function serviceFilter(id){
			var borderId = $("#boardName").val();
			$('#loadAjax').show();
			$.ajax({
				type : "POST",
				url : "getBordName.json",
				data : "borderId=" + borderId,
				dataType : "json",
				success : function(response) {
					/* alert(response); */ 
					var optionsForClass = "";
					optionsForClass = $("#medium").empty();
					optionsForClass.append(new Option("--Select--", ""));
					$.each(response, function(i, tests) {
						var id=tests.id;
						var name=tests.name;
						optionsForClass.append(new Option(name, id));
					});
					$('#loadAjax').hide();
					$('#medium').trigger("chosen:updated");
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
		
		function deleteFaculty(id){
			var facultyId = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
				$('#loadAjax').show();
				
			  
			  $.ajax({
						type : "POST",
						url : "deleteFaculty.json",
						data : "facultyId=" + facultyId ,
						success : function(response) {
//	 						alert(response);
							displayTable(response);
							window.location.href='addFaculty';
							if(response == null || response == ""){
								$("#emptyMessageId").val("No Results Found");
							}
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
				
			}else{
			return false;
			}
		}
