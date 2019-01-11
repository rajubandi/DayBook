$( document ).ready(function() {
    $("#fee").val("");

$("#cls-form").validate(
		{
			errorElement: 'span',
		    errorClass: 'has-error',
			rules:
			{
				boardId: {required: true},
				classId: {required: true},
			    section: {required: true},
			},
			messages:
			{
				boardId: {required: 'Choose Board'},
				classId: {required: 'Choose Class'},
				section: {required: ' Section Name'},
			},
			errorPlacement: function(error, element)
			{
			      if(element.attr("name") == "classId")
			        error.insertAfter(".classId_error").css("color", "red");
			      else if(element.attr("name") == "boardId")
			        error.insertAfter(".boardId_error").css("color", "red"); 
			       else if(element.attr("name") == "section")
			        error.insertAfter(".section_error").css("color", "red");
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
			    $("#section").val('');
				$("#submitId").val("Submit");
				$("#headId").text("Section Creation");
			    $("#cls-form").addClass('form-horizontal');
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
								serviceUnitArray[orderObj.sectionId] = orderObj;
								var id = '"' + orderObj.sectionId + '"';
								var tblRow = "<tr align='center' role='row' class='odd'>" + "<td'><a  id='"
										+ orderObj.sectionId
										+ "' href='javascript:forOrderDetails("
										+ id
										+ ")' style='font-color:red'>"
										+ orderObj.orderId
										+ "</a></td>"
										+ "<td  title='"+orderObj.boardName+"'>"
										+ orderObj.boardName
										+ "</td>"
										+ "<td title='"+orderObj.className+"'>"
										+ orderObj.className
										+ "</td>"
										+ "<td title='"+orderObj.sectionName+"' >"
										+ orderObj.sectionName
										+ "<td>"
										+ '<a href="javascript:void(0)" onclick=editPack('
										+ orderObj.sectionId + ')'
										+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
										+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteSection('
										+ orderObj.sectionId + ')'
										+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
									
										+ '</tr>';
								$(tblRow).appendTo("#basicExample");
							});
	}
	function editPack(id) {
		var transactionId = serviceUnitArray[id].classId;
		  $("#cls-form").validate().resetForm();
		$("#id").val(id)
		$('#boardId').val(serviceUnitArray[id].boardId);
		$('#boardId').trigger("chosen:updated");
		classNameFilter();
		$('#classId').val(serviceUnitArray[id].classId);
		$('#classId').trigger("chosen:updated");
		$('#section').val(serviceUnitArray[id].sectionName);
		$("#submitId").val("Update");
		$("#headId").text("Edit Section");
	}
	
	
	function classNameFilter(){
		var boardId = $("#boardId").val();
		if(boardId.length !=0){
			$('#loadAjax').show();
		$.ajax({
			type : "POST",
			url : "getClassNameViaBoardName.json",
			data : "boardId=" + boardId,
			dataType : "json",
			async:false,
			success : function(response) {
//				  alert(response);   
				var optionsForClass = "";
				optionsForClass = $("#classId").empty();
				optionsForClass.append(new Option("-- Choose Class/Branch --", ""));
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
	
	function deleteSection(id){
		var sectionId = id;
		var count = 0;
		var checkstr =  confirm('Are you sure you want to delete this?');
		if(checkstr == true){
		  // do your code
//			$('#loadAjax').show();
		  
		  $.ajax({
					type : "POST",
					url : "deleteSection.json",
					data : "sectionId=" + sectionId ,
					success : function(response) {
						displayTable(response);
//						$('#loadAjax').hide();
						window.location.href='sectionHome';
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
