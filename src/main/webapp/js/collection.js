$(function(){
	$("#cls-form").validate(
			{
				errorElement: 'span',
			    errorClass: 'has-error',
				rules:
				{
					date: {required: true},
					client: {required: true},
					description: {required: true},
					fullamount: {required: true},
					paidamount: {required: true},						
				},
				messages:
				{
					date: {required: 'Date'},
					client: {required: 'Client'},
					description: {required: 'Description'},
					fullamount: {required: 'FullAmount'},
					paidamount: {required: 'PaidAmount'},	
					
				},
				errorPlacement: function(error, element)
				{
					if(element.attr("name") == "date")
				        error.insertAfter(".date_error").css("color", "red");
				      else if(element.attr("name") == "client")
				        error.insertAfter(".client_error").css("color", "red");
				      else if(element.attr("name") == "description")
					        error.insertAfter(".description_error").css("color", "red"); 
				      else if(element.attr("name") == "fullamount")
					        error.insertAfter(".fullamount_error").css("color", "red");		
				      else if(element.attr("name") == "paidamount")
					        error.insertAfter(".paidamount_error").css("color", "red");					     	
				      else
				        error.insertAfter(element);
				}	
			});

				  $('#cancel').click(function () {
				    $("#cls-form").validate().resetForm();
				    $("#cls-form").removeClass("has-error");
				    $("#id").val(0);
				    $("#date").val('');
				    $("#client").val('');
				    $("#description").val('');
				    $("#fullamount").val('');
				    $("#paidamount").val('');
				    $("#duedate").val('');
				    $("#submitId").val("Submit");
				    $("#headId").text("Account Creation");
				    $("#cls-form").addClass('form-horizontal');
				  });

});

/*$(function(){
	
	$("#date").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-17:+0",
		showButtonPanel : false,
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});
	
});*/

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

											+ "<td class='' title='"+orderObj.date+"' >"
											+ orderObj.date
											+ "</td>"
											+ "<td class='' title='"+orderObj.client+"' >"
											+ orderObj.client
											+ "</td>"
											+ "<td class='' title='"+orderObj.description+"' >"
											+ orderObj.description
											+ "</td>"
											+ "<td class='' title='"+orderObj.fullamount+"' >"
											+ orderObj.fullamount
											+ "</td>"
											+ "<td class='' title='"+orderObj.paidamount+"' >"
											+ orderObj.paidamount
											+ "</td>"
											+ "<td class='' title='"+orderObj.dueamount+"' >"
											+ orderObj.dueamount
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
			$('#date').val(serviceUnitArray[ids].date);
			$('#client').val(serviceUnitArray[ids].client);
			$('#description').val(serviceUnitArray[ids].description);
			$('#fullamount').val(serviceUnitArray[ids].fullamount);
			$('#paidamount').val(serviceUnitArray[ids].paidamount);
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
						url : "deleteCollection.json",
						data : "id=" + id ,
						success : function(response) {
							displayTable(response);
							window.location.href='collections';
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
		
		function checkAmount(theForm) {		
			
			if(theForm.fullamount.value != theForm.paidamount.value){
				document.getElementById('duedate').style.display="block" ;
		        return false;
		    }
		    return true;
		}
		