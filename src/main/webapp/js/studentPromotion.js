var searchbtn=''; 
$(function(){
	jQuery.validator.addMethod('lettersonly', function(value, element) {
	    return this.optional(element) || /^[a-z. áãâäàéêëèíîïìóõôöòúûüùçñ]+$/i.test(value);
	}, "Please Enter Valid Name");

	   jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
	   phone_number = phone_number.replace(/\s+/g, ""); 
	 return this.optional(element) || phone_number.length > 9 &&
	   phone_number.match(/^[7-9]\d+$/);
	}, "Invalid Mobile Number");

	   $("#student-form").validate({
		    errorElement: 'span',
		    errorClass: 'has-error',
			rules:
			{
				boardName:{required: true},
				className:{required: true},
				section:{required: true},
				medium:{required: true}
			},
		    messages:
			{
		    	boardName:{lettersonly: 'Valid Name'},
		    	className:{number: '10 digit mobile number'},
		    	section:{email: 'Valid Email'},
		    	medium:{email: 'Valid Email'},
			},
			errorPlacement: function(error, element){
				if(element.attr("name") == "name")
			        error.insertAfter(".name_error").css("color", "red");
				else if(element.attr("name") == "mobile")
			        error.insertAfter(".mobile_error").css("color", "red");
				else if(element.attr("name") == "email")
			        error.insertAfter(".email_error").css("color", "red");
				else
			    	error.insertAfter(element);
			}
	   });   
	   
	$('#cancel').click(function () {
	  	$("#student-form").validate().resetForm();
	    $("#student-form").removeClass("has-error");
	    $('#name').val("");
	    $('#mobile').val("");
	    $('#email').val("");
	    $("#student-form").addClass('form-horizontal');
	});
	

	var styleBlock = '.placeholder-style.placeholder-style::-moz-placeholder {color: #cc0000;} .placeholder-style::-webkit-input-placeholder {color: #cc0000;}';
	$('.validate').blur(function() {
		var id = $(this).attr('id');
		var placeholder = $(this).attr('placeholder');
		var value1 = $("#" + id).val();
		var value=$.trim(value1);
		if (value == null || value == "" || value == "undefined") {
			$('style').append(styleBlock);
			$("#" + id ).attr("placeholder", placeholder);
			$("#" + id ).css('border-color','#e73d4a');
			$("#" + id ).css('color','#e73d4a');
			$("#" + id ).addClass('placeholder-style your-class');
			
			if ($("#" + id+"_chosen").length)
			{
				$("#" + id+"_chosen").children('a').css('border-color','#e73d4a');
			}
//			$("#" + id + "Error").text("Please " + placeholder);
		} else {
			$("#" + id + "Error").text("");
		}
	});

	var idArray = $.makeArray($('.validate').map(function() {
		return this.id;
	}));
	
	var validation = true;

	
	$('#promoteStudentModalSubmit').click(function(event) {
		validation = true;
		$.each(idArray, function(i, val) {
			var value = $("#" + idArray[i]).val();
			var placeholder = $("#" + idArray[i]).attr('placeholder');
			
			/* optional variable is for hidden and show input field validation  */
			 
			var optional = $("#" + idArray[i]).hasClass('display-none');
			var errorCls = $("#" + idArray[i]).hasClass('errorCls');
			if ((value == null || value == "" || value == "undefined" || errorCls) && !optional) {
				$('style').append(styleBlock);
				$("#" + idArray[i] ).attr("placeholder", placeholder);
				$("#" + idArray[i] ).css('border-color','#e73d4a');
				$("#" + idArray[i] ).css('color','#e73d4a');
				$("#" + idArray[i] ).addClass('placeholder-style your-class');
				 var id11 = $("#" + idArray[i]+"_chosen").length;
				if ($("#" + idArray[i]+"_chosen").length)
				{
					$("#" + idArray[i]+"_chosen").children('a').css('border-color','#e73d4a');
				}
//				$("#" + idArray[i] + "Error").text("Please " + placeholder);
				validation = false;
			} 
		});
		if(validation) {
			$("#promoteStudentModalSubmit").attr("disabled",true);
			$("#promoteStudentModalSubmit").val("Please wait...");
			
			/*var allStudentIds= $("#id").val();
			
			var allStudentIdsArry = new Array();
			$.each(allStudentIds, function(i,id) {
				allStudentIdsArry.push(id);
			});
			formData = new FormData();
			formData.append(id,allStudentIds);*/
			$("form").submit();											
		}else {
			return false;
			event.preventDefault();
		}
	});
	

	$('.validate').keydown(function() {
		var id = $(this).attr('id');
		removeBorder(id);
	});
	
	
	/* $('.multiselect').multiselect({
	    	 allSelectedText: 'All',
	      maxHeight: 200,
	      includeSelectAllOption: true,
	      selectAllText: 'Check all!'
	    });*/
	   /* .multiselect('selectAll', true)
	    .multiselect('Selected Students');*/
});
	    

	function displayTable(listOrders) {
		$('#basicTable').html('');
		serviceUnitArray = {};
		var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
						+ '<thead>'
						+'<tr role="row">'
						+'<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">#</th>'
						+'<th class="sorting noExport" style="width: 10px;" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">S.No</th>'
						+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>'
						+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Father Name</th>'
						+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Mobile Number</th>'
						+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Image</th>'
						+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Admission No.</th>'
//						+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>'
						+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Class</th>'
						+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>'
						//+'<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>'
					+'</tr>'
				+'</thead>'
				+'<tbody></tbody></table>';
		$('#basicTable').html(tableHead);
		$.each(listOrders,function(i, orderObj) {
							
							if(orderObj.imagePath == null){
								orderObj.imagePath="img/default.png"
							}
//								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
							serviceUnitArray[orderObj.studentId] = orderObj;
							var id = '"' + orderObj.studentId + '"';
							var sno = i+1;
							var tblRow = "<tr  role='row' class='odd'>"
									+ "<td align='center'><input class='checkall multiplecheck' type='checkbox' name='checkboxName' id='"+orderObj.studentId+"' value='"+orderObj.studentId+"'/></td>"
									/*+ "<td'><a id='"
									+ orderObj.studentId
									+ "' href='javascript:forOrderDetails("
									+ orderObj.studentId
									+ ")' style='font-color:red'>"
									+ orderObj.studentId
									+ "</a></td>"*/
									+ "<td title='"+ sno +"'>"
									+ sno
									+ "</td>"
									+ "<td title='"+orderObj.studentName+"'>"
									+ orderObj.studentName
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.fatherName+"' >"
									+ orderObj.fatherName
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mobile+"' >"
									+ orderObj.mobile
									+ "</td>"
									+ "<td  class='hidden-sm hidden-xs'><img style='width: 25px;height: 25px;' src='"+baseUrl2+"/"+orderObj.imagePath+"'/>"
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.admissionNum+"'>"
									+ orderObj.admissionNum
									+ "</td>"
//									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"' >"
//									+ orderObj.boardName
//									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.className+"' >"
									+ orderObj.className
									+ "</td>"
									+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"'>"
									+ orderObj.mediumName
									+ "</td>"
									
									/*+ "<td align='center'>"
									+ '<a onclick=getApplicant('+orderObj.studentId+')>'
									+ '<i style="cursor: pointer;" class="fa fa-address-book-o fa-2x"></i></a>' 
									+ '</td>'*/
									+ '</tr>';
							$(tblRow).appendTo("#basicExample tbody");
							
							//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
						});
		if(isClick == 'Yes'){
			
			$("#checkAll").change(function () {
				oTable.$("input:checkbox").prop('checked', $(this).prop("checked"));
					var len=$("[name='checkboxName']:checked").length;
					
				});
			
			 oTable =  $('#basicExample').dataTable( {
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
		                footer: true,exportOptions: {
	                        columns: "thead th:not(.noExport)"
	                    }
		            },
		            {
		            	 extend: 'pdfHtml5',
			                orientation: 'landscape',
			                pageSize: 'LEGAL',
			                	footer: true,exportOptions: {
			                        columns: "thead th:not(.noExport)"
			                    }
		            },
		            {
		                extend: 'print',
		                footer: true,
		                exportOptions: {
	                        columns: "thead th:not(.noExport)"
	                    }
		               
		            }
		        ]
		    
		    } );
		}
//$('#basicExample').dataTable();
}  
	function promoteStudents(){
		
		var selected = new Array();
		$('#basicExample input[type="checkbox"]:checked').each(function() {
		    selected.push($(this).attr('id'));
		});
		var noOfStudents = selected.length;
		//console.log(selected);
		if(noOfStudents > 0 ){
			var r = confirm("Selected students are only : " +noOfStudents +"\n Do you wish to Continue");
			if(r==true)	{
				
				//Main Page Fields Will Get empty
				$("#boardName").val('');
				$("#className").val('');
				$("#section").val('');
				$("#medium").val('');
				
				$("#academicYear").val('');
				$("#boardId").val('');
				$("#classId").val('');
				$("#sectionId").val('');
				$("#mediumId").val('');
				
				var idArray = $.makeArray($('.validate').map(function() {
					return this.id;
				}));
				
				
				$.each(idArray, function(i, val)
						{
							var value = $("#" + idArray[i]).val();
							if ($("#" +idArray[i]+"_chosen").length)
							{
								$("#" +idArray[i]).val("");
								$("#" +idArray[i]).trigger("chosen:updated");
							}
//							$("form")[0].reset();
							$("#"+idArray[i]).val('');
							$("#"+idArray[i]).prop('disabled',false);
							$("#"+idArray[i]).css('border-color','');
							$("#"+idArray[i]).css('color','black');
							$("#"+idArray[i]).removeClass('placeholder-style your-class default-class');
							if ($("#" + idArray[i]+"_chosen").length)
							{
								$("#" + idArray[i]+"_chosen").children('a').css('border-color','black');
							}
						});
				
			/*	$.each(selected, function(i, tests) {
					
					$('#hiddenStudentIdsDiv').append('<div class="col-md-2">'
							+'<input id="id" name="id" type="hidden" class="form-control" tabindex="1" value="'+tests+'"/>'
							+'</div>');
						
					$('#hiddenStudentIdsDiv').append();
					//optionsForClass.append(new Option(className, id));
				});*/

				
				
				var optionsForClass = "";
				optionsForClass = $("#studentId").empty();
				$.each(selected, function(i, tests) {
					var id=tests;
					var studentName=serviceUnitArray[tests].studentName;
					//optionsForClass.append(new Option(studentName, id));
					optionsForClass.append("<option value='"+id+"'>" + studentName + "</option>");
				});
				$('#PromotionStudentModal').modal('show');
				/*if(isClick == 'Yes'){
							 $('#id').multiselect({
							     
											      includeSelectAllOption: true,
											      selectAllText: 'Check all!',
											      selectAllValue: 'select-all-value',
											    });
							    
				}*/
				//$("#id").removeAttr("style");
				$('#studentId option').attr('selected', 'selected');
				
				//$('#subjectDiv').html('');
					/*$.ajax({
						type : "POST",
						url : "sendStudentFeeSMS",
						data : {studentArry:selected},
						dataType : "json",
						success : function(response) {
						var	messageForAjaxCall = '<div class="col-sm-4 col-sm-offset-4">'
												+'<div class="form-group">'
												+'<div class="alert alert-success fadeIn animated">Message sent successfully for '+response+' students</div>'
												+'</div></div>';
						$('#messageForAjaxCall').html(messageForAjaxCall);
						setInterval(function(){ $('#messageForAjaxCall').html(''); }, 3000);
							}
						
						
					});*/
					//$('input.checkall').not(this).prop('checked', false);
			}
		}else{
			
			alert("Please select atleast one student")
		}
		
	}
	
	
	
		
		


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
		function searchStudent(){
			searchbtn=123;
			//var studentName = $("#name").val();
			var boardName = $("#boardName").val();
			//var admissionNum = $('#admissionNum').val();
			var medium = $('#medium').val();
			//var caste = $('#caste').val();
			//var email = $('#email').val();
			//var studentName = $('#name').val();
			var className = $('#className').val();
			var section = $('#section').val();
			//var mobile = $("#mobile").val();
			$('#loadAjax').show();
			$.ajax({
				type : "POST",
				url : "getStudetnDetails.json",
				dataType : "json",
				data : "boardName=" + boardName +"&medium="+medium+"&className="+className+"&section="+section,
				success : function(response) {
//	 				 alert(response); 
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
		

	function getBack()
	{
		$('#showData').html('');
		$('#view_list').show();
		$('#view_list1').show();
	}

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
	function classNameFilter(){
		var boardId = $("#boardName").val();
		
		if(boardId == ""){
			boardId = $("#boardId").val();
		}
		if(boardId.length !=0){
		$.ajax({
			type : "POST",
			url : "getClassNameFilter.json",
			data : "boardId=" + boardId,
			dataType : "json",
			async:false,
			success : function(response) {
				 /* alert(response); */  
				
				if(true){
					
					
					var optionsForClass = "";
					optionsForClass = $("#classId").empty();
					
					optionsForClass.append(new Option("-- Choose Class --", ""));
					$.each(response, function(i, tests) {
						var id=tests.id;
						var className=tests.className;
						optionsForClass.append(new Option(className, id));
					});
					$('#classId').trigger("chosen:updated");
				}
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
		
		if(boardId == "" && classId == "" ){
			boardId = $("#boardId").val();
			classId = $("#classId").val();
		}
		if(boardId.length !=0 && classId.length != 0){
		$.ajax({
			type : "POST",
			url : "getSectionFilter.json",
			data : "boardId=" + boardId+"&classId="+classId,
			dataType : "json",
			async:false,
			success : function(response) {
				 /* alert(response); */  
				
				//if($("#boardName").val() == "" &&  $("#className").val() == ""){
				if(true){
					
					var optionsForClass = "";
					optionsForClass = $("#sectionId").empty();
					
					optionsForClass.append(new Option("-- Choose Section --", ""));
					$.each(response, function(i, tests) {
						var id=tests.id;
						var sectionName=tests.sectionName;
						optionsForClass.append(new Option(sectionName, id));
					});
					$('#sectionId').trigger("chosen:updated");
				}
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
		
		if(boardId == "" && classId == "" && sectionId == "" ){
			boardId = $("#boardId").val();
			classId = $("#classId").val();
			sectionId = $("#sectionId").val();
		}
		
		if(boardId.length !=0 && classId.length != 0 &&  sectionId.length != 0){
		$.ajax({
			type : "POST",
			url : "getMediumFilter.json",
			data : "boardId=" + boardId+"&classId="+classId+"&sectionId="+sectionId,
			dataType : "json",
			async:false,
			success : function(response) {
				 /* alert(response); */
				//if($("#boardName").val() == "" &&  $("#className").val() == "" && $("#section").val() ==""){
				if(true){	
					
					var optionsForClass = "";
					optionsForClass = $("#mediumId").empty();
					
					optionsForClass.append(new Option("-- Choose Medium --", ""));
					$.each(response, function(i, tests) {
						var id=tests.id;
						var mediumName=tests.mediumName;
						optionsForClass.append(new Option(mediumName, id));
					});
					$('#mediumId').trigger("chosen:updated");
				}
				
				var optionsForClass = "";
				optionsForClass = $("#medium").empty();
				optionsForClass.append(new Option("-- Choose Medium --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var mediumName=tests.mediumName;
					optionsForClass.append(new Option(mediumName, id));
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
		}
	}

