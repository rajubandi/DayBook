/*$(document).ready(function(){
	
    $("#add-row").click(function(){
    	 var toDayDate = new Date()
    	var yyyy = new Date().getFullYear();
    	 var mm = toDayDate.getMonth()+1;
    	 var dd = toDayDate.getDate();
    	 if (dd < 10) {
    		 dd = "0" + dd;
    	    }
    	    if (mm < 10) {
    	    	mm = "0" + mm;
    	    }
    	    
    	    var formatDate = yyyy +"-"+ mm + "-" + dd;
    	    
        var discription = $("#discription").val();
        var amount = $("#amount").val();
        var markup = "<tr><td>"+formatDate+"</td><td>" + discription + "</td><td>" + amount + "</td></tr>";
        $("table tbody").append(markup);
    }); 
   
    
});*/
$(function(){
	
	$("#dairydate,#from,#to").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-50:+0",
		showButtonPanel : false,
// 		minDate: '-50Y',
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});
	
	
	
	   $(" #submitId").click(function(e){
		   
	   var isValid= false;
	   
	    $("#ledger-form").validate({
	    errorElement: 'span',
	    errorClass: 'has-error',
		rules:
		{
		    discription:{required: true},
		    amount:{required: true},
		    dairydate:{required: true},
		   
	    },
		messages:
		{
		    discription:{required: 'Discription'},
		    amount:{required: 'Amount'},
		    dairydate:{required: 'Select Date'},
	    },
	    errorPlacement: function(error, element){
	      if(element.attr("name") == "discription")
	        error.insertAfter(".discription_error").css("color", "red");
	      else if(element.attr("name") == "amount")
	        error.insertAfter(".amount_error").css("color", "red"); 
	      
	    
	      else
	        error.insertAfter(element);
	      }
    	
	});
	    if ( $("#ledger-form").valid() == true){
	    	
	    	return true;
		}
	    
	   });
	   
	   
	   $("#ledgerBwDateSubmitId").click(function(){
			
			 //Second form Validation
			$("#ledgerBwDate-form").validate({
			    	errorElement : 'span',
					errorClass : 'has-error',
					rules : {
						 from:{required:true},
						 to:{required:true},  
						
					},
					messages : {
						from:{required:'Select Date '},
						to:{required:'Select Date'},
						
					},
					errorPlacement: function(error, element){
					      if(element.attr("name") == "from")
					        error.insertAfter(".from_error").css("color", "red");
					      else if(element.attr("name") == "to")
					        error.insertAfter(".to_error").css("color", "red"); 
					      					    
					      else
					        error.insertAfter(element);
					      }
				    	
				});

			
		    if ( $("#ledgerBwDate-form").valid() == true){
				  
				 
				var  data = $('#ledgerBwDate-form').serialize();
				console.log(data);
				 
				 $.ajax({
						type : "POST",
						url : "dailyExpensesBetweentwoDate.json",
						data : data ,
						async:false,
						success : function(response) {
							displayTableDayWiseExpenses(response);
								
								/*$('#todayFeeCollecitonDivId').hide();
								$('#BetweenTwoDatesListId').show();*/
								
							
						}
						
					});
				
				
			}else{
				
				return false;
			}
		    
		   });	  

	$('#cancel').click(function () {
	   	$('#discription').val("");      //image will be cleared if selected
	  	$("#ledger-form").validate().resetForm();
	    $("#ledger-form").removeClass("has-error");
	    $("#accountHeadId").val("");
	    $('#amount').val("");
	    $('#dairydate').val("");
	    $('#discription').val("");
	    $("#submitId").val("Submit");
	    
	});
	
	$('#cancel2').click(function () {
		window.location.href = '?';
	  	$("#ledgerBwDate-form").validate().resetForm();
	    $("#ledgerBwDate-form").removeClass("has-error");
	    $("#from").val('');
	    $("#to").val('');
	    $("#submitId").val("Submit");
	    
	});
	

});

function displayTable(listOrders) {
			if (listOrders != null) {
				$("#basicExample tr td").remove();
				$("#basicExample td").remove();
				serviceUnitArray = {};
				var TotalExpenses = 0.00;
				$.each(listOrders,function(i, orderObj) {
									
									serviceUnitArray[orderObj.id] = orderObj;
									var id = '"' + orderObj.id + '"';
									TotalExpenses += parseInt(orderObj.amount);
									var tblRow = "<tr align='center' role='row' class='odd'>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.accountHead+"'>"
											+ orderObj.accountHead
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.discription+"'>"
											+ orderObj.discription
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.amount+"' >"
											+ " ₹"+orderObj.amount
											+ "</td>"
											+ "<td>"
	 										+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.id + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteExpense('
											+ orderObj.id + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
									
									//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
								});
				
			/*var	totalAmountRow = "<tr align='center' role='row' class='odd'>"
								+"<td colspan='2' class='hidden-sm hidden-xs' title='Total Amount'><b>Total Amount</b></td>"
								+ "<td colspan='2' class='hidden-sm hidden-xs' title='"+TotalExpenses+"'>"
								+ TotalExpenses
								+ "</td>"
								+"</tr>";
			*/
				$("#ledgerTotalAmount").text("INR ₹"+TotalExpenses);
			//$(totalAmountRow).appendTo("#basicExample1");
			console.log(serviceUnitArray)
			}
		}  
	 	function editPack(id) {
	 		console.log(serviceUnitArray[id]);
			$("#ledger-form").validate().resetForm();
			$("#id").val(serviceUnitArray[id].id);
			
			$("#accountHeadId").val(serviceUnitArray[id].accountHeadId);
			$("#dairydate").val(serviceUnitArray[id].strDate);
			$("#discription").val(serviceUnitArray[id].discription);
			$('#amount').val(serviceUnitArray[id].amount);
			
			$("#submitId").val("Update");
			$(window).scrollTop($('#createLedgerHeading').offset().top);
		} 
	 	
	 	function deleteExpense(id){
				
			
				/* $('input[name=checkboxName]:checked').map(function() {
					studentId.push($(this).val());
				}); */
				var count = 0;
				var checkstr =  confirm('are you sure you want to delete this?');
				if(checkstr == true){
				  // do your code
				  
				  $.ajax({
							type : "POST",
							url : "deleteExpens.json",
							data : "expensId=" + id ,
							async:false,
							success : function(response) {
								
							},
							
							
						});
				  window.location.href = '?';
					
				}else{
				return false;
				}
			}	
	 	
	 	
	/* 	
	 	function displayTableDayWiseExpenses(listOrders) {
			if (listOrders != null) {
				$("#dayWiseExpenses tr td").remove();
				$("#dayWiseExpenses td").remove();
				serviceUnitArray11 = {};
				var TotalExpenses = 0.00;
				$.each(listOrders,function(i, orderObj) {
									
									serviceUnitArray11[orderObj.id] = orderObj;
									var id = '"' + orderObj.id + '"';
									TotalExpenses += parseInt(orderObj.amount);
									var onDate = orderObj.strDate;
									var tblRow = "<tr align='center' role='row' class='odd'>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.strDate+"'>"
											+ '<a style="cursor: pointer;" title="Get Expenses List" data-toggle="modal"  onclick=getExpenses("'+ onDate+ '")>'
											+ '<b>'
											+ orderObj.strDate
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.discription+"' >"
											+ orderObj.discription
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.amount+"' >"
											+ orderObj.amount
											+ "</td>"
											+ "<td>"
	 										+ '<a href="javascript:void(0)" title="Edit" onclick=editPack('
											+ orderObj.id + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)"  title="Delete" onclick=deleteExpense('
											+ orderObj.id + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
											+ '</tr>';
									$(tblRow).appendTo("#dayWiseExpenses");
									
									//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
								});
				
			var	totalAmountRow = "<tr align='center' role='row' class='odd'>"
								+"<td colspan='2'style='text-align:  center;' class='hidden-sm hidden-xs' title='Total Amount'><b>Total Amount</b></td>"
								+ "<td colspan='2' class='hidden-sm hidden-xs' title='"+TotalExpenses+"'>"
								+ TotalExpenses
								+ "</td>"
								+"</tr>";
			
			$(totalAmountRow).appendTo("#dayWiseExpenses");
				
				
				 $("#monthlyExpensesTotal").text(TotalExpenses);
			var mon = listOrders[0].monthName
		    $("#onDateExpensesHeading").text(mon +" Expenses ");

			}
		}  
	 		*/
/*function getExpenses(ondate1){
	
	 $.ajax({
			type : "POST",
			url : "onDateExpensesList.json",
			data : "onDate="+ondate1 ,
			async:false,
			success : function(response) {
				displayTable(response);
					
				$("#onDateExpensesHeading").text(response[0].strDate);
				
					$('#todayFeeCollecitonDivId').hide();
					$('#BetweenTwoDatesListId').show();
					
				
			}
			
		});
	
}	*/

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
		
		
		
		
		
		