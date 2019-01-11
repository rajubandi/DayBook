$(function(){
	$("#cls-form").validate(
			{
				errorElement: 'span',
			    errorClass: 'has-error',
				rules:
				{
					examType: {required: true},
				},
				messages:
				{
					examType: {required: 'Please Enter Exam Type Name'},
				},
				errorPlacement: function(error, element)
				{
				      if(element.attr("name") == "examType1")
				        error.insertAfter(".name_error").css("color", "red");
				      else
				        error.insertAfter(element);
				}	
			});

				  $('#cancel').click(function () {
				    $("#cls-form").validate().resetForm();
				    $("#cls-form").removeClass("has-error");
				    $("#name").val('');
				    $("#cls-form").addClass('form-horizontal');
				  });

});

		function displayTable(listOrders) {
				$("#basicExample tr td").remove();
				$("#basicExample td").remove();
				serviceUnitArray = {};
				console.log(listOrders);
				$.each(listOrders, function(i, orderObj) {
									serviceUnitArray[orderObj.id] = orderObj;
									var tblRow = "<tr align='center' role='row' class='odd'>"  
											+ "<td class='' title='"+orderObj.examType+"' >"
											+ orderObj.examType
											+ "</td>"
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.id + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteClass('
											+ orderObj.id + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
										
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
								});
		}
		function editPack(id1) {
			var ids= id1;
			$("#id").val(serviceUnitArray[ids].id);
			$('#examType').val(serviceUnitArray[ids].examType);
			console.log($('#examType').val());
			$("#submitId").val("Update");
			$("#headId").text("Edit ExamType");
		}
		
		
		function deleteClass(id){
			var id = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
			  
			  $.ajax({
						type : "POST",
						url : "deleteExam",
						data : "id=" + id ,
						success : function(response) {
							var resJson=JSON.parse(response);
							displayTable(resJson);
							
							//window.location.href='examType';
						},
						error : function(e) {
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
		