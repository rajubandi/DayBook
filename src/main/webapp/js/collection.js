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
					//fullamount: {required: true},
					paidamount: {required: true},						
				},
				messages:
				{
					date: {required: 'Date'},
					client: {required: 'Client'},
					description: {required: 'Description'},
					//fullamount: {required: 'FullAmount'},
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
				      /*else if(element.attr("name") == "fullamount")
					        error.insertAfter(".fullamount_error").css("color", "red");*/		
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
				    $("#client").prop('selectedIndex','');
				    $("#description").val('');
				    //$("#fullamount").val('');
				    $("#paidamount").val('');
				    $("#duedate").val('');
				    $("#submitId").val("Submit");
				    $("#headId").text("Collections");
				    $("#cls-form").addClass('form-horizontal');
				    document.getElementById('showamount').style.display="none" ;
				  });

});

$(function(){
	
	$("#date").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-17:+0",
		showButtonPanel : false,
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'			
	});
	
	
	// USED URL: https://stackoverflow.com/questions/4419804/restrict-date-in-jquery-datepicker-based-on-another-datepicker-or-textbox
	$("#duedate").datepicker({		        
		  onSelect: function(dateText, inst){
		     $("#duedate").datepicker("option","minDate",
		     $("#date").datepicker("getDate"));
		  }
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
		
		/*var showAmountValue;
		
		function showAmountFunc(showamt) {
			
			showAmountValue = showamt;
			//showAmountValue = "gg";
			
		}*/
		
		var gg ;		
		function searchData() {		
			
			var clientid = $("#client").val();
				$.ajax({
					type : "POST",
					url : "getAmountData.json",
					data : "clientid=" + clientid,
					async:false,
					success : function(response) {	
						
						gg = response;						
						//showAmountFunc(response)						
					}
				});
				
				var str = gg;
				
				var damont = getSecondPart(gg);			
				
		        if(damont == 0 ){
		        	document.getElementById("paidamount").style.display = "none";
		        	document.getElementById("paidamount").value = 0;
		        	document.getElementById("paidamntLabel").style.display = "none";		        	
		        
		        }else{
		        	$("#paidamount").val('');
		        	document.getElementById("paidamntLabel").style.display = "block";
		        	document.getElementById("paidamount").style.display = "block";		        	
		        }
				var patt = new RegExp("null");
				var res = patt.test(str);				
				
				if (res==true) {
					document.getElementById('showamount').style.display="block" ;
					document.getElementById("showamount").style.color = "blue";
					document.getElementById('showamount').innerHTML = "";//"Till Now, He Not Paid ";
				} else {
					
					document.getElementById('showamount').style.display="block" ;				
					document.getElementById("showamount").style.color = "blue";				
					document.getElementById('showamount').innerHTML = gg;
				}	
				
				if (clientid=='clnt') {
					document.getElementById('showamount').style.display="none" ;
				
				}
		}
		var dueAmt;
		var dueAmtInt; 
function checkDueAmount() {		
			
			var clientid = $("#client").val();
			var paidamount = $("#paidamount").val();
			
			// var jsonObjects = [{cid:clientid, pmt:paidamount}];
			
				$.ajax({
					type : "POST",
					url : "getDueAmount.json",
					data : {"paidamount":paidamount, "clientid":clientid}, 
					async:false,
					success : function(response) {	
						
						dueAmt = response;	
						/*dueAmtInt = parseInt(dueAmt);*/				
						
					}
				});
				
				dueAmtInt = Number(dueAmt); 
				document.getElementById('showamount').innerHTML = dueAmtInt;
				
				var valueDate = document.getElementById('duedate').value;			
			    
			    if ((dueAmtInt == 0)) {
			    	  //  block of code to be executed if condition1 is true
			    	document.getElementById("duedate").value = "19-January-2019";
			    	document.getElementById("showamount").style.display = "none";
			    	return true;
			    	} 
			        else if (((dueAmtInt != 0))&&(!Date.parse(valueDate))) {
			    	  //  block of code to be executed if the condition1 is false and condition2 is true
			    		document.getElementById('duedate').style.display="block" ;
			    		document.getElementById("endTimeLabel").style.display = 'block';
			    		document.getElementById("showamount").style.display = "none";
			    		return false;
			    	} 
			    	else if (((dueAmtInt != 0))&&(Date.parse(valueDate))) {
				    	  //  block of code to be executed if the condition1 is false and condition2 is false and condition3 is true			    		
				    		return true;
				    	} 
			    	else {
			    	  //  block of code to be executed if the condition1 is false and condition2 is false and condition3 is false
			    	}			
				
				
		}

// Used URL: https://stackoverflow.com/questions/21203729/regular-expression-in-javascript-to-allow-only-numbers-with-optional-2-decimals
function validatenumber(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /^[0-9]*$/;    // Valid characters: only Numbers. 
	  if( !regex.test(key) ) {
	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}
		
		function editPack(id1) {
			var ids= id1;
			$("#cls-form").validate().resetForm();
			$("#id").val(serviceUnitArray[ids].accountId);
			$('#date').val(serviceUnitArray[ids].date);
			$('#client').val(serviceUnitArray[ids].client);
			$('#description').val(serviceUnitArray[ids].description);
			//$('#fullamount').val(serviceUnitArray[ids].fullamount);
			$('#paidamount').val(serviceUnitArray[ids].paidamount);
			$("#submitId").val("Update");
			$("#headId").text("Edit Collection Details");
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
		
		// function you can use:
		function getSecondPart(str) {
		    return str.split(':')[3];
		}
		
		// use the function:
		
		
		function CheckNo(sender){
		    if(!isNaN(sender.value)){
		    	
		    	var damnt = getSecondPart(gg);
		        if(sender.value > damnt )
		            sender.value = damnt;
		        
		    }else{
		          sender.value = 0;
		    }
		}
		
		
		function checkAmount(theForm) {				
			
			var valueDate = document.getElementById('duedate').value;			
		    
		    if (theForm.fullamount.value == theForm.paidamount.value) {
		    	  //  block of code to be executed if condition1 is true
		    	document.getElementById("duedate").value = "19-January-2019";
		    	return true;
		    	} 
		        else if ((theForm.fullamount.value != theForm.paidamount.value)&&(!Date.parse(valueDate))) {
		    	  //  block of code to be executed if the condition1 is false and condition2 is true
		    		document.getElementById('duedate').style.display="block" ;
		    		document.getElementById("endTimeLabel").style.display = 'block';
		    		return false;
		    	} 
		    	else if ((theForm.fullamount.value != theForm.paidamount.value)&&(Date.parse(valueDate))) {
			    	  //  block of code to be executed if the condition1 is false and condition2 is false and condition3 is true			    		
			    		return true;
			    	} 
		    	else {
		    	  //  block of code to be executed if the condition1 is false and condition2 is false and condition3 is false
		    	}		    
		    
		}
		
		// USED LINK FOR VALIDATING EMPTY INPUT DATE: https://stackoverflow.com/questions/19110663/how-to-check-the-empty-value-of-a-input-type-date-in-chrome 
		// USED LINK FOR ONSUBMIT IN SPRING FORM: 
		// 1. https://stackoverflow.com/questions/26376369/spring-form-submit-using-java-script
		// 2. https://stackoverflow.com/questions/16262797/html-form-action-and-onsubmit-issues
		// USED LINK FOR COMPARE TWO INPUT FIELDS IN JAVASCRIPT:  https://lab.artlung.com/compare-fields/