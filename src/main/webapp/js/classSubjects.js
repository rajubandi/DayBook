
$( document ).ready(function() {
    $("#fee").val("");

$("#cls-form").validate(
		{
			errorElement: 'span',
		    errorClass: 'has-error',
			rules:
			{
				boardId: {required: true},
			    mediumId: {required: true},
				className: {required: true},
			    section: {required: true},
			    fee: {required: true, number: true},
			},
			messages:
			{
				boardId: {required: 'Choose Board'},
				mediumId: {required: 'Choose Medium'},
				className: {required: 'Choose Class'},
				section: {required: 'Choose Section'},
				fee: {required: 'Fee Amount', number: 'Numeric Characters'},
			},
			errorPlacement: function(error, element)
			{
			      if(element.attr("name") == "className")
			        error.insertAfter(".className_error").css("color", "red");
			      else if(element.attr("name") == "boardId")
			        error.insertAfter(".boardId_error").css("color", "red"); 
			       else if(element.attr("name") == "mediumId")
			        error.insertAfter(".mediumId_error").css("color", "red");
			       else if(element.attr("name") == "section")
			        error.insertAfter(".section_error").css("color", "red");
			       else if(element.attr("name") == "fee")
				        error.insertAfter(".fee_error").css("color", "red");
			      else
			        error.insertAfter(element);
			}	
		});

			  $('#cancel').click(function () {
			    $("#cls-form").validate().resetForm();
			    $("#cls-form").removeClass("has-error");
			    $("#id").val(0);
			    $("#boardId").val('');
			    $("#classId").val('');
			    $("#subjectId").val('');
			    $("#submitId").val("Submit");
			    $("#cls-form").addClass('form-horizontal');
			    $("#headId").text("Class Subjects");
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
								serviceUnitArray[orderObj.id] = orderObj;
								var tblRow = "<tr align='center' role='row' class='odd'>" 
										+ "<td  title='"+orderObj.boardName+"'>"
										+ orderObj.boardName
										+ "</td>"
										+ "<td  title='"+orderObj.className+"'>"
										+ orderObj.className
										+ "</td>"
										+ "<td  title='"+orderObj.subjectName+"'>"
										+ orderObj.subjectName
										+ "</td>"
										+ "<td>"
										+ '<a href="javascript:void(0)" onclick=editPack('
										+ orderObj.id+ ')'
										+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
										+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteClass('
										+ orderObj.id+ ')'
										+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
									
										+ '</tr>';
								$(tblRow).appendTo("#basicExample");
							});
	}
	function editPack(id) {
		$("#id").val(id);
		 $("#cls-form").validate().resetForm();
		$('#boardId').val(serviceUnitArray[id].boardId);
		$('#boardId').trigger("chosen:updated");
		classNameFilter();
		$('#classId').val(serviceUnitArray[id].classId);
		$('#classId').trigger("chosen:updated");
		$('#subjectId').val(serviceUnitArray[id].subjectId);
		$('#subjectId').trigger("chosen:updated");
		$("#submitId").val("Update");
		$("#headId").text("Edit Class");
	}
	
	
	function deleteClass(id){
		var count = 0;
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		  
		  $.ajax({
					type : "POST",
					url : "deleteClassSubject.json",
					data : "id=" + id ,
					success : function(response) {
						displayTable(response);
//						$('#loadAjax').hide();
//						window.location.href='HomeControl1';
					},
					error : function(e) {
					}
				});
		
			
		}else{
		return false;
		}
	}
	
	
	function classNameFilter(){
		var boardId = $("#boardId").val();
		if(boardId.length !=0){
			$('#loadAjax').show();
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
