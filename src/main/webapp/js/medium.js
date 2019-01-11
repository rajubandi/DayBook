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
					name: {required: 'Medium Name'},
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
				    $("#headId").text("Medium Creation");
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
									serviceUnitArray[orderObj.mediumId] = orderObj;
									var tblRow = "<tr align='center' role='row' class='odd'>"  

											+ "<td class='' title='"+orderObj.name+"' >"
											+ orderObj.name
											+ "</td>"
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.mediumId + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteMedium('
											+ orderObj.mediumId + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
										
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
								});
		}
		function editPack(id1) {
			var ids= id1;
			$("#id").val(serviceUnitArray[ids].mediumId);
			   $("#cls-form").validate().resetForm();
			$('#name').val(serviceUnitArray[ids].name);
			$("#submitId").val("Update");
			$("#headId").text("Edit Medium");
		}
		
		
		function deleteMedium(id){
			var id = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
			  
			  $.ajax({
						type : "POST",
						url : "deleteMedium.json",
						data : "mediumId=" + id ,
						success : function(response) {
							displayTable(response);
							window.location.href='mediumHome';
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
		