$(function(){
	$("#cls-form").validate(
			{
				errorElement: 'span',
			    errorClass: 'has-error',
				rules:
				{
					clientName: {required: true},
					phoneNumber: {required: true},
					mail: {required: true},
					address: {required: true},
				},
				messages:
				{
					clientName: {required: 'clientName'},
					phoneNumber: {required: 'phoneNumber'},
					mail: {required: 'mail'},
					address: {required: 'address'},
				},
				errorPlacement: function(error, element)
				{
					if(element.attr("name") == "clientName")
				        error.insertAfter(".clientName_error").css("color", "red");
				      else if(element.attr("name") == "phoneNumber")
				        error.insertAfter(".phoneNumber_error").css("color", "red");
				      else if(element.attr("name") == "mail")
					        error.insertAfter(".mail_error").css("color", "red"); 
				      else if(element.attr("name") == "address")
					        error.insertAfter(".address_error").css("color", "red");					      
				      else
				        error.insertAfter(element);
				}	
			});

				  $('#cancel').click(function () {
				    $("#cls-form").validate().resetForm();
				    $("#cls-form").removeClass("has-error");
				    $("#id").val(0);
				    $("#clientName").val('');
				    $("#phoneNumber").val('');
				    $("#mail").val('');
				    $("#address").val('');
				    $("#submitId").val("Submit");
				    $("#headId").text("Client Account Creation");
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
									serviceUnitArray[orderObj.accountId] = orderObj;
									var tblRow = "<tr align='center' role='row' class='odd'>"  

											+ "<td class='' title='"+orderObj.clientName+"' >"
											+ orderObj.clientName
											+ "</td>"
											+ "<td class='' title='"+orderObj.phoneNumber+"' >"
											+ orderObj.phoneNumber
											+ "</td>"
											+ "<td class='' title='"+orderObj.mail+"' >"
											+ orderObj.mail
											+ "</td>"
											+ "<td class='' title='"+orderObj.address+"' >"
											+ orderObj.address
											+ "</td>"
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.accountId + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteAccount('
											+ orderObj.accountId + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
										
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
								});
		}
		
		function editPack(id1) {
			var ids= id1;
			$("#cls-form").validate().resetForm();
			$("#id").val(serviceUnitArray[ids].accountId);
			$('#clientName').val(serviceUnitArray[ids].clientName);
			$('#phoneNumber').val(serviceUnitArray[ids].phoneNumber);
			$('#mail').val(serviceUnitArray[ids].mail);
			$('#address').val(serviceUnitArray[ids].address);
			$("#submitId").val("Update");
			$("#headId").text("Edit AccountHead");
		}
		
		
		function deleteAccount(id){
			var id = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
			  
			  $.ajax({
						type : "POST",
						url : "deleteClient.json",
						data : "id=" + id ,
						success : function(response) {
							displayTable(response);
							window.location.href='addClient';
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
		