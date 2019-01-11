$(function(){
	$("#cls-form").validate(
			{
				errorElement: 'span',
			    errorClass: 'has-error',
				rules:
				{
					routeName: {required: true},
					//busfee: {required: true, number: true}
				},
				messages:
				{
					routeName: {required: 'Route Name'},
					//busFee: {required: 'Fees', number : 'Plese enter numbers only'}
				},
				errorPlacement: function(error, element)
				{
				      if(element.attr("name") == "name")
				        error.insertAfter(".name_error").css("color", "red");
				      else
				        error.insertAfter(element);
				}	
			});

	$('#submitId').click(function () {
		if($("#cls-form").valid() == true) {
			$("#submitId").attr("disabled",true);
			$("#submitId").val("Please wait...");
			$("#cls-form").submit();											
			event.preventDefault();
		}else {
			
			 $("#routeName").val('');
			return false;
			event.preventDefault();
			
		}
		});
				  $('#cancel').click(function () {
				    $("#cls-form").validate().resetForm();
				    $("#cls-form").removeClass("has-error");
				    $("#id").val(0);
				    $("#routeName").val('');
				    //$("#busFee").val('');
				    $("#submitId").val("Submit");
				    $("#headId").text("Route Name");
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
									serviceUnitArray[orderObj.id] = orderObj;
									var tblRow = "<tr align='center' role='row' class='odd'>"  

											+ "<td class='' title='"+orderObj.routeName+"' >"
											+ orderObj.routeName
											+ "</td>"
											/*+ "<td class='' title='"+orderObj.busFee+"' >"
											+ orderObj.busFee
											+ " /- </td>"*/
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.id + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteBustRoute('
											+ orderObj.id + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
										
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
								});
		}
		function editPack(id1) {
			var ids= id1;
			$("#cls-form").validate().resetForm();
			$("#id").val(serviceUnitArray[ids].id);
			$('#routeName').val(serviceUnitArray[ids].routeName);
			//$('#busFee').val(serviceUnitArray[ids].busFee);
			$("#submitId").val("Update");
			//$("#headId").text("Route Name");
		}
		
		
		function deleteBustRoute(id){
			var id = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
			  
			  $.ajax({
						type : "POST",
						url : "deleteBusRoute.json",
						data : "id=" + id ,
						success : function(response) {
							 /*$('#busrouteDeletemsg').html("Successfully Route Name is Deleted").fadeIn('slow');
						     //$('#msg').html("data insert successfully").fadeIn('slow') //also show a success message 
						     $('#busrouteDeletemsg').delay(5000).fadeOut('slow');
							*/
							displayTable(response);
							window.location.href='?';
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
		