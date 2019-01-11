$(function(){
	$("#cls-form").validate(
			{
				errorElement: 'span',
			    errorClass: 'has-error',
				rules:
				{
					name: {required: true},
				},
				messages:
				{
					name: {required: 'Board Name'},
				},
				errorPlacement: function(error, element)
				{
				      if(element.attr("name") == "name")
				        error.insertAfter(".name_error").css("color", "red");
				      else
				        error.insertAfter(element);
				}	
			});

				  $('#cancel').click(function () {
				    $("#cls-form").validate().resetForm();
				    $("#cls-form").removeClass("has-error");
				    $("#id").val(0);
				    $("#name").val('');
				    $("#submitId").val("Submit");
				    $("#headId").text("Board Creation");
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
									serviceUnitArray[orderObj.boardId] = orderObj;
									var tblRow = "<tr align='center' role='row' class='odd'>"  

											+ "<td class='' title='"+orderObj.name+"' >"
											+ orderObj.name
											+ "</td>"
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.boardId + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteBoard('
											+ orderObj.boardId + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
										
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
								});
		}
		function editPack(id1) {
			var ids= id1;
			$("#cls-form").validate().resetForm();
			$("#id").val(serviceUnitArray[ids].boardId);
			$('#name').val(serviceUnitArray[ids].name);
			$("#submitId").val("Update");
			$("#headId").text("Edit Board");
		}
		
		
		function deleteBoard(id){
			var id = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
			  
			  $.ajax({
						type : "POST",
						url : "deleteBoard.json",
						data : "id=" + id ,
						success : function(response) {
							displayTable(response);
							window.location.href='boardHome';
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
		